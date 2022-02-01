package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ViewUtilsApi21
  extends ViewUtilsApi19
{
  private static boolean sTryHiddenSetAnimationMatrix = true;
  private static boolean sTryHiddenTransformMatrixToGlobal = true;
  private static boolean sTryHiddenTransformMatrixToLocal = true;
  
  @SuppressLint({"NewApi"})
  public void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    if (sTryHiddenSetAnimationMatrix) {}
    try
    {
      paramView.setAnimationMatrix(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    sTryHiddenSetAnimationMatrix = false;
  }
  
  @SuppressLint({"NewApi"})
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    if (sTryHiddenTransformMatrixToGlobal) {}
    try
    {
      paramView.transformMatrixToGlobal(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    sTryHiddenTransformMatrixToGlobal = false;
  }
  
  @SuppressLint({"NewApi"})
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    if (sTryHiddenTransformMatrixToLocal) {}
    try
    {
      paramView.transformMatrixToLocal(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    sTryHiddenTransformMatrixToLocal = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewUtilsApi21
 * JD-Core Version:    0.7.0.1
 */