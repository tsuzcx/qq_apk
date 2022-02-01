package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.viewmodel.R.id;

public class ViewTreeViewModelStoreOwner
{
  @Nullable
  public static ViewModelStoreOwner get(@NonNull View paramView)
  {
    ViewModelStoreOwner localViewModelStoreOwner = (ViewModelStoreOwner)paramView.getTag(R.id.view_tree_view_model_store_owner);
    if (localViewModelStoreOwner != null) {
      return localViewModelStoreOwner;
    }
    Object localObject = paramView.getParent();
    paramView = localViewModelStoreOwner;
    while ((paramView == null) && ((localObject instanceof View)))
    {
      localObject = (View)localObject;
      paramView = (ViewModelStoreOwner)((View)localObject).getTag(R.id.view_tree_view_model_store_owner);
      localObject = ((View)localObject).getParent();
    }
    return paramView;
  }
  
  public static void set(@NonNull View paramView, @Nullable ViewModelStoreOwner paramViewModelStoreOwner)
  {
    paramView.setTag(R.id.view_tree_view_model_store_owner, paramViewModelStoreOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewTreeViewModelStoreOwner
 * JD-Core Version:    0.7.0.1
 */