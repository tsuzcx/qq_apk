import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class boef
{
  private static final Property<View, Rect> jdField_a_of_type_AndroidUtilProperty = new boeg(Rect.class, "clipBounds");
  private static int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  @RequiresApi(api=19)
  private static Animator a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    View localView = paramTransitionValues1.view;
    Object localObject = (Rect)paramTransitionValues1.values.get("android:clipBounds:bounds");
    Rect localRect = (Rect)paramTransitionValues2.values.get("android:clipBounds:bounds");
    bodz localbodz = new bodz(new Rect());
    localObject = ObjectAnimator.ofObject(localView, jdField_a_of_type_AndroidUtilProperty, localbodz, new Rect[] { localObject, localRect });
    ((ObjectAnimator)localObject).addListener(new boeh(localView));
    paramTransitionValues1 = paramTransitionValues1.values.get("android:changeBounds:windowX");
    if ((paramTransitionValues1 instanceof Integer)) {}
    for (int i = ((Integer)paramTransitionValues1).intValue();; i = 0)
    {
      paramTransitionValues1 = paramTransitionValues2.values.get("android:changeBounds:windowX");
      if ((paramTransitionValues1 instanceof Integer)) {}
      for (int j = ((Integer)paramTransitionValues1).intValue();; j = 0)
      {
        float f1 = j - i;
        float f2 = localView.getTranslationX();
        paramTransitionValues1 = ObjectAnimator.ofFloat(localView, "translationX", new float[] { f1 });
        paramTransitionValues1.addListener(new boei(localView, f2));
        paramTransitionValues2 = new AnimatorSet();
        paramTransitionValues2.playTogether(new Animator[] { localObject, paramTransitionValues1 });
        return paramTransitionValues2;
      }
    }
  }
  
  @RequiresApi(api=19)
  public static Animator a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramViewGroup == null) {
      return new AnimatorSet();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.getLocationInWindow(jdField_a_of_type_ArrayOfInt);
      TransitionValues localTransitionValues1 = new TransitionValues();
      localTransitionValues1.values.put("android:changeBounds:windowX", Integer.valueOf(jdField_a_of_type_ArrayOfInt[0]));
      localTransitionValues1.values.put("android:clipBounds:bounds", new Rect(0, 0, localView.getWidth(), localView.getHeight()));
      localTransitionValues1.view = localView;
      TransitionValues localTransitionValues2 = new TransitionValues();
      localTransitionValues2.values.put("android:clipBounds:bounds", new Rect(0, 0, paramInt3, localView.getHeight()));
      localTransitionValues2.values.put("android:changeBounds:windowX", Integer.valueOf((i - paramInt1) * paramInt3 + paramInt2));
      localTransitionValues2.view = localView;
      localLinkedList.add(a(localTransitionValues1, localTransitionValues2));
      i += 1;
    }
    paramViewGroup = new AnimatorSet();
    paramViewGroup.playTogether(localLinkedList);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boef
 * JD-Core Version:    0.7.0.1
 */