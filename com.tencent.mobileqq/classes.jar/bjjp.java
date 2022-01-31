import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjjp
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new bjjq(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new bbky(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new bjjr(paramView));
  }
  
  public static void a(List<bjjs> paramList, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bjjs localbjjs = (bjjs)paramList.next();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localbjjs.jdField_a_of_type_AndroidViewView, localbjjs.jdField_a_of_type_JavaLangString, new float[] { localbjjs.jdField_a_of_type_Float, localbjjs.jdField_b_of_type_Float }).setDuration(localbjjs.jdField_a_of_type_Long);
        localObjectAnimator.setStartDelay(localbjjs.jdField_b_of_type_Long);
        localArrayList.add(localObjectAnimator);
      }
      paramList = new AnimatorSet();
      paramList.playTogether(localArrayList);
      paramList.addListener(paramAnimatorListener);
      paramList.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjjp
 * JD-Core Version:    0.7.0.1
 */