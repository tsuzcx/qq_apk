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

public class bpog
  extends bpny
  implements wij
{
  private Animator a;
  protected wia a;
  protected int b;
  private Animator b;
  public View b;
  
  public bpog(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getIntExtra("edit_video_type", 10002);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bocn.x();
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
      if (this.jdField_a_of_type_Wia != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_Wia.b();
      }
      return;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        i();
      }
    }
    this.jdField_a_of_type_Wia.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bocn.I();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wia != null) {
      this.jdField_a_of_type_Wia.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Wia != null) {
      this.jdField_a_of_type_Wia.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Wia != null) {
      this.jdField_a_of_type_Wia.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    if (this.jdField_b_of_type_Int == 10002)
    {
      wfv localwfv = (wfv)wth.a(30);
      localwfv.c();
      if (localwfv.a(this.jdField_a_of_type_AndroidViewView.getContext()))
      {
        ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131364183)).inflate();
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364182);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          yuk.b("SlidesMode", "init album gallery view part success");
          this.jdField_a_of_type_Wia = new wia(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), this.jdField_b_of_type_AndroidViewView, this);
        }
      }
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377794)).inflate();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377793);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377792).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363949).setOnClickListener(this);
    }
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new bpoh(this));
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
    if (this.jdField_a_of_type_Wia != null)
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
      this.jdField_a_of_type_Wia.a(localBundle);
      return;
      try
      {
        label144:
        localBundle.putLong("BUNDLE_KEY_LOCATE_ALBUM_ID", Long.valueOf(str).longValue());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        yuk.c("SlidesMode", "format albumId error : %s", localNumberFormatException);
      }
    }
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bpoi(this));
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
      this.jdField_a_of_type_Bocn.I();
      continue;
      this.jdField_a_of_type_Bocn.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpog
 * JD-Core Version:    0.7.0.1
 */