package androidx.savedstate;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ViewTreeSavedStateRegistryOwner
{
  @Nullable
  public static SavedStateRegistryOwner get(@NonNull View paramView)
  {
    SavedStateRegistryOwner localSavedStateRegistryOwner = (SavedStateRegistryOwner)paramView.getTag(R.id.view_tree_saved_state_registry_owner);
    if (localSavedStateRegistryOwner != null) {
      return localSavedStateRegistryOwner;
    }
    Object localObject = paramView.getParent();
    paramView = localSavedStateRegistryOwner;
    while ((paramView == null) && ((localObject instanceof View)))
    {
      localObject = (View)localObject;
      paramView = (SavedStateRegistryOwner)((View)localObject).getTag(R.id.view_tree_saved_state_registry_owner);
      localObject = ((View)localObject).getParent();
    }
    return paramView;
  }
  
  public static void set(@NonNull View paramView, @Nullable SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    paramView.setTag(R.id.view_tree_saved_state_registry_owner, paramSavedStateRegistryOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.savedstate.ViewTreeSavedStateRegistryOwner
 * JD-Core Version:    0.7.0.1
 */