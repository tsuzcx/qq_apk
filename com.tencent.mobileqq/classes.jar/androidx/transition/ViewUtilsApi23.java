package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class ViewUtilsApi23
  extends ViewUtilsApi22
{
  private static boolean sTryHiddenSetTransitionVisibility = true;
  
  @SuppressLint({"NewApi"})
  public void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT == 28)
    {
      super.setTransitionVisibility(paramView, paramInt);
      return;
    }
    if (sTryHiddenSetTransitionVisibility) {}
    try
    {
      paramView.setTransitionVisibility(paramInt);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label27:
      break label27;
    }
    sTryHiddenSetTransitionVisibility = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewUtilsApi23
 * JD-Core Version:    0.7.0.1
 */