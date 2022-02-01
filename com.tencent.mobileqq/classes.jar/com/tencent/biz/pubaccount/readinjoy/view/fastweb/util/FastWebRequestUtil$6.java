package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import pay;
import rtb;
import tcn;

public final class FastWebRequestUtil$6
  implements Runnable
{
  public FastWebRequestUtil$6(ArticleInfo paramArticleInfo, tcn paramtcn) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new Bundle();
      Object localObject1 = (QQAppInterface)pay.a();
      String str1 = pay.a();
      String str2 = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getSkey(str1);
      ((Bundle)localObject2).putString("feeds_id", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId));
      ((Bundle)localObject2).putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin));
      ((Bundle)localObject2).putString("feedsType", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType));
      if (str2 == null) {}
      for (localObject1 = "";; localObject1 = rtb.a(str2))
      {
        ((Bundle)localObject2).putString("g_tk", (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, new Object[] { "params feeds_id = ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), ", uin = ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin), ", feedsType = ", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType) });
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("cookie", "uin=o" + str1 + ";skey=" + str2);
        localObject2 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://kandian.qq.com/qz_kandian_social/kandian_ext/deleteFeeds", "GET", (Bundle)localObject2, (Bundle)localObject1);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = new String((byte[])localObject2);
        }
        QLog.d("FastWebRequestUtil", 1, new Object[] { "deleteFeeds result = ", localObject1 });
        localObject1 = new JSONObject((String)localObject1).getJSONObject("result");
        int i = ((JSONObject)localObject1).getInt("retCode");
        localObject1 = ((JSONObject)localObject1).getString("retMsg");
        if (this.jdField_a_of_type_Tcn == null) {
          break;
        }
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.1(this, i, (String)localObject1));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Tcn != null) {
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.2(this, localException));
      }
      QLog.d("FastWebRequestUtil", 2, "deleteFeeds exception. ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.6
 * JD-Core Version:    0.7.0.1
 */