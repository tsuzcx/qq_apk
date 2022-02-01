import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import java.util.List;

class arqw
  implements Animation.AnimationListener
{
  arqw(arqt paramarqt, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Arqt.a.size())
    {
      paramAnimation = (ImageView)this.jdField_a_of_type_Arqt.a.get(i);
      paramAnimation.clearAnimation();
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (i < this.jdField_a_of_type_Arqt.jdField_b_of_type_JavaUtilList.size()))
      {
        localObject = arid.a((AppInterface)localObject, (String)this.jdField_a_of_type_Arqt.jdField_b_of_type_JavaUtilList.get(i));
        Drawable localDrawable = paramAnimation.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
          ((FaceDrawable)localDrawable).cancel();
        }
        paramAnimation.setImageDrawable((Drawable)localObject);
      }
      i += 1;
    }
    this.jdField_a_of_type_Arqt.c.clearAnimation();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_Arqt.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
    this.jdField_a_of_type_Arqt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new arqx(this));
    this.jdField_a_of_type_Arqt.c.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqw
 * JD-Core Version:    0.7.0.1
 */