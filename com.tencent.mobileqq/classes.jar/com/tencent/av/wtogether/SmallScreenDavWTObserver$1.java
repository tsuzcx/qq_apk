package com.tencent.av.wtogether;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class SmallScreenDavWTObserver$1
  implements Runnable
{
  SmallScreenDavWTObserver$1(SmallScreenDavWTObserver paramSmallScreenDavWTObserver, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), this.a, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.SmallScreenDavWTObserver.1
 * JD-Core Version:    0.7.0.1
 */