package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewTreeViewModelStoreOwner
{
  @Nullable
  public static ViewModelStoreOwner get(@NonNull View paramView)
  {
    ViewModelStoreOwner localViewModelStoreOwner = (ViewModelStoreOwner)paramView.getTag(2131380893);
    if (localViewModelStoreOwner != null) {
      return localViewModelStoreOwner;
    }
    Object localObject = paramView.getParent();
    paramView = localViewModelStoreOwner;
    while ((paramView == null) && ((localObject instanceof View)))
    {
      localObject = (View)localObject;
      paramView = (ViewModelStoreOwner)((View)localObject).getTag(2131380893);
      localObject = ((View)localObject).getParent();
    }
    return paramView;
  }
  
  public static void set(@NonNull View paramView, @Nullable ViewModelStoreOwner paramViewModelStoreOwner)
  {
    paramView.setTag(2131380893, paramViewModelStoreOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewTreeViewModelStoreOwner
 * JD-Core Version:    0.7.0.1
 */