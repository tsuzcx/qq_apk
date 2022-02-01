package com.dataline.util.file;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil
{
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int i = FileManagerUtil.c(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    Bitmap localBitmap;
    if (i == 0) {
      localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    } else if (FileManagerUtil.c(paramString) == 2) {
      localBitmap = MediaStoreUtil.c(paramString, 150, 150);
    } else {
      localBitmap = null;
    }
    if (localBitmap == null) {
      return null;
    }
    try
    {
      paramContext = b(paramContext, paramString);
      try
      {
        com.tencent.mobileqq.filemanager.util.FileUtil.a(localBitmap, paramContext);
        localBitmap.recycle();
        MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
        return paramContext;
      }
      catch (IOException paramString) {}catch (FileNotFoundException paramString) {}
      paramString.printStackTrace();
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramContext = localObject1;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (FileNotFoundException paramString)
    {
      paramContext = localObject2;
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.b(paramContext));
    localStringBuilder.append("thumbnails/");
    paramContext = new VFSFile(localStringBuilder.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(FileManagerUtil.a(paramString1));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".JPG");
    return localStringBuilder.toString();
  }
  
  public static void a(VFSFile paramVFSFile)
  {
    if (paramVFSFile.isDirectory())
    {
      VFSFile[] arrayOfVFSFile = paramVFSFile.listFiles();
      if ((arrayOfVFSFile != null) && (arrayOfVFSFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfVFSFile.length)
        {
          a(arrayOfVFSFile[i]);
          i += 1;
        }
      }
    }
    paramVFSFile.delete();
  }
  
  public static void a(File paramFile)
  {
    a(new VFSFile(paramFile));
  }
  
  /* Error */
  public static void a(java.lang.StringBuffer paramStringBuffer, String paramString)
  {
    // Byte code:
    //   0: new 120	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 123	java/io/BufferedReader
    //   12: dup
    //   13: new 125	java/io/InputStreamReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore 5
    //   31: aload_1
    //   32: astore_3
    //   33: aload_2
    //   34: astore 4
    //   36: aload 5
    //   38: ifnull +74 -> 112
    //   41: aload_0
    //   42: aload 5
    //   44: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 5
    //   54: goto -23 -> 31
    //   57: astore_3
    //   58: aload_2
    //   59: astore_0
    //   60: goto +26 -> 86
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: goto +37 -> 103
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_0
    //   72: goto +14 -> 86
    //   75: astore_3
    //   76: aconst_null
    //   77: astore_0
    //   78: goto +25 -> 103
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: astore_1
    //   86: aload_3
    //   87: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: astore_3
    //   92: aload_0
    //   93: astore 4
    //   95: goto +17 -> 112
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 58	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_0
    //   108: astore 4
    //   110: aload_1
    //   111: astore_3
    //   112: aload 4
    //   114: ifnull +16 -> 130
    //   117: aload 4
    //   119: invokevirtual 142	java/io/BufferedReader:close	()V
    //   122: goto +8 -> 130
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   130: aload_3
    //   131: ifnull +13 -> 144
    //   134: aload_3
    //   135: invokevirtual 145	java/io/InputStream:close	()V
    //   138: return
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   144: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramStringBuffer	java.lang.StringBuffer
    //   0	145	1	paramString	String
    //   24	41	2	localBufferedReader	java.io.BufferedReader
    //   32	1	3	str1	String
    //   57	1	3	localIOException1	IOException
    //   63	1	3	localFileNotFoundException1	FileNotFoundException
    //   69	1	3	localIOException2	IOException
    //   75	1	3	localFileNotFoundException2	FileNotFoundException
    //   81	6	3	localIOException3	IOException
    //   91	1	3	str2	String
    //   98	6	3	localFileNotFoundException3	FileNotFoundException
    //   111	24	3	str3	String
    //   34	84	4	localObject	Object
    //   29	24	5	str4	String
    // Exception table:
    //   from	to	target	type
    //   25	31	57	java/io/IOException
    //   41	54	57	java/io/IOException
    //   25	31	63	java/io/FileNotFoundException
    //   41	54	63	java/io/FileNotFoundException
    //   9	25	69	java/io/IOException
    //   9	25	75	java/io/FileNotFoundException
    //   0	9	81	java/io/IOException
    //   0	9	98	java/io/FileNotFoundException
    //   117	122	125	java/io/IOException
    //   134	138	139	java/io/IOException
  }
  
  /* Error */
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_2
    //   8: iload 4
    //   10: ifeq +228 -> 238
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore 7
    //   19: aload_1
    //   20: invokevirtual 86	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   23: ifeq +19 -> 42
    //   26: aload_0
    //   27: invokevirtual 92	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   30: aload_1
    //   31: invokevirtual 92	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   34: invokestatic 154	com/tencent/mobileqq/richmediabrowser/report/FileCheckReport:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_1
    //   38: invokevirtual 114	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   41: pop
    //   42: new 156	com/tencent/mm/vfs/VFSFileOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 158	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   50: astore 6
    //   52: new 160	com/tencent/mm/vfs/VFSFileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 161	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   60: astore 5
    //   62: ldc 162
    //   64: newarray byte
    //   66: astore 7
    //   68: goto +24 -> 92
    //   71: astore_0
    //   72: goto +70 -> 142
    //   75: astore_0
    //   76: aload 5
    //   78: astore_1
    //   79: aload_0
    //   80: astore 5
    //   82: goto +73 -> 155
    //   85: sipush 4096
    //   88: newarray byte
    //   90: astore 7
    //   92: aload 5
    //   94: aload 7
    //   96: invokevirtual 166	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: iconst_m1
    //   102: if_icmpeq +20 -> 122
    //   105: aload 6
    //   107: aload 7
    //   109: iconst_0
    //   110: iload_3
    //   111: invokevirtual 170	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   114: aload 6
    //   116: invokevirtual 173	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   119: goto -27 -> 92
    //   122: aload 6
    //   124: invokevirtual 174	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   127: aload 5
    //   129: invokevirtual 175	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   132: goto +106 -> 238
    //   135: goto +103 -> 238
    //   138: astore_0
    //   139: aconst_null
    //   140: astore 5
    //   142: aload 6
    //   144: astore_1
    //   145: aload_0
    //   146: astore 6
    //   148: goto +66 -> 214
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 6
    //   157: astore_0
    //   158: goto +23 -> 181
    //   161: astore 6
    //   163: aconst_null
    //   164: astore_0
    //   165: aload 5
    //   167: astore_1
    //   168: aload_0
    //   169: astore 5
    //   171: goto +43 -> 214
    //   174: astore 5
    //   176: aconst_null
    //   177: astore_1
    //   178: aload 7
    //   180: astore_0
    //   181: aload 5
    //   183: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   186: aload_0
    //   187: ifnull +10 -> 197
    //   190: aload_0
    //   191: invokevirtual 174	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   194: goto +3 -> 197
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 175	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore 6
    //   209: aload_1
    //   210: astore 5
    //   212: aload_0
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +10 -> 225
    //   218: aload_1
    //   219: invokevirtual 174	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   222: goto +3 -> 225
    //   225: aload 5
    //   227: ifnull +8 -> 235
    //   230: aload 5
    //   232: invokevirtual 175	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   235: aload 6
    //   237: athrow
    //   238: aload_0
    //   239: invokevirtual 105	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   242: ifeq +91 -> 333
    //   245: aload_0
    //   246: invokevirtual 109	com/tencent/mm/vfs/VFSFile:listFiles	()[Lcom/tencent/mm/vfs/VFSFile;
    //   249: astore_0
    //   250: aload_1
    //   251: invokevirtual 178	com/tencent/mm/vfs/VFSFile:mkdir	()Z
    //   254: pop
    //   255: iload_2
    //   256: aload_0
    //   257: arraylength
    //   258: if_icmpge +75 -> 333
    //   261: aload_0
    //   262: iload_2
    //   263: aaload
    //   264: invokevirtual 182	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   267: astore 5
    //   269: new 61	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   276: astore 6
    //   278: aload 6
    //   280: aload_1
    //   281: invokevirtual 182	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   284: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 6
    //   290: ldc 94
    //   292: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 6
    //   298: aload_0
    //   299: iload_2
    //   300: aaload
    //   301: invokevirtual 188	com/tencent/mm/vfs/VFSFile:getName	()Ljava/lang/String;
    //   304: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 5
    //   310: new 75	com/tencent/mm/vfs/VFSFile
    //   313: dup
    //   314: aload 6
    //   316: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokespecial 82	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   322: invokestatic 190	com/dataline/util/file/FileUtil:a	(Lcom/tencent/mm/vfs/VFSFile;Lcom/tencent/mm/vfs/VFSFile;)Z
    //   325: pop
    //   326: iload_2
    //   327: iconst_1
    //   328: iadd
    //   329: istore_2
    //   330: goto -75 -> 255
    //   333: iconst_1
    //   334: ireturn
    //   335: astore 7
    //   337: goto -252 -> 85
    //   340: astore 6
    //   342: goto -215 -> 127
    //   345: astore 5
    //   347: goto -212 -> 135
    //   350: astore_0
    //   351: goto -154 -> 197
    //   354: astore_0
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_0
    //   358: goto -133 -> 225
    //   361: astore_0
    //   362: goto -127 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramVFSFile1	VFSFile
    //   0	365	1	paramVFSFile2	VFSFile
    //   7	323	2	i	int
    //   99	12	3	j	int
    //   4	5	4	bool	boolean
    //   14	127	5	localObject1	Object
    //   151	15	5	localIOException1	IOException
    //   169	1	5	localVFSFile1	VFSFile
    //   174	8	5	localIOException2	IOException
    //   210	99	5	localVFSFile2	VFSFile
    //   345	1	5	localIOException3	IOException
    //   50	106	6	localObject2	Object
    //   161	1	6	localObject3	Object
    //   207	29	6	localObject4	Object
    //   276	39	6	localStringBuilder	StringBuilder
    //   340	1	6	localIOException4	IOException
    //   17	162	7	arrayOfByte	byte[]
    //   335	1	7	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   62	68	71	finally
    //   85	92	71	finally
    //   92	100	71	finally
    //   105	119	71	finally
    //   62	68	75	java/io/IOException
    //   85	92	75	java/io/IOException
    //   92	100	75	java/io/IOException
    //   105	119	75	java/io/IOException
    //   52	62	138	finally
    //   52	62	151	java/io/IOException
    //   19	42	161	finally
    //   42	52	161	finally
    //   19	42	174	java/io/IOException
    //   42	52	174	java/io/IOException
    //   181	186	207	finally
    //   62	68	335	java/lang/OutOfMemoryError
    //   122	127	340	java/io/IOException
    //   127	132	345	java/io/IOException
    //   190	194	350	java/io/IOException
    //   201	205	354	java/io/IOException
    //   218	222	357	java/io/IOException
    //   230	235	361	java/io/IOException
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(new VFSFile(paramFile1), new VFSFile(paramFile2));
  }
  
  public static String b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.b(paramContext));
    localStringBuilder.append("thumbnails/");
    paramContext = new VFSFile(localStringBuilder.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(FileManagerUtil.a(paramString));
    localStringBuilder.append(".JPG");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.FileUtil
 * JD-Core Version:    0.7.0.1
 */