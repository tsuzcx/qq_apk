import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class biqk
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private biqo jdField_a_of_type_Biqo;
  protected bjmh a;
  private QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = (QIMMusicConfigManager)bjav.a(2);
  private Animator b;
  
  public biqk(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ((ViewStub)paramView.findViewById(2131379423)).inflate();
    this.jdField_a_of_type_Bjmh = new bjmh(paramView, "biz_src_jc_story");
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.i();
    this.jdField_a_of_type_Bjmh.a(new biql(this));
    this.jdField_a_of_type_Bjmh.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b);
    this.jdField_a_of_type_Bjmh.a().setOnTouchListener(new biqm(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bjmh.a(), "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
    this.jdField_a_of_type_Bjmh.a().setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
    boolean bool = vzw.a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Bjmh.a(bool);
  }
  
  public void a(biqo parambiqo)
  {
    this.jdField_a_of_type_Biqo = parambiqo;
  }
  
  public void b()
  {
    if (this.b == null)
    {
      this.b = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bjmh.a(), "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.b.addListener(new biqn(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {}
    while (this.jdField_a_of_type_Bjmh.a().getVisibility() == 8) {
      return;
    }
    this.b.start();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bjmh != null)
    {
      boolean bool = vzw.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bjmh.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqk
 * JD-Core Version:    0.7.0.1
 */