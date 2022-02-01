package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewTreeLifecycleOwner
{
  @Nullable
  public static LifecycleOwner get(@NonNull View paramView)
  {
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)paramView.getTag(2131380891);
    if (localLifecycleOwner != null) {
      return localLifecycleOwner;
    }
    Object localObject = paramView.getParent();
    paramView = localLifecycleOwner;
    while ((paramView == null) && ((localObject instanceof View)))
    {
      localObject = (View)localObject;
      paramView = (LifecycleOwner)((View)localObject).getTag(2131380891);
      localObject = ((View)localObject).getParent();
    }
    return paramView;
  }
  
  public static void set(@NonNull View paramView, @Nullable LifecycleOwner paramLifecycleOwner)
  {
    paramView.setTag(2131380891, paramLifecycleOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewTreeLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */