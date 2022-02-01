package com.tencent.biz.qqstory.model.pendant;

import android.os.AsyncTask;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import java.io.File;

public class FileDownloadTask
  extends AsyncTask<FileDownloadTask.Input, FileDownloadTask.Progress, FileDownloadTask.Output>
{
  public final Downloader a;
  
  public FileDownloadTask(Downloader paramDownloader)
  {
    if (paramDownloader != null)
    {
      this.a = paramDownloader;
      return;
    }
    throw new IllegalArgumentException("downloader should not be null");
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore_3
    //   6: new 29	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: astore_0
    //   17: ldc 32
    //   19: invokestatic 38	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore 4
    //   24: aload_2
    //   25: astore_0
    //   26: aload_2
    //   27: aload_3
    //   28: invokevirtual 44	java/io/InputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +16 -> 49
    //   36: aload_2
    //   37: astore_0
    //   38: aload 4
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 48	java/security/MessageDigest:update	([BII)V
    //   46: goto -22 -> 24
    //   49: aload_2
    //   50: astore_0
    //   51: aload 4
    //   53: invokevirtual 52	java/security/MessageDigest:digest	()[B
    //   56: invokestatic 55	com/tencent/biz/qqstory/model/pendant/FileDownloadTask:a	([B)Ljava/lang/String;
    //   59: astore_3
    //   60: aload_2
    //   61: invokevirtual 58	java/io/InputStream:close	()V
    //   64: aload_3
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_0
    //   69: goto +25 -> 94
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_0
    //   76: ldc 60
    //   78: ldc 62
    //   80: invokestatic 67	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +7 -> 91
    //   87: aload_2
    //   88: invokevirtual 58	java/io/InputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_2
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 58	java/io/InputStream:close	()V
    //   102: goto +5 -> 107
    //   105: aload_2
    //   106: athrow
    //   107: goto -2 -> 105
    //   110: astore_0
    //   111: goto -39 -> 72
    //   114: astore_0
    //   115: goto -41 -> 74
    //   118: astore_0
    //   119: aload_3
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: goto -23 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   31	12	1	i	int
    //   14	47	2	localFileInputStream	java.io.FileInputStream
    //   66	1	2	localObject1	Object
    //   73	15	2	localObject2	Object
    //   93	13	2	localObject3	Object
    //   5	115	3	localObject4	Object
    //   22	30	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   0	15	66	finally
    //   17	24	93	finally
    //   26	32	93	finally
    //   38	46	93	finally
    //   51	60	93	finally
    //   76	83	93	finally
    //   0	15	110	java/lang/Exception
    //   17	24	114	java/lang/Exception
    //   26	32	114	java/lang/Exception
    //   38	46	114	java/lang/Exception
    //   51	60	114	java/lang/Exception
    //   60	64	118	java/io/IOException
    //   87	91	121	java/io/IOException
    //   98	102	124	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(arrayOfChar[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(String paramString)
  {
    SLog.b("FileDownloadTask", paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      return false;
    }
    if (((File)localObject).isDirectory()) {
      return false;
    }
    if (paramString2 == null) {
      return true;
    }
    paramString1 = a(paramString1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expectedMd5 = ");
    ((StringBuilder)localObject).append(paramString2);
    SLog.b("FileDownloadTask", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file Md5    = ");
    ((StringBuilder)localObject).append(paramString1);
    SLog.b("FileDownloadTask", ((StringBuilder)localObject).toString());
    return paramString2.equalsIgnoreCase(paramString1);
  }
  
  protected FileDownloadTask.Output a(FileDownloadTask.Input... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (a(paramVarArgs.b, paramVarArgs.c))
    {
      a("already has local file, don't need download");
      return new FileDownloadTask.Output(paramVarArgs, 0, "has local file already");
    }
    this.a.a(new FileDownloadTask.1(this, paramVarArgs));
    int i = this.a.a(paramVarArgs.a, paramVarArgs.b, 0L);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("download finish : ");
    localStringBuilder1.append(i);
    a(localStringBuilder1.toString());
    if ((i == 0) && (!a(paramVarArgs.b, paramVarArgs.c)))
    {
      a("delete the downloaded file because of md5 mismatch");
      try
      {
        FileUtils.d(paramVarArgs.b);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return new FileDownloadTask.Output(paramVarArgs, -1, "file md5 mismatch");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("error=");
    localStringBuilder2.append(i);
    return new FileDownloadTask.Output(paramVarArgs, i, localStringBuilder2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask
 * JD-Core Version:    0.7.0.1
 */