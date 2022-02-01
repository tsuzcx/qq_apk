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
  private long a;
  private int b;
  private int c;
  private long d;
  private int e;
  private int f;
  private GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener g;
  private List<WeakReference<View>> h = new ArrayList();
  private boolean i = false;
  private boolean j = false;
  
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
    long l1 = this.d;
    long l2 = this.a;
    long l3 = System.currentTimeMillis();
    long l4 = this.d;
    long l5 = System.currentTimeMillis();
    long l6 = this.a;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("g", String.valueOf(l1 - l2));
      localJSONObject.put("sc", String.valueOf(l3 - l4));
      localJSONObject.put("ec", String.valueOf(l5 - l6));
      localJSONObject.put("aa", String.valueOf(this.b - paramAdBoxReportParams.c));
      localJSONObject.put("ab", String.valueOf(this.c - paramAdBoxReportParams.d));
      localJSONObject.put("ba", String.valueOf(this.e - paramAdBoxReportParams.c));
      localJSONObject.put("bb", String.valueOf(this.f - paramAdBoxReportParams.d));
      localJSONObject.put("d", "0");
      localJSONObject.put("p", "0");
      localJSONObject.put("f", "0");
      localJSONObject.put("x", "1");
      localJSONObject.put("db", String.valueOf(paramAdBoxReportParams.b));
      localJSONObject.put("da", String.valueOf(paramAdBoxReportParams.a));
      localJSONObject.put("px", String.valueOf(paramAdBoxReportParams.c));
      localJSONObject.put("py", String.valueOf(paramAdBoxReportParams.d));
    }
    catch (Exception paramAdBoxReportParams)
    {
      GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", paramAdBoxReportParams);
    }
    return a(1, paramString, localJSONObject.toString());
  }
  
  public void a(View paramView)
  {
    this.h.add(new WeakReference(paramView));
    paramView.setOnTouchListener(this);
  }
  
  public void a(GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener paramOnMoveCompleteListener)
  {
    this.g = paramOnMoveCompleteListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public long[] a()
  {
    return new long[] { this.d, this.a };
  }
  
  public String b(String paramString, GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams paramAdBoxReportParams)
  {
    if (paramAdBoxReportParams == null)
    {
      QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToExposureUr params == null");
      return paramString;
    }
    return a(2, paramString, paramAdBoxReportParams.a, paramAdBoxReportParams.b, paramAdBoxReportParams.c, paramAdBoxReportParams.d);
  }
  
  public void b()
  {
    this.g = null;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((WeakReference)localIterator.next()).get();
      if (localView != null) {
        localView.setOnTouchListener(null);
      }
    }
    this.i = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k == 1)
      {
        this.d = System.currentTimeMillis();
        this.e = ((int)paramMotionEvent.getRawX());
        this.f = ((int)paramMotionEvent.getRawY());
        paramView = this.g;
        if (paramView != null) {
          paramView.a(this.a, this.d, this.b, this.c, this.e, this.f);
        }
      }
    }
    else
    {
      this.a = System.currentTimeMillis();
      this.b = ((int)paramMotionEvent.getRawX());
      this.c = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper
 * JD-Core Version:    0.7.0.1
 */