package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.libpag.PAGView;

public class AETipsViewController
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new AETipsViewController.TipsHandler(this);
  private View jdField_a_of_type_AndroidViewView;
  private final ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private FaceDetectTipGifViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder;
  private FaceDetectTipViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder;
  private MaterialTipsViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = AECaptureMode.NORMAL;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  
  public AETipsViewController(View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder = new FaceDetectTipViewStubHolder((ViewStub)paramView.findViewById(2064122650));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder = new FaceDetectTipGifViewStubHolder((ViewStub)paramView.findViewById(2064122651));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder = new MaterialTipsViewStubHolder((ViewStub)paramView.findViewById(2064122661));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2064122660));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AETipsViewController.1(this));
    paramView = new HashMap();
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value), "张开你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value), "挑动你的眉毛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK.value), "眨眨你的眼睛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.KISS.value), "嘟起你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value), "眨眨你的左眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value), "眨眨你的右眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_NOD.value), "点一点你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value), "点击屏幕试试");
    AETipsManager.getInstance().updateActionTipsString(paramView);
  }
  
  private void b(VideoMaterial paramVideoMaterial)
  {
    k();
    if (paramVideoMaterial == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
    AETipsManager.getInstance().setVideoMaterial(paramVideoMaterial);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.PLAY)
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.b();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.PLAY)
    {
      b();
      return;
    }
    VideoMaterial localVideoMaterial;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
      localVideoMaterial = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
      if ((localVideoMaterial != null) && (localVideoMaterial.needFaceInfo()))
      {
        if (this.d)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
          j();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
        j();
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
      localVideoMaterial = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
      if ((localVideoMaterial != null) && (localVideoMaterial.needFaceInfo()))
      {
        if (this.d)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
          j();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
        j();
      }
    }
  }
  
  private void j()
  {
    if (!this.g)
    {
      MaterialTipsViewStubHolder localMaterialTipsViewStubHolder = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder;
      String str = this.jdField_a_of_type_JavaLangString;
      Bitmap localBitmap;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localBitmap = null;
      } else {
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localMaterialTipsViewStubHolder.a(str, localBitmap, 3000);
      this.g = true;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.g = false;
    b(paramVideoMaterial);
    g();
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPagTip: pagPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AETipsViewController", localStringBuilder.toString());
    if (this.jdField_a_of_type_OrgLibpagPAGView == null) {
      this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    this.jdField_a_of_type_OrgLibpagPAGView.addPAGFlushListener(new AETipsViewController.3(this));
    this.jdField_a_of_type_OrgLibpagPAGView.setPath(paramString);
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(1);
    this.jdField_a_of_type_OrgLibpagPAGView.addListener(new AETipsViewController.4(this));
    this.jdField_a_of_type_OrgLibpagPAGView.flush();
    this.jdField_a_of_type_OrgLibpagPAGView.setProgress(0.0D);
    this.jdField_a_of_type_OrgLibpagPAGView.setVisibility(0);
    this.jdField_a_of_type_OrgLibpagPAGView.play();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNormalTip: tip=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AETipsViewController", localStringBuilder.toString());
    paramString2 = BitmapUtils.decodeSampleBitmap(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(), paramString2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder.a(paramString1, paramString2, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
    if ((this.jdField_b_of_type_Boolean != this.c) || (this.d != this.e))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("### onDetectStateChange, materialNeedFace=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", hasFaceDetected=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("AETipsViewController", 4, localStringBuilder.toString());
      this.c = this.jdField_b_of_type_Boolean;
      this.e = this.d;
      g();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.c();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipViewStubHolder.d();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsFaceDetectTipGifViewStubHolder.d();
  }
  
  public void d()
  {
    QLog.d("AETipsViewController", 4, "### onChangeCameraByMaterial");
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public void e()
  {
    AEQLog.a("AETipsViewController", "hideNormalTip: ");
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsMaterialTipsViewStubHolder.b();
  }
  
  public void f()
  {
    AEQLog.a("AETipsViewController", "hidePagTip: ");
    PAGView localPAGView = this.jdField_a_of_type_OrgLibpagPAGView;
    if (localPAGView == null) {
      return;
    }
    if (localPAGView.isPlaying()) {
      this.jdField_a_of_type_OrgLibpagPAGView.stop();
    }
    this.jdField_a_of_type_OrgLibpagPAGView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController
 * JD-Core Version:    0.7.0.1
 */