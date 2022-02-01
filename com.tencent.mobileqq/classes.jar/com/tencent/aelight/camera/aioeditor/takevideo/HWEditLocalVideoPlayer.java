package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.HWVideoPlayViewListener;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HWEditLocalVideoPlayer
  extends EditVideoPart
  implements Handler.Callback, HWVideoPlayView.HWVideoPlayViewListener, EditVideoPlayerExport, HWDecodeListener
{
  protected VideoFilterPlayView a;
  protected LocalMediaInfo b;
  protected List<HWEditLocalVideoPlayer.Mp4VideoFragmentInfo> c = new CopyOnWriteArrayList();
  protected int d = 0;
  boolean e = false;
  boolean f = false;
  private String g;
  private String h;
  private String i;
  private Mp4ReEncoder j;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable k;
  private boolean l = true;
  private Handler m;
  private Handler n = new Handler(ThreadManager.getFileThreadLooper(), this);
  private AtomicBoolean o = new AtomicBoolean(false);
  private int p = 0;
  private Runnable q = new HWEditLocalVideoPlayer.2(this);
  
  public HWEditLocalVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private Bitmap a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    Object localObject1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(paramMp4VideoFragmentInfo);
    long l2 = this.t.S() / 1000000L;
    long l1 = 0L;
    Object localObject2 = localObject1;
    if (l2 != 0L)
    {
      localObject2 = localObject1;
      if (paramBoolean)
      {
        localObject3 = MediaUtil.a(this.g, this.b, l2);
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
      }
    }
    if (localObject2 == null) {
      return null;
    }
    int i1 = this.b.rotation;
    localObject1 = localObject2;
    if (i1 != 0) {
      localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i1);
    }
    Object localObject3 = new GPUBitmapImageRender();
    ((GPUBitmapImageRender)localObject3).a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
    localObject2 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if ((localObject2 != null) && (((QQFilterRenderManager)localObject2).getBusinessOperation().hasAvOrSpecialEffect()))
    {
      if (paramBoolean) {
        l1 = this.t.S();
      }
      localObject2 = ((GPUBitmapImageRender)localObject3).a((Bitmap)localObject1, l1);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.d(paramMp4VideoFragmentInfo))
    {
      localObject2 = localObject1;
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.e(paramMp4VideoFragmentInfo) != null)
      {
        GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
        localGPUImagePixelationFilter.a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.e(paramMp4VideoFragmentInfo));
        localGPUImagePixelationFilter.init();
        localObject2 = ((GPUBitmapImageRender)localObject3).a((Bitmap)localObject1, localGPUImagePixelationFilter);
        SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        localGPUImagePixelationFilter.destroy();
        localObject2 = localObject1;
      }
    }
    ((GPUBitmapImageRender)localObject3).a();
    localObject1 = localObject2;
    if (i1 != 0) {
      localObject1 = UIUtils.a((Bitmap)localObject2, i1);
    }
    if ((localObject1 == HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(paramMp4VideoFragmentInfo)) && (!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.f(paramMp4VideoFragmentInfo)))
    {
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.d(paramMp4VideoFragmentInfo)) {
        return localObject1;
      }
      return paramMp4VideoFragmentInfo.e;
    }
    return localObject1;
  }
  
  private void a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.d), Integer.valueOf(paramMp4VideoFragmentInfo.d));
    if (paramMp4VideoFragmentInfo.a == null)
    {
      if (!this.a.getVideoFilePath().equalsIgnoreCase(this.g))
      {
        this.a.c();
        this.a.setFilePath(this.g, this.h);
        this.a.b();
        this.a.e();
        this.p = 1;
      }
      this.a.setPlayRange((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.t.P != null) {
        this.t.P.d(3, HardCodeUtil.a(2131903650));
      }
    }
    else
    {
      if (!this.a.getVideoFilePath().equalsIgnoreCase(paramMp4VideoFragmentInfo.a))
      {
        this.a.c();
        this.a.setFilePath(paramMp4VideoFragmentInfo.a, paramMp4VideoFragmentInfo.b);
        this.a.f();
        this.a.b();
        this.a.e();
        this.p = 1;
      }
      if (this.t.P != null) {
        this.t.P.d(3, "");
      }
    }
    this.d = paramMp4VideoFragmentInfo.d;
  }
  
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable f(int paramInt)
  {
    if ((!Build.MODEL.equalsIgnoreCase("MX5")) && (!Build.MODEL.contains("vivo X5")) && (!Build.MODEL.equalsIgnoreCase("M2 Note")) && (!Build.MODEL.equalsIgnoreCase("m1 metal")) && (!Build.MODEL.equalsIgnoreCase("HLA Note3")) && (!Build.MODEL.equalsIgnoreCase("OPPO R7")) && (!Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 30, 0, paramInt);
    }
    return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 3, 1, paramInt);
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.k;
    if (localObject == null)
    {
      if (paramInt < this.c.size())
      {
        localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(paramInt);
        if ((!((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).c) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).a)))
        {
          this.k = f(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).d);
          this.n.postDelayed(this.k, 300L);
        }
      }
      if (this.k == null)
      {
        localObject = this.c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)((Iterator)localObject).next();
          if ((!localMp4VideoFragmentInfo.c) && (TextUtils.isEmpty(localMp4VideoFragmentInfo.a)))
          {
            this.k = f(localMp4VideoFragmentInfo.d);
            this.n.postDelayed(this.k, 300L);
          }
        }
      }
      if (this.k == null)
      {
        SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.k.a), Integer.valueOf(this.k.b), Integer.valueOf(this.k.c));
      return;
    }
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(((HWEditLocalVideoPlayer.ConvertIFramesRunnable)localObject).a), Integer.valueOf(this.k.b), Integer.valueOf(this.k.c));
  }
  
  private int h(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9) {
              return 0;
            }
            return 4;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    return 5;
  }
  
  private int i(int paramInt)
  {
    return 0;
  }
  
  private void m()
  {
    int i1 = 0;
    while (i1 < this.c.size())
    {
      if ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.g((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1)) == 1) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1)).a)))
      {
        this.t.e(false);
        return;
      }
      i1 += 1;
    }
    if (this.o.compareAndSet(true, true)) {
      this.t.e(true);
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.c.size()) {
      return a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a()
  {
    super.a();
    this.m = new Handler();
    if ((this.t.I.e instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.t.I.e;
      this.h = ((EditTakeVideoSource)localObject).c;
      this.b = ((EditTakeVideoSource)localObject).b;
      this.g = ((EditTakeVideoSource)localObject).a;
      this.i = ((EditTakeVideoSource)localObject).d;
      if ((!TextUtils.isEmpty(this.h)) && (this.h.endsWith(".mp3")))
      {
        localObject = (QimMusicPlayer)QIMManager.a().d(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.h);
        if (localMusicItemInfo != null)
        {
          ((QimMusicPlayer)localObject).a(localMusicItemInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(Image2Video.a);
          ((StringBuilder)localObject).append("/noaudio");
          localObject = ((StringBuilder)localObject).toString();
          FileUtils.createFileIfNotExits((String)localObject);
          this.h = ((String)localObject);
        }
      }
      this.a = ((VideoFilterPlayView)d(2063991125));
      this.a.setVisibility(0);
      this.a.setBgmFilePath(this.i);
      this.a.setMediaInfo(this.b);
      this.a.setFilePath(this.g, this.h);
      this.a.setRepeat(true);
      this.a.setSpeedType(0);
      this.a.setDecodeListener(this);
      this.a.setPlayViewListener(this);
      this.p = 0;
      a(EditVideoPlayerExport.class, this);
      this.t.e(false);
      this.n.postDelayed(new HWEditLocalVideoPlayer.1(this), 200L);
      return;
    }
    throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
  }
  
  public void a(float paramFloat)
  {
    this.a.setVolume(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    if ((f1 != 0.0F) && (f1 <= 0.95F))
    {
      if ((this.t.I.e instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.t.I.e;
        this.a.setColorFilterType(i(paramInt1), i(paramInt2), f1, localEditLocalVideoSource.b.rotation);
        return;
      }
      if ((this.t.I.e instanceof EditTakeVideoSource)) {
        this.a.setColorFilterType(i(paramInt1), i(paramInt2), f1, 0);
      }
    }
    else
    {
      this.a.setColorFilterType(i(paramInt1));
      c(paramInt1);
      SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if ((paramGenerateContext.c instanceof EditTakeVideoSource))
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        ((Mp4ReEncoder)localObject).a();
        this.j = null;
      }
      localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(paramInt);
      paramGenerateContext.d.videoNeedRotate = false;
      paramGenerateContext.d.mIFrameVideoPath = ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).a;
      boolean bool = VideoUtils.a(this.b);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("landscape:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" w:");
        ((StringBuilder)localObject).append(this.b.mediaWidth);
        ((StringBuilder)localObject).append(" h:");
        ((StringBuilder)localObject).append(this.b.mediaHeight);
        ((StringBuilder)localObject).append(" r:");
        ((StringBuilder)localObject).append(this.b.rotation);
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, ((StringBuilder)localObject).toString());
      }
      paramGenerateContext.d.putExtra("landscape_video", Boolean.valueOf(bool));
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.a;
    if (paramObject == null) {
      return;
    }
    if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (!this.f))
    {
      paramObject.e();
      this.p = 1;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i1 = this.t.m();
    if (i1 < this.c.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.d(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
    }
    this.a.setMosaicFilterType(paramBitmap);
  }
  
  public void a(TransferData paramTransferData)
  {
    VideoFilterPlayView localVideoFilterPlayView = this.a;
    if (localVideoFilterPlayView != null) {
      localVideoFilterPlayView.setTransferData(paramTransferData);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    Handler localHandler = this.m;
    if (localHandler != null)
    {
      if (paramLong != 0L)
      {
        localHandler.postDelayed(paramRunnable, paramLong);
        return;
      }
      localHandler.post(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = this.t.m();
    if (i1 < this.c.size()) {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1), paramBoolean);
    }
    this.a.setMuteAudio(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      int i1 = paramMessage.arg1;
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        this.a.c();
        this.p = 0;
        return true;
      }
      paramMessage = this.a;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.p = 1;
      }
      return true;
    }
    return false;
  }
  
  public void at_()
  {
    super.at_();
    this.l = false;
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Mp4ReEncoder)localObject).a();
      this.j = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      this.m.removeCallbacks((Runnable)localObject);
      this.k = null;
    }
  }
  
  public void ax_()
  {
    super.ax_();
    this.a.d();
    this.a.onPause();
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i1 = this.t.m();
    if (i1 < this.c.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.g(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void c()
  {
    if (this.p == 2)
    {
      this.a.d();
      return;
    }
    this.p = 1;
  }
  
  public void c(int paramInt)
  {
    paramInt = h(paramInt);
    if ((paramInt == 5) && (this.c.size() > 0))
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(this.d);
      if (localMp4VideoFragmentInfo.a == null)
      {
        this.a.d();
        this.p = 2;
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
        a(localMp4VideoFragmentInfo);
      }
      this.a.setSpeedType(5);
    }
    else
    {
      this.a.setSpeedType(paramInt);
      this.a.e();
      this.p = 1;
    }
    m();
  }
  
  public void d()
  {
    this.p = 0;
  }
  
  public void f()
  {
    super.f();
    this.a.onResume();
    if (this.p != 2) {
      this.a.e();
    } else {
      this.a.d();
    }
    this.e = false;
  }
  
  public void g()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.m = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((VideoFilterPlayView)localObject).c();
      this.a.i();
      this.p = 0;
      this.a.setPlayViewListener(null);
    }
    super.g();
    if (CaptureFreqMonitor.d)
    {
      localObject = this.a;
      if ((localObject != null) && (((VideoFilterPlayView)localObject).t > 100) && (this.a.s > 0L))
      {
        int i1 = this.t.T();
        float f1 = this.a.t / (float)this.a.s * 1000.0F;
        if (StoryReportor.a((int)f1, 0L, 30L)) {
          StoryReportor.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.t.I.a), String.valueOf(f1), StoryReportor.d(i1), String.valueOf(this.a.t), String.valueOf(this.a.s) });
        }
      }
    }
  }
  
  public void h()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.a;
    localVideoFilterPlayView.n = false;
    localVideoFilterPlayView.d();
    this.p = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if ((i1 >= 0) && (i1 < this.c.size()))
    {
      paramMessage = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.e))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.c.set(i1, paramMessage);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
      }
    }
    return true;
  }
  
  public void i()
  {
    this.a.e();
    this.p = 1;
  }
  
  public LocalMediaInfo k()
  {
    return this.b;
  }
  
  public int l()
  {
    return this.p;
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, localStringBuilder.toString(), paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    a(new HWEditLocalVideoPlayer.3(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    if (this.p != 2) {
      a(new HWEditLocalVideoPlayer.4(this), 0L);
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if (this.p != 2)
    {
      Handler localHandler = this.m;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.q);
        a(this.q, 200L);
      }
    }
  }
  
  public void v()
  {
    super.v();
    this.l = true;
    g(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */