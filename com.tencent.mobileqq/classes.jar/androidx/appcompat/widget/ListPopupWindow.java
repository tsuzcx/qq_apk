package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements ShowableListMenu
{
  private static final boolean DEBUG = false;
  static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int MATCH_PARENT = -1;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private static Method sGetMaxAvailableHeightMethod;
  private static Method sSetClipToWindowEnabledMethod;
  private static Method sSetEpicenterBoundsMethod;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownGravity = 0;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private int mDropDownWindowLayoutType = 1002;
  private Rect mEpicenterBounds;
  private boolean mForceIgnoreOutsideTouch = false;
  final Handler mHandler;
  private final ListPopupWindow.ListSelectorHider mHideSelector = new ListPopupWindow.ListSelectorHider(this);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  int mListItemExpandMaximum = 2147483647;
  private boolean mModal;
  private DataSetObserver mObserver;
  private boolean mOverlapAnchor;
  private boolean mOverlapAnchorSet;
  PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  final ListPopupWindow.ResizePopupRunnable mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(this);
  private final ListPopupWindow.PopupScrollListener mScrollListener = new ListPopupWindow.PopupScrollListener(this);
  private Runnable mShowDropDownRunnable;
  private final Rect mTempRect = new Rect();
  private final ListPopupWindow.PopupTouchInterceptor mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(this);
  
  static
  {
    if (Build.VERSION.SDK_INT <= 28) {}
    try
    {
      sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      label31:
      label61:
      break label31;
    }
    Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    try
    {
      sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label61;
    }
    Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    if (Build.VERSION.SDK_INT <= 23) {}
    try
    {
      sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      label109:
      break label109;
    }
    Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
  }
  
  public ListPopupWindow(@NonNull Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.mDropDownVerticalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.mDropDownVerticalOffset != 0) {
      this.mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.mPopup.setInputMethodMode(1);
  }
  
  private int buildDropDown()
  {
    Object localObject1 = this.mDropDownList;
    boolean bool = true;
    Object localObject2;
    int i;
    int j;
    if (localObject1 == null)
    {
      localObject1 = this.mContext;
      this.mShowDropDownRunnable = new ListPopupWindow.2(this);
      this.mDropDownList = createDropDownListView((Context)localObject1, this.mModal ^ true);
      localObject2 = this.mDropDownListHighlight;
      if (localObject2 != null) {
        this.mDropDownList.setSelector((Drawable)localObject2);
      }
      this.mDropDownList.setAdapter(this.mAdapter);
      this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
      this.mDropDownList.setFocusable(true);
      this.mDropDownList.setFocusableInTouchMode(true);
      this.mDropDownList.setOnItemSelectedListener(new ListPopupWindow.3(this));
      this.mDropDownList.setOnScrollListener(this.mScrollListener);
      localObject2 = this.mItemSelectedListener;
      if (localObject2 != null) {
        this.mDropDownList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
      }
      localObject2 = this.mDropDownList;
      View localView = this.mPromptView;
      if (localView != null)
      {
        localObject1 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject1).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        i = this.mPromptPosition;
        if (i != 0)
        {
          if (i != 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid hint position ");
            ((StringBuilder)localObject2).append(this.mPromptPosition);
            Log.e("ListPopupWindow", ((StringBuilder)localObject2).toString());
          }
          else
          {
            ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
            ((LinearLayout)localObject1).addView(localView);
          }
        }
        else
        {
          ((LinearLayout)localObject1).addView(localView);
          ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
        }
        i = this.mDropDownWidth;
        if (i >= 0)
        {
          j = -2147483648;
        }
        else
        {
          i = 0;
          j = 0;
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, j), 0);
        localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        i = localView.getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      }
      else
      {
        i = 0;
        localObject1 = localObject2;
      }
      this.mPopup.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)this.mPopup.getContentView();
      localObject1 = this.mPromptView;
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      }
      else
      {
        i = 0;
      }
    }
    localObject1 = this.mPopup.getBackground();
    int k;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.mTempRect);
      j = this.mTempRect.top + this.mTempRect.bottom;
      k = j;
      if (!this.mDropDownVerticalOffsetSet)
      {
        this.mDropDownVerticalOffset = (-this.mTempRect.top);
        k = j;
      }
    }
    else
    {
      this.mTempRect.setEmpty();
      k = 0;
    }
    if (this.mPopup.getInputMethodMode() != 2) {
      bool = false;
    }
    int m = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, bool);
    if ((!this.mDropDownAlwaysVisible) && (this.mDropDownHeight != -1))
    {
      j = this.mDropDownWidth;
      if (j != -2) {
        if (j != -1) {
          j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        }
      }
      for (;;)
      {
        break;
        j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
        continue;
        j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
      }
      m = this.mDropDownList.measureHeightOfChildrenCompat(j, 0, -1, m - i, -1);
      j = i;
      if (m > 0) {
        j = i + (k + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
      }
      return m + j;
    }
    return m + k;
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT <= 23)
    {
      localMethod = sGetMaxAvailableHeightMethod;
      if (localMethod == null) {}
    }
    try
    {
      int i = ((Integer)localMethod.invoke(this.mPopup, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
      return i;
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    return this.mPopup.getMaxAvailableHeight(paramView, paramInt);
    return this.mPopup.getMaxAvailableHeight(paramView, paramInt, paramBoolean);
  }
  
  private static boolean isConfirmKey(int paramInt)
  {
    return (paramInt == 66) || (paramInt == 23);
  }
  
  private void removePromptView()
  {
    Object localObject = this.mPromptView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.mPromptView);
      }
    }
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT <= 28)
    {
      localMethod = sSetClipToWindowEnabledMethod;
      if (localMethod == null) {
        break label55;
      }
    }
    try
    {
      localMethod.invoke(this.mPopup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    return;
    this.mPopup.setIsClippedToScreen(paramBoolean);
    label55:
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      localDropDownListView.setListSelectionHidden(true);
      localDropDownListView.requestLayout();
    }
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView)
  {
    return new ListPopupWindow.1(this, paramView);
  }
  
  @NonNull
  DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean)
  {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  @Nullable
  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }
  
  @StyleRes
  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }
  
  @Nullable
  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }
  
  @Nullable
  public Rect getEpicenterBounds()
  {
    Rect localRect = this.mEpicenterBounds;
    if (localRect != null) {
      return new Rect(localRect);
    }
    return null;
  }
  
  public int getHeight()
  {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }
  
  @Nullable
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }
  
  @Nullable
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return -9223372036854775808L;
    }
    return this.mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return this.mDropDownList.getSelectedItemPosition();
  }
  
  @Nullable
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet) {
      return 0;
    }
    return this.mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return this.mDropDownWidth;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return this.mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return this.mModal;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || (!isConfirmKey(paramInt))))
    {
      int k = this.mDropDownList.getSelectedItemPosition();
      boolean bool1 = this.mPopup.isAboveAnchor() ^ true;
      ListAdapter localListAdapter = this.mAdapter;
      int i = 2147483647;
      int j;
      if (localListAdapter != null)
      {
        boolean bool2 = localListAdapter.areAllItemsEnabled();
        if (bool2) {
          i = 0;
        } else {
          i = this.mDropDownList.lookForSelectablePosition(0, true);
        }
        if (bool2) {
          j = localListAdapter.getCount() - 1;
        } else {
          j = this.mDropDownList.lookForSelectablePosition(localListAdapter.getCount() - 1, false);
        }
      }
      else
      {
        j = -2147483648;
      }
      if (((bool1) && (paramInt == 19) && (k <= i)) || ((!bool1) && (paramInt == 20) && (k >= j)))
      {
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
      }
      this.mDropDownList.setListSelectionHidden(false);
      if (this.mDropDownList.onKeyDown(paramInt, paramKeyEvent))
      {
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        return (paramInt == 19) || (paramInt == 20) || (paramInt == 23) || (paramInt == 66);
      }
      if ((bool1) && (paramInt == 20))
      {
        if (k == j) {
          return true;
        }
      }
      else if ((!bool1) && (paramInt == 19) && (k == i)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onKeyPreIme(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (isShowing()))
    {
      Object localObject = this.mDropDownAnchorView;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      boolean bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if ((bool) && (isConfirmKey(paramInt))) {
        dismiss();
      }
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (this.mItemClickListener != null)
      {
        DropDownListView localDropDownListView = this.mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        this.mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
  }
  
  public void setAdapter(@Nullable ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.mObserver;
    if (localDataSetObserver == null)
    {
      this.mObserver = new ListPopupWindow.PopupDataSetObserver(this);
    }
    else
    {
      ListAdapter localListAdapter = this.mAdapter;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.mAdapter = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.mObserver);
    }
    paramListAdapter = this.mDropDownList;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(this.mAdapter);
    }
  }
  
  public void setAnchorView(@Nullable View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(@StyleRes int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(@Nullable Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void setEpicenterBounds(@Nullable Rect paramRect)
  {
    if (paramRect != null) {
      paramRect = new Rect(paramRect);
    } else {
      paramRect = null;
    }
    this.mEpicenterBounds = paramRect;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = paramBoolean;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setOverlapAnchor(boolean paramBoolean)
  {
    this.mOverlapAnchorSet = true;
    this.mOverlapAnchor = paramBoolean;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(@Nullable View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    this.mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      localDropDownListView.setListSelectionHidden(false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt)
  {
    this.mDropDownWindowLayoutType = paramInt;
  }
  
  public void show()
  {
    int j = buildDropDown();
    boolean bool2 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
    boolean bool3 = this.mPopup.isShowing();
    boolean bool1 = true;
    int i;
    if (bool3)
    {
      if (!ViewCompat.isAttachedToWindow(getAnchorView())) {
        return;
      }
      k = this.mDropDownWidth;
      if (k == -1)
      {
        i = -1;
      }
      else
      {
        i = k;
        if (k == -2) {
          i = getAnchorView().getWidth();
        }
      }
      k = this.mDropDownHeight;
      if (k == -1)
      {
        if (!bool2) {
          j = -1;
        }
        if (bool2)
        {
          localObject = this.mPopup;
          if (this.mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject).setWidth(k);
          this.mPopup.setHeight(0);
        }
        else
        {
          localObject = this.mPopup;
          if (this.mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject).setWidth(k);
          this.mPopup.setHeight(-1);
        }
      }
      else if (k != -2)
      {
        j = k;
      }
      localObject = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible)) {
        bool1 = false;
      }
      ((PopupWindow)localObject).setOutsideTouchable(bool1);
      localObject = this.mPopup;
      View localView = getAnchorView();
      k = this.mDropDownHorizontalOffset;
      int m = this.mDropDownVerticalOffset;
      if (i < 0) {
        i = -1;
      }
      if (j < 0) {
        j = -1;
      }
      ((PopupWindow)localObject).update(localView, k, m, i, j);
      return;
    }
    int k = this.mDropDownWidth;
    if (k == -1)
    {
      i = -1;
    }
    else
    {
      i = k;
      if (k == -2) {
        i = getAnchorView().getWidth();
      }
    }
    k = this.mDropDownHeight;
    if (k == -1) {
      j = -1;
    } else if (k != -2) {
      j = k;
    }
    this.mPopup.setWidth(i);
    this.mPopup.setHeight(j);
    setPopupClipToScreenEnabled(true);
    Object localObject = this.mPopup;
    if ((!this.mForceIgnoreOutsideTouch) && (!this.mDropDownAlwaysVisible)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((PopupWindow)localObject).setOutsideTouchable(bool1);
    this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
    if (this.mOverlapAnchorSet) {
      PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    }
    if (Build.VERSION.SDK_INT <= 28)
    {
      localObject = sSetEpicenterBoundsMethod;
      if (localObject != null) {
        try
        {
          ((Method)localObject).invoke(this.mPopup, new Object[] { this.mEpicenterBounds });
        }
        catch (Exception localException)
        {
          Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException);
        }
      }
    }
    else
    {
      this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
    }
    PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
    this.mDropDownList.setSelection(-1);
    if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
      clearListSelection();
    }
    if (!this.mModal) {
      this.mHandler.post(this.mHideSelector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */