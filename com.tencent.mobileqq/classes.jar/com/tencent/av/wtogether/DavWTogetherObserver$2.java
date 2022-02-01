package com.tencent.av.wtogether;

import android.app.Activity;
import com.tencent.av.wtogether.util.WTogetherUtil;

class DavWTogetherObserver$2
  implements Runnable
{
  DavWTogetherObserver$2(DavWTogetherObserver paramDavWTogetherObserver, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    String str = this.a.getString(2131695991);
    WTogetherUtil.a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver.2
 * JD-Core Version:    0.7.0.1
 */