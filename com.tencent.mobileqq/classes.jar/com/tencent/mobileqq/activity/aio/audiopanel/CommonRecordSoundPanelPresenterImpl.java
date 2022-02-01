package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IMediaPlayerManagerTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class CommonRecordSoundPanelPresenterImpl
  implements ICommonRecordSoundPanelPresenter, IQQRecorder.OnQQRecorderListener
{
  protected double a;
  protected int a;
  protected Handler a;
  protected IQQRecorder a;
  private WeakReference<ICommonRecordSoundPanelView> a;
  protected boolean a;
  protected int b = 0;
  private int c = 180000;
  private int d;
  
  public CommonRecordSoundPanelPresenterImpl()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new CommonRecordSoundPanelPresenterImpl.1(this, Looper.getMainLooper());
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public ICommonRecordSoundPanelView a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (ICommonRecordSoundPanelView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public String a(double paramDouble)
  {
    return ((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(16711688)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView == null) {
      return;
    }
    localICommonRecordSoundPanelView.a().getWindow().addFlags(128);
    localICommonRecordSoundPanelView.setRequestedOrientation4Recording(false);
    ((IMediaPlayerManagerTempApi)QRoute.api(IMediaPlayerManagerTempApi.class)).mediaPlayer_doStop(true, localICommonRecordSoundPanelView.a());
    localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    ((Intent)localObject).setPackage(localICommonRecordSoundPanelView.a().getApp().getPackageName());
    localICommonRecordSoundPanelView.a().getApp().sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CommonRecordSoundPanelPresenterImpl", 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(localICommonRecordSoundPanelView.a());
    }
    if (this.d == 0)
    {
      localObject = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
      str = TransFileUtil.getTransferFilePath(localICommonRecordSoundPanelView.a().getCurrentAccountUin(), null, 2, null);
    }
    else
    {
      localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
      str = TransFileUtil.getTransferFilePath(localICommonRecordSoundPanelView.a().getCurrentAccountUin(), null, 25, null);
    }
    String str = VFSAssistantUtils.getSDKPrivatePath(str);
    File localFile = new File(str);
    localFile.getParentFile().mkdirs();
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOAudioPanel", 2, "recorderInit, createNewFile cause exception", localIOException);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a((RecordParams.RecorderParam)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("path: ");
      ((StringBuilder)localObject).append(str);
      QLog.i("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this);
    QQAudioUtils.a(localICommonRecordSoundPanelView.a(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQRecorder start() is called,time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("CommonRecordSoundPanelPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.b(str);
  }
  
  public void a(int paramInt)
  {
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("CommonRecordSoundPanelPresenterImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.b = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder != null)
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public void a(ICommonRecordSoundPanelView paramICommonRecordSoundPanelView)
  {
    if (paramICommonRecordSoundPanelView != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramICommonRecordSoundPanelView);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecorderPerpare path = ");
      localStringBuilder.append(paramString);
      QLog.d("QQRecorder", 2, localStringBuilder.toString());
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230749, false);
  }
  
  public boolean a()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  public int b()
  {
    this.c -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.c);
    return this.c + 200;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean b()
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView == null) {
      return false;
    }
    if (((IQavTemp)QRoute.api(IQavTemp.class)).isVideoChatting(localICommonRecordSoundPanelView.a()))
    {
      QQToast.a(BaseApplication.getContext(), 2131695163, 0).a();
      return false;
    }
    if (AudioUtil.a(1))
    {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(localICommonRecordSoundPanelView.a());
      return false;
    }
    return true;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return b();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    paramString = a();
    if (paramString != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.7(this, paramString));
    }
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("RecordSoundPanel.onRecorderEnd() is called,path is:");
      paramRecorderParam.append(paramString);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramRecorderParam = a();
    if (this.jdField_a_of_type_Int < 1200)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.4(this, paramRecorderParam, paramString));
      return;
    }
    int i = a();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fateOfRecorder is:");
      ((StringBuilder)localObject).append(i);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 102)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
      if (paramRecorderParam != null)
      {
        localObject = paramRecorderParam.a().obtainMessage(102);
        ((Message)localObject).obj = paramString;
        paramRecorderParam.a().sendMessage((Message)localObject);
      }
    }
    else if (i == 1)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.5(this, paramRecorderParam, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("RecordSoundPanel.onRecorderError() is called,path is:");
      paramRecorderParam.append(paramString1);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString1);
    paramRecorderParam = a();
    if (paramRecorderParam == null) {
      return;
    }
    paramRecorderParam.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.6(this, paramRecorderParam));
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.2(this, localICommonRecordSoundPanelView));
      a(paramString, true, paramRecorderParam);
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.8(this, paramInt2, paramDouble));
    this.jdField_a_of_type_Int = ((int)paramDouble);
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView != null)
    {
      this.jdField_a_of_type_Int = 0;
      localICommonRecordSoundPanelView.a().sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonRecordSoundPanelPresenterImpl.3(this, localICommonRecordSoundPanelView));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
      this.jdField_a_of_type_Boolean = true;
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl
 * JD-Core Version:    0.7.0.1
 */