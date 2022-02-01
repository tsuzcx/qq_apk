package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenVideoController$MyVideoObserver$1
  implements Runnable
{
  SmallScreenVideoController$MyVideoObserver$1(SmallScreenVideoController.MyVideoObserver paramMyVideoObserver) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131299166);
    QQToast.a(localBaseApplication, -1, localBaseApplication.getString(2131695999), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1
 * JD-Core Version:    0.7.0.1
 */