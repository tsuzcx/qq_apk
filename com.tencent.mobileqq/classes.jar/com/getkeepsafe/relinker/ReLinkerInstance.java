package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance
{
  protected final ReLinker.LibraryInstaller a;
  protected final ReLinker.LibraryLoader a;
  protected ReLinker.Logger a;
  protected final Set<String> a;
  protected boolean a;
  protected boolean b;
  
  protected ReLinkerInstance()
  {
    this(new SystemLibraryLoader(), new ApkLibraryInstaller());
  }
  
  protected ReLinkerInstance(ReLinker.LibraryLoader paramLibraryLoader, ReLinker.LibraryInstaller paramLibraryInstaller)
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    if (paramLibraryLoader != null)
    {
      if (paramLibraryInstaller != null)
      {
        this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader = paramLibraryLoader;
        this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryInstaller = paramLibraryInstaller;
        return;
      }
      throw new IllegalArgumentException("Cannot pass null library installer");
    }
    throw new IllegalArgumentException("Cannot pass null library loader");
  }
  
  /* Error */
  private void b(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   4: aload_2
    //   5: invokeinterface 58 2 0
    //   10: ifeq +25 -> 35
    //   13: aload_0
    //   14: getfield 60	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_Boolean	Z
    //   17: ifne +18 -> 35
    //   20: aload_0
    //   21: ldc 62
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_2
    //   30: aastore
    //   31: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 33	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader	Lcom/getkeepsafe/relinker/ReLinker$LibraryLoader;
    //   39: aload_2
    //   40: invokeinterface 69 2 0
    //   45: aload_0
    //   46: getfield 31	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   49: aload_2
    //   50: invokeinterface 72 2 0
    //   55: pop
    //   56: aload_0
    //   57: ldc 74
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_2
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_3
    //   70: aastore
    //   71: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: return
    //   75: astore 5
    //   77: aload_0
    //   78: ldc 76
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 5
    //   88: invokestatic 82	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   91: aastore
    //   92: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: ldc 84
    //   98: iconst_2
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_2
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_3
    //   109: aastore
    //   110: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_0
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 87	com/getkeepsafe/relinker/ReLinkerInstance:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   120: astore 7
    //   122: aload 7
    //   124: invokevirtual 93	java/io/File:exists	()Z
    //   127: ifeq +10 -> 137
    //   130: aload_0
    //   131: getfield 60	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_Boolean	Z
    //   134: ifeq +67 -> 201
    //   137: aload_0
    //   138: getfield 60	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_Boolean	Z
    //   141: ifeq +21 -> 162
    //   144: aload_0
    //   145: ldc 95
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_2
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_3
    //   158: aastore
    //   159: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_0
    //   163: aload_1
    //   164: aload_2
    //   165: aload_3
    //   166: invokevirtual 97	com/getkeepsafe/relinker/ReLinkerInstance:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 35	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryInstaller	Lcom/getkeepsafe/relinker/ReLinker$LibraryInstaller;
    //   173: aload_1
    //   174: aload_0
    //   175: getfield 33	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader	Lcom/getkeepsafe/relinker/ReLinker$LibraryLoader;
    //   178: invokeinterface 100 1 0
    //   183: aload_0
    //   184: getfield 33	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader	Lcom/getkeepsafe/relinker/ReLinker$LibraryLoader;
    //   187: aload_2
    //   188: invokeinterface 103 2 0
    //   193: aload 7
    //   195: aload_0
    //   196: invokeinterface 108 6 0
    //   201: aload_0
    //   202: getfield 110	com/getkeepsafe/relinker/ReLinkerInstance:b	Z
    //   205: istore 4
    //   207: iload 4
    //   209: ifeq +86 -> 295
    //   212: aconst_null
    //   213: astore 6
    //   215: new 112	com/getkeepsafe/relinker/elf/ElfParser
    //   218: dup
    //   219: aload 7
    //   221: invokespecial 115	com/getkeepsafe/relinker/elf/ElfParser:<init>	(Ljava/io/File;)V
    //   224: astore 5
    //   226: aload 5
    //   228: invokevirtual 118	com/getkeepsafe/relinker/elf/ElfParser:a	()Ljava/util/List;
    //   231: astore 6
    //   233: aload 5
    //   235: invokevirtual 121	com/getkeepsafe/relinker/elf/ElfParser:close	()V
    //   238: aload 6
    //   240: invokeinterface 127 1 0
    //   245: astore 5
    //   247: aload 5
    //   249: invokeinterface 132 1 0
    //   254: ifeq +41 -> 295
    //   257: aload 5
    //   259: invokeinterface 136 1 0
    //   264: checkcast 138	java/lang/String
    //   267: astore 6
    //   269: aload_0
    //   270: aload_1
    //   271: aload_0
    //   272: getfield 33	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader	Lcom/getkeepsafe/relinker/ReLinker$LibraryLoader;
    //   275: aload 6
    //   277: invokeinterface 140 2 0
    //   282: invokevirtual 143	com/getkeepsafe/relinker/ReLinkerInstance:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   285: goto -38 -> 247
    //   288: aload_1
    //   289: invokevirtual 121	com/getkeepsafe/relinker/elf/ElfParser:close	()V
    //   292: aload 5
    //   294: athrow
    //   295: aload_0
    //   296: getfield 33	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader	Lcom/getkeepsafe/relinker/ReLinker$LibraryLoader;
    //   299: aload 7
    //   301: invokevirtual 147	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   304: invokeinterface 149 2 0
    //   309: aload_0
    //   310: getfield 31	com/getkeepsafe/relinker/ReLinkerInstance:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   313: aload_2
    //   314: invokeinterface 72 2 0
    //   319: pop
    //   320: aload_0
    //   321: ldc 151
    //   323: iconst_2
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_2
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload_3
    //   334: aastore
    //   335: invokevirtual 65	com/getkeepsafe/relinker/ReLinkerInstance:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: return
    //   339: astore_1
    //   340: goto -45 -> 295
    //   343: astore 6
    //   345: aload 5
    //   347: astore_1
    //   348: aload 6
    //   350: astore 5
    //   352: goto -64 -> 288
    //   355: astore 5
    //   357: aload 6
    //   359: astore_1
    //   360: goto -72 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	ReLinkerInstance
    //   0	363	1	paramContext	Context
    //   0	363	2	paramString1	String
    //   0	363	3	paramString2	String
    //   205	3	4	bool	boolean
    //   75	12	5	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   224	127	5	localObject1	Object
    //   355	1	5	localObject2	Object
    //   213	63	6	localObject3	Object
    //   343	15	6	localObject4	Object
    //   120	180	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   35	74	75	java/lang/UnsatisfiedLinkError
    //   201	207	339	java/io/IOException
    //   233	247	339	java/io/IOException
    //   247	285	339	java/io/IOException
    //   288	295	339	java/io/IOException
    //   226	233	343	finally
    //   215	226	355	finally
  }
  
  protected File a(Context paramContext)
  {
    return paramContext.getDir("lib", 0);
  }
  
  protected File a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader.a(paramString1);
    if (TextUtils.a(paramString2)) {
      return new File(a(paramContext), paramString1);
    }
    paramContext = a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return new File(paramContext, localStringBuilder.toString());
  }
  
  public void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null);
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = a(paramContext);
    paramContext = a(paramContext, paramString1, paramString2);
    paramString1 = localFile.listFiles(new ReLinkerInstance.2(this, this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LibraryLoader.a(paramString1)));
    if (paramString1 == null) {
      return;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      paramString2 = paramString1[i];
      if ((this.jdField_a_of_type_Boolean) || (!paramString2.getAbsolutePath().equals(paramContext.getAbsolutePath()))) {
        paramString2.delete();
      }
      i += 1;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener)
  {
    if (paramContext != null)
    {
      if (!TextUtils.a(paramString1))
      {
        a("Beginning load of %s...", new Object[] { paramString1 });
        if (paramLoadListener == null)
        {
          b(paramContext, paramString1, paramString2);
          return;
        }
        new Thread(new ReLinkerInstance.1(this, paramContext, paramString1, paramString2, paramLoadListener)).start();
        return;
      }
      throw new IllegalArgumentException("Given library is either null or empty");
    }
    throw new IllegalArgumentException("Given context is null");
  }
  
  public void a(String paramString)
  {
    ReLinker.Logger localLogger = this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$Logger;
    if (localLogger != null) {
      localLogger.a(paramString);
    }
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    a(String.format(Locale.US, paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.ReLinkerInstance
 * JD-Core Version:    0.7.0.1
 */