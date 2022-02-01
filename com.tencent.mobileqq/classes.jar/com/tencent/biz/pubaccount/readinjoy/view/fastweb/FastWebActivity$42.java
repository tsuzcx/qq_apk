package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$42
  implements Runnable
{
  FastWebActivity$42(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 1, "requestControllInfo requestInsertArticlesAndRecordAction in native page");
    RIJFeedsDynamicInsertController.a.a(this.this$0.a.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE, 0, 0, 0), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42
 * JD-Core Version:    0.7.0.1
 */