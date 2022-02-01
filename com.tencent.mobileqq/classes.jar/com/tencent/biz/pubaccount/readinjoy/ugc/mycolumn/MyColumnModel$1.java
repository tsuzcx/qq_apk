package com.tencent.biz.pubaccount.readinjoy.ugc.mycolumn;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListModel.LoadDataFromNetworkCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MyColumnModel$1
  extends ProtoUtils.TroopProtocolObserver
{
  MyColumnModel$1(MyColumnModel paramMyColumnModel, ListModel.LoadDataFromNetworkCallback paramLoadDataFromNetworkCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    MyColumnModel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcMycolumnMyColumnModel, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel$LoadDataFromNetworkCallback.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    MyColumnModel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcMycolumnMyColumnModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel$LoadDataFromNetworkCallback, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.mycolumn.MyColumnModel.1
 * JD-Core Version:    0.7.0.1
 */