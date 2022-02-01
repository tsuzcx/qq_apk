package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22
  extends ViewUtilsApi21
{
  private static boolean sTryHiddenSetLeftTopRightBottom = true;
  
  @SuppressLint({"NewApi"})
  public void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (sTryHiddenSetLeftTopRightBottom) {}
    try
    {
      paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label17:
      break label17;
    }
    sTryHiddenSetLeftTopRightBottom = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewUtilsApi22
 * JD-Core Version:    0.7.0.1
 */