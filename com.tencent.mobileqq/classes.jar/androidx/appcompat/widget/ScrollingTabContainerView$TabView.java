package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.app.ActionBar.Tab;

class ScrollingTabContainerView$TabView
  extends LinearLayout
{
  private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
  private final int[] BG_ATTRS = { 16842964 };
  private View mCustomView;
  private ImageView mIconView;
  private ActionBar.Tab mTab;
  private TextView mTextView;
  
  public ScrollingTabContainerView$TabView(ScrollingTabContainerView paramScrollingTabContainerView, Context paramContext, ActionBar.Tab paramTab, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.actionBarTabStyle);
    this.mTab = paramTab;
    paramScrollingTabContainerView = TintTypedArray.obtainStyledAttributes(paramContext, null, this.BG_ATTRS, R.attr.actionBarTabStyle, 0);
    if (paramScrollingTabContainerView.hasValue(0)) {
      setBackgroundDrawable(paramScrollingTabContainerView.getDrawable(0));
    }
    paramScrollingTabContainerView.recycle();
    if (paramBoolean) {
      setGravity(8388627);
    }
    update();
  }
  
  public void bindTab(ActionBar.Tab paramTab)
  {
    this.mTab = paramTab;
    update();
  }
  
  public ActionBar.Tab getTab()
  {
    return this.mTab;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.this$0.mMaxTabWidth > 0) && (getMeasuredWidth() > this.this$0.mMaxTabWidth)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.this$0.mMaxTabWidth, 1073741824), paramInt2);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    int i;
    if (isSelected() != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    super.setSelected(paramBoolean);
    if ((i != 0) && (paramBoolean)) {
      sendAccessibilityEvent(4);
    }
  }
  
  public void update()
  {
    ActionBar.Tab localTab = this.mTab;
    Object localObject2 = localTab.getCustomView();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      localObject1 = ((View)localObject2).getParent();
      if (localObject1 != this)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        addView((View)localObject2);
      }
      this.mCustomView = ((View)localObject2);
      localObject1 = this.mTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.mIconView;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(8);
        this.mIconView.setImageDrawable(null);
      }
    }
    else
    {
      localObject2 = this.mCustomView;
      if (localObject2 != null)
      {
        removeView((View)localObject2);
        this.mCustomView = null;
      }
      Object localObject3 = localTab.getIcon();
      localObject2 = localTab.getText();
      Object localObject4;
      if (localObject3 != null)
      {
        if (this.mIconView == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.mIconView = ((ImageView)localObject4);
        }
        this.mIconView.setImageDrawable((Drawable)localObject3);
        this.mIconView.setVisibility(0);
      }
      else
      {
        localObject3 = this.mIconView;
        if (localObject3 != null)
        {
          ((ImageView)localObject3).setVisibility(8);
          this.mIconView.setImageDrawable(null);
        }
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
      if (bool)
      {
        if (this.mTextView == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.mTextView = ((TextView)localObject3);
        }
        this.mTextView.setText((CharSequence)localObject2);
        this.mTextView.setVisibility(0);
      }
      else
      {
        localObject2 = this.mTextView;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(8);
          this.mTextView.setText(null);
        }
      }
      localObject2 = this.mIconView;
      if (localObject2 != null) {
        ((ImageView)localObject2).setContentDescription(localTab.getContentDescription());
      }
      if (!bool) {
        localObject1 = localTab.getContentDescription();
      }
      TooltipCompat.setTooltipText(this, (CharSequence)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ScrollingTabContainerView.TabView
 * JD-Core Version:    0.7.0.1
 */