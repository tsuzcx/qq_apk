package com.tencent.mobileqq.apollo.view;

import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameWrapper
{
  public static void a(boolean paramBoolean, Activity paramActivity, TipsManager paramTipsManager, AppInterface paramAppInterface, String paramString, ApolloGameWrapper.CheckGameListener paramCheckGameListener)
  {
    a(paramBoolean, paramActivity, paramTipsManager, paramAppInterface, paramString, paramCheckGameListener, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, TipsManager paramTipsManager, AppInterface paramAppInterface, String paramString, ApolloGameWrapper.CheckGameListener paramCheckGameListener, boolean paramBoolean2)
  {
    if (paramCheckGameListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame listener is null");
      }
      return;
    }
    if ((paramActivity == null) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame activity is null OR appInterface is null");
      }
      paramCheckGameListener.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramTipsManager = CmGameMainManager.a(paramString);
      if ((paramTipsManager == null) || (paramTipsManager.a == null) || (paramTipsManager.a.get() != paramActivity))
      {
        paramCheckGameListener.a(false, paramTipsManager);
        return;
      }
      paramCheckGameListener.a(true, paramTipsManager);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramCheckGameListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper
 * JD-Core Version:    0.7.0.1
 */