package com.tencent.mobileqq.apollo.game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.util.WeakReferenceHandler;
import cooperation.gmesdk.GMESDKIPC;
import cooperation.gmesdk.GMESDK_Event;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameAudioManager
  implements Handler.Callback, IQQRecorder.OnQQRecorderListener, AudioPlayerBase.AudioPlayerListener, GMESDK_Event
{
  public static String a = "1400035750";
  public static boolean a = false;
  public static String b = "5d3728db75adf458";
  public static boolean b = false;
  public static String c = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  public static String d = "105d1e43c456bc800b4adacd57ac1199";
  private int jdField_a_of_type_Int;
  public long a;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CmGameAudioManager.GameMsgListener jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$GameMsgListener;
  private CmGameAudioManager.TPHandler jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IQQRecorder jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public WeakReference<CmGameAudioManager.RecorderEventListener> a;
  private int b;
  public WeakReference<CmGameAudioManager.UploadEventListener> b;
  boolean c;
  private volatile boolean d;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = false;
  private String f;
  private String g;
  private String h;
  
  public CmGameAudioManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$GameMsgListener = new CmGameAudioManager.GameMsgListener(paramQQAppInterface);
    ((ApolloGameManagerImpl)paramQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getGameTempMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$GameMsgListener);
    GMESDKIPC.a().a(this);
    a();
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[onReportRecordInfoResp] upload record succ.");
        }
        ((CmGameAudioManager.UploadEventListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
        return;
      }
      ((CmGameAudioManager.UploadEventListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReportRecordInfoResp] uploadError,retcode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/audioRecord/");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append(".amr");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt, CmGameAudioManager.RecorderEventListener paramRecorderEventListener)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRecorderEventListener);
    if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      paramRecorderEventListener = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(paramRecorderEventListener);
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this);
    }
    paramRecorderEventListener = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/audioRecord/");
    if (!paramRecorderEventListener.exists()) {
      paramRecorderEventListener.mkdirs();
    }
    paramRecorderEventListener = a();
    if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(paramRecorderEventListener, true);
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[startRecord] start record");
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("gmesdk_event_key");
    int i = paramBundle.getInt("gmesdk_event_ret");
    paramBundle = new StringBuilder();
    paramBundle.append("key:");
    paramBundle.append(str);
    paramBundle.append(",ret:");
    paramBundle.append(i);
    QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramBundle.toString());
    paramBundle = (ApolloGameManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    if ("gmesdk_event_key_enterroom".equals(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key:");
      localStringBuilder.append(str);
      localStringBuilder.append(",ret:");
      localStringBuilder.append(i);
      localStringBuilder.append(",roomId:");
      localStringBuilder.append(this.h);
      QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, localStringBuilder.toString());
      if ((i != 0) && (i != 1003))
      {
        paramBundle.getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
        a(false, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 319) {
          i = 1;
        } else {
          i = 2;
        }
        VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 1, new String[0]);
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      this.jdField_e_of_type_JavaLangString = this.g;
      this.f = this.h;
      paramBundle.getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, true, this.jdField_a_of_type_Int);
      a(true, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 319) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 0, new String[0]);
      return;
    }
    if ("gmesdk_event_key_exit_room".equals(str))
    {
      this.jdField_d_of_type_Boolean = false;
      paramBundle.getGameTempMsgHandler().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
      a(false, this.jdField_e_of_type_JavaLangString);
      this.jdField_e_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_Int == 319) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(null, "cmshow", "Apollo", "turnOffAudio", i, 0, new String[0]);
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    paramAudioPlayerBase = new StringBuilder();
    paramAudioPlayerBase.append("[AudioPlayerListener] onError:");
    paramAudioPlayerBase.append(paramInt);
    QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramAudioPlayerBase.toString());
  }
  
  public void a(String paramString, CmGameAudioManager.UploadEventListener paramUploadEventListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[uploadFile] uploadFile:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler = new CmGameAudioManager.TPHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramUploadEventListener);
    if (localObject != null)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler);
        this.jdField_c_of_type_Boolean = true;
      }
      paramUploadEventListener = new TransferRequest();
      paramUploadEventListener.mFileType = 24;
      paramUploadEventListener.mCommandId = 36;
      paramUploadEventListener.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      paramUploadEventListener.mPeerUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      paramUploadEventListener.mIsUp = true;
      paramUploadEventListener.mRequestLength = ((int)new File(paramString).length());
      paramUploadEventListener.mLocalPath = paramString;
      ((ITransFileController)localObject).transferAsync(paramUploadEventListener);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    CmGameServerQIPCModule.a().a(paramBoolean, paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_e_of_type_Boolean) {
      return true;
    }
    Object localObject = ApolloConfigUtils.d;
    boolean bool2 = false;
    if (localObject != null)
    {
      jdField_a_of_type_JavaLangString = ApolloConfigUtils.d.optString("appid", "1400035750");
      jdField_b_of_type_JavaLangString = ApolloConfigUtils.d.optString("key", "5d3728db75adf458");
      jdField_c_of_type_JavaLangString = ApolloConfigUtils.d.optString("url", "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip");
      jdField_d_of_type_JavaLangString = ApolloConfigUtils.d.optString("md5", "105d1e43c456bc800b4adacd57ac1199");
      if (ApolloConfigUtils.d.optInt("openAudio", 0) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      jdField_a_of_type_Boolean = bool1;
      boolean bool1 = bool2;
      if (ApolloConfigUtils.d.optInt("display", 0) != 0) {
        bool1 = true;
      }
      jdField_b_of_type_Boolean = bool1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initParams] appId:");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",key:");
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",md5:");
      ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",OPEN_AUDIO:");
      ((StringBuilder)localObject).append(jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",sDISPLAY:");
      ((StringBuilder)localObject).append(jdField_b_of_type_Boolean);
      QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, ((StringBuilder)localObject).toString());
      GMESDKIPC.a().a(jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString);
      this.jdField_e_of_type_Boolean = true;
    }
    else
    {
      QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[initParams] gameAudioConfig is null");
      this.jdField_e_of_type_Boolean = false;
    }
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[playUserRecord] play record:");
      ((StringBuilder)???).append(paramString);
      QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
        {
          if (QLog.isColorLevel()) {
            QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, "record is playing");
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        if (TextUtils.isEmpty(paramString))
        {
          if (!new File(a()).exists())
          {
            QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, "audio file not exist.");
            return false;
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(a());
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return true;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return true;
      }
      catch (IOException paramString)
      {
        QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramString.getMessage());
        return false;
      }
    }
  }
  
  public void b()
  {
    ((ApolloGameManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getGameTempMsgHandler().b(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$GameMsgListener);
    GMESDKIPC.a().a();
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      ((ITransFileController)localObject).removeHandle(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameAudioManager$TPHandler = null;
      this.jdField_c_of_type_Boolean = false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (localObject != null)
    {
      ((IQQRecorder)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a();
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = null;
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public boolean b()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    boolean bool = false;
    if (localIQQRecorder != null)
    {
      QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[startRecord] stop record");
      if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a();
      bool = true;
    }
    return bool;
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[stopUserRecord] stop record:");
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        return true;
      }
      return false;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      Object localObject = paramMessage.getData();
      paramMessage = ((Bundle)localObject).getString("uin");
      String str = ((Bundle)localObject).getString("roomId");
      i = ((Bundle)localObject).getInt("from");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleMessage] enterRoom,uin:");
      ((StringBuilder)localObject).append(paramMessage);
      ((StringBuilder)localObject).append(",roomId:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",from:");
      ((StringBuilder)localObject).append(i);
      QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, ((StringBuilder)localObject).toString());
      this.g = paramMessage;
      this.h = str;
      this.jdField_a_of_type_Int = i;
      GMESDKIPC.a().a(this.f);
      if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
      {
        GMESDKIPC.a().a(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), jdField_b_of_type_JavaLangString, str, true, true);
        return false;
      }
      QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[handleMessage] appid or key is null!enter room failed");
      return false;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("[handleMessage] exitRoom,roomId:");
    paramMessage.append(this.f);
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, paramMessage.toString());
    GMESDKIPC.a().a(false);
    GMESDKIPC.a().b(false);
    GMESDKIPC.a().a(this.f);
    return false;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onBeginReceiveData");
    return this.jdField_b_of_type_Int * 1000;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitFailed");
    paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramString != null) && (paramString.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-1);
    }
  }
  
  public void onInitSuccess()
  {
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitSuccess");
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderAbnormal");
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[QQRecorder] onRecorderEnd,totalTime:");
    ((StringBuilder)localObject).append(paramDouble);
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, (String)localObject);
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    }
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        i = 0;
      }
      if (i == 0)
      {
        StreamDataManager.a(paramString, false);
        StreamDataManager.a(paramString);
      }
      else
      {
        ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
      }
    }
    this.jdField_a_of_type_Long = (paramDouble);
    paramString = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderError");
    paramString1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramString1 != null) && (paramString1.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-2);
    }
  }
  
  public void onRecorderNotReady(String paramString)
  {
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderNotReady");
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    int i = 1;
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderPrepare");
    byte[] arrayOfByte = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
      i = 0;
    }
    if (i == 0)
    {
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, arrayOfByte, arrayOfByte.length);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[QQRecorder] onRecorderSilceEnd size：");
      localStringBuilder.append(paramInt1);
      QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, localStringBuilder.toString());
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 == 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
  }
  
  public int onRecorderStart()
  {
    QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderStart");
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((CmGameAudioManager.RecorderEventListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderVolumeStateChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameAudioManager
 * JD-Core Version:    0.7.0.1
 */