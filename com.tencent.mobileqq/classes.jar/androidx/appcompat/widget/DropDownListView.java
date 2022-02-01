package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R.attr;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

class DropDownListView
  extends ListView
{
  public static final int INVALID_POSITION = -1;
  public static final int NO_POSITION = -1;
  private ViewPropertyAnimatorCompat mClickAnimation;
  private boolean mDrawsInPressedState;
  private boolean mHijackFocus;
  private Field mIsChildViewEnabled;
  private boolean mListSelectionHidden;
  private int mMotionPosition;
  DropDownListView.ResolveHoverRunnable mResolveHoverRunnable;
  private ListViewAutoScrollHelper mScrollHelper;
  private int mSelectionBottomPadding = 0;
  private int mSelectionLeftPadding = 0;
  private int mSelectionRightPadding = 0;
  private int mSelectionTopPadding = 0;
  private DropDownListView.GateKeeperDrawable mSelector;
  private final Rect mSelectorRect = new Rect();
  
  DropDownListView(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void clearPressedItem()
  {
    this.mDrawsInPressedState = false;
    setPressed(false);
    drawableStateChanged();
    Object localObject = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    localObject = this.mClickAnimation;
    if (localObject != null)
    {
      ((ViewPropertyAnimatorCompat)localObject).cancel();
      this.mClickAnimation = null;
    }
  }
  
  private void clickPressedItem(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void drawSelectorCompat(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.mSelectorRect);
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  private void positionSelectorCompat(int paramInt, View paramView)
  {
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.mSelectionLeftPadding;
    localRect.top -= this.mSelectionTopPadding;
    localRect.right += this.mSelectionRightPadding;
    localRect.bottom += this.mSelectionBottomPadding;
    for (;;)
    {
      try
      {
        bool = this.mIsChildViewEnabled.getBoolean(this);
        if (paramView.isEnabled() != bool)
        {
          paramView = this.mIsChildViewEnabled;
          if (bool) {
            break label143;
          }
          bool = true;
          paramView.set(this, Boolean.valueOf(bool));
          if (paramInt != -1)
          {
            refreshDrawableState();
            return;
          }
        }
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
      }
      return;
      label143:
      boolean bool = false;
    }
  }
  
  private void positionSelectorLikeFocusCompat(int paramInt, View paramView)
  {
    Drawable localDrawable = getSelector();
    boolean bool = true;
    int i;
    if ((localDrawable != null) && (paramInt != -1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localDrawable.setVisible(false, false);
    }
    positionSelectorCompat(paramInt, paramView);
    if (i != 0)
    {
      paramView = this.mSelectorRect;
      float f1 = paramView.exactCenterX();
      float f2 = paramView.exactCenterY();
      if (getVisibility() != 0) {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
    }
  }
  
  private void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    paramView = getSelector();
    if ((paramView != null) && (paramInt != -1)) {
      DrawableCompat.setHotspot(paramView, paramFloat1, paramFloat2);
    }
  }
  
  private void setPressedItem(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mDrawsInPressedState = true;
    if (Build.VERSION.SDK_INT >= 21) {
      drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (!isPressed()) {
      setPressed(true);
    }
    layoutChildren();
    int i = this.mMotionPosition;
    if (i != -1)
    {
      View localView = getChildAt(i - getFirstVisiblePosition());
      if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
        localView.setPressed(false);
      }
    }
    this.mMotionPosition = paramInt;
    float f1 = paramView.getLeft();
    float f2 = paramView.getTop();
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2);
    }
    if (!paramView.isPressed()) {
      paramView.setPressed(true);
    }
    positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    DropDownListView.GateKeeperDrawable localGateKeeperDrawable = this.mSelector;
    if (localGateKeeperDrawable != null) {
      localGateKeeperDrawable.setEnabled(paramBoolean);
    }
  }
  
  private boolean touchModeDrawsInPressedStateCompat()
  {
    return this.mDrawsInPressedState;
  }
  
  private void updateSelectorStateCompat()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (touchModeDrawsInPressedStateCompat()) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.mResolveHoverRunnable != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    updateSelectorStateCompat();
  }
  
  public boolean hasFocus()
  {
    return (this.mHijackFocus) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.mHijackFocus) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.mHijackFocus) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode());
  }
  
  public int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter != null)
    {
      if (isInTouchMode()) {
        return -1;
      }
      int j = localListAdapter.getCount();
      if (!getAdapter().areAllItemsEnabled())
      {
        int i;
        if (paramBoolean)
        {
          paramInt = Math.max(0, paramInt);
          for (;;)
          {
            i = paramInt;
            if (paramInt >= j) {
              break;
            }
            i = paramInt;
            if (localListAdapter.isEnabled(paramInt)) {
              break;
            }
            paramInt += 1;
          }
        }
        paramInt = Math.min(paramInt, j - 1);
        for (;;)
        {
          i = paramInt;
          if (paramInt < 0) {
            break;
          }
          i = paramInt;
          if (localListAdapter.isEnabled(paramInt)) {
            break;
          }
          paramInt -= 1;
        }
        if (i >= 0)
        {
          if (i >= j) {
            return -1;
          }
          return i;
        }
        return -1;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= j) {
          return -1;
        }
        return paramInt;
      }
    }
    return -1;
  }
  
  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt2 + paramInt3;
    }
    if ((i <= 0) || (localObject == null)) {
      i = 0;
    }
    int i1 = localListAdapter.getCount();
    paramInt3 = paramInt2 + paramInt3;
    localObject = null;
    int j = 0;
    int m = 0;
    int n;
    for (paramInt2 = 0; j < i1; paramInt2 = n)
    {
      n = localListAdapter.getItemViewType(j);
      int k = m;
      if (n != m)
      {
        localObject = null;
        k = n;
      }
      View localView = localListAdapter.getView(j, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (((ViewGroup.LayoutParams)localObject).height > 0) {
        m = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
      } else {
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, m);
      localView.forceLayout();
      m = paramInt3;
      if (j > 0) {
        m = paramInt3 + i;
      }
      paramInt3 = m + localView.getMeasuredHeight();
      if (paramInt3 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (j > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt2 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt3 != paramInt4) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
        return paramInt1;
      }
      n = paramInt2;
      if (paramInt5 >= 0)
      {
        n = paramInt2;
        if (j >= paramInt5) {
          n = paramInt3;
        }
      }
      j += 1;
      m = k;
      localObject = localView;
    }
    return paramInt3;
  }
  
  protected void onDetachedFromWindow()
  {
    this.mResolveHoverRunnable = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {}
      }
    }
    boolean bool;
    for (;;)
    {
      paramInt = 0;
      bool = true;
      break;
      label45:
      do
      {
        paramInt = 0;
        bool = false;
        break;
        bool = true;
        break label45;
        bool = false;
        j = paramMotionEvent.findPointerIndex(paramInt);
      } while (j < 0);
      paramInt = (int)paramMotionEvent.getX(j);
      int j = (int)paramMotionEvent.getY(j);
      int k = pointToPosition(paramInt, j);
      if (k == -1)
      {
        paramInt = 1;
        break;
      }
      View localView = getChildAt(k - getFirstVisiblePosition());
      setPressedItem(localView, k, paramInt, j);
      if (i == 1) {
        clickPressedItem(localView, k);
      }
    }
    if ((!bool) || (paramInt != 0)) {
      clearPressedItem();
    }
    if (bool)
    {
      if (this.mScrollHelper == null) {
        this.mScrollHelper = new ListViewAutoScrollHelper(this);
      }
      this.mScrollHelper.setEnabled(true);
      this.mScrollHelper.onTouch(this, paramMotionEvent);
      return bool;
    }
    paramMotionEvent = this.mScrollHelper;
    if (paramMotionEvent != null) {
      paramMotionEvent.setEnabled(false);
    }
    return bool;
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 10) && (this.mResolveHoverRunnable == null))
    {
      this.mResolveHoverRunnable = new DropDownListView.ResolveHoverRunnable(this);
      this.mResolveHoverRunnable.post();
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i != 9) && (i != 7))
    {
      setSelection(-1);
      return bool;
    }
    i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i != -1) && (i != getSelectedItemPosition()))
    {
      paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      if (paramMotionEvent.isEnabled()) {
        setSelectionFromTop(i, paramMotionEvent.getTop() - getTop());
      }
      updateSelectorStateCompat();
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    DropDownListView.ResolveHoverRunnable localResolveHoverRunnable = this.mResolveHoverRunnable;
    if (localResolveHoverRunnable != null) {
      localResolveHoverRunnable.cancel();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.mListSelectionHidden = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new DropDownListView.GateKeeperDrawable(paramDrawable);
    } else {
      localObject = null;
    }
    this.mSelector = ((DropDownListView.GateKeeperDrawable)localObject);
    super.setSelector(this.mSelector);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    this.mSelectionLeftPadding = ((Rect)localObject).left;
    this.mSelectionTopPadding = ((Rect)localObject).top;
    this.mSelectionRightPadding = ((Rect)localObject).right;
    this.mSelectionBottomPadding = ((Rect)localObject).bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.DropDownListView
 * JD-Core Version:    0.7.0.1
 */