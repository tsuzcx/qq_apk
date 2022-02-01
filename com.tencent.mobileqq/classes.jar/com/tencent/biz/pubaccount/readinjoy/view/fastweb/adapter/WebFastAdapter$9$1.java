package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import ssq;

class WebFastAdapter$9$1
  implements Runnable
{
  WebFastAdapter$9$1(WebFastAdapter.9 param9) {}
  
  public void run()
  {
    Intent localIntent = ssq.a(this.a.this$0).getPackageManager().getLaunchIntentForPackage("com.tencent.reading");
    if (localIntent != null)
    {
      localIntent.setFlags(268435456);
      localIntent.putExtra("big_brother_source_key", "biz_src_kandian_read");
      ssq.a(this.a.this$0).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.9.1
 * JD-Core Version:    0.7.0.1
 */