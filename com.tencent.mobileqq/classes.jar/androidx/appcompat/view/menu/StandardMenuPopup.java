package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup
  extends MenuPopup
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter
{
  private static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  private final MenuAdapter mAdapter;
  private View mAnchorView;
  private final View.OnAttachStateChangeListener mAttachStateChangeListener = new StandardMenuPopup.2(this);
  private int mContentWidth;
  private final Context mContext;
  private int mDropDownGravity = 0;
  final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new StandardMenuPopup.1(this);
  private boolean mHasContentWidth;
  private final MenuBuilder mMenu;
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final boolean mOverflowOnly;
  final MenuPopupWindow mPopup;
  private final int mPopupMaxWidth;
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  private MenuPresenter.Callback mPresenterCallback;
  private boolean mShowTitle;
  View mShownAnchorView;
  ViewTreeObserver mTreeObserver;
  private boolean mWasDismissed;
  
  public StandardMenuPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mMenu = paramMenuBuilder;
    this.mOverflowOnly = paramBoolean;
    this.mAdapter = new MenuAdapter(paramMenuBuilder, LayoutInflater.from(paramContext), this.mOverflowOnly, ITEM_LAYOUT);
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
    Resources localResources = paramContext.getResources();
    this.mPopupMaxWidth = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.mAnchorView = paramView;
    this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  private boolean tryShow()
  {
    if (isShowing()) {
      return true;
    }
    if (!this.mWasDismissed)
    {
      Object localObject = this.mAnchorView;
      if (localObject == null) {
        return false;
      }
      this.mShownAnchorView = ((View)localObject);
      this.mPopup.setOnDismissListener(this);
      this.mPopup.setOnItemClickListener(this);
      this.mPopup.setModal(true);
      localObject = this.mShownAnchorView;
      int i;
      if (this.mTreeObserver == null) {
        i = 1;
      } else {
        i = 0;
      }
      this.mTreeObserver = ((View)localObject).getViewTreeObserver();
      if (i != 0) {
        this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
      }
      ((View)localObject).addOnAttachStateChangeListener(this.mAttachStateChangeListener);
      this.mPopup.setAnchorView((View)localObject);
      this.mPopup.setDropDownGravity(this.mDropDownGravity);
      if (!this.mHasContentWidth)
      {
        this.mContentWidth = measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
      }
      this.mPopup.setContentWidth(this.mContentWidth);
      this.mPopup.setInputMethodMode(2);
      this.mPopup.setEpicenterBounds(getEpicenterBounds());
      this.mPopup.show();
      localObject = this.mPopup.getListView();
      ((ListView)localObject).setOnKeyListener(this);
      if ((this.mShowTitle) && (this.mMenu.getHeaderTitle() != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
        TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
        if (localTextView != null) {
          localTextView.setText(this.mMenu.getHeaderTitle());
        }
        localFrameLayout.setEnabled(false);
        ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
      }
      this.mPopup.setAdapter(this.mAdapter);
      this.mPopup.show();
      return true;
    }
    return false;
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder) {}
  
  public void dismiss()
  {
    if (isShowing()) {
      this.mPopup.dismiss();
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    return this.mPopup.getListView();
  }
  
  public boolean isShowing()
  {
    return (!this.mWasDismissed) && (this.mPopup.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != this.mMenu) {
      return;
    }
    dismiss();
    MenuPresenter.Callback localCallback = this.mPresenterCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onDismiss()
  {
    this.mWasDismissed = true;
    this.mMenu.close();
    Object localObject = this.mTreeObserver;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
      }
      this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
      this.mTreeObserver = null;
    }
    this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
    localObject = this.mOnDismissListener;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      Object localObject = new MenuPopupHelper(this.mContext, paramSubMenuBuilder, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
      ((MenuPopupHelper)localObject).setPresenterCallback(this.mPresenterCallback);
      ((MenuPopupHelper)localObject).setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(paramSubMenuBuilder));
      ((MenuPopupHelper)localObject).setOnDismissListener(this.mOnDismissListener);
      this.mOnDismissListener = null;
      this.mMenu.close(false);
      int j = this.mPopup.getHorizontalOffset();
      int k = this.mPopup.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 0x7) == 5) {
        i = j + this.mAnchorView.getWidth();
      }
      if (((MenuPopupHelper)localObject).tryShow(i, k))
      {
        localObject = this.mPresenterCallback;
        if (localObject != null) {
          ((MenuPresenter.Callback)localObject).onOpenSubMenu(paramSubMenuBuilder);
        }
        return true;
      }
    }
    return false;
  }
  
  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mAdapter.setForceShowIcon(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mPopup.setHorizontalOffset(paramInt);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.mShowTitle = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mPopup.setVerticalOffset(paramInt);
  }
  
  public void show()
  {
    if (tryShow()) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    this.mHasContentWidth = false;
    MenuAdapter localMenuAdapter = this.mAdapter;
    if (localMenuAdapter != null) {
      localMenuAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.StandardMenuPopup
 * JD-Core Version:    0.7.0.1
 */