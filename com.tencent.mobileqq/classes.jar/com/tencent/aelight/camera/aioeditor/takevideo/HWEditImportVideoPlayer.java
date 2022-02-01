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
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected VideoFilterPlayView a;
  protected LocalMediaInfo a;
  private String jdField_a_of_type_JavaLangString;
  protected List<HWEditImportVideoPlayer.Mp4VideoFragmentInfo> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  final boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean;
  private int e = 0;
  
  public HWEditImportVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
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
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, GPUBitmapImageRender paramGPUBitmapImageRender)
  {
    if ((paramBitmap != null) && (paramGPUBitmapImageRender != null))
    {
      Object localObject = VideoUtils.a(paramBitmap.getWidth(), paramBitmap.getHeight(), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
      int m = ((Integer)((Pair)localObject).first).intValue();
      int n = ((Integer)((Pair)localObject).second).intValue();
      int k = MergeEditVideo.jdField_a_of_type_Int;
      int i = n;
      int j = m;
      if (n > k)
      {
        double d1 = m;
        double d2 = k;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3 = n;
        Double.isNaN(d3);
        j = (int)(d1 * d2 / d3);
        i = k;
      }
      j = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(j);
      i = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(i);
      paramGPUBitmapImageRender.a(j, i);
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
      paramContext = BitmapUtils.a(BitmapUtils.a(paramGPUBitmapImageRender, j, i, true), paramBitmap);
      ((GaussianBlurFilter)localObject).destroy();
      return paramContext;
    }
    return null;
  }
  
  private Bitmap a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    Object localObject2 = HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo);
    long l2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() / 1000000L;
    long l1 = 0L;
    Object localObject1 = localObject2;
    if (l2 != 0L)
    {
      localObject1 = localObject2;
      if (paramBoolean)
      {
        localObject3 = MediaUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
    if (localObject1 == null) {
      return null;
    }
    boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    int i = 0;
    if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180)) {
      i = 180;
    }
    localObject2 = localObject1;
    if (i != 0) {
      localObject2 = UIUtils.a((Bitmap)localObject1, i);
    }
    Object localObject3 = new GPUBitmapImageRender();
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = a(a(), (Bitmap)localObject2, (GPUBitmapImageRender)localObject3);
    }
    else
    {
      ((GPUBitmapImageRender)localObject3).a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      localObject1 = localObject2;
    }
    localObject2 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.jdField_c_of_type_Int);
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
    if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
    {
      localObject2 = localObject1;
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo) != null)
      {
        GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
        localGPUImagePixelationFilter.a(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
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
    if (i != 0) {
      localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i);
    }
    localObject2 = localObject1;
    if (this.jdField_d_of_type_Boolean) {
      localObject2 = UIUtils.a((Bitmap)localObject1, 90.0F);
    }
    if ((localObject2 == HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) && (!HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo)))
    {
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
        return localObject2;
      }
      return paramMp4VideoFragmentInfo.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    return localObject2;
  }
  
  private void a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramMp4VideoFragmentInfo.jdField_a_of_type_Int));
    if (paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.e = 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter.d(3, HardCodeUtil.a(2131705760));
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString, paramMp4VideoFragmentInfo.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.e = 1;
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
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      int k = ((EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a();
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        i = Math.min(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b());
        j = Math.max(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b());
      }
      float f = i / j;
      j = ScreenUtil.SCREEN_WIDTH;
      i = ScreenUtil.SCREEN_HIGHT;
      if (!ScreenUtil.checkDeviceHasNavigationBar(a())) {
        i = ScreenUtil.getRealHeight(a());
      } else {
        i = ScreenUtil.SCREEN_HIGHT;
      }
      k = (int)(j / f);
      Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = j;
        ((RelativeLayout.LayoutParams)localObject).height = k;
        ((RelativeLayout.LayoutParams)localObject).addRule(16);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, i / 2 - k / 2, 0, 0);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjust view size viewWidth ane viewHeight:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(k);
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void A_()
  {
    super.A_();
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new MediaMetadataUtils.MetaData();
        MediaMetadataUtils.a(this.jdField_a_of_type_JavaLangString, (MediaMetadataUtils.MetaData)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = localObject.a[0];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = localObject.a[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LocalMediaInfo:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2064122251));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 14)
      {
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      }
      else
      {
        if (((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().isLandTakePicToVideo())) || (!VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(180);
        }
        if (VideoUtils.a())
        {
          j();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
        }
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_is_fit_center", false);
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if (this.jdField_c_of_type_Boolean)
      {
        int i;
        if (VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          i = -90;
        } else {
          i = 0;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.a(i);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = (VideoStoryDataBean)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        boolean bool;
        if ((localObject != null) && (((VideoStoryDataBean)localObject).isLandTakePicToVideo())) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_d_of_type_Boolean = bool;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.e = 0;
      a(EditVideoPlayerExport.class, this);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditImportVideoPlayer.1(this), 200L);
      return;
    }
    throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setVolume(paramFloat);
  }
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
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
      SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.a.videoNeedRotate = false;
    paramGenerateContext.a.videoRangeStart = this.jdField_b_of_type_Int;
    paramGenerateContext.a.videoRangeEnd = this.jdField_c_of_type_Int;
    paramGenerateContext.a.putExtra("local_import", Boolean.valueOf(true));
    paramGenerateContext.a.putExtra("video_rotation", Integer.valueOf(this.jdField_d_of_type_Int));
    boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("landscape:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" w:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      localStringBuilder.append(" h:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
      localStringBuilder.append(" r:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, localStringBuilder.toString());
    }
    paramGenerateContext.a.putExtra("landscape_video", Boolean.valueOf(bool));
    paramGenerateContext.a.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.jdField_c_of_type_Boolean));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    if (paramObject == null) {
      return;
    }
    if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6))
    {
      paramObject.e();
      this.e = 1;
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
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
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
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
        this.e = 0;
        return true;
      }
      paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.e = 1;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.e == 2)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.e = 1;
  }
  
  public void b(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.e = 2;
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
        a(localMp4VideoFragmentInfo);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.e = 1;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.e != 2)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c();
    this.e = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    super.e();
    if ((CaptureFreqMonitor.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g();
      float f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (StoryReportor.a((int)f, 0L, 30L)) {
        StoryReportor.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), StoryReportor.b(i), String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public void g()
  {
    this.e = 0;
  }
  
  public void h()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView;
    localVideoFilterPlayView.jdField_a_of_type_Boolean = false;
    localVideoFilterPlayView.d();
    this.e = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
      }
    }
    return true;
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
  
  public void w_()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.e = 1;
  }
  
  public void z_()
  {
    super.z_();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer
 * JD-Core Version:    0.7.0.1
 */