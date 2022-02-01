package com.tencent.comic.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.api.impl.QQComicRedTouchServiceImpl.PluginRedTouchObserver;
import com.tencent.comic.api.impl.QQDcReporterImpl;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.jsp.QQComicDownloadCountObserver;
import com.tencent.comic.jsp.QQComicDownloadObserverProxy;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.SimpleBiMap;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.IWebViewTabBar;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@KeepClassConstructor
public class QQComicTabBarView
  extends LinearLayout
  implements IWebViewTabBar
{
  static final Map<String, String> a = new HashMap();
  static final Map<String, String> b;
  static final Map<String, String> c;
  boolean A = true;
  LinearLayout.LayoutParams B;
  RelativeLayout.LayoutParams C;
  RelativeLayout.LayoutParams D;
  Interpolator E = new AccelerateDecelerateInterpolator();
  Handler F = new QQComicTabBarView.1(this, Looper.getMainLooper());
  IQQComicRedTouchService G = null;
  QQComicRedTouchServiceImpl.PluginRedTouchObserver H = new QQComicTabBarView.2(this);
  QQComicDownloadCountObserver I = new QQComicTabBarView.3(this);
  SparseArray<RedAppInfo> d = new SparseArray();
  final SimpleBiMap<String, RedTouchUI> e = new SimpleBiMap();
  final SimpleBiMap<String, String> f = new SimpleBiMap();
  List<WebViewTabBarData> g;
  AppInterface h = null;
  public final Paint i;
  public final Paint j;
  public final Paint k;
  final int l;
  final int m;
  final int n;
  final int o;
  final int p;
  final float q;
  final int r;
  public TabBarView.OnTabChangeListener s;
  long t = 0L;
  float u;
  int v = 0;
  int w = -1;
  int x = -1;
  int y = -1;
  boolean z = true;
  
  static
  {
    a.put("index", "1113.100800");
    a.put("fav", "1113.100801");
    a.put("category", "1113.100804");
    a.put("more", "1113.100802");
    a.put("group", "1113.100803");
    b = new HashMap(5);
    c = new HashMap(5);
    b.put("index", "200458");
    b.put("fav", "200459");
    b.put("category", "200460");
    b.put("more", "200461");
    b.put("group", "200462");
    c.put("index", "100");
    c.put("fav", "102");
    c.put("category", "101");
    c.put("more", "103");
    c.put("group", "104");
  }
  
  public QQComicTabBarView(Context paramContext)
  {
    super(paramContext);
    paramContext = super.getContext().getResources();
    this.m = -8947849;
    this.l = -14629889;
    this.q = TypedValue.applyDimension(2, 17.0F, paramContext.getDisplayMetrics());
    this.n = -14629889;
    this.o = ((int)TypedValue.applyDimension(1, 6.0F, paramContext.getDisplayMetrics()));
    this.p = -8947849;
    this.r = ((int)TypedValue.applyDimension(1, 54.0F, paramContext.getDisplayMetrics()));
    this.i = new Paint(1);
    this.j = new Paint();
    this.j.setColor(this.n);
    this.k = new Paint();
    this.k.setColor(this.p);
    this.B = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.B;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    this.C = new RelativeLayout.LayoutParams(-1, -1);
    this.C.addRule(13);
    int i1 = this.r;
    this.D = new RelativeLayout.LayoutParams(i1, i1);
    this.D.addRule(13);
    ThreadManager.post(new QQComicTabBarView.4(this), 5, null, false);
    setLayerType(2, null);
  }
  
  static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramAppInterface != null)
    {
      String str = (String)b.get(paramString);
      if (!TextUtils.isEmpty(str))
      {
        IQQDcReporter localIQQDcReporter = (IQQDcReporter)QRoute.api(IQQDcReporter.class);
        if (paramBoolean) {
          paramString = "1";
        } else {
          paramString = "";
        }
        localIQQDcReporter.reportDC00145_3(paramAppInterface, "3071", "2", str, "", "", "", "", "", "", paramString, new String[0]);
      }
    }
  }
  
  float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramFloat < 0.6F) {
        paramFloat = 0.0F;
      } else {
        paramFloat = (paramFloat - 0.6F) / 0.4F;
      }
    }
    else if (paramFloat < 0.6F) {
      paramFloat /= 0.6F;
    } else {
      paramFloat = 1.0F;
    }
    Interpolator localInterpolator = this.E;
    float f1 = paramFloat;
    if (localInterpolator != null) {
      f1 = localInterpolator.getInterpolation(paramFloat);
    }
    return f1;
  }
  
  public View a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(super.getContext());
      SimpleTextView localSimpleTextView = new SimpleTextView(super.getContext());
      localSimpleTextView.setText(paramString2);
      localSimpleTextView.setTextSize(0, this.q);
      localSimpleTextView.setTextColor(this.m);
      localSimpleTextView.setContentDescription(paramString2);
      localSimpleTextView.setGravity(17);
      QQComicTabBarView.ViewHolder localViewHolder = new QQComicTabBarView.ViewHolder(this);
      localViewHolder.a = localSimpleTextView;
      localRelativeLayout.setTag(-3, localViewHolder);
      localRelativeLayout.setOnClickListener(new QQComicTabBarView.MyOnClickListener(this, paramInt, this.z ^ true, this.g));
      localRelativeLayout.addView(localSimpleTextView, this.C);
      if (this.z)
      {
        ImageView localImageView = new ImageView(super.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        File localFile = new File(paramString3);
        ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(17170445));
        boolean bool1 = this.A;
        boolean bool2;
        if (bool1) {
          try
          {
            bool2 = ApngDrawable.isApngFile(localFile);
            bool1 = bool2;
          }
          catch (IOException localIOException)
          {
            QLog.e("WebViewTabBarView", 1, localIOException, new Object[0]);
          }
        }
        if (bool1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putFloat("key_frame_delay_fraction", 0.6F);
          paramString3 = VasApngUtil.getApngDrawable(this.h, paramString3, "-comic-tab-bar-", localColorDrawable, new int[] { 12 }, "-comic-tab-bar-", localBundle);
          if (paramString3 != null)
          {
            bool2 = bool1;
            if (!ApngImage.canDecodeIDs.contains(Integer.valueOf(12)))
            {
              ApngImage.canDecodeIDs.add(Integer.valueOf(12));
              bool2 = bool1;
            }
          }
          else
          {
            bool2 = false;
          }
          localViewHolder.c = paramString3;
          bool1 = bool2;
        }
        if (!bool1)
        {
          paramString3 = URLDrawable.URLDrawableOptions.obtain();
          paramString3.mLoadingDrawable = localColorDrawable;
          paramString3.mFailedDrawable = localColorDrawable;
          localViewHolder.c = URLDrawable.getDrawable(localFile, paramString3);
        }
        localViewHolder.b = localImageView;
        localRelativeLayout.addView(localImageView, this.D);
        localImageView.setVisibility(8);
      }
      super.addView(localRelativeLayout, paramInt, this.B);
      if (a.containsKey(paramString1))
      {
        paramString1 = (String)a.get(paramString1);
        paramString3 = (RedTouchUI)new RedTouchUI(super.getContext(), localSimpleTextView).c(5).a();
        paramString3.setRedpointImgResID(2130852588);
        paramString3.setTextOrNumImgRedID(2130852592);
        this.f.put(paramString1, a(paramString1, 0));
        this.e.put(paramString1, paramString3);
        localViewHolder.d = paramString3;
      }
      if (AppSetting.e) {
        localRelativeLayout.setContentDescription(paramString2);
      }
      return localSimpleTextView;
    }
    throw new IllegalArgumentException("position is not legal, please check!");
  }
  
  public String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = QQDcReporterImpl.obtainStringBuilder();
    int i1;
    if (paramInt == 0)
    {
      i1 = 100000000;
      localStringBuilder.append(100600);
      localStringBuilder.append('.');
    }
    else
    {
      if (paramInt != 1) {
        break label270;
      }
      i1 = -100000000;
    }
    boolean bool = paramString.contains(".");
    int i4 = 0;
    int i3;
    if (bool)
    {
      paramString = paramString.split("\\.");
      i3 = i4;
      if (paramString.length <= 0) {
        break label192;
      }
      int i5 = paramString.length;
      i3 = 0;
      int i2 = 0;
      for (;;)
      {
        if (i3 < i5)
        {
          String str = paramString[i3];
          try
          {
            localStringBuilder.append(Integer.parseInt(str) + i1);
            localStringBuilder.append('.');
            i2 += 1;
            i3 += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
      i3 = i4;
      if (i2 != paramString.length) {
        break label192;
      }
    }
    try
    {
      localStringBuilder.append(Integer.parseInt(paramString) + i1);
      i3 = 1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      i3 = i4;
    }
    label192:
    if (i3 != 0)
    {
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == '.')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (paramInt == 1)
      {
        paramInt = localStringBuilder.indexOf(".");
        if (paramInt < 0) {
          return null;
        }
        return localStringBuilder.substring(paramInt + 1);
      }
      return localStringBuilder.toString();
    }
    label270:
    return null;
  }
  
  void a()
  {
    ThreadManager.postImmediately(new QQComicTabBarView.7(this), null, false);
  }
  
  void a(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < super.getChildCount())
        {
          Object localObject1 = super.getChildAt(paramInt).getTag(-3);
          boolean bool = localObject1 instanceof QQComicTabBarView.ViewHolder;
          if (!bool) {
            return;
          }
          RedTouchUI localRedTouchUI = ((QQComicTabBarView.ViewHolder)localObject1).d;
          if ((localRedTouchUI != null) && (!localRedTouchUI.h()))
          {
            localObject1 = (RedAppInfo)this.d.get(paramInt);
            if (localObject1 == null)
            {
              localObject1 = new RedAppInfo();
              ((RedAppInfo)localObject1).a(1113);
              ((RedAppInfo)localObject1).b(1);
              ((RedAppInfo)localObject1).c(0);
              RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
              RedTypeInfo localRedTypeInfo = new RedTypeInfo();
              localRedTypeInfo.setRedType(0);
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localRedTypeInfo);
              localRedDisplayInfo.a(localArrayList);
              ((RedAppInfo)localObject1).a(localRedDisplayInfo);
              this.d.put(paramInt, localObject1);
            }
            else
            {
              ((RedAppInfo)localObject1).b(1);
            }
            a(localRedTouchUI, (RedAppInfo)localObject1, true);
            return;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder)) {
        ((QQComicTabBarView.ViewHolder)localObject).a.setTextColor(this.m);
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder)) {
        ((QQComicTabBarView.ViewHolder)localObject).a.setTextColor(this.l);
      }
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= super.getChildCount()) {
        return;
      }
      Object localObject = super.getChildAt(paramInt).getTag(-3);
      if (!(localObject instanceof QQComicTabBarView.ViewHolder)) {
        return;
      }
      localObject = ((QQComicTabBarView.ViewHolder)localObject).d;
      if (localObject == null) {
        return;
      }
      ((RedTouchUI)localObject).g();
      if ((paramBoolean) && (QQComicPluginBridge.c != null)) {
        QQComicPluginBridge.c.a();
      }
    }
  }
  
  public void a(Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.s = paramOnTabChangeListener;
    int i1;
    if (paramIntent != null)
    {
      i1 = paramIntent.getIntExtra("key_maintab", -1);
      paramIntent.removeExtra("key_maintab");
    }
    else
    {
      i1 = -1;
    }
    boolean bool2 = DeviceInfoUtil.U();
    boolean bool1 = true;
    if ((bool2) || (VipComicDataHelper.p.optInt("navSwitchAnimation", 1) != 1)) {
      bool1 = false;
    }
    this.A = bool1;
    this.g = paramList;
    if (paramList != null)
    {
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext()) {
        if (TextUtils.isEmpty(((WebViewTabBarData)paramIntent.next()).tabIcon)) {
          this.z = false;
        }
      }
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext())
      {
        paramList = (WebViewTabBarData)paramIntent.next();
        a(super.getChildCount(), paramList.tag, paramList.tabName, paramList.tabIcon);
      }
    }
    super.setVisibility(0);
    a();
    if (i1 != -1)
    {
      this.v = i1;
      b(this.y, this.v);
      this.x = this.v;
      this.y = this.x;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      paramCanvas.drawColor(-2147483648);
    }
  }
  
  void a(RedTouchUI paramRedTouchUI, RedAppInfo paramRedAppInfo, boolean paramBoolean)
  {
    if ((paramRedTouchUI != null) && (paramRedAppInfo != null) && (paramRedAppInfo.o() != null))
    {
      if (paramRedAppInfo.o().a() == null) {
        return;
      }
      if ((paramBoolean) && (paramRedTouchUI.a != null)) {
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      Iterator localIterator = paramRedAppInfo.o().a().iterator();
      while (localIterator.hasNext())
      {
        RedTypeInfo localRedTypeInfo = (RedTypeInfo)localIterator.next();
        if (localRedTypeInfo.getRedType() != 9)
        {
          if ((localRedTypeInfo.getRedType() == 3) || (localRedTypeInfo.getRedType() == 4)) {
            localRedTypeInfo.setRedType(0);
          }
          if (localRedTypeInfo.getRedType() == 0) {
            paramRedTouchUI.a(0, 13, 12, 0).a();
          } else {
            paramRedTouchUI.a(0, 8, 7, 0).a();
          }
          localArrayList.add(localRedTypeInfo);
        }
      }
      paramRedAppInfo.o().a(localArrayList);
      paramRedTouchUI.a(paramRedAppInfo);
    }
  }
  
  void b()
  {
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (RedTouchUI)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null) && (((RedTouchUI)localObject).h()) && (this.h != null)) {
          if ("1113.100800".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "1", "30012", "", new String[] { "100" });
          } else if ("1113.100801".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "1", "30012", "", new String[] { "102" });
          } else if ("1113.100802".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "1", "30012", "", new String[] { "103" });
          } else if ("1113.100803".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "1", "30012", "", new String[] { "104" });
          } else if ("1113.100804".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "1", "30012", "", new String[] { "101" });
          }
        }
      }
    }
  }
  
  void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= super.getChildCount()) {
        return;
      }
      Object localObject1 = super.getChildAt(paramInt).getTag(-3);
      if (!(localObject1 instanceof QQComicTabBarView.ViewHolder)) {
        return;
      }
      localObject1 = ((QQComicTabBarView.ViewHolder)localObject1).d;
      if (localObject1 != null)
      {
        if (!((RedTouchUI)localObject1).h()) {
          return;
        }
        ((RedTouchUI)localObject1).g();
        Object localObject2 = (String)this.e.a(localObject1);
        IQQComicRedTouchService localIQQComicRedTouchService = this.G;
        if (localIQQComicRedTouchService != null)
        {
          localIQQComicRedTouchService.reportRedTouchClick((String)localObject2);
          this.G.reportRedTouchClick((String)this.f.get(localObject2));
        }
        localObject2 = (RedAppInfo)this.d.get(paramInt);
        if ((localObject2 != null) && (((RedTouchUI)localObject1).a == localObject2)) {
          return;
        }
        if (this.h != null)
        {
          localObject1 = (WebViewTabBarData)this.g.get(paramInt);
          ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.h, "3014", "2", "40049", "", new String[] { (String)c.get(((WebViewTabBarData)localObject1).tag) });
        }
      }
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tab switch : old=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", new=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WebViewTabBarView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder))
      {
        localObject = (QQComicTabBarView.ViewHolder)localObject;
        ((QQComicTabBarView.ViewHolder)localObject).a.setVisibility(0);
        ((QQComicTabBarView.ViewHolder)localObject).b.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "tab icon hide.");
        }
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder))
      {
        localObject = (QQComicTabBarView.ViewHolder)localObject;
        if ((((QQComicTabBarView.ViewHolder)localObject).b != null) && (((QQComicTabBarView.ViewHolder)localObject).a != null))
        {
          ((QQComicTabBarView.ViewHolder)localObject).a.setVisibility(8);
          URLDrawable localURLDrawable = ((QQComicTabBarView.ViewHolder)localObject).c;
          ((QQComicTabBarView.ViewHolder)localObject).b.setVisibility(0);
          ((QQComicTabBarView.ViewHolder)localObject).b.setImageDrawable(localURLDrawable);
          if ((localURLDrawable != null) && ((localURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
          {
            ((ApngDrawable)localURLDrawable.getCurrDrawable()).repaly();
            if (QLog.isColorLevel()) {
              QLog.d("WebViewTabBarView", 2, "tab icon anim play.");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebViewTabBarView", 2, "tab icon show.");
          }
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.z)
    {
      a(paramCanvas);
      return;
    }
    View localView1 = super.getChildAt(this.x);
    View localView2 = super.getChildAt(this.w);
    if ((localView1 != null) && (localView2 != null))
    {
      int i3 = localView1.getLeft();
      int i1 = localView1.getRight();
      if (this.u > 0.0F)
      {
        boolean bool;
        if (this.x < this.w) {
          bool = true;
        } else {
          bool = false;
        }
        i1 = (int)(localView1.getLeft() + a(this.u, bool) * (localView2.getLeft() - localView1.getLeft()));
        i2 = (int)(localView1.getRight() + a(this.u, bool ^ true) * (localView2.getRight() - localView1.getRight()));
        i3 = i1;
      }
      else
      {
        i2 = i1;
      }
      paramCanvas.drawRect(i3, super.getHeight() - this.o, i2, super.getHeight(), this.j);
      i1 = (localView2.getLeft() + localView2.getRight()) / 2;
      int i2 = (localView2.getTop() + localView2.getBottom()) / 2;
      float f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.k.setAlpha((int)((1.0F - this.u) * 96.0F));
      paramCanvas.drawCircle(i1, i2, f1 * 1.2F * this.u, this.k);
    }
    a(paramCanvas);
  }
  
  public int getSelectedTabIndex()
  {
    return this.x;
  }
  
  public View getTabBarView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.5(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.6(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.r, 1073741824));
    super.setMeasuredDimension(super.getMeasuredWidth(), this.r);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    int i2 = super.getChildCount();
    paramInt = i1;
    if (i1 >= i2) {
      paramInt = i2 - 1;
    }
    i1 = this.x;
    if (i1 != paramInt)
    {
      Object localObject = this.s;
      if (localObject != null) {
        ((TabBarView.OnTabChangeListener)localObject).onTabSelected(i1, paramInt);
      }
      if (this.z) {
        b(this.y, paramInt);
      }
      if (paramBoolean)
      {
        this.w = paramInt;
        this.u = 0.0F;
        this.F.sendEmptyMessage(0);
      }
      else
      {
        this.w = paramInt;
        this.u = 1.0F;
        this.F.sendEmptyMessage(2);
      }
      this.y = this.w;
      localObject = (WebViewTabBarData)this.g.get(paramInt);
      a(this.h, ((WebViewTabBarData)localObject).tag, false);
      b(paramInt);
      paramBoolean = bool;
      if (paramInt == VipComicJumpActivity.getIndexByTag("fav", this.g)) {
        paramBoolean = true;
      }
      a(paramInt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView
 * JD-Core Version:    0.7.0.1
 */