package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class AccountDetailCustomModuleBaseWrapper$2
  implements AdapterView.OnItemClickListener
{
  AccountDetailCustomModuleBaseWrapper$2(AccountDetailCustomModuleBaseWrapper paramAccountDetailCustomModuleBaseWrapper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (PaConfigAttr.PaConfigInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailHandlerAccountDetailBaseItemClickHandler != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailHandlerAccountDetailBaseItemClickHandler.a(paramAdapterView);
    }
    this.a.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailCustomModuleBaseWrapper.2
 * JD-Core Version:    0.7.0.1
 */