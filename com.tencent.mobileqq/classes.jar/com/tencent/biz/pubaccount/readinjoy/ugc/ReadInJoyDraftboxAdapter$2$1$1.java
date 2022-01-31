package com.tencent.biz.pubaccount.readinjoy.ugc;

import ajya;
import android.content.Context;
import bcql;
import java.util.List;
import nol;
import qfc;
import qfe;

class ReadInJoyDraftboxAdapter$2$1$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1$1(ReadInJoyDraftboxAdapter.2.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    Context localContext = qfc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Qfc);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajya.a(2131712951);; str = ajya.a(2131712812))
    {
      bcql.a(localContext, 2, str, 1).a();
      if (this.jdField_a_of_type_Boolean)
      {
        nol.a(null, "", "0X80096E0", "0X80096E0", 0, 0, qfc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Qfc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
        qfc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Qfc).remove(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Qfc.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */