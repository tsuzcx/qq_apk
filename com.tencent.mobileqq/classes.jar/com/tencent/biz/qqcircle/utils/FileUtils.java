package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class FileUtils
{
  public static String a = "unknown_";
  
  public static String a()
  {
    if ((!"mounted".equals(Environment.getExternalStorageState())) && (Environment.isExternalStorageRemovable())) {
      return RFApplication.getApplication().getCacheDir().getPath();
    }
    if (RFApplication.getApplication().getExternalCacheDir() == null) {
      return null;
    }
    return RFApplication.getApplication().getExternalCacheDir().getPath();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(Integer.toString(paramArrayOfByte[i] & 0xFF));
        str = localStringBuilder.toString();
        i += 1;
      }
      i = Integer.parseInt(str);
      if (i != 6677)
      {
        if (i != 7173)
        {
          if (i != 7784)
          {
            if (i != 7790)
            {
              if (i != 8075)
              {
                if (i != 8273)
                {
                  if (i != 8297)
                  {
                    if (i != 13780)
                    {
                      if (i != 255216)
                      {
                        paramArrayOfByte = new StringBuilder();
                        paramArrayOfByte.append(a);
                        paramArrayOfByte.append(str);
                        return paramArrayOfByte.toString();
                      }
                      return "jpg";
                    }
                    return "png";
                  }
                  return "rar";
                }
                return "webp";
              }
              return "zip";
            }
            return "exe";
          }
          return "midi";
        }
        return "gif";
      }
      return "bmp";
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(a);
    paramArrayOfByte.append("");
    return paramArrayOfByte.toString();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +131 -> 132
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: new 122	java/io/BufferedOutputStream
    //   18: dup
    //   19: new 124	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: ldc 126
    //   29: invokespecial 129	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   32: astore_1
    //   33: aload_0
    //   34: getstatic 135	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   37: bipush 70
    //   39: aload_1
    //   40: invokevirtual 141	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   43: istore_2
    //   44: aload_1
    //   45: invokevirtual 146	java/io/OutputStream:flush	()V
    //   48: aload_1
    //   49: invokevirtual 149	java/io/OutputStream:close	()V
    //   52: iload_2
    //   53: ireturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   59: iload_2
    //   60: ireturn
    //   61: astore_0
    //   62: aload_1
    //   63: astore_3
    //   64: goto +46 -> 110
    //   67: astore_3
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: astore_1
    //   72: goto +11 -> 83
    //   75: astore_0
    //   76: goto +34 -> 110
    //   79: astore_1
    //   80: aload 4
    //   82: astore_0
    //   83: aload_0
    //   84: astore_3
    //   85: aload_1
    //   86: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   89: aload_0
    //   90: ifnull +18 -> 108
    //   93: aload_0
    //   94: invokevirtual 146	java/io/OutputStream:flush	()V
    //   97: aload_0
    //   98: invokevirtual 149	java/io/OutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: aload_3
    //   111: ifnull +19 -> 130
    //   114: aload_3
    //   115: invokevirtual 146	java/io/OutputStream:flush	()V
    //   118: aload_3
    //   119: invokevirtual 149	java/io/OutputStream:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: athrow
    //   132: iconst_0
    //   133: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramBitmap	android.graphics.Bitmap
    //   0	134	1	paramString	String
    //   43	17	2	bool	boolean
    //   14	50	3	str	String
    //   67	4	3	localIOException	IOException
    //   84	35	3	localBitmap	android.graphics.Bitmap
    //   11	70	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	52	54	java/io/IOException
    //   33	44	61	finally
    //   33	44	67	java/io/IOException
    //   15	33	75	finally
    //   85	89	75	finally
    //   15	33	79	java/io/IOException
    //   93	101	103	java/io/IOException
    //   114	122	125	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: ifnull +244 -> 250
    //   9: new 158	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 161	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 165	java/io/File:length	()J
    //   26: l2i
    //   27: newarray byte
    //   29: astore 5
    //   31: iconst_0
    //   32: istore_1
    //   33: aload 4
    //   35: astore_3
    //   36: iload_1
    //   37: aload 5
    //   39: arraylength
    //   40: if_icmpge +31 -> 71
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: aload 5
    //   50: iload_1
    //   51: aload 5
    //   53: arraylength
    //   54: iload_1
    //   55: isub
    //   56: invokevirtual 171	java/io/InputStream:read	([BII)I
    //   59: istore_2
    //   60: iload_2
    //   61: iflt +10 -> 71
    //   64: iload_1
    //   65: iload_2
    //   66: iadd
    //   67: istore_1
    //   68: goto -35 -> 33
    //   71: aload 4
    //   73: astore_3
    //   74: iload_1
    //   75: aload 5
    //   77: arraylength
    //   78: if_icmpge +32 -> 110
    //   81: aload 6
    //   83: astore_0
    //   84: aload 4
    //   86: astore_3
    //   87: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +23 -> 113
    //   93: aload 4
    //   95: astore_3
    //   96: ldc 178
    //   98: iconst_2
    //   99: ldc 180
    //   101: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore_0
    //   107: goto +6 -> 113
    //   110: aload 5
    //   112: astore_0
    //   113: aload 4
    //   115: invokevirtual 185	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore 4
    //   122: aload_0
    //   123: astore_3
    //   124: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +123 -> 250
    //   130: ldc 178
    //   132: iconst_2
    //   133: ldc 187
    //   135: aload 4
    //   137: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: areturn
    //   142: astore_0
    //   143: goto +24 -> 167
    //   146: astore_0
    //   147: aconst_null
    //   148: astore 5
    //   150: goto +17 -> 167
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: goto +65 -> 221
    //   159: astore_0
    //   160: aconst_null
    //   161: astore 4
    //   163: aload 4
    //   165: astore 5
    //   167: aload 4
    //   169: astore_3
    //   170: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +15 -> 188
    //   176: aload 4
    //   178: astore_3
    //   179: ldc 178
    //   181: iconst_2
    //   182: ldc 193
    //   184: aload_0
    //   185: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload 4
    //   190: ifnull +27 -> 217
    //   193: aload 4
    //   195: invokevirtual 185	java/io/InputStream:close	()V
    //   198: goto +19 -> 217
    //   201: astore_0
    //   202: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 178
    //   210: iconst_2
    //   211: ldc 187
    //   213: aload_0
    //   214: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload 5
    //   219: areturn
    //   220: astore_0
    //   221: aload_3
    //   222: ifnull +26 -> 248
    //   225: aload_3
    //   226: invokevirtual 185	java/io/InputStream:close	()V
    //   229: goto +19 -> 248
    //   232: astore_3
    //   233: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +12 -> 248
    //   239: ldc 178
    //   241: iconst_2
    //   242: ldc 187
    //   244: aload_3
    //   245: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_0
    //   249: athrow
    //   250: aload_3
    //   251: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramFile	File
    //   32	47	1	i	int
    //   59	8	2	j	int
    //   1	225	3	localObject1	Object
    //   232	19	3	localIOException1	IOException
    //   17	97	4	localFileInputStream	java.io.FileInputStream
    //   120	16	4	localIOException2	IOException
    //   161	33	4	localObject2	Object
    //   29	189	5	localObject3	Object
    //   3	102	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	120	java/io/IOException
    //   36	43	142	java/lang/Exception
    //   46	60	142	java/lang/Exception
    //   74	81	142	java/lang/Exception
    //   87	93	142	java/lang/Exception
    //   96	104	142	java/lang/Exception
    //   22	31	146	java/lang/Exception
    //   9	19	153	finally
    //   9	19	159	java/lang/Exception
    //   193	198	201	java/io/IOException
    //   22	31	220	finally
    //   36	43	220	finally
    //   46	60	220	finally
    //   74	81	220	finally
    //   87	93	220	finally
    //   96	104	220	finally
    //   170	176	220	finally
    //   179	188	220	finally
    //   225	229	232	java/io/IOException
  }
  
  public static File b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: ldc 55
    //   2: astore_1
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_2
    //   11: new 158	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_1
    //   21: astore_2
    //   22: aload_1
    //   23: astore 4
    //   25: iconst_2
    //   26: newarray byte
    //   28: astore 5
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: astore_2
    //   34: aload_1
    //   35: astore 4
    //   37: aload_3
    //   38: aload 5
    //   40: invokevirtual 212	java/io/FileInputStream:read	([B)I
    //   43: iconst_m1
    //   44: if_icmpeq +14 -> 58
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: astore 4
    //   52: aload 5
    //   54: invokestatic 214	com/tencent/biz/qqcircle/utils/FileUtils:a	([B)Ljava/lang/String;
    //   57: astore_0
    //   58: aload_0
    //   59: astore_2
    //   60: aload_0
    //   61: astore 4
    //   63: aload_3
    //   64: invokevirtual 215	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 215	java/io/FileInputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: aload_3
    //   77: astore_2
    //   78: goto +75 -> 153
    //   81: astore 4
    //   83: aload_3
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: goto +22 -> 112
    //   93: astore_2
    //   94: aload_3
    //   95: astore_0
    //   96: aload 4
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: goto +35 -> 136
    //   104: astore_0
    //   105: goto +48 -> 153
    //   108: astore_3
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: astore_2
    //   114: aload_3
    //   115: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   118: aload_1
    //   119: astore_2
    //   120: aload_0
    //   121: ifnull +30 -> 151
    //   124: aload_1
    //   125: astore_2
    //   126: aload_0
    //   127: invokevirtual 215	java/io/FileInputStream:close	()V
    //   130: aload_1
    //   131: areturn
    //   132: astore_3
    //   133: aload 5
    //   135: astore_0
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: invokevirtual 216	java/io/FileNotFoundException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_0
    //   145: ifnull +6 -> 151
    //   148: goto -24 -> 124
    //   151: aload_2
    //   152: areturn
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 215	java/io/FileInputStream:close	()V
    //   161: goto +5 -> 166
    //   164: aload_0
    //   165: athrow
    //   166: goto -2 -> 164
    //   169: astore_0
    //   170: aload_2
    //   171: areturn
    //   172: astore_1
    //   173: goto -12 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString	String
    //   2	141	1	localObject1	Object
    //   172	1	1	localIOException1	IOException
    //   10	76	2	localObject2	Object
    //   93	7	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   113	58	2	localObject3	Object
    //   19	82	3	localObject4	Object
    //   108	7	3	localIOException2	IOException
    //   132	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	58	4	localObject5	Object
    //   81	29	4	localIOException3	IOException
    //   7	127	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	30	75	finally
    //   37	47	75	finally
    //   52	58	75	finally
    //   63	67	75	finally
    //   25	30	81	java/io/IOException
    //   37	47	81	java/io/IOException
    //   52	58	81	java/io/IOException
    //   63	67	81	java/io/IOException
    //   25	30	93	java/io/FileNotFoundException
    //   37	47	93	java/io/FileNotFoundException
    //   52	58	93	java/io/FileNotFoundException
    //   63	67	93	java/io/FileNotFoundException
    //   11	20	104	finally
    //   114	118	104	finally
    //   138	142	104	finally
    //   11	20	108	java/io/IOException
    //   11	20	132	java/io/FileNotFoundException
    //   69	73	169	java/io/IOException
    //   126	130	169	java/io/IOException
    //   157	161	172	java/io/IOException
  }
  
  public static boolean d(String paramString)
  {
    paramString = c(paramString);
    return (paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"));
  }
  
  public static long e(String paramString)
  {
    long l2 = 0L;
    if (paramString == null) {
      return 0L;
    }
    try
    {
      paramString = new File(paramString);
      long l1 = l2;
      if (paramString.exists())
      {
        l1 = l2;
        if (paramString.length() > 0L) {
          l1 = paramString.length();
        }
      }
      return l1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static void f(String paramString)
  {
    if (!a(paramString)) {
      try
      {
        b(paramString);
        return;
      }
      catch (IOException paramString)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createFileIfNotExits");
          localStringBuilder.append(paramString);
          QLog.i("FileUtils", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */