package com.tencent.biz.common.offline;

import android.content.Context;
import com.tencent.biz.common.offline.util.ILog;

final class HtmlOffline$1
  implements Runnable
{
  HtmlOffline$1(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack) {}
  
  public void run()
  {
    if (HtmlOffline.f.a()) {
      HtmlOffline.f.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new HtmlOffline.TransUrl(this.a, this.b, this.c).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */