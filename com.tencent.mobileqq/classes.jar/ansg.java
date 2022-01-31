import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import mqq.app.Constants.LogoutReason;

public class ansg
  implements Handler.Callback
{
  public int a;
  public Handler a;
  public ViewGroup a;
  public Interpolator a;
  public ImageView a;
  public Animator.AnimatorListener a;
  public ValueAnimator a;
  public Conversation a;
  public ARMapHongBaoListView a;
  public String a;
  public boolean a;
  public ValueAnimator b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  
  private void a(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Int = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.jdField_a_of_type_Int;
    paramView1.setLayoutParams(paramView2);
    this.f = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (!this.f) {
      a(paramView2, paramView1);
    }
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new ansk(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new ansl(this, paramView3);
    }
    if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "springBackPromptly, offset=" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSpringbackOffset(paramInt);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.c);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onLogout");
    }
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (!a()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged, isNetSupport=" + paramBoolean);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged error" + localThrowable.getMessage());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onBeforeAccountChanged");
    }
    a();
  }
  
  public void b(int paramInt) {}
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  direct=" + paramBoolean + "  mTitleIsVisible:" + this.d + "  mTitleBarOffset:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) {}
    View localView1;
    View localView2;
    View localView3;
    do
    {
      do
      {
        return;
        localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
        localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
        localView3 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
        if ((localView1 != null) && (localView2 != null) && (localView3 != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  exit title:" + localView1 + "  head:" + localView2 + "  container:" + localView3);
      return;
      if (paramBoolean)
      {
        if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        l();
        this.d = true;
        return;
      }
      if (!this.d) {
        break;
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) || (((RelativeLayout.LayoutParams)localView1.getLayoutParams()).topMargin == 0));
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle catch a display exception");
    }
    l();
    return;
    this.d = true;
    a(localView1, localView3, localView2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
  }
  
  public void f() {}
  
  public void g()
  {
    if (!a()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onDestroy");
      }
      a();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void h()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onDrawerOpened");
    }
    b(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      j();
      k();
      return false;
    case 1002: 
      d();
      return false;
    }
    int j = paramMessage.arg1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(i);
    return false;
  }
  
  public void i() {}
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367722));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "stopGestureGuide");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367722));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "doGestureGuide  this=" + this);
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new ansh(this));
    int i = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131298052);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(), 0, i + -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a());
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new ansi(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new ansj(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(11)
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "resetTitle  mTitleIsVisible:" + this.d + "  mTitleBarOffset:" + this.jdField_a_of_type_Int);
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    if ((localView1 == null) || (localView2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "resetTitle exit title:" + localView1 + "  head:" + localView2);
      }
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localView1.setLayoutParams(localLayoutParams);
    if (this.e) {
      localView2.setAlpha(1.0F);
    }
    localView2.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansg
 * JD-Core Version:    0.7.0.1
 */