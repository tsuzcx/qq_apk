package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

class OnLinePushMessageProcessor$HandleShMsgType0xe6
{
  private MsgInfo b;
  private long c;
  private long d;
  private int e;
  private int f;
  private String g;
  private byte[] h;
  private boolean i;
  
  public OnLinePushMessageProcessor$HandleShMsgType0xe6(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, long paramLong1, long paramLong2)
  {
    this.b = paramMsgInfo;
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public byte[] d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public HandleShMsgType0xe6 f()
  {
    this.g = new String(EmotionCodecUtils.a(this.b.vMsg), "utf-8");
    Object localObject = (FriendsManager)this.a.q.getManager(QQManagerFactory.FRIENDS_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("");
    localObject = ((FriendsManager)localObject).m(localStringBuilder.toString());
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      this.e = 0;
    }
    else
    {
      localObject = ((IPhoneContactService)this.a.q.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(String.valueOf(this.c));
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        this.e = 1006;
      } else {
        this.e = 1000;
      }
    }
    localObject = new SafeMsg.SafeMoreInfo();
    ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(this.b.strFromMobile);
    ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(this.b.strFromName);
    ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(this.g);
    this.h = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
    this.f = -1002;
    this.i = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgType0xe6
 * JD-Core Version:    0.7.0.1
 */