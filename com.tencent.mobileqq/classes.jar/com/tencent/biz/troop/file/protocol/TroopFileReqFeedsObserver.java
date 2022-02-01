package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.im.cs.group_file_common.group_file_common.FeedsResult;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;

public abstract class TroopFileReqFeedsObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, "", 102, 0, paramBundle);
      return;
    }
    Object localObject = new oidb_0x6d9.RspBody();
    try
    {
      ((oidb_0x6d9.RspBody)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label36:
      boolean bool;
      int i;
      int j;
      break label36;
    }
    a(false, paramInt, "", 102, 0, paramBundle);
    if (!((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.has())
    {
      a(false, paramInt, "", 102, 0, paramBundle);
      return;
    }
    localObject = (oidb_0x6d9.FeedsRspBody)((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.get();
    bool = ((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.has();
    i = 102;
    if (!bool)
    {
      a(false, paramInt, "", 102, 0, paramBundle);
      return;
    }
    j = ((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.get();
    paramArrayOfByte = ((oidb_0x6d9.FeedsRspBody)localObject).str_client_wording.get();
    if (((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.has())
    {
      localObject = (group_file_common.FeedsResult)((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.get().get(0);
      if (localObject != null)
      {
        paramInt = i;
        if (((group_file_common.FeedsResult)localObject).uint32_bus_id.has()) {
          paramInt = ((group_file_common.FeedsResult)localObject).uint32_bus_id.get();
        }
        if (((group_file_common.FeedsResult)localObject).uint32_dead_time.has())
        {
          i = ((group_file_common.FeedsResult)localObject).uint32_dead_time.get();
          break label227;
        }
        break label224;
      }
    }
    paramInt = 102;
    label224:
    i = 0;
    label227:
    a(true, j, paramArrayOfByte, paramInt, i, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver
 * JD-Core Version:    0.7.0.1
 */