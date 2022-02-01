package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class DiandianTopConfigManager$2$1
  implements Runnable
{
  DiandianTopConfigManager$2$1(DiandianTopConfigManager.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(false, null);
      return;
    }
    oidb_0xb7e.RspBody localRspBody = new oidb_0xb7e.RspBody();
    try
    {
      localRspBody.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      DiandianTopConfigManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicDiandianTopConfigManager$2.this$0, localRspBody);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(DiandianTopConfigManager.a, 2, "loadDiandianTopConfig, e = " + localException);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2.1
 * JD-Core Version:    0.7.0.1
 */