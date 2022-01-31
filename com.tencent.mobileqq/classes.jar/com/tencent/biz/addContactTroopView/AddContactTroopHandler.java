package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import kkw;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
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
  
  private userinfo.UserInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    userinfo.UserInfo localUserInfo = new userinfo.UserInfo();
    Object localObject;
    if (paramSosoLbsInfo != null)
    {
      localObject = new userinfo.GPS();
      ((userinfo.GPS)localObject).uint32_lat.set(Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue());
      ((userinfo.GPS)localObject).uint32_lon.set(Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
      localUserInfo.gps.set((MessageMicro)localObject);
    }
    try
    {
      if (!TextUtils.isEmpty(this.a.getCurrentAccountUin())) {
        localUserInfo.uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
      }
      paramSosoLbsInfo = new userinfo.AppInfo();
      paramSosoLbsInfo.plat_type.set(2);
      paramSosoLbsInfo.str_app_version.set(DeviceInfoUtil.d());
      localUserInfo.app_info.set(paramSosoLbsInfo);
      localUserInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("7.6.0"));
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
  
  private void b(userinfo.UserInfo paramUserInfo, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB)
  {
    searchtab.ReqBody localReqBody = new searchtab.ReqBody();
    localReqBody.user_info.set(paramUserInfo);
    localReqBody.uint32_label_style.set(2);
    a("SearchAsmTab.GetAsmInfo", localReqBody.toByteArray(), new AddContactTroopHandler.InfoReqObserver(paramIGetPopClassAndSearchCB, this.a, 2));
  }
  
  public void a(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB1, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB2)
  {
    SosoInterface.a(new kkw(this, 0, true, false, 60000L, false, false, "AddContactTroopHandler", paramIGetPopClassAndSearchCB1, paramIGetPopClassAndSearchCB2));
  }
  
  public void b(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB1, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB2)
  {
    try
    {
      userinfo.UserInfo localUserInfo = a(null);
      a(localUserInfo, paramIGetPopClassAndSearchCB1);
      b(localUserInfo, paramIGetPopClassAndSearchCB2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramIGetPopClassAndSearchCB1.b();
      paramIGetPopClassAndSearchCB2.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopHandler
 * JD-Core Version:    0.7.0.1
 */