package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper$CallbackWrapper
  implements ActionMode.Callback
{
  final ArrayList<SupportActionModeWrapper> mActionModes;
  final Context mContext;
  final SimpleArrayMap<Menu, Menu> mMenus;
  final android.view.ActionMode.Callback mWrappedCallback;
  
  public SupportActionModeWrapper$CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.mWrappedCallback = paramCallback;
    this.mActionModes = new ArrayList();
    this.mMenus = new SimpleArrayMap();
  }
  
  private Menu getMenuWrapper(Menu paramMenu)
  {
    Menu localMenu = (Menu)this.mMenus.get(paramMenu);
    Object localObject = localMenu;
    if (localMenu == null)
    {
      localObject = new MenuWrapperICS(this.mContext, (SupportMenu)paramMenu);
      this.mMenus.put(paramMenu, localObject);
    }
    return localObject;
  }
  
  public android.view.ActionMode getActionModeWrapper(ActionMode paramActionMode)
  {
    int j = this.mActionModes.size();
    int i = 0;
    while (i < j)
    {
      SupportActionModeWrapper localSupportActionModeWrapper = (SupportActionModeWrapper)this.mActionModes.get(i);
      if ((localSupportActionModeWrapper != null) && (localSupportActionModeWrapper.mWrappedObject == paramActionMode)) {
        return localSupportActionModeWrapper;
      }
      i += 1;
    }
    paramActionMode = new SupportActionModeWrapper(this.mContext, paramActionMode);
    this.mActionModes.add(paramActionMode);
    return paramActionMode;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), new MenuItemWrapperICS(this.mContext, (SupportMenuItem)paramMenuItem));
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */