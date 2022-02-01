package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar.LayoutParams;

public class Toolbar$LayoutParams
  extends ActionBar.LayoutParams
{
  static final int CUSTOM = 0;
  static final int EXPANDED = 2;
  static final int SYSTEM = 1;
  int mViewType = 0;
  
  public Toolbar$LayoutParams(int paramInt)
  {
    this(-2, -1, paramInt);
  }
  
  public Toolbar$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.gravity = 8388627;
  }
  
  public Toolbar$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.gravity = paramInt3;
  }
  
  public Toolbar$LayoutParams(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Toolbar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    copyMarginsFromCompat(paramMarginLayoutParams);
  }
  
  public Toolbar$LayoutParams(ActionBar.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.mViewType = paramLayoutParams.mViewType;
  }
  
  void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    this.leftMargin = paramMarginLayoutParams.leftMargin;
    this.topMargin = paramMarginLayoutParams.topMargin;
    this.rightMargin = paramMarginLayoutParams.rightMargin;
    this.bottomMargin = paramMarginLayoutParams.bottomMargin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar.LayoutParams
 * JD-Core Version:    0.7.0.1
 */