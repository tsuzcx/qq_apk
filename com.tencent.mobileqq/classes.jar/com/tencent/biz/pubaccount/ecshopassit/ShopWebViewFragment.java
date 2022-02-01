package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewSurface;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ShopWebViewFragment
  extends WebViewFragment
  implements DragFrameLayout.OnDragModeChangedListener
{
  boolean a;
  boolean b;
  boolean c;
  boolean d;
  int e;
  public List<RecentShopParcel> f;
  EcshopCacheTool g;
  String[] h = new String[4];
  DragFrameLayout i;
  SwipListView j;
  public ShopFolderAdapter k;
  int l = 0;
  int m;
  int n;
  View o;
  ImageView p;
  TextView q;
  ImageView r;
  public TextView s;
  public TextView t;
  public TextView u;
  public ImageView v;
  public ViewGroup w;
  BroadcastReceiver x = new ShopWebViewFragment.4(this);
  SosoInterfaceOnLocationListener y = new ShopWebViewFragment.5(this, 0, true, false, 600000L, false, false, "ecshop");
  RedTouch z;
  
  void a()
  {
    this.p = new FadeIconImageView(getQBaseActivity());
    this.q = new TextView(getQBaseActivity());
    Object localObject2;
    int i1;
    if (!this.a)
    {
      this.t.setText(HardCodeUtil.a(2131911410));
      this.s.setVisibility(8);
      this.p.setId(2131436666);
      this.p.setOnClickListener(this);
      this.p.setImageResource(2130853298);
      localObject1 = (RelativeLayout)this.w.findViewById(2131445048);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(10.0F, getResources());
      ((RelativeLayout)localObject1).addView(this.p, (ViewGroup.LayoutParams)localObject2);
      this.q.setId(2131448219);
      this.q.setOnClickListener(this);
      this.q.setTextColor(getResources().getColor(2131168464));
      this.q.setTextSize(1, 17.0F);
      this.q.setBackgroundResource(2130837967);
      this.q.setGravity(17);
      i1 = AIOUtils.b(3.0F, getResources());
      int i2 = AIOUtils.b(4.0F, getResources());
      this.q.setPadding(i1, 0, i1, 0);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131436666);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
      ((RelativeLayout)localObject1).addView(this.q, (ViewGroup.LayoutParams)localObject2);
    }
    else
    {
      i1 = AIOUtils.b(30.0F, getResources());
      this.r = new FadeIconImageView(getQBaseActivity());
      this.r.setId(2131436199);
      this.r.setScaleType(ImageView.ScaleType.CENTER);
      localObject1 = new RelativeLayout.LayoutParams(i1, i1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131436194);
      ((RelativeLayout)this.v.getParent()).addView(this.r, (ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = new int[4][];
    localObject1[0] = { 16842919 };
    localObject1[1] = { 16842912 };
    localObject1[2] = { 16842913 };
    localObject1[3] = new int[0];
    if (this.c)
    {
      if (!this.a)
      {
        this.w.setBackgroundResource(2130852229);
        localObject2 = getResources().getColorStateList(2131167991);
        this.t.setTextColor((ColorStateList)localObject2);
        localObject2 = new ColorStateList((int[][])localObject1, new int[] { 2147483647, 2147483647, 2147483647, -1 });
        this.u.setTextColor((ColorStateList)localObject2);
        getQBaseActivity().setStatusBarBlue();
      }
      if (Build.VERSION.SDK_INT >= 19) {
        break label746;
      }
    }
    try
    {
      localObject2 = (ViewGroup.MarginLayoutParams)this.w.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(getQBaseActivity().getApplicationContext()));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Change mBackWrapper topMargin=");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject2).topMargin);
        QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
      }
      this.w.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    catch (Throwable localThrowable)
    {
      label595:
      break label595;
    }
    break label746;
    if ((this.webViewSurface.f()) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      if (getWebTitleBarInterface().l() != null)
      {
        if ((getUIStyle() != null) && (getUIStyle().R != null))
        {
          getWebTitleBarInterface().l().setBackgroundColor(getUIStyle().R.b);
          SimpleUIUtil.a(true, getUIStyle().R.b, getHostActivity().getWindow());
        }
        else
        {
          getWebTitleBarInterface().l().setBackgroundColor(getResources().getColor(2131168092));
          SimpleUIUtil.a(false, getResources().getColor(2131168092), getHostActivity().getWindow());
        }
      }
      else {
        getWebTitleBarInterface().c(false);
      }
    }
    label746:
    if (this.a)
    {
      this.w.setBackgroundResource(0);
      this.w.setBackgroundColor(-1);
      ImmersiveUtils.setStatusBarDarkMode(getActivity().getWindow(), true);
      if (getWebTitleBarInterface().l() != null) {
        getWebTitleBarInterface().l().setBackgroundResource(2130853592);
      }
      i1 = AIOUtils.b(3.0F, getResources());
      localObject1 = new ColorStateList((int[][])localObject1, new int[] { 2130706432, 2130706432, 2130706432, -16777216 });
      this.t.setTextColor((ColorStateList)localObject1);
      this.s.setTextColor((ColorStateList)localObject1);
      this.s.setBackgroundResource(2130851519);
      this.v.setVisibility(0);
      this.r.setVisibility(0);
      this.v.setPadding(i1, i1, i1, i1);
      this.r.setPadding(i1, i1, i1, i1);
      this.r.setImageDrawable(ImageUtil.a(2130848995, getQBaseActivity()));
      this.v.setImageDrawable(ImageUtil.a(2130848996, getQBaseActivity()));
      this.v.setOnClickListener(this);
      this.r.setOnClickListener(this);
      i1 = AIOUtils.b(4.0F, getResources());
      ((RelativeLayout.LayoutParams)this.v.getLayoutParams()).rightMargin = i1;
    }
    else
    {
      this.u.setText(HardCodeUtil.a(2131911411));
      this.u.setVisibility(0);
      this.u.setOnClickListener(this);
    }
    b();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return;
    }
    if ((paramInt == 1) && (localObject != null))
    {
      ((ImageView)localObject).setVisibility(0);
      this.z = new RedTouch(getQBaseActivity(), this.r);
      this.z.c(53);
      this.z.a();
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      this.z.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      this.z.setVisibility(0);
      return;
    }
    this.z.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 0) && (this.l == 1))
    {
      this.l = 0;
      localObject = this.j;
      if (localObject != null) {
        ((SwipListView)localObject).setVisibility(8);
      }
    }
    else if ((paramInt1 == 1) && (this.l == 0))
    {
      this.l = 1;
      localObject = this.j;
      if (localObject == null)
      {
        a(LayoutInflater.from(getQBaseActivity()));
        localObject = (RelativeLayout)this.webView.getParent();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.topMargin = paramInt2;
        ((RelativeLayout)localObject).addView(this.j, localLayoutParams);
      }
      else
      {
        ((RelativeLayout.LayoutParams)((SwipListView)localObject).getLayoutParams()).topMargin = paramInt2;
        this.j.setVisibility(0);
        this.k.a(this.f);
        this.j.requestLayout();
      }
      localObject = this.o;
      if (localObject != null) {
        ((View)localObject).bringToFront();
      }
    }
    else if (paramInt1 == 1)
    {
      localObject = this.j;
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)((SwipListView)localObject).getLayoutParams()).topMargin = paramInt2;
        this.j.requestLayout();
      }
    }
  }
  
  void a(LayoutInflater paramLayoutInflater)
  {
    this.j = ((SwipListView)paramLayoutInflater.inflate(2131626018, null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131628313, null);
    paramLayoutInflater.findViewById(2131429860).setOnClickListener(new ShopWebViewFragment.1(this));
    if (this.a)
    {
      localObject = paramLayoutInflater.findViewById(2131447717);
      View localView = paramLayoutInflater.findViewById(2131429860);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      if (localView != null) {
        localView.setBackgroundResource(2130848985);
      }
      localObject = (TextView)paramLayoutInflater.findViewById(2131430057);
      ((TextView)localObject).setTextColor(Color.parseColor("#FF000000"));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838997, 0);
      paramLayoutInflater.findViewById(2131432003).setBackgroundColor(Color.parseColor("#FFF9F9FB"));
      this.j.setBackgroundResource(2131166980);
    }
    this.j.addHeaderView(paramLayoutInflater);
    this.k = new ShopFolderAdapter(getQBaseActivity(), this.j, this.g, this.h[0]);
    this.j.setAdapter(this.k);
    this.k.a(this.f);
    this.k.a(this.i);
    this.j.setDragEnable(true);
    if ((getQBaseActivity() instanceof SwipListView.RightIconMenuListener)) {
      this.j.setRightIconMenuListener((SwipListView.RightIconMenuListener)getQBaseActivity());
    }
    if (!this.a) {
      return;
    }
    paramLayoutInflater = new JSONObject();
    Object localObject = new JSONObject();
    this.j.setOnTouchListener(new ShopWebViewFragment.2(this, paramLayoutInflater, (JSONObject)localObject));
  }
  
  void b()
  {
    Object localObject1 = this.s;
    if (localObject1 != null)
    {
      TextView localTextView = this.q;
      if (localTextView != null)
      {
        if (localTextView == null) {
          return;
        }
        if ((this.c) && (!this.a))
        {
          ((TextView)localObject1).setVisibility(8);
          this.p.setVisibility(0);
          this.q.setVisibility(0);
          localTextView = this.q;
        }
        else
        {
          this.s.setVisibility(0);
          this.p.setVisibility(8);
          this.q.setVisibility(8);
          localTextView = this.s;
        }
        if (localTextView != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.e);
          localObject1 = ((StringBuilder)localObject1).toString();
          if ((this.c) && (!this.a))
          {
            if (this.e > 99) {
              localObject1 = "99+";
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(getString(2131917002));
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(this.e);
            ((StringBuilder)localObject1).append(")");
            localObject1 = ((StringBuilder)localObject1).toString();
            if (this.e > 99)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(getString(2131917002));
              ((StringBuilder)localObject1).append("(99+)");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          Object localObject2 = localObject1;
          if (this.e <= 0)
          {
            localObject2 = localObject1;
            if (!this.d)
            {
              localObject1 = getString(2131917002);
              localObject2 = localObject1;
              if (this.c)
              {
                localObject2 = localObject1;
                if (!this.a)
                {
                  localTextView.setVisibility(8);
                  return;
                }
              }
            }
          }
          localObject1 = localTextView;
          if (this.d)
          {
            if (this.a)
            {
              this.p.setVisibility(8);
            }
            else
            {
              this.p.setVisibility(0);
              this.s.setVisibility(0);
              this.q.setVisibility(8);
              localTextView = this.s;
              localTextView.setBackgroundResource(0);
            }
            localObject2 = getResources().getString(2131887625);
            localObject1 = localTextView;
          }
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (!this.a)
    {
      int i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.webViewSurface.a(new View(super.getActivity()));
      getWebTitleBarInterface().l().setId(2131446329);
      getWebTitleBarInterface().l().setBackgroundResource(2130852228);
      paramBundle = new RelativeLayout.LayoutParams(-1, i1);
      paramBundle.addRule(10, -1);
      this.contentView.addView(getWebTitleBarInterface().l(), paramBundle);
      LayoutInflater.from(getQBaseActivity()).inflate(2131624346, this.contentView);
      this.w = ((ViewGroup)this.contentView.findViewById(2131444897));
      this.w.setBackgroundResource(2130852228);
      ((RelativeLayout.LayoutParams)this.w.getLayoutParams()).topMargin = i1;
      this.s = ((TextView)this.w.findViewById(2131436180));
      this.s.setOnClickListener(this);
      this.t = ((TextView)this.w.findViewById(2131436227));
      this.u = ((TextView)this.w.findViewById(2131436211));
      this.v = ((ImageView)this.w.findViewById(2131436194));
      this.u.setOnClickListener(this);
      this.v.setOnClickListener(this);
      paramBundle = this.w.findViewById(2131438587);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      a();
      return true;
    }
    return super.doOnCreate(paramBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ShopWebViewFragment.3(this, this.webViewSurface);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.i.getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131449123))
    {
      paramDragFrameLayout = (RecentShopParcel)paramDragFrameLayout.getDragView().getTag(2131442952);
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout.g = 0;
        Intent localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", paramDragFrameLayout.a);
        localIntent.putExtra("needDelete", false);
        getQBaseActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      break;
    case 2131436199: 
    case 2131436211: 
      if (this.webView != null)
      {
        localObject = WebViewPlugin.toJsScript("onEnterUserInfo", new JSONObject(), new JSONObject());
        this.webView.callJs((String)localObject);
      }
      localObject = this.z;
      if (localObject != null) {
        ((RedTouch)localObject).g();
      }
      this.g.b(getQBaseActivity(), this.h[3]);
    }
    try
    {
      this.g.f.a(134248547, null, null, null, null, 0L, false);
    }
    catch (Exception localException)
    {
      label213:
      break label213;
    }
    if (this.webView != null)
    {
      localObject = WebViewPlugin.toJsScript("onSearchBtnClick", new JSONObject(), new JSONObject());
      this.webView.callJs((String)localObject);
      break label213;
      if (getQBaseActivity() != null) {
        getQBaseActivity().doOnBackPressed();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    this.g = new EcshopCacheTool((AppInterface)getAppRuntime(), this);
    boolean bool1 = this.intent.hasExtra("bundle");
    int i1 = 0;
    long l1;
    if (bool1)
    {
      paramBundle = this.intent.getBundleExtra("bundle");
      paramBundle.setClassLoader(RecentShopParcel.class.getClassLoader());
      this.a = paramBundle.getBoolean("is_tab_show", false);
      l1 = 0L;
      long l2 = paramBundle.getLong("click_time", 0L);
      bool1 = paramBundle.getBoolean("is_tool_exist", false);
      if (l2 != 0L) {
        l1 = System.currentTimeMillis() - l2;
      }
      this.h = paramBundle.getStringArray("urls");
      this.f = paramBundle.getParcelableArrayList("datas");
      this.b = paramBundle.getBoolean("hasUnread", false);
      this.e = paramBundle.getInt("unReadNum", 0);
      this.c = paramBundle.getBoolean("isDefaultTheme", true);
      this.d = paramBundle.getBoolean("from_search", false);
      paramBundle = this.g;
      boolean bool2 = this.a;
      paramBundle.g = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramBundle.f.a(134248544, null, null, null, null, 0L, false);
        localObject = this.g.f;
        if (!bool1) {
          break label378;
        }
        paramBundle = "1";
        ((EcshopReportHandler)localObject).a(134248552, null, paramBundle, String.valueOf(l1), null, 0L, false);
      }
      catch (Exception paramBundle)
      {
        try
        {
          getActivity().registerReceiver(this.x, paramBundle);
          paramBundle = this.g;
          Object localObject = getAppRuntime();
          if (this.f != null) {
            i1 = this.f.size();
          }
          paramBundle.a((AppRuntime)localObject, i1);
          return;
        }
        catch (Exception paramBundle)
        {
          return;
        }
        paramBundle = paramBundle;
        continue;
      }
      this.i = DragFrameLayout.a(getQBaseActivity());
      this.i.a(this, false);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_decode_finish");
      paramBundle.addAction("action_on_shop_msg_receive");
      label378:
      paramBundle = "0";
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!this.a)
    {
      this.l = 1;
      a(LayoutInflater.from(getQBaseActivity()));
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(3, 2131444932);
      this.contentView.addView(this.j, paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getQBaseActivity().unregisterReceiver(this.x);
      label15:
      Object localObject = this.k;
      if (localObject != null)
      {
        ((ShopFolderAdapter)localObject).a();
        this.k = null;
      }
      localObject = this.g;
      if (localObject != null) {
        ((EcshopCacheTool)localObject).a();
      }
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i3 = Build.VERSION.SDK_INT;
      int i2 = 1;
      int i1 = 1;
      if (i3 >= 23)
      {
        if (getQBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          i1 = 0;
        }
        i2 = i1;
        if (i1 == 0)
        {
          getQBaseActivity().requestPermissions("android.permission.ACCESS_FINE_LOCATION", 10, new String[0]);
          i2 = i1;
        }
      }
      if (i2 != 0) {
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.y);
      }
      localObject = this.k;
      if (localObject != null) {
        ((ShopFolderAdapter)localObject).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment
 * JD-Core Version:    0.7.0.1
 */