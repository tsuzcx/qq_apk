package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class NewerGuideWebLaunchSuccessReceiver
  extends BroadcastReceiver
{
  private final WeakReference<NewerGuideBannerViewModel> a;
  
  public NewerGuideWebLaunchSuccessReceiver(NewerGuideBannerViewModel paramNewerGuideBannerViewModel)
  {
    this.a = new WeakReference(paramNewerGuideBannerViewModel);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideWebLaunchSuccessReceiver", 2, "onReceive");
    }
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS")))
    {
      paramContext = (NewerGuideBannerViewModel)this.a.get();
      if (paramContext != null)
      {
        ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).notifyClickCloseBanner(paramContext);
        paramContext.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideWebLaunchSuccessReceiver
 * JD-Core Version:    0.7.0.1
 */