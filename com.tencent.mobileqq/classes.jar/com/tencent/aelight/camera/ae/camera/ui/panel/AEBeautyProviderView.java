package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AEBeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 500;
  protected View a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new AEBeautyProviderView.1(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  protected TextView a;
  private AECaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
  private AEProviderContainerView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView;
  public boolean a;
  private final int jdField_b_of_type_Int = 300;
  private View jdField_b_of_type_AndroidViewView;
  private SeekBar.OnSeekBarChangeListener jdField_b_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new AEBeautyProviderView.2(this);
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  protected TextView b;
  private View c;
  private View d;
  
  public AEBeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AEBeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_beauty_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.jdField_a_of_type_Int);
    str = localStringBuilder.toString();
    if (FlowCameraConstant.jdField_a_of_type_Int == 2) {
      i = 0;
    } else {
      i = 55;
    }
    int i = AECameraPrefsUtil.a().a(str, i, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBeautyFeature BeautyLevel=");
      localStringBuilder.append(i);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private Animation a(AEProviderContainerView paramAEProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new ValueAnimation(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new AEBeautyProviderView.3(this, paramAEProviderContainerView, paramView));
  }
  
  private void a(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_beauty_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.jdField_a_of_type_Int);
    str = localStringBuilder.toString();
    AECameraPrefsUtil.a().a(str, paramInt, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveBeautyFeature BeautyLevel=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", key: ");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setMotionEventSplittingEnabled(false);
    }
    int j = 300;
    localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((Animation)localObject).hasEnded())
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
        i = 0;
      }
    }
    paramView1.setAlpha(1.0F);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView.b()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView, paramView2, this.jdField_a_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration((this.jdField_a_of_type_Float * this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setStartOffset(i);
    startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public static int b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (FlowCameraConstant.jdField_a_of_type_Int == 2) {
      i = 0;
    } else {
      i = 40;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_sharp_face_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.jdField_a_of_type_Int);
    str = localStringBuilder.toString();
    int i = AECameraPrefsUtil.a().a(str, i, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSharpFaceFeature SharpFaceLevel = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private void b(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_sharp_face_level_");
    localStringBuilder.append(str);
    localStringBuilder.append("_CAMERA_ID_");
    localStringBuilder.append(FlowCameraConstant.jdField_a_of_type_Int);
    str = localStringBuilder.toString();
    AECameraPrefsUtil.a().a(str, paramInt, 0);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSharpFaceFeature SharpFaceLevel = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", key:");
      localStringBuilder.append(str);
      QLog.d("AEBeautyProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void b(View paramView1, View paramView2)
  {
    Animation localAnimation = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    if ((localAnimation != null) && (!localAnimation.hasEnded())) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    }
    paramView1.setAlpha(1.0F);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView.b()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView, paramView2, this.jdField_a_of_type_Float, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(((1.0F - this.jdField_a_of_type_Float) * this.jdField_a_of_type_Int));
    startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private int c()
  {
    int i = a();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(i / 10.0F);
    localTextView.setText(localStringBuilder.toString());
    return i;
  }
  
  private int d()
  {
    int i = b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    localTextView.setText(localStringBuilder.toString());
    return i;
  }
  
  public void a()
  {
    c();
  }
  
  @TargetApi(11)
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562861, this, true);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_AndroidViewView = ((Activity)getContext()).findViewById(2064122225);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2064121976));
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363482);
    if (!CaptureUtil.d()) {
      this.c.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363489));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setSplitTrack(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363483));
    c();
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131377429);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377431));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_b_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setSplitTrack(false);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377430));
    d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = c();
    AECaptureController localAECaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if (localAECaptureController != null) {
      localAECaptureController.a(i);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int i = d();
      AECaptureController localAECaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
      if (localAECaptureController != null) {
        localAECaptureController.b(i);
      }
      i = c();
      localAECaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
      if (localAECaptureController != null) {
        localAECaptureController.a(i);
      }
    }
  }
  
  public void setController(AECaptureController paramAECaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = paramAECaptureController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView
 * JD-Core Version:    0.7.0.1
 */