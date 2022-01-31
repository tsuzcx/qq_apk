import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class bltl
  extends blsz
{
  private Animator a;
  public bmcd a;
  public QIMMusicConfigManager a;
  private Animator b;
  
  public bltl(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)blqr.a(2));
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bmcd.a(), "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
    this.jdField_a_of_type_Bmcd.a().setVisibility(0);
    this.jdField_a_of_type_Bmcd.a().bringToFront();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a.bringToFront();
    }
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
    boolean bool = xsx.a(this.jdField_a_of_type_Bkms.a());
    this.jdField_a_of_type_Bmcd.a(bool);
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      wxj.a("weishi_share", "clk_ws_entry", 0, 0, new String[] { String.valueOf(i) });
      return;
    }
  }
  
  private void b()
  {
    if (this.b == null)
    {
      this.b = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bmcd.a(), "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.b.addListener(new bltn(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if (this.jdField_a_of_type_Bmcd.a().getVisibility() != 8) {
      this.b.start();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      a();
    }
    while (this.jdField_a_of_type_Bmcd == null) {
      return;
    }
    b();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bmcd == null)
    {
      ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380196)).inflate();
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.i();
      this.jdField_a_of_type_Bmcd = new bmcd(this.jdField_a_of_type_AndroidViewView, "biz_src_jc_hyws");
      this.jdField_a_of_type_Bmcd.a(this);
      this.jdField_a_of_type_Bmcd.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b);
      this.jdField_a_of_type_Bmcd.a().setOnTouchListener(new bltm(this));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Bkms.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltl
 * JD-Core Version:    0.7.0.1
 */