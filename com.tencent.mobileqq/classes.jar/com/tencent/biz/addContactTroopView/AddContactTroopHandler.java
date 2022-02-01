package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.troop_search_searchtab.searchtab.ReqBody;
import tencent.im.troop_search_userinfo.userinfo.AppInfo;
import tencent.im.troop_search_userinfo.userinfo.GPS;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public class AddContactTroopHandler
{
  protected QQAppInterface a;
  
  public AddContactTroopHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private userinfo.UserInfo a(SosoLbsInfo paramSosoLbsInfo)
  {
    userinfo.UserInfo localUserInfo = new userinfo.UserInfo();
    if (paramSosoLbsInfo != null)
    {
      localObject = new userinfo.GPS();
      ((userinfo.GPS)localObject).uint32_lat.set(Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue());
      ((userinfo.GPS)localObject).uint32_lon.set(Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue());
      localUserInfo.gps.set((MessageMicro)localObject);
    }
    try
    {
      if (!TextUtils.isEmpty(this.a.getCurrentAccountUin())) {
        localUserInfo.uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
      }
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
    }
    paramSosoLbsInfo = new userinfo.AppInfo();
    paramSosoLbsInfo.plat_type.set(2);
    paramSosoLbsInfo.str_app_version.set(DeviceInfoUtil.c());
    localUserInfo.app_info.set(paramSosoLbsInfo);
    localUserInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    paramSosoLbsInfo = (TicketManager)this.a.getManager(2);
    Object localObject = this.a.getAccount();
    if (!TextUtils.isEmpty(paramSosoLbsInfo.getSkey((String)localObject))) {
      localUserInfo.skey.set(paramSosoLbsInfo.getSkey((String)localObject));
    }
    return localUserInfo;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRequest:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AddContactTroopHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(this.a.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("cmd", paramString);
    ((NewIntent)localObject).putExtra("data", paramArrayOfByte);
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    this.a.startServlet((NewIntent)localObject);
  }
  
  private void a(userinfo.UserInfo paramUserInfo, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB)
  {
    searchtab.ReqBody localReqBody = new searchtab.ReqBody();
    localReqBody.user_info.set(paramUserInfo);
    localReqBody.uint32_label_style.set(1);
    a("SearchAsmTab.GetPopClassific", localReqBody.toByteArray(), new AddContactTroopHandler.InfoReqObserver(paramIGetPopClassAndSearchCB, this.a, 1));
  }
  
  public void a(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB)
  {
    try
    {
      a(a(null), paramIGetPopClassAndSearchCB);
      IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.a.getRuntimeService(IRecommendTroopService.class, "");
      if (localIRecommendTroopService != null)
      {
        localIRecommendTroopService.getNotificationRecommendTroopFromServer(this.a.getLongAccountUin(), null, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramIGetPopClassAndSearchCB.b();
    }
  }
  
  public void a(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startGetPopClassAndRecommendTroopsWithLBSInfo info = ");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.w("AddContactTroopHandler", 2, localStringBuilder.toString());
    }
    double d1;
    int k;
    double d2;
    int i;
    if (paramSosoLbsInfo != null)
    {
      a(a(paramSosoLbsInfo), paramIGetPopClassAndSearchCB);
      d1 = paramSosoLbsInfo.mLocation.altitude;
      k = (int)paramSosoLbsInfo.mLocation.accuracy;
      d2 = paramSosoLbsInfo.mLocation.locationTime;
      paramIGetPopClassAndSearchCB = paramSosoLbsInfo.mLocation.cityCode;
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(paramIGetPopClassAndSearchCB);
      i = j;
    }
    catch (Exception paramIGetPopClassAndSearchCB)
    {
      label108:
      double d3;
      double d4;
      break label108;
    }
    QLog.e("AddContactTroopHandler", 1, "parse cityCode error");
    d3 = Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
    d4 = Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
    paramIGetPopClassAndSearchCB = new oidb_0x935.GPS();
    paramIGetPopClassAndSearchCB.uint32_latitude.set((int)d3);
    paramIGetPopClassAndSearchCB.uint32_longitude.set((int)d4);
    paramIGetPopClassAndSearchCB.uint32_altitude.set((int)d1);
    paramIGetPopClassAndSearchCB.uint32_accuracy.set(k);
    paramIGetPopClassAndSearchCB.uint32_time.set((int)d2);
    paramIGetPopClassAndSearchCB.uint32_cityid.set(i);
    paramIGetPopClassAndSearchCB.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    paramIGetPopClassAndSearchCB.uint32_client.set(2);
    paramSosoLbsInfo = (IRecommendTroopService)this.a.getRuntimeService(IRecommendTroopService.class, "");
    if (paramSosoLbsInfo != null) {
      paramSosoLbsInfo.getNotificationRecommendTroopFromServer(this.a.getLongAccountUin(), paramIGetPopClassAndSearchCB, 4);
    }
  }
  
  public void b(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB)
  {
    try
    {
      a(a(null), paramIGetPopClassAndSearchCB);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramIGetPopClassAndSearchCB.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopHandler
 * JD-Core Version:    0.7.0.1
 */