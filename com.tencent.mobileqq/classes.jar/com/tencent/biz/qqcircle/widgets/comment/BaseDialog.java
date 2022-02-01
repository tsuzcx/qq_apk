package com.tencent.biz.qqcircle.widgets.comment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class BaseDialog
  extends ReportDialog
{
  public BaseDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  @TargetApi(19)
  public void b()
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 19) {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((getWindow() != null) && (getWindow().getDecorView() != null))
        {
          getWindow().clearFlags(67108864);
          getWindow().getDecorView().setSystemUiVisibility(1280);
          getWindow().addFlags(-2147483648);
          getWindow().setStatusBarColor(0);
        }
      }
      else if (getWindow() != null) {
        getWindow().addFlags(67108864);
      }
    }
    Object localObject = getWindow();
    if (localObject == null) {
      return;
    }
    localObject = ((Window)localObject).getDecorView();
    if ((localObject instanceof ViewGroup))
    {
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        j = ((ViewGroup)localObject).getChildCount();
        while (i < j)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if (localView == null) {
            return;
          }
          if (localView.getId() == 16908290) {
            return;
          }
          if (!(localView instanceof ViewStub)) {
            localView.setAlpha(0.0F);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.comment.BaseDialog
 * JD-Core Version:    0.7.0.1
 */