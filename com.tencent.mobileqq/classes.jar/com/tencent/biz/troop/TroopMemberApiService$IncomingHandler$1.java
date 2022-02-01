package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import tencent.im.group.nearbybanner.nearbybanner.Banners;
import tencent.im.group.nearbybanner.nearbybanner.RspBody;

class TroopMemberApiService$IncomingHandler$1
  implements BusinessObserver
{
  TroopMemberApiService$IncomingHandler$1(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.remove("data");
    if (!paramBoolean)
    {
      this.b.a.a(16, this.a);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    nearbybanner.RspBody localRspBody = new nearbybanner.RspBody();
    try
    {
      localRspBody.mergeFrom(paramBundle);
      if ((localRspBody.uint32_result.get() != 0) && (!localRspBody.msg_banners.has()))
      {
        this.b.a.a(16, this.a);
        return;
      }
      paramBundle = (nearbybanner.Banners)localRspBody.msg_banners.get();
      if (!paramBundle.rpt_banner_info.has())
      {
        this.b.a.a(16, this.a);
        return;
      }
      this.a.putByteArray("data", paramBundle.toByteArray());
      this.b.a.a(16, this.a);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      break label178;
    }
    catch (Exception paramBundle)
    {
      label161:
      label178:
      break label161;
    }
    this.b.a.a(16, this.a);
    return;
    this.b.a.a(16, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */