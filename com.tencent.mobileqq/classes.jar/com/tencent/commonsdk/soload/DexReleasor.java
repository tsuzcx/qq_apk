package com.tencent.commonsdk.soload;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.zip.ZipException;

public class DexReleasor
  implements MyZipConstants
{
  public static final int APK_DEX_COUNT = 11;
  private static final String DEX_NAME = "classes.dex";
  private static DexReleasor dexOperator = null;
  public static String[] sExtraDexes = new String[10];
  public static String[] sExtraJarDexes = new String[10];
  byte[] buffer = new byte[81920];
  byte[] commentOfEOCD = null;
  private String mDstPath;
  private final LinkedHashMap<String, MyZipEntry> mEntries = new LinkedHashMap();
  RandomAccessFile mRaf = null;
  private String mSrcFile;
  
  static
  {
    int i = 0;
    while (i < 10)
    {
      sExtraDexes[i] = ("classes" + (i + 2) + ".dex");
      sExtraJarDexes[i] = ("classes" + (i + 2) + ".jar");
      i += 1;
    }
  }
  
  public DexReleasor(String paramString1, String paramString2)
  {
    this.mSrcFile = paramString1;
    this.mDstPath = paramString2;
    try
    {
      read();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static DexReleasor getInstance(String paramString1, String paramString2)
  {
    try
    {
      if (dexOperator == null) {
        dexOperator = new DexReleasor(paramString1, paramString2);
      }
      paramString1 = dexOperator;
      return paramString1;
    }
    finally {}
  }
  
  private boolean read()
  {
    long l1 = 0L;
    try
    {
      File localFile1 = new File(this.mSrcFile);
      if (!localFile1.exists()) {
        throw new IOException("no exist " + this.mSrcFile);
      }
    }
    finally {}
    this.mRaf = new RandomAccessFile(localFile2, "r");
    long l2 = this.mRaf.length() - 22L;
    Object localObject;
    int i;
    int j;
    int n;
    int k;
    int m;
    int i1;
    label245:
    long l3;
    label283:
    byte[] arrayOfByte;
    if (l2 < 0L)
    {
      throw new ZipException("too short to be Zip");
      do
      {
        this.mRaf.seek(l2);
        if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
        {
          localObject = new byte[18];
          this.mRaf.readFully((byte[])localObject);
          localObject = HeapBufferIterator.iterator((byte[])localObject, 0, localObject.length, ByteOrder.LITTLE_ENDIAN);
          i = ((BufferIterator)localObject).readShort();
          j = ((BufferIterator)localObject).readShort();
          n = ((BufferIterator)localObject).readShort();
          k = ((BufferIterator)localObject).readShort();
          l1 = ((BufferIterator)localObject).readInt();
          m = ((BufferIterator)localObject).readInt();
          i1 = ((BufferIterator)localObject).readShort();
          if (i1 <= 0) {
            break;
          }
          localObject = new byte[i1];
          if (this.mRaf.read((byte[])localObject, 0, localObject.length) == -1) {
            break;
          }
          this.commentOfEOCD = ((byte[])localObject);
          break;
          throw new ZipException("spanned archives not supported");
        }
        l3 = l2 - 1L;
        l2 = l3;
      } while (l3 >= l1);
      throw new ZipException("EOCD not found; not a Zip archive?");
      localObject = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, m), 4096);
      arrayOfByte = new byte[46];
      j = 0;
      i = 0;
    }
    for (;;)
    {
      label322:
      boolean bool;
      if (i == 10)
      {
        bool = readLocalHeader(this.mRaf);
        label338:
        return bool;
      }
      label495:
      do
      {
        MyZipEntry localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject);
        String str = localMyZipEntry.getName();
        m = i;
        if (!TextUtils.isEmpty(str))
        {
          String[] arrayOfString = sExtraDexes;
          i1 = arrayOfString.length;
          k = 0;
          for (;;)
          {
            m = i;
            if (k >= i1) {
              break;
            }
            m = i;
            if (TextUtils.equals(str, arrayOfString[k]))
            {
              this.mEntries.put(str, localMyZipEntry);
              m = i + 1;
            }
            k += 1;
            i = m;
          }
        }
        j += 1;
        i = m;
        break label495;
        bool = false;
        break label338;
        do
        {
          l1 = l3;
          break;
          l3 = l2 - 65536L;
        } while (l3 >= 0L);
        break;
        if ((n != k) || (i != 0)) {
          break label245;
        }
        if (j == 0) {
          break label283;
        }
        break label245;
        if (j >= n) {
          break label322;
        }
      } while (i != 10);
    }
  }
  
  private boolean readLocalHeader(RandomAccessFile paramRandomAccessFile)
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[30];
        Iterator localIterator = this.mEntries.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label229;
        }
        Object localObject = (String)localIterator.next();
        localObject = (MyZipEntry)this.mEntries.get(localObject);
        Streams.readFully(new BufferedInputStream(new MyZipFile.RAFStream(paramRandomAccessFile, ((MyZipEntry)localObject).mLocalHeaderRelOffset), 4096), arrayOfByte, 0, arrayOfByte.length);
        HeapBufferIterator localHeapBufferIterator = HeapBufferIterator.iterator(arrayOfByte, 0, arrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
        i = localHeapBufferIterator.readInt();
        if (i != 67324752L)
        {
          bool = false;
          return bool;
        }
        localHeapBufferIterator.skip(2);
        if ((localHeapBufferIterator.readShort() & 0x8) != 0)
        {
          bool = true;
          localHeapBufferIterator.skip(18);
          i = localHeapBufferIterator.readShort();
          int j = localHeapBufferIterator.readShort();
          ((MyZipEntry)localObject).hasDD = bool;
          long l1 = j + (i + 30);
          long l2 = ((MyZipEntry)localObject).compressedSize;
          if (!bool) {
            break label224;
          }
          i = 16;
          ((MyZipEntry)localObject).mLocContentSize = (l1 + l2 + i);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label224:
      int i = 0;
      continue;
      label229:
      boolean bool = true;
    }
  }
  
  private long writeLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private int writeShort(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  private File writeToJar(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString2 = (MyZipEntry)this.mEntries.get(paramString2);
        if (paramString2 == null)
        {
          paramString1 = null;
          return paramString1;
        }
        paramString1 = new File(this.mDstPath + paramString1);
        if (!paramString1.exists()) {
          paramString1.createNewFile();
        }
        FileOutputStream localFileOutputStream = new FileOutputStream(paramString1);
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localFileOutputStream);
        this.mRaf.seek(paramString2.mLocalHeaderRelOffset);
        i = this.mRaf.read(this.buffer, 0, 26);
        if ((i == -1) || (i != 26))
        {
          localBufferedOutputStream.close();
          localFileOutputStream.close();
          paramString1 = null;
          continue;
        }
        localBufferedOutputStream.write(this.buffer, 0, 26);
        byte[] arrayOfByte = "classes.dex".getBytes("UTF-8");
        int j = arrayOfByte.length;
        writeShort(localBufferedOutputStream, j);
        writeShort(localBufferedOutputStream, paramString2.extraLength);
        localBufferedOutputStream.write(arrayOfByte);
        this.mRaf.seek(paramString2.mLocalHeaderRelOffset + 30L + paramString2.nameLength);
        long l2 = paramString2.mLocContentSize - 30L - paramString2.nameLength;
        long l1 = 0L;
        ByteArrayOutputStream localByteArrayOutputStream;
        if (81920L + l1 <= l2)
        {
          i = this.mRaf.read(this.buffer);
          if (i != -1) {}
        }
        else
        {
          i = (int)(l2 - l1);
          int k = this.mRaf.read(this.buffer, 0, i);
          if ((k == -1) || (k != i)) {
            break label744;
          }
          localBufferedOutputStream.write(this.buffer, 0, i);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          writeLong(localByteArrayOutputStream, 33639248L);
          writeShort(localByteArrayOutputStream, paramString2.version);
          writeShort(localByteArrayOutputStream, paramString2.versionMinimum);
          writeShort(localByteArrayOutputStream, paramString2.flags);
          writeShort(localByteArrayOutputStream, paramString2.compressionMethod);
          writeShort(localByteArrayOutputStream, paramString2.time);
          writeShort(localByteArrayOutputStream, paramString2.modDate);
          writeLong(localByteArrayOutputStream, paramString2.crc);
          writeLong(localByteArrayOutputStream, paramString2.compressedSize);
          writeLong(localByteArrayOutputStream, paramString2.size);
          writeShort(localByteArrayOutputStream, j);
          writeShort(localByteArrayOutputStream, paramString2.extraLength);
          writeShort(localByteArrayOutputStream, paramString2.commentLength);
          writeShort(localByteArrayOutputStream, paramString2.diskNumbers);
          writeShort(localByteArrayOutputStream, paramString2.internalFileAttri);
          writeLong(localByteArrayOutputStream, paramString2.externalFileAttri);
          writeLong(localByteArrayOutputStream, 0L);
          localByteArrayOutputStream.write(arrayOfByte);
          if (paramString2.extraLength > 0) {
            localByteArrayOutputStream.write(paramString2.extra);
          }
          if (paramString2.commentLength > 0) {
            localByteArrayOutputStream.write(paramString2.comment.getBytes());
          }
          if (!paramString2.hasDD) {
            break label749;
          }
          i = 16;
          l1 = i + 30 + j + paramString2.extraLength;
          l2 = paramString2.compressedSize;
          i = localByteArrayOutputStream.size();
          writeLong(localByteArrayOutputStream, 101010256L);
          writeShort(localByteArrayOutputStream, 0);
          writeShort(localByteArrayOutputStream, 0);
          writeShort(localByteArrayOutputStream, 1);
          writeShort(localByteArrayOutputStream, 1);
          writeLong(localByteArrayOutputStream, i);
          writeLong(localByteArrayOutputStream, l1 + l2);
          if (this.commentOfEOCD == null) {
            continue;
          }
          writeShort(localByteArrayOutputStream, this.commentOfEOCD.length);
          localByteArrayOutputStream.write(this.commentOfEOCD);
          localByteArrayOutputStream.writeTo(localBufferedOutputStream);
          if (localBufferedOutputStream != null)
          {
            localBufferedOutputStream.flush();
            localBufferedOutputStream.close();
          }
          if (localFileOutputStream == null) {
            break label741;
          }
          localFileOutputStream.flush();
          localFileOutputStream.close();
          break label741;
        }
        localBufferedOutputStream.write(this.buffer);
        l1 += i;
        continue;
        writeShort(localByteArrayOutputStream, 0);
        continue;
        continue;
      }
      finally {}
      label741:
      label744:
      paramString1 = null;
      continue;
      label749:
      int i = 0;
    }
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 67	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 67	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 77	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   24: aconst_null
    //   25: putstatic 60	com/tencent/commonsdk/soload/DexReleasor:dexOperator	Lcom/tencent/commonsdk/soload/DexReleasor;
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 67	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   35: goto -16 -> 19
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 67	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	DexReleasor
    //   29	1	1	localIOException	IOException
    //   38	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	29	java/io/IOException
    //   7	14	38	finally
  }
  
  public long getEntryCrcCode(String paramString)
  {
    paramString = (MyZipEntry)this.mEntries.get(paramString);
    if (paramString != null) {
      return paramString.crc;
    }
    return -1L;
  }
  
  /* Error */
  public File releaseDex(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 382	com/tencent/commonsdk/soload/DexReleasor:writeToJar	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: getstatic 34	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   14: bipush 9
    //   16: aaload
    //   17: aload_2
    //   18: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +9 -> 30
    //   24: aload_0
    //   25: invokevirtual 387	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   28: aload_3
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_3
    //   42: astore_1
    //   43: getstatic 34	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   46: bipush 9
    //   48: aaload
    //   49: aload_2
    //   50: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq -23 -> 30
    //   56: aload_0
    //   57: invokevirtual 387	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   60: aload_3
    //   61: astore_1
    //   62: goto -32 -> 30
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: getstatic 34	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   74: bipush 9
    //   76: aaload
    //   77: aload_2
    //   78: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 387	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	DexReleasor
    //   0	90	1	paramString1	String
    //   0	90	2	paramString2	String
    //   8	53	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	9	34	java/io/IOException
    //   11	28	65	finally
    //   43	60	65	finally
    //   71	88	65	finally
    //   88	90	65	finally
    //   2	9	70	finally
    //   35	39	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.DexReleasor
 * JD-Core Version:    0.7.0.1
 */