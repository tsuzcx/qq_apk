package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import java.util.Map;

public class GdtWebReportNoco
  implements GdtWebReportInterface
{
  private GdtWebReportPlugin a;
  
  public GdtWebReportNoco(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    this.a = paramGdtWebReportPlugin;
  }
  
  private String a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((GdtWebReportPlugin)localObject).b();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Activity)localObject).getIntent() != null))
    {
      long l = ((Activity)localObject).getIntent().getLongExtra("GdtNocoId", -1L);
      if (l != -1L) {
        return String.valueOf(l);
      }
    }
    return null;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934594L) {
      try
      {
        paramString = a();
        if (!TextUtils.isEmpty(paramString))
        {
          this.a.callJs("!function(g,d,t,e,v,n,s){if(g.gdt)return;v=g.gdt=function(){v.tk?v.tk.apply(v,arguments):v.queue.push(arguments)};v.sv=\"1.0\";v.bt=2;v.queue=[];n=d.createElement(t);n.async=!0;n.src=e;s=d.getElementsByTagName(t)[0];s.parentNode.insertBefore(n,s);}(window,document,\"script\",\"//qzonestyle.gtimg.cn/qzone/biz/gdt/dmp/user-action/gdtevent.min.js\");gdt(\"init\",\"userActionSetId\");gdt(\"track\",\"PAGE_VIEW\");".replace("userActionSetId", paramString));
          paramMap = new StringBuilder();
          paramMap.append("GdtWebReportPlugin Report nocoId :");
          paramMap.append(paramString);
          GdtLog.a("GdtWebReportNoco", paramMap.toString());
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public void b() {}
  
  public void b(CustomWebView paramCustomWebView) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportNoco
 * JD-Core Version:    0.7.0.1
 */