package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.cmd0xe36.cmd0xe36.RspBody;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class BridgeModuleHelper$2
  extends ProtoUtils.TroopProtocolObserver
{
  BridgeModuleHelper$2(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("BridgeModuleHelper", 1, "yyy_0xe36 error code: " + paramInt);
    if (paramInt == 0) {
      paramBundle = new cmd0xe36.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = 0;
      paramArrayOfByte = "";
      if (paramBundle.code.has()) {
        paramInt = paramBundle.code.get();
      }
      if (paramBundle.wording.has()) {
        paramArrayOfByte = paramBundle.wording.get();
      }
      QLog.i("BridgeModuleHelper", 1, "yyy_0xe36 code: " + paramInt + "\nwording: " + paramArrayOfByte);
      if ((paramInt != 0) && (!TextUtils.isEmpty(paramArrayOfByte)))
      {
        paramBundle = new JSONObject();
        paramBundle.put("wording", paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramBundle);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.i("BridgeModuleHelper", 1, "yyy_0xe36 error: " + paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.2
 * JD-Core Version:    0.7.0.1
 */