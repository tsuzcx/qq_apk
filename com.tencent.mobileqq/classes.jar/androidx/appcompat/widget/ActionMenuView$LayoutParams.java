package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;

public class ActionMenuView$LayoutParams
  extends LinearLayoutCompat.LayoutParams
{
  @ViewDebug.ExportedProperty
  public int cellsUsed;
  @ViewDebug.ExportedProperty
  public boolean expandable;
  boolean expanded;
  @ViewDebug.ExportedProperty
  public int extraPixels;
  @ViewDebug.ExportedProperty
  public boolean isOverflowButton;
  @ViewDebug.ExportedProperty
  public boolean preventEdgeOffset;
  
  public ActionMenuView$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.isOverflowButton = false;
  }
  
  ActionMenuView$LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2);
    this.isOverflowButton = paramBoolean;
  }
  
  public ActionMenuView$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ActionMenuView$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public ActionMenuView$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.isOverflowButton = paramLayoutParams.isOverflowButton;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView.LayoutParams
 * JD-Core Version:    0.7.0.1
 */