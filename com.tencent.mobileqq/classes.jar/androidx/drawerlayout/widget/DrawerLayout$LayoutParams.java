package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawerLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int FLAG_IS_CLOSING = 4;
  private static final int FLAG_IS_OPENED = 1;
  private static final int FLAG_IS_OPENING = 2;
  public int gravity = 0;
  boolean isPeeking;
  float onScreen;
  int openState;
  
  public DrawerLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public DrawerLayout$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2);
    this.gravity = paramInt3;
  }
  
  public DrawerLayout$LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
    this.gravity = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public DrawerLayout$LayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public DrawerLayout$LayoutParams(@NonNull ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public DrawerLayout$LayoutParams(@NonNull LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.gravity = paramLayoutParams.gravity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */