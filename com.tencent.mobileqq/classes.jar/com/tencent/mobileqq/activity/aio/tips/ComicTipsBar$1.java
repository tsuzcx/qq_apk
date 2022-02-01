package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ComicTipsBar$1
  implements View.OnClickListener
{
  ComicTipsBar$1(ComicTipsBar paramComicTipsBar, View paramView) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.b.h) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("from", "19");
      label27:
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.b.c, "/base/vipcomic");
      localActivityURIRequest.extra().putString("options", localJSONObject.toString());
      QRoute.startUri(localActivityURIRequest, null);
      break label75;
      this.b.c.finish();
      label75:
      this.a.postDelayed(new ComicTipsBar.1.1(this), 2500L);
      if (this.b.h) {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.b.a, "3009", "2", "40039", this.b.e, new String[0]);
      } else {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.b.a, "3006", "2", "40025", this.b.e, new String[] { "2" });
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ComicTipsBar.1
 * JD-Core Version:    0.7.0.1
 */