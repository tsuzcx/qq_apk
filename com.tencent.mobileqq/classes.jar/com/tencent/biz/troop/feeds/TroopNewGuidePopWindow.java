package com.tencent.biz.troop.feeds;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(9)
public class TroopNewGuidePopWindow
  extends QQCustomDialog
  implements View.OnClickListener, Observer
{
  TroopChatPie A;
  protected TroopFeedsDataManager.TroopNotify B = null;
  protected TroopFeedsDataManager.TroopNotifyAd C = null;
  protected boolean D = false;
  boolean E = false;
  boolean F;
  boolean G = false;
  int H = 0;
  int I = 0;
  boolean J = false;
  boolean K = false;
  protected Handler L = new TroopNewGuidePopWindow.10(this);
  BaseActivity a;
  View b;
  View c;
  View d;
  View e;
  TextView f;
  Button g;
  Button h;
  ImageView i;
  TextView j;
  TextView k;
  TextView l;
  TextView m;
  LinearLayout n;
  ImageView o;
  BounceScrollView p = null;
  boolean q = false;
  protected View r = null;
  protected URLImageView s = null;
  protected boolean t = false;
  protected String u = "";
  boolean v = false;
  QQAppInterface w;
  TroopFeedsCenterLogic x;
  protected TroopFeedsDataManager y;
  String z;
  
  public TroopNewGuidePopWindow(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopFeedsCenterLogic paramTroopFeedsCenterLogic, String paramString)
  {
    super(paramBaseActivity, 2131953338);
    this.a = paramBaseActivity;
    if ((!(paramBaseActivity instanceof SplashActivity)) && (!(paramBaseActivity instanceof ChatActivity)))
    {
      dismiss();
      return;
    }
    paramBaseActivity = paramBaseActivity.getChatFragment();
    if ((paramBaseActivity != null) && ((paramBaseActivity.k() instanceof TroopChatPie))) {
      this.A = ((TroopChatPie)paramBaseActivity.k());
    }
    this.x = paramTroopFeedsCenterLogic;
    this.w = paramQQAppInterface;
    paramBaseActivity = (TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    try
    {
      this.y = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.z = paramString;
      if (a()) {
        this.E = true;
      }
      setOnDismissListener(new TroopNewGuidePopWindow.1(this));
      this.F = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).aa(paramString);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopTipsPopWindow", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong * 1000L);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(localDate);
    try
    {
      paramLong = NetConnInfoCenter.getServerTime();
    }
    catch (Exception localException)
    {
      label29:
      Object localObject2;
      Object localObject3;
      break label29;
    }
    paramLong = System.currentTimeMillis() / 1000L;
    localObject2 = new Date(paramLong * 1000L);
    localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTime((Date)localObject2);
    localObject2 = new SimpleDateFormat("HH:mm");
    if (((Calendar)localObject1).get(1) == ((Calendar)localObject3).get(1))
    {
      localObject1 = new SimpleDateFormat("M月d日");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject1).format(localDate));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject2).format(localDate));
      return ((StringBuilder)localObject3).toString();
    }
    return new SimpleDateFormat("yyyy年M月d日").format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Date localDate = new Date(paramLong * 1000L);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate);
    try
    {
      l1 = NetConnInfoCenter.getServerTime();
    }
    catch (Exception localException1)
    {
      long l1;
      label34:
      Object localObject2;
      Calendar localCalendar2;
      Object localObject1;
      Object localObject3;
      StringBuilder localStringBuilder;
      double d1;
      break label34;
    }
    l1 = System.currentTimeMillis() / 1000L;
    localObject2 = new Date(1000L * l1);
    localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime((Date)localObject2);
    localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    localObject2 = ((SimpleDateFormat)localObject1).format((Date)localObject2);
    try
    {
      localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
      try
      {
        localObject2 = new Date(((Date)localObject1).getTime() - 86400000L);
      }
      catch (Exception localException2) {}
      if (!QLog.isColorLevel()) {
        break label177;
      }
    }
    catch (Exception localException3)
    {
      localObject1 = null;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("get today failed! msg = ");
    ((StringBuilder)localObject3).append(localException3.getMessage());
    QLog.d("TroopTipsPopWindow", 2, ((StringBuilder)localObject3).toString());
    label177:
    localStringBuilder = null;
    if ((localObject1 != null) && (localStringBuilder != null))
    {
      localObject3 = new SimpleDateFormat("HH:mm");
      l1 -= paramLong;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      if (paramLong < 60L) {
        return HardCodeUtil.a(2131912938);
      }
      if (paramLong < 3600L)
      {
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 == 0L) {
          paramLong = 1L;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912933));
        return ((StringBuilder)localObject1).toString();
      }
      if (paramLong < 86400L)
      {
        if (localDate.getDate() != ((Date)localObject1).getDate())
        {
          if (paramBoolean1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912934));
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
            return ((StringBuilder)localObject1).toString();
          }
          return HardCodeUtil.a(2131912936);
        }
        if (paramBoolean3)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912937));
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        d1 = (float)paramLong / (float)3600L;
        Double.isNaN(d1);
        paramLong = (d1 + 0.5D);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912935));
        return ((StringBuilder)localObject1).toString();
      }
      if ((paramBoolean2) && (paramLong < 259200L) && (localStringBuilder.getTime() - localDate.getTime() <= 86400000L))
      {
        if (paramBoolean1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912929));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        return HardCodeUtil.a(2131912932);
      }
      if ((paramLong < 172800L) && (((Date)localObject1).getTime() - localDate.getTime() <= 86400000L))
      {
        if (paramBoolean1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912930));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        return HardCodeUtil.a(2131912940);
      }
      if (localCalendar1.get(1) == localCalendar2.get(1))
      {
        localObject1 = new SimpleDateFormat("MM-dd");
        if (paramBoolean1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((SimpleDateFormat)localObject1).format(localDate));
          localStringBuilder.append(" ");
          localStringBuilder.append(((SimpleDateFormat)localObject3).format(localDate));
          return localStringBuilder.toString();
        }
        return ((SimpleDateFormat)localObject1).format(localDate);
      }
      return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
    }
    return "unknown";
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt)
  {
    if (!this.E)
    {
      this.y.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel()) {
      if (this.B == null)
      {
        QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
      }
      else
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("initNorNoticeView mTroopNotify");
        paramJSONObject.append(this.B.toString());
        QLog.d("TroopTipsPopWindow", 2, paramJSONObject.toString());
      }
    }
    paramJSONObject = this.B;
    if (paramJSONObject == null)
    {
      dismiss();
      return false;
    }
    paramJSONObject.a = paramInt;
    if (!TextUtils.isEmpty(paramJSONObject.g)) {
      this.o.setVisibility(0);
    }
    this.j.setText(new QQText(Html.fromHtml(this.B.d), 8));
    paramJSONObject = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.B.m);
    localStringBuilder.append(HardCodeUtil.a(2131912931));
    paramJSONObject.setText(localStringBuilder.toString());
    this.l.setText(a(this.B.j));
    this.q = this.B.l;
    if (this.q)
    {
      this.h.setVisibility(0);
      this.h.setOnClickListener(this);
      ReportController.b(this.w, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.z, "", "", "");
    }
    else
    {
      this.h.setVisibility(8);
    }
    if (this.B.o)
    {
      this.f.setText(2131895420);
      this.g.setText(2131895409);
      this.g.setContentDescription(this.a.getString(2131895409));
    }
    this.l.getViewTreeObserver().addOnGlobalLayoutListener(new TroopNewGuidePopWindow.3(this));
    if (!TextUtils.isEmpty(this.B.e)) {
      d(this.B.e);
    }
    if (AppSetting.e) {
      this.u = this.a.getString(2131895418, new Object[] { Html.fromHtml(this.B.c).toString(), this.B.i, a(this.B.j, true, true, false), Html.fromHtml(this.B.d).toString() });
    }
    paramJSONObject = this.y;
    if ((paramJSONObject != null) && (paramJSONObject.c == 1))
    {
      c();
      return true;
    }
    this.L.sendEmptyMessage(1001);
    return true;
  }
  
  public static void b(String paramString)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.11(paramString), 5, null, false);
  }
  
  public static String c(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private void d(String paramString)
  {
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    int i2 = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(this.a, 60.0F));
    int i3 = (int)DisplayUtils.a(this.a, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.v = true;
      Object localObject1 = this.i;
      int i1 = 0;
      ((ImageView)localObject1).setVisibility(0);
      this.c.setVisibility(0);
      Object localObject2;
      try
      {
        URL localURL = new URL(paramString);
        String str = c(localURL.getHost());
        localObject1 = paramString;
        if (!TextUtils.isEmpty(str)) {
          localObject1 = new URL("http", str, localURL.getFile()).toString();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        localObject2 = paramString;
      }
      paramString = URLDrawable.getDrawable((String)localObject2, i2, i3);
      if (paramString.getStatus() == 1)
      {
        float f1 = paramString.getIntrinsicHeight();
        float f2 = paramString.getIntrinsicWidth();
        localObject2 = this.i.getLayoutParams();
        if (f2 != 0.0F) {
          if (f1 > DisplayUtils.a(this.a, 150.0F)) {
            i1 = (int)DisplayUtils.a(this.a, 150.0F);
          } else {
            i1 = (int)(i2 * (f1 / f2));
          }
        }
        if (i1 > 0)
        {
          ((ViewGroup.LayoutParams)localObject2).height = i1;
          this.i.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        paramString.setURLDrawableListener(new TroopNewGuidePopWindow.5(this, localDisplayMetrics));
      }
      this.i.setImageDrawable(paramString);
      this.i.setContentDescription(this.a.getString(2131895413));
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.E) {
      return;
    }
    Object localObject;
    if (this.F)
    {
      localObject = this.w;
      String str = this.z;
      TroopReportor.a((AppRuntime)localObject, str, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { str, "", "", "" });
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (this.y != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "show. GET_NEW_GUIDE_NOTICE_REQUEST_CODE");
        }
        this.y.addObserver(this);
        this.y.b(1003);
      }
    }
    else if (this.y != null)
    {
      localObject = TroopNotificationHelper.d(this.w, this.z);
      if (localObject != null)
      {
        if (((TroopNotificationFlagMsg)localObject).b == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 1");
          }
          this.y.addObserver(this);
          this.y.a(1007, ((TroopNotificationFlagMsg)localObject).a);
          return;
        }
        if (((TroopNotificationFlagMsg)localObject).b == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 2");
          }
          this.y.addObserver(this);
          this.y.b(1003);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "show. GET_NOR_NOTICE, type = 0");
        }
        this.y.addObserver(this);
        this.y.b(1004);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.H = paramInt1;
    this.I = (this.a.getResources().getDisplayMetrics().heightPixels - this.H * 2);
  }
  
  public void a(TroopFeedsDataManager.TroopNotifyAd paramTroopNotifyAd)
  {
    if ((paramTroopNotifyAd != null) && (!TextUtils.isEmpty(paramTroopNotifyAd.c)) && (!TextUtils.isEmpty(paramTroopNotifyAd.b)))
    {
      this.r.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(paramTroopNotifyAd.c, (URLDrawable.URLDrawableOptions)localObject);
      this.s.setImageDrawable((Drawable)localObject);
      this.s.setURLDrawableDownListener(new TroopNewGuidePopWindow.7(this));
      this.s.setOnClickListener(new TroopNewGuidePopWindow.8(this, paramTroopNotifyAd));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.w;
    String str = this.z;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.B.a);
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, str, localStringBuilder.toString(), "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramBoolean, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.r.setVisibility(0);
    } else {
      this.r.setVisibility(8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changAdLayoutVisible show = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", from = ");
    localStringBuilder.append(paramString);
    QLog.i("zivonchen", 2, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    long l1 = (DeviceInfoUtil.a() * 3L + DeviceInfoUtil.r() * 7L) / 10L;
    if (l1 < 3136512L)
    {
      hide();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("availMemSize is ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" , smaller than 3M , TroopNewGuidePopWindow can't show ");
      QLog.i("TroopTipsPopWindow", 1, localStringBuilder.toString());
      return false;
    }
    try
    {
      this.b = LayoutInflater.from(this.a).inflate(2131626753, null);
      this.d = this.b.findViewById(2131431349);
      this.e = this.b.findViewById(2131447534);
      this.e.setOnClickListener(this);
      this.p = ((BounceScrollView)this.b.findViewById(2131445362));
      if (Build.VERSION.SDK_INT > 8) {
        this.p.setOverScrollMode(2);
      }
      this.p.setOnScrollChangedListener(new TroopNewGuidePopWindow.2(this));
      this.f = ((TextView)this.b.findViewById(2131439439));
      this.g = ((Button)this.b.findViewById(2131430817));
      this.h = ((Button)this.b.findViewById(2131438797));
      this.i = ((ImageView)this.b.findViewById(2131447409));
      this.i.setOnClickListener(this);
      this.j = ((TextView)this.b.findViewById(2131447407));
      this.j.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      this.j.setMovementMethod(LinkMovementMethod.getInstance());
      this.j.setOnClickListener(this);
      this.n = ((LinearLayout)this.b.findViewById(2131435763));
      this.k = ((TextView)this.b.findViewById(2131435769));
      this.l = ((TextView)this.b.findViewById(2131435778));
      this.m = ((TextView)this.b.findViewById(2131435767));
      this.g.setOnClickListener(this);
      this.g.setContentDescription(this.a.getString(2131895417));
      this.o = ((ImageView)this.b.findViewById(2131449652));
      this.o.setOnClickListener(this);
      this.c = this.b.findViewById(2131435579);
      this.r = this.b.findViewById(2131448061);
      this.s = ((URLImageView)this.r.findViewById(2131448060));
      setContentView(this.b);
      setCancelable(true);
      return true;
    }
    catch (InflateException localInflateException)
    {
      label475:
      break label475;
    }
    hide();
    QLog.e("TroopTipsPopWindow", 2, "InflateException, OutOfMemoryError, hide TroopNewGuidePopWindow");
    return false;
  }
  
  void b()
  {
    Object localObject1;
    if (!this.a.isFinishing())
    {
      if (this.A.bE()) {
        return;
      }
      localObject1 = this.a.getResources().getDisplayMetrics();
      Object localObject2 = this.b.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - DisplayUtils.a(this.a, 30.0F)));
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).gravity = 17;
      int i1 = (int)DisplayUtils.a(this.a, 10.0F);
      ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - DisplayUtils.a(this.a, 30.0F)));
      this.b.getViewTreeObserver().addOnGlobalLayoutListener(new TroopNewGuidePopWindow.6(this, i1));
      localObject1 = (TroopGameGuideHelper)this.A.q(92);
      if (localObject1 != null) {
        ((TroopGameGuideHelper)localObject1).a();
      }
      if ((!this.a.isFinishing()) && (!this.A.bE())) {
        super.show();
      }
      a("exp_bulletin");
      if (this.B.a == 2) {
        ReportController.b(this.w, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.z, "", "", "");
      }
      if (!TextUtils.isEmpty(this.B.g)) {
        a("exp_vid");
      } else if (!TextUtils.isEmpty(this.B.e)) {
        a("exp_pic");
      }
    }
    try
    {
      localObject1 = (QQText)this.j.getText();
      localObject1 = (LinkSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), LinkSpan.class);
      if ((localObject1 == null) || (localObject1.length == 0)) {
        break label333;
      }
      a("exp_link");
      return;
    }
    catch (Exception localException)
    {
      label318:
      label333:
      break label318;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
    }
  }
  
  public void c()
  {
    TroopFeedsDataManager.a(this.a, this.w, 0, new TroopNewGuidePopWindow.9(this));
  }
  
  public void dismiss()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((TroopFeedsDataManager)localObject).deleteObserver(this);
    }
    localObject = (AIOAnimationControlManager)this.w.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    boolean bool = false;
    if (localObject != null) {
      bool = ((AIOAnimationControlManager)localObject).a(this.z);
    }
    if (bool)
    {
      localObject = this.A;
      if ((localObject != null) && (!((TroopChatPie)localObject).bE()))
      {
        AIOAnimationControlManager.l = true;
        AIOAnimationControlManager.a(this.A, true);
      }
    }
    super.dismiss();
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.e) && (!TextUtils.isEmpty(this.u)) && (!this.K))
    {
      AccessibilityUtils.a(this.b, this.u);
      this.K = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int i1 = 2;
    Object localObject1 = "";
    Object localObject4;
    Object localObject3;
    Object localObject5;
    String str;
    Object localObject2;
    switch (i2)
    {
    default: 
      break;
    case 2131449652: 
      if (!TextUtils.isEmpty(this.B.g))
      {
        localObject1 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.B.g);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        this.a.startActivity((Intent)localObject1);
        a("clk_vid");
      }
      else if (!TextUtils.isEmpty(this.B.f))
      {
        localObject4 = new ArrayList();
        localObject3 = this.B.f;
        try
        {
          localObject5 = new URL((String)localObject3);
          str = c(((URL)localObject5).getHost());
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = new URL("http", str, ((URL)localObject5).getFile()).toString();
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          localObject2 = localObject3;
        }
        ((ArrayList)localObject4).add(localObject2);
        TroopNoticeJsHandler.a(this.a, 0, (ArrayList)localObject4, true, "", -1);
        a("clk_pic");
      }
      break;
    case 2131438797: 
      localObject5 = (TroopManager)this.w.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject4 = ((TroopManager)localObject5).g(this.z, this.w.getCurrentUin());
      if ((localObject4 != null) && (((TroopMemberInfo)localObject4).troopColorNick != null)) {
        localObject3 = ((TroopMemberInfo)localObject4).troopColorNick;
      } else {
        localObject3 = "";
      }
      localObject5 = ((TroopManager)localObject5).f(this.z);
      if (localObject5 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject5).dwGroupClassExt);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject5 = new Intent();
      ((Intent)localObject5).putExtra("edit_type", 5);
      ((Intent)localObject5).putExtra("edit_mode", 0);
      ((Intent)localObject5).putExtra("title", getContext().getResources().getString(2131895350));
      ((Intent)localObject5).putExtra("default_text", (String)localObject3);
      if (localObject4 != null) {
        ((Intent)localObject5).putExtra("default_nick_id", ((TroopMemberInfo)localObject4).troopColorNickId);
      }
      ((Intent)localObject5).putExtra("troopUin", this.z);
      ((Intent)localObject5).putExtra("uin", this.w.getAccount());
      ((Intent)localObject5).putExtra("max_num", 60);
      ((Intent)localObject5).putExtra("from", 0);
      RouteUtils.a(getContext(), (Intent)localObject5, "/base/activity/editInfoActivity");
      ReportController.b(this.w, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.z, "", "", "");
      localObject3 = this.w;
      localObject4 = this.z;
      if (!this.B.o) {
        i1 = 1;
      }
      ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, (String)localObject4, (String)localObject2, String.valueOf(i1), "");
      dismiss();
      break;
    case 2131430817: 
    case 2131447407: 
    case 2131447409: 
    case 2131447534: 
      localObject4 = new Intent(this.a, QQBrowserActivity.class);
      localObject5 = ((TroopManager)this.w.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.z);
      str = this.w.getCurrentAccountUin();
      localObject3 = localObject2;
      if (localObject5 != null)
      {
        localObject3 = localObject2;
        if (str != null)
        {
          if ((!str.equals(((TroopInfo)localObject5).troopowneruin)) && (((TroopInfo)localObject5).Administrator != null)) {
            ((TroopInfo)localObject5).Administrator.contains(str);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject5).dwGroupClassExt);
          localObject3 = ((StringBuilder)localObject2).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=");
      ((StringBuilder)localObject2).append(this.B.p);
      ((StringBuilder)localObject2).append("&gc=");
      ((StringBuilder)localObject2).append(this.z);
      ((Intent)localObject4).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject4).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity((Intent)localObject4);
      a("clk_history");
      if (this.B.o)
      {
        localObject2 = this.w;
        localObject4 = this.z;
        if (!this.G) {
          i1 = 1;
        }
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, (String)localObject4, (String)localObject3, "", String.valueOf(i1));
      }
      else
      {
        ReportController.b(this.w, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.z, (String)localObject3, "", "");
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.y;
    if (paramObservable != null) {
      paramObservable.deleteObserver(this);
    }
    paramObservable = this.A;
    if (paramObservable != null)
    {
      if (paramObservable.bE()) {
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramObservable = (Integer)paramObject;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("update, notifyType = ");
          paramObject.append(paramObservable);
          QLog.d("TroopTipsPopWindow", 2, paramObject.toString());
        }
        if (paramObservable.intValue() == 106)
        {
          paramObservable = this.y;
          if ((paramObservable != null) && (paramObservable.a != null))
          {
            a(this.y.a, 2, false);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1007)
        {
          paramObservable = this.y;
          if ((paramObservable != null) && (paramObservable.b != null))
          {
            a(this.y.b, 1, false);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1011)
        {
          paramObservable = this.y;
          if ((paramObservable != null) && (paramObservable.b != null))
          {
            a(this.y.b, 1, true);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1012)
        {
          TroopNotificationHelper.e(this.w, this.z);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow
 * JD-Core Version:    0.7.0.1
 */