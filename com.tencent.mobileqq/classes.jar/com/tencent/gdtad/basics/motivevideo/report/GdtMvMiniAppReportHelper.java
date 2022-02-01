package com.tencent.gdtad.basics.motivevideo.report;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import org.json.JSONObject;

public class GdtMvMiniAppReportHelper
  implements View.OnTouchListener
{
  private long a;
  public String a;
  private long b;
  public String b;
  
  protected long a(long paramLong)
  {
    return paramLong + NetConnInfoCenter.servetTimeSecondInterv * 1000L;
  }
  
  protected JSONObject a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams miniAppAntiSpamParams is empty");
      return null;
    }
    Object localObject = URLUtil.a(this.jdField_b_of_type_JavaLangString);
    if (localObject != null) {
      localObject = (String)((Map)localObject).get("viewid");
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams viewid is empty");
      return null;
    }
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable2);
      localJSONObject2 = null;
    }
    if (localJSONObject2 == null)
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams antiSpamParams == null");
      return null;
    }
    try
    {
      localJSONObject2.put("viewid", localObject);
      return localJSONObject2;
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable1);
    }
    return localJSONObject2;
  }
  
  public void a(int paramInt, long paramLong)
  {
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    a(paramInt, paramLong, l1 - l2, l2);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("cb", paramInt);
      localJSONObject.put("pi", Math.abs(paramLong2));
      localJSONObject.put("pd", paramLong1);
      localJSONObject.put("cct", a(paramLong3));
      localJSONObject.put("ct", a(System.currentTimeMillis()));
      localJSONObject.put("lt", 3);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", localThrowable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportClickButton ");
    localStringBuilder.append(localJSONObject.toString());
    QLog.i("GdtMvMiniAppReportHelper", 1, localStringBuilder.toString());
    GdtReportForAntiSpam.b(localJSONObject);
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("lt", 2);
      localJSONObject.put("pd", paramLong);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtMvMiniAppReportHelper", 1, "reportVideoStart", localThrowable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportVideoStart ");
    localStringBuilder.append(localJSONObject.toString());
    QLog.i("GdtMvMiniAppReportHelper", 1, localStringBuilder.toString());
    GdtReportForAntiSpam.b(localJSONObject);
  }
  
  public void a(long paramLong, GdtMotiveVideoClickCoordinateReportHelper paramGdtMotiveVideoClickCoordinateReportHelper)
  {
    paramGdtMotiveVideoClickCoordinateReportHelper = paramGdtMotiveVideoClickCoordinateReportHelper.a();
    long l1 = paramGdtMotiveVideoClickCoordinateReportHelper[0];
    long l2 = paramGdtMotiveVideoClickCoordinateReportHelper[1];
    a(5, paramLong, l1 - l2, l2);
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(this);
    }
  }
  
  public void a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null) && (paramGdtMotiveVideoModel.a() != null))
    {
      this.jdField_a_of_type_JavaLangString = paramGdtMotiveVideoModel.a().antiSpamParams;
      this.jdField_b_of_type_JavaLangString = paramGdtMotiveVideoModel.a().getUrlForClick();
      return;
    }
    QLog.i("GdtMvMiniAppReportHelper", 1, "init error");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null)
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "webReportClickButton local param is null");
      return;
    }
    if (paramJSONObject == null)
    {
      QLog.i("GdtMvMiniAppReportHelper", 1, "webReportClickButton web json is null");
      return;
    }
    try
    {
      localJSONObject.put("cb", paramJSONObject.optInt("cb"));
      localJSONObject.put("pi", paramJSONObject.optInt("pi"));
      localJSONObject.put("pd", paramJSONObject.optInt("pd"));
      localJSONObject.put("cct", paramJSONObject.optInt("cct"));
      localJSONObject.put("ct", a(System.currentTimeMillis()));
      localJSONObject.put("lt", 3);
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("GdtMvMiniAppReportHelper", 1, "buildComonSpamParams", paramJSONObject);
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("webReportClickButton ");
    paramJSONObject.append(localJSONObject.toString());
    QLog.i("GdtMvMiniAppReportHelper", 1, paramJSONObject.toString());
    GdtReportForAntiSpam.b(localJSONObject);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1) {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
    }
    else {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper
 * JD-Core Version:    0.7.0.1
 */