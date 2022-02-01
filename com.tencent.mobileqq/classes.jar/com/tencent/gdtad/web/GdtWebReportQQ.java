package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Map;

public class GdtWebReportQQ
  implements GdtWebReportInterface
{
  private int a = 0;
  private int b = 0;
  private long c;
  private long d;
  private boolean e;
  private boolean f;
  private GdtWebReportPlugin g;
  
  public GdtWebReportQQ(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    this.g = paramGdtWebReportPlugin;
  }
  
  private void a(int paramInt1, Boolean paramBoolean, int paramInt2)
  {
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report eventId is ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("costTime is");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("isCgiClick is");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GdtWebReportQQ", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((GdtWebReportPlugin)localObject).b();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext((Context)localObject, new InitGdtContextParams());
      link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
      localReportBiz.cost_time = paramInt2;
      localReportBiz.wv_progress = 2;
      if (paramBoolean.booleanValue()) {
        localReportBiz.click_req_type = 1;
      } else {
        localReportBiz.click_req_type = 3;
      }
      if (this.e) {
        localReportBiz.lp_type = 1;
      } else {
        localReportBiz.lp_type = 4;
      }
      localReportBiz.aid = b("GdtWebReportQQ_AD_ID");
      localReportBiz.pid = b("GdtWebReportQQ_POS_ID");
      localReportBiz.traceid = b("GdtWebReportQQ_TRACE_ID");
      AdReporterForLinkEvent.reportAsync((Context)localObject, paramInt1, null, localReportBiz, null);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Object localObject = new URL(paramString).getHost();
      if (QLog.isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("current url is ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("host is ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("state is ");
        QLog.d("GdtWebReportQQ", 2, localStringBuilder.toString());
      }
      paramString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = ((String)localObject).equals(paramString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check url is fail, error is ");
      ((StringBuilder)localObject).append(paramString);
      Log.e("GdtWebReportQQ", ((StringBuilder)localObject).toString());
    }
  }
  
  private String b(String paramString)
  {
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((GdtWebReportPlugin)localObject).b();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      localObject = ((Activity)localObject).getIntent().getStringExtra(paramString);
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", s = ");
    localStringBuilder.append((String)localObject);
    Log.i("GdtWebReportQQ", localStringBuilder.toString());
    return localObject;
  }
  
  public void a()
  {
    GdtLog.a("GdtWebReportQQ", " init");
    Object localObject = this.g;
    if ((localObject != null) && (((GdtWebReportPlugin)localObject).b() != null))
    {
      GdtLog.a("GdtWebReportQQ", " init success");
      localObject = this.g.b().getIntent();
      long l;
      if (localObject != null) {
        l = ((Intent)localObject).getLongExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
      } else {
        l = System.currentTimeMillis();
      }
      this.c = l;
      boolean bool = true;
      if (localObject != null) {
        bool = ((Intent)localObject).getBooleanExtra("GdtWebReportQQ_IS_H5", true);
      }
      this.e = bool;
    }
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (TextUtils.isEmpty(b("GdtWebReportQQ_TRACE_ID")))
    {
      Log.i("GdtWebReportQQ", "error, traceID is empty");
      return false;
    }
    int i = this.a;
    if (i != 0)
    {
      boolean bool;
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i == 3) && ((paramLong == 8589934601L) || (paramLong == 8589934598L)))
          {
            this.a = 4;
            if (this.b != 0) {
              bool = true;
            } else {
              bool = false;
            }
            a(4003023, Boolean.valueOf(bool), (int)(System.currentTimeMillis() - this.c));
          }
        }
        else
        {
          long l;
          if (paramLong == 8589934597L)
          {
            l = SystemClock.elapsedRealtime() - this.c;
            if (l > 0L) {
              l = this.d + l;
            } else {
              l = this.d;
            }
            this.d = l;
          }
          if (paramLong == 2L) {
            this.c = SystemClock.elapsedRealtime();
          }
          if ((paramLong == 8589934601L) || (paramLong == 8589934598L) || (paramLong == 8589934596L))
          {
            l = SystemClock.elapsedRealtime() - this.c;
            if (l > 0L) {
              l = this.d + l;
            } else {
              l = this.d;
            }
            this.d = l;
            if (this.b != 0) {
              bool = true;
            } else {
              bool = false;
            }
            a(4003026, Boolean.valueOf(bool), (int)this.d);
            this.a = 4;
          }
        }
      }
      else if (paramLong == 8589934594L)
      {
        this.a = 2;
        if (this.b != 0) {
          bool = true;
        } else {
          bool = false;
        }
        a(4003010, Boolean.valueOf(bool), (int)(System.currentTimeMillis() - this.c));
        this.c = SystemClock.elapsedRealtime();
      }
      else if ((paramLong != 8589934595L) && (paramLong != 8589934612L))
      {
        if (paramLong == 8589934601L)
        {
          this.a = 4;
          if (this.b != 0) {
            bool = true;
          } else {
            bool = false;
          }
          a(4003023, Boolean.valueOf(bool), (int)(System.currentTimeMillis() - this.c));
        }
      }
      else
      {
        this.a = 3;
        if (a(paramString)) {
          i = 4000002;
        } else {
          i = 4003009;
        }
        if (this.b != 0) {
          bool = true;
        } else {
          bool = false;
        }
        a(i, Boolean.valueOf(bool), (int)(System.currentTimeMillis() - this.c));
      }
    }
    else if (paramLong == 8589934593L)
    {
      if ((a(paramString)) && (this.b == 0))
      {
        this.b = 1;
        a(4000001, Boolean.valueOf(true), (int)(System.currentTimeMillis() - this.c));
      }
      this.a = 1;
    }
    if (this.b == 1)
    {
      if ((paramLong == 8589934626L) && (this.a == 1) && (!a(paramString)) && (!this.f))
      {
        this.f = true;
        a(4000003, Boolean.valueOf(true), (int)(System.currentTimeMillis() - this.c));
      }
      if ((paramLong == 8589934593L) && (this.a == 1) && (!a(paramString)))
      {
        a(4003008, Boolean.valueOf(true), (int)(System.currentTimeMillis() - this.c));
        this.b = 2;
      }
    }
    return false;
  }
  
  public void b() {}
  
  public void b(CustomWebView paramCustomWebView)
  {
    a();
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportQQ
 * JD-Core Version:    0.7.0.1
 */