package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class ReadInJoyFeedsActivity$6
  implements Runnable
{
  ReadInJoyFeedsActivity$6(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void run()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.this$0.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localKandianMergeManager != null) {
      localKandianMergeManager.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.6
 * JD-Core Version:    0.7.0.1
 */