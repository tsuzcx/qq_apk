package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJWebArticlePreloadUtil$preload$runnable$1
  implements Runnable
{
  public RIJWebArticlePreloadUtil$preload$runnable$1(String paramString) {}
  
  public final void run()
  {
    Intent localIntent = new Intent((Context)BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
    localIntent.setAction("action_preload_rij_article");
    localIntent.putExtra("BUNDLE_KEY_ARTICLE_URL", this.a);
    try
    {
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJWebArticlePreloadUtil", 1, "[preload] e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil.preload.runnable.1
 * JD-Core Version:    0.7.0.1
 */