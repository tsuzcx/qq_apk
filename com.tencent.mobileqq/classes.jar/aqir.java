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

class aqir
  implements Animation.AnimationListener
{
  aqir(aqio paramaqio, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Aqio.a.size())
    {
      paramAnimation = (ImageView)this.jdField_a_of_type_Aqio.a.get(i);
      paramAnimation.clearAnimation();
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (i < this.jdField_a_of_type_Aqio.jdField_b_of_type_JavaUtilList.size()))
      {
        Object localObject2 = (String)this.jdField_a_of_type_Aqio.jdField_b_of_type_JavaUtilList.get(i);
        Drawable localDrawable = bdhj.a(true);
        localObject1 = bdbk.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        localObject2 = paramAnimation.getDrawable();
        if ((localObject2 != null) && (localObject2 != localObject1) && ((localObject2 instanceof bdbk))) {
          ((bdbk)localObject2).a();
        }
        paramAnimation.setImageDrawable((Drawable)localObject1);
      }
      i += 1;
    }
    this.jdField_a_of_type_Aqio.c.clearAnimation();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_Aqio.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
    this.jdField_a_of_type_Aqio.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new aqis(this));
    this.jdField_a_of_type_Aqio.c.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqir
 * JD-Core Version:    0.7.0.1
 */