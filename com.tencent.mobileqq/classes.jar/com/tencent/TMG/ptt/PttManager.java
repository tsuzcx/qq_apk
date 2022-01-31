package com.tencent.TMG.ptt;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.TMG.utils.CosFileTransfer;
import com.tencent.TMG.utils.CosFileTransfer.DownloadCosFileListener;
import com.tencent.TMG.utils.CosFileTransfer.UploadCosFileListener;
import java.util.UUID;

public class PttManager
{
  private static final String TAG = "PTTManager";
  private static PttManager s_instance = null;
  private Context context = null;
  Recorder.OnQQRecorderListener listener = new Recorder.OnQQRecorderListener()
  {
    public void onBeginReceiveData() {}
    
    public void onRecorderAbnormal(int paramAnonymousInt)
    {
      Log.e("PTTManager", "on recorder abnormal!");
      PttManager.this.recordFileListener.onCompleted(4100, null);
    }
    
    public void onRecorderEnd()
    {
      Log.e("PTTManager", "on recorder end!");
      PttManager.this.recordFileListener.onCompleted(0, PttManager.this.recorder.recorderPath);
    }
    
    public void onRecorderError(String paramAnonymousString1, String paramAnonymousString2)
    {
      Log.e("PTTManager", "on recorder error : path = " + paramAnonymousString1 + " , reason = " + paramAnonymousString2);
      PttManager.this.recordFileListener.onCompleted(4101, null);
    }
    
    public void onRecorderFailed(String paramAnonymousString, int paramAnonymousInt)
    {
      Log.e("PTTManager", "on recorder failed! reason = " + paramAnonymousInt);
      if (paramAnonymousInt == 3) {
        PttManager.this.recordFileListener.onCompleted(4102, null);
      }
      do
      {
        return;
        if (paramAnonymousInt == 2)
        {
          PttManager.this.recordFileListener.onCompleted(4101, null);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          PttManager.this.recordFileListener.onCompleted(4098, null);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          PttManager.this.recordFileListener.onCompleted(4099, null);
          return;
        }
      } while (paramAnonymousInt != 5);
      PttManager.this.recordFileListener.onCompleted(4103, null);
    }
    
    public void onRecorderPrepare(String paramAnonymousString)
    {
      Log.d("PTTManager", "on recorder prepare : path = " + paramAnonymousString);
    }
    
    public void onRecorderStart()
    {
      Log.d("PTTManager", "on recorder start!");
    }
  };
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
    //   0: new 78	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_3
    //   13: aload 4
    //   15: invokevirtual 85	java/io/FileInputStream:available	()I
    //   18: istore_2
    //   19: iload_2
    //   20: istore_1
    //   21: aload 4
    //   23: ifnull +10 -> 33
    //   26: aload 4
    //   28: invokevirtual 88	java/io/FileInputStream:close	()V
    //   31: iload_2
    //   32: istore_1
    //   33: ldc 20
    //   35: ldc 90
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: iload_1
    //   48: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 102	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: invokestatic 108	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: iload_1
    //   60: ireturn
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   66: iload_2
    //   67: istore_1
    //   68: goto -35 -> 33
    //   71: astore 5
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: ldc 20
    //   81: new 113	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   88: ldc 116
    //   90: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 127	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload 4
    //   106: astore_3
    //   107: aload 5
    //   109: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   112: aload 4
    //   114: ifnull +53 -> 167
    //   117: aload 4
    //   119: invokevirtual 88	java/io/FileInputStream:close	()V
    //   122: iconst_0
    //   123: istore_1
    //   124: goto -91 -> 33
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   132: iconst_0
    //   133: istore_1
    //   134: goto -101 -> 33
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 88	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 111	java/io/IOException:printStackTrace	()V
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
  
  public void downloadFile(final String paramString1, final String paramString2, final PttListener.DownloadFileListener paramDownloadFileListener)
  {
    TokenFetcher.getInstance().getDownloadToken(paramString1, new TokenFetcher.GetDownloadTokenListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString, TokenFetcher.DownloadInfo paramAnonymousDownloadInfo)
      {
        if ((paramAnonymousInt == 0) && (paramAnonymousDownloadInfo != null)) {
          CosFileTransfer.downloadFile(paramAnonymousDownloadInfo.file_url, paramString2, paramAnonymousDownloadInfo.token, null, new CosFileTransfer.DownloadCosFileListener()
          {
            public void onCompleted(int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              if (PttManager.2.this.val$monitor != null) {
                PttManager.2.this.val$monitor.onCompleted(paramAnonymous2Int, PttManager.2.this.val$savePath, PttManager.2.this.val$downloadUrl);
              }
            }
          });
        }
        do
        {
          return;
          Log.e("PTTManager", "downloadFile|get download file token failed");
        } while (paramDownloadFileListener == null);
        paramDownloadFileListener.onCompleted(paramAnonymousInt, paramString2, paramString1);
      }
    });
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
  
  public void uploadFile(final String paramString, final PttListener.UploadFileListener paramUploadFileListener)
  {
    String str = UUID.randomUUID().toString();
    TokenFetcher.getInstance().getUploadToken(str, new TokenFetcher.GetUploadTokenListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString, TokenFetcher.UploadInfo paramAnonymousUploadInfo)
      {
        if ((paramAnonymousInt == 0) && (paramAnonymousUploadInfo != null)) {
          CosFileTransfer.uploadFile(paramString, paramAnonymousUploadInfo.upload_url, paramAnonymousUploadInfo.token, 20971520, null, new CosFileTransfer.UploadCosFileListener()
          {
            public void onCompleted(int paramAnonymous2Int, String paramAnonymous2String, Object paramAnonymous2Object)
            {
              if (PttManager.1.this.val$monitor != null) {
                PttManager.1.this.val$monitor.onCompleted(paramAnonymous2Int, PttManager.1.this.val$srcPath, paramAnonymous2String);
              }
            }
          });
        }
        do
        {
          return;
          Log.e("PTTManager", "uploadFile|get upload file token failed");
        } while (paramUploadFileListener == null);
        paramUploadFileListener.onCompleted(paramAnonymousInt, paramString, null);
      }
    });
  }
  
  public void voice2Text(final String paramString, final PttListener.Voice2TextListener paramVoice2TextListener)
  {
    TokenFetcher.getInstance().voice2Text(paramString, new TokenFetcher.Voice2TextListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString, TokenFetcher.Voice2TextInfo paramAnonymousVoice2TextInfo)
      {
        Object localObject = null;
        paramAnonymousString = localObject;
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = localObject;
          if (paramAnonymousVoice2TextInfo != null) {
            paramAnonymousString = paramAnonymousVoice2TextInfo.text;
          }
        }
        if (paramVoice2TextListener != null) {
          paramVoice2TextListener.onCompleted(paramAnonymousInt, paramString, paramAnonymousString);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager
 * JD-Core Version:    0.7.0.1
 */