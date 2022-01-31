import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMStoryFollowCaptureUnit.1;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@TargetApi(18)
public class bkju
  extends bkjt
{
  private static int d;
  private static int e;
  private volatile boolean A;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private FollowCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView;
  private Stack<Integer> jdField_a_of_type_JavaUtilStack = new Stack();
  private LocalMediaInfo b;
  private CameraCaptureView.VideoCaptureResult c;
  
  static
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    jdField_d_of_type_Int = localDisplayMetrics.widthPixels;
    e = localDisplayMetrics.heightPixels;
  }
  
  public bkju(bmcv parambmcv, bmcu parambmcu)
  {
    super(parambmcv, parambmcu);
  }
  
  private void af()
  {
    if (azcw.e())
    {
      localObject = axld.a(this.jdField_a_of_type_Bmcv.a());
      if (localObject != null)
      {
        jdField_d_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
        e = ((DisplayMetrics)localObject).heightPixels;
      }
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (e / 2);
    int j = bdkf.a(48.0F);
    int i = bdkf.a(44.0F);
    int k = bdkf.a(118.0F);
    k = e - k - i - j;
    i = k;
    if (this.jdField_d_of_type_Boolean) {
      i = k - (this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height + this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height);
    }
    if (i - ((RelativeLayout.LayoutParams)localObject).height > 0) {}
    for (i = (i - ((RelativeLayout.LayoutParams)localObject).height) / 2 + j;; i = j)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.e(false);
      return;
    }
  }
  
  public void A()
  {
    super.A();
    this.jdField_a_of_type_JavaUtilStack.pop();
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView.e(((Integer)this.jdField_a_of_type_JavaUtilStack.peek()).intValue());
  }
  
  protected void B()
  {
    e(false);
  }
  
  public void H()
  {
    super.H();
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().b(true);
  }
  
  public void L()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.B();
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      e(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.h(false);
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
  }
  
  public void T()
  {
    super.T();
    af();
  }
  
  public int a()
  {
    return 2131560732;
  }
  
  public View a()
  {
    View localView = super.a();
    af();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setFunctionFlag(3);
    return localView;
  }
  
  protected axkq a()
  {
    return new bkjv(this, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected axmk a()
  {
    axmk localaxmk = super.a();
    localaxmk.g(jdField_d_of_type_Int);
    localaxmk.h(e);
    localaxmk.a(false);
    return localaxmk;
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryFollowCaptureUnit", 2, "onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.jdField_a_of_type_Bmcv.a().getIntent().getSerializableExtra("extra_follow_capture_param"));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131710226), 0).a();
      this.jdField_a_of_type_Bmcv.a().finish();
      return;
    }
    this.jdField_a_of_type_Bmcn.b = 108;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b(true);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(true);
    d(true);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView = ((FollowCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView);
    paramBundle = BaseApplicationImpl.getContext().getResources().getString(2131699830);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setIsFollowCaptureTips();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.e();
    ThreadManagerV2.excute(new QIMStoryFollowCaptureUnit.1(this), 16, null, true);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().b(false);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().b();
    this.jdField_a_of_type_JavaUtilStack.push(Integer.valueOf(0));
    bncp.a().b(false);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    if ((!this.A) || (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult == null) || (paramLocalMediaInfo == null)) {
      return;
    }
    this.jdField_a_of_type_Bmcv.a().getIntent().putExtra("extra_follow_capture_param", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) {
      paramVideoCaptureResult.audioDataFilePath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.audioPath;
    }
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
  }
  
  protected void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.b(paramVideoCaptureResult, paramLocalMediaInfo);
    this.jdField_a_of_type_JavaUtilStack.push(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView.f()));
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryFollowCaptureUnit", 2, "onSegmentVideoOneCaptured: localMediaInfo.duration = " + paramLocalMediaInfo.mDuration + " ; playPosition = " + this.jdField_a_of_type_JavaUtilStack.peek());
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkju
 * JD-Core Version:    0.7.0.1
 */