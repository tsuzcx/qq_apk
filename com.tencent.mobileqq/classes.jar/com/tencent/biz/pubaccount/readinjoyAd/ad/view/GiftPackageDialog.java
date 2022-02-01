package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import java.util.List;
import org.json.JSONObject;

public class GiftPackageDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private JSONObject A;
  private long B;
  private GiftPkgSelectDialog C;
  private int D;
  private int E = 3;
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private Button g;
  private List<GiftServiceBean> h;
  private List<GiftServiceBean> i;
  private List<GiftServiceBean> j;
  private List<GiftServiceBean> k;
  private LinearLayout l;
  private LinearLayout m;
  private GiftServiceBean n;
  private GiftServiceBean o;
  private GiftServiceBean p;
  private String q;
  private ImageView r;
  private GiftPackageListener s;
  private GiftGetListener t;
  private String u = "";
  private String v = "";
  private String w = "";
  private boolean x = true;
  private boolean y = false;
  private AdvertisementInfo z;
  
  public GiftPackageDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131952330);
    this.E = paramInt;
    this.a = paramContext;
    requestWindowFeature(1);
    if (!VersionUtils.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    } else {
      getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131166286)));
    }
    setContentView(2131626260);
    this.b = ((TextView)findViewById(2131448741));
    this.c = ((TextView)findViewById(2131448266));
    this.d = ((TextView)findViewById(2131448717));
    this.e = ((TextView)findViewById(2131448701));
    this.g = ((Button)findViewById(2131429843));
    this.f = ((TextView)findViewById(2131448814));
    this.r = ((ImageView)findViewById(2131436318));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.l = ((LinearLayout)findViewById(2131437798));
    this.m = ((LinearLayout)findViewById(2131437801));
    this.m.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.g, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, paramContext.getResources()), Color.parseColor("#EBEDF5"));
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.b, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.c, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.d, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.l, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
  }
  
  private String a()
  {
    int i1 = this.E;
    String str = "1";
    if (i1 == 4) {
      return "1";
    }
    if (i1 == 3) {
      return "2";
    }
    if (i1 == 5) {
      str = "0";
    }
    return str;
  }
  
  private void b()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.C = new GiftPkgSelectDialog(this.a, this.l.getHeight());
      localObject = this.n;
      if ((localObject != null) && (!TextUtils.isEmpty(((GiftServiceBean)localObject).t))) {
        localObject = this.n.t;
      } else {
        localObject = "";
      }
      this.C.a(this.h, new GiftPackageDialog.1(this), (String)localObject);
      this.C.show();
    }
  }
  
  private void c()
  {
    Object localObject = this.j;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.C = new GiftPkgSelectDialog(this.a, this.l.getHeight());
      localObject = this.o;
      if ((localObject != null) && (!TextUtils.isEmpty(((GiftServiceBean)localObject).t))) {
        localObject = this.o.t;
      } else {
        localObject = "";
      }
      this.C.a(this.j, new GiftPackageDialog.2(this), (String)localObject);
      this.C.show();
    }
  }
  
  private void d()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.C = new GiftPkgSelectDialog(this.a, this.l.getHeight());
      localObject = this.p;
      if ((localObject != null) && (!TextUtils.isEmpty(((GiftServiceBean)localObject).t))) {
        localObject = this.p.t;
      } else {
        localObject = "";
      }
      this.C.a(this.k, new GiftPackageDialog.3(this), (String)localObject);
      this.C.show();
    }
  }
  
  private void e()
  {
    ThreadManager.executeOnNetWorkThread(new GiftPackageDialog.4(this));
  }
  
  private void f()
  {
    if ((this.n != null) && (this.o != null) && (this.p != null))
    {
      ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.g, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, this.a.getResources()), Color.parseColor("#00CAFC"));
      this.g.setClickable(true);
      return;
    }
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.g, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, this.a.getResources()), Color.parseColor("#EBEDF5"));
    this.g.setClickable(false);
  }
  
  public void a(long paramLong)
  {
    this.B = paramLong;
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.D = paramConfiguration.orientation;
    paramConfiguration = this.C;
    if (paramConfiguration != null) {
      paramConfiguration.dismiss();
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.z = paramAdvertisementInfo;
  }
  
  public void a(GiftGetListener paramGiftGetListener)
  {
    this.t = paramGiftGetListener;
  }
  
  public void a(GiftPackageListener paramGiftPackageListener)
  {
    this.s = paramGiftPackageListener;
  }
  
  public void a(List<GiftServiceBean> paramList1, List<GiftServiceBean> paramList2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.h = paramList1;
    this.i = paramList2;
    this.q = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.u = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      this.w = paramString3;
      this.f.setText(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      this.v = paramString4;
    }
    if ((!TextUtils.isEmpty(paramString5)) && ("0".equals(paramString5))) {
      this.x = false;
    }
    if (!this.x)
    {
      this.d.setVisibility(8);
      this.p = new GiftServiceBean();
      this.p.t = HardCodeUtil.a(2131903243);
      this.p.v = "0";
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.A = paramJSONObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131448741)
    {
      b();
    }
    else if (i1 == 2131448266)
    {
      c();
    }
    else if (i1 == 2131448717)
    {
      d();
    }
    else if (i1 == 2131429843)
    {
      e();
    }
    else if (i1 == 2131436318)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGameGiftClick(this.z, 3, a());
      dismiss();
    }
    else if (i1 == 2131437801)
    {
      dismiss();
    }
    else if ((i1 != 2131437798) && (i1 == 2131448701))
    {
      dismiss();
      GiftPackageListener localGiftPackageListener = this.s;
      if (localGiftPackageListener != null) {
        localGiftPackageListener.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog
 * JD-Core Version:    0.7.0.1
 */