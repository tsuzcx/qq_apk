package com.tencent.hippy.qq.update.tool.v;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import com.tencent.hippy.qq.update.tool.ExtensionFiled;
import com.tencent.hippy.qq.update.tool.QarBody;
import com.tencent.hippy.qq.update.tool.QarHeader;
import com.tencent.hippy.qq.update.tool.QarHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QarHelperV1
  extends QarHelper
{
  static long createTime = ;
  
  public static String byteToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if ((paramArrayOfByte[i] & 0xFF) < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  private boolean checkQAR(QarHeader paramQarHeader)
  {
    return (VersionConfiguration.isQBDAvalible(paramQarHeader.version)) && (paramQarHeader.isQBDAvabile());
  }
  
  private void readFullBody(BufferedInputStream paramBufferedInputStream, ZipOutputStream paramZipOutputStream)
  {
    while (paramBufferedInputStream.available() > 0)
    {
      QarBody localQarBody = this.proxyBody.readBody(paramBufferedInputStream);
      long l1 = 0L;
      Object localObject = new ZipEntry(localQarBody.fileName);
      if (localQarBody.method == 0)
      {
        paramZipOutputStream.setMethod(0);
        ((ZipEntry)localObject).setCrc(localQarBody.crc);
      }
      else
      {
        paramZipOutputStream.setMethod(localQarBody.method);
      }
      ((ZipEntry)localObject).setSize(localQarBody.fileLength);
      ((ZipEntry)localObject).setTime(createTime);
      paramZipOutputStream.putNextEntry((ZipEntry)localObject);
      if (localQarBody.type == 1)
      {
        for (;;)
        {
          long l2 = 32768L + l1;
          if (l2 >= localQarBody.fileLength) {
            break;
          }
          paramBufferedInputStream.read(VersionConfiguration.BYTE_BUFFER);
          paramZipOutputStream.write(VersionConfiguration.BYTE_BUFFER, 0, 32768);
          l1 = l2;
        }
        int i = (int)(localQarBody.fileLength - l1);
        localObject = new byte[i];
        paramBufferedInputStream.read((byte[])localObject);
        paramZipOutputStream.write((byte[])localObject, 0, i);
      }
      this.checkSum.put(localQarBody.fileName, Long.valueOf(localQarBody.crc));
    }
  }
  
  protected List<ExtensionFiled> addExBody(QarBody paramQarBody)
  {
    if ((this.uncompressFiles != null) && (this.uncompressFiles.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.uncompressFiles.iterator();
      for (;;)
      {
        paramQarBody = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramQarBody = (String)localIterator.next();
        ExtensionFiled localExtensionFiled = new ExtensionFiled();
        localExtensionFiled.setEx(ExtensionFiled.DEFAULT_KEY_UNCOMPRESS, paramQarBody);
        localArrayList.add(localExtensionFiled);
      }
    }
    paramQarBody = null;
    return paramQarBody;
  }
  
  protected List<ExtensionFiled> addExHeader(QarHeader paramQarHeader)
  {
    return null;
  }
  
  /* Error */
  protected String getQarMd5(File paramFile)
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 209	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 4
    //   7: goto +13 -> 20
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 212	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   17: aconst_null
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +6 -> 28
    //   25: ldc 214
    //   27: areturn
    //   28: new 216	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile
    //   31: dup
    //   32: aload_1
    //   33: ldc 218
    //   35: invokespecial 221	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 225	com/tencent/hippy/qq/update/tool/v/QarHelperV1:md5Header	(Ljava/security/MessageDigest;)V
    //   45: aload_1
    //   46: invokevirtual 229	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:getEntriesInPhysicalOrder	()Ljava/util/Enumeration;
    //   49: astore 5
    //   51: aload 5
    //   53: invokeinterface 234 1 0
    //   58: ifeq +149 -> 207
    //   61: aload 5
    //   63: invokeinterface 237 1 0
    //   68: checkcast 80	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry
    //   71: astore 6
    //   73: aload 6
    //   75: invokevirtual 240	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:getName	()Ljava/lang/String;
    //   78: ldc 242
    //   80: invokevirtual 246	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   83: ifeq +6 -> 89
    //   86: goto -35 -> 51
    //   89: aload 6
    //   91: invokevirtual 249	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:isDirectory	()Z
    //   94: ifeq +15 -> 109
    //   97: aload_0
    //   98: aload 4
    //   100: aload 6
    //   102: iconst_2
    //   103: invokevirtual 253	com/tencent/hippy/qq/update/tool/v/QarHelperV1:md5Body	(Ljava/security/MessageDigest;Lcom/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry;I)V
    //   106: goto -55 -> 51
    //   109: aload_0
    //   110: getfield 256	com/tencent/hippy/qq/update/tool/v/QarHelperV1:exceptFiles	Ljava/util/List;
    //   113: ifnull +58 -> 171
    //   116: iconst_0
    //   117: istore_3
    //   118: aload_0
    //   119: getfield 256	com/tencent/hippy/qq/update/tool/v/QarHelperV1:exceptFiles	Ljava/util/List;
    //   122: invokeinterface 165 1 0
    //   127: astore 7
    //   129: iload_3
    //   130: istore_2
    //   131: aload 7
    //   133: invokeinterface 170 1 0
    //   138: ifeq +106 -> 244
    //   141: aload 7
    //   143: invokeinterface 174 1 0
    //   148: checkcast 176	java/lang/String
    //   151: astore 8
    //   153: aload 6
    //   155: invokevirtual 240	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry:getName	()Ljava/lang/String;
    //   158: aload 8
    //   160: invokevirtual 260	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   163: ifeq -34 -> 129
    //   166: iconst_1
    //   167: istore_2
    //   168: goto +76 -> 244
    //   171: aload_0
    //   172: aload 4
    //   174: aload 6
    //   176: iconst_1
    //   177: invokevirtual 253	com/tencent/hippy/qq/update/tool/v/QarHelperV1:md5Body	(Ljava/security/MessageDigest;Lcom/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry;I)V
    //   180: aload_1
    //   181: aload 6
    //   183: invokevirtual 264	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:getInputStream	(Lcom/tencent/hippy/qq/update/qarchive/tools/zip/ZipEntry;)Ljava/io/InputStream;
    //   186: astore 6
    //   188: aload_0
    //   189: aload 4
    //   191: aload 6
    //   193: getstatic 124	com/tencent/hippy/qq/update/tool/v/VersionConfiguration:BYTE_BUFFER	[B
    //   196: invokevirtual 268	com/tencent/hippy/qq/update/tool/v/QarHelperV1:md5BodyData	(Ljava/security/MessageDigest;Ljava/io/InputStream;[B)V
    //   199: aload 6
    //   201: invokevirtual 273	java/io/InputStream:close	()V
    //   204: goto -153 -> 51
    //   207: aload 4
    //   209: invokevirtual 277	java/security/MessageDigest:digest	()[B
    //   212: invokestatic 279	com/tencent/hippy/qq/update/tool/v/QarHelperV1:byteToHexString	([B)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_1
    //   218: invokevirtual 280	com/tencent/hippy/qq/update/qarchive/tools/zip/ZipFile:close	()V
    //   221: aload 4
    //   223: areturn
    //   224: astore_1
    //   225: goto +11 -> 236
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 281	java/lang/Exception:printStackTrace	()V
    //   233: ldc 214
    //   235: areturn
    //   236: goto +5 -> 241
    //   239: aload_1
    //   240: athrow
    //   241: goto -2 -> 239
    //   244: iload_2
    //   245: ifeq -74 -> 171
    //   248: goto -197 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	QarHelperV1
    //   0	251	1	paramFile	File
    //   130	115	2	i	int
    //   117	13	3	j	int
    //   5	1	4	localMessageDigest	java.security.MessageDigest
    //   10	3	4	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   18	204	4	localObject1	Object
    //   49	13	5	localEnumeration	Enumeration
    //   71	129	6	localObject2	Object
    //   127	15	7	localIterator	Iterator
    //   151	8	8	str	String
    // Exception table:
    //   from	to	target	type
    //   0	7	10	java/security/NoSuchAlgorithmException
    //   28	51	224	finally
    //   51	86	224	finally
    //   89	106	224	finally
    //   109	116	224	finally
    //   118	129	224	finally
    //   131	166	224	finally
    //   171	204	224	finally
    //   207	221	224	finally
    //   229	233	224	finally
    //   28	51	228	java/lang/Exception
    //   51	86	228	java/lang/Exception
    //   89	106	228	java/lang/Exception
    //   109	116	228	java/lang/Exception
    //   118	129	228	java/lang/Exception
    //   131	166	228	java/lang/Exception
    //   171	204	228	java/lang/Exception
    //   207	221	228	java/lang/Exception
  }
  
  public boolean read(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BufferedInputStream(new FileInputStream(new File(paramString1)));
      this.proxyHeader.readHeader(paramString1);
      if (!checkQAR(this.proxyHeader))
      {
        paramString1 = System.out;
        paramString2 = new StringBuilder();
        paramString2.append("YorkeLi:  Header not suport|qar:");
        paramString2.append(this.proxyHeader.qarMark);
        paramString2.append("|");
        paramString2.append(this.proxyHeader.version);
        paramString2.append("|but:");
        paramString2.append(VersionConfiguration.CURRENT_VERSION);
        paramString2.append("|");
        this.proxyHeader.getClass();
        paramString2.append(1233211);
        paramString1.print(paramString2.toString());
        return false;
      }
      ZipOutputStream localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramString2));
      localZipOutputStream.setLevel(3);
      localZipOutputStream.setEncoding("utf-8");
      readFullBody(paramString1, localZipOutputStream);
      localZipOutputStream.close();
      paramString1.close();
      boolean bool = checkSum(paramString2);
      this.checkSum.clear();
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public boolean write(File paramFile1, File paramFile2)
  {
    for (;;)
    {
      try
      {
        paramFile1 = new ZipFile(paramFile1, "utf-8");
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile2));
        writeHeader(localBufferedOutputStream);
        Enumeration localEnumeration = paramFile1.getEntriesInPhysicalOrder();
        if (localEnumeration.hasMoreElements())
        {
          Object localObject = (ZipEntry)localEnumeration.nextElement();
          if (((ZipEntry)localObject).getName().contains("../")) {
            continue;
          }
          if (this.exceptFiles != null)
          {
            Iterator localIterator = this.exceptFiles.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!((ZipEntry)localObject).getName().startsWith(str)) {
                continue;
              }
              System.out.println(((ZipEntry)localObject).getName());
              i = 1;
              break label253;
            }
          }
          else
          {
            if (((ZipEntry)localObject).isDirectory())
            {
              writeBody(localBufferedOutputStream, (ZipEntry)localObject, 2);
              continue;
            }
            writeBody(localBufferedOutputStream, (ZipEntry)localObject, 1);
            localObject = paramFile1.getInputStream((ZipEntry)localObject);
            writeBodyData(localBufferedOutputStream, (InputStream)localObject, VersionConfiguration.BYTE_BUFFER);
            ((InputStream)localObject).close();
          }
        }
        else
        {
          localBufferedOutputStream.close();
          paramFile1.close();
          paramFile1 = new File(paramFile2.getAbsolutePath());
          return (paramFile1.exists()) && (paramFile1.length() > 0L);
        }
      }
      catch (Exception paramFile1)
      {
        paramFile1.printStackTrace();
        return false;
      }
      int i = 0;
      label253:
      if (i == 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.v.QarHelperV1
 * JD-Core Version:    0.7.0.1
 */