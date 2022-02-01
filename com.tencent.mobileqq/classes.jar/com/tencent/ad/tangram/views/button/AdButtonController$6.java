package com.tencent.ad.tangram.views.button;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.util.AdAppReceiver;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class AdButtonController$6
  implements View.OnClickListener
{
  AdButtonController$6(AdButtonController paramAdButtonController, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (!AdButtonController.access$1200(this.this$0))
    {
      AdLog.e("AdButtonController", "onClick error");
    }
    else
    {
      AdLog.i("AdButtonController", String.format("onClick status:%d layerDisplayed:%b", new Object[] { Integer.valueOf(AdButtonController.access$400(this.this$0)), Boolean.valueOf(AdButtonController.access$1300(this.this$0)) }));
      boolean bool3 = AdButtonController.access$800(this.this$0).reportForClick;
      Object localObject = AdButtonController.access$800(this.this$0);
      boolean bool1;
      if ((this.val$inPlacement) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((AdClickUtil.Params)localObject).reportForClick = bool1;
      if (AdClickUtil.isValidForApp(AdButtonController.access$800(this.this$0)))
      {
        if ((AdButtonController.access$800(this.this$0).appReceiver != null) && (AdButtonController.access$800(this.this$0).appReceiver.get() != null)) {
          ((AdAppReceiver)AdButtonController.access$800(this.this$0).appReceiver.get()).observe(AdButtonController.access$800(this.this$0));
        }
        if (AdButtonController.access$400(this.this$0) == 2)
        {
          if ((AdButtonController.access$800(this.this$0).enableAutoDownload) && (AdNet.isWifiConnected((Context)AdButtonController.access$800(this.this$0).activity.get()))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject = this.this$0;
          boolean bool2;
          if ((!bool1) && (!AdButtonController.access$1300((AdButtonController)localObject))) {
            bool2 = false;
          } else {
            bool2 = true;
          }
          AdButtonController.access$1400((AdButtonController)localObject, bool1, bool2);
          if ((this.val$inPlacement) && (!AdButtonController.access$1300(this.this$0)))
          {
            AdButtonController.access$1302(this.this$0, true);
            AdButtonController.access$902(this.this$0, new a());
            localObject = new a.a();
            ((a.a)localObject).logoUrl = AdButtonController.access$800(this.this$0).ad.getAdvertiser_corporate_logo();
            ((a.a)localObject).appName = AdButtonController.access$800(this.this$0).ad.getAppName();
            ((a.a)localObject).rightInfoUrl = AdButtonController.access$800(this.this$0).ad.getAppRightInfoUrl();
            AdButtonController.access$900(this.this$0).setParams((a.a)localObject);
            localObject = this.this$0;
            ((AdButtonController)localObject).registerView(new WeakReference(AdButtonController.access$900((AdButtonController)localObject)), false);
            AdButtonController.access$900(this.this$0).show(((Activity)AdButtonController.access$800(this.this$0).activity.get()).getFragmentManager(), "AdAppDownloadLayerFragment");
          }
          if (AdButtonController.access$800(this.this$0).reportForClick) {
            AdReporterForClick.reportAsync(new WeakReference(AdButtonController.access$800(this.this$0).activity.get()), AdButtonController.access$800(this.this$0).ad, AdButtonController.access$800(this.this$0).ad.getUrlForClick());
          }
        }
        else if (AdButtonController.access$400(this.this$0) == 3)
        {
          if (AdButtonController.access$800(this.this$0).reportForClick) {
            AdReporterForClick.reportAsync(new WeakReference(AdButtonController.access$800(this.this$0).activity.get()), AdButtonController.access$800(this.this$0).ad, AdButtonController.access$800(this.this$0).ad.getUrlForClick());
          }
        }
        else if ((AdButtonController.access$400(this.this$0) != 4) && (AdButtonController.access$400(this.this$0) != 7))
        {
          if ((AdButtonController.access$400(this.this$0) != 5) && (AdButtonController.access$400(this.this$0) != 6))
          {
            if (AdButtonController.access$400(this.this$0) == 8)
            {
              AdButtonController.access$1700(this.this$0);
              if (AdButtonController.access$800(this.this$0).reportForClick) {
                AdReporterForClick.reportAsync(new WeakReference(AdButtonController.access$800(this.this$0).activity.get()), AdButtonController.access$800(this.this$0).ad, AdButtonController.access$800(this.this$0).ad.getUrlForClick());
              }
            }
            else
            {
              AdClickUtil.handle(AdButtonController.access$800(this.this$0));
            }
          }
          else
          {
            AdButtonController.access$1600(this.this$0);
            if (AdButtonController.access$800(this.this$0).reportForClick) {
              AdReporterForClick.reportAsync(new WeakReference(AdButtonController.access$800(this.this$0).activity.get()), AdButtonController.access$800(this.this$0).ad, AdButtonController.access$800(this.this$0).ad.getUrlForClick());
            }
          }
        }
        else
        {
          AdButtonController.access$1500(this.this$0);
          if (AdButtonController.access$800(this.this$0).reportForClick) {
            AdReporterForClick.reportAsync(new WeakReference(AdButtonController.access$800(this.this$0).activity.get()), AdButtonController.access$800(this.this$0).ad, AdButtonController.access$800(this.this$0).ad.getUrlForClick());
          }
        }
      }
      else
      {
        AdClickUtil.handle(AdButtonController.access$800(this.this$0));
      }
      AdButtonController.access$800(this.this$0).reportForClick = bool3;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.6
 * JD-Core Version:    0.7.0.1
 */