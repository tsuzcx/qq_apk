import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.AECMShowCameraUnit.6;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;

public class bmvn
  implements Animator.AnimatorListener
{
  public bmvn(AECMShowCameraUnit.6 param6) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmvk.a(this.a.this$0).setAlpha(1.0F);
    bmvk.a(this.a.this$0).setAlpha(255);
    bmvk.a(this.a.this$0).setVisibility(8);
    Log.d(this.a.this$0.a, "MakeFaceSucc -> onAnimationEnd: 设置为蓝色背景");
    bmvk.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    bmvk.a(this.a.this$0).setTextColor(-1);
    bmvk.a(this.a.this$0).setText(2131690857);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bmvk.a(this.a.this$0).setVisibility(8);
    bmvk.a(this.a.this$0).setAlpha(0.0F);
    bmvk.a(this.a.this$0).setTag(Integer.valueOf(1));
    bmvk.a(this.a.this$0).setClickable(true);
    Log.d(this.a.this$0.a, "MakeFaceSucc -> onAnimationStart: 设置为蓝色背景");
    bmvk.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    bmvk.a(this.a.this$0).setTextColor(-1);
    bmvk.a(this.a.this$0).setText(2131690857);
    bmvk.a(this.a.this$0).setVisibility(0);
    bmvk.a(this.a.this$0).setImageDrawable(this.a.this$0.a().getResources().getDrawable(2130837666));
    bmvk.a(this.a.this$0).setTag(Integer.valueOf(4));
    bmvk.a(this.a.this$0).setAlpha(0);
    bmvk.a(this.a.this$0).setVisibility(0);
    bmvk.a(this.a.this$0).setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvn
 * JD-Core Version:    0.7.0.1
 */