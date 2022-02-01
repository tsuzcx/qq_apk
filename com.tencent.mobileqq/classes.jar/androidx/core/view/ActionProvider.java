package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;

public abstract class ActionProvider
{
  private static final String TAG = "ActionProvider(support)";
  private final Context mContext;
  private ActionProvider.SubUiVisibilityListener mSubUiVisibilityListener;
  private ActionProvider.VisibilityListener mVisibilityListener;
  
  public ActionProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public abstract View onCreateActionView();
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public boolean overridesItemVisibility()
  {
    return false;
  }
  
  public void refreshVisibility()
  {
    if ((this.mVisibilityListener != null) && (overridesItemVisibility())) {
      this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void reset()
  {
    this.mVisibilityListener = null;
    this.mSubUiVisibilityListener = null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSubUiVisibilityListener(ActionProvider.SubUiVisibilityListener paramSubUiVisibilityListener)
  {
    this.mSubUiVisibilityListener = paramSubUiVisibilityListener;
  }
  
  public void setVisibilityListener(ActionProvider.VisibilityListener paramVisibilityListener)
  {
    if ((this.mVisibilityListener != null) && (paramVisibilityListener != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
      Log.w("ActionProvider(support)", localStringBuilder.toString());
    }
    this.mVisibilityListener = paramVisibilityListener;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void subUiVisibilityChanged(boolean paramBoolean)
  {
    ActionProvider.SubUiVisibilityListener localSubUiVisibilityListener = this.mSubUiVisibilityListener;
    if (localSubUiVisibilityListener != null) {
      localSubUiVisibilityListener.onSubUiVisibilityChanged(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ActionProvider
 * JD-Core Version:    0.7.0.1
 */