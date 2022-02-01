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
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected VideoFilterPlayView a;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected LocalMediaInfo a;
  private Mp4ReEncoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HWEditLocalVideoPlayer.2(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<HWEditLocalVideoPlayer.Mp4VideoFragmentInfo> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  
  public HWEditLocalVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(int paramInt)
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
  
  private Bitmap a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    Object localObject1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo);
    long l2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() / 1000000L;
    long l1 = 0L;
    Object localObject2 = localObject1;
    if (l2 != 0L)
    {
      localObject2 = localObject1;
      if (paramBoolean)
      {
        localObject3 = MediaUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
      }
    }
    if (localObject2 == null) {
      return null;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    localObject1 = localObject2;
    if (i != 0) {
      localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i);
    }
    Object localObject3 = new GPUBitmapImageRender();
    ((GPUBitmapImageRender)localObject3).a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
    localObject2 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if ((localObject2 != null) && (((QQFilterRenderManager)localObject2).getBusinessOperation().hasAvOrSpecialEffect()))
    {
      if (paramBoolean) {
        l1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
      }
      localObject2 = ((GPUBitmapImageRender)localObject3).a((Bitmap)localObject1, l1);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
    {
      localObject2 = localObject1;
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo) != null)
      {
        GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
        localGPUImagePixelationFilter.a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
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
    if (i != 0) {
      localObject1 = UIUtils.a((Bitmap)localObject2, i);
    }
    if ((localObject1 == HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) && (!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo)))
    {
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
        return localObject1;
      }
      return paramMp4VideoFragmentInfo.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    return localObject1;
  }
  
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable a(int paramInt)
  {
    if ((!Build.MODEL.equalsIgnoreCase("MX5")) && (!Build.MODEL.contains("vivo X5")) && (!Build.MODEL.equalsIgnoreCase("M2 Note")) && (!Build.MODEL.equalsIgnoreCase("m1 metal")) && (!Build.MODEL.equalsIgnoreCase("HLA Note3")) && (!Build.MODEL.equalsIgnoreCase("OPPO R7")) && (!Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 30, 0, paramInt);
    }
    return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 3, 1, paramInt);
  }
  
  private void a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramMp4VideoFragmentInfo.jdField_a_of_type_Int));
    if (paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter.d(3, HardCodeUtil.a(2131705765));
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString, paramMp4VideoFragmentInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter.d(3, "");
      }
    }
    this.jdField_a_of_type_Int = paramMp4VideoFragmentInfo.jdField_a_of_type_Int;
  }
  
  private int b(int paramInt)
  {
    return 0;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
    if (localObject == null)
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_Int);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)((Iterator)localObject).next();
          if ((!localMp4VideoFragmentInfo.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localMp4VideoFragmentInfo.jdField_a_of_type_Int);
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.c));
      return;
    }
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(((HWEditLocalVideoPlayer.ConvertIFramesRunnable)localObject).jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.c));
  }
  
  private void j()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e(false);
        return;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e(true);
    }
  }
  
  public void A_()
  {
    super.A_();
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder;
    if (localObject != null)
    {
      ((Mp4ReEncoder)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public LocalMediaInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith(".mp3")))
      {
        localObject = (QimMusicPlayer)QIMManager.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.jdField_b_of_type_JavaLangString);
        if (localMusicItemInfo != null)
        {
          ((QimMusicPlayer)localObject).a(localMusicItemInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(Image2Video.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("/noaudio");
          localObject = ((StringBuilder)localObject).toString();
          FileUtils.createFileIfNotExits((String)localObject);
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2064122251));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.jdField_b_of_type_Int = 0;
      a(EditVideoPlayerExport.class, this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.1(this), 200L);
      return;
    }
    throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setVolume(paramFloat);
  }
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f != 0.0F) && (f <= 0.95F))
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1));
      b(paramInt1);
      SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if ((paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder;
      if (localObject != null)
      {
        ((Mp4ReEncoder)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder = null;
      }
      localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoNeedRotate = false;
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mIFrameVideoPath = ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_JavaLangString;
      boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("landscape:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" w:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
        ((StringBuilder)localObject).append(" h:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
        ((StringBuilder)localObject).append(" r:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, ((StringBuilder)localObject).toString());
      }
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    if (paramObject == null) {
      return;
    }
    if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (!this.jdField_b_of_type_Boolean))
    {
      paramObject.e();
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setMosaicFilterType(paramBitmap);
  }
  
  public void a(TransferData paramTransferData)
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    if (localVideoFilterPlayView != null) {
      localVideoFilterPlayView.setTransferData(paramTransferData);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      int i = paramMessage.arg1;
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_b_of_type_Int = 0;
        return true;
      }
      paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.jdField_b_of_type_Int = 1;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  public void b(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_b_of_type_Int = 2;
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
        a(localMp4VideoFragmentInfo);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
      this.jdField_b_of_type_Int = 1;
    }
    j();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    if (localObject != null)
    {
      ((VideoFilterPlayView)localObject).c();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.h();
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    }
    super.e();
    if (CaptureFreqMonitor.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
      if ((localObject != null) && (((VideoFilterPlayView)localObject).j > 100) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
      {
        int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g();
        float f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
        if (StoryReportor.a((int)f, 0L, 30L)) {
          StoryReportor.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), StoryReportor.b(i), String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c) });
        }
      }
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public void h()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    localVideoFilterPlayView.jdField_a_of_type_Boolean = false;
    localVideoFilterPlayView.d();
    this.jdField_b_of_type_Int = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramMessage = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
      }
    }
    return true;
  }
  
  public void o()
  {
    super.o();
    this.jdField_c_of_type_Boolean = true;
    c(0);
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
    if (this.jdField_b_of_type_Int != 2) {
      a(new HWEditLocalVideoPlayer.4(this), 0L);
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if (this.jdField_b_of_type_Int != 2)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        a(this.jdField_a_of_type_JavaLangRunnable, 200L);
      }
    }
  }
  
  public void w_()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_b_of_type_Int = 1;
  }
  
  public void z_()
  {
    super.z_();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */