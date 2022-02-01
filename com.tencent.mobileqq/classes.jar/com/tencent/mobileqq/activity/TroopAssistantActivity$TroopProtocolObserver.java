package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x72d.cmd0x72d.RspBody;

class TroopAssistantActivity$TroopProtocolObserver
  extends ProtoUtils.TroopProtocolObserver
{
  WeakReference<TroopAssistantActivity> a;
  
  TroopAssistantActivity$TroopProtocolObserver(WeakReference<TroopAssistantActivity> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    try
    {
      if (this.a != null)
      {
        paramBundle = (TroopAssistantActivity)this.a.get();
        if (paramBundle == null) {
          return;
        }
        TroopAssistantManager localTroopAssistantManager = TroopAssistantManager.a();
        if ((paramInt == 0) && (paramArrayOfByte != null))
        {
          cmd0x72d.RspBody localRspBody = new cmd0x72d.RspBody();
          localRspBody.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = localRspBody.rpt_uint64_groupcode.get();
          if (localRspBody.opt_uint32_ret_code.get() == 0)
          {
            localTroopAssistantManager.b(paramBundle.app, localRspBody.opt_uint64_timestamp.get());
            if ((paramArrayOfByte.size() > 0) && (paramBundle.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter != null))
            {
              paramBundle.jdField_a_of_type_JavaUtilList = paramArrayOfByte;
              paramBundle.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter.a(paramArrayOfByte);
              return;
            }
            TroopAssistantActivity.a(paramBundle);
            return;
          }
          localTroopAssistantManager.b(paramBundle.app, 0L);
          TroopAssistantActivity.a(paramBundle);
          return;
        }
        localTroopAssistantManager.b(paramBundle.app, 0L);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */