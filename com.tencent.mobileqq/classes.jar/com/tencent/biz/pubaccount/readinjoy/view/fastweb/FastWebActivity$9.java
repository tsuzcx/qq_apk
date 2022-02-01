package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatus;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.UserInfoItem;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class FastWebActivity$9
  implements RIJLiveStatusModule.LiveStatusCallback
{
  FastWebActivity$9(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, List<RIJLiveStatusModule.UserInfoItem> paramList)
  {
    QLog.d("FastWebActivity", 1, "live Status Callback");
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RIJLiveStatusModule.UserInfoItem localUserInfoItem = (RIJLiveStatusModule.UserInfoItem)paramList.next();
        if ((localUserInfoItem.jdField_a_of_type_Long == FastWebActivity.a(this.a).d) && (localUserInfoItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus.a == 1))
        {
          QLog.d("FastWebActivity", 1, "need to show live status");
          FastWebActivity.c(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.9
 * JD-Core Version:    0.7.0.1
 */