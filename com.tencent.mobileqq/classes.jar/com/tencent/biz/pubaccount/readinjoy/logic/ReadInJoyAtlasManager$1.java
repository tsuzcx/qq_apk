package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;

class ReadInJoyAtlasManager$1
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 2, "fetchAtlasBiuCount onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_cmd0xb54.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        long l;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null)
        {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl;
          if (!paramBundle.msg_rsp_biu_count.has()) {
            break label102;
          }
          l = paramBundle.msg_rsp_biu_count.uint64_biu_count.get();
          paramArrayOfByte.a(true, l, 0, this.jdField_a_of_type_JavaLangString);
        }
        label102:
        do
        {
          return;
          l = 0L;
          break;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl == null);
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, 0L, paramInt, this.jdField_a_of_type_JavaLangString);
        }
        QLog.e(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 1, "fetchAtlasBiuCount onResult(), exception=" + paramArrayOfByte.toString());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, 0L, paramInt, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.1
 * JD-Core Version:    0.7.0.1
 */