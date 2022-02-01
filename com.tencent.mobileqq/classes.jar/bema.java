import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class bema
  implements Animation.AnimationListener
{
  bema(belx parambelx, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < 3)
    {
      paramAnimation = (ImageView)this.jdField_a_of_type_Belx.a.get(i);
      paramAnimation.clearAnimation();
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (i < this.jdField_a_of_type_Belx.b.size()))
      {
        Object localObject2 = (String)this.jdField_a_of_type_Belx.b.get(i);
        Drawable localDrawable = bhmq.a(true);
        localObject1 = aoot.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        localObject2 = paramAnimation.getDrawable();
        if ((localObject2 != null) && (localObject2 != localObject1) && ((localObject2 instanceof aoot))) {
          ((aoot)localObject2).b();
        }
        paramAnimation.setImageDrawable((Drawable)localObject1);
      }
      i += 1;
    }
    this.jdField_a_of_type_Belx.d.clearAnimation();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_Belx.c.setTranslationX(0.0F);
    this.jdField_a_of_type_Belx.c.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new bemb(this));
    this.jdField_a_of_type_Belx.d.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bema
 * JD-Core Version:    0.7.0.1
 */