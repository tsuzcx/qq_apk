package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenWatchTogether$5
  implements Runnable
{
  SmallScreenWatchTogether$5(SmallScreenWatchTogether paramSmallScreenWatchTogether) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131299920);
    QQToast.makeText(localBaseApplication, -1, localBaseApplication.getString(2131893771), 0).show(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether.5
 * JD-Core Version:    0.7.0.1
 */