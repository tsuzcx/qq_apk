package com.tencent.mobileqq.app;

import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.FromChannel;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;

public class VIPAioSendHandler
  extends BusinessHandler
{
  public static int a = 1;
  public static String b = "AIOSendSvc.CheckPopGrayStips";
  public static String c = "AIOSendSvc.getUserKeyWordStips";
  private QQAppInterface d;
  
  protected VIPAioSendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = paramQQAppInterface;
  }
  
  public void a(AIOSendReq paramAIOSendReq)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), b);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramAIOSendReq);
    super.send(localToServiceMsg);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    paramInt = ((IVasGrayTips)QRoute.api(IVasGrayTips.class)).transformFrom(paramInt);
    UniGrayTip.FromChannel localFromChannel = new UniGrayTip.FromChannel();
    localFromChannel.channel.set(paramInt);
    Object localObject = localFromChannel.fromUin;
    if (paramString1 == null) {
      paramString1 = "";
    }
    ((PBStringField)localObject).set(paramString1);
    localObject = new HashMap();
    ((Map)localObject).put("matchKey", paramString2);
    if (paramBoolean) {
      paramString1 = String.valueOf(1);
    } else {
      paramString1 = String.valueOf(0);
    }
    ((Map)localObject).put("msgType", paramString1);
    ((IVasGrayTips)QRoute.api(IVasGrayTips.class)).requestUnitGrayTips(1, localFromChannel, (Map)localObject, null);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VIPAioSendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
      if (b.equals(paramToServiceMsg))
      {
        paramToServiceMsg = (AIOSendRes)paramObject;
        AioVipDonateHelper.a().a(this.d, paramToServiceMsg);
      }
      notifyUI(a, true, paramObject);
      return;
    }
    notifyUI(a, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VIPAioSendHandler
 * JD-Core Version:    0.7.0.1
 */