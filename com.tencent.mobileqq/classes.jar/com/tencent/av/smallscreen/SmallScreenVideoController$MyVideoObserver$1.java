package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import lzy;

public class SmallScreenVideoController$MyVideoObserver$1
  implements Runnable
{
  public SmallScreenVideoController$MyVideoObserver$1(lzy paramlzy) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131299080);
    QQToast.a(localBaseApplication, -1, localBaseApplication.getString(2131695752), 0).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1
 * JD-Core Version:    0.7.0.1
 */