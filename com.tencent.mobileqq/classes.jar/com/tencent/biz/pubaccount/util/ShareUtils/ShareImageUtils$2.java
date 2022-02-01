package com.tencent.biz.pubaccount.util.ShareUtils;

import android.content.Context;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import uwi;
import uwk;

public final class ShareImageUtils$2
  implements Runnable
{
  public ShareImageUtils$2(Context paramContext) {}
  
  public void run()
  {
    if ((this.a instanceof AppActivity))
    {
      if (!CheckPermission.isHasStoragePermission(this.a)) {
        CheckPermission.requestSDCardPermission((AppActivity)this.a, new uwk(this));
      }
      uwi.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.2
 * JD-Core Version:    0.7.0.1
 */