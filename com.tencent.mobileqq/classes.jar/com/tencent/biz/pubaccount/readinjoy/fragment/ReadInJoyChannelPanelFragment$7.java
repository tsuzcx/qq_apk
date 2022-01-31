package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import nss;
import onk;
import onr;
import oos;
import org.json.JSONException;
import qar;

class ReadInJoyChannelPanelFragment$7
  implements Runnable
{
  ReadInJoyChannelPanelFragment$7(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, TabChannelCoverInfo paramTabChannelCoverInfo, qar paramqar, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = oos.a(onk.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
      onr localonr = new onr().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId).b().n(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo)).b(this.jdField_a_of_type_Qar.l + 1).c(this.jdField_a_of_type_Int).b("is_change", i);
      if (nss.a()) {}
      for (i = 1;; i = 0)
      {
        ReadInJoyChannelPanelFragment.a("0X8009954", localonr.b("style", i).a());
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