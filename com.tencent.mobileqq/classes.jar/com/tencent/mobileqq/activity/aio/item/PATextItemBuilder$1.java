package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PATextItemBuilder$1
  implements View.OnClickListener
{
  PATextItemBuilder$1(PATextItemBuilder paramPATextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportPubAioItemClick(this.a.d.b, null);
    Object localObject1 = (PATextItemBuilder.Holder)AIOUtils.b(paramView);
    if (!((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).jumpNative(((PATextItemBuilder.Holder)localObject1).g, this.a.c))
    {
      Object localObject2;
      if ((((PATextItemBuilder.Holder)localObject1).h != null) && (((PATextItemBuilder.Holder)localObject1).h.equals("open_local")))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("schemaurl", ((PATextItemBuilder.Holder)localObject1).i);
        ((Bundle)localObject2).putString("uin", this.a.a.getCurrentAccountUin());
        OpenAppClient.b((Activity)this.a.c, (Bundle)localObject2);
      }
      else
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin", this.a.a.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("url", ((PATextItemBuilder.Holder)localObject1).i);
        ((Intent)localObject2).putExtra("assignBackText", this.a.c.getResources().getString(2131887625));
        ((Intent)localObject2).putExtra("puin", this.a.d.b);
        ((Intent)localObject2).putExtra("source_name", this.a.d.e);
        Object localObject3;
        if ((((PATextItemBuilder.Holder)localObject1).q instanceof MessageForPubAccount))
        {
          long l2 = -1L;
          localObject3 = (MessageForPubAccount)((PATextItemBuilder.Holder)localObject1).q;
          long l1 = l2;
          if (((MessageForPubAccount)localObject3).mPAMessage != null)
          {
            l1 = l2;
            if (((MessageForPubAccount)localObject3).mPAMessage.mMsgId > 0L) {
              l1 = ((MessageForPubAccount)localObject3).mPAMessage.mMsgId;
            }
          }
          if (l1 >= 0L) {
            ((Intent)localObject2).putExtra("msg_id", String.valueOf(l1));
          }
        }
        ((Intent)localObject2).putExtra("fromAio", true);
        ((Intent)localObject2).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.a.d.b));
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, ((PATextItemBuilder.Holder)localObject1).i);
        if (((Intent)localObject2).getComponent() != null)
        {
          this.a.c.startActivity((Intent)localObject2);
        }
        else
        {
          localObject3 = new ActivityURIRequest(this.a.c, "/pubaccount/browser");
          ((ActivityURIRequest)localObject3).extra().putAll(((Intent)localObject2).getExtras());
          QRoute.startUri((URIRequest)localObject3, null);
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, ((PATextItemBuilder.Holder)localObject1).i, "", "", "");
      }
    }
    localObject1 = ((PATextItemBuilder.Holder)localObject1).q;
    if ((localObject1 instanceof MessageForPubAccount))
    {
      localObject1 = (MessageForPubAccount)localObject1;
      if ((((MessageForPubAccount)localObject1).mPAMessage != null) && (((MessageForPubAccount)localObject1).mPAMessage.mMsgId > 0L)) {
        ReportController.b(this.a.a, "P_CliOper", "Pb_account_lifeservice", ((MessageForPubAccount)localObject1).frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(((MessageForPubAccount)localObject1).mPAMessage.mMsgId), "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PATextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */