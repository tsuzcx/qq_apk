package com.tencent.mobileqq.app.soso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.LbsData;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.ReqLbsReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class LbsInfoReportManager
  implements Manager, BusinessObserver
{
  private QQAppInterface a;
  private long b;
  private long c;
  private double d;
  private double e;
  private int f;
  private ArrayList<LbsReportInfo> g;
  private boolean h = false;
  private boolean i = false;
  
  public LbsInfoReportManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.g = new ArrayList();
    b(null);
  }
  
  private String a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("lbs_report_config");
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getLBSNewReport,lbs_report_config:");
      paramString.append(paramContext);
      QLog.d("LBSReport", 2, paramString.toString());
    }
    return paramContext;
  }
  
  private ArrayList<String> a(ArrayList<LbsReportInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (j < paramArrayList.size())
      {
        LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.get(j);
        if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
          localArrayList.add("dc01864");
        }
        j += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a()
  {
    List localList = this.a.getEntityManagerFactory().createEntityManager().query(LbsReportInfo.class);
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.g.addAll(localList);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initLbsReportInfoFromDB info list size is: ");
        localStringBuilder.append(localList.size());
        QLog.i("LBSReport", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list is empty.");
    }
    this.h = true;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("lbs_report_config");
    paramContext.putString(localStringBuilder.toString(), paramString2).commit();
  }
  
  public static void a(SosoLocation paramSosoLocation, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LbsInfoReportManager.reportLbsInfo2DC(), location = ");
      ((StringBuilder)localObject).append(paramSosoLocation);
      ((StringBuilder)localObject).append(", businessTag = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("LBSReport", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSosoLocation.mLat02 != 0.0D)
    {
      if (paramSosoLocation.mLon02 == 0.0D) {
        return;
      }
      int k = BaseApplicationImpl.sProcessId;
      int j = 1;
      if (k != 1) {
        j = 0;
      }
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("is_runtime", 1001);
      ((Intent)localObject).putExtra("lat", paramSosoLocation.mLat02);
      ((Intent)localObject).putExtra("lng", paramSosoLocation.mLon02);
      ((Intent)localObject).putExtra("alt", paramSosoLocation.altitude);
      ((Intent)localObject).putExtra("accuracy", paramSosoLocation.accuracy);
      ((Intent)localObject).putExtra("businessTag", paramString);
      if (!TextUtils.isEmpty(paramSosoLocation.nation)) {
        ((Intent)localObject).putExtra("nation", paramSosoLocation.nation);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.province)) {
        ((Intent)localObject).putExtra("province", paramSosoLocation.province);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.city)) {
        ((Intent)localObject).putExtra("city", paramSosoLocation.city);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.district)) {
        ((Intent)localObject).putExtra("district", paramSosoLocation.district);
      }
      if (j != 0)
      {
        paramSosoLocation = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramSosoLocation != null) {
          ((LbsInfoReportManager)paramSosoLocation.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a((Intent)localObject);
        }
      }
      else
      {
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ProtoServlet.class);
      localNewIntent.putExtra("cmd", "LbsSvc.lbs_report");
      localNewIntent.putExtra("data", paramArrayOfByte);
      localNewIntent.putExtra("DataType", 2);
      localNewIntent.putExtra("retryTime", paramInt + 1);
      localNewIntent.putExtra("copyData", paramArrayOfByte);
      localNewIntent.setObserver(this);
      localQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  private int b()
  {
    try
    {
      if (this.f <= 0) {
        this.f = (new Random().nextInt(1000000) + 100);
      } else if (this.f >= 1000100) {
        this.f = 100;
      } else {
        this.f += 1;
      }
      int j = this.f;
      return j;
    }
    finally {}
  }
  
  private void b(@Nullable JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = a(this.a.getApp(), this.a.getCurrentAccountUin());
        if (TextUtils.isEmpty(paramJSONObject)) {
          return;
        }
        localJSONObject = new JSONObject(paramJSONObject);
        int j = localJSONObject.optInt("is_close_old_report");
        bool = true;
        if (j == 1)
        {
          this.i = bool;
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LBSReport", 2, paramJSONObject, new Object[0]);
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "onReceiveLbsInfo intent is null. return.");
      }
      return;
    }
    double d1 = paramIntent.getDoubleExtra("lat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("lng", 0.0D);
    double d3 = paramIntent.getDoubleExtra("alt", 0.0D);
    float f1 = paramIntent.getFloatExtra("accuracy", 0.0F);
    String str1 = paramIntent.getStringExtra("businessTag");
    String str2 = paramIntent.getStringExtra("nation");
    String str3 = paramIntent.getStringExtra("province");
    String str4 = paramIntent.getStringExtra("city");
    paramIntent = paramIntent.getStringExtra("district");
    if ((d1 != 0.0D) && (d2 != 0.0D))
    {
      double d4 = TencentLocationUtils.distanceBetween(d1, d2, this.d, this.e);
      double d5 = SystemClock.elapsedRealtime() - this.b;
      if ((d4 < 20.0D) && (d5 < 180000.0D))
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("onReceiveLbsInfo distance is: ");
          paramIntent.append(d4);
          paramIntent.append(" collectGap: ");
          paramIntent.append(d5);
          QLog.i("LBSReport", 2, paramIntent.toString());
        }
        return;
      }
      ThreadManager.executeOnSubThread(new LbsInfoReportManager.1(this, d1, d2, d3, f1, str1, str2, str3, str4, paramIntent));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo lat or lng is 0.0d. return.");
    }
  }
  
  public void a(ArrayList<LbsReportInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ProtoServlet StorySvc.lbs_report doNewReportLbsInfo: size = ");
        ((StringBuilder)localObject).append(paramArrayList.size());
        QLog.d("LBSReport", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new qqstory_lbs.ReqLbsReport();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.next();
        qqstory_lbs.LbsData localLbsData = new qqstory_lbs.LbsData();
        localLbsData.alt.set(localLbsReportInfo.alt);
        localLbsData.lng.set(localLbsReportInfo.lng);
        localLbsData.lat.set(localLbsReportInfo.lat);
        localLbsData.accuracy.set(localLbsReportInfo.accuracy);
        if (!TextUtils.isEmpty(localLbsReportInfo.businessTag)) {
          localLbsData.bussinessTag.set(localLbsReportInfo.businessTag);
        }
        if (!TextUtils.isEmpty(localLbsReportInfo.nation)) {
          localLbsData.nation.set(localLbsReportInfo.nation);
        }
        if (!TextUtils.isEmpty(localLbsReportInfo.province)) {
          localLbsData.province.set(localLbsReportInfo.province);
        }
        if (!TextUtils.isEmpty(localLbsReportInfo.city)) {
          localLbsData.city.set(localLbsReportInfo.city);
        }
        if (!TextUtils.isEmpty(localLbsReportInfo.district)) {
          localLbsData.district.set(localLbsReportInfo.district);
        }
        localLbsData.plat_type.set(2);
        localLbsData.oper_time.set((int)localLbsReportInfo.operTime);
        ((qqstory_lbs.ReqLbsReport)localObject).list_data.add(localLbsData);
      }
      a(((qqstory_lbs.ReqLbsReport)localObject).toByteArray(), paramInt);
    }
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt1, int paramInt2)
  {
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()) && (paramArrayList2 != null))
    {
      if (paramArrayList2.isEmpty()) {
        return;
      }
      QQAppInterface localQQAppInterface = this.a;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ReportServlet.class);
      localNewIntent.putExtra("sendType", 10);
      localNewIntent.putExtra("seqKey", paramInt1);
      localNewIntent.putExtra("tags", paramArrayList1);
      localNewIntent.putExtra("contents", paramArrayList2);
      localNewIntent.putExtra("retryTime", paramInt2 + 1);
      localNewIntent.setObserver(this);
      localQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("lbs_report_config");
    if (paramJSONObject != null) {
      a(this.a.getApp(), this.a.getCurrentAccountUin(), paramJSONObject.toString());
    }
    b(paramJSONObject);
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int j = 0;
    Object localObject;
    if (paramInt == 10)
    {
      k = paramBundle.getInt("seqKey");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnReceive: isSuccess-");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", seqKey = ");
        ((StringBuilder)localObject).append(k);
        QLog.d("LBSReport", 2, ((StringBuilder)localObject).toString());
      }
      paramInt = j;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      localObject = this.a;
      if ((!paramBoolean) && (paramInt < 2) && (localObject != null)) {
        a(paramBundle.getStringArrayList("tags"), paramBundle.getStringArrayList("contents"), k, paramInt);
      }
    }
    else if ((paramBundle.containsKey("cmd")) && ("LbsSvc.lbs_report".equals(paramBundle.getString("cmd"))))
    {
      paramInt = k;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ProtoServlet StorySvc.lbs_report OnReceive: isSuccess =");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", retryTime = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("LBSReport", 2, ((StringBuilder)localObject).toString());
      }
      if ((!paramBoolean) && (paramInt < 2)) {
        a(paramBundle.getByteArray("copyData"), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager
 * JD-Core Version:    0.7.0.1
 */