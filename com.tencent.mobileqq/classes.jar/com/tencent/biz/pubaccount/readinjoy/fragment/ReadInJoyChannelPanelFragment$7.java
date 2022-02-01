package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import ozs;
import paa;
import pay;
import qvp;

class ReadInJoyChannelPanelFragment$7
  implements Runnable
{
  ReadInJoyChannelPanelFragment$7(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, TabChannelCoverInfo paramTabChannelCoverInfo, qvp paramqvp, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = pay.a(ozs.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
      ReadInJoyChannelPanelFragment.a("0X8009954", new paa().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId).b().n(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo)).b(this.jdField_a_of_type_Qvp.l + 1).c(this.jdField_a_of_type_Int).b("is_change", i).b("style", 0).a());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "reportChannelExposure exception ", localJSONException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.7
 * JD-Core Version:    0.7.0.1
 */