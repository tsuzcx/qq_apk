package com.tencent.mobileqq.activity.springfestival;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class HBEntryBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  public static int a = 10;
  public static long b = -1L;
  public static int c = -1;
  private HBEntryBannerServlet d;
  private WeakReference<Activity> e;
  private HBEntryBannerData f;
  private float g = 2.62F;
  private final ImageView h;
  private final ImageView i;
  private final ImageView j;
  private final ImageView k;
  private final ImageView l;
  private final ImageView m;
  private final TextView n;
  private final TextView o;
  private final RelativeLayout p;
  private final RelativeLayout q;
  
  public HBEntryBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HBEntryBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HBEntryBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131625136, this);
    this.d = new HBEntryBannerServlet();
    a();
    this.p = ((RelativeLayout)findViewById(2131434807));
    this.q = ((RelativeLayout)findViewById(2131434811));
    this.n = ((TextView)findViewById(2131434816));
    this.o = ((TextView)findViewById(2131434810));
    this.j = ((ImageView)findViewById(2131434808));
    this.k = ((ImageView)findViewById(2131434812));
    this.h = ((ImageView)findViewById(2131434815));
    this.i = ((ImageView)findViewById(2131434809));
    this.l = ((ImageView)findViewById(2131434813));
    this.m = ((ImageView)findViewById(2131434814));
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void a()
  {
    boolean bool;
    if (Math.abs(System.currentTimeMillis() - b) > a * 60 * 1000) {
      bool = true;
    } else {
      bool = false;
    }
    if ((b == -1L) || (bool))
    {
      if (this.d == null) {
        this.d = new HBEntryBannerServlet();
      }
      this.d.a();
      b = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateActivityRealtimeNumber, timeApprove:");
      localStringBuilder.append(bool);
      QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(View paramView, String paramString, boolean paramBoolean)
  {
    paramString = Utils.a(paramString, paramView.getWidth(), paramView.getHeight(), paramBoolean);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("jumpGame,jumpUrl = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      localObject1 = localObject2;
      if ((localObject3 instanceof QQAppInterface)) {
        localObject1 = (QQAppInterface)localObject3;
      }
    }
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = paramString.trim();
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        if (paramString.startsWith("mqqapi://"))
        {
          paramString = JumpParser.a((BaseQQAppInterface)localObject1, (Context)this.e.get(), paramString);
          if (paramString != null) {
            paramString.a();
          }
        }
      }
      else {
        b(paramString);
      }
    }
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("reportBanner actionName = ");
      paramMap.append(paramString);
      QLog.d("HBEntryBannerView", 2, paramMap.toString());
    }
    ((Map)localObject).put("active_id", this.f.r());
    SpringHbReporter.a(ReportConstant.Event.m, 0, 1, (Map)localObject, paramString);
  }
  
  private void a(WeakReference<Activity> paramWeakReference)
  {
    int i1 = this.f.b();
    Object localObject1 = this.f.c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playFireWorkAnimation fireWorkPlayCount = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(",fireWorkImgUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    if ((paramWeakReference != null) && ((paramWeakReference.get() instanceof QBaseActivity)))
    {
      localObject2 = (SpringFestivalEntryManager)((QBaseActivity)paramWeakReference.get()).getAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      paramWeakReference = ((SpringFestivalEntryManager)localObject2).b((String)localObject1);
      boolean bool = FileUtils.fileExists(paramWeakReference);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playFireWorkAnimation exist = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",apngFilePath = ");
        localStringBuilder.append(paramWeakReference);
        QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        localObject1 = new ApngOptions();
        ((ApngOptions)localObject1).a(URLDrawableHelper.TRANSPARENT);
        ((ApngOptions)localObject1).a(i1);
        paramWeakReference = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject1, paramWeakReference);
        this.k.setImageDrawable(paramWeakReference);
        return;
      }
      ((SpringFestivalEntryManager)localObject2).a(new HBEntryBannerView.1(this, (String)localObject1, i1, (SpringFestivalEntryManager)localObject2));
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.setBackgroundDrawable(getResources().getDrawable(2130841070));
      this.n.setVisibility(0);
    }
    else
    {
      this.p.setBackgroundColor(0);
      this.n.setVisibility(8);
    }
    this.o.setVisibility(0);
    this.i.setVisibility(0);
    TextView localTextView = this.o;
    String str;
    if (paramBoolean) {
      str = "#E9FEFF";
    } else {
      str = "#F7E5C3";
    }
    localTextView.setTextColor(Color.parseColor(str));
    this.o.setTextSize(14.0F);
  }
  
  private RelativeLayout.LayoutParams b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.height = AIOUtils.b(32.0F, getResources());
      localLayoutParams.addRule(1, 2131434816);
      localLayoutParams.addRule(15);
      return localLayoutParams;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.height = AIOUtils.b(32.0F, getResources());
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  private void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpWeb,schemeUrl = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e.get() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = new Intent((Context)this.e.get(), QQBrowserActivity.class);
      BaseApplicationImpl.getApplication().startActivity(((Intent)localObject).putExtra("url", paramString));
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void a(WeakReference<Activity> paramWeakReference, HBEntryBannerData paramHBEntryBannerData, boolean paramBoolean)
  {
    this.f = paramHBEntryBannerData;
    this.e = paramWeakReference;
    a();
    if (this.f == null) {
      return;
    }
    if (paramBoolean) {
      a("exp", null);
    }
    if (this.f.p() == 0)
    {
      this.j.setImageDrawable(getResources().getDrawable(2130841067));
      this.g = 3.42F;
    }
    else if (this.f.p() == 1)
    {
      this.j.setImageDrawable(getResources().getDrawable(2130841066));
      this.g = 2.62F;
    }
    if (QLog.isColorLevel())
    {
      paramHBEntryBannerData = new StringBuilder();
      paramHBEntryBannerData.append("updateHbEntryData:");
      paramHBEntryBannerData.append(this.f.d());
      QLog.d("HBEntryBannerView", 2, paramHBEntryBannerData.toString());
      paramHBEntryBannerData = new StringBuilder();
      paramHBEntryBannerData.append("updateHbEntryData hbBannerRatio:");
      paramHBEntryBannerData.append(this.g);
      paramHBEntryBannerData.append(",isDesktopOpened: ");
      paramHBEntryBannerData.append(paramBoolean);
      paramHBEntryBannerData.append(", imgUrl:");
      paramHBEntryBannerData.append(this.f.f());
      QLog.d("HBEntryBannerView", 2, paramHBEntryBannerData.toString());
    }
    if ((this.j.getMeasuredWidth() > 0) && (this.j.getMeasuredHeight() > 0))
    {
      paramHBEntryBannerData = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      int i1 = this.j.getMeasuredWidth() - paramHBEntryBannerData.leftMargin - paramHBEntryBannerData.rightMargin;
      int i2 = (int)(i1 / this.g);
      paramHBEntryBannerData.width = this.j.getMeasuredWidth();
      paramHBEntryBannerData.height = (paramHBEntryBannerData.topMargin + i2 + paramHBEntryBannerData.bottomMargin);
      this.j.setLayoutParams(paramHBEntryBannerData);
      Object localObject = Utils.a(this.f.f(), i1, i2, true);
      if (QLog.isColorLevel())
      {
        QLog.d("HBEntryBannerView", 2, "updateHbEntryData setImageDrawable");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateHbEntryData params.width = ");
        localStringBuilder.append(paramHBEntryBannerData.width);
        localStringBuilder.append(",params.height = ");
        localStringBuilder.append(paramHBEntryBannerData.height);
        localStringBuilder.append(",img backBgWidth = ");
        localStringBuilder.append(i1);
        localStringBuilder.append(",img backBgHeiht = ");
        localStringBuilder.append(i2);
        QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
      }
      this.j.setImageDrawable((Drawable)localObject);
      this.k.setVisibility(8);
      if (this.f.a())
      {
        localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = paramHBEntryBannerData.width;
        ((RelativeLayout.LayoutParams)localObject).height = paramHBEntryBannerData.height;
        this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.k.setVisibility(0);
        try
        {
          a(paramWeakReference);
        }
        catch (Exception paramWeakReference)
        {
          QLog.d("HBEntryBannerView", 1, "updateHbEntryData playFireWorkAnimation exception", paramWeakReference);
          SpringHbMonitorReporter.a(405, paramWeakReference, new String[] { Log.getStackTraceString(paramWeakReference) });
        }
      }
    }
    if (this.f.p() == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    a(paramBoolean);
    if (!TextUtils.isEmpty(this.f.k()))
    {
      this.n.setVisibility(0);
      this.o.setText(this.f.k());
      this.p.setVisibility(0);
      this.q.setLayoutParams(b(true));
    }
    else if (!TextUtils.isEmpty(this.f.l()))
    {
      this.n.setVisibility(8);
      this.o.setText(this.f.l());
      this.p.setVisibility(0);
      this.q.setLayoutParams(b(false));
    }
    else
    {
      this.p.setVisibility(8);
    }
    if (this.p.getVisibility() == 0)
    {
      this.o.setFocusable(true);
      this.o.setFocusableInTouchMode(true);
      if (this.f.q() == 3)
      {
        this.n.setVisibility(8);
        if (TextUtils.isEmpty(this.f.l())) {
          paramWeakReference = getResources().getString(2131897346);
        } else {
          paramWeakReference = this.f.l();
        }
        if (c != -1)
        {
          paramHBEntryBannerData = new StringBuilder();
          paramHBEntryBannerData.append(c);
          paramHBEntryBannerData.append(paramWeakReference);
          paramWeakReference = paramHBEntryBannerData.toString();
          this.o.setText(paramWeakReference);
        }
        else
        {
          this.o.setText(getResources().getText(2131897347));
        }
        this.o.setTextColor(Color.parseColor("#E9FEFF"));
        this.o.setTextSize(18.0F);
        this.i.setVisibility(8);
      }
    }
    a(this.i, this.f.h(), false);
    a(this.h, this.f.g(), true);
    a(this.l, this.f.i(), false);
    a(this.m, this.f.j(), false);
    requestLayout();
    invalidate();
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    int i2 = 2;
    switch (i1)
    {
    default: 
      i1 = -1;
      break;
    case 2131434814: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern2");
      }
      localObject = this.f;
      i1 = i2;
      if (localObject != null)
      {
        b(((HBEntryBannerData)localObject).n());
        i1 = i2;
      }
      break;
    case 2131434813: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern1");
      }
      localObject = this.f;
      if (localObject != null) {
        b(((HBEntryBannerData)localObject).m());
      }
      i1 = 1;
      break;
    case 2131434808: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_background");
      }
      localObject = this.f;
      if (localObject != null) {
        a(((HBEntryBannerData)localObject).o());
      }
      i1 = 3;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("refer", String.valueOf(i1));
    a("clk", (Map)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerView
 * JD-Core Version:    0.7.0.1
 */