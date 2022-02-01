package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.FeedbackCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class FastWebRequestUtil$7
  implements Runnable
{
  FastWebRequestUtil$7(ArticleInfo paramArticleInfo, ReadInJoyFeedbackPopupWindow.FeedbackCallback paramFeedbackCallback) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject2 = ReadInJoyUtils.a();
        str2 = ((TicketManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(2)).getSkey((String)localObject2);
        localBundle1 = new Bundle();
        localBundle1.putString("type", "1");
        localBundle1.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin));
        if (RIJItemViewType.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label360;
        }
        if (!RIJItemViewType.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label367;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        String str2;
        Bundle localBundle1;
        Object localObject1;
        Bundle localBundle2;
        int i;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback == null) {
          continue;
        }
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.7.2(this, localException));
        QLog.d("FastWebRequestUtil", 2, "shieldFeedSource exception. ", localException);
        return;
      }
      localBundle1.putString("accountType", (String)localObject1);
      if (str2 == null)
      {
        localObject1 = "";
        localBundle1.putString("g_tk", (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, new Object[] { "shieldFeedSource, params type = ", localBundle1.getString("type"), ", uin = ", localBundle1.getString("uin"), ", accountType = ", localBundle1.getString("accountType") });
        }
        localObject1 = "";
        localBundle2 = new Bundle();
        localBundle2.putString("cookie", "uin=o" + (String)localObject2 + ";skey=" + str2);
        localObject2 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://kandian.qq.com/cgi-bin/social/setNotCare", "GET", localBundle1, localBundle2);
        if (localObject2 != null) {
          localObject1 = new String((byte[])localObject2);
        }
        QLog.d("FastWebRequestUtil", 1, new Object[] { "shieldFeeds result = ", localObject1 });
        localObject1 = new JSONObject((String)localObject1).getJSONObject("result");
        i = ((JSONObject)localObject1).getInt("retCode");
        localObject1 = ((JSONObject)localObject1).getString("retMsg");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback != null) {
          ThreadManager.getUIHandler().post(new FastWebRequestUtil.7.1(this, i, (String)localObject1));
        }
      }
      else
      {
        localObject1 = ReadInJoyWebDataManager.a(str2);
        continue;
        label360:
        str1 = "1";
        continue;
      }
      return;
      label367:
      String str1 = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.7
 * JD-Core Version:    0.7.0.1
 */