package com.tencent.gdtad.api.motivevideo;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GdtMotiveVideoClickCoordinateReportHelper
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener;
  private List<WeakReference<View>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d;
  
  private String a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("da", String.valueOf(paramInt2));
      localJSONObject.put("db", String.valueOf(paramInt3));
      localJSONObject.put("px", String.valueOf(paramInt4));
      localJSONObject.put("py", String.valueOf(paramInt5));
      localJSONObject.put("x", String.valueOf(1));
      return a(paramInt1, paramString, localJSONObject.toString());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToExposureUrl error", localException);
      }
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl TextUtils.isEmpty(url)");
    }
    Object localObject;
    do
    {
      return paramString1;
      localObject = URLUtil.a(paramString1);
      if ((localObject != null) && (((Map)localObject).containsKey("s")))
      {
        QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl hasKey  type = " + paramInt + ", url=" + paramString1);
        return paramString1;
      }
      localObject = URLUtil.a(paramString1, "s", paramString2);
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl type = " + paramInt + ",result url=" + (String)localObject);
      paramString1 = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 2, "report param: " + paramString2);
    return localObject;
  }
  
  public String a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return a(4, paramString, DisplayUtil.b(localBaseApplication, ScreenUtil.getInstantScreenWidth(localBaseApplication)), DisplayUtil.b(localBaseApplication, ScreenUtil.getInstantScreenHeight(localBaseApplication)), 0, 0);
  }
  
  String a(String paramString1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    long l1 = Math.abs(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_b_of_type_Long;
    long l4 = System.currentTimeMillis();
    long l5 = this.jdField_a_of_type_Long;
    int i;
    BaseApplication localBaseApplication;
    Object localObject;
    if (paramBoolean1)
    {
      i = 1;
      localBaseApplication = BaseApplicationImpl.getContext();
      localObject = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        localObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          continue;
        }
        k = ScreenUtil.getInstantScreenWidth(localBaseApplication);
        j = ScreenUtil.getInstantScreenHeight(localBaseApplication) + ScreenUtil.getNavigationBarHeight(localBaseApplication);
        k = DisplayUtil.b(localBaseApplication, k);
        j = DisplayUtil.b(localBaseApplication, j);
        ((JSONObject)localObject).put("da", String.valueOf(k));
        ((JSONObject)localObject).put("db", String.valueOf(j));
        ((JSONObject)localObject).put("px", String.valueOf(0));
        ((JSONObject)localObject).put("py", String.valueOf(0));
        ((JSONObject)localObject).put("x", String.valueOf(i));
        ((JSONObject)localObject).put("p", String.valueOf(paramLong));
        ((JSONObject)localObject).put("aa", String.valueOf(DisplayUtil.b(localBaseApplication, this.jdField_a_of_type_Int)));
        ((JSONObject)localObject).put("ab", String.valueOf(DisplayUtil.b(localBaseApplication, this.jdField_b_of_type_Int)));
        ((JSONObject)localObject).put("ba", String.valueOf(DisplayUtil.b(localBaseApplication, this.c)));
        ((JSONObject)localObject).put("bb", String.valueOf(DisplayUtil.b(localBaseApplication, this.d)));
        ((JSONObject)localObject).put("g", String.valueOf(l1));
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        paramString2 = "1";
        ((JSONObject)localObject).put("f", paramString2);
        ((JSONObject)localObject).put("sc", String.valueOf(l2 - l3));
        ((JSONObject)localObject).put("ec", String.valueOf(l4 - l5));
        ((JSONObject)localObject).put("d", String.valueOf(0));
        ((JSONObject)localObject).put("sz", String.valueOf(-999));
        if (!paramBoolean2) {
          continue;
        }
        i = 2;
        ((JSONObject)localObject).put("vca", String.valueOf(i));
      }
      catch (Exception paramString2)
      {
        int k;
        int j;
        GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", paramString2);
        continue;
      }
      localObject = ((JSONObject)localObject).toString();
      GdtLog.b("GdtMotiveVideoClickCoordinateReportHelper", "cgi upload param:" + (String)localObject);
      return a(3, paramString1, (String)localObject);
      i = 0;
      break;
      j = ScreenUtil.getInstantScreenWidth(localBaseApplication);
      k = ScreenUtil.getNavigationBarHeight(localBaseApplication) + j;
      j = ScreenUtil.getInstantScreenHeight(localBaseApplication);
      continue;
      paramString2 = "0";
      continue;
      i = 1;
    }
  }
  
  public String a(String paramString, GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams paramAdBoxReportParams)
  {
    if (paramAdBoxReportParams == null)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToClickUrl params == null");
      return paramString;
    }
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_b_of_type_Long;
    long l5 = System.currentTimeMillis();
    long l6 = this.jdField_a_of_type_Long;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("g", String.valueOf(l1 - l2));
      localJSONObject.put("sc", String.valueOf(l3 - l4));
      localJSONObject.put("ec", String.valueOf(l5 - l6));
      localJSONObject.put("aa", String.valueOf(this.jdField_a_of_type_Int - paramAdBoxReportParams.c));
      localJSONObject.put("ab", String.valueOf(this.jdField_b_of_type_Int - paramAdBoxReportParams.d));
      localJSONObject.put("ba", String.valueOf(this.c - paramAdBoxReportParams.c));
      localJSONObject.put("bb", String.valueOf(this.d - paramAdBoxReportParams.d));
      localJSONObject.put("d", "0");
      localJSONObject.put("p", "0");
      localJSONObject.put("f", "0");
      localJSONObject.put("x", "1");
      localJSONObject.put("db", String.valueOf(paramAdBoxReportParams.jdField_b_of_type_Int));
      localJSONObject.put("da", String.valueOf(paramAdBoxReportParams.jdField_a_of_type_Int));
      localJSONObject.put("px", String.valueOf(paramAdBoxReportParams.c));
      localJSONObject.put("py", String.valueOf(paramAdBoxReportParams.d));
      return a(1, paramString, localJSONObject.toString());
    }
    catch (Exception paramAdBoxReportParams)
    {
      for (;;)
      {
        GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", paramAdBoxReportParams);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((WeakReference)localIterator.next()).get();
      if (localView != null) {
        localView.setOnTouchListener(null);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramView));
    paramView.setOnTouchListener(this);
  }
  
  public void a(GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener paramOnMoveCompleteListener)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener = paramOnMoveCompleteListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public long[] a()
  {
    return new long[] { this.jdField_b_of_type_Long, this.jdField_a_of_type_Long };
  }
  
  public String b(String paramString, GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams paramAdBoxReportParams)
  {
    if (paramAdBoxReportParams == null)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToExposureUr params == null");
      return paramString;
    }
    return a(2, paramString, paramAdBoxReportParams.jdField_a_of_type_Int, paramAdBoxReportParams.jdField_b_of_type_Int, paramAdBoxReportParams.c, paramAdBoxReportParams.d);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.c = ((int)paramMotionEvent.getRawX());
      this.d = ((int)paramMotionEvent.getRawY());
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener != null) {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper
 * JD-Core Version:    0.7.0.1
 */