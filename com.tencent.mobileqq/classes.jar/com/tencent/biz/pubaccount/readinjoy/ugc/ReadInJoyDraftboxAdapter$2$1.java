package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pwc;
import ria;
import ric;

public class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  public ReadInJoyDraftboxAdapter$2$1(ric paramric) {}
  
  public void run()
  {
    boolean bool = ria.a(this.a.jdField_a_of_type_Ria).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */