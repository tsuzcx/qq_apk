package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxModule;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ReadInJoyDeliverUGCActivity$16
  extends ReadInJoyObserver
{
  ReadInJoyDeliverUGCActivity$16(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 1, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2 + ", errorMsg: " + paramString3);
    ReadInJoyDeliverUGCActivity.c(this.a, true);
    if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
      ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
    }
    this.a.l();
    ReadInJoyDeliverUGCActivity.c(this.a, paramInt1);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverUGCActivity.a(this.a, 2, this.a.getString(2131718216));
      ReadInJoyDeliverUGCActivity.d(this.a, -1);
      ReadInJoyDeliverUGCActivity.d(this.a, true);
    }
    label273:
    label444:
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsId", String.valueOf(paramLong));
      ReadInJoyDeliverUGCActivity.a(this.a).put("rowkey", paramString1);
      ReadInJoyDeliverUGCActivity.a(this.a).put("status", paramInt2);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("comment", new String(Base64Util.encode(paramString1.getBytes(), 0)));
      if (ReadInJoyDeliverUGCActivity.e(this.a) != 12) {
        break label386;
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
    }
    catch (Exception paramString1)
    {
      List localList;
      label335:
      label729:
      break label273;
    }
    if (ReadInJoyDeliverUGCActivity.c(this.a))
    {
      paramString3 = null;
      paramString1 = null;
      if (RIJXTabConfigHandler.b().a())
      {
        localList = RIJXTabFrameUtils.a();
        paramString2 = paramString3;
        if (localList == null) {
          break label444;
        }
        paramString2 = paramString3;
        if (localList.size() <= 0) {
          break label444;
        }
        paramString3 = localList.iterator();
        paramString2 = paramString1;
        if (!paramString3.hasNext()) {
          break label444;
        }
        paramString2 = (TabChannelCoverInfo)paramString3.next();
        if ((paramString2 == null) || (paramString2.mChannelCoverId != 70)) {
          break label729;
        }
        paramString1 = paramString2.mChannelJumpUrl;
      }
    }
    for (;;)
    {
      break label335;
      label386:
      if (ReadInJoyDeliverUGCActivity.e(this.a) == 13)
      {
        ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 5);
        break;
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
      break;
      paramString2 = (String)ReadInJoyHelper.a("readinjoy_channel_follow_viola_url", "");
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2 + "&publishFeedsId=" + paramLong;
        ReadInJoyUtils.b(BaseApplicationImpl.getContext(), paramString1);
        if (ReadInJoyDeliverUGCActivity.d(this.a)) {
          paramString1 = new JSONObject();
        }
      }
      for (;;)
      {
        try
        {
          if (!ReadInJoyDeliverUGCActivity.e(this.a)) {
            continue;
          }
          paramInt1 = 70;
          paramString1.put("channel_id", paramInt1);
          paramString1.put("rowkey", "0");
          paramString1.put("topicid", ReadInJoyDeliverUGCActivity.c(this.a));
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          continue;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, paramLong + "", "1", "", paramString1.toString(), false);
        if (ReadInJoyDeliverUGCActivity.f(this.a) != -1L) {
          ReadInJoyDeliverUGCActivity.h(this.a).a(ReadInJoyDeliverUGCActivity.g(this.a));
        }
        ReadInJoyDeliverUGCActivity.d(this.a);
        this.a.finish();
        return;
        KandianSubscribeManager.a(this.a.getActivity(), 4);
        break;
        ReadInJoyLogicEngine.a().b(true);
        break;
        paramInt1 = 0;
      }
      if (paramInt1 == 33)
      {
        ReadInJoyDeliverUGCActivity.b(this.a, 1, paramString3);
        return;
      }
      ReadInJoyDeliverUGCActivity.c(this.a, 1, paramString3);
      this.a.i();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.16
 * JD-Core Version:    0.7.0.1
 */