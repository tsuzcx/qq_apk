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
  AEWaterMarkProviderView a;
  public int b = getOpenedHeight();
  private boolean c = false;
  private boolean d = false;
  private AEWaterMarkPanel.AEWaterMarkPanelListener e;
  private VideoStoryCapturePartManager g;
  private Runnable h;
  private ICaptureController i;
  private AEWatermarkMaterialManager.IWatermarkMgrListener j;
  private AEVideoStoryTopBarViewModel.Ratio k;
  
  public AEWaterMarkPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Runnable paramRunnable)
  {
    i();
    AEWaterMarkProviderView localAEWaterMarkProviderView = this.a;
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
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.b });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEWaterMarkPanel.3(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.a, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEWaterMarkPanel.4(this));
    startAnimation(paramRunnable);
  }
  
  @TargetApi(12)
  private void c(Runnable paramRunnable)
  {
    if (this.a == null) {
      j();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.b, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEWaterMarkPanel.7(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.a, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEWaterMarkPanel.8(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void f()
  {
    ICaptureController localICaptureController = this.i;
    if (localICaptureController != null) {
      localICaptureController.a(false, 150);
    }
  }
  
  private void g()
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.g;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.b(131075, new Object[0]);
    }
  }
  
  private int getOpenedHeight()
  {
    return UIUtils.a(getContext(), 195.0F);
  }
  
  private void i()
  {
    setTranslationY(getOpenedHeight());
    setVisibility(8);
  }
  
  @TargetApi(11)
  private void j()
  {
    AEQLog.a("AEWaterMarkPanel", "watermark loadView");
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getOpenedHeight();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.a == null)
    {
      this.a = new AEWaterMarkProviderView(getContext(), this.e);
      addView(this.a);
      localObject = this.a;
      if (localObject != null) {
        ((AEWaterMarkProviderView)localObject).setCaptureRadio(this.k);
      }
      k();
      this.j = new AEWaterMarkPanel.5(this);
      AEWatermarkMaterialManager.a().a(this.j);
    }
  }
  
  private void k()
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
      if ((AECameraEntryManager.o(((Activity)localObject).getIntent())) && (b()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEWaterMarkPanel.1(this, (Activity)localObject);
        this.h = ((Runnable)localObject);
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
    paramRunnable = this.g;
    if (paramRunnable != null) {
      paramRunnable.b(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEWaterMarkPanel", 2, "panel closed");
    }
  }
  
  public boolean b()
  {
    int m = getVisibility();
    boolean bool2 = false;
    if (m == 8) {
      return false;
    }
    AEWaterMarkProviderView localAEWaterMarkProviderView = this.a;
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEWaterMarkPanel", 2, "onDestroy()");
    }
    if (this.a != null) {
      this.a = null;
    }
    if (this.h != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.h);
    }
    if (this.j != null) {
      AEWatermarkMaterialManager.a().b(this.j);
    }
  }
  
  public void d() {}
  
  public boolean e()
  {
    return false;
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.i = paramICaptureController;
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCaptureRadio ");
    ((StringBuilder)localObject).append(paramRatio);
    AEQLog.a("AEWaterMarkPanel", ((StringBuilder)localObject).toString());
    this.k = paramRatio;
    localObject = this.a;
    if (localObject != null) {
      ((AEWaterMarkProviderView)localObject).setCaptureRadio(paramRatio);
    }
  }
  
  public void setMaterialPanelListener(AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.e = paramAEWaterMarkPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.g = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel
 * JD-Core Version:    0.7.0.1
 */