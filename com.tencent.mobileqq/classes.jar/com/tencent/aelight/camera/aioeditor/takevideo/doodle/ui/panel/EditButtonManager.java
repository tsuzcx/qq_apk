package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EditButtonManager
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @NonNull
  private final View jdField_a_of_type_AndroidViewView;
  private EditButtonManager.FunHandler jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunHandler;
  private final List<EditButtonManager.FunGroup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Integer, EditButtonManager.FunButton> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private final int[][] jdField_a_of_type_Array2dOfInt;
  private int jdField_b_of_type_Int;
  @Nullable
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  @NonNull
  private final View jdField_b_of_type_AndroidViewView;
  private final int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = 0;
  private final int[] jdField_c_of_type_ArrayOfInt = new int[2];
  private int jdField_d_of_type_Int = 0;
  private final int[] jdField_d_of_type_ArrayOfInt = new int[2];
  
  public EditButtonManager(@NonNull View paramView, int[][] paramArrayOfInt)
  {
    this.jdField_a_of_type_Array2dOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new EditButtonManager.1(this));
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = a(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368184);
  }
  
  private int a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    int[][] arrayOfInt = this.jdField_a_of_type_Array2dOfInt;
    int m = arrayOfInt.length;
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      int[] arrayOfInt1 = arrayOfInt[j];
      i = arrayOfInt1.length;
      boolean bool2 = true;
      if (i == 1)
      {
        a(k, arrayOfInt1[0], null);
        i = k + 1;
      }
      else
      {
        i = k;
        if (arrayOfInt1.length == 4)
        {
          Object localObject = a(arrayOfInt1[0]);
          View localView = a(arrayOfInt1[1]);
          i = k + 1;
          localObject = new EditButtonManager.FunGroup(this, (View)localObject, localView, new int[] { k, i });
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          a(k, arrayOfInt1[2], (EditButtonManager.FunGroup)localObject);
          a(i, arrayOfInt1[3], (EditButtonManager.FunGroup)localObject);
          boolean bool1 = bool2;
          if (k != paramInt) {
            if (i == paramInt) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          a((EditButtonManager.FunGroup)localObject, bool1);
          i = k + 2;
        }
      }
      j += 1;
    }
    return k;
  }
  
  @NonNull
  private View a(@IdRes int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    localView.getClass();
    return (View)localView;
  }
  
  @NonNull
  private EditButtonManager.FunButton a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    localObject.getClass();
    return (EditButtonManager.FunButton)localObject;
  }
  
  private void a()
  {
    Object localObject = a(this.jdField_b_of_type_Int);
    if (((EditButtonManager.FunButton)localObject).jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      ((EditButtonManager.FunButton)localObject).jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_d_of_type_ArrayOfInt);
    } else if (((EditButtonManager.FunButton)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup != null) {
      ((EditButtonManager.FunButton)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_d_of_type_ArrayOfInt);
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator == null))
    {
      this.jdField_c_of_type_Int = this.jdField_d_of_type_ArrayOfInt[0];
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      float f;
      if (localObject == null) {
        f = 0.0F;
      } else {
        f = ((Float)((ValueAnimator)localObject).getAnimatedValue()).floatValue();
      }
      int i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i + (int)((this.jdField_d_of_type_ArrayOfInt[0] - i) * f));
    }
    a(this.jdField_c_of_type_Int);
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(paramInt - this.jdField_a_of_type_ArrayOfInt[0]);
  }
  
  private void a(int paramInt1, @IdRes int paramInt2, EditButtonManager.FunGroup paramFunGroup)
  {
    EditButtonManager.FunButton localFunButton = new EditButtonManager.FunButton(this, paramInt1, a(paramInt2));
    localFunButton.jdField_a_of_type_AndroidViewView.setVisibility(0);
    localFunButton.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup = paramFunGroup;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localFunButton);
  }
  
  private void a(EditButtonManager.FunButton paramFunButton1, EditButtonManager.FunButton paramFunButton2)
  {
    EditButtonManager.FunGroup localFunGroup1 = paramFunButton1.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup;
    EditButtonManager.FunGroup localFunGroup2 = paramFunButton2.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup;
    boolean bool;
    if (localFunGroup1 != localFunGroup2) {
      bool = true;
    } else {
      bool = false;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(Math.abs(paramFunButton2.jdField_a_of_type_Int - paramFunButton1.jdField_a_of_type_Int) * 25 + 150);
    localValueAnimator.addUpdateListener(new EditButtonManager.2(this, bool, paramFunButton2, localFunGroup1, paramFunButton1, localFunGroup2));
    localValueAnimator.addListener(new EditButtonManager.3(this, bool, localFunGroup1));
    paramFunButton1 = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (paramFunButton1 != null)
    {
      paramFunButton1.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = localValueAnimator;
      this.jdField_a_of_type_AndroidViewView.post(new EditButtonManager.4(this, localFunGroup1, localFunGroup2));
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = localValueAnimator;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    if ((localFunGroup1 != localFunGroup2) && (localFunGroup2 != null)) {
      a(localFunGroup2, true);
    }
  }
  
  private void a(@NonNull EditButtonManager.FunGroup paramFunGroup, boolean paramBoolean)
  {
    View localView = paramFunGroup.jdField_b_of_type_AndroidViewView;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramFunGroup = paramFunGroup.jdField_a_of_type_ArrayOfInt;
    int k = paramFunGroup.length;
    int i = 0;
    while (i < k)
    {
      localView = a(paramFunGroup[i]).jdField_a_of_type_AndroidViewView;
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 8;
      }
      localView.setVisibility(j);
      i += 1;
    }
  }
  
  private void b()
  {
    Log.d("[EditButton]", "update FunGroup Layout");
    EditButtonManager.FunButton localFunButton = a(this.jdField_b_of_type_Int);
    localFunButton.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      EditButtonManager.FunGroup localFunGroup = (EditButtonManager.FunGroup)localIterator.next();
      int j = localFunGroup.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      int i = j;
      if (j <= 0) {
        i = a(localFunGroup.jdField_a_of_type_ArrayOfInt[0]).jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      }
      if (i > 0) {
        if (localFunGroup == localFunButton.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunGroup)
        {
          i *= 2;
          if (localFunGroup.jdField_a_of_type_AndroidViewView.getMeasuredWidth() != i)
          {
            localFunGroup.jdField_a_of_type_AndroidViewView.getLayoutParams().width = i;
            localFunGroup.jdField_a_of_type_AndroidViewView.requestLayout();
          }
        }
        else if (localFunGroup.jdField_a_of_type_AndroidViewView.getMeasuredWidth() != i)
        {
          localFunGroup.jdField_a_of_type_AndroidViewView.getLayoutParams().width = i;
          localFunGroup.jdField_a_of_type_AndroidViewView.requestLayout();
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Int))
    {
      int i = this.jdField_b_of_type_Int;
      if (i == paramInt) {
        return;
      }
      Object localObject = a(i);
      EditButtonManager.FunButton localFunButton = a(paramInt);
      this.jdField_b_of_type_Int = paramInt;
      a((EditButtonManager.FunButton)localObject, localFunButton);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunHandler;
      if (localObject != null) {
        ((EditButtonManager.FunHandler)localObject).a(localFunButton.jdField_a_of_type_AndroidViewView, paramInt);
      }
    }
  }
  
  public void a(EditButtonManager.FunHandler paramFunHandler)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditButtonManager$FunHandler = paramFunHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager
 * JD-Core Version:    0.7.0.1
 */