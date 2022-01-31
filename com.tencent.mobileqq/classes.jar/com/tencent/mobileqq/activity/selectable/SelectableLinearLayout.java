package com.tencent.mobileqq.activity.selectable;

import ahpm;
import ahpo;
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
  implements ahpm
{
  private int jdField_a_of_type_Int;
  private ahpm jdField_a_of_type_Ahpm;
  private ahpo jdField_a_of_type_Ahpo;
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
  
  public int a()
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      if (!(localView instanceof ahpm)) {
        break label51;
      }
      i = ((ahpm)localView).a() + i;
    }
    label51:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
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
      if (!(localObject instanceof ahpm)) {
        break label238;
      }
      ahpm localahpm = (ahpm)localObject;
      if ((m > ((View)localObject).getLeft()) && (m < ((View)localObject).getRight()) && (n > ((View)localObject).getTop()) && (n < ((View)localObject).getBottom()))
      {
        this.jdField_a_of_type_Ahpm = localahpm;
        return localahpm.a(paramInt1, paramInt2) + i;
      }
      i = localahpm.a() + i;
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
        if (!(localObject instanceof ahpm)) {
          break label235;
        }
        localObject = (ahpm)localObject;
        if (this.jdField_a_of_type_Ahpm == localObject) {
          return this.jdField_a_of_type_Ahpm.a(paramInt1, paramInt2) + i;
        }
        i = ((ahpm)localObject).a() + i;
      }
      for (;;)
      {
        j += 1;
        break;
        return -1;
      }
    }
  }
  
  @Nullable
  public ahpo a()
  {
    return this.jdField_a_of_type_Ahpo;
  }
  
  @NonNull
  public View a()
  {
    return this;
  }
  
  @Nullable
  public CharSequence a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof ahpm)) {
        localStringBuilder.append(((ahpm)localView).a());
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i;
    int k;
    label46:
    ahpm localahpm;
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
      if (!(localView instanceof ahpm)) {
        break label266;
      }
      localahpm = (ahpm)localView;
      if (paramInt1 != 0) {
        break label237;
      }
      m = localahpm.a();
      if (paramInt2 < m) {
        break label190;
      }
      i -= m;
      localahpm.a(-1, -1);
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
        localahpm.a(paramInt2, paramInt1);
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
      localahpm.a(-1, -1);
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
  
  public void a(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if (!(localObject instanceof ahpm)) {
        break label79;
      }
      localObject = (ahpm)localObject;
      int k = ((ahpm)localObject).a();
      if (paramInt > k) {
        paramInt -= k;
      }
    }
    label79:
    for (;;)
    {
      i += 1;
      break;
      ((ahpm)localObject).a(paramInt, paramArrayOfInt, paramBoolean);
      return;
    }
  }
  
  public void a(@Nullable ahpo paramahpo)
  {
    this.jdField_a_of_type_Ahpo = paramahpo;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectableLinearLayout", 2, "doSelecting msg = null.");
      }
    }
    while (this.jdField_a_of_type_Ahpo == null) {
      return;
    }
    this.jdField_a_of_type_Ahpo.a(paramChatMessage);
  }
  
  @Nullable
  public CharSequence b()
  {
    CharSequence localCharSequence = a();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public void f()
  {
    if (!h())
    {
      g();
      return;
    }
    int j = getChildCount();
    int i = 0;
    label19:
    Object localObject;
    if (i < j)
    {
      localObject = getChildAt(i);
      if ((localObject instanceof ahpm))
      {
        localObject = (ahpm)localObject;
        if (!((ahpm)localObject).h()) {
          break label74;
        }
        ((ahpm)localObject).a(this.jdField_c_of_type_Int);
        ((ahpm)localObject).f();
      }
    }
    for (;;)
    {
      i += 1;
      break label19;
      break;
      label74:
      ((ahpm)localObject).g();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof ahpm)) {
        ((ahpm)localView).g();
      }
      i += 1;
    }
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableLinearLayout
 * JD-Core Version:    0.7.0.1
 */