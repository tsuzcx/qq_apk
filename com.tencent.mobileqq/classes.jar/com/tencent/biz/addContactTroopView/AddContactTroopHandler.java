package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
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
    Object localObject;
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
      paramSosoLbsInfo = new userinfo.AppInfo();
      paramSosoLbsInfo.plat_type.set(2);
      paramSosoLbsInfo.str_app_version.set(DeviceInfoUtil.c());
      localUserInfo.app_info.set(paramSosoLbsInfo);
      localUserInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
      paramSosoLbsInfo = (TicketManager)this.a.getManager(2);
      localObject = this.a.getAccount();
      if (!TextUtils.isEmpty(paramSosoLbsInfo.getSkey((String)localObject))) {
        localUserInfo.skey.set(paramSosoLbsInfo.getSkey((String)localObject));
      }
      return localUserInfo;
    }
    catch (Exception paramSosoLbsInfo)
    {
      for (;;)
      {
        paramSosoLbsInfo.printStackTrace();
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactTroopHandler", 2, "sendRequest:" + paramString);
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), ProtoServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.setObserver(paramBusinessObserver);
    this.a.startServlet(localNewIntent);
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
      ((RecommendTroopManagerImp)this.a.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER)).a(this.a.getLongAccountUin(), null, 4);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramIGetPopClassAndSearchCB.b();
    }
  }
  
  public void a(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.w("AddContactTroopHandler", 2, "startGetPopClassAndRecommendTroopsWithLBSInfo info = " + paramSosoLbsInfo);
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
      for (;;)
      {
        double d3;
        double d4;
        QLog.e("AddContactTroopHandler", 1, "parse cityCode error");
      }
    }
    d3 = Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
    d4 = Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
    paramIGetPopClassAndSearchCB = new oidb_0x935.GPS();
    paramIGetPopClassAndSearchCB.uint32_latitude.set((int)d3);
    paramIGetPopClassAndSearchCB.uint32_longitude.set((int)d4);
    paramIGetPopClassAndSearchCB.uint32_altitude.set((int)d1);
    paramIGetPopClassAndSearchCB.uint32_accuracy.set(k);
    paramIGetPopClassAndSearchCB.uint32_time.set((int)d2);
    paramIGetPopClassAndSearchCB.uint32_cityid.set(i);
    paramIGetPopClassAndSearchCB.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
    paramIGetPopClassAndSearchCB.uint32_client.set(2);
    ((RecommendTroopManagerImp)this.a.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER)).a(this.a.getLongAccountUin(), paramIGetPopClassAndSearchCB, 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopHandler
 * JD-Core Version:    0.7.0.1
 */