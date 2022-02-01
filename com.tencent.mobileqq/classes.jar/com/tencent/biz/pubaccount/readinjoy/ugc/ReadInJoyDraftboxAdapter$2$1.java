package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1(ReadInJoyDraftboxAdapter.2 param2) {}
  
  public void run()
  {
    boolean bool = ReadInJoyDraftboxAdapter.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */