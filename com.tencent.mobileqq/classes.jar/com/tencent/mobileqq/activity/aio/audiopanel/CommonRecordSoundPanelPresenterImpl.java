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
  protected boolean a = true;
  protected double b;
  protected int c;
  protected IQQRecorder d;
  protected int e = 0;
  protected Handler f = new CommonRecordSoundPanelPresenterImpl.1(this, Looper.getMainLooper());
  private WeakReference<ICommonRecordSoundPanelView> g;
  private int h = 180000;
  private int i;
  
  public ICommonRecordSoundPanelView a()
  {
    WeakReference localWeakReference = this.g;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (ICommonRecordSoundPanelView)this.g.get();
    }
    return null;
  }
  
  public String a(double paramDouble)
  {
    return ((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble);
  }
  
  public void a(int paramInt)
  {
    a();
    Object localObject = this.d;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.f.hasMessages(16711686)))
    {
      this.f.removeMessages(16711688);
      this.f.removeMessages(16711686);
      this.f.removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("CommonRecordSoundPanelPresenterImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.e = paramInt;
      if (this.d != null)
      {
        localObject = this.f.obtainMessage(16711686);
        this.f.sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public void a(ICommonRecordSoundPanelView paramICommonRecordSoundPanelView)
  {
    if (paramICommonRecordSoundPanelView != null) {
      this.g = new WeakReference(paramICommonRecordSoundPanelView);
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
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230817, false);
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean b()
  {
    IQQRecorder localIQQRecorder = this.d;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public double d()
  {
    return this.b;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public int e()
  {
    this.h -= 200;
    this.f.sendEmptyMessageDelayed(16711687, this.h);
    return this.h + 200;
  }
  
  public void f()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(16711688)) {
        this.f.removeMessages(16711688);
      }
      this.f.removeMessages(16711688);
      this.f.removeMessages(16711686);
      this.f.removeMessages(16711687);
    }
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView == null) {
      return;
    }
    localICommonRecordSoundPanelView.getViewContext().getWindow().addFlags(128);
    localICommonRecordSoundPanelView.setRequestedOrientation4Recording(false);
    ((IMediaPlayerManagerTempApi)QRoute.api(IMediaPlayerManagerTempApi.class)).mediaPlayer_doStop(true, localICommonRecordSoundPanelView.getApp());
    localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    ((Intent)localObject).setPackage(localICommonRecordSoundPanelView.getApp().getApp().getPackageName());
    localICommonRecordSoundPanelView.getApp().getApp().sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CommonRecordSoundPanelPresenterImpl", 2, "startRecord() is called");
    }
    if (this.d == null) {
      this.d = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(localICommonRecordSoundPanelView.getViewContext());
    }
    if (this.i == 0)
    {
      localObject = new RecordParams.RecorderParam(RecordParams.a, 0, 0);
      str = TransFileUtil.getTransferFilePath(localICommonRecordSoundPanelView.getApp().getCurrentAccountUin(), null, 2, null);
    }
    else
    {
      localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
      str = TransFileUtil.getTransferFilePath(localICommonRecordSoundPanelView.getApp().getCurrentAccountUin(), null, 25, null);
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
    this.d.a((RecordParams.RecorderParam)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("path: ");
      ((StringBuilder)localObject).append(str);
      QLog.i("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
    this.d.a(this);
    QQAudioUtils.a(localICommonRecordSoundPanelView.getViewContext(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQRecorder start() is called,time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("CommonRecordSoundPanelPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    this.d.b(str);
  }
  
  public boolean g()
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView == null) {
      return false;
    }
    if (((IQavTemp)QRoute.api(IQavTemp.class)).isVideoChatting(localICommonRecordSoundPanelView.getApp()))
    {
      QQToast.makeText(BaseApplication.getContext(), 2131892896, 0).show();
      return false;
    }
    if (AudioUtil.b(1))
    {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(localICommonRecordSoundPanelView.getViewContext());
      return false;
    }
    return true;
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return e();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    paramString = a();
    if (paramString != null) {
      this.f.post(new CommonRecordSoundPanelPresenterImpl.7(this, paramString));
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
    this.f.removeMessages(1);
    paramRecorderParam = a();
    if (this.c < 1200)
    {
      this.f.post(new CommonRecordSoundPanelPresenterImpl.4(this, paramRecorderParam, paramString));
      return;
    }
    int j = c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fateOfRecorder is:");
      ((StringBuilder)localObject).append(j);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (j == 102)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
      if (paramRecorderParam != null)
      {
        localObject = paramRecorderParam.getCallBack().obtainMessage(102);
        ((Message)localObject).obj = paramString;
        paramRecorderParam.getCallBack().sendMessage((Message)localObject);
      }
    }
    else if (j == 1)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
      this.f.post(new CommonRecordSoundPanelPresenterImpl.5(this, paramRecorderParam, paramString));
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
    this.f.removeMessages(1);
    this.f.post(new CommonRecordSoundPanelPresenterImpl.6(this, paramRecorderParam));
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
      this.f.post(new CommonRecordSoundPanelPresenterImpl.2(this, localICommonRecordSoundPanelView));
      a(paramString, true, paramRecorderParam);
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
    if (this.a)
    {
      this.a = false;
      this.f.removeMessages(1);
    }
    this.f.post(new CommonRecordSoundPanelPresenterImpl.8(this, paramInt2, paramDouble));
    this.c = ((int)paramDouble);
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = a();
    if (localICommonRecordSoundPanelView != null)
    {
      this.c = 0;
      localICommonRecordSoundPanelView.getCallBack().sendEmptyMessage(3);
      this.f.post(new CommonRecordSoundPanelPresenterImpl.3(this, localICommonRecordSoundPanelView));
      this.f.removeMessages(1);
      this.f.sendEmptyMessageDelayed(1, 2000L);
      this.a = true;
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl
 * JD-Core Version:    0.7.0.1
 */