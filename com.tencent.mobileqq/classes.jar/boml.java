import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class boml
  extends bomd
  implements weo
{
  private Animator a;
  protected wef a;
  protected int b;
  private Animator b;
  public View b;
  
  public boml(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getIntExtra("edit_video_type", 10002);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnbf.x();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      h();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wef != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_Wef.b();
      }
      return;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        i();
      }
    }
    this.jdField_a_of_type_Wef.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bnbf.I();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wef != null) {
      this.jdField_a_of_type_Wef.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Wef != null) {
      this.jdField_a_of_type_Wef.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Wef != null) {
      this.jdField_a_of_type_Wef.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    if (this.jdField_b_of_type_Int == 10002)
    {
      wca localwca = (wca)wpm.a(30);
      localwca.c();
      if (localwca.a(this.jdField_a_of_type_AndroidViewView.getContext()))
      {
        ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364142)).inflate();
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364141);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          yqp.b("SlidesMode", "init album gallery view part success");
          this.jdField_a_of_type_Wef = new wef(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), this.jdField_b_of_type_AndroidViewView, this);
        }
      }
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377646)).inflate();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377645);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377644).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363925).setOnClickListener(this);
    }
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new bomm(this));
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimator != null) && (this.jdField_b_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
    String str;
    Bundle localBundle;
    if (this.jdField_a_of_type_Wef != null)
    {
      str = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getExtras().getString("story_capture_album_id", "");
      localBundle = new Bundle();
      if (!TextUtils.isEmpty(str))
      {
        if (!"default_id".equals(str)) {
          break label144;
        }
        localBundle.putInt("BUNDLE_KEY_LOCATE_INDEX", 1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Wef.a(localBundle);
      return;
      try
      {
        label144:
        localBundle.putLong("BUNDLE_KEY_LOCATE_ALBUM_ID", Long.valueOf(str).longValue());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        yqp.c("SlidesMode", "format albumId error : %s", localNumberFormatException);
      }
    }
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bomn(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
      this.jdField_b_of_type_AndroidAnimationAnimator.start();
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
      this.jdField_a_of_type_Bnbf.I();
      continue;
      this.jdField_a_of_type_Bnbf.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boml
 * JD-Core Version:    0.7.0.1
 */