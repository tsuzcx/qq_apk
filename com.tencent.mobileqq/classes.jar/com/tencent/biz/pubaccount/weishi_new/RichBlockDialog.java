package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class RichBlockDialog
  extends SafeDialog
  implements View.OnClickListener
{
  public stPopWindowsConfig a;
  private Context b;
  private int d = 12;
  private int e = 5;
  private URLImageView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private long m;
  private WSMultiImageManager n;
  private boolean o = false;
  private TextView p;
  private View q;
  private stGlobalConfig r;
  private String s = "weishi://main";
  private int t;
  private int u;
  private String v;
  
  private RichBlockDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131953466, paramInt1, paramInt2);
  }
  
  private RichBlockDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      WSLog.b("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      WSLog.b("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  public RichBlockDialog(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    this(paramContext, -1, -1);
    this.b = paramContext;
    this.t = paramInt1;
    this.u = paramInt2;
    this.v = paramString;
  }
  
  private void a(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.m < 1500L)
    {
      WSLog.a("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.m = l1;
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((stPopWindowsConfig)localObject1).jp_button != null))
    {
      a(112, "popup_clk");
      Object localObject2 = getContext();
      localObject1 = localObject2;
      if ((localObject2 instanceof ContextThemeWrapper)) {
        localObject1 = ((ContextThemeWrapper)localObject2).getBaseContext();
      }
      localObject2 = this.a.schema_url;
      String str = this.a.h5url;
      WeishiUtils.a(this.b, (String)localObject2, str, "", this.a.type, new RichBlockDialog.1(this, (Context)localObject1));
    }
    e();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (h())
    {
      WSReportDc00898.c(paramInt, this.a.type, this.a.windowsid);
      return;
    }
    WSReportDC898Vertical.b(paramString, this.a.type, this.a.windowsid);
  }
  
  private String b(int paramInt)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(d1 / 100.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0) {
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str1;
  }
  
  private void b()
  {
    this.o = false;
    this.q = LayoutInflater.from(getContext()).inflate(2131629032, null, false);
    setContentView(this.q);
    this.f = ((URLImageView)this.q.findViewById(2131444125));
    this.i = ((TextView)this.q.findViewById(2131444129));
    this.j = ((TextView)this.q.findViewById(2131444126));
    this.k = ((TextView)this.q.findViewById(2131444128));
    this.l = ((TextView)this.q.findViewById(2131444127));
    this.g = ((ImageView)this.q.findViewById(2131444123));
    this.h = ((TextView)this.q.findViewById(2131444122));
    this.p = ((TextView)this.q.findViewById(2131444130));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void c()
  {
    stPopWindowsConfig localstPopWindowsConfig = this.a;
    if ((localstPopWindowsConfig != null) && (localstPopWindowsConfig.type != 1))
    {
      this.i.setVisibility(4);
      this.j.setVisibility(4);
      this.k.setVisibility(4);
      this.l.setVisibility(4);
      this.p.setVisibility(4);
      this.h.setVisibility(4);
      WSLog.a("weishi-813", "展示图片");
      return;
    }
    WSLog.a("weishi-813", "展示红包");
  }
  
  private int d()
  {
    int i1 = this.a.type;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return 6;
        }
        return 7;
      }
      return 401;
    }
    return 6;
  }
  
  private void e()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void f()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((stPopWindowsConfig)localObject).title)) {
        this.i.setText(this.a.title);
      }
      if (this.a.type == 1)
      {
        if ((this.a.annexation != null) && (this.a.annexation.money > 0))
        {
          localObject = b(this.a.annexation.money);
          this.j.setText((CharSequence)localObject);
        }
      }
      else if (this.a.annexation != null)
      {
        localObject = this.j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.annexation.money);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      if ((this.a.jp_button != null) && (!TextUtils.isEmpty(this.a.jp_button.title))) {
        this.h.setText(this.a.jp_button.title);
      }
      if (!TextUtils.isEmpty(this.a.text)) {
        this.k.setText(this.a.text);
      }
      if (!TextUtils.isEmpty(this.a.remark)) {
        this.l.setText(this.a.remark);
      }
      show();
      a(6, "popup_exp");
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.a.windowsid, this.a.trace_id, this.v, this.u);
      a();
    }
  }
  
  private boolean h()
  {
    return this.t == 0;
  }
  
  public void a() {}
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a();
    if (paramstGlobalConfig != null)
    {
      this.r = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config != null) && (paramstGlobalConfig.windows_config.size() > 0))
      {
        paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
        if (paramstGlobalConfig != null)
        {
          if (paramstGlobalConfig.type == 1) {
            this.a = paramstGlobalConfig;
          } else if (paramstGlobalConfig.type == 2) {
            this.a = paramstGlobalConfig;
          } else {
            this.a = paramstGlobalConfig;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("阻断页rich化 type是：");
          localStringBuilder.append(paramstGlobalConfig.type);
          WSLog.a("weishi-813", localStringBuilder.toString());
        }
        else
        {
          WSLog.a("weishi-813", "阻断页rich化 windowsConfig为null");
        }
      }
      else
      {
        WSLog.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
      }
      c();
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = this.a;
    if (paramContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramContext.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130842687);
      int i1 = this.a.type;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          e();
          return;
        }
        this.n = new WSMultiImageManager();
        this.n.a(this.f, paramContext, this.a.bg_img_url, true, false);
        f();
        return;
      }
      a(this.a.bg_img_url, paramContext, paramContext, HardCodeUtil.a(2131910923));
      return;
    }
    e();
  }
  
  public void a(String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    WSFallKeyPicMonitor.a(3);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mFailedDrawable = paramDrawable1;
    paramString2.mLoadingDrawable = paramDrawable2;
    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
    this.f.setImageDrawable(paramString1);
    this.f.setURLDrawableDownListener(new RichBlockDialog.2(this));
    this.f.setImageDrawable(paramString1);
    if (1 == paramString1.getStatus())
    {
      f();
      WSFallKeyPicMonitor.b(3);
      return;
    }
    paramString1.startDownload();
  }
  
  public void dismiss()
  {
    WSLog.b("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.o = false;
      if (this.n != null)
      {
        this.n.a();
        this.n = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      WSLog.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    case 2131444124: 
    default: 
    case 2131444125: 
      WSLog.a("weishi-813", "点击了图片 背景图");
      a(2);
      return;
    case 2131444123: 
      e();
      if (this.a != null)
      {
        a(117, "popup_close");
        WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.a.windowsid, this.a.trace_id, this.v, this.u);
        return;
      }
      break;
    case 2131444122: 
      WSLog.a("weishi-813", "点击了红包 提现");
      a(1);
    }
  }
  
  public void show()
  {
    WSLog.b("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.o = true;
      return;
    }
    catch (Exception localException)
    {
      WSLog.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.RichBlockDialog
 * JD-Core Version:    0.7.0.1
 */