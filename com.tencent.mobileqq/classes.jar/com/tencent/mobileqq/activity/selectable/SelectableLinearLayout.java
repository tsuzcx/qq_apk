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
  private SelectableDelegate a;
  private int b;
  private int c;
  private int d = -5250572;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  private SelectableComponent h;
  private final int[] i = new int[2];
  
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
    this.a = paramSelectableDelegate;
  }
  
  public void clearHighlightContent()
  {
    int j = 0;
    this.e = false;
    int k = getChildCount();
    while (j < k)
    {
      View localView = getChildAt(j);
      if ((localView instanceof SelectableComponent)) {
        ((SelectableComponent)localView).clearHighlightContent();
      }
      j += 1;
    }
  }
  
  @Nullable
  public CharSequence content()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = getChildAt(j);
      if ((localView instanceof SelectableComponent)) {
        localStringBuilder.append(((SelectableComponent)localView).content());
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int contentLength()
  {
    int n = getChildCount();
    int j = 0;
    int m;
    for (int k = 0; j < n; k = m)
    {
      View localView = getChildAt(j);
      m = k;
      if ((localView instanceof SelectableComponent)) {
        m = k + ((SelectableComponent)localView).contentLength();
      }
      j += 1;
    }
    return k;
  }
  
  @Nullable
  public SelectableDelegate delegate()
  {
    return this.a;
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
    SelectableDelegate localSelectableDelegate = this.a;
    if (localSelectableDelegate != null) {
      localSelectableDelegate.a(paramChatMessage);
    }
  }
  
  public boolean hasSelected()
  {
    return this.f;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.i);
    Object localObject = this.i;
    int j = paramInt1 - localObject[0];
    paramInt2 = paramInt2 - localObject[1] - getPaddingTop();
    int k = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < k)
    {
      localObject = getChildAt(paramInt1);
      if ((localObject instanceof SelectableComponent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectableLinearLayout", 2, new Object[] { "left=", Integer.valueOf(((View)localObject).getLeft()), " right=", Integer.valueOf(((View)localObject).getRight()), " top=", Integer.valueOf(((View)localObject).getTop()), " bottom=", Integer.valueOf(((View)localObject).getBottom()), " relativeX=", Integer.valueOf(j), " relativeY=", Integer.valueOf(paramInt2) });
        }
        if ((j > ((View)localObject).getLeft()) && (j < ((View)localObject).getRight()) && (paramInt2 > ((View)localObject).getTop()) && (paramInt2 < ((View)localObject).getBottom())) {
          return true;
        }
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public void highlightBackgroundColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected())
    {
      clearHighlightContent();
      return;
    }
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      Object localObject = getChildAt(j);
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        if (((SelectableComponent)localObject).hasSelected())
        {
          ((SelectableComponent)localObject).highlightBackgroundColor(this.d);
          ((SelectableComponent)localObject).highlightContent();
        }
        else
        {
          ((SelectableComponent)localObject).clearHighlightContent();
        }
      }
      j += 1;
    }
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    int m = getChildCount();
    int k = 0;
    int j = paramInt;
    paramInt = k;
    while (paramInt < m)
    {
      Object localObject = getChildAt(paramInt);
      k = j;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        k = ((SelectableComponent)localObject).contentLength();
        if (j > k)
        {
          k = j - k;
        }
        else
        {
          ((SelectableComponent)localObject).locationByIndex(j, paramArrayOfInt, paramBoolean);
          return;
        }
      }
      paramInt += 1;
      j = k;
    }
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.b, this.c);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.b = paramInt2;
        this.c = paramInt1;
      }
      else
      {
        this.b = paramInt1;
        this.c = paramInt2;
      }
      if (this.c - this.b > 0) {
        this.f = true;
      }
    }
    else
    {
      this.b = -1;
      this.c = -1;
      this.f = false;
    }
    int j = this.b;
    paramInt1 = this.c;
    int i2 = getChildCount();
    int n = 0;
    int k;
    for (paramInt2 = 0; n < i2; paramInt2 = k)
    {
      View localView = getChildAt(n);
      int i1 = j;
      int m = paramInt1;
      k = paramInt2;
      if ((localView instanceof SelectableComponent))
      {
        SelectableComponent localSelectableComponent = (SelectableComponent)localView;
        if (paramInt2 == 0)
        {
          i1 = localSelectableComponent.contentLength();
          if (j >= i1)
          {
            j -= i1;
            paramInt1 -= i1;
            localSelectableComponent.selectContent(-1, -1);
            m = paramInt2;
            paramInt2 = paramInt1;
          }
          else
          {
            if (paramInt1 > i1)
            {
              k = paramInt2;
              paramInt2 = i1;
            }
            else
            {
              paramInt2 = paramInt1;
              k = 1;
            }
            localSelectableComponent.selectContent(j, paramInt2);
            paramInt2 = paramInt1;
            m = k;
            if (k == 0)
            {
              paramInt2 = paramInt1 - i1;
              j = 0;
              m = k;
            }
          }
          paramInt1 = paramInt2;
          paramInt2 = m;
        }
        else
        {
          localSelectableComponent.selectContent(-1, -1);
        }
        localView.invalidate();
        k = paramInt2;
        m = paramInt1;
        i1 = j;
      }
      n += 1;
      j = i1;
      paramInt1 = m;
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.i);
    Object localObject = this.i;
    int n = 0;
    int i2 = paramInt1 - localObject[0] - getPaddingLeft();
    int i3 = paramInt2 - this.i[1] - getPaddingTop();
    int i1 = getChildCount();
    int j = 0;
    int m;
    SelectableComponent localSelectableComponent;
    for (int k = 0; j < i1; k = m)
    {
      localObject = getChildAt(j);
      m = k;
      if ((localObject instanceof SelectableComponent))
      {
        localSelectableComponent = (SelectableComponent)localObject;
        if ((i2 > ((View)localObject).getLeft()) && (i2 < ((View)localObject).getRight()) && (i3 > ((View)localObject).getTop()) && (i3 < ((View)localObject).getBottom()))
        {
          this.h = localSelectableComponent;
          return k + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        m = k + localSelectableComponent.contentLength();
      }
      j += 1;
    }
    k = 0;
    j = n;
    while (j < i1)
    {
      localObject = getChildAt(j);
      m = k;
      if ((localObject instanceof SelectableComponent))
      {
        localObject = (SelectableComponent)localObject;
        localSelectableComponent = this.h;
        if (localSelectableComponent == localObject) {
          return k + localSelectableComponent.touchIndex(paramInt1, paramInt2);
        }
        m = k + ((SelectableComponent)localObject).contentLength();
      }
      j += 1;
      k = m;
    }
    return -1;
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableLinearLayout
 * JD-Core Version:    0.7.0.1
 */