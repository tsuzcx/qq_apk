package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SubMenuWrapperICS
  extends MenuWrapperICS
  implements SubMenu
{
  private final SupportSubMenu mSubMenu;
  
  SubMenuWrapperICS(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    super(paramContext, paramSupportSubMenu);
    this.mSubMenu = paramSupportSubMenu;
  }
  
  public void clearHeader()
  {
    this.mSubMenu.clearHeader();
  }
  
  public MenuItem getItem()
  {
    return getMenuItemWrapper(this.mSubMenu.getItem());
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    this.mSubMenu.setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    this.mSubMenu.setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    this.mSubMenu.setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    this.mSubMenu.setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    this.mSubMenu.setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.mSubMenu.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.mSubMenu.setIcon(paramDrawable);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.SubMenuWrapperICS
 * JD-Core Version:    0.7.0.1
 */