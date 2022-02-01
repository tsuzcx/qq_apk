package com.tencent.mobileqq.activity.selectable;

import alwg;
import alwi;
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
  implements alwg
{
  private int jdField_a_of_type_Int;
  private alwg jdField_a_of_type_Alwg;
  private alwi jdField_a_of_type_Alwi;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
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
  
  public void bind(@Nullable alwi paramalwi)
  {
    this.jdField_a_of_type_Alwi = paramalwi;
  }
  
  public void clearHighlightContent()
  {
    this.jdField_a_of_type_Boolean = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof alwg)) {
        ((alwg)localView).clearHighlightContent();
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
      if ((localView instanceof alwg)) {
        localStringBuilder.append(((alwg)localView).content());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (!(localView instanceof alwg)) {
        break label51;
      }
      i = ((alwg)localView).contentLength() + i;
    }
    label51:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @Nullable
  public alwi delegate()
  {
    return this.jdField_a_of_type_Alwi;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectableLinearLayout", 2, "doSelecting msg = null.");
      }
    }
    while (this.jdField_a_of_type_Alwi == null) {
      return;
    }
    this.jdField_a_of_type_Alwi.a(paramChatMessage);
  }
  
  public boolean hasSelected()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int i = paramInt1 - this.jdField_a_of_type_ArrayOfInt[0];
    paramInt2 = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int j = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      View localView = getChildAt(paramInt1);
      if ((localView instanceof alwg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectableLinearLayout", 2, new Object[] { "left=", Integer.valueOf(localView.getLeft()), " right=", Integer.valueOf(localView.getRight()), " top=", Integer.valueOf(localView.getTop()), " bottom=", Integer.valueOf(localView.getBottom()), " relativeX=", Integer.valueOf(i), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((i > localView.getLeft()) && (i < localView.getRight()) && (paramInt2 > localView.getTop()) && (paramInt2 < localView.getBottom())) {
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
    label19:
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if ((localObject instanceof alwg))
      {
        localObject = (alwg)localObject;
        if (!((alwg)localObject).hasSelected()) {
          break label74;
        }
        ((alwg)localObject).highlightBackgroundColor(this.jdField_c_of_type_Int);
        ((alwg)localObject).highlightContent();
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label74:
      ((alwg)localObject).clearHighlightContent();
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if (!(localObject instanceof alwg)) {
        break label79;
      }
      localObject = (alwg)localObject;
      int k = ((alwg)localObject).contentLength();
      if (paramInt > k) {
        paramInt -= k;
      }
    }
    label79:
    for (;;)
    {
      i += 1;
      break;
      ((alwg)localObject).locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
      return;
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
    int i;
    int k;
    label46:
    alwg localalwg;
    int m;
    int j;
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
      paramInt2 = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      int n = getChildCount();
      k = 0;
      paramInt1 = 0;
      if (k >= n) {
        break label257;
      }
      View localView = getChildAt(k);
      if (!(localView instanceof alwg)) {
        break label266;
      }
      localalwg = (alwg)localView;
      if (paramInt1 != 0) {
        break label237;
      }
      m = localalwg.contentLength();
      if (paramInt2 < m) {
        break label190;
      }
      i -= m;
      localalwg.selectContent(-1, -1);
      j = paramInt2 - m;
      paramInt2 = paramInt1;
      paramInt1 = j;
      label120:
      localView.invalidate();
    }
    for (;;)
    {
      k += 1;
      j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      break label46;
      if (paramInt1 > paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      for (this.jdField_b_of_type_Int = paramInt1;; this.jdField_b_of_type_Int = paramInt2)
      {
        if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int <= 0) {
          break label188;
        }
        this.jdField_b_of_type_Boolean = true;
        break;
        this.jdField_a_of_type_Int = paramInt1;
      }
      label188:
      break;
      label190:
      if (i > m)
      {
        j = paramInt1;
        paramInt1 = m;
      }
      for (;;)
      {
        localalwg.selectContent(paramInt2, paramInt1);
        if (j != 0) {
          break label258;
        }
        i -= m;
        paramInt1 = 0;
        paramInt2 = j;
        break;
        paramInt1 = i;
        j = 1;
      }
      label237:
      localalwg.selectContent(-1, -1);
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label257:
      return;
      label258:
      paramInt1 = paramInt2;
      paramInt2 = j;
      break label120;
      label266:
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int m = paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - getPaddingLeft();
    int n = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    int k = getChildCount();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < k)
    {
      localObject = getChildAt(j);
      if (!(localObject instanceof alwg)) {
        break label238;
      }
      alwg localalwg = (alwg)localObject;
      if ((m > ((View)localObject).getLeft()) && (m < ((View)localObject).getRight()) && (n > ((View)localObject).getTop()) && (n < ((View)localObject).getBottom()))
      {
        this.jdField_a_of_type_Alwg = localalwg;
        return localalwg.touchIndex(paramInt1, paramInt2) + i;
      }
      i = localalwg.contentLength() + i;
    }
    label235:
    label238:
    for (;;)
    {
      j += 1;
      break;
      j = 0;
      i = 0;
      if (j < k)
      {
        localObject = getChildAt(j);
        if (!(localObject instanceof alwg)) {
          break label235;
        }
        localObject = (alwg)localObject;
        if (this.jdField_a_of_type_Alwg == localObject) {
          return this.jdField_a_of_type_Alwg.touchIndex(paramInt1, paramInt2) + i;
        }
        i = ((alwg)localObject).contentLength() + i;
      }
      for (;;)
      {
        j += 1;
        break;
        return -1;
      }
    }
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableLinearLayout
 * JD-Core Version:    0.7.0.1
 */