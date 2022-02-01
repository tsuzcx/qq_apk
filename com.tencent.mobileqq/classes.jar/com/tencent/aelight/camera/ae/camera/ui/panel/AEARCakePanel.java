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
  private static int jdField_b_of_type_Int = 1;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ICaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
  AEARCakeMaterialManager.IARcakeMgrListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager$IARcakeMgrListener = new AEARCakePanel.5(this);
  private AEARCakePanel.AEARCakePanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener;
  AEARCakeProvidewView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView;
  private VideoStoryCapturePartManager jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
  private List<AEGiftMaterial> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  boolean jdField_b_of_type_Boolean = false;
  private boolean d = false;
  
  public AEARCakePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEARCakePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEARCakePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a()
  {
    return UIUtils.a(getContext(), 169.5F);
  }
  
  @TargetApi(12)
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView == null) {
      b();
    } else {
      f();
    }
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F });
    localObjectAnimator.addUpdateListener(new AEARCakePanel.2(this));
    ((AnimatorSet)localObject).play(localObjectAnimator);
    ((AnimatorSet)localObject).addListener(new AEARCakePanel.3(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEARCakePanel.4(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void b(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEARCakePanel.7(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEARCakePanel.8(this));
    startAnimation(paramRunnable);
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      AEQLog.b("AEARCakePanel", "arcake : isMaterialAllDownload no data ");
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : mCurrentMaterials size ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    AEQLog.b("AEARCakePanel", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_JavaUtilList.size() <= jdField_b_of_type_Int) {
      return false;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AEARCakeMaterial localAEARCakeMaterial = ((AEGiftMaterial)((Iterator)localObject).next()).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake : mCurrentMaterials name ");
      localStringBuilder.append(localAEARCakeMaterial.p);
      localStringBuilder.append(" usable ");
      localStringBuilder.append(localAEARCakeMaterial.e);
      AEQLog.a("AEARCakePanel", localStringBuilder.toString());
      if (!localAEARCakeMaterial.e) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    AEQLog.a("AEARCakePanel", "showCaptureLayout");
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController;
    if (localObject != null) {
      ((ICaptureController)localObject).a(false, 150);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).a(327699, new Object[] { Boolean.valueOf(c()) });
    }
  }
  
  private void f()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      AEQLog.d("AEARCakePanel", "arcake :not arcake mode can not refresh data");
      return;
    }
    List localList = AEARCakeMaterialManager.a().a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("arcake : giftMaterials size : ");
    ((StringBuilder)localObject1).append(localList.size());
    AEQLog.b("AEARCakePanel", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_JavaUtilList = localList;
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
      localObject2 = ((AEGiftMaterial)localObject2).a();
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
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView == null) {
      AEARCakeMaterialManager.a().a();
    }
    ThreadManager.getUIHandler().post(new AEARCakePanel.6(this, localList));
  }
  
  public void a()
  {
    AEQLog.a("AEARCakePanel", "doOpenProviderView");
    a(null);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, new AEARCakePanel.1(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!b()) {
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
    return false;
  }
  
  @TargetApi(11)
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : loadView");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener);
    AEQLog.a("AEARCakePanel", ((StringBuilder)localObject).toString());
    localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = a();
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView = new AEARCakeProvidewView(getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView;
    if (localObject != null) {
      addView((View)localObject);
    }
    f();
  }
  
  public boolean b()
  {
    int i = getVisibility();
    boolean bool2 = false;
    if (i == 8) {
      return false;
    }
    AEARCakeProvidewView localAEARCakeProvidewView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView;
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEARCakePanel", 2, "ar cake panel onDestroy()");
    }
    AEARCakeProvidewView localAEARCakeProvidewView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView;
    if (localAEARCakeProvidewView != null)
    {
      localAEARCakeProvidewView.a();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView = null;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager$IARcakeMgrListener != null) {
      AEARCakeMaterialManager.a().b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager$IARcakeMgrListener);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = null;
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiICaptureController = paramICaptureController;
  }
  
  public void setClosedByTouch(boolean paramBoolean)
  {
    super.setClosedByTouch(paramBoolean);
  }
  
  public void setMaterialPanelListener(AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = paramAEARCakePanelListener;
    this.jdField_b_of_type_Boolean = paramBoolean;
    AEARCakeMaterialManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener);
    AEARCakeMaterialManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialManager$IARcakeMgrListener);
  }
  
  public void setMaterialSelectId()
  {
    AEQLog.a("AEARCakePanel", "arcake : setMaterialSelectId");
    f();
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel
 * JD-Core Version:    0.7.0.1
 */