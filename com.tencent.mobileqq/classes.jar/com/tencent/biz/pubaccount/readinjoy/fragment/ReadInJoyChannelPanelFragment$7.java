package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import nsp;
import onh;
import ono;
import oop;
import org.json.JSONException;
import qao;

class ReadInJoyChannelPanelFragment$7
  implements Runnable
{
  ReadInJoyChannelPanelFragment$7(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, TabChannelCoverInfo paramTabChannelCoverInfo, qao paramqao, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = oop.a(onh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
      ono localono = new ono().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId).b().n(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo)).b(this.jdField_a_of_type_Qao.l + 1).c(this.jdField_a_of_type_Int).b("is_change", i);
      if (nsp.a()) {}
      for (i = 1;; i = 0)
      {
        ReadInJoyChannelPanelFragment.a("0X8009954", localono.b("style", i).a());
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "reportChannelExposure exception ", localJSONException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.7
 * JD-Core Version:    0.7.0.1
 */