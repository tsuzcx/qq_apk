package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import nzb;

public class ReadInJoyFeedsActivity$5$1
  implements Runnable
{
  public ReadInJoyFeedsActivity$5$1(nzb paramnzb) {}
  
  public void run()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.a.app.getManager(162);
    if (localKandianMergeManager != null) {
      localKandianMergeManager.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.5.1
 * JD-Core Version:    0.7.0.1
 */