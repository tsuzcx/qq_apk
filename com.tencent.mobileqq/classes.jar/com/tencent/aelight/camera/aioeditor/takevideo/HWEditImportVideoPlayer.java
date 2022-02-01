package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.HWVideoPlayViewListener;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.step.MergeEditVideo;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HWEditImportVideoPlayer
  extends EditVideoPart
  implements Handler.Callback, HWVideoPlayView.HWVideoPlayViewListener, EditVideoPlayerExport, HWDecodeListener
{
  protected VideoFilterPlayView a;
  protected LocalMediaInfo b;
  protected List<HWEditImportVideoPlayer.Mp4VideoFragmentInfo> c = new CopyOnWriteArrayList();
  protected int d = -1;
  final boolean e = true;
  boolean f;
  boolean g;
  boolean h;
  private String i;
  private String j;
  private int k;
  private int l;
  private Handler m;
  private Handler n = new Handler(ThreadManager.getFileThreadLooper(), this);
  private AtomicBoolean o = new AtomicBoolean(false);
  private int p = 0;
  private int q = 0;
  
  public HWEditImportVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, GPUBitmapImageRender paramGPUBitmapImageRender)
  {
    if ((paramBitmap != null) && (paramGPUBitmapImageRender != null))
    {
      Object localObject = VideoUtils.b(paramBitmap.getWidth(), paramBitmap.getHeight(), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
      int i4 = ((Integer)((Pair)localObject).first).intValue();
      int i5 = ((Integer)((Pair)localObject).second).intValue();
      int i3 = MergeEditVideo.a;
      int i1 = i5;
      int i2 = i4;
      if (i5 > i3)
      {
        double d1 = i4;
        double d2 = i3;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3 = i5;
        Double.isNaN(d3);
        i2 = (int)(d1 * d2 / d3);
        i1 = i3;
      }
      i2 = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(i2);
      i1 = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(i1);
      paramGPUBitmapImageRender.a(i2, i1);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      Canvas localCanvas;
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = ImageUtil.a(paramContext, ImageUtil.c(paramBitmap), 0.4F, 25.0F);
        paramGPUBitmapImageRender = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (paramContext.isMutable()) {
            paramGPUBitmapImageRender = paramContext;
          } else {
            paramGPUBitmapImageRender = paramContext.copy(paramContext.getConfig(), true);
          }
          localCanvas.setBitmap(paramGPUBitmapImageRender);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramGPUBitmapImageRender = paramContext;
        }
      }
      else
      {
        paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
        localCanvas = new Canvas();
        if (paramContext.isMutable()) {
          paramGPUBitmapImageRender = paramContext;
        } else {
          paramGPUBitmapImageRender = paramContext.copy(paramContext.getConfig(), true);
        }
        localCanvas.setBitmap(paramGPUBitmapImageRender);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        paramGPUBitmapImageRender = paramContext;
      }
      paramContext = BitmapUtils.a(BitmapUtils.a(paramGPUBitmapImageRender, i2, i1, true), paramBitmap);
      ((GaussianBlurFilter)localObject).destroy();
      return paramContext;
    }
    return null;
  }
  
  private Bitmap a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    Object localObject2 = HWEditImportVideoPlayer.Mp4VideoFragmentInfo.c(paramMp4VideoFragmentInfo);
    long l2 = this.t.S() / 1000000L;
    long l1 = 0L;
    Object localObject1 = localObject2;
    if (l2 != 0L)
    {
      localObject1 = localObject2;
      if (paramBoolean)
      {
        localObject3 = MediaUtil.a(this.i, this.b, l2);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
    if (localObject1 == null) {
      return null;
    }
    boolean bool = VideoUtils.a(this.b);
    int i1 = 0;
    if ((!bool) && (this.b.rotation == 180)) {
      i1 = 180;
    }
    localObject2 = localObject1;
    if (i1 != 0) {
      localObject2 = UIUtils.a((Bitmap)localObject1, i1);
    }
    Object localObject3 = new GPUBitmapImageRender();
    if (this.g)
    {
      localObject1 = a(u(), (Bitmap)localObject2, (GPUBitmapImageRender)localObject3);
    }
    else
    {
      ((GPUBitmapImageRender)localObject3).a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      localObject1 = localObject2;
    }
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
    if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.d(paramMp4VideoFragmentInfo))
    {
      localObject2 = localObject1;
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.e(paramMp4VideoFragmentInfo) != null)
      {
        GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
        localGPUImagePixelationFilter.a(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.e(paramMp4VideoFragmentInfo));
        localGPUImagePixelationFilter.init();
        localObject2 = ((GPUBitmapImageRender)localObject3).a((Bitmap)localObject1, localGPUImagePixelationFilter);
        SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
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
      localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i1);
    }
    localObject2 = localObject1;
    if (this.h) {
      localObject2 = UIUtils.a((Bitmap)localObject1, 90.0F);
    }
    if ((localObject2 == HWEditImportVideoPlayer.Mp4VideoFragmentInfo.c(paramMp4VideoFragmentInfo)) && (!HWEditImportVideoPlayer.Mp4VideoFragmentInfo.f(paramMp4VideoFragmentInfo)))
    {
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.d(paramMp4VideoFragmentInfo)) {
        return localObject2;
      }
      return paramMp4VideoFragmentInfo.e;
    }
    return localObject2;
  }
  
  private void a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.d), Integer.valueOf(paramMp4VideoFragmentInfo.d));
    if (paramMp4VideoFragmentInfo.a == null)
    {
      if (!this.a.getVideoFilePath().equalsIgnoreCase(this.i))
      {
        this.a.c();
        this.p = this.a.a(this.b);
        this.a.setFilePath(this.i, this.j, true, this.f, this.g);
        this.a.b();
        this.a.e();
        this.q = 1;
      }
      this.a.setPlayRange((int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.t.P != null) {
        this.t.P.d(3, HardCodeUtil.a(2131903645));
      }
    }
    else
    {
      if (!this.a.getVideoFilePath().equalsIgnoreCase(paramMp4VideoFragmentInfo.a))
      {
        this.a.c();
        this.p = this.a.a(this.b);
        this.a.setFilePath(paramMp4VideoFragmentInfo.a, paramMp4VideoFragmentInfo.b, true, this.f, this.g);
        this.a.f();
        this.a.b();
        this.a.e();
        this.q = 1;
      }
      if (this.t.P != null) {
        this.t.P.d(3, "");
      }
    }
    this.d = paramMp4VideoFragmentInfo.d;
  }
  
  private int f(int paramInt)
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
  
  private int g(int paramInt)
  {
    return 0;
  }
  
  private void k()
  {
    if ((this.t.I.a == 14) && (this.t.X() != null) && (!this.t.X().isLandTakePicToVideo()) && ((this.t.I.e instanceof EditLocalVideoSource)))
    {
      int i3 = ((EditLocalVideoSource)this.t.I.e).b.rotation;
      int i1 = this.t.I.e.b();
      int i2 = this.t.I.e.c();
      if ((i3 == 90) || (i3 == 270))
      {
        i1 = Math.min(this.t.I.e.b(), this.t.I.e.c());
        i2 = Math.max(this.t.I.e.b(), this.t.I.e.c());
      }
      float f1 = i1 / i2;
      i2 = ScreenUtil.SCREEN_WIDTH;
      i1 = ScreenUtil.SCREEN_HIGHT;
      if (!ScreenUtil.checkDeviceHasNavigationBar(u())) {
        i1 = ScreenUtil.getRealHeight(u());
      } else {
        i1 = ScreenUtil.SCREEN_HIGHT;
      }
      i3 = (int)(i2 / f1);
      Object localObject = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = i2;
        ((RelativeLayout.LayoutParams)localObject).height = i3;
        ((RelativeLayout.LayoutParams)localObject).addRule(16);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, i1 / 2 - i3 / 2, 0, 0);
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjust view size viewWidth ane viewHeight:");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(i3);
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.c.size()) {
      return a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a()
  {
    super.a();
    this.m = new Handler();
    if ((this.t.I.e instanceof EditLocalVideoSource))
    {
      Object localObject = (EditLocalVideoSource)this.t.I.e;
      this.j = ((EditLocalVideoSource)localObject).a;
      this.b = ((EditLocalVideoSource)localObject).b;
      this.k = ((EditLocalVideoSource)localObject).c;
      this.l = ((EditLocalVideoSource)localObject).d;
      this.i = ((EditLocalVideoSource)localObject).a;
      if ((this.b.mediaWidth == 0) || (this.b.mediaHeight == 0))
      {
        localObject = new MediaMetadataUtils.MetaData();
        MediaMetadataUtils.a(this.i, (MediaMetadataUtils.MetaData)localObject);
        this.b.mediaWidth = localObject.a[0];
        this.b.mediaHeight = localObject.a[1];
        this.b.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LocalMediaInfo:");
        ((StringBuilder)localObject).append(this.b.toString());
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, ((StringBuilder)localObject).toString());
      }
      this.a = ((VideoFilterPlayView)d(2063991125));
      this.a.setVisibility(0);
      if (this.t.I.a != 14)
      {
        this.p = this.a.a(this.b);
      }
      else
      {
        if (((this.t.X() != null) && (this.t.X().isLandTakePicToVideo())) || (!VideoUtils.a(this.b))) {
          this.p = this.a.a(this.b);
        } else if (this.b.rotation == 180) {
          this.p = this.a.a(180);
        }
        if (VideoUtils.a())
        {
          k();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
        }
      }
      this.f = this.t.I.a("extra_is_fit_center", false);
      this.g = this.t.I.a("extra_is_need_gaussion_blur", false);
      if (this.g)
      {
        int i1;
        if (VideoUtils.a(this.b)) {
          i1 = -90;
        } else {
          i1 = 0;
        }
        this.a.b(i1);
      }
      this.a.setMediaInfo(this.b);
      this.a.setFilePath(this.i, this.j, true, this.f, this.g);
      if (this.t.ad != null)
      {
        localObject = (VideoStoryDataBean)this.t.ad.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        boolean bool;
        if ((localObject != null) && (((VideoStoryDataBean)localObject).isLandTakePicToVideo())) {
          bool = true;
        } else {
          bool = false;
        }
        this.h = bool;
      }
      this.a.setRepeat(true);
      this.a.setSpeedType(0);
      this.a.setDecodeListener(this);
      this.a.setPlayViewListener(this);
      this.q = 0;
      a(EditVideoPlayerExport.class, this);
      this.n.postDelayed(new HWEditImportVideoPlayer.1(this), 200L);
      return;
    }
    throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
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
        this.a.setColorFilterType(g(paramInt1), g(paramInt2), f1, localEditLocalVideoSource.b.rotation);
        return;
      }
      if ((this.t.I.e instanceof EditTakeVideoSource)) {
        this.a.setColorFilterType(g(paramInt1), g(paramInt2), f1, 0);
      }
    }
    else
    {
      this.a.setColorFilterType(g(paramInt1));
      c(paramInt1);
      SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.d.videoNeedRotate = false;
    paramGenerateContext.d.videoRangeStart = this.k;
    paramGenerateContext.d.videoRangeEnd = this.l;
    paramGenerateContext.d.putExtra("local_import", Boolean.valueOf(true));
    paramGenerateContext.d.putExtra("video_rotation", Integer.valueOf(this.p));
    boolean bool = VideoUtils.a(this.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("landscape:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" w:");
      localStringBuilder.append(this.b.mediaWidth);
      localStringBuilder.append(" h:");
      localStringBuilder.append(this.b.mediaHeight);
      localStringBuilder.append(" r:");
      localStringBuilder.append(this.b.rotation);
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, localStringBuilder.toString());
    }
    paramGenerateContext.d.putExtra("landscape_video", Boolean.valueOf(bool));
    paramGenerateContext.d.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.g));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.a;
    if (paramObject == null) {
      return;
    }
    if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6))
    {
      paramObject.e();
      this.q = 1;
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
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditImportVideoPlayer.Mp4VideoFragmentInfo.d(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
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
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1), paramBoolean);
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
        this.q = 0;
        return true;
      }
      paramMessage = this.a;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.q = 1;
      }
      return true;
    }
    return false;
  }
  
  public void at_()
  {
    super.at_();
  }
  
  public void ax_()
  {
    super.ax_();
    this.a.d();
    this.a.onPause();
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i1 = this.t.m();
    if (i1 < this.c.size())
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.g(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void c()
  {
    if (this.q == 2)
    {
      this.a.d();
      return;
    }
    this.q = 1;
  }
  
  public void c(int paramInt)
  {
    paramInt = f(paramInt);
    if ((paramInt == 5) && (this.c.size() > 0))
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(this.d);
      if (localMp4VideoFragmentInfo.a == null)
      {
        this.a.d();
        this.q = 2;
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
        a(localMp4VideoFragmentInfo);
      }
      this.a.setSpeedType(5);
      return;
    }
    this.a.setSpeedType(paramInt);
    this.a.e();
    this.q = 1;
  }
  
  public void d()
  {
    this.q = 0;
  }
  
  public void f()
  {
    super.f();
    this.a.onResume();
    if (this.q != 2)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
  
  public void g()
  {
    this.a.c();
    this.q = 0;
    this.a.setPlayViewListener(null);
    Handler localHandler = this.m;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    super.g();
    if ((CaptureFreqMonitor.d) && (this.a.t > 100) && (this.a.s > 0L))
    {
      int i1 = this.t.T();
      float f1 = this.a.t / (float)this.a.s * 1000.0F;
      if (StoryReportor.a((int)f1, 0L, 30L)) {
        StoryReportor.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.t.I.a), String.valueOf(f1), StoryReportor.d(i1), String.valueOf(this.a.t), String.valueOf(this.a.s) });
      }
    }
  }
  
  public void h()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.a;
    localVideoFilterPlayView.n = false;
    localVideoFilterPlayView.d();
    this.q = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 < this.c.size())
    {
      paramMessage = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.c.get(i1);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.e))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.c.set(i1, paramMessage);
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
      }
    }
    return true;
  }
  
  public void i()
  {
    this.a.e();
    this.q = 1;
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    QLog.e("Q.qqstory.record.HWEditImportVideoPlayer", 4, localStringBuilder.toString(), paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    a(new HWEditImportVideoPlayer.3(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    a(new HWEditImportVideoPlayer.4(this), 0L);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    a(new HWEditImportVideoPlayer.2(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer
 * JD-Core Version:    0.7.0.1
 */