package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.tencent.aelight.camera.ae.camera.ui.ICaptureController;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEARCakePanel
  extends AEAbsBottomPanal
{
  private static int l = 1;
  AEARCakeProvidewView a;
  boolean b = false;
  public int c = getOpenedHeight();
  boolean d = false;
  AEARCakeMaterialManager.IARcakeMgrListener e = new AEARCakePanel.5(this);
  private boolean g = false;
  private List<AEGiftMaterial> h;
  private ICaptureController i;
  private VideoStoryCapturePartManager j;
  private AEARCakePanel.AEARCakePanelListener k;
  private Context m;
  
  public AEARCakePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEARCakePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEARCakePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.m = paramContext;
  }
  
  @TargetApi(12)
  private void a(Runnable paramRunnable)
  {
    if (this.a == null) {
      c();
    } else {
      g();
    }
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { this.c, 0.0F });
    localObjectAnimator.addUpdateListener(new AEARCakePanel.2(this));
    ((AnimatorSet)localObject).play(localObjectAnimator);
    ((AnimatorSet)localObject).addListener(new AEARCakePanel.3(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.a, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEARCakePanel.4(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void b(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.c });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEARCakePanel.7(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.a, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEARCakePanel.8(this));
    startAnimation(paramRunnable);
  }
  
  private void f()
  {
    AEQLog.a("AEARCakePanel", "showCaptureLayout");
    Object localObject = this.i;
    if (localObject != null) {
      ((ICaptureController)localObject).a(false, 150);
    }
    localObject = this.j;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).b(327699, new Object[] { Boolean.valueOf(i()) });
    }
  }
  
  private void g()
  {
    if (!this.d)
    {
      AEQLog.d("AEARCakePanel", "arcake :not arcake mode can not refresh data");
      return;
    }
    List localList = AEARCakeMaterialManager.a().b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake : giftMaterials size : ");
    ((StringBuilder)localObject1).append(localList.size());
    AEQLog.b("AEARCakePanel", ((StringBuilder)localObject1).toString());
    this.h = localList;
    if (CollectionUtils.isEmpty(localList)) {
      return;
    }
    localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (AEGiftMaterial)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake : gift : ");
      localStringBuilder.append(((AEGiftMaterial)localObject2).toString());
      AEQLog.a("AEARCakePanel", localStringBuilder.toString());
      localObject2 = ((AEGiftMaterial)localObject2).c();
      if (localObject2 == null)
      {
        AEQLog.a("AEARCakePanel", "arcake : aeArCakeMaterial is null ");
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("arcake : gift : ");
        localStringBuilder.append(((AEARCakeMaterial)localObject2).toString());
        AEQLog.a("AEARCakePanel", localStringBuilder.toString());
      }
    }
    if (this.a == null) {
      AEARCakeMaterialManager.a().j();
    }
    ThreadManager.getUIHandler().post(new AEARCakePanel.6(this, localList));
  }
  
  private int getOpenedHeight()
  {
    return UIUtils.a(getContext(), 169.5F);
  }
  
  private boolean i()
  {
    if (this.h == null)
    {
      AEQLog.b("AEARCakePanel", "arcake : isMaterialAllDownload no data ");
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : mCurrentMaterials size ");
    ((StringBuilder)localObject).append(this.h.size());
    AEQLog.b("AEARCakePanel", ((StringBuilder)localObject).toString());
    if (this.h.size() <= l) {
      return false;
    }
    localObject = this.h.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AEARCakeMaterial localAEARCakeMaterial = ((AEGiftMaterial)((Iterator)localObject).next()).c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake : mCurrentMaterials name ");
      localStringBuilder.append(localAEARCakeMaterial.t);
      localStringBuilder.append(" usable ");
      localStringBuilder.append(localAEARCakeMaterial.A);
      AEQLog.a("AEARCakePanel", localStringBuilder.toString());
      if (!localAEARCakeMaterial.A) {
        return true;
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, new AEARCakePanel.1(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!a()) {
      return;
    }
    if (paramBoolean) {
      b(paramRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEARCakePanel", 2, "panel closed");
    }
  }
  
  public boolean a()
  {
    int n = getVisibility();
    boolean bool2 = false;
    if (n == 8) {
      return false;
    }
    AEARCakeProvidewView localAEARCakeProvidewView = this.a;
    boolean bool1 = bool2;
    if (localAEARCakeProvidewView != null)
    {
      bool1 = bool2;
      if (localAEARCakeProvidewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    AEQLog.a("AEARCakePanel", "doOpenProviderView");
    a(null);
  }
  
  @TargetApi(11)
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : loadView");
    ((StringBuilder)localObject).append(this.k);
    AEQLog.a("AEARCakePanel", ((StringBuilder)localObject).toString());
    localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getOpenedHeight();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a = new AEARCakeProvidewView(getContext(), this.k);
    localObject = this.a;
    if (localObject != null) {
      addView((View)localObject);
    }
    g();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEARCakePanel", 2, "ar cake panel onDestroy()");
    }
    AEARCakeProvidewView localAEARCakeProvidewView = this.a;
    if (localAEARCakeProvidewView != null)
    {
      localAEARCakeProvidewView.a();
      this.a = null;
    }
    if (this.e != null) {
      AEARCakeMaterialManager.a().b(this.e);
    }
    this.k = null;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.i = paramICaptureController;
  }
  
  public void setClosedByTouch(boolean paramBoolean)
  {
    super.setClosedByTouch(paramBoolean);
  }
  
  public void setMaterialPanelListener(AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener, boolean paramBoolean)
  {
    this.k = paramAEARCakePanelListener;
    this.d = paramBoolean;
    AEARCakeMaterialManager.a().a(this.k);
    AEARCakeMaterialManager.a().a(this.e);
  }
  
  public void setMaterialSelectId()
  {
    AEQLog.a("AEARCakePanel", "arcake : setMaterialSelectId");
    g();
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.j = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel
 * JD-Core Version:    0.7.0.1
 */