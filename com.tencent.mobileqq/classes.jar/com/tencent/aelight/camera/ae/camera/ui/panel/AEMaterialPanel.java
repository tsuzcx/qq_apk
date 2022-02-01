package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
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
  public int a = getOpenedHeight();
  private AEMaterialProviderView b;
  private boolean c = false;
  private boolean d = false;
  private ICaptureController e;
  private VideoStoryCapturePartManager g;
  private AEMaterialPanel.AEMaterialPanelListener h;
  private Runnable i;
  
  public AEMaterialPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Runnable paramRunnable)
  {
    f();
    AEMaterialProviderView localAEMaterialProviderView = this.b;
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
    if (this.b == null) {
      a();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.a, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEMaterialPanel.3(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.b, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEMaterialPanel.4(this, paramRunnable));
    startAnimation((Animation)localObject);
    if (((getContext() instanceof Activity)) && (AECameraEntryManager.o(((Activity)getContext()).getIntent()))) {
      AEReportUtils.a(5, null);
    }
  }
  
  @RequiresApi(api=11)
  private void c(Runnable paramRunnable)
  {
    AEQLog.a("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.a });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEMaterialPanel.5(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.b, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEMaterialPanel.6(this));
    startAnimation(paramRunnable);
  }
  
  private void f()
  {
    setTranslationY(getOpenedHeight());
    setVisibility(8);
  }
  
  private void g()
  {
    ICaptureController localICaptureController = this.e;
    if (localICaptureController != null) {
      localICaptureController.a(false, 150);
    }
  }
  
  private int getOpenedHeight()
  {
    return UIUtils.a(getContext(), 242.0F);
  }
  
  private void i()
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.g;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.b(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = getOpenedHeight();
    setLayoutParams(localLayoutParams);
    this.b = new AEMaterialProviderView(getContext(), this.h);
    addView(this.b);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(String paramString1, String paramString2)
  {
    AEMaterialProviderView localAEMaterialProviderView = this.b;
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
      if ((AECameraEntryManager.o(((Activity)localObject).getIntent())) && (c()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEMaterialPanel.1(this, (Activity)localObject);
        this.i = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEMaterialPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!c()) {
      return;
    }
    if (paramBoolean) {
      c(paramRunnable);
    } else {
      a(paramRunnable);
    }
    paramRunnable = this.g;
    if (paramRunnable != null) {
      paramRunnable.b(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialPanel", 2, "panel closed");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEMaterialPanel", 2, "onDestroy()");
    }
    AEMaterialProviderView localAEMaterialProviderView = this.b;
    if (localAEMaterialProviderView != null)
    {
      localAEMaterialProviderView.b();
      this.b = null;
    }
    if (this.i != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.i);
    }
  }
  
  public boolean c()
  {
    int j = getVisibility();
    boolean bool2 = false;
    if (j == 8) {
      return false;
    }
    AEMaterialProviderView localAEMaterialProviderView = this.b;
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
  
  public void d()
  {
    AEMaterialProviderView localAEMaterialProviderView = this.b;
    if (localAEMaterialProviderView != null) {
      localAEMaterialProviderView.a();
    }
  }
  
  public boolean e()
  {
    return c() ^ true;
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.e = paramICaptureController;
  }
  
  public void setMaterialPanelListener(AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.h = paramAEMaterialPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.g = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */