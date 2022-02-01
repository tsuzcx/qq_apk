import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.AECMShowCameraUnit.7;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;

public class bmvp
  implements Animator.AnimatorListener
{
  public bmvp(AECMShowCameraUnit.7 param7) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmvk.a(this.a.this$0).setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bmvk.a(this.a.this$0).setTag(Integer.valueOf(2));
    bmvk.a(this.a.this$0).setClickable(true);
    Log.d(this.a.this$0.a, "MakeFaceFail -> animationStart: 设置为蓝色背景");
    bmvk.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    bmvk.a(this.a.this$0).setTextColor(-1);
    bmvk.a(this.a.this$0).setText(2131690859);
    bmvk.a(this.a.this$0).setVisibility(0);
    bmvk.a(this.a.this$0).setAlpha(0.0F);
    if (this.a.a == 4) {
      bmvk.a(this.a.this$0).a(2, this.a.this$0.a().getResources().getString(2131689677));
    }
    for (;;)
    {
      bmvk.a(this.a.this$0).setVisibility(8);
      bmvk.a(this.a.this$0).setVisibility(8);
      return;
      bmvk.a(this.a.this$0).a(2, this.a.this$0.a().getResources().getString(2131690863));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvp
 * JD-Core Version:    0.7.0.1
 */