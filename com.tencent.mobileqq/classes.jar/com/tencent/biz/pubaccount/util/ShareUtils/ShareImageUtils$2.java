package com.tencent.biz.pubaccount.util.ShareUtils;

import android.content.Context;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;

final class ShareImageUtils$2
  implements Runnable
{
  ShareImageUtils$2(Context paramContext) {}
  
  public void run()
  {
    Context localContext = this.a;
    if ((localContext instanceof AppActivity))
    {
      if (!CheckPermission.isHasStoragePermission(localContext)) {
        CheckPermission.requestSDCardPermission((AppActivity)this.a, new ShareImageUtils.2.1(this));
      }
      ShareImageUtils.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.2
 * JD-Core Version:    0.7.0.1
 */