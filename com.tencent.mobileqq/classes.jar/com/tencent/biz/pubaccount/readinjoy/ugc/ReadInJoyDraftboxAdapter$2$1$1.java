package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ReadInJoyDraftboxAdapter$2$1$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1$1(ReadInJoyDraftboxAdapter.2.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    Context localContext = ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = HardCodeUtil.a(2131712908);; str = HardCodeUtil.a(2131712775))
    {
      QQToast.a(localContext, 2, str, 1).a();
      if (this.jdField_a_of_type_Boolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80096E0", "0X80096E0", 0, 0, ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
        ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter).remove(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */