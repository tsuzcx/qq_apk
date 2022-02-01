package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(26)
class TextViewCompat$OreoCallback
  implements ActionMode.Callback
{
  private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
  private final ActionMode.Callback mCallback;
  private boolean mCanUseMenuBuilderReferences;
  private boolean mInitializedMenuBuilderReferences;
  private Class<?> mMenuBuilderClass;
  private Method mMenuBuilderRemoveItemAtMethod;
  private final TextView mTextView;
  
  TextViewCompat$OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView)
  {
    this.mCallback = paramCallback;
    this.mTextView = paramTextView;
    this.mInitializedMenuBuilderReferences = false;
  }
  
  private Intent createProcessTextIntent()
  {
    return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
  }
  
  private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView)
  {
    return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", isEditable(paramTextView) ^ true).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
  }
  
  private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (!(paramContext instanceof Activity)) {
      return localArrayList;
    }
    paramPackageManager = paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
    while (paramPackageManager.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)paramPackageManager.next();
      if (isSupportedActivity(localResolveInfo, paramContext)) {
        localArrayList.add(localResolveInfo);
      }
    }
    return localArrayList;
  }
  
  private boolean isEditable(TextView paramTextView)
  {
    return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
  }
  
  private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext)
  {
    boolean bool2 = paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (!paramResolveInfo.activityInfo.exported) {
      return false;
    }
    if (paramResolveInfo.activityInfo.permission != null)
    {
      if (paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission) == 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void recomputeProcessTextMenuItems(Menu paramMenu)
  {
    Object localObject2 = this.mTextView.getContext();
    PackageManager localPackageManager = ((Context)localObject2).getPackageManager();
    if (!this.mInitializedMenuBuilderReferences) {
      this.mInitializedMenuBuilderReferences = true;
    }
    try
    {
      this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
      this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
      this.mCanUseMenuBuilderReferences = true;
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          if ((this.mCanUseMenuBuilderReferences) && (this.mMenuBuilderClass.isInstance(paramMenu))) {
            localObject1 = this.mMenuBuilderRemoveItemAtMethod;
          } else {
            localObject1 = paramMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
          }
          int i = paramMenu.size() - 1;
          if (i >= 0)
          {
            MenuItem localMenuItem = paramMenu.getItem(i);
            if ((localMenuItem.getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(localMenuItem.getIntent().getAction()))) {
              ((Method)localObject1).invoke(paramMenu, new Object[] { Integer.valueOf(i) });
            }
            i -= 1;
            continue;
          }
          Object localObject1 = getSupportedActivities((Context)localObject2, localPackageManager);
          i = 0;
          if (i < ((List)localObject1).size())
          {
            localObject2 = (ResolveInfo)((List)localObject1).get(i);
            paramMenu.add(0, 0, i + 100, ((ResolveInfo)localObject2).loadLabel(localPackageManager)).setIntent(createProcessTextIntentForResolveInfo((ResolveInfo)localObject2, this.mTextView)).setShowAsAction(1);
            i += 1;
            continue;
          }
          return;
        }
        catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramMenu) {}
        localClassNotFoundException = localClassNotFoundException;
      }
    }
    this.mMenuBuilderClass = null;
    this.mMenuBuilderRemoveItemAtMethod = null;
    this.mCanUseMenuBuilderReferences = false;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mCallback.onDestroyActionMode(paramActionMode);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    recomputeProcessTextMenuItems(paramMenu);
    return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.TextViewCompat.OreoCallback
 * JD-Core Version:    0.7.0.1
 */