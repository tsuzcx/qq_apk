package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.tool.v.VersionConfiguration;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

public abstract class QarHelper
{
  protected HashMap<String, Long> checkSum = new HashMap();
  protected List<String> exceptFiles = null;
  protected QarBody proxyBody = new QarBody();
  protected QarHeader proxyHeader = new QarHeader();
  protected List<String> uncompressFiles = null;
  
  protected abstract List<ExtensionFiled> addExBody(QarBody paramQarBody);
  
  protected abstract List<ExtensionFiled> addExHeader(QarHeader paramQarHeader);
  
  /* Error */
  protected boolean checkSum(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 5
    //   13: new 48	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 51	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: iload 4
    //   24: istore_3
    //   25: aload_1
    //   26: invokevirtual 55	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:getEntries	()Ljava/util/Enumeration;
    //   29: astore 5
    //   31: iload 4
    //   33: istore_3
    //   34: aload 5
    //   36: invokeinterface 61 1 0
    //   41: ifeq +309 -> 350
    //   44: iload 4
    //   46: istore_3
    //   47: aload 5
    //   49: invokeinterface 65 1 0
    //   54: checkcast 67	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry
    //   57: astore 6
    //   59: iload 4
    //   61: istore_3
    //   62: aload 6
    //   64: invokevirtual 71	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:getName	()Ljava/lang/String;
    //   67: ldc 73
    //   69: invokevirtual 79	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +6 -> 78
    //   75: goto -44 -> 31
    //   78: iload 4
    //   80: istore_3
    //   81: aload 6
    //   83: invokevirtual 71	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:getName	()Ljava/lang/String;
    //   86: astore 7
    //   88: iload 4
    //   90: istore_3
    //   91: aload 6
    //   93: invokevirtual 83	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:getCrc	()J
    //   96: aload_0
    //   97: getfield 24	com/tencent/hippy/qq/update/tool/QarHelper:checkSum	Ljava/util/HashMap;
    //   100: aload 7
    //   102: invokevirtual 87	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 89	java/lang/Long
    //   108: invokevirtual 92	java/lang/Long:longValue	()J
    //   111: lcmp
    //   112: ifeq -81 -> 31
    //   115: goto +3 -> 118
    //   118: iload_2
    //   119: istore_3
    //   120: aload_0
    //   121: getfield 24	com/tencent/hippy/qq/update/tool/QarHelper:checkSum	Ljava/util/HashMap;
    //   124: invokevirtual 95	java/util/HashMap:clear	()V
    //   127: aload_1
    //   128: invokevirtual 98	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:close	()V
    //   131: iload_2
    //   132: ireturn
    //   133: astore 6
    //   135: getstatic 104	java/lang/System:out	Ljava/io/PrintStream;
    //   138: astore_1
    //   139: new 106	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   146: astore 5
    //   148: aload 5
    //   150: ldc 109
    //   152: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload 6
    //   160: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: aload 5
    //   167: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 124	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   173: iload_2
    //   174: ireturn
    //   175: astore 6
    //   177: aload_1
    //   178: astore 5
    //   180: aload 6
    //   182: astore_1
    //   183: goto +104 -> 287
    //   186: astore 6
    //   188: goto +12 -> 200
    //   191: astore_1
    //   192: goto +95 -> 287
    //   195: astore 6
    //   197: aload 7
    //   199: astore_1
    //   200: aload_1
    //   201: astore 5
    //   203: getstatic 104	java/lang/System:out	Ljava/io/PrintStream;
    //   206: astore 7
    //   208: aload_1
    //   209: astore 5
    //   211: new 106	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   218: astore 8
    //   220: aload_1
    //   221: astore 5
    //   223: aload 8
    //   225: ldc 126
    //   227: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: astore 5
    //   234: aload 8
    //   236: aload 6
    //   238: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: astore 5
    //   245: aload 7
    //   247: aload 8
    //   249: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 124	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: ifnull +29 -> 285
    //   259: aload_1
    //   260: invokevirtual 98	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:close	()V
    //   263: iload_3
    //   264: ireturn
    //   265: astore 6
    //   267: getstatic 104	java/lang/System:out	Ljava/io/PrintStream;
    //   270: astore_1
    //   271: new 106	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   278: astore 5
    //   280: iload_3
    //   281: istore_2
    //   282: goto -134 -> 148
    //   285: iload_3
    //   286: ireturn
    //   287: aload 5
    //   289: ifnull +53 -> 342
    //   292: aload 5
    //   294: invokevirtual 98	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:close	()V
    //   297: goto +45 -> 342
    //   300: astore 5
    //   302: getstatic 104	java/lang/System:out	Ljava/io/PrintStream;
    //   305: astore 6
    //   307: new 106	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   314: astore 7
    //   316: aload 7
    //   318: ldc 109
    //   320: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 7
    //   326: aload 5
    //   328: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 6
    //   334: aload 7
    //   336: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokevirtual 124	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   342: goto +5 -> 347
    //   345: aload_1
    //   346: athrow
    //   347: goto -2 -> 345
    //   350: iconst_1
    //   351: istore_2
    //   352: goto -234 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	QarHelper
    //   0	355	1	paramString	String
    //   6	346	2	bool1	boolean
    //   4	282	3	bool2	boolean
    //   1	88	4	bool3	boolean
    //   11	282	5	localObject1	Object
    //   300	27	5	localIOException1	java.io.IOException
    //   57	35	6	localZipEntry	ZipEntry
    //   133	26	6	localIOException2	java.io.IOException
    //   175	6	6	localObject2	Object
    //   186	1	6	localIOException3	java.io.IOException
    //   195	42	6	localIOException4	java.io.IOException
    //   265	1	6	localIOException5	java.io.IOException
    //   305	28	6	localPrintStream	java.io.PrintStream
    //   8	327	7	localObject3	Object
    //   218	30	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/io/IOException
    //   25	31	175	finally
    //   34	44	175	finally
    //   47	59	175	finally
    //   62	75	175	finally
    //   81	88	175	finally
    //   91	115	175	finally
    //   120	127	175	finally
    //   25	31	186	java/io/IOException
    //   34	44	186	java/io/IOException
    //   47	59	186	java/io/IOException
    //   62	75	186	java/io/IOException
    //   81	88	186	java/io/IOException
    //   91	115	186	java/io/IOException
    //   120	127	186	java/io/IOException
    //   13	22	191	finally
    //   203	208	191	finally
    //   211	220	191	finally
    //   223	231	191	finally
    //   234	242	191	finally
    //   245	255	191	finally
    //   13	22	195	java/io/IOException
    //   259	263	265	java/io/IOException
    //   292	297	300	java/io/IOException
  }
  
  protected abstract String getQarMd5(File paramFile);
  
  protected void md5Body(MessageDigest paramMessageDigest, ZipEntry paramZipEntry, int paramInt)
  {
    this.proxyBody.setBody(paramInt, paramZipEntry.getName(), paramZipEntry.getSize(), paramZipEntry.getCrc(), paramZipEntry.getMethod());
    paramZipEntry = this.proxyBody;
    paramZipEntry.setExtensionFileds(addExBody(paramZipEntry));
    this.proxyBody.md5Body(paramMessageDigest);
  }
  
  protected void md5BodyData(MessageDigest paramMessageDigest, InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    this.proxyBody.md5BodyData(paramMessageDigest, paramInputStream, paramArrayOfByte);
  }
  
  protected void md5Header(MessageDigest paramMessageDigest)
  {
    this.proxyHeader.setHeader(VersionConfiguration.CURRENT_VERSION);
    QarHeader localQarHeader = this.proxyHeader;
    localQarHeader.setExtensionFileds(addExHeader(localQarHeader));
    this.proxyHeader.md5Header(paramMessageDigest);
  }
  
  protected abstract boolean read(String paramString1, String paramString2);
  
  protected void setExceptFiles(List<String> paramList)
  {
    this.exceptFiles = paramList;
  }
  
  protected void setUncompressList(List<String> paramList)
  {
    this.uncompressFiles = paramList;
  }
  
  protected abstract boolean write(File paramFile1, File paramFile2);
  
  protected void writeBody(BufferedOutputStream paramBufferedOutputStream, ZipEntry paramZipEntry, int paramInt)
  {
    this.proxyBody.setBody(paramInt, paramZipEntry.getName(), paramZipEntry.getSize(), paramZipEntry.getCrc(), paramZipEntry.getMethod());
    paramZipEntry = this.proxyBody;
    paramZipEntry.setExtensionFileds(addExBody(paramZipEntry));
    this.proxyBody.writeBody(paramBufferedOutputStream);
  }
  
  protected void writeBodyData(BufferedOutputStream paramBufferedOutputStream, InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    this.proxyBody.writeBodyData(paramBufferedOutputStream, paramInputStream, paramArrayOfByte);
  }
  
  protected void writeHeader(BufferedOutputStream paramBufferedOutputStream)
  {
    this.proxyHeader.setHeader(VersionConfiguration.CURRENT_VERSION);
    QarHeader localQarHeader = this.proxyHeader;
    localQarHeader.setExtensionFileds(addExHeader(localQarHeader));
    this.proxyHeader.writeHeader(paramBufferedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QarHelper
 * JD-Core Version:    0.7.0.1
 */