package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class ViewUtilsApi19
  extends ViewUtilsBase
{
  private static boolean sTryHiddenTransitionAlpha = true;
  
  public void clearNonTransitionAlpha(@NonNull View paramView) {}
  
  @SuppressLint({"NewApi"})
  public float getTransitionAlpha(@NonNull View paramView)
  {
    if (sTryHiddenTransitionAlpha) {}
    try
    {
      float f = paramView.getTransitionAlpha();
      return f;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label13:
      break label13;
    }
    sTryHiddenTransitionAlpha = false;
    return paramView.getAlpha();
  }
  
  public void saveNonTransitionAlpha(@NonNull View paramView) {}
  
  @SuppressLint({"NewApi"})
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    if (sTryHiddenTransitionAlpha) {}
    try
    {
      paramView.setTransitionAlpha(paramFloat);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label12:
      break label12;
    }
    sTryHiddenTransitionAlpha = false;
    paramView.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ViewUtilsApi19
 * JD-Core Version:    0.7.0.1
 */