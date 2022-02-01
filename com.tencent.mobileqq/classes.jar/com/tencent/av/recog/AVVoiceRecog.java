package com.tencent.av.recog;

import android.os.Environment;
import com.qq.wx.voice.embedqqegg.recognizer.SDKVersion;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.so.ResInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.os.MqqHandler;

public class AVVoiceRecog
  implements SdkAudioFrameCallback
{
  private static volatile AVVoiceRecog n;
  public int a;
  public int b;
  Runnable c = new AVVoiceRecog.1(this);
  public int d;
  public int e;
  Runnable f = new AVVoiceRecog.2(this);
  String g = f();
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private VideoAppInterface k = null;
  private AVVoiceRecog.AVVoiceRecogCallback l = null;
  private int m = 1;
  private AVVoiceRecog.VRListener o = new AVVoiceRecog.VRListener(this);
  
  private void a(int paramInt1, int paramInt2)
  {
    VideoController.f().b(0, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseContinue, oldReasons[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.w("AVVoiceRecog", 1, localStringBuilder.toString());
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 114	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 79	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   17: astore 5
    //   19: aload 5
    //   21: aload_1
    //   22: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 5
    //   28: aload_2
    //   29: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: new 114	java/io/File
    //   36: dup
    //   37: aload 5
    //   39: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload 4
    //   48: invokevirtual 121	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 4
    //   56: invokevirtual 124	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokevirtual 121	java/io/File:exists	()Z
    //   64: ifne +16 -> 80
    //   67: aload_1
    //   68: invokevirtual 127	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: goto +8 -> 80
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   80: new 132	java/io/FileOutputStream
    //   83: dup
    //   84: aload_1
    //   85: iconst_1
    //   86: invokespecial 135	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   89: astore_2
    //   90: aload_3
    //   91: ifnull +10 -> 101
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: aload_3
    //   98: invokevirtual 139	java/io/FileOutputStream:write	([B)V
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual 142	java/io/FileOutputStream:flush	()V
    //   107: aload_2
    //   108: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   111: return
    //   112: astore_3
    //   113: goto +16 -> 129
    //   116: astore_3
    //   117: goto +30 -> 147
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: goto +50 -> 173
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_3
    //   132: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   135: aload_2
    //   136: ifnull +31 -> 167
    //   139: aload_2
    //   140: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   143: return
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: invokevirtual 146	java/io/FileNotFoundException:printStackTrace	()V
    //   153: aload_2
    //   154: ifnull +13 -> 167
    //   157: aload_2
    //   158: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   161: return
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   167: return
    //   168: astore_3
    //   169: aload_1
    //   170: astore_2
    //   171: aload_3
    //   172: astore_1
    //   173: aload_2
    //   174: ifnull +15 -> 189
    //   177: aload_2
    //   178: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   181: goto +8 -> 189
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	AVVoiceRecog
    //   0	191	1	paramString1	String
    //   0	191	2	paramString2	String
    //   0	191	3	paramArrayOfByte	byte[]
    //   8	47	4	localFile	File
    //   17	21	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	72	75	java/io/IOException
    //   96	101	112	java/io/IOException
    //   103	107	112	java/io/IOException
    //   96	101	116	java/io/FileNotFoundException
    //   103	107	116	java/io/FileNotFoundException
    //   80	90	120	finally
    //   80	90	126	java/io/IOException
    //   80	90	144	java/io/FileNotFoundException
    //   107	111	162	java/io/IOException
    //   139	143	162	java/io/IOException
    //   157	161	162	java/io/IOException
    //   96	101	168	finally
    //   103	107	168	finally
    //   131	135	168	finally
    //   149	153	168	finally
    //   177	181	184	java/io/IOException
  }
  
  private static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    return ((EffectSupportManager)paramVideoAppInterface.c(5)).a(3, "normal");
  }
  
  public static AVVoiceRecog b()
  {
    if (n == null) {
      try
      {
        if (n == null) {
          n = new AVVoiceRecog();
        }
      }
      finally {}
    }
    return n;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    b().c();
    if (!this.i)
    {
      this.j = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeContinue failed, !mIsInitAndStart, mPauseReason[");
      localStringBuilder.append(this.m);
      localStringBuilder.append("], reason[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.w("AVVoiceRecog", 1, localStringBuilder.toString());
      return;
    }
    this.j = false;
    int i1 = VideoController.f().a(0, false);
    int i2 = VideoController.f().a(0, 16000, 1, 16);
    VideoController.f().a(1, this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeContinue, oldReasons[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], mPauseReason[");
    localStringBuilder.append(this.m);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], mIsPause[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], regret[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], setret[");
    localStringBuilder.append(i2);
    localStringBuilder.append("]");
    QLog.w("AVVoiceRecog", 1, localStringBuilder.toString());
  }
  
  private boolean e()
  {
    VoiceRecognizer.shareInstance().setListener(this.o);
    if (this.h)
    {
      VoiceRecognizer.shareInstance().setOpenLogCat(true);
      VoiceRecognizer.shareInstance().setSaveVoice(true);
    }
    VoiceRecognizer.shareInstance().setContReco(true);
    Object localObject1 = ResMgr.a().f("AVVoiceRecogSo");
    Object localObject2 = ResMgr.a().f("AVVoiceRecogModel");
    if ((localObject1 != null) && (localObject2 != null))
    {
      if (!ResMgr.a().g("AVVoiceRecogSo"))
      {
        ResMgr.a().a("AVVoiceRecogSo");
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. so file no exist.");
        return false;
      }
      if (!ResMgr.a().g("AVVoiceRecogModel"))
      {
        ResMgr.a().a("AVVoiceRecogModel");
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. model file no exist.");
        return false;
      }
      VoiceRecognizer.shareInstance().setWakeupThres(0);
      int i2 = -1;
      boolean bool;
      int i1;
      try
      {
        localObject1 = ResMgr.a().c("AVVoiceRecogSo");
        localObject2 = ResMgr.a().c("AVVoiceRecogModel");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initRecognizer. soFullFileName = ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", modelFullFileName = ");
        localStringBuilder.append((String)localObject2);
        QLog.i("AVVoiceRecog", 1, localStringBuilder.toString());
        bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication().getApplicationContext(), "c++_shared");
        if (!bool) {
          i1 = i2;
        }
        try
        {
          localObject1 = new StringBuilder();
          i1 = i2;
          ((StringBuilder)localObject1).append("initRecognizer. init failed. ret1 = ");
          i1 = i2;
          ((StringBuilder)localObject1).append(bool);
          i1 = i2;
          QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
        i1 = i2;
        i2 = VoiceRecognizer.shareInstance().init(BaseApplicationImpl.getApplication().getApplicationContext(), (String)localObject1, (String)localObject2);
        i1 = i2;
        localObject1 = new StringBuilder();
        i1 = i2;
        ((StringBuilder)localObject1).append("VoiceRecog. init. ret1 = ");
        i1 = i2;
        ((StringBuilder)localObject1).append(bool);
        i1 = i2;
        ((StringBuilder)localObject1).append(", ret2 = ");
        i1 = i2;
        ((StringBuilder)localObject1).append(i2);
        i1 = i2;
        ((StringBuilder)localObject1).append(", thre = ");
        i1 = i2;
        ((StringBuilder)localObject1).append(0);
        i1 = i2;
        QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject1).toString());
        if ((bool) && (i2 >= 0))
        {
          localObject1 = new SDKVersion();
          i1 = VoiceRecognizer.shareInstance().getVersion((SDKVersion)localObject1);
          if (i1 < 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initRecognizer. getVersion failed. ret = ");
            ((StringBuilder)localObject1).append(i1);
            QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject1).toString());
            return false;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initRecognizer OK. soVer = ");
          ((StringBuilder)localObject2).append(((SDKVersion)localObject1).soVer);
          ((StringBuilder)localObject2).append(", binVer = ");
          ((StringBuilder)localObject2).append(((SDKVersion)localObject1).binVer);
          QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject2).toString());
          return true;
        }
        i1 = i2;
        localObject1 = new StringBuilder();
        i1 = i2;
        ((StringBuilder)localObject1).append("initRecognizer. init failed. ret1 = ");
        i1 = i2;
        ((StringBuilder)localObject1).append(bool);
        i1 = i2;
        ((StringBuilder)localObject1).append(", ret2 = ");
        i1 = i2;
        ((StringBuilder)localObject1).append(i2);
        i1 = i2;
        QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        bool = false;
        i1 = i2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initRecognizer. init failed. ret1 = ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", ret2 = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", err = ");
      ((StringBuilder)localObject2).append(localUnsatisfiedLinkError2.getMessage());
      QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. soResInfo == null || modelResInfo == null.");
    return false;
  }
  
  private String f()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audiodata");
    localStringBuilder.append(str);
    localStringBuilder.append(".pcm");
    return localStringBuilder.toString();
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, AVVoiceRecog.AVVoiceRecogCallback paramAVVoiceRecogCallback)
  {
    this.k = paramVideoAppInterface;
    this.l = paramAVVoiceRecogCallback;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool3 = this.j;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.m != paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b(int paramInt)
  {
    this.m |= paramInt;
    if (!this.i) {
      return;
    }
    this.a = this.m;
    this.b = paramInt;
    if (this.j) {
      return;
    }
    this.j = true;
    ThreadManager.getUIHandler().removeCallbacks(this.f);
    ThreadManager.getUIHandler().post(this.c);
  }
  
  public void c(int paramInt)
  {
    if (!this.j) {
      return;
    }
    int i1 = this.m;
    this.d = i1;
    this.e = paramInt;
    this.m = ((paramInt ^ 0xFFFFFFFF) & i1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mIsPause[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], mPauseReason[");
    localStringBuilder.append(i1);
    localStringBuilder.append("->");
    localStringBuilder.append(this.m);
    localStringBuilder.append("]");
    QLog.w("AVVoiceRecog", 1, localStringBuilder.toString());
    if (this.m == 0)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.c);
      ThreadManager.getUIHandler().post(this.f);
      return;
    }
    this.j = true;
  }
  
  public boolean c()
  {
    boolean bool = this.i;
    if (bool) {
      return bool;
    }
    Object localObject = this.k;
    if (localObject == null) {
      return bool;
    }
    if (!a((VideoAppInterface)localObject))
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. not DeviceSupport.");
      this.i = false;
      return false;
    }
    localObject = ResMgr.a().f("AVVoiceRecogSo");
    ResInfo localResInfo = ResMgr.a().f("AVVoiceRecogModel");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initAndStart. soResInfo = ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(", modelResInfo = ");
    localStringBuilder.append(localResInfo);
    QLog.i("AVVoiceRecog", 1, localStringBuilder.toString());
    if ((localObject != null) && (localResInfo != null))
    {
      bool = e();
      if (!bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAndStart. initRecognizer failed. initret = ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject).toString());
        this.i = false;
        return false;
      }
      VoiceRecognizer.shareInstance().setKeywordSetIndex(0);
      int i1 = VoiceRecognizer.shareInstance().startReceiving();
      if (i1 < 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAndStart. startReceiving failed. ret = ");
        ((StringBuilder)localObject).append(i1);
        QLog.i("AVVoiceRecog", 1, ((StringBuilder)localObject).toString());
        this.i = false;
        return false;
      }
      QLog.i("AVVoiceRecog", 1, "initAndStart OK.");
      this.i = true;
      return this.i;
    }
    QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. soResInfo == null || modelResInfo == null.");
    this.i = false;
    return false;
  }
  
  public void d()
  {
    if (!this.i) {
      return;
    }
    VideoController.f().b(0, false);
    VideoController.f().a(1, null);
    VoiceRecognizer.shareInstance().cancel();
    VoiceRecognizer.shareInstance().destroy();
    this.i = false;
    this.m = 1;
    this.j = true;
    QLog.i("AVVoiceRecog", 1, "stopAndUninit OK.");
  }
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) || (!this.i) || (this.j))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveAudioFrame, srcType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], size[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.w("AVVoiceRecog", 1, localStringBuilder.toString());
    }
    if (this.i)
    {
      if (this.j) {
        return;
      }
      if (this.h)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("audiodata");
        localStringBuilder.append(File.separator);
        a(localStringBuilder.toString(), this.g, paramArrayOfByte);
      }
      VoiceRecognizer.shareInstance().appendData(paramArrayOfByte, 0, paramInt2, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.recog.AVVoiceRecog
 * JD-Core Version:    0.7.0.1
 */