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
    if (paramUniPayUpdateListener == null) {
      return;
    }
    if (!this.a.contains(paramUniPayUpdateListener)) {
      this.a.add(paramUniPayUpdateListener);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.appRuntime.getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android");
    localStringBuilder.append(paramString);
    paramString = new UniPayRequest((String)localObject, localStringBuilder.toString());
    localObject = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "VipSTCheckServer.UinPay");
    ((ToServiceMsg)localObject).extraData.putSerializable("UniPayRequest", paramString);
    super.send((ToServiceMsg)localObject);
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
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramObject == null) {
        return;
      }
      String str1 = paramToServiceMsg.getServiceCmd();
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      Object localObject1;
      if ((str1.compareTo("VipSTCheckServer.UinPay") == 0) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("req---");
        ((StringBuilder)localObject1).append(paramToServiceMsg);
        ((StringBuilder)localObject1).append(",res----");
        ((StringBuilder)localObject1).append(paramFromServiceMsg);
        ((StringBuilder)localObject1).append(",data-----");
        ((StringBuilder)localObject1).append(paramObject);
        QLog.i("UniPayHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if (str1.compareTo("VipSTCheckServer.UinPay") == 0)
      {
        paramFromServiceMsg = (UniPayResponse)paramObject;
        paramToServiceMsg = paramFromServiceMsg.getSUin();
        int i = paramFromServiceMsg.getIShowOpen();
        int j = paramFromServiceMsg.getIUniPayType();
        new HashMap();
        Object localObject2 = paramFromServiceMsg.getMapResponse();
        paramFromServiceMsg = (String)((Map)localObject2).get("cur_st");
        paramObject = (String)((Map)localObject2).get("net_mobile_club");
        str1 = (String)((Map)localObject2).get("open_month");
        localObject1 = (String)((Map)localObject2).get("platform");
        String str2 = (String)((Map)localObject2).get("ret");
        String str3 = (String)((Map)localObject2).get("show_open");
        String str4 = (String)((Map)localObject2).get("uin");
        localObject2 = (String)((Map)localObject2).get("uin_pay_type");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("sUin==");
          ((StringBuilder)localObject3).append(paramToServiceMsg);
          ((StringBuilder)localObject3).append(",isShowOpen==");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",iUniPayType==");
          ((StringBuilder)localObject3).append(j);
          QLog.d("UniPayHandler", 2, ((StringBuilder)localObject3).toString());
        }
        Object localObject3 = this.appRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uniPaySp_");
        localStringBuilder.append(paramToServiceMsg);
        localObject3 = ((BaseApplication)localObject3).getSharedPreferences(localStringBuilder.toString(), 4).edit();
        ((SharedPreferences.Editor)localObject3).putString("sUin", paramToServiceMsg);
        ((SharedPreferences.Editor)localObject3).putInt("isShowOpen", i);
        ((SharedPreferences.Editor)localObject3).putInt("iUinpPayType", j);
        ((SharedPreferences.Editor)localObject3).putString("cur_st", paramFromServiceMsg);
        ((SharedPreferences.Editor)localObject3).putString("net_mobile_club", paramObject);
        ((SharedPreferences.Editor)localObject3).putString("open_month", str1);
        ((SharedPreferences.Editor)localObject3).putString("platform", (String)localObject1);
        ((SharedPreferences.Editor)localObject3).putString("ret", str2);
        ((SharedPreferences.Editor)localObject3).putString("show_open", str3);
        ((SharedPreferences.Editor)localObject3).putString("uin", str4);
        ((SharedPreferences.Editor)localObject3).putString("uin_pay_type", (String)localObject2);
        ((SharedPreferences.Editor)localObject3).commit();
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniPayHandler
 * JD-Core Version:    0.7.0.1
 */