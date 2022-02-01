package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

@VisibleForTesting
class AppCompatSpinner$DropdownPopup
  extends ListPopupWindow
  implements AppCompatSpinner.SpinnerPopup
{
  ListAdapter mAdapter;
  private CharSequence mHintText;
  private int mOriginalHorizontalOffset;
  private final Rect mVisibleRect = new Rect();
  
  public AppCompatSpinner$DropdownPopup(AppCompatSpinner paramAppCompatSpinner, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setAnchorView(paramAppCompatSpinner);
    setModal(true);
    setPromptPosition(0);
    setOnItemClickListener(new AppCompatSpinner.DropdownPopup.1(this, paramAppCompatSpinner));
  }
  
  void computeContentWidth()
  {
    Object localObject = getBackground();
    int i = 0;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(this.this$0.mTempRect);
      if (ViewUtils.isLayoutRtl(this.this$0)) {
        i = this.this$0.mTempRect.right;
      } else {
        i = -this.this$0.mTempRect.left;
      }
    }
    else
    {
      localObject = this.this$0.mTempRect;
      this.this$0.mTempRect.right = 0;
      ((Rect)localObject).left = 0;
    }
    int n = this.this$0.getPaddingLeft();
    int i1 = this.this$0.getPaddingRight();
    int i2 = this.this$0.getWidth();
    if (this.this$0.mDropDownWidth == -2)
    {
      int k = this.this$0.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
      int m = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - this.this$0.mTempRect.left - this.this$0.mTempRect.right;
      int j = k;
      if (k > m) {
        j = m;
      }
      setContentWidth(Math.max(j, i2 - n - i1));
    }
    else if (this.this$0.mDropDownWidth == -1)
    {
      setContentWidth(i2 - n - i1);
    }
    else
    {
      setContentWidth(this.this$0.mDropDownWidth);
    }
    if (ViewUtils.isLayoutRtl(this.this$0)) {
      i += i2 - i1 - getWidth() - getHorizontalOriginalOffset();
    } else {
      i += n + getHorizontalOriginalOffset();
    }
    setHorizontalOffset(i);
  }
  
  public CharSequence getHintText()
  {
    return this.mHintText;
  }
  
  public int getHorizontalOriginalOffset()
  {
    return this.mOriginalHorizontalOffset;
  }
  
  boolean isVisibleToUser(View paramView)
  {
    return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.mVisibleRect));
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.mAdapter = paramListAdapter;
  }
  
  public void setHorizontalOriginalOffset(int paramInt)
  {
    this.mOriginalHorizontalOffset = paramInt;
  }
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mHintText = paramCharSequence;
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    boolean bool = isShowing();
    computeContentWidth();
    setInputMethodMode(2);
    super.show();
    Object localObject = getListView();
    ((ListView)localObject).setChoiceMode(1);
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((ListView)localObject).setTextDirection(paramInt1);
      ((ListView)localObject).setTextAlignment(paramInt2);
    }
    setSelection(this.this$0.getSelectedItemPosition());
    if (bool) {
      return;
    }
    localObject = this.this$0.getViewTreeObserver();
    if (localObject != null)
    {
      AppCompatSpinner.DropdownPopup.2 local2 = new AppCompatSpinner.DropdownPopup.2(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
      setOnDismissListener(new AppCompatSpinner.DropdownPopup.3(this, local2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.DropdownPopup
 * JD-Core Version:    0.7.0.1
 */