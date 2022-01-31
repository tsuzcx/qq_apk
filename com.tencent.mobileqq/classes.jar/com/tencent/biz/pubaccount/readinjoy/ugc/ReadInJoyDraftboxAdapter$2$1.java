package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pgo;
import qpi;
import qpk;

public class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  public ReadInJoyDraftboxAdapter$2$1(qpk paramqpk) {}
  
  public void run()
  {
    boolean bool = qpi.a(this.a.jdField_a_of_type_Qpi).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */