package com.tencent.mobileqq.activity.selectable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class SelectableLinearLayout
  extends LinearLayout
  implements SelectableComponent
{
  private int jdField_a_of_type_Int;
  private SelectableComponent jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
  private SelectableDelegate jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -5250572;
  private boolean jdField_c_of_type_Boolean = true;
  
  public SelectableLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectableLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectableLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void bind(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate = paramSelectableDelegate;
  }
  
  public void clearHighlightContent()
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof SelectableComponent)) {
        ((SelectableComponent)localView).clearHighlightContent();
      }
      i += 1;
    }
  }
  
  @Nullable
  public CharSequence content()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof SelectableComponent)) {
        localStringBuilder.append(((SelectableComponent)localView).content());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int m = getChildCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if ((localView instanceof SelectableComponent)) {
        k = j + ((SelectableComponent)localView).contentLength();
      }
      i += 1;
    }
    return j;
  }
  
  @Nullable
  public SelectableDelegate delegate()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectableLinearLayout", 2, "doSelecting msg = null.");
      }
      return;
    }
    SelectableDelegate localSelectableDelegate = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
    if (localSelectableDelegate != null) {
      localSelectableDelegate.a(paramChatMessage);
    }
  }
  
  public boolean hasSelected()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int i = paramInt1 - localObject[0];
    paramInt2 = paramInt2 - localObject[1] - getPaddingTop();
    int j = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      localObject = getChildAt(paramInt1);
      if ((localObject instanceof SelectableComponent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectableLinearLayout", 2, new Object[] { "left=", Integer.valueOf(((View)localObject).getLeft()), " right=", Integer.valueOf(((View)localObject).getRight()), " top=", Integer.valueOf(((View)localObject).getTop()), " bottom=", Integer.valueOf(((View)localObject).getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > ((View)localObject).getLeft()) && (i < ((View)localObject).getRight()) && (paramInt2 > ((View)localObject).getTop()) && (paramInt2 < ((View)localObject).getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected())
    {
      clearHighlightContent();
      return;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        if (((SelectableComponent)localObject).hasSelected())
        {
          ((SelectableComponent)localObject).highlightBackgroundColor(this.jdField_c_of_type_Int);
          ((SelectableComponent)localObject).highlightContent();
        }
        else
        {
          ((SelectableComponent)localObject).clearHighlightContent();
        }
      }
      i += 1;
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = getChildCount();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = getChildAt(paramInt);
      j = i;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        j = ((SelectableComponent)localObject).contentLength();
        if (i > j)
        {
          j = i - j;
        }
        else
        {
          ((SelectableComponent)localObject).locationByIndex(i, paramArrayOfInt, paramBoolean);
          return;
        }
      }
      paramInt += 1;
      i = j;
    }
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.jdField_a_of_type_Int = paramInt2;
        this.jdField_b_of_type_Int = paramInt1;
      }
      else
      {
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = paramInt2;
      }
      if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
    }
    int i = this.jdField_a_of_type_Int;
    paramInt1 = this.jdField_b_of_type_Int;
    int i1 = getChildCount();
    int m = 0;
    int j;
    for (paramInt2 = 0; m < i1; paramInt2 = j)
    {
      View localView = getChildAt(m);
      int n = i;
      int k = paramInt1;
      j = paramInt2;
      if ((localView instanceof SelectableComponent))
      {
        SelectableComponent localSelectableComponent = (SelectableComponent)localView;
        if (paramInt2 == 0)
        {
          n = localSelectableComponent.contentLength();
          if (i >= n)
          {
            i -= n;
            paramInt1 -= n;
            localSelectableComponent.selectContent(-1, -1);
            k = paramInt2;
            paramInt2 = paramInt1;
          }
          else
          {
            if (paramInt1 > n)
            {
              j = paramInt2;
              paramInt2 = n;
            }
            else
            {
              paramInt2 = paramInt1;
              j = 1;
            }
            localSelectableComponent.selectContent(i, paramInt2);
            paramInt2 = paramInt1;
            k = j;
            if (j == 0)
            {
              paramInt2 = paramInt1 - n;
              i = 0;
              k = j;
            }
          }
          paramInt1 = paramInt2;
          paramInt2 = k;
        }
        else
        {
          localSelectableComponent.selectContent(-1, -1);
        }
        localView.invalidate();
        j = paramInt2;
        k = paramInt1;
        n = i;
      }
      m += 1;
      i = n;
      paramInt1 = k;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int m = 0;
    int i1 = paramInt1 - localObject[0] - getPaddingLeft();
    int i2 = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int n = getChildCount();
    int i = 0;
    int k;
    SelectableComponent localSelectableComponent;
    for (int j = 0; i < n; j = k)
    {
      localObject = getChildAt(i);
      k = j;
      if ((localObject instanceof SelectableComponent))
      {
        localSelectableComponent = (SelectableComponent)localObject;
        if ((i1 > ((View)localObject).getLeft()) && (i1 < ((View)localObject).getRight()) && (i2 > ((View)localObject).getTop()) && (i2 < ((View)localObject).getBottom()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = localSelectableComponent;
          return j + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        k = j + localSelectableComponent.contentLength();
      }
      i += 1;
    }
    j = 0;
    i = m;
    while (i < n)
    {
      localObject = getChildAt(i);
      k = j;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        localSelectableComponent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
        if (localSelectableComponent == localObject) {
          return j + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        k = j + ((SelectableComponent)localObject).contentLength();
      }
      i += 1;
      j = k;
    }
    return -1;
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableLinearLayout
 * JD-Core Version:    0.7.0.1
 */