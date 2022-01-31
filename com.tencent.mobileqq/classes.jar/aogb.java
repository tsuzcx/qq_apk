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

class aogb
  implements Animation.AnimationListener
{
  aogb(aofw paramaofw, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < 6)
    {
      paramAnimation = (ImageView)this.jdField_a_of_type_Aofw.a.get(i);
      paramAnimation.clearAnimation();
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (i < this.jdField_a_of_type_Aofw.b.size()))
      {
        Object localObject2 = (String)this.jdField_a_of_type_Aofw.b.get(i);
        Drawable localDrawable = bbef.a(true);
        localObject1 = bayh.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        localObject2 = paramAnimation.getDrawable();
        if ((localObject2 != null) && (localObject2 != localObject1) && ((localObject2 instanceof bayh))) {
          ((bayh)localObject2).a();
        }
        paramAnimation.setImageDrawable((Drawable)localObject1);
      }
      i += 1;
    }
    this.jdField_a_of_type_Aofw.g.clearAnimation();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_Aofw.f.setTranslationX(0.0F);
    this.jdField_a_of_type_Aofw.f.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new aogc(this));
    this.jdField_a_of_type_Aofw.g.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogb
 * JD-Core Version:    0.7.0.1
 */