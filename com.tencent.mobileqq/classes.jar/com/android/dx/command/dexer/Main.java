package com.android.dx.command.dexer;

import com.android.dex.Dex;
import com.android.dex.DexException;
import com.android.dx.cf.direct.ClassPathOpener;
import com.android.dx.cf.direct.ClassPathOpener.FileNameFilter;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.command.DxConsole;
import com.android.dx.dex.cf.CfOptions;
import com.android.dx.dex.cf.CfTranslator;
import com.android.dx.dex.cf.CodeStatistics;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.dex.file.Statistics;
import com.android.dx.merge.CollisionPolicy;
import com.android.dx.merge.DexMerger;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;

public class Main
{
  private static final Attributes.Name CREATED_BY;
  private static final String DEX_EXTENSION = ".dex";
  private static final String DEX_PREFIX = "classes";
  private static final String IN_RE_CORE_CLASSES = "Ill-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n";
  private static final String[] JAVAX_CORE;
  private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
  private static final int MAX_FIELD_ADDED_DURING_DEX_CREATION = 9;
  private static final int MAX_METHOD_ADDED_DURING_DEX_CREATION = 2;
  private static List<Future<Boolean>> addToDexFutures;
  private static volatile boolean anyFilesProcessed;
  private static Main.Arguments args;
  private static ExecutorService classDefItemConsumer;
  private static ExecutorService classTranslatorPool;
  private static Set<String> classesInMainDex;
  private static ExecutorService dexOutPool;
  private static List<byte[]> dexOutputArrays;
  private static List<Future<byte[]>> dexOutputFutures;
  private static Object dexRotationLock;
  private static AtomicInteger errors;
  private static OutputStreamWriter humanOutWriter;
  private static final List<byte[]> libraryDexBuffers;
  private static int maxFieldIdsInProcess;
  private static int maxMethodIdsInProcess;
  private static long minimumFileAge;
  private static DexFile outputDex;
  private static TreeMap<String, byte[]> outputResources;
  
  static
  {
    if (!Main.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CREATED_BY = new Attributes.Name("Created-By");
      JAVAX_CORE = new String[] { "accessibility", "crypto", "imageio", "management", "naming", "net", "print", "rmi", "security", "sip", "sound", "sql", "swing", "transaction", "xml" };
      errors = new AtomicInteger(0);
      libraryDexBuffers = new ArrayList();
      addToDexFutures = new ArrayList();
      dexOutputFutures = new ArrayList();
      dexRotationLock = new Object();
      maxMethodIdsInProcess = 0;
      maxFieldIdsInProcess = 0;
      minimumFileAge = 0L;
      classesInMainDex = null;
      dexOutputArrays = new ArrayList();
      humanOutWriter = null;
      return;
    }
  }
  
  private static boolean addClassToDex(ClassDefItem paramClassDefItem)
  {
    synchronized (outputDex)
    {
      outputDex.add(paramClassDefItem);
      return true;
    }
  }
  
  private static void checkClassName(String paramString)
  {
    int j = 1;
    int i;
    if (paramString.startsWith("java/")) {
      i = j;
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (paramString.startsWith("javax/"))
        {
          int k = paramString.indexOf('/', 6);
          i = j;
          if (k == -1) {
            continue;
          }
          String str = paramString.substring(6, k);
          i = j;
          if (Arrays.binarySearch(JAVAX_CORE, str) >= 0) {
            continue;
          }
          i = 0;
        }
      }
      else
      {
        DxConsole.err.println("\ntrouble processing \"" + paramString + "\":\n\n" + "Ill-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n");
        errors.incrementAndGet();
        throw new Main.StopProcessing(null);
      }
      i = 0;
    }
  }
  
  private static void closeOutput(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {}
    do
    {
      return;
      paramOutputStream.flush();
    } while (paramOutputStream == System.out);
    paramOutputStream.close();
  }
  
  private static void createDexFile()
  {
    outputDex = new DexFile(args.dexOptions);
    if (args.dumpWidth != 0) {
      outputDex.setDumpWidth(args.dumpWidth);
    }
  }
  
  /* Error */
  private static boolean createJar(String paramString)
  {
    // Byte code:
    //   0: invokestatic 322	com/android/dx/command/dexer/Main:makeManifest	()Ljava/util/jar/Manifest;
    //   3: astore_2
    //   4: aload_0
    //   5: invokestatic 326	com/android/dx/command/dexer/Main:openOutput	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   8: astore_0
    //   9: new 328	java/util/jar/JarOutputStream
    //   12: dup
    //   13: aload_0
    //   14: aload_2
    //   15: invokespecial 331	java/util/jar/JarOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/jar/Manifest;)V
    //   18: astore_2
    //   19: getstatic 333	com/android/dx/command/dexer/Main:outputResources	Ljava/util/TreeMap;
    //   22: invokevirtual 338	java/util/TreeMap:entrySet	()Ljava/util/Set;
    //   25: invokeinterface 344 1 0
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface 349 1 0
    //   37: ifeq +174 -> 211
    //   40: aload_3
    //   41: invokeinterface 352 1 0
    //   46: checkcast 354	java/util/Map$Entry
    //   49: astore 5
    //   51: aload 5
    //   53: invokeinterface 357 1 0
    //   58: checkcast 83	java/lang/String
    //   61: astore 4
    //   63: aload 5
    //   65: invokeinterface 360 1 0
    //   70: checkcast 362	[B
    //   73: astore 5
    //   75: new 364	java/util/jar/JarEntry
    //   78: dup
    //   79: aload 4
    //   81: invokespecial 365	java/util/jar/JarEntry:<init>	(Ljava/lang/String;)V
    //   84: astore 6
    //   86: aload 5
    //   88: arraylength
    //   89: istore_1
    //   90: getstatic 164	com/android/dx/command/dexer/Main:args	Lcom/android/dx/command/dexer/Main$Arguments;
    //   93: getfield 368	com/android/dx/command/dexer/Main$Arguments:verbose	Z
    //   96: ifeq +46 -> 142
    //   99: getstatic 369	com/android/dx/command/DxConsole:out	Ljava/io/PrintStream;
    //   102: new 258	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 371
    //   112: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 373
    //   123: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload_1
    //   127: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 378
    //   133: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokevirtual 276	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   142: aload 6
    //   144: iload_1
    //   145: i2l
    //   146: invokevirtual 382	java/util/jar/JarEntry:setSize	(J)V
    //   149: aload_2
    //   150: aload 6
    //   152: invokevirtual 386	java/util/jar/JarOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   155: aload_2
    //   156: aload 5
    //   158: invokevirtual 390	java/util/jar/JarOutputStream:write	([B)V
    //   161: aload_2
    //   162: invokevirtual 393	java/util/jar/JarOutputStream:closeEntry	()V
    //   165: goto -134 -> 31
    //   168: astore_3
    //   169: aload_2
    //   170: invokevirtual 396	java/util/jar/JarOutputStream:finish	()V
    //   173: aload_2
    //   174: invokevirtual 397	java/util/jar/JarOutputStream:flush	()V
    //   177: aload_0
    //   178: invokestatic 399	com/android/dx/command/dexer/Main:closeOutput	(Ljava/io/OutputStream;)V
    //   181: aload_3
    //   182: athrow
    //   183: astore_0
    //   184: getstatic 164	com/android/dx/command/dexer/Main:args	Lcom/android/dx/command/dexer/Main$Arguments;
    //   187: getfield 402	com/android/dx/command/dexer/Main$Arguments:debug	Z
    //   190: ifeq +35 -> 225
    //   193: getstatic 256	com/android/dx/command/DxConsole:err	Ljava/io/PrintStream;
    //   196: ldc_w 404
    //   199: invokevirtual 276	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: getstatic 256	com/android/dx/command/DxConsole:err	Ljava/io/PrintStream;
    //   206: invokevirtual 408	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   209: iconst_0
    //   210: ireturn
    //   211: aload_2
    //   212: invokevirtual 396	java/util/jar/JarOutputStream:finish	()V
    //   215: aload_2
    //   216: invokevirtual 397	java/util/jar/JarOutputStream:flush	()V
    //   219: aload_0
    //   220: invokestatic 399	com/android/dx/command/dexer/Main:closeOutput	(Ljava/io/OutputStream;)V
    //   223: iconst_1
    //   224: ireturn
    //   225: getstatic 256	com/android/dx/command/DxConsole:err	Ljava/io/PrintStream;
    //   228: new 258	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 410
    //   238: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: invokevirtual 413	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   245: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokevirtual 276	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   254: goto -45 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   89	56	1	i	int
    //   3	213	2	localObject1	Object
    //   30	11	3	localIterator	Iterator
    //   168	14	3	localObject2	Object
    //   61	55	4	str	String
    //   49	108	5	localObject3	Object
    //   84	67	6	localJarEntry	java.util.jar.JarEntry
    // Exception table:
    //   from	to	target	type
    //   19	31	168	finally
    //   31	142	168	finally
    //   142	165	168	finally
    //   0	19	183	java/lang/Exception
    //   169	183	183	java/lang/Exception
    //   211	223	183	java/lang/Exception
  }
  
  private static void dumpMethod(DexFile paramDexFile, String paramString, OutputStreamWriter paramOutputStreamWriter)
  {
    boolean bool = paramString.endsWith("*");
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1))
    {
      DxConsole.err.println("bogus fully-qualified method name: " + paramString);
      return;
    }
    Object localObject2 = paramString.substring(0, i).replace('.', '/');
    Object localObject1 = paramString.substring(i + 1);
    ClassDefItem localClassDefItem = paramDexFile.getClassOrNull((String)localObject2);
    if (localClassDefItem == null)
    {
      DxConsole.err.println("no such class: " + (String)localObject2);
      return;
    }
    if (bool) {}
    for (paramDexFile = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);; paramDexFile = (DexFile)localObject1)
    {
      localObject2 = localClassDefItem.getMethods();
      localObject1 = new TreeMap();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        EncodedMethod localEncodedMethod = (EncodedMethod)((Iterator)localObject2).next();
        String str = localEncodedMethod.getName().getString();
        if (((bool) && (str.startsWith(paramDexFile))) || ((!bool) && (str.equals(paramDexFile)))) {
          ((TreeMap)localObject1).put(localEncodedMethod.getRef().getNat(), localEncodedMethod);
        }
      }
      if (((TreeMap)localObject1).size() == 0)
      {
        DxConsole.err.println("no such method: " + paramString);
        return;
      }
      paramDexFile = new PrintWriter(paramOutputStreamWriter);
      paramString = ((TreeMap)localObject1).values().iterator();
      while (paramString.hasNext())
      {
        paramOutputStreamWriter = (EncodedMethod)paramString.next();
        paramOutputStreamWriter.debugPrint(paramDexFile, args.verboseDump);
        localObject1 = localClassDefItem.getSourceFile();
        if (localObject1 != null) {
          paramDexFile.println("  source file: " + ((CstString)localObject1).toQuoted());
        }
        localObject1 = localClassDefItem.getMethodAnnotations(paramOutputStreamWriter.getRef());
        paramOutputStreamWriter = localClassDefItem.getParameterAnnotations(paramOutputStreamWriter.getRef());
        if (localObject1 != null)
        {
          paramDexFile.println("  method annotations:");
          localObject1 = ((Annotations)localObject1).getAnnotations().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Annotation)((Iterator)localObject1).next();
            paramDexFile.println("    " + localObject2);
          }
        }
        if (paramOutputStreamWriter != null)
        {
          paramDexFile.println("  parameter annotations:");
          int j = paramOutputStreamWriter.size();
          i = 0;
          while (i < j)
          {
            paramDexFile.println("    parameter " + i);
            localObject1 = paramOutputStreamWriter.get(i).getAnnotations().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Annotation)((Iterator)localObject1).next();
              paramDexFile.println("      " + localObject2);
            }
            i += 1;
          }
        }
      }
      paramDexFile.flush();
      return;
    }
  }
  
  private static String fixPath(String paramString)
  {
    String str = paramString;
    if (File.separatorChar == '\\') {
      str = paramString.replace('\\', '/');
    }
    int i = str.lastIndexOf("/./");
    if (i != -1) {
      paramString = str.substring(i + 3);
    }
    do
    {
      return paramString;
      paramString = str;
    } while (!str.startsWith("./"));
    return str.substring(2);
  }
  
  private static String getDexFileName(int paramInt)
  {
    if (paramInt == 0) {
      return "classes.dex";
    }
    return "classes" + (paramInt + 1) + ".dex";
  }
  
  public static String getTooManyIdsErrorMessage()
  {
    if (args.multiDex) {
      return "The list of classes given in --main-dex-list is too big and does not fit in the main dex.";
    }
    return "You may try using --multi-dex option.";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    Main.Arguments localArguments = new Main.Arguments();
    localArguments.parse(paramArrayOfString);
    int i = run(localArguments);
    if (i != 0) {
      System.exit(i);
    }
  }
  
  private static Manifest makeManifest()
  {
    Object localObject = (byte[])outputResources.get("META-INF/MANIFEST.MF");
    Manifest localManifest;
    if (localObject == null)
    {
      localManifest = new Manifest();
      localObject = localManifest.getMainAttributes();
      ((Attributes)localObject).put(Attributes.Name.MANIFEST_VERSION, "1.0");
      str = ((Attributes)localObject).getValue(CREATED_BY);
      if (str != null) {
        break label132;
      }
    }
    label132:
    for (String str = "";; str = str + " + ")
    {
      str = str + "dx 1.12";
      ((Attributes)localObject).put(CREATED_BY, str);
      ((Attributes)localObject).putValue("Dex-Location", "classes.dex");
      return localManifest;
      localManifest = new Manifest(new ByteArrayInputStream((byte[])localObject));
      localObject = localManifest.getMainAttributes();
      outputResources.remove("META-INF/MANIFEST.MF");
      break;
    }
  }
  
  private static byte[] mergeIncremental(byte[] paramArrayOfByte, File paramFile)
  {
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = new Dex(paramArrayOfByte);; paramArrayOfByte = null)
    {
      if (paramFile.exists()) {}
      for (paramFile = new Dex(paramFile);; paramFile = null)
      {
        if ((paramArrayOfByte == null) && (paramFile == null)) {
          return null;
        }
        Object localObject;
        if (paramArrayOfByte == null) {
          localObject = paramFile;
        }
        for (;;)
        {
          paramArrayOfByte = new ByteArrayOutputStream();
          ((Dex)localObject).writeTo(paramArrayOfByte);
          return paramArrayOfByte.toByteArray();
          localObject = paramArrayOfByte;
          if (paramFile != null)
          {
            localObject = CollisionPolicy.KEEP_FIRST;
            localObject = new DexMerger(new Dex[] { paramArrayOfByte, paramFile }, (CollisionPolicy)localObject).merge();
          }
        }
      }
    }
  }
  
  private static byte[] mergeLibraryDexBuffers(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte != null) {
      localArrayList.add(new Dex(paramArrayOfByte));
    }
    paramArrayOfByte = libraryDexBuffers.iterator();
    while (paramArrayOfByte.hasNext()) {
      localArrayList.add(new Dex((byte[])paramArrayOfByte.next()));
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new DexMerger((Dex[])localArrayList.toArray(new Dex[localArrayList.size()]), CollisionPolicy.FAIL).merge().getBytes();
  }
  
  private static OutputStream openOutput(String paramString)
  {
    if ((paramString.equals("-")) || (paramString.startsWith("-."))) {
      return System.out;
    }
    return new FileOutputStream(paramString);
  }
  
  private static DirectClassFile parseClass(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new DirectClassFile(paramArrayOfByte, paramString, args.cfOptions.strictNameCheck);
    paramString.setAttributeFactory(StdAttributeFactory.THE_ONE);
    paramString.getMagic();
    return paramString;
  }
  
  private static boolean processAllFiles()
  {
    
    if (args.jarOutput) {
      outputResources = new TreeMap();
    }
    anyFilesProcessed = false;
    Object localObject3 = args.fileNames;
    Arrays.sort((Object[])localObject3);
    classTranslatorPool = new ThreadPoolExecutor(args.numThreads, args.numThreads, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue(args.numThreads * 2, true), new ThreadPoolExecutor.CallerRunsPolicy());
    classDefItemConsumer = Executors.newSingleThreadExecutor();
    int i;
    try
    {
      if (args.mainDexListFile != null)
      {
        Object localObject1;
        if (args.strictNameCheck)
        {
          localObject1 = new Main.MainDexListFilter(null);
          break label659;
          while (i < localObject3.length)
          {
            processOne(localObject3[i], (ClassPathOpener.FileNameFilter)localObject1);
            i += 1;
          }
        }
        else
        {
          localObject1 = new Main.BestEffortMainDexListFilter();
        }
      }
    }
    catch (Main.StopProcessing localStopProcessing) {}
    for (;;)
    {
      try
      {
        classTranslatorPool.shutdown();
        classTranslatorPool.awaitTermination(600L, TimeUnit.SECONDS);
        classDefItemConsumer.shutdown();
        classDefItemConsumer.awaitTermination(600L, TimeUnit.SECONDS);
        Iterator localIterator = addToDexFutures.iterator();
        if (!localIterator.hasNext()) {
          break label521;
        }
        localObject3 = (Future)localIterator.next();
        try
        {
          ((Future)localObject3).get();
        }
        catch (ExecutionException localExecutionException)
        {
          if (errors.incrementAndGet() >= 10) {
            break label510;
          }
        }
        if (args.debug)
        {
          DxConsole.err.println("Uncaught translation error:");
          localExecutionException.getCause().printStackTrace(DxConsole.err);
          continue;
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        classTranslatorPool.shutdownNow();
        classDefItemConsumer.shutdownNow();
        throw new RuntimeException("Translation has been interrupted", localInterruptedException1);
        if (dexOutputFutures.size() > 0) {
          throw new DexException("Too many classes in --main-dex-list, main dex capacity exceeded");
        }
        if (!args.minimalMainDex) {
          break label664;
        }
        synchronized (dexRotationLock)
        {
          if (maxMethodIdsInProcess <= 0)
          {
            i = maxFieldIdsInProcess;
            if (i <= 0) {}
          }
          else
          {
            try
            {
              dexRotationLock.wait();
            }
            catch (InterruptedException localInterruptedException2) {}
            continue;
          }
          rotateDexFile();
          break label664;
          if (i >= localExecutionException.length) {
            continue;
          }
          processOne(localExecutionException[i], new Main.NotFilter(localInterruptedException1, null));
          i += 1;
        }
        if (i >= localExecutionException.length) {
          continue;
        }
        processOne(localExecutionException[i], ClassPathOpener.acceptAll);
        i += 1;
        continue;
        DxConsole.err.println("Uncaught translation error: " + localExecutionException.getCause());
        continue;
      }
      catch (Exception localException)
      {
        classTranslatorPool.shutdownNow();
        classDefItemConsumer.shutdownNow();
        localException.printStackTrace(System.out);
        throw new RuntimeException("Unexpected exception in translator thread.", localException);
      }
      label510:
      throw new InterruptedException("Too many errors");
      label521:
      i = errors.get();
      if (i != 0)
      {
        PrintStream localPrintStream = DxConsole.err;
        ??? = new StringBuilder().append(i).append(" error");
        if (i == 1) {}
        for (String str = "";; str = "s")
        {
          localPrintStream.println(str + "; aborting");
          return false;
        }
      }
      if ((args.incremental) && (!anyFilesProcessed)) {
        return true;
      }
      if ((!anyFilesProcessed) && (!args.emptyOk))
      {
        DxConsole.err.println("no classfiles specified");
        return false;
      }
      if ((args.optimize) && (args.statistics)) {
        CodeStatistics.dumpStatistics(DxConsole.out);
      }
      return true;
      label659:
      i = 0;
      break;
      label664:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private static boolean processClass(String paramString, byte[] paramArrayOfByte)
  {
    if (!args.coreLibrary) {
      checkClassName(paramString);
    }
    try
    {
      Main.DirectClassFileConsumer.access$700(new Main.DirectClassFileConsumer(paramString, paramArrayOfByte, null, null), new Main.ClassParserTask(paramString, paramArrayOfByte, null).call());
      return true;
    }
    catch (ParseException paramString)
    {
      throw paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("Exception parsing classes", paramString);
    }
  }
  
  private static boolean processFileBytes(String arg0, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool1 = ???.endsWith(".class");
    boolean bool2 = ???.equals("classes.dex");
    if (outputResources != null) {}
    for (int i = 1; (!bool1) && (!bool2) && (i == 0); i = 0)
    {
      if (args.verbose) {
        DxConsole.out.println("ignored resource " + ???);
      }
      return false;
    }
    if (args.verbose) {
      DxConsole.out.println("processing " + ??? + "...");
    }
    ??? = fixPath(???);
    if (bool1)
    {
      if ((i != 0) && (args.keepClassesInJar)) {}
      synchronized (outputResources)
      {
        outputResources.put(???, paramArrayOfByte);
        if (paramLong < minimumFileAge) {
          return true;
        }
      }
      processClass(???, paramArrayOfByte);
      return false;
    }
    if (bool2) {
      synchronized (libraryDexBuffers)
      {
        libraryDexBuffers.add(paramArrayOfByte);
        return true;
      }
    }
    synchronized (outputResources)
    {
      outputResources.put(???, paramArrayOfByte);
      return true;
    }
  }
  
  private static void processOne(String paramString, ClassPathOpener.FileNameFilter paramFileNameFilter)
  {
    if (new ClassPathOpener(paramString, true, paramFileNameFilter, new Main.FileBytesConsumer(null)).process()) {
      updateStatus(true);
    }
  }
  
  private static void readPathsFromFile(String paramString, Collection<String> paramCollection)
  {
    try
    {
      paramString = new BufferedReader(new FileReader(paramString));
      try
      {
        for (;;)
        {
          String str = paramString.readLine();
          if (str == null) {
            break;
          }
          paramCollection.add(fixPath(str));
        }
        if (paramCollection == null) {
          break label52;
        }
      }
      finally
      {
        paramCollection = paramString;
        paramString = localObject;
      }
    }
    finally
    {
      for (;;)
      {
        label52:
        paramCollection = null;
      }
    }
    paramCollection.close();
    throw paramString;
    if (paramString != null) {
      paramString.close();
    }
  }
  
  private static void rotateDexFile()
  {
    if (outputDex != null)
    {
      if (dexOutPool == null) {
        break label44;
      }
      dexOutputFutures.add(dexOutPool.submit(new Main.DexWriter(outputDex, null)));
    }
    for (;;)
    {
      createDexFile();
      return;
      label44:
      dexOutputArrays.add(writeDex(outputDex));
    }
  }
  
  public static int run(Main.Arguments paramArguments)
  {
    errors.set(0);
    libraryDexBuffers.clear();
    args = paramArguments;
    Main.Arguments.access$000(args);
    if (args.humanOutName != null)
    {
      paramArguments = openOutput(args.humanOutName);
      humanOutWriter = new OutputStreamWriter(paramArguments);
    }
    for (;;)
    {
      try
      {
        if (args.multiDex)
        {
          i = runMultiDex();
          return i;
        }
        int i = runMonoDex();
        return i;
      }
      finally
      {
        closeOutput(paramArguments);
      }
      paramArguments = null;
    }
  }
  
  private static int runMonoDex()
  {
    Object localObject1;
    if (args.incremental)
    {
      if (args.outName == null)
      {
        System.err.println("error: no incremental output name specified");
        return -1;
      }
      localObject1 = new File(args.outName);
      localObject2 = localObject1;
      if (((File)localObject1).exists()) {
        minimumFileAge = ((File)localObject1).lastModified();
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      if (!processAllFiles()) {
        return 1;
      }
      if ((args.incremental) && (!anyFilesProcessed)) {
        return 0;
      }
      if ((!outputDex.isEmpty()) || (args.humanOutName != null))
      {
        localObject3 = writeDex(outputDex);
        localObject1 = localObject3;
        if (localObject3 == null) {
          return 2;
        }
      }
      else
      {
        localObject1 = null;
      }
      Object localObject3 = localObject1;
      if (args.incremental) {
        localObject3 = mergeIncremental((byte[])localObject1, (File)localObject2);
      }
      localObject1 = mergeLibraryDexBuffers((byte[])localObject3);
      if (args.jarOutput)
      {
        outputDex = null;
        if (localObject1 != null) {
          outputResources.put("classes.dex", localObject1);
        }
        if (!createJar(args.outName)) {
          return 3;
        }
      }
      else if ((localObject1 != null) && (args.outName != null))
      {
        localObject2 = openOutput(args.outName);
        ((OutputStream)localObject2).write((byte[])localObject1);
        closeOutput((OutputStream)localObject2);
      }
      return 0;
    }
  }
  
  private static int runMultiDex()
  {
    int k = 0;
    assert (!args.incremental);
    if (args.mainDexListFile != null)
    {
      classesInMainDex = new HashSet();
      readPathsFromFile(args.mainDexListFile, classesInMainDex);
    }
    dexOutPool = Executors.newFixedThreadPool(args.numThreads);
    int i;
    if (!processAllFiles()) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        if (!libraryDexBuffers.isEmpty()) {
          throw new DexException("Library dex files are not supported in multi-dex mode");
        }
        if (outputDex != null)
        {
          dexOutputFutures.add(dexOutPool.submit(new Main.DexWriter(outputDex, null)));
          outputDex = null;
        }
        try
        {
          dexOutPool.shutdown();
          if (!dexOutPool.awaitTermination(600L, TimeUnit.SECONDS)) {
            throw new RuntimeException("Timed out waiting for dex writer threads.");
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          dexOutPool.shutdownNow();
          throw new RuntimeException("A dex writer thread has been interrupted.");
          Iterator localIterator = dexOutputFutures.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (Future)localIterator.next();
            dexOutputArrays.add(((Future)localObject1).get());
          }
        }
        catch (Exception localException)
        {
          dexOutPool.shutdownNow();
          throw new RuntimeException("Unexpected exception in dex writer thread");
        }
        if (!args.jarOutput) {
          break;
        }
        i = 0;
        while (i < dexOutputArrays.size())
        {
          outputResources.put(getDexFileName(i), dexOutputArrays.get(i));
          i += 1;
        }
        i = k;
      } while (createJar(args.outName));
      return 3;
      i = k;
    } while (args.outName == null);
    Object localObject1 = new File(args.outName);
    assert (((File)localObject1).isDirectory());
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= dexOutputArrays.size()) {
        break;
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(new File((File)localObject1, getDexFileName(j)));
      try
      {
        localFileOutputStream.write((byte[])dexOutputArrays.get(j));
        closeOutput(localFileOutputStream);
        j += 1;
      }
      finally
      {
        closeOutput(localFileOutputStream);
      }
    }
  }
  
  private static ClassDefItem translateClass(byte[] paramArrayOfByte, DirectClassFile paramDirectClassFile)
  {
    try
    {
      paramArrayOfByte = CfTranslator.translate(paramDirectClassFile, paramArrayOfByte, args.cfOptions, args.dexOptions, outputDex);
      return paramArrayOfByte;
    }
    catch (ParseException paramArrayOfByte)
    {
      DxConsole.err.println("\ntrouble processing:");
      if (!args.debug) {
        break label58;
      }
    }
    paramArrayOfByte.printStackTrace(DxConsole.err);
    for (;;)
    {
      errors.incrementAndGet();
      return null;
      label58:
      paramArrayOfByte.printContext(DxConsole.err);
    }
  }
  
  private static void updateStatus(boolean paramBoolean)
  {
    anyFilesProcessed |= paramBoolean;
  }
  
  private static byte[] writeDex(DexFile paramDexFile)
  {
    for (;;)
    {
      try
      {
        if (args.methodToDump != null)
        {
          paramDexFile.toDex(null, false);
          dumpMethod(paramDexFile, args.methodToDump, humanOutWriter);
          arrayOfByte = null;
          if (args.statistics) {
            DxConsole.out.println(paramDexFile.getStatistics().toHuman());
          }
        }
      }
      finally
      {
        byte[] arrayOfByte;
        if (humanOutWriter != null) {
          humanOutWriter.flush();
        }
      }
      try
      {
        if (humanOutWriter != null) {
          humanOutWriter.flush();
        }
        return arrayOfByte;
      }
      catch (Exception paramDexFile)
      {
        if (!args.debug) {
          break label127;
        }
      }
      arrayOfByte = paramDexFile.toDex(humanOutWriter, args.verboseDump);
    }
    DxConsole.err.println("\ntrouble writing output:");
    paramDexFile.printStackTrace(DxConsole.err);
    for (;;)
    {
      return null;
      label127:
      DxConsole.err.println("\ntrouble writing output: " + paramDexFile.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main
 * JD-Core Version:    0.7.0.1
 */