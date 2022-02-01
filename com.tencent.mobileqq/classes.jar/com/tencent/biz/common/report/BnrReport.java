package com.tencent.biz.common.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.bnr.BnrReport.BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfig;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigReq;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp;
import com.tencent.mobileqq.bnr.BnrReport.BNReportGroupInfo;
import com.tencent.mobileqq.bnr.BnrReport.ExtInfo;
import com.tencent.mobileqq.bnr.BnrReport.RetInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BnrReport
{
  protected static long a = 0L;
  protected static boolean b = false;
  protected static ArrayList<Integer> c;
  protected static boolean d = false;
  
  protected static BnrReport.BNRConfigMsg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      try
      {
        paramString = BaseApplication.getContext();
        paramString = paramString.getPackageManager().getPackageInfo(paramString.getPackageName(), 0).versionName;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        paramString = "";
      }
      Object localObject1 = Build.BRAND;
      Object localObject3 = Build.MODEL;
      String str = Build.VERSION.RELEASE;
      Object localObject2 = new StringBuffer("android");
      ((StringBuffer)localObject2).append(" ");
      ((StringBuffer)localObject2).append(Build.VERSION.SDK_INT);
      ((StringBuffer)localObject2).append(" ");
      ((StringBuffer)localObject2).append(str);
      ((StringBuffer)localObject2).append(" ");
      ((StringBuffer)localObject2).append((String)localObject1);
      ((StringBuffer)localObject2).append(" ");
      ((StringBuffer)localObject2).append((String)localObject3);
      localObject1 = new BnrReport.ExtInfo();
      ((BnrReport.ExtInfo)localObject1).app_ver.set(paramString);
      ((BnrReport.ExtInfo)localObject1).sys_ver.set(((StringBuffer)localObject2).toString());
      paramString = new BnrReport.BNReportConfigReq();
      localObject2 = f();
      if (localObject2 != null)
      {
        int j = ((SparseIntArray)localObject2).size();
        int i = 0;
        while (i < j)
        {
          int k = ((SparseIntArray)localObject2).keyAt(i);
          int m = ((SparseIntArray)localObject2).get(k);
          localObject3 = new BnrReport.BNReportGroupInfo();
          ((BnrReport.BNReportGroupInfo)localObject3).id.set(k);
          ((BnrReport.BNReportGroupInfo)localObject3).seqno.set(m);
          paramString.group_info.add((MessageMicro)localObject3);
          i += 1;
        }
      }
      localObject2 = new BnrReport.BNRConfigMsg();
      ((BnrReport.BNRConfigMsg)localObject2).uin.set(l);
      ((BnrReport.BNRConfigMsg)localObject2).cmd.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).seq.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).ext_info.set((MessageMicro)localObject1);
      ((BnrReport.BNRConfigMsg)localObject2).msg_req_body.set(paramString);
      return localObject2;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "BnrReport init");
    }
    d = true;
  }
  
  protected static void a(SparseIntArray paramSparseIntArray)
  {
    if (paramSparseIntArray == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer("");
    int j = paramSparseIntArray.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append("|");
      }
      int k = paramSparseIntArray.keyAt(i);
      localStringBuffer.append(k);
      localStringBuffer.append("-");
      localStringBuffer.append(paramSparseIntArray.get(k));
      i += 1;
    }
    paramSparseIntArray = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    paramSparseIntArray.putString("bnr_group_update_ver", localStringBuffer.toString());
    paramSparseIntArray.commit();
    if (QLog.isDevelopLevel())
    {
      paramSparseIntArray = new StringBuilder();
      paramSparseIntArray.append("server ver:");
      paramSparseIntArray.append(localStringBuffer.toString());
      QLog.d("BnrReport", 4, paramSparseIntArray.toString());
    }
  }
  
  protected static void a(AppInterface paramAppInterface) {}
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    a(paramAppInterface, paramInt, "", 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (a(paramInt1))
    {
      paramString5 = new StringBuilder();
      paramString5.append(paramInt1);
      paramString5.append("");
      ReportController.b(null, "P_CliOper", "AppBernoulliReport", "", paramString5.toString(), paramString1, paramInt2, paramInt3, paramString2, paramString3, paramString3, paramString4);
      QLog.isDevelopLevel();
    }
    if (paramAppInterface != null) {
      a(paramAppInterface);
    }
  }
  
  protected static void a(BnrReport.BNReportConfigRsp paramBNReportConfigRsp)
  {
    if (paramBNReportConfigRsp != null)
    {
      if (((BnrReport.RetInfo)((BnrReport.RetInfo)paramBNReportConfigRsp.ret_info.get()).get()).ret_code.get() != 0L) {
        return;
      }
      List localList = paramBNReportConfigRsp.cfglist.get();
      if (localList == null) {
        return;
      }
      JSONObject localJSONObject = c();
      if (localJSONObject == null) {
        return;
      }
      SparseIntArray localSparseIntArray = f();
      paramBNReportConfigRsp = localSparseIntArray;
      if (localSparseIntArray == null) {
        paramBNReportConfigRsp = new SparseIntArray();
      }
      localSparseIntArray = new SparseIntArray();
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        BnrReport.BNReportConfig localBNReportConfig = (BnrReport.BNReportConfig)((BnrReport.BNReportConfig)localList.get(i)).get();
        int k = localBNReportConfig.id.get();
        int m = localBNReportConfig.seqno.get();
        localSparseIntArray.put(k, m);
        if ((paramBNReportConfigRsp.get(k) <= 0) || (paramBNReportConfigRsp.get(k) != m))
        {
          a(localJSONObject, k, false);
          a(localJSONObject, localBNReportConfig.idList.get(), false);
        }
        i += 1;
      }
      a(localSparseIntArray);
      e();
      b();
    }
  }
  
  protected static void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    if ((paramJSONObject != null) && (paramInt >= 1))
    {
      Object localObject = c;
      if (localObject != null)
      {
        if (((ArrayList)localObject).size() == 0) {
          return;
        }
        try
        {
          int i = paramJSONObject.getInt("id");
          if (b(i) > -1) {
            c.remove(b(i));
          }
          localObject = null;
          try
          {
            paramJSONObject = paramJSONObject.getJSONArray("ls");
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            paramJSONObject = (JSONObject)localObject;
          }
          if (paramJSONObject != null)
          {
            i = 0;
            int j = paramJSONObject.length();
            while (i < j)
            {
              try
              {
                localObject = paramJSONObject.getJSONObject(i);
                if ((((JSONObject)localObject).getInt("id") == paramInt) || (paramBoolean)) {
                  a((JSONObject)localObject, paramInt, true);
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  protected static void a(JSONObject paramJSONObject, List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramJSONObject != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      if (c == null) {
        c = new ArrayList();
      }
      try
      {
        int j = paramJSONObject.getInt("id");
        int k = paramList.indexOf(Integer.valueOf(j));
        int i = 0;
        if ((k <= -1) && (!paramBoolean)) {
          paramBoolean = false;
        } else {
          paramBoolean = true;
        }
        Object localObject = null;
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("ls");
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = localObject;
        }
        if (paramJSONObject != null)
        {
          j = paramJSONObject.length();
          while (i < j)
          {
            try
            {
              a(paramJSONObject.getJSONObject(i), paramList, paramBoolean);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            i += 1;
          }
        }
        if ((paramBoolean) && (!a(j))) {
          c.add(Integer.valueOf(j));
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return true;
  }
  
  protected static int b(int paramInt)
  {
    ArrayList localArrayList = c;
    if (localArrayList == null) {
      return -1;
    }
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      if (((Integer)c.get(i)).intValue() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected static void b()
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    a = System.currentTimeMillis();
    localEditor.putLong("bnr_last_up_time", a);
    localEditor.commit();
  }
  
  protected static JSONObject c()
  {
    try
    {
      InputStream localInputStream = BaseApplication.getContext().getAssets().open("qb_report_config.json");
      Object localObject = Util.a(localInputStream);
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("BnrReport", 2, "error : loadAllConfig");
        }
        return null;
      }
      return null;
    }
    catch (IOException localIOException1) {}
  }
  
  protected static void d()
  {
    Object localObject = BaseApplication.getContext();
    int i = 0;
    localObject = ((BaseApplication)localObject).getSharedPreferences("pref_bnr_report", 0).getString("bnr_open_report_id", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).split("\\|");
    c = new ArrayList();
    int j = localObject.length;
    while (i < j)
    {
      try
      {
        int k = Integer.valueOf(localObject[i]).intValue();
        c.add(Integer.valueOf(k));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      i += 1;
    }
  }
  
  protected static void e()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (c == null) {
      c = new ArrayList();
    }
    int j = c.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(c.get(i));
      i += 1;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    localEditor.putString("bnr_open_report_id", localStringBuffer.toString());
    localEditor.commit();
  }
  
  protected static SparseIntArray f()
  {
    new ArrayList();
    Object localObject1 = c();
    if (localObject1 == null) {
      return null;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray();
    try
    {
      localObject1 = ((JSONObject)localObject1).getJSONArray("ls");
      int j = ((JSONArray)localObject1).length();
      int i = 0;
      while (i < j)
      {
        try
        {
          localSparseIntArray.put(((JSONArray)localObject1).getJSONObject(i).getInt("id"), 0);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        i += 1;
      }
      localObject1 = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).getString("bnr_group_update_ver", "");
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("local ver:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("BnrReport", 4, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          try
          {
            localObject2 = localObject1[i].split("\\-");
            localSparseIntArray.put(Integer.valueOf(localObject2[0]).intValue(), Integer.valueOf(localObject2[1]).intValue());
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
          i += 1;
        }
      }
      return localSparseIntArray;
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.report.BnrReport
 * JD-Core Version:    0.7.0.1
 */