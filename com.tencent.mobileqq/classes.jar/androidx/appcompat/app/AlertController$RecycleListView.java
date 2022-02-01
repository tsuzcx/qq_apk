package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R.styleable;

public class AlertController$RecycleListView
  extends ListView
{
  private final int mPaddingBottomNoButtons;
  private final int mPaddingTopNoTitle;
  
  public AlertController$RecycleListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlertController$RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
    this.mPaddingBottomNoButtons = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
    this.mPaddingTopNoTitle = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
  }
  
  public void setHasDecor(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) || (!paramBoolean1))
    {
      int k = getPaddingLeft();
      int i;
      if (paramBoolean1) {
        i = getPaddingTop();
      } else {
        i = this.mPaddingTopNoTitle;
      }
      int m = getPaddingRight();
      int j;
      if (paramBoolean2) {
        j = getPaddingBottom();
      } else {
        j = this.mPaddingBottomNoButtons;
      }
      setPadding(k, i, m, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.RecycleListView
 * JD-Core Version:    0.7.0.1
 */