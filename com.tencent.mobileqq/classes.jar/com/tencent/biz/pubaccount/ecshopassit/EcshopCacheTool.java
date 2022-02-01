package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;

public class EcshopCacheTool
{
  public static final String i;
  EntityManager a;
  Map<String, Friends> b;
  Map<String, Bitmap> c;
  public Map<String, Integer> d;
  public Map<String, String> e;
  public EcshopReportHandler f;
  public boolean g;
  ShopWebViewFragment h;
  Runnable j = new EcshopCacheTool.1(this);
  BusinessObserver k = new EcshopCacheTool.2(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shop_assit_banner_json.txt");
    i = localStringBuilder.toString();
  }
  
  public EcshopCacheTool(AppInterface paramAppInterface, ShopWebViewFragment paramShopWebViewFragment)
  {
    this.h = paramShopWebViewFragment;
    this.d = new ConcurrentHashMap();
    this.e = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    this.a = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.f = ((EcshopReportHandler)paramAppInterface.getBusinessHandler(BrowserAppInterface.m));
    ThreadManager.post(this.j, 5, null, true);
  }
  
  public void a()
  {
    this.h = null;
    this.f = null;
    Map localMap = this.b;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.c;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.d;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.e;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("action_get_PA_head");
    localIntent.putExtra("uin", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.c)
    {
      this.c.put(paramString, paramBitmap);
      return;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.msglistlen.set(paramInt);
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), WebSSOAgentServlet.class);
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetFolderInfo");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.k);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime, List<Long> paramList, double paramDouble1, double paramDouble2)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), WebSSOAgentServlet.class);
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.addAll(paramList);
    if ((!TextUtils.isEmpty(paramAppRuntime.getAccount())) && (paramDouble1 != 0.0D) && (paramDouble2 != 0.0D))
    {
      localSQQSHPClientReq.latitude.set(paramDouble2);
      localSQQSHPClientReq.longitude.set(paramDouble1);
      paramList = new StringBuilder();
      paramList.append("lat:");
      paramList.append(paramDouble2);
      paramList.append(",lon:");
      paramList.append(paramDouble1);
      QLog.i("EcshopCacheTool", 2, paramList.toString());
    }
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetShopBindUin");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.k);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Map localMap = this.b;
      if (localMap == null) {
        return false;
      }
      return (Friends)localMap.get(paramString) != null;
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Map localMap = this.b;
      if (localMap == null) {
        return "";
      }
      paramString = (Friends)localMap.get(paramString);
      if (paramString != null) {
        return paramString.getFriendNick();
      }
    }
    return "";
  }
  
  public void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  public Bitmap c(String paramString)
  {
    synchronized (this.c)
    {
      paramString = (Bitmap)this.c.get(paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool
 * JD-Core Version:    0.7.0.1
 */