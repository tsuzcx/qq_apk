package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.service.MobileQQServiceExtend;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Collection;

public class GetRichSig
  extends FriendListHandler
  implements CheckUpdateItemInterface
{
  private ToServiceMsg a;
  
  public GetRichSig(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject3 = new ArrayList(2);
    ((ArrayList)localObject3).add(this.app.getAccount());
    Object localObject1 = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ISubAccountService)localObject1).getAllSubUin();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
      ((ArrayList)localObject3).addAll((Collection)localObject1);
    }
    localObject1 = new String[((ArrayList)localObject3).size()];
    ((ArrayList)localObject3).toArray((Object[])localObject1);
    getRichStatus((String[])localObject1);
    localObject1 = localObject2;
    if (this.a != null)
    {
      BaseProtocolCoder localBaseProtocolCoder = this.app.mqqService.lookupCoder(this.a.getServiceCmd());
      localObject1 = localObject2;
      if (localBaseProtocolCoder != null)
      {
        localObject3 = new UniPacket(true);
        ((UniPacket)localObject3).setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localBaseProtocolCoder.encodeReqMsg(this.a, (UniPacket)localObject3))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 119;
          ((ReqItem)localObject1).vecParam = ((UniPacket)localObject3).encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 119) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetRichSig");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.receiveToService(this.a, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.GetRichSig
 * JD-Core Version:    0.7.0.1
 */