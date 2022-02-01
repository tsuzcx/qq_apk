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
  private static PttManager s_instance;
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
    if (s_instance == null) {
      try
      {
        if (s_instance == null)
        {
          s_instance = new PttManager(paramContext);
          s_instance.context = paramContext;
        }
      }
      finally {}
    }
    return s_instance;
  }
  
  /* Error */
  public static int getFileSize(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: new 68	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 75	java/io/FileInputStream:available	()I
    //   18: istore_1
    //   19: aload_3
    //   20: invokevirtual 78	java/io/FileInputStream:close	()V
    //   23: goto +99 -> 122
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   31: goto +91 -> 122
    //   34: astore_0
    //   35: aload_3
    //   36: astore_2
    //   37: goto +113 -> 150
    //   40: astore 4
    //   42: goto +12 -> 54
    //   45: astore_0
    //   46: goto +104 -> 150
    //   49: astore 4
    //   51: aload 5
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: new 83	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   63: astore 5
    //   65: aload_3
    //   66: astore_2
    //   67: aload 5
    //   69: ldc 86
    //   71: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_3
    //   76: astore_2
    //   77: aload 5
    //   79: aload_0
    //   80: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: astore_2
    //   86: ldc 8
    //   88: aload 5
    //   90: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload_3
    //   98: astore_2
    //   99: aload 4
    //   101: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   104: aload_3
    //   105: ifnull +15 -> 120
    //   108: aload_3
    //   109: invokevirtual 78	java/io/FileInputStream:close	()V
    //   112: goto +8 -> 120
    //   115: astore_2
    //   116: aload_2
    //   117: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   120: iconst_0
    //   121: istore_1
    //   122: ldc 8
    //   124: ldc 102
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: iload_1
    //   137: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic 114	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokestatic 117	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: iload_1
    //   149: ireturn
    //   150: aload_2
    //   151: ifnull +15 -> 166
    //   154: aload_2
    //   155: invokevirtual 78	java/io/FileInputStream:close	()V
    //   158: goto +8 -> 166
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   18	131	1	i	int
    //   4	1	2	localObject1	Object
    //   26	2	2	localIOException1	java.io.IOException
    //   36	63	2	localObject2	Object
    //   115	40	2	localIOException2	java.io.IOException
    //   161	2	2	localIOException3	java.io.IOException
    //   13	96	3	localObject3	Object
    //   40	1	4	localIOException4	java.io.IOException
    //   49	51	4	localIOException5	java.io.IOException
    //   1	88	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	23	26	java/io/IOException
    //   14	19	34	finally
    //   14	19	40	java/io/IOException
    //   5	14	45	finally
    //   56	65	45	finally
    //   67	75	45	finally
    //   77	84	45	finally
    //   86	97	45	finally
    //   99	104	45	finally
    //   5	14	49	java/io/IOException
    //   108	112	115	java/io/IOException
    //   154	158	161	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("_");
    localStringBuilder.append(str2);
    localStringBuilder.append("_");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play recording failed! e = ");
      localStringBuilder.append(paramString);
      Log.e("PTTManager", localStringBuilder.toString());
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
    if (paramRecordFileListener == null) {
      return 4097;
    }
    if (this.recorder.isRecording())
    {
      Log.e("PTTManager", "is recording , not do again!");
      paramRecordFileListener.onCompleted(4099, null);
      return 0;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = FileManager.getInstance().genSilkFileName();
    }
    this.recordFileListener = paramRecordFileListener;
    if (this.recorder.initRecording()) {
      this.recorder.start(str);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager
 * JD-Core Version:    0.7.0.1
 */