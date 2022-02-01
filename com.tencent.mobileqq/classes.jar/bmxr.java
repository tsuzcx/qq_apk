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

public class bmxr
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new bmxs(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new bfzt(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new bmxt(paramView));
  }
  
  public static void a(List<bmxu> paramList, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bmxu localbmxu = (bmxu)paramList.next();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localbmxu.jdField_a_of_type_AndroidViewView, localbmxu.jdField_a_of_type_JavaLangString, new float[] { localbmxu.jdField_a_of_type_Float, localbmxu.jdField_b_of_type_Float }).setDuration(localbmxu.jdField_a_of_type_Long);
        localObjectAnimator.setStartDelay(localbmxu.jdField_b_of_type_Long);
        localArrayList.add(localObjectAnimator);
      }
      paramList = new AnimatorSet();
      paramList.playTogether(localArrayList);
      paramList.addListener(paramAnimatorListener);
      paramList.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxr
 * JD-Core Version:    0.7.0.1
 */