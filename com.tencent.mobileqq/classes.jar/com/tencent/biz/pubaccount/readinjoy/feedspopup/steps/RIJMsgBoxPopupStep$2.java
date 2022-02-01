package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;

class RIJMsgBoxPopupStep$2
  implements Runnable
{
  RIJMsgBoxPopupStep$2(RIJMsgBoxPopupStep paramRIJMsgBoxPopupStep, KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo, KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.writeToSP();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep.2
 * JD-Core Version:    0.7.0.1
 */