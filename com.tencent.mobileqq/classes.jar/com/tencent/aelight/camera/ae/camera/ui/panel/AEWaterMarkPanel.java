package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.tencent.aelight.camera.ae.camera.ui.ICaptureController;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager;
import com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager.IWatermarkMgrListener;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AEWaterMarkPanel
  extends AEAbsBottomPanal
{
  public int a;
  private ICaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  AEWaterMarkProviderView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEWatermarkMaterialManager.IWatermarkMgrListener jdField_a_of_type_ComTencentAelightCameraAeDataAEWatermarkMaterialManager$IWatermarkMgrListener;
  private VideoStoryCapturePartManager jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public AEWaterMarkPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    return UIUtils.a(getContext(), 195.0F);
  }
  
  private void a(Runnable paramRunnable)
  {
    g();
    AEWaterMarkProviderView localAEWaterMarkProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView;
    if (localAEWaterMarkProviderView != null) {
      localAEWaterMarkProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    AEQLog.a("AEWaterMarkPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEWaterMarkPanel.3(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEWaterMarkPanel.4(this));
    startAnimation(paramRunnable);
  }
  
  @TargetApi(12)
  private void c(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView == null) {
      h();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEWaterMarkPanel.7(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEWaterMarkPanel.8(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void e()
  {
    ICaptureController localICaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
    if (localICaptureController != null) {
      localICaptureController.a(false, 150);
    }
  }
  
  private void f()
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.a(131075, new Object[0]);
    }
  }
  
  private void g()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  @TargetApi(11)
  private void h()
  {
    AEQLog.a("AEWaterMarkPanel", "watermark loadView");
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = a();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView = new AEWaterMarkProviderView(getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
      addView(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView;
      if (localObject != null) {
        ((AEWaterMarkProviderView)localObject).setCaptureRadio(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      }
      i();
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEWatermarkMaterialManager$IWatermarkMgrListener = new AEWaterMarkPanel.5(this);
      AEWatermarkMaterialManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEWatermarkMaterialManager$IWatermarkMgrListener);
    }
  }
  
  private void i()
  {
    ThreadManager.excute(new AEWaterMarkPanel.6(this), 64, null, false);
  }
  
  public void a()
  {
    c(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if ((AECameraEntryManager.k(((Activity)localObject).getIntent())) && (b()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEWaterMarkPanel.1(this, (Activity)localObject);
        this.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEWaterMarkPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean) {
      b(paramRunnable);
    } else {
      a(paramRunnable);
    }
    paramRunnable = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (paramRunnable != null) {
      paramRunnable.a(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEWaterMarkPanel", 2, "panel closed");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEWaterMarkPanel", 2, "onDestroy()");
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEWatermarkMaterialManager$IWatermarkMgrListener != null) {
      AEWatermarkMaterialManager.a().b(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEWatermarkMaterialManager$IWatermarkMgrListener);
    }
  }
  
  public boolean b()
  {
    int i = getVisibility();
    boolean bool2 = false;
    if (i == 8) {
      return false;
    }
    AEWaterMarkProviderView localAEWaterMarkProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView;
    boolean bool1 = bool2;
    if (localAEWaterMarkProviderView != null)
    {
      bool1 = bool2;
      if (localAEWaterMarkProviderView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c() {}
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController = paramICaptureController;
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCaptureRadio ");
    ((StringBuilder)localObject).append(paramRatio);
    AEQLog.a("AEWaterMarkPanel", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkProviderView;
    if (localObject != null) {
      ((AEWaterMarkProviderView)localObject).setCaptureRadio(paramRatio);
    }
  }
  
  public void setMaterialPanelListener(AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel
 * JD-Core Version:    0.7.0.1
 */