package com.tencent.gdtad.basics.motivevideo.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
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
  private GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener;
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
    }
    catch (Exception localException)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToExposureUrl error", localException);
    }
    return a(paramInt1, paramString, localJSONObject.toString());
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl TextUtils.isEmpty(url)");
      return paramString1;
    }
    Object localObject = URLUtil.a(paramString1);
    if ((localObject != null) && (((Map)localObject).containsKey("s")))
    {
      paramString2 = new StringBuilder();
      paramString2.append("addAntiSpamToUrl hasKey  type = ");
      paramString2.append(paramInt);
      paramString2.append(", url=");
      paramString2.append(paramString1);
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, paramString2.toString());
      return paramString1;
    }
    paramString1 = URLUtil.a(paramString1, "s", paramString2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addAntiSpamToUrl type = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",result url=");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report param: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 2, ((StringBuilder)localObject).toString());
    }
    return paramString1;
  }
  
  public String a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    return a(4, paramString, DisplayUtil.b(localBaseApplication, ScreenUtil.getInstantScreenWidth(localBaseApplication)), DisplayUtil.b(localBaseApplication, ScreenUtil.getInstantScreenHeight(localBaseApplication)), 0, 0);
  }
  
  public String a(String paramString1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    }
    catch (Exception paramAdBoxReportParams)
    {
      GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", paramAdBoxReportParams);
    }
    return a(1, paramString, localJSONObject.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener = null;
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
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener = paramOnMoveCompleteListener;
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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.c = ((int)paramMotionEvent.getRawX());
        this.d = ((int)paramMotionEvent.getRawY());
        paramView = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper$OnMoveCompleteListener;
        if (paramView != null) {
          paramView.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper
 * JD-Core Version:    0.7.0.1
 */