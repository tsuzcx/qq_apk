package com.tencent.TMG.ptt;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.UUID;

public class PttManager
{
  private static final String TAG = "PTTManager";
  private static PttManager s_instance = null;
  private Context context = null;
  Recorder.OnQQRecorderListener listener = new PttManager.4(this);
  private PCMPlayer pcmPlayer = null;
  private PttListener.RecordFileListener recordFileListener = null;
  private Recorder recorder = null;
  
  private PttManager(Context paramContext)
  {
    this.recorder = new Recorder(paramContext);
    this.pcmPlayer = new PCMPlayer();
    this.recorder.setQQRecorderListener(this.listener);
  }
  
  public static PttManager createInstance(Context paramContext)
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null)
      {
        s_instance = new PttManager(paramContext);
        s_instance.context = paramContext;
      }
      return s_instance;
    }
    finally {}
  }
  
  /* Error */
  public static int getFileSize(String paramString)
  {
    // Byte code:
    //   0: new 68	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_3
    //   13: aload 4
    //   15: invokevirtual 75	java/io/FileInputStream:available	()I
    //   18: istore_2
    //   19: iload_2
    //   20: istore_1
    //   21: aload 4
    //   23: ifnull +10 -> 33
    //   26: aload 4
    //   28: invokevirtual 78	java/io/FileInputStream:close	()V
    //   31: iload_2
    //   32: istore_1
    //   33: ldc 8
    //   35: ldc 80
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: iload_1
    //   48: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: invokestatic 98	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: iload_1
    //   60: ireturn
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   66: iload_2
    //   67: istore_1
    //   68: goto -35 -> 33
    //   71: astore 5
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: ldc 8
    //   81: new 103	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   88: ldc 106
    //   90: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload 4
    //   106: astore_3
    //   107: aload 5
    //   109: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   112: aload 4
    //   114: ifnull +53 -> 167
    //   117: aload 4
    //   119: invokevirtual 78	java/io/FileInputStream:close	()V
    //   122: iconst_0
    //   123: istore_1
    //   124: goto -91 -> 33
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   132: iconst_0
    //   133: istore_1
    //   134: goto -101 -> 33
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 78	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   155: goto -7 -> 148
    //   158: astore_0
    //   159: goto -19 -> 140
    //   162: astore 5
    //   164: goto -88 -> 76
    //   167: iconst_0
    //   168: istore_1
    //   169: goto -136 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramString	String
    //   20	149	1	i	int
    //   18	49	2	j	int
    //   12	1	3	localFileInputStream1	java.io.FileInputStream
    //   61	2	3	localIOException1	java.io.IOException
    //   78	29	3	localFileInputStream2	java.io.FileInputStream
    //   127	2	3	localIOException2	java.io.IOException
    //   139	6	3	localObject	Object
    //   150	2	3	localIOException3	java.io.IOException
    //   8	110	4	localFileInputStream3	java.io.FileInputStream
    //   71	37	5	localIOException4	java.io.IOException
    //   162	1	5	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	31	61	java/io/IOException
    //   0	10	71	java/io/IOException
    //   117	122	127	java/io/IOException
    //   0	10	137	finally
    //   144	148	150	java/io/IOException
    //   13	19	158	finally
    //   79	104	158	finally
    //   107	112	158	finally
    //   13	19	162	java/io/IOException
  }
  
  public static PttManager getInstance()
  {
    return s_instance;
  }
  
  public int cancelRecording()
  {
    this.recorder.cancel();
    return 0;
  }
  
  public void downloadFile(String paramString1, String paramString2, PttListener.DownloadFileListener paramDownloadFileListener)
  {
    TokenFetcher.getInstance().getDownloadToken(paramString1, new PttManager.2(this, paramString2, paramDownloadFileListener, paramString1));
  }
  
  public String getDeviceInfo()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.SDK;
    int i = NetworkProvider.getNetTypeName(this.context);
    return str1 + "_" + str2 + "_" + i;
  }
  
  public int getFileSeconds(String paramString)
  {
    int i = this.pcmPlayer.getSilkFilePlayTime(paramString);
    Log.i("PTTManager", String.format("getFileSeconds| time=%s", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  public int playRecordedFile(String paramString, PttListener.PlayFileListener paramPlayFileListener)
  {
    if (paramPlayFileListener == null) {
      return 20483;
    }
    if (this.recorder.isRecording())
    {
      Log.e("PTTManager", "now is recording,do not play!");
      paramPlayFileListener.onCompleted(4099, null);
      return 0;
    }
    if (this.pcmPlayer.isPlaying())
    {
      Log.e("PTTManager", "pcm is playing, not play again!");
      paramPlayFileListener.onCompleted(20482, null);
      return 0;
    }
    try
    {
      this.pcmPlayer.initPCMPlayer();
      this.pcmPlayer.play(paramString, paramPlayFileListener);
      return 0;
    }
    catch (Exception paramString)
    {
      Log.e("PTTManager", "play recording failed! e = " + paramString);
      paramPlayFileListener.onCompleted(20481, null);
    }
    return 0;
  }
  
  public void setAccessToken(String paramString)
  {
    TokenFetcher.AppInfo localAppInfo2 = TokenFetcher.getInstance().getAppInfo();
    TokenFetcher.AppInfo localAppInfo1 = localAppInfo2;
    if (localAppInfo2 == null) {
      localAppInfo1 = new TokenFetcher.AppInfo();
    }
    localAppInfo1.accesstoken = paramString;
    TokenFetcher.getInstance().setAppInfo(localAppInfo1);
  }
  
  public void setAppInfo(String paramString1, String paramString2, String paramString3)
  {
    TokenFetcher.AppInfo localAppInfo2 = TokenFetcher.getInstance().getAppInfo();
    TokenFetcher.AppInfo localAppInfo1 = localAppInfo2;
    if (localAppInfo2 == null) {
      localAppInfo1 = new TokenFetcher.AppInfo();
    }
    localAppInfo1.sdk_appid = paramString1;
    localAppInfo1.appidat3rd = paramString1;
    localAppInfo1.accounttype = paramString2;
    localAppInfo1.identifier = paramString3;
    TokenFetcher.getInstance().setAppInfo(localAppInfo1);
  }
  
  public void setMaxRecordTime(int paramInt)
  {
    this.recorder.setMaxRecorderTime(paramInt);
  }
  
  public int startRecording(String paramString, PttListener.RecordFileListener paramRecordFileListener)
  {
    int i = 0;
    if (paramRecordFileListener == null) {
      i = 4097;
    }
    String str;
    do
    {
      return i;
      if (this.recorder.isRecording())
      {
        Log.e("PTTManager", "is recording , not do again!");
        paramRecordFileListener.onCompleted(4099, null);
        return 0;
      }
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = FileManager.getInstance().genSilkFileName();
      }
      this.recordFileListener = paramRecordFileListener;
    } while (!this.recorder.initRecording());
    this.recorder.start(str);
    return 0;
  }
  
  public int stopPlayFile()
  {
    this.pcmPlayer.stop();
    return 0;
  }
  
  public int stopRecording()
  {
    this.recorder.stop();
    return 0;
  }
  
  public void uploadFile(String paramString, PttListener.UploadFileListener paramUploadFileListener)
  {
    String str = UUID.randomUUID().toString();
    TokenFetcher.getInstance().getUploadToken(str, new PttManager.1(this, paramString, paramUploadFileListener));
  }
  
  public void voice2Text(String paramString, PttListener.Voice2TextListener paramVoice2TextListener)
  {
    TokenFetcher.getInstance().voice2Text(paramString, new PttManager.3(this, paramVoice2TextListener, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager
 * JD-Core Version:    0.7.0.1
 */