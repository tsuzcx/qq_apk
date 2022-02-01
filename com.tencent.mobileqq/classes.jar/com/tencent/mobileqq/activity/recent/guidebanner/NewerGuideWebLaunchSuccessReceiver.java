package com.tencent.mobileqq.activity.recent.guidebanner;

import alkp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class NewerGuideWebLaunchSuccessReceiver
  extends BroadcastReceiver
{
  private final WeakReference<alkp> a;
  
  public NewerGuideWebLaunchSuccessReceiver(alkp paramalkp)
  {
    this.a = new WeakReference(paramalkp);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideWebLaunchSuccessReceiver", 2, "onReceive");
    }
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS")))
    {
      paramContext = (alkp)this.a.get();
      if (paramContext != null)
      {
        paramIntent = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramIntent instanceof QQAppInterface)) {
          paramContext.b((QQAppInterface)paramIntent);
        }
        paramContext.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideWebLaunchSuccessReceiver
 * JD-Core Version:    0.7.0.1
 */