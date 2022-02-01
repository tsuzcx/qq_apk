import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.widget.media.danmu.DecelerateAccelerateInterpolator;
import com.tencent.mobileqq.qassistant.view.VoicePanelContainer;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class azes
  implements View.OnClickListener, azfy
{
  private VoicePanelContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private void b(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((azfg)((QQAppInterface)localAppRuntime).getManager(387)).a(paramBoolean, false);
    }
  }
  
  private void d()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "translationY", new float[] { ScreenUtil.getRealHeight(BaseApplicationImpl.getContext()), 0.0F, -100.0F, 50.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
  }
  
  private void e()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "translationY", new float[] { 0.0F, -100.0F, ScreenUtil.getRealHeight(BaseApplicationImpl.getContext()) });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setInterpolator(new DecelerateAccelerateInterpolator());
    localObjectAnimator.addListener(new azet(this));
    localObjectAnimator.start();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.b();
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer = null;
    }
  }
  
  public int a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssistantPanelManager", 2, "contentView is null");
      }
      return 2;
    }
    Object localObject = BaseApplicationImpl.getContext();
    if (!FloatingScreenPermission.checkPermission((Context)localObject)) {
      return 1;
    }
    if (a()) {
      a(false);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer = new VoicePanelContainer((Context)localObject);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer != null)
      {
        localObject = paramView.findViewById(2131377557);
        if ((localObject instanceof VoicePanelSlideContainer)) {
          ((VoicePanelSlideContainer)localObject).setPanelSlideListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.addView(paramView);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer.a();
      }
      d();
    }
    return 0;
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelContainer, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.start();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e();
      return;
    }
    f();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    b(false);
    azgl.d(1);
  }
  
  public void c()
  {
    try
    {
      a(true);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AssistantPanelManager", 2, "onDestroy exception = " + localException.getMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(true);
      azgl.d(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azes
 * JD-Core Version:    0.7.0.1
 */