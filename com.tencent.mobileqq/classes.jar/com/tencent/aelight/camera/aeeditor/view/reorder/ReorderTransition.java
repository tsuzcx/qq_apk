package com.tencent.aelight.camera.aeeditor.view.reorder;

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

public class ReorderTransition
{
  private static final Property<View, Rect> a = new ReorderTransition.1(Rect.class, "clipBounds");
  private static int[] b = new int[2];
  
  @RequiresApi(api=19)
  private static Animator a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    View localView = paramTransitionValues1.view;
    Object localObject = (Rect)paramTransitionValues1.values.get("android:clipBounds:bounds");
    Rect localRect = (Rect)paramTransitionValues2.values.get("android:clipBounds:bounds");
    RectEvaluator localRectEvaluator = new RectEvaluator(new Rect());
    localObject = ObjectAnimator.ofObject(localView, a, localRectEvaluator, new Rect[] { localObject, localRect });
    ((ObjectAnimator)localObject).addListener(new ReorderTransition.2(localView));
    paramTransitionValues1 = paramTransitionValues1.values.get("android:changeBounds:windowX");
    int i;
    if ((paramTransitionValues1 instanceof Integer)) {
      i = ((Integer)paramTransitionValues1).intValue();
    } else {
      i = 0;
    }
    paramTransitionValues1 = paramTransitionValues2.values.get("android:changeBounds:windowX");
    int j;
    if ((paramTransitionValues1 instanceof Integer)) {
      j = ((Integer)paramTransitionValues1).intValue();
    } else {
      j = 0;
    }
    float f1 = j - i;
    float f2 = localView.getTranslationX();
    paramTransitionValues1 = ObjectAnimator.ofFloat(localView, "translationX", new float[] { f1 });
    paramTransitionValues1.addListener(new ReorderTransition.3(localView, f2));
    paramTransitionValues2 = new AnimatorSet();
    paramTransitionValues2.playTogether(new Animator[] { localObject, paramTransitionValues1 });
    return paramTransitionValues2;
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
      localView.getLocationInWindow(b);
      TransitionValues localTransitionValues1 = new TransitionValues();
      localTransitionValues1.values.put("android:changeBounds:windowX", Integer.valueOf(b[0]));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderTransition
 * JD-Core Version:    0.7.0.1
 */