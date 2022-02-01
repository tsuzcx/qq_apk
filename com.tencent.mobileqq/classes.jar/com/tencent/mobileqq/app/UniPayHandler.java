package com.tencent.mobileqq.app;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UniPayHandler
  extends BusinessHandler
{
  private ArrayList<UniPayHandler.UniPayUpdateListener> a = new ArrayList();
  
  public UniPayHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((UniPayHandler.UniPayUpdateListener)localIterator.next()).a();
    }
  }
  
  public void a(UniPayHandler.UniPayUpdateListener paramUniPayUpdateListener)
  {
    if (paramUniPayUpdateListener == null) {}
    while (this.a.contains(paramUniPayUpdateListener)) {
      return;
    }
    this.a.add(paramUniPayUpdateListener);
  }
  
  public void a(String paramString)
  {
    paramString = new UniPayRequest(this.appRuntime.getAccount(), "android" + paramString);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "VipSTCheckServer.UinPay");
    localToServiceMsg.extraData.putSerializable("UniPayRequest", paramString);
    super.send(localToServiceMsg);
  }
  
  public void b(UniPayHandler.UniPayUpdateListener paramUniPayUpdateListener)
  {
    if ((paramUniPayUpdateListener != null) && (this.a.contains(paramUniPayUpdateListener))) {
      this.a.remove(paramUniPayUpdateListener);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {}
    do
    {
      do
      {
        return;
        str1 = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(str1));
      if ((str1.compareTo("VipSTCheckServer.UinPay") == 0) && (QLog.isColorLevel())) {
        QLog.i("UniPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str1.compareTo("VipSTCheckServer.UinPay") != 0);
    paramFromServiceMsg = (UniPayResponse)paramObject;
    paramToServiceMsg = paramFromServiceMsg.getSUin();
    int i = paramFromServiceMsg.getIShowOpen();
    int j = paramFromServiceMsg.getIUniPayType();
    new HashMap();
    Object localObject = paramFromServiceMsg.getMapResponse();
    paramFromServiceMsg = (String)((Map)localObject).get("cur_st");
    paramObject = (String)((Map)localObject).get("net_mobile_club");
    String str1 = (String)((Map)localObject).get("open_month");
    String str2 = (String)((Map)localObject).get("platform");
    String str3 = (String)((Map)localObject).get("ret");
    String str4 = (String)((Map)localObject).get("show_open");
    String str5 = (String)((Map)localObject).get("uin");
    localObject = (String)((Map)localObject).get("uin_pay_type");
    if (QLog.isColorLevel()) {
      QLog.d("UniPayHandler", 2, "sUin==" + paramToServiceMsg + ",isShowOpen==" + i + ",iUniPayType==" + j);
    }
    SharedPreferences.Editor localEditor = this.appRuntime.getApp().getSharedPreferences("uniPaySp_" + paramToServiceMsg, 4).edit();
    localEditor.putString("sUin", paramToServiceMsg);
    localEditor.putInt("isShowOpen", i);
    localEditor.putInt("iUinpPayType", j);
    localEditor.putString("cur_st", paramFromServiceMsg);
    localEditor.putString("net_mobile_club", paramObject);
    localEditor.putString("open_month", str1);
    localEditor.putString("platform", str2);
    localEditor.putString("ret", str3);
    localEditor.putString("show_open", str4);
    localEditor.putString("uin", str5);
    localEditor.putString("uin_pay_type", (String)localObject);
    localEditor.commit();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniPayHandler
 * JD-Core Version:    0.7.0.1
 */