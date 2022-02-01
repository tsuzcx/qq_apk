package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.richframework.activity.ComponentBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class QCirclePermissionUtil
{
  public static void a(Activity paramActivity, Object paramObject, int paramInt, String... paramVarArgs)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      View localView = paramActivity.getWindow().getDecorView();
      if ((localView.getParent() instanceof View)) {
        paramActivity = ((View)localView.getParent()).getContext();
      }
      if ((paramActivity instanceof AppActivity))
      {
        QLog.d("QCirclePermissionUtil", 1, "requestPermissions in AppActivity");
        ((AppActivity)paramActivity).requestPermissions(paramObject, paramInt, paramVarArgs);
        return;
      }
      if ((paramActivity instanceof ComponentBaseActivity))
      {
        QLog.d("QCirclePermissionUtil", 1, "requestPermissions in ComponentBaseActivity");
        ((ComponentBaseActivity)paramActivity).a(paramObject, paramInt, paramVarArgs);
        return;
      }
      QLog.d("QCirclePermissionUtil", 1, "requestPermissions error with unknown activity");
      return;
    }
    QLog.d("QCirclePermissionUtil", 1, "requestPermissions error with null activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCirclePermissionUtil
 * JD-Core Version:    0.7.0.1
 */