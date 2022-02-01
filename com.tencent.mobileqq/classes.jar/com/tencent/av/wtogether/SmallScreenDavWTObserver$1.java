package com.tencent.av.wtogether;

import android.content.Context;
import android.content.Intent;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mxa;

public class SmallScreenDavWTObserver$1
  implements Runnable
{
  public SmallScreenDavWTObserver$1(mxa parammxa, String paramString) {}
  
  public void run()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      Intent localIntent = new Intent(localBaseApplication, SmallScreenDialogActivity.class);
      localIntent.putExtra("tag_model", 1);
      localIntent.putExtra("tag_style", 1);
      localIntent.putExtra("tag_msg", this.a);
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("WTogether.ObserverImpl", 2, "startAlertDialog", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.SmallScreenDavWTObserver.1
 * JD-Core Version:    0.7.0.1
 */