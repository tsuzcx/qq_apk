package com.tencent.biz.qqcircle.manager;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._VasRewardResult;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams.Builder;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class QcircleRewardAdManager
{
  private static volatile QcircleRewardAdManager b;
  boolean a = false;
  private long c = 0L;
  
  public static QcircleRewardAdManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QcircleRewardAdManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private String a(int paramInt1, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, Context paramContext, int paramInt2)
  {
    this.a = false;
    if (paramInt1 == QCircleHostConstants._VasRewardResult.SUCCESS())
    {
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        try
        {
          paramArrayOfByte1 = new JSONObject(new String(paramArrayOfByte2));
          paramInt1 = paramArrayOfByte1.optInt("errCode");
          int i = paramArrayOfByte1.optInt("balance");
          paramArrayOfByte2 = paramArrayOfByte1.optString("toastContent");
          if ((paramInt1 == 0) && (i > 0))
          {
            paramArrayOfByte1 = paramArrayOfByte2;
            if (TextUtils.isEmpty(paramArrayOfByte2)) {
              paramArrayOfByte1 = paramContext.getResources().getString(2131895897);
            }
            if (paramInt2 == 1) {
              SimpleEventBus.getInstance().dispatchEvent(new QCirclePopWindowUpdateBalanceEvent(HostDataTransUtils.getAccount(), i));
            } else if (paramInt2 == 2) {
              QCircleConfig.getInstance().saveFuleCount(i);
            }
            this.a = true;
            return paramArrayOfByte1;
          }
          paramArrayOfByte1 = paramArrayOfByte2;
          if (!TextUtils.isEmpty(paramArrayOfByte2)) {
            return paramArrayOfByte1;
          }
          paramArrayOfByte1 = paramContext.getResources().getString(2131895895);
          return paramArrayOfByte1;
        }
        catch (Exception paramArrayOfByte1)
        {
          paramArrayOfByte2 = paramContext.getResources().getString(2131895895);
          QLog.e("QcircleRewardAdManager", 1, paramArrayOfByte1, new Object[0]);
          return paramArrayOfByte2;
        }
      } else if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
        try
        {
          paramArrayOfByte2 = new JSONObject(new String(paramArrayOfByte1)).optString("toastContent");
          paramArrayOfByte1 = paramArrayOfByte2;
          if (!TextUtils.isEmpty(paramArrayOfByte2)) {
            return paramArrayOfByte1;
          }
          paramArrayOfByte1 = paramContext.getResources().getString(2131895895);
          return paramArrayOfByte1;
        }
        catch (Exception paramArrayOfByte1)
        {
          QLog.e("QcircleRewardAdManager", 1, paramArrayOfByte1, new Object[0]);
          return paramContext.getResources().getString(2131895895);
        }
      } else {
        return paramContext.getResources().getString(2131895895);
      }
    }
    else
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2);
      if (!TextUtils.isEmpty(paramArrayOfByte1)) {
        return paramArrayOfByte1;
      }
      if (paramInt1 == QCircleHostConstants._VasRewardResult.BIZ_NO_AD()) {
        return paramContext.getResources().getString(2131895892);
      }
      if (paramInt1 == QCircleHostConstants._VasRewardResult.REQUEST_AD_ERROR()) {
        return paramContext.getResources().getString(2131895896);
      }
      if (paramInt1 == QCircleHostConstants._VasRewardResult.REPORT_AD_ERROR()) {
        return paramContext.getResources().getString(2131895895);
      }
      if (paramInt1 == QCircleHostConstants._VasRewardResult.NON_PROFITABLE())
      {
        if (paramInt2 == 1) {
          return paramContext.getResources().getString(2131895894);
        }
        return paramContext.getResources().getString(2131895893);
      }
      paramArrayOfByte1 = paramContext.getResources().getString(2131895895);
    }
    return paramArrayOfByte1;
  }
  
  private String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
      try
      {
        paramArrayOfByte1 = new JSONObject(new String(paramArrayOfByte2)).optString("toastContent");
        return paramArrayOfByte1;
      }
      catch (Exception paramArrayOfByte1)
      {
        QLog.e("QcircleRewardAdManager", 1, paramArrayOfByte1, new Object[0]);
      }
    } else if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
      try
      {
        paramArrayOfByte1 = new JSONObject(new String(paramArrayOfByte1)).optString("toastContent");
        return paramArrayOfByte1;
      }
      catch (Exception paramArrayOfByte1)
      {
        QLog.e("QcircleRewardAdManager", 1, paramArrayOfByte1, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (paramInt3 == 1) {
      paramInt3 = 7;
    } else if (paramInt1 == 1) {
      paramInt3 = 5;
    } else {
      paramInt3 = 6;
    }
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(70).setSubActionType(2).setThrActionType(paramInt3);
    if (paramBoolean) {
      paramInt3 = i;
    } else {
      paramInt3 = 2;
    }
    localDataBuilder = localDataBuilder.setExt1(String.valueOf(paramInt3));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localDataBuilder = localDataBuilder.setExt2(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    QCircleLpReportDc05504.report(localDataBuilder.setExt6(localStringBuilder.toString()).setExt7(paramString));
  }
  
  private void a(Context paramContext1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Context paramContext2, int paramInt5, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    String str2 = b();
    try
    {
      localJSONObject.put("rewardType", paramInt1);
      localJSONObject.put("numberOfReward", paramInt2);
      localJSONObject.put("traceID", str2);
      String str1 = QCircleApplication.APP.getResources().getString(2131895899);
      if (paramInt1 == 2) {
        str1 = QCircleApplication.APP.getResources().getString(2131895898);
      }
      VasRewardAdParams.Builder localBuilder = new VasRewardAdParams.Builder();
      localBuilder.setAdvPos(Integer.valueOf(paramInt3));
      localBuilder.setRewardType(Integer.valueOf(paramInt4));
      localBuilder.setRewardItem(localJSONObject.toString());
      localBuilder.setRewardText(str1);
      localBuilder.setUin(Long.valueOf(HostDataTransUtils.getAccount()));
      localBuilder.setBizSrcId("biz_src_ads_xsj");
      QCircleHostLauncher.requestAd(paramContext1, localBuilder.build(), new QcircleRewardAdManager.2(this, str2, paramInt1, paramInt2, paramInt5, paramContext2, paramString));
      return;
    }
    catch (JSONException paramContext1)
    {
      QLog.e("QcircleRewardAdManager", 1, paramContext1, new Object[0]);
    }
  }
  
  private static String b()
  {
    String str = HostDataTransUtils.getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(System.currentTimeMillis() % 1000L);
    localStringBuilder.append("_");
    localStringBuilder.append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  private void b(Context paramContext, String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new QcircleRewardAdManager.3(this, paramContext, paramString));
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    HostUIHelper.openHostEnvironment(new QcircleRewardAdManager.1(this, paramInt1, paramInt2, paramInt3, paramInt4, paramContext, paramString));
  }
  
  public void a(Context paramContext, String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      a(paramContext, Integer.parseInt(paramString.getQueryParameter("rewardType")), Integer.parseInt(paramString.getQueryParameter("numberOfReward")), Integer.parseInt(paramString.getQueryParameter("advPosType")), Integer.parseInt(paramString.getQueryParameter("advRewardType")), null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QcircleRewardAdManager", 1, paramString, new Object[] { "launchRewardAd error" });
      b(paramContext, paramContext.getResources().getString(2131895896));
    }
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramContext == null) {}
    try
    {
      QLog.e("QcircleRewardAdManager", 1, "openRewardAd context == null");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QcircleRewardAdManager", 1, paramContext, new Object[0]);
    }
    if (paramJSONObject == null)
    {
      QLog.e("QcircleRewardAdManager", 1, "openRewardAd jsonObject == null");
      return;
    }
    a(paramContext, paramJSONObject.optInt("rewardType", 2), paramJSONObject.optInt("numberOfReward", 5), paramJSONObject.optInt("advPosType", 7), paramJSONObject.optInt("advRewardType", 8), paramContext, 1, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QcircleRewardAdManager
 * JD-Core Version:    0.7.0.1
 */