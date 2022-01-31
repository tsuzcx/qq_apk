package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import oqf;
import pth;
import ptj;

public class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  public ReadInJoyDraftboxAdapter$2$1(ptj paramptj) {}
  
  public void run()
  {
    boolean bool = pth.a(this.a.jdField_a_of_type_Pth).a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */