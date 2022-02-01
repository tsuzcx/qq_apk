package com.android.multidex;

import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.HasAttribute;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.annotation.Annotations;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;

public class MainDexListBuilder
{
  private static final String CLASS_EXTENSION = ".class";
  private static final String DISABLE_ANNOTATION_RESOLUTION_WORKAROUND = "--disable-annotation-resolution-workaround";
  private static final String EOL = System.getProperty("line.separator");
  private static final int STATUS_ERROR = 1;
  private static String USAGE_MESSAGE = "Usage:" + EOL + EOL + "Short version: Don't use this." + EOL + EOL + "Slightly longer version: This tool is used by mainDexClasses script to build" + EOL + "the main dex list." + EOL;
  private Set<String> filesToKeep;
  
  /* Error */
  public MainDexListBuilder(boolean paramBoolean, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokespecial 59	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: new 61	java/util/HashSet
    //   11: dup
    //   12: invokespecial 62	java/util/HashSet:<init>	()V
    //   15: putfield 64	com/android/multidex/MainDexListBuilder:filesToKeep	Ljava/util/Set;
    //   18: new 66	java/util/zip/ZipFile
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 69	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   26: astore 4
    //   28: new 71	com/android/multidex/Path
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 72	com/android/multidex/Path:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: new 74	com/android/multidex/ClassReferenceListBuilder
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 77	com/android/multidex/ClassReferenceListBuilder:<init>	(Lcom/android/multidex/Path;)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload 4
    //   49: invokevirtual 81	com/android/multidex/ClassReferenceListBuilder:addRoots	(Ljava/util/zip/ZipFile;)V
    //   52: aload_2
    //   53: invokevirtual 85	com/android/multidex/ClassReferenceListBuilder:getClassNames	()Ljava/util/Set;
    //   56: invokeinterface 91 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 97 1 0
    //   68: ifeq +158 -> 226
    //   71: aload_2
    //   72: invokeinterface 101 1 0
    //   77: checkcast 103	java/lang/String
    //   80: astore 5
    //   82: aload_0
    //   83: getfield 64	com/android/multidex/MainDexListBuilder:filesToKeep	Ljava/util/Set;
    //   86: new 33	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   93: aload 5
    //   95: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 8
    //   100: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokeinterface 107 2 0
    //   111: pop
    //   112: goto -50 -> 62
    //   115: astore_2
    //   116: aload 4
    //   118: invokevirtual 110	java/util/zip/ZipFile:close	()V
    //   121: aload_3
    //   122: ifnull +164 -> 286
    //   125: aload_3
    //   126: getfield 114	com/android/multidex/Path:elements	Ljava/util/List;
    //   129: invokeinterface 117 1 0
    //   134: astore_3
    //   135: aload_3
    //   136: invokeinterface 97 1 0
    //   141: ifeq +145 -> 286
    //   144: aload_3
    //   145: invokeinterface 101 1 0
    //   150: checkcast 119	com/android/multidex/ClassPathElement
    //   153: astore 4
    //   155: aload 4
    //   157: invokeinterface 120 1 0
    //   162: goto -27 -> 135
    //   165: astore 4
    //   167: goto -32 -> 135
    //   170: astore_3
    //   171: new 58	java/io/IOException
    //   174: dup
    //   175: new 33	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   182: ldc 122
    //   184: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_2
    //   188: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 124
    //   193: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 129
    //   205: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: aload_3
    //   212: invokespecial 132	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: athrow
    //   216: astore_2
    //   217: aconst_null
    //   218: astore_3
    //   219: aload 5
    //   221: astore 4
    //   223: goto -107 -> 116
    //   226: iload_1
    //   227: ifeq +8 -> 235
    //   230: aload_0
    //   231: aload_3
    //   232: invokespecial 135	com/android/multidex/MainDexListBuilder:keepAnnotated	(Lcom/android/multidex/Path;)V
    //   235: aload 4
    //   237: invokevirtual 110	java/util/zip/ZipFile:close	()V
    //   240: aload_3
    //   241: ifnull +56 -> 297
    //   244: aload_3
    //   245: getfield 114	com/android/multidex/Path:elements	Ljava/util/List;
    //   248: invokeinterface 117 1 0
    //   253: astore_2
    //   254: aload_2
    //   255: invokeinterface 97 1 0
    //   260: ifeq +37 -> 297
    //   263: aload_2
    //   264: invokeinterface 101 1 0
    //   269: checkcast 119	com/android/multidex/ClassPathElement
    //   272: astore_3
    //   273: aload_3
    //   274: invokeinterface 120 1 0
    //   279: goto -25 -> 254
    //   282: astore_3
    //   283: goto -29 -> 254
    //   286: aload_2
    //   287: athrow
    //   288: astore_2
    //   289: goto -49 -> 240
    //   292: astore 4
    //   294: goto -173 -> 121
    //   297: return
    //   298: astore_2
    //   299: aconst_null
    //   300: astore_3
    //   301: goto -185 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	MainDexListBuilder
    //   0	304	1	paramBoolean	boolean
    //   0	304	2	paramString1	String
    //   0	304	3	paramString2	String
    //   26	130	4	localObject	Object
    //   165	1	4	localIOException1	IOException
    //   221	15	4	str1	String
    //   292	1	4	localIOException2	IOException
    //   1	219	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   37	62	115	finally
    //   62	112	115	finally
    //   230	235	115	finally
    //   155	162	165	java/io/IOException
    //   18	28	170	java/io/IOException
    //   18	28	216	finally
    //   171	216	216	finally
    //   273	279	282	java/io/IOException
    //   235	240	288	java/io/IOException
    //   116	121	292	java/io/IOException
    //   28	37	298	finally
  }
  
  private boolean hasRuntimeVisibleAnnotation(HasAttribute paramHasAttribute)
  {
    paramHasAttribute = paramHasAttribute.getAttributes().findFirst("RuntimeVisibleAnnotations");
    return (paramHasAttribute != null) && (((AttRuntimeVisibleAnnotations)paramHasAttribute).getAnnotations().size() > 0);
  }
  
  private void keepAnnotated(Path paramPath)
  {
    Iterator localIterator1 = paramPath.getElements().iterator();
    label161:
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ClassPathElement)localIterator1.next()).list().iterator();
      label40:
      label216:
      for (;;)
      {
        String str;
        Object localObject;
        int i;
        if (localIterator2.hasNext())
        {
          str = (String)localIterator2.next();
          if (str.endsWith(".class"))
          {
            localObject = paramPath.getClass(str);
            if (hasRuntimeVisibleAnnotation((HasAttribute)localObject))
            {
              this.filesToKeep.add(str);
            }
            else
            {
              MethodList localMethodList = ((DirectClassFile)localObject).getMethods();
              i = 0;
              for (;;)
              {
                if (i >= localMethodList.size()) {
                  break label161;
                }
                if (hasRuntimeVisibleAnnotation(localMethodList.get(i)))
                {
                  this.filesToKeep.add(str);
                  break;
                }
                i += 1;
              }
              localObject = ((DirectClassFile)localObject).getFields();
              i = 0;
            }
          }
        }
        else
        {
          for (;;)
          {
            if (i >= ((FieldList)localObject).size()) {
              break label216;
            }
            if (hasRuntimeVisibleAnnotation(((FieldList)localObject).get(i)))
            {
              this.filesToKeep.add(str);
              break label40;
              break;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    boolean bool = true;
    int i = 0;
    if (i < paramArrayOfString.length - 2)
    {
      if (paramArrayOfString[i].equals("--disable-annotation-resolution-workaround")) {
        bool = false;
      }
      for (;;)
      {
        i += 1;
        break;
        System.err.println("Invalid option " + paramArrayOfString[i]);
        printUsage();
        System.exit(1);
      }
    }
    if (paramArrayOfString.length - i != 2)
    {
      printUsage();
      System.exit(1);
    }
    try
    {
      printList(new MainDexListBuilder(bool, paramArrayOfString[i], paramArrayOfString[(i + 1)]).getMainDexList());
      return;
    }
    catch (IOException paramArrayOfString)
    {
      System.err.println("A fatal error occured: " + paramArrayOfString.getMessage());
      System.exit(1);
    }
  }
  
  private static void printList(Set<String> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      System.out.println(str);
    }
  }
  
  private static void printUsage()
  {
    System.err.print(USAGE_MESSAGE);
  }
  
  public Set<String> getMainDexList()
  {
    return this.filesToKeep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.MainDexListBuilder
 * JD-Core Version:    0.7.0.1
 */