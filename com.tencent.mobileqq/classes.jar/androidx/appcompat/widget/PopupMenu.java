package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

public class PopupMenu
{
  private final View mAnchor;
  private final Context mContext;
  private View.OnTouchListener mDragListener;
  private final MenuBuilder mMenu;
  PopupMenu.OnMenuItemClickListener mMenuItemClickListener;
  PopupMenu.OnDismissListener mOnDismissListener;
  final MenuPopupHelper mPopup;
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView, int paramInt1, @AttrRes int paramInt2, @StyleRes int paramInt3)
  {
    this.mContext = paramContext;
    this.mAnchor = paramView;
    this.mMenu = new MenuBuilder(paramContext);
    this.mMenu.setCallback(new PopupMenu.1(this));
    this.mPopup = new MenuPopupHelper(paramContext, this.mMenu, paramView, false, paramInt2, paramInt3);
    this.mPopup.setGravity(paramInt1);
    this.mPopup.setOnDismissListener(new PopupMenu.2(this));
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
  }
  
  @NonNull
  public View.OnTouchListener getDragToOpenListener()
  {
    if (this.mDragListener == null) {
      this.mDragListener = new PopupMenu.3(this, this.mAnchor);
    }
    return this.mDragListener;
  }
  
  public int getGravity()
  {
    return this.mPopup.getGravity();
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  @NonNull
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.mContext);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  ListView getMenuListView()
  {
    if (!this.mPopup.isShowing()) {
      return null;
    }
    return this.mPopup.getListView();
  }
  
  public void inflate(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, this.mMenu);
  }
  
  public void setGravity(int paramInt)
  {
    this.mPopup.setGravity(paramInt);
  }
  
  public void setOnDismissListener(@Nullable PopupMenu.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(@Nullable PopupMenu.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void show()
  {
    this.mPopup.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.PopupMenu
 * JD-Core Version:    0.7.0.1
 */