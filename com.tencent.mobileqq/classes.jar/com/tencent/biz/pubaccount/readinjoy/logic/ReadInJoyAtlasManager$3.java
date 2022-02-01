package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

class ReadInJoyAtlasManager$3
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 2, "fetchAtlas0xbe0 onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_cmd0x83e.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        boolean bool;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null)
        {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl;
          String str = this.jdField_a_of_type_JavaLangString;
          if (paramBundle.uint32_is_like.get() != 1) {
            break label98;
          }
          bool = true;
          paramArrayOfByte.a(true, str, bool, 0);
        }
        label98:
        do
        {
          return;
          bool = false;
          break;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl == null);
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, this.jdField_a_of_type_JavaLangString, false, 0);
        }
        QLog.e(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 1, "fetchAtlas0xbe0 onResult(), exception=" + paramArrayOfByte.toString());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, this.jdField_a_of_type_JavaLangString, false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.3
 * JD-Core Version:    0.7.0.1
 */