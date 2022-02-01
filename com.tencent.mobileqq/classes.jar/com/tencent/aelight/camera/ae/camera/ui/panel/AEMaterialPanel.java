package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.ae.camera.ui.ICaptureController;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AEMaterialPanel
  extends AEAbsBottomPanal
{
  public int a;
  private ICaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialProviderView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
  private VideoStoryCapturePartManager jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public AEMaterialPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    return UIUtils.a(getContext(), 242.0F);
  }
  
  private void a(Runnable paramRunnable)
  {
    e();
    AEMaterialProviderView localAEMaterialProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    if (localAEMaterialProviderView != null) {
      localAEMaterialProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  @TargetApi(12)
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView == null) {
      a();
    }
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F });
    localObjectAnimator.addUpdateListener(new AEMaterialPanel.3(this));
    ((AnimatorSet)localObject).play(localObjectAnimator);
    ((AnimatorSet)localObject).addListener(new AEMaterialPanel.4(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEMaterialPanel.5(this, paramRunnable));
    startAnimation((Animation)localObject);
    if (((getContext() instanceof Activity)) && (AECameraEntryManager.k(((Activity)getContext()).getIntent()))) {
      AEReportUtils.a(5, null);
    }
  }
  
  @RequiresApi(api=11)
  private void c(Runnable paramRunnable)
  {
    AEQLog.a("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    localObjectAnimator.addUpdateListener(new AEMaterialPanel.6(this));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEMaterialPanel.7(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEMaterialPanel.8(this));
    startAnimation(paramRunnable);
  }
  
  private void e()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  private void f()
  {
    ICaptureController localICaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
    if (localICaptureController != null) {
      localICaptureController.a(false, 150);
    }
  }
  
  private void g()
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.a(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = a();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView = new AEMaterialProviderView(getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    if (localObject != null) {
      addView((View)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(String paramString1, String paramString2)
  {
    AEMaterialProviderView localAEMaterialProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    if (localAEMaterialProviderView != null) {
      localAEMaterialProviderView.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    b(null);
    if ((paramBoolean) && (paramString1 != null) && (paramString2 != null)) {
      a(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if ((AECameraEntryManager.k(((Activity)localObject).getIntent())) && (b()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEMaterialPanel.1(this, (Activity)localObject);
        this.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEMaterialPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean) {
      c(paramRunnable);
    } else {
      a(paramRunnable);
    }
    paramRunnable = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (paramRunnable != null) {
      paramRunnable.a(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialPanel", 2, "panel closed");
    }
  }
  
  public boolean a()
  {
    return b() ^ true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEMaterialPanel", 2, "onDestroy()");
    }
    AEMaterialProviderView localAEMaterialProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    if (localAEMaterialProviderView != null)
    {
      localAEMaterialProviderView.b();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean b()
  {
    int i = getVisibility();
    boolean bool2 = false;
    if (i == 8) {
      return false;
    }
    AEMaterialProviderView localAEMaterialProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    boolean bool1 = bool2;
    if (localAEMaterialProviderView != null)
    {
      bool1 = bool2;
      if (localAEMaterialProviderView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    AEMaterialProviderView localAEMaterialProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialProviderView;
    if (localAEMaterialProviderView != null) {
      localAEMaterialProviderView.a();
    }
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController = paramICaptureController;
  }
  
  public void setMaterialPanelListener(AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */