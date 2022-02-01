package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

public final class SnackBarAlert
{
  public static final int SNACKBAR_ANIMA_TIME = 1800;
  private static boolean a = false;
  
  public static boolean isShow()
  {
    return a;
  }
  
  public static void setShowMode(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void showToast(Activity paramActivity, String paramString)
  {
    showToastWithAction(new SnackBar.Builder(paramActivity).withMessage(paramString).withDuration(Short.valueOf((short)1500)), null, null);
  }
  
  public static void showToast(Context paramContext, View paramView, String paramString, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    showToastWithAction(new SnackBar.Builder(paramContext, paramView).withMessage(paramString).withDuration(Short.valueOf((short)1500)), paramOnVisibilityChangeListener);
  }
  
  public static void showToastWithAction(Activity paramActivity, String paramString1, String paramString2, SnackBar.OnMessageClickListener paramOnMessageClickListener)
  {
    showToastWithAction(new SnackBar.Builder(paramActivity).withMessage(paramString1).withActionMessage(paramString2).withDuration(Short.valueOf((short)2500)), paramOnMessageClickListener, null);
  }
  
  public static void showToastWithAction(Activity paramActivity, String paramString1, String paramString2, SnackBar.OnMessageClickListener paramOnMessageClickListener, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    showToastWithAction(new SnackBar.Builder(paramActivity).withMessage(paramString1).withActionMessage(paramString2).withDuration(Short.valueOf((short)2500)), paramOnMessageClickListener, paramOnVisibilityChangeListener);
  }
  
  public static void showToastWithAction(Context paramContext, View paramView, String paramString1, String paramString2, SnackBar.OnMessageClickListener paramOnMessageClickListener)
  {
    showToastWithAction(new SnackBar.Builder(paramContext, paramView).withMessage(paramString1).withActionMessage(paramString2).withDuration(Short.valueOf((short)2500)), paramOnMessageClickListener, null);
  }
  
  public static void showToastWithAction(Context paramContext, View paramView, String paramString1, String paramString2, SnackBar.OnMessageClickListener paramOnMessageClickListener, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    showToastWithAction(new SnackBar.Builder(paramContext, paramView).withMessage(paramString1).withActionMessage(paramString2).withDuration(Short.valueOf((short)2500)), paramOnMessageClickListener, paramOnVisibilityChangeListener);
  }
  
  public static void showToastWithAction(Fragment paramFragment, String paramString1, String paramString2, SnackBar.OnMessageClickListener paramOnMessageClickListener, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    showToastWithAction(new SnackBar.Builder(paramFragment.getContext(), paramFragment.getView()).withMessage(paramString1).withActionMessage(paramString2).withDuration(Short.valueOf((short)2500)), paramOnMessageClickListener, paramOnVisibilityChangeListener);
  }
  
  public static void showToastWithAction(SnackBar.Builder paramBuilder, SnackBar.OnMessageClickListener paramOnMessageClickListener, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    if (paramOnMessageClickListener != null) {
      paramBuilder.withOnClickListener(paramOnMessageClickListener);
    }
    if (paramOnVisibilityChangeListener != null) {
      paramBuilder.withVisibilityChangeListener(paramOnVisibilityChangeListener);
    }
    paramBuilder.show();
  }
  
  public static void showToastWithAction(SnackBar.Builder paramBuilder, SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    if (paramOnVisibilityChangeListener != null) {
      paramBuilder.withVisibilityChangeListener(paramOnVisibilityChangeListener);
    }
    paramBuilder.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackBarAlert
 * JD-Core Version:    0.7.0.1
 */