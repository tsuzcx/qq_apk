package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.styleable;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private static final String TAG = "Toolbar";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  int mButtonGravity;
  ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private int mContentInsetEndWithActions;
  private int mContentInsetStartWithNavigation;
  private RtlSpacingHelper mContentInsets;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  View mExpandedActionView;
  private Toolbar.ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private final ArrayList<View> mHiddenViews = new ArrayList();
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private ActionMenuView mMenuView;
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new Toolbar.1(this);
  private ImageButton mNavButtonView;
  Toolbar.OnMenuItemClickListener mOnMenuItemClickListener;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new Toolbar.2(this);
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private ColorStateList mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<View> mTempViews = new ArrayList();
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private ColorStateList mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035405);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = paramContext.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = paramContext.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = paramContext.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = paramContext.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.hasValue(R.styleable.Toolbar_titleMargins)) {
      paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i);
    }
    this.mTitleMarginBottom = paramInt;
    this.mTitleMarginTop = paramInt;
    this.mTitleMarginEnd = paramInt;
    this.mTitleMarginStart = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.mTitleMarginStart = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.mTitleMarginEnd = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.mTitleMarginTop = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.mTitleMarginBottom = paramInt;
    }
    this.mMaxButtonHeight = paramContext.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    i = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int j = paramContext.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = paramContext.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    ensureContentInsets();
    this.mContentInsets.setAbsolute(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.mContentInsets.setRelative(paramInt, i);
    }
    this.mContentInsetStartWithNavigation = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.mContentInsetEndWithActions = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.mCollapseIcon = paramContext.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = paramContext.getText(R.styleable.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.mPopupContext = getContext();
    setPopupTheme(paramContext.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(R.styleable.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.getColorStateList(R.styleable.Toolbar_titleTextColor));
    }
    if (paramContext.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
    }
    if (paramContext.hasValue(R.styleable.Toolbar_menu)) {
      inflateMenu(paramContext.getResourceId(R.styleable.Toolbar_menu, 0));
    }
    paramContext.recycle();
  }
  
  private void addCustomViewsWithGravity(List<View> paramList, int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int m = getChildCount();
    int k = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    paramList.clear();
    paramInt = j;
    View localView;
    Toolbar.LayoutParams localLayoutParams;
    if (i != 0)
    {
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (Toolbar.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(localLayoutParams.gravity) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
    }
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (Toolbar.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private void addSystemView(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateDefaultLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = generateLayoutParams((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (Toolbar.LayoutParams)localObject;
    }
    ((Toolbar.LayoutParams)localObject).mViewType = 1;
    if ((paramBoolean) && (this.mExpandedActionView != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mHiddenViews.add(paramView);
      return;
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void ensureContentInsets()
  {
    if (this.mContentInsets == null) {
      this.mContentInsets = new RtlSpacingHelper();
    }
  }
  
  private void ensureLogoView()
  {
    if (this.mLogoView == null) {
      this.mLogoView = new AppCompatImageView(getContext());
    }
  }
  
  private void ensureMenu()
  {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null)
    {
      MenuBuilder localMenuBuilder = (MenuBuilder)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null) {
        this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(this);
      }
      this.mMenuView.setExpandedActionViewsExclusive(true);
      localMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
  }
  
  private void ensureMenuView()
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = new ActionMenuView(getContext());
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      Toolbar.LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800005 | this.mButtonGravity & 0x70);
      this.mMenuView.setLayoutParams(localLayoutParams);
      addSystemView(this.mMenuView, false);
    }
  }
  
  private void ensureNavButtonView()
  {
    if (this.mNavButtonView == null)
    {
      this.mNavButtonView = new AppCompatImageButton(getContext(), null, 2131035404);
      Toolbar.LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | this.mButtonGravity & 0x70);
      this.mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int getChildHorizontalGravity(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = GravityCompat.getAbsoluteGravity(paramInt, i) & 0x7;
    if (j != 1)
    {
      paramInt = 3;
      if ((j != 3) && (j != 5))
      {
        if (i == 1) {
          paramInt = 5;
        }
        return paramInt;
      }
    }
    return j;
  }
  
  private int getChildTop(View paramView, int paramInt)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (j - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int i = getChildVerticalGravity(localLayoutParams.gravity);
    if (i != 48)
    {
      if (i != 80)
      {
        int k = getPaddingTop();
        paramInt = getPaddingBottom();
        int m = getHeight();
        i = (m - k - paramInt - j) / 2;
        if (i < localLayoutParams.topMargin)
        {
          paramInt = localLayoutParams.topMargin;
        }
        else
        {
          j = m - paramInt - j - i - k;
          paramInt = i;
          if (j < localLayoutParams.bottomMargin) {
            paramInt = Math.max(0, i - (localLayoutParams.bottomMargin - j));
          }
        }
        return k + paramInt;
      }
      return getHeight() - getPaddingBottom() - j - localLayoutParams.bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    if (i != 16)
    {
      paramInt = i;
      if (i != 48)
      {
        paramInt = i;
        if (i != 80) {
          paramInt = this.mGravity & 0x70;
        }
      }
    }
    return paramInt;
  }
  
  private int getHorizontalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(paramView) + MarginLayoutParamsCompat.getMarginEnd(paramView);
  }
  
  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }
  
  private int getVerticalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return paramView.topMargin + paramView.bottomMargin;
  }
  
  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfInt)
  {
    int m = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    int n = paramList.size();
    int i = 0;
    int j = 0;
    while (i < n)
    {
      paramArrayOfInt = (View)paramList.get(i);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramArrayOfInt.getLayoutParams();
      m = localLayoutParams.leftMargin - m;
      k = localLayoutParams.rightMargin - k;
      int i1 = Math.max(0, m);
      int i2 = Math.max(0, k);
      m = Math.max(0, -m);
      k = Math.max(0, -k);
      j += i1 + paramArrayOfInt.getMeasuredWidth() + i2;
      i += 1;
    }
    return j;
  }
  
  private boolean isChildOrHidden(View paramView)
  {
    return (paramView.getParent() == this) || (this.mHiddenViews.contains(paramView));
  }
  
  private static boolean isCustomView(View paramView)
  {
    return ((Toolbar.LayoutParams)paramView.getLayoutParams()).mViewType == 0;
  }
  
  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + (i + localLayoutParams.rightMargin);
  }
  
  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (i + localLayoutParams.leftMargin);
  }
  
  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  private void postShowOverflowMenu()
  {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }
  
  private boolean shouldCollapse()
  {
    if (!this.mCollapsible) {
      return false;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean shouldLayout(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  void addChildrenForExpandedActionView()
  {
    int i = this.mHiddenViews.size() - 1;
    while (i >= 0)
    {
      addView((View)this.mHiddenViews.get(i));
      i -= 1;
    }
    this.mHiddenViews.clear();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean canShowOverflowMenu()
  {
    if (getVisibility() == 0)
    {
      ActionMenuView localActionMenuView = this.mMenuView;
      if ((localActionMenuView != null) && (localActionMenuView.isOverflowReserved())) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof Toolbar.LayoutParams));
  }
  
  public void collapseActionView()
  {
    Object localObject = this.mExpandedMenuPresenter;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Toolbar.ExpandedActionViewMenuPresenter)localObject).mCurrentExpandedItem;
    }
    if (localObject != null) {
      ((MenuItemImpl)localObject).collapseActionView();
    }
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.dismissPopupMenus();
    }
  }
  
  void ensureCollapseButtonView()
  {
    if (this.mCollapseButtonView == null)
    {
      this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, 2131035404);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      Toolbar.LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | this.mButtonGravity & 0x70);
      localLayoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams(localLayoutParams);
      this.mCollapseButtonView.setOnClickListener(new Toolbar.3(this));
    }
  }
  
  protected Toolbar.LayoutParams generateDefaultLayoutParams()
  {
    return new Toolbar.LayoutParams(-2, -2);
  }
  
  public Toolbar.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Toolbar.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected Toolbar.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof Toolbar.LayoutParams)) {
      return new Toolbar.LayoutParams((Toolbar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new Toolbar.LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new Toolbar.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new Toolbar.LayoutParams(paramLayoutParams);
  }
  
  @Nullable
  public CharSequence getCollapseContentDescription()
  {
    ImageButton localImageButton = this.mCollapseButtonView;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  @Nullable
  public Drawable getCollapseIcon()
  {
    ImageButton localImageButton = this.mCollapseButtonView;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  public int getContentInsetEnd()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getEnd();
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i = this.mContentInsetEndWithActions;
    if (i != -2147483648) {
      return i;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getLeft();
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getRight();
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getStart();
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i = this.mContentInsetStartWithNavigation;
    if (i != -2147483648) {
      return i;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = this.mMenuView;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).peekMenu();
      if ((localObject != null) && (((MenuBuilder)localObject).hasVisibleItems()))
      {
        i = 1;
        break label32;
      }
    }
    int i = 0;
    label32:
    if (i != 0) {
      return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }
    return getContentInsetEnd();
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      return localImageView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      return localImageView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    ensureMenu();
    return this.mMenuView.getMenu();
  }
  
  @Nullable
  public CharSequence getNavigationContentDescription()
  {
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  @Nullable
  public Drawable getNavigationIcon()
  {
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.mOuterActionMenuPresenter;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    ensureMenu();
    return this.mMenuView.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.mPopupContext;
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitleText;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  final TextView getSubtitleTextView()
  {
    return this.mSubtitleTextView;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitleText;
  }
  
  public int getTitleMarginBottom()
  {
    return this.mTitleMarginBottom;
  }
  
  public int getTitleMarginEnd()
  {
    return this.mTitleMarginEnd;
  }
  
  public int getTitleMarginStart()
  {
    return this.mTitleMarginStart;
  }
  
  public int getTitleMarginTop()
  {
    return this.mTitleMarginTop;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.TESTS})
  final TextView getTitleTextView()
  {
    return this.mTitleTextView;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public DecorToolbar getWrapper()
  {
    if (this.mWrapper == null) {
      this.mWrapper = new ToolbarWidgetWrapper(this, true);
    }
    return this.mWrapper;
  }
  
  public boolean hasExpandedActionView()
  {
    Toolbar.ExpandedActionViewMenuPresenter localExpandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
    return (localExpandedActionViewMenuPresenter != null) && (localExpandedActionViewMenuPresenter.mCurrentExpandedItem != null);
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.hideOverflowMenu());
  }
  
  public void inflateMenu(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowing());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isTitleTruncated()
  {
    Object localObject = this.mTitleTextView;
    if (localObject == null) {
      return false;
    }
    localObject = ((TextView)localObject).getLayout();
    if (localObject == null) {
      return false;
    }
    int j = ((Layout)localObject).getLineCount();
    int i = 0;
    while (i < j)
    {
      if (((Layout)localObject).getEllipsisCount(i) > 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.mEatingHover = false;
    }
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.mEatingHover = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      k = 1;
    } else {
      k = 0;
    }
    int n = getWidth();
    int i3 = getHeight();
    int i = getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = getPaddingTop();
    int i4 = getPaddingBottom();
    int m = n - i1;
    int[] arrayOfInt = this.mTempMargins;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ViewCompat.getMinimumHeight(this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    }
    if (shouldLayout(this.mNavButtonView))
    {
      if (k != 0)
      {
        j = layoutChildRight(this.mNavButtonView, m, arrayOfInt, paramInt4);
        paramInt3 = i;
        break label167;
      }
      paramInt3 = layoutChildLeft(this.mNavButtonView, i, arrayOfInt, paramInt4);
    }
    else
    {
      paramInt3 = i;
    }
    int j = m;
    label167:
    paramInt1 = paramInt3;
    paramInt2 = j;
    if (shouldLayout(this.mCollapseButtonView)) {
      if (k != 0)
      {
        paramInt2 = layoutChildRight(this.mCollapseButtonView, j, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = layoutChildLeft(this.mCollapseButtonView, paramInt3, arrayOfInt, paramInt4);
        paramInt2 = j;
      }
    }
    j = paramInt1;
    paramInt3 = paramInt2;
    if (shouldLayout(this.mMenuView)) {
      if (k != 0)
      {
        j = layoutChildLeft(this.mMenuView, paramInt1, arrayOfInt, paramInt4);
        paramInt3 = paramInt2;
      }
      else
      {
        paramInt3 = layoutChildRight(this.mMenuView, paramInt2, arrayOfInt, paramInt4);
        j = paramInt1;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - j);
    arrayOfInt[1] = Math.max(0, paramInt1 - (m - paramInt3));
    paramInt2 = Math.max(j, paramInt2);
    paramInt3 = Math.min(paramInt3, m - paramInt1);
    paramInt1 = paramInt2;
    j = paramInt3;
    if (shouldLayout(this.mExpandedActionView)) {
      if (k != 0)
      {
        j = layoutChildRight(this.mExpandedActionView, paramInt3, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = layoutChildLeft(this.mExpandedActionView, paramInt2, arrayOfInt, paramInt4);
        j = paramInt3;
      }
    }
    paramInt3 = paramInt1;
    paramInt2 = j;
    if (shouldLayout(this.mLogoView)) {
      if (k != 0)
      {
        paramInt2 = layoutChildRight(this.mLogoView, j, arrayOfInt, paramInt4);
        paramInt3 = paramInt1;
      }
      else
      {
        paramInt3 = layoutChildLeft(this.mLogoView, paramInt1, arrayOfInt, paramInt4);
        paramInt2 = j;
      }
    }
    paramBoolean = shouldLayout(this.mTitleTextView);
    boolean bool = shouldLayout(this.mSubtitleTextView);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
      paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin + this.mTitleTextView.getMeasuredHeight() + ((Toolbar.LayoutParams)localObject1).bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (bool)
    {
      localObject1 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
      paramInt1 += ((Toolbar.LayoutParams)localObject1).topMargin + this.mSubtitleTextView.getMeasuredHeight() + ((Toolbar.LayoutParams)localObject1).bottomMargin;
    }
    if ((!paramBoolean) && (!bool)) {}
    for (paramInt1 = paramInt3;; paramInt1 = paramInt3)
    {
      paramInt3 = paramInt2;
      break label1321;
      if (paramBoolean) {
        localObject1 = this.mTitleTextView;
      } else {
        localObject1 = this.mSubtitleTextView;
      }
      if (bool) {
        localObject2 = this.mSubtitleTextView;
      } else {
        localObject2 = this.mTitleTextView;
      }
      localObject1 = (Toolbar.LayoutParams)((View)localObject1).getLayoutParams();
      Object localObject2 = (Toolbar.LayoutParams)((View)localObject2).getLayoutParams();
      if (((paramBoolean) && (this.mTitleTextView.getMeasuredWidth() > 0)) || ((bool) && (this.mSubtitleTextView.getMeasuredWidth() > 0))) {
        j = 1;
      } else {
        j = 0;
      }
      m = this.mGravity & 0x70;
      if (m != 48)
      {
        if (m != 80)
        {
          m = (i3 - i2 - i4 - paramInt1) / 2;
          if (m < ((Toolbar.LayoutParams)localObject1).topMargin + this.mTitleMarginTop)
          {
            paramInt1 = ((Toolbar.LayoutParams)localObject1).topMargin + this.mTitleMarginTop;
          }
          else
          {
            i3 = i3 - i4 - paramInt1 - m - i2;
            paramInt1 = m;
            if (i3 < ((Toolbar.LayoutParams)localObject1).bottomMargin + this.mTitleMarginBottom) {
              paramInt1 = Math.max(0, m - (((Toolbar.LayoutParams)localObject2).bottomMargin + this.mTitleMarginBottom - i3));
            }
          }
          paramInt1 = i2 + paramInt1;
        }
        else
        {
          paramInt1 = i3 - i4 - ((Toolbar.LayoutParams)localObject2).bottomMargin - this.mTitleMarginBottom - paramInt1;
        }
      }
      else {
        paramInt1 = getPaddingTop() + ((Toolbar.LayoutParams)localObject1).topMargin + this.mTitleMarginTop;
      }
      if (k == 0) {
        break;
      }
      if (j != 0) {
        k = this.mTitleMarginStart;
      } else {
        k = 0;
      }
      k -= arrayOfInt[1];
      paramInt2 -= Math.max(0, k);
      arrayOfInt[1] = Math.max(0, -k);
      if (paramBoolean)
      {
        localObject1 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
        m = paramInt2 - this.mTitleTextView.getMeasuredWidth();
        k = this.mTitleTextView.getMeasuredHeight() + paramInt1;
        this.mTitleTextView.layout(m, paramInt1, paramInt2, k);
        paramInt1 = m - this.mTitleMarginEnd;
        m = k + ((Toolbar.LayoutParams)localObject1).bottomMargin;
      }
      else
      {
        k = paramInt2;
        m = paramInt1;
        paramInt1 = k;
      }
      if (bool)
      {
        localObject1 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
        k = m + ((Toolbar.LayoutParams)localObject1).topMargin;
        m = this.mSubtitleTextView.getMeasuredWidth();
        i2 = this.mSubtitleTextView.getMeasuredHeight();
        this.mSubtitleTextView.layout(paramInt2 - m, k, paramInt2, i2 + k);
        k = paramInt2 - this.mTitleMarginEnd;
        m = ((Toolbar.LayoutParams)localObject1).bottomMargin;
      }
      else
      {
        k = paramInt2;
      }
      if (j != 0) {
        paramInt2 = Math.min(paramInt1, k);
      }
    }
    if (j != 0) {
      k = this.mTitleMarginStart;
    } else {
      k = 0;
    }
    k -= arrayOfInt[0];
    paramInt3 += Math.max(0, k);
    arrayOfInt[0] = Math.max(0, -k);
    if (paramBoolean)
    {
      localObject1 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
      k = this.mTitleTextView.getMeasuredWidth() + paramInt3;
      m = this.mTitleTextView.getMeasuredHeight() + paramInt1;
      this.mTitleTextView.layout(paramInt3, paramInt1, k, m);
      k += this.mTitleMarginEnd;
      paramInt1 = m + ((Toolbar.LayoutParams)localObject1).bottomMargin;
    }
    else
    {
      k = paramInt3;
    }
    if (bool)
    {
      localObject1 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
      paramInt1 += ((Toolbar.LayoutParams)localObject1).topMargin;
      m = this.mSubtitleTextView.getMeasuredWidth() + paramInt3;
      i2 = this.mSubtitleTextView.getMeasuredHeight();
      this.mSubtitleTextView.layout(paramInt3, paramInt1, m, i2 + paramInt1);
      m += this.mTitleMarginEnd;
      paramInt1 = ((Toolbar.LayoutParams)localObject1).bottomMargin;
    }
    else
    {
      m = paramInt3;
    }
    paramInt1 = paramInt3;
    paramInt3 = paramInt2;
    if (j != 0)
    {
      paramInt1 = Math.max(k, m);
      paramInt3 = paramInt2;
    }
    label1321:
    j = i;
    i = 0;
    addCustomViewsWithGravity(this.mTempViews, 3);
    int k = this.mTempViews.size();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      paramInt1 = layoutChildLeft((View)this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, paramInt4);
      paramInt2 += 1;
    }
    addCustomViewsWithGravity(this.mTempViews, 5);
    k = this.mTempViews.size();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      paramInt3 = layoutChildRight((View)this.mTempViews.get(paramInt2), paramInt3, arrayOfInt, paramInt4);
      paramInt2 += 1;
    }
    addCustomViewsWithGravity(this.mTempViews, 1);
    k = getViewListMeasuredWidth(this.mTempViews, arrayOfInt);
    paramInt2 = j + (n - j - i1) / 2 - k / 2;
    j = k + paramInt2;
    if (paramInt2 >= paramInt1) {
      if (j > paramInt3) {
        paramInt1 = paramInt2 - (j - paramInt3);
      } else {
        paramInt1 = paramInt2;
      }
    }
    paramInt3 = this.mTempViews.size();
    paramInt2 = i;
    while (paramInt2 < paramInt3)
    {
      paramInt1 = layoutChildLeft((View)this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, paramInt4);
      paramInt2 += 1;
    }
    this.mTempViews.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mTempMargins;
    if (ViewUtils.isLayoutRtl(this))
    {
      i1 = 1;
      n = 0;
    }
    else
    {
      i1 = 0;
      n = 1;
    }
    if (shouldLayout(this.mNavButtonView))
    {
      measureChildConstrained(this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      i = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
      m = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
      k = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    }
    else
    {
      i = 0;
      m = 0;
      k = 0;
    }
    int i2 = i;
    int j = m;
    int i = k;
    if (shouldLayout(this.mCollapseButtonView))
    {
      measureChildConstrained(this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      i2 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
      j = Math.max(m, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
      i = View.combineMeasuredStates(k, this.mCollapseButtonView.getMeasuredState());
    }
    int k = getCurrentContentInsetStart();
    int m = 0 + Math.max(k, i2);
    arrayOfInt[i1] = Math.max(0, k - i2);
    if (shouldLayout(this.mMenuView))
    {
      measureChildConstrained(this.mMenuView, paramInt1, m, paramInt2, 0, this.mMaxButtonHeight);
      k = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
      j = Math.max(j, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
      i = View.combineMeasuredStates(i, this.mMenuView.getMeasuredState());
    }
    else
    {
      k = 0;
    }
    i2 = getCurrentContentInsetEnd();
    int i1 = m + Math.max(i2, k);
    arrayOfInt[n] = Math.max(0, i2 - k);
    int n = i1;
    m = j;
    k = i;
    if (shouldLayout(this.mExpandedActionView))
    {
      n = i1 + measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i1, paramInt2, 0, arrayOfInt);
      m = Math.max(j, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
      k = View.combineMeasuredStates(i, this.mExpandedActionView.getMeasuredState());
    }
    j = n;
    i1 = m;
    i = k;
    if (shouldLayout(this.mLogoView))
    {
      j = n + measureChildCollapseMargins(this.mLogoView, paramInt1, n, paramInt2, 0, arrayOfInt);
      i1 = Math.max(m, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
      i = View.combineMeasuredStates(k, this.mLogoView.getMeasuredState());
    }
    int i3 = getChildCount();
    n = i1;
    k = 0;
    m = j;
    j = k;
    while (j < i3)
    {
      View localView = getChildAt(j);
      i2 = m;
      i1 = i;
      k = n;
      if (((Toolbar.LayoutParams)localView.getLayoutParams()).mViewType == 0) {
        if (!shouldLayout(localView))
        {
          i2 = m;
          i1 = i;
          k = n;
        }
        else
        {
          i2 = m + measureChildCollapseMargins(localView, paramInt1, m, paramInt2, 0, arrayOfInt);
          k = Math.max(n, localView.getMeasuredHeight() + getVerticalMargins(localView));
          i1 = View.combineMeasuredStates(i, localView.getMeasuredState());
        }
      }
      j += 1;
      m = i2;
      i = i1;
      n = k;
    }
    i1 = this.mTitleMarginTop + this.mTitleMarginBottom;
    i2 = this.mTitleMarginStart + this.mTitleMarginEnd;
    if (shouldLayout(this.mTitleTextView))
    {
      measureChildCollapseMargins(this.mTitleTextView, paramInt1, m + i2, paramInt2, i1, arrayOfInt);
      j = this.mTitleTextView.getMeasuredWidth();
      i3 = getHorizontalMargins(this.mTitleTextView);
      k = this.mTitleTextView.getMeasuredHeight();
      int i4 = getVerticalMargins(this.mTitleTextView);
      i = View.combineMeasuredStates(i, this.mTitleTextView.getMeasuredState());
      k += i4;
      j += i3;
    }
    else
    {
      j = 0;
      k = 0;
    }
    if (shouldLayout(this.mSubtitleTextView))
    {
      j = Math.max(j, measureChildCollapseMargins(this.mSubtitleTextView, paramInt1, m + i2, paramInt2, k + i1, arrayOfInt));
      k += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
      i = View.combineMeasuredStates(i, this.mSubtitleTextView.getMeasuredState());
    }
    k = Math.max(n, k);
    i2 = getPaddingLeft();
    i3 = getPaddingRight();
    n = getPaddingTop();
    i1 = getPaddingBottom();
    j = View.resolveSizeAndState(Math.max(m + j + (i2 + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
    paramInt1 = View.resolveSizeAndState(Math.max(k + (n + i1), getSuggestedMinimumHeight()), paramInt2, i << 16);
    if (shouldCollapse()) {
      paramInt1 = 0;
    }
    setMeasuredDimension(j, paramInt1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof Toolbar.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Toolbar.SavedState localSavedState = (Toolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    paramParcelable = this.mMenuView;
    if (paramParcelable != null) {
      paramParcelable = paramParcelable.peekMenu();
    } else {
      paramParcelable = null;
    }
    if ((localSavedState.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(localSavedState.expandedMenuItemId);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (localSavedState.isOverflowOpen) {
      postShowOverflowMenu();
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    ensureContentInsets();
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localRtlSpacingHelper.setDirection(bool);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Toolbar.SavedState localSavedState = new Toolbar.SavedState(super.onSaveInstanceState());
    Toolbar.ExpandedActionViewMenuPresenter localExpandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
    if ((localExpandedActionViewMenuPresenter != null) && (localExpandedActionViewMenuPresenter.mCurrentExpandedItem != null)) {
      localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
    }
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.mEatingTouch = false;
    }
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.mEatingTouch = false;
    }
    return true;
  }
  
  void removeChildrenForExpandedActionView()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((((Toolbar.LayoutParams)localView.getLayoutParams()).mViewType != 2) && (localView != this.mMenuView))
      {
        removeViewAt(i);
        this.mHiddenViews.add(localView);
      }
      i -= 1;
    }
  }
  
  public void setCollapseContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setCollapseContentDescription(localCharSequence);
  }
  
  public void setCollapseContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureCollapseButtonView();
    }
    ImageButton localImageButton = this.mCollapseButtonView;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setCollapseIcon(@DrawableRes int paramInt)
  {
    setCollapseIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCollapseIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureCollapseButtonView();
      this.mCollapseButtonView.setImageDrawable(paramDrawable);
      return;
    }
    paramDrawable = this.mCollapseButtonView;
    if (paramDrawable != null) {
      paramDrawable.setImageDrawable(this.mCollapseIcon);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setCollapsible(boolean paramBoolean)
  {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.mContentInsetEndWithActions)
    {
      this.mContentInsetEndWithActions = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.mContentInsetStartWithNavigation)
    {
      this.mContentInsetStartWithNavigation = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setAbsolute(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    ensureContentInsets();
    this.mContentInsets.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(@DrawableRes int paramInt)
  {
    setLogo(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (!isChildOrHidden(this.mLogoView)) {
        addSystemView(this.mLogoView, true);
      }
    }
    else
    {
      localImageView = this.mLogoView;
      if ((localImageView != null) && (isChildOrHidden(localImageView)))
      {
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
      }
    }
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(@StringRes int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureLogoView();
    }
    ImageView localImageView = this.mLogoView;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setMenu(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramMenuBuilder == null) && (this.mMenuView == null)) {
      return;
    }
    ensureMenuView();
    MenuBuilder localMenuBuilder = this.mMenuView.peekMenu();
    if (localMenuBuilder == paramMenuBuilder) {
      return;
    }
    if (localMenuBuilder != null)
    {
      localMenuBuilder.removeMenuPresenter(this.mOuterActionMenuPresenter);
      localMenuBuilder.removeMenuPresenter(this.mExpandedMenuPresenter);
    }
    if (this.mExpandedMenuPresenter == null) {
      this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(this);
    }
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.addMenuPresenter(paramActionMenuPresenter, this.mPopupContext);
      paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
    else
    {
      paramActionMenuPresenter.initForMenu(this.mPopupContext, null);
      this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
    }
    this.mMenuView.setPopupTheme(this.mPopupTheme);
    this.mMenuView.setPresenter(paramActionMenuPresenter);
    this.mOuterActionMenuPresenter = paramActionMenuPresenter;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
    ActionMenuView localActionMenuView = this.mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.setMenuCallbacks(paramCallback, paramCallback1);
    }
  }
  
  public void setNavigationContentDescription(@StringRes int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureNavButtonView();
    }
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(@DrawableRes int paramInt)
  {
    setNavigationIcon(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (!isChildOrHidden(this.mNavButtonView)) {
        addSystemView(this.mNavButtonView, true);
      }
    }
    else
    {
      localImageButton = this.mNavButtonView;
      if ((localImageButton != null) && (isChildOrHidden(localImageButton)))
      {
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
      }
    }
    ImageButton localImageButton = this.mNavButtonView;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    ensureMenu();
    this.mMenuView.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(@StyleRes int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
      {
        this.mPopupContext = getContext();
        return;
      }
      this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setSubtitle(@StringRes int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mSubtitleTextView == null)
      {
        localObject = getContext();
        this.mSubtitleTextView = new AppCompatTextView((Context)localObject);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.mSubtitleTextAppearance;
        if (i != 0) {
          this.mSubtitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = this.mSubtitleTextColor;
        if (localObject != null) {
          this.mSubtitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(this.mSubtitleTextView)) {
        addSystemView(this.mSubtitleTextView, true);
      }
    }
    else
    {
      localObject = this.mSubtitleTextView;
      if ((localObject != null) && (isChildOrHidden((View)localObject)))
      {
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
      }
    }
    Object localObject = this.mSubtitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.mSubtitleText = paramCharSequence;
  }
  
  public void setSubtitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mSubtitleTextAppearance = paramInt;
    TextView localTextView = this.mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setSubtitleTextColor(@ColorInt int paramInt)
  {
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.mSubtitleTextColor = paramColorStateList;
    TextView localTextView = this.mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(@StringRes int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mTitleTextView == null)
      {
        localObject = getContext();
        this.mTitleTextView = new AppCompatTextView((Context)localObject);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = this.mTitleTextAppearance;
        if (i != 0) {
          this.mTitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = this.mTitleTextColor;
        if (localObject != null) {
          this.mTitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(this.mTitleTextView)) {
        addSystemView(this.mTitleTextView, true);
      }
    }
    else
    {
      localObject = this.mTitleTextView;
      if ((localObject != null) && (isChildOrHidden((View)localObject)))
      {
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
      }
    }
    Object localObject = this.mTitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.mTitleText = paramCharSequence;
  }
  
  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTitleMarginStart = paramInt1;
    this.mTitleMarginTop = paramInt2;
    this.mTitleMarginEnd = paramInt3;
    this.mTitleMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.mTitleMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.mTitleMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.mTitleMarginStart = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.mTitleMarginTop = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mTitleTextAppearance = paramInt;
    TextView localTextView = this.mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTitleTextColor(@ColorInt int paramInt)
  {
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.mTitleTextColor = paramColorStateList;
    TextView localTextView = this.mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuView localActionMenuView = this.mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.showOverflowMenu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */