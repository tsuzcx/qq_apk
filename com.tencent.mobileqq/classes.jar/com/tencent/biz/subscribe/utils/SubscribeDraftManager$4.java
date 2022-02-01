package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.Pair;

class SubscribeDraftManager$4
  implements Runnable
{
  SubscribeDraftManager$4(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Pair localPair = SubscribeDraftManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      FileUtils.e((String)localPair.first);
      FileUtils.e((String)localPair.second);
      if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */