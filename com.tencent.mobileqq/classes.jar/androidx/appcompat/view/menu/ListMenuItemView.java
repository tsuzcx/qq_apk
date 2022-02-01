package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView
  extends LinearLayout
  implements AbsListView.SelectionBoundsAdjuster, MenuView.ItemView
{
  private static final String TAG = "ListMenuItemView";
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private LinearLayout mContent;
  private boolean mForceShowIcon;
  private ImageView mGroupDivider;
  private boolean mHasListDivider;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private Drawable mSubMenuArrow;
  private ImageView mSubMenuArrowView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.mBackground = paramAttributeSet.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.mTextAppearance = paramAttributeSet.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = paramAttributeSet.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = paramAttributeSet.getDrawable(R.styleable.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = R.attr.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.mHasListDivider = paramContext.hasValue(0);
    paramAttributeSet.recycle();
    paramContext.recycle();
  }
  
  private void addContentView(View paramView)
  {
    addContentView(paramView, -1);
  }
  
  private void addContentView(View paramView, int paramInt)
  {
    LinearLayout localLinearLayout = this.mContent;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    return this.mInflater;
  }
  
  private void insertCheckBox()
  {
    this.mCheckBox = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    addContentView(this.mCheckBox);
  }
  
  private void insertIconView()
  {
    this.mIconView = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
    addContentView(this.mIconView, 0);
  }
  
  private void insertRadioButton()
  {
    this.mRadioButton = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    addContentView(this.mRadioButton);
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.mSubMenuArrowView;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    Object localObject = this.mGroupDivider;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.mGroupDivider.getLayoutParams();
      paramRect.top += this.mGroupDivider.getHeight() + ((LinearLayout.LayoutParams)localObject).topMargin + ((LinearLayout.LayoutParams)localObject).bottomMargin;
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
    setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
    setContentDescription(paramMenuItemImpl.getContentDescription());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackground(this, this.mBackground);
    this.mTitleView = ((TextView)findViewById(R.id.title));
    int i = this.mTextAppearance;
    if (i != -1) {
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, i);
    }
    this.mShortcutView = ((TextView)findViewById(R.id.shortcut));
    this.mSubMenuArrowView = ((ImageView)findViewById(R.id.submenuarrow));
    ImageView localImageView = this.mSubMenuArrowView;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.mSubMenuArrow);
    }
    this.mGroupDivider = ((ImageView)findViewById(R.id.group_divider));
    this.mContent = ((LinearLayout)findViewById(R.id.content));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mIconView != null) && (this.mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mRadioButton == null) && (this.mCheckBox == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mItemData.isExclusiveCheckable())
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      localObject1 = this.mRadioButton;
      localObject2 = this.mCheckBox;
    }
    else
    {
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      localObject1 = this.mCheckBox;
      localObject2 = this.mRadioButton;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(this.mItemData.isChecked());
      if (((CompoundButton)localObject1).getVisibility() != 0) {
        ((CompoundButton)localObject1).setVisibility(0);
      }
      if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
        ((CompoundButton)localObject2).setVisibility(8);
      }
    }
    else
    {
      localObject1 = this.mCheckBox;
      if (localObject1 != null) {
        ((CheckBox)localObject1).setVisibility(8);
      }
      localObject1 = this.mRadioButton;
      if (localObject1 != null) {
        ((RadioButton)localObject1).setVisibility(8);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (this.mItemData.isExclusiveCheckable())
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      localObject = this.mRadioButton;
    }
    else
    {
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      localObject = this.mCheckBox;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    this.mPreserveIconSpacing = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView = this.mGroupDivider;
    if (localImageView != null)
    {
      int i;
      if ((!this.mHasListDivider) && (paramBoolean)) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((!this.mItemData.shouldShowIcon()) && (!this.mForceShowIcon)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!this.mPreserveIconSpacing)) {
      return;
    }
    if ((this.mIconView == null) && (paramDrawable == null) && (!this.mPreserveIconSpacing)) {
      return;
    }
    if (this.mIconView == null) {
      insertIconView();
    }
    if ((paramDrawable == null) && (!this.mPreserveIconSpacing))
    {
      this.mIconView.setVisibility(8);
      return;
    }
    ImageView localImageView = this.mIconView;
    if (i == 0) {
      paramDrawable = null;
    }
    localImageView.setImageDrawable(paramDrawable);
    if (this.mIconView.getVisibility() != 0) {
      this.mIconView.setVisibility(0);
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.mItemData.shouldShowShortcut())) {
      paramChar = '\000';
    } else {
      paramChar = '\b';
    }
    if (paramChar == 0) {
      this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    }
    if (this.mShortcutView.getVisibility() != paramChar) {
      this.mShortcutView.setVisibility(paramChar);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.mTitleView.setText(paramCharSequence);
      if (this.mTitleView.getVisibility() != 0) {
        this.mTitleView.setVisibility(0);
      }
    }
    else if (this.mTitleView.getVisibility() != 8)
    {
      this.mTitleView.setVisibility(8);
    }
  }
  
  public boolean showsIcon()
  {
    return this.mForceShowIcon;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */