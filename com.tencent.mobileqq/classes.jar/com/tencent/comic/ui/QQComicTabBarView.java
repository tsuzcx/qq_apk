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
  static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  static final Map<String, String> jdField_b_of_type_JavaUtilMap;
  static final Map<String, String> jdField_c_of_type_JavaUtilMap;
  final float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public final Paint a;
  Handler jdField_a_of_type_AndroidOsHandler = new QQComicTabBarView.1(this, Looper.getMainLooper());
  SparseArray<RedAppInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  IQQComicRedTouchService jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService = null;
  QQComicRedTouchServiceImpl.PluginRedTouchObserver jdField_a_of_type_ComTencentComicApiImplQQComicRedTouchServiceImpl$PluginRedTouchObserver = new QQComicTabBarView.2(this);
  QQComicDownloadCountObserver jdField_a_of_type_ComTencentComicJspQQComicDownloadCountObserver = new QQComicTabBarView.3(this);
  final SimpleBiMap<String, RedTouchUI> jdField_a_of_type_ComTencentComicUtilsSimpleBiMap = new SimpleBiMap();
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  public TabBarView.OnTabChangeListener a;
  List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  final int jdField_b_of_type_Int;
  public final Paint b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  final SimpleBiMap<String, String> jdField_b_of_type_ComTencentComicUtilsSimpleBiMap = new SimpleBiMap();
  boolean jdField_b_of_type_Boolean = true;
  final int jdField_c_of_type_Int;
  public final Paint c;
  final int d;
  final int e;
  final int f;
  int g = 0;
  int h = -1;
  int i = -1;
  int j = -1;
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put("index", "1113.100800");
    jdField_a_of_type_JavaUtilMap.put("fav", "1113.100801");
    jdField_a_of_type_JavaUtilMap.put("category", "1113.100804");
    jdField_a_of_type_JavaUtilMap.put("more", "1113.100802");
    jdField_a_of_type_JavaUtilMap.put("group", "1113.100803");
    jdField_b_of_type_JavaUtilMap = new HashMap(5);
    jdField_c_of_type_JavaUtilMap = new HashMap(5);
    jdField_b_of_type_JavaUtilMap.put("index", "200458");
    jdField_b_of_type_JavaUtilMap.put("fav", "200459");
    jdField_b_of_type_JavaUtilMap.put("category", "200460");
    jdField_b_of_type_JavaUtilMap.put("more", "200461");
    jdField_b_of_type_JavaUtilMap.put("group", "200462");
    jdField_c_of_type_JavaUtilMap.put("index", "100");
    jdField_c_of_type_JavaUtilMap.put("fav", "102");
    jdField_c_of_type_JavaUtilMap.put("category", "101");
    jdField_c_of_type_JavaUtilMap.put("more", "103");
    jdField_c_of_type_JavaUtilMap.put("group", "104");
  }
  
  public QQComicTabBarView(Context paramContext)
  {
    super(paramContext);
    paramContext = super.getContext().getResources();
    this.jdField_b_of_type_Int = -8947849;
    this.jdField_a_of_type_Int = -14629889;
    this.jdField_a_of_type_Float = TypedValue.applyDimension(2, 17.0F, paramContext.getDisplayMetrics());
    this.jdField_c_of_type_Int = -14629889;
    this.d = ((int)TypedValue.applyDimension(1, 6.0F, paramContext.getDisplayMetrics()));
    this.e = -8947849;
    this.f = ((int)TypedValue.applyDimension(1, 54.0F, paramContext.getDisplayMetrics()));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
    paramContext.weight = 1.0F;
    paramContext.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
    int k = this.f;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(k, k);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(13);
    ThreadManager.post(new QQComicTabBarView.4(this), 5, null, false);
    setLayerType(2, null);
  }
  
  static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramAppInterface != null)
    {
      String str = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
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
    Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    float f1 = paramFloat;
    if (localInterpolator != null) {
      f1 = localInterpolator.getInterpolation(paramFloat);
    }
    return f1;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public View a()
  {
    return this;
  }
  
  public View a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(super.getContext());
      SimpleTextView localSimpleTextView = new SimpleTextView(super.getContext());
      localSimpleTextView.setText(paramString2);
      localSimpleTextView.setTextSize(0, this.jdField_a_of_type_Float);
      localSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
      localSimpleTextView.setContentDescription(paramString2);
      localSimpleTextView.setGravity(17);
      QQComicTabBarView.ViewHolder localViewHolder = new QQComicTabBarView.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView = localSimpleTextView;
      localRelativeLayout.setTag(-3, localViewHolder);
      localRelativeLayout.setOnClickListener(new QQComicTabBarView.MyOnClickListener(this, paramInt, this.jdField_a_of_type_Boolean ^ true, this.jdField_a_of_type_JavaUtilList));
      localRelativeLayout.addView(localSimpleTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      if (this.jdField_a_of_type_Boolean)
      {
        ImageView localImageView = new ImageView(super.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        File localFile = new File(paramString3);
        ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(17170445));
        boolean bool1 = this.jdField_b_of_type_Boolean;
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
          paramString3 = VasApngUtil.getApngDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString3, "-comic-tab-bar-", localColorDrawable, new int[] { 12 }, "-comic-tab-bar-", localBundle);
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
          localViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramString3;
          bool1 = bool2;
        }
        if (!bool1)
        {
          paramString3 = URLDrawable.URLDrawableOptions.obtain();
          paramString3.mLoadingDrawable = localColorDrawable;
          paramString3.mFailedDrawable = localColorDrawable;
          localViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localFile, paramString3);
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localRelativeLayout.addView(localImageView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        localImageView.setVisibility(8);
      }
      super.addView(localRelativeLayout, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      if (jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        paramString1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString1);
        paramString3 = (RedTouchUI)new RedTouchUI(super.getContext(), localSimpleTextView).b(5).a();
        paramString3.setRedpointImgResID(2130850766);
        paramString3.setTextOrNumImgRedID(2130850770);
        this.jdField_b_of_type_ComTencentComicUtilsSimpleBiMap.put(paramString1, a(paramString1, 0));
        this.jdField_a_of_type_ComTencentComicUtilsSimpleBiMap.put(paramString1, paramString3);
        localViewHolder.jdField_a_of_type_ComTencentComicUiRedTouchUI = paramString3;
      }
      if (AppSetting.d) {
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
    int k;
    if (paramInt == 0)
    {
      k = 100000000;
      localStringBuilder.append(100600);
      localStringBuilder.append('.');
    }
    else
    {
      if (paramInt != 1) {
        break label270;
      }
      k = -100000000;
    }
    boolean bool = paramString.contains(".");
    int i1 = 0;
    int n;
    if (bool)
    {
      paramString = paramString.split("\\.");
      n = i1;
      if (paramString.length <= 0) {
        break label192;
      }
      int i2 = paramString.length;
      n = 0;
      int m = 0;
      for (;;)
      {
        if (n < i2)
        {
          String str = paramString[n];
          try
          {
            localStringBuilder.append(Integer.parseInt(str) + k);
            localStringBuilder.append('.');
            m += 1;
            n += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
      n = i1;
      if (m != paramString.length) {
        break label192;
      }
    }
    try
    {
      localStringBuilder.append(Integer.parseInt(paramString) + k);
      n = 1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      n = i1;
    }
    label192:
    if (n != 0)
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
          RedTouchUI localRedTouchUI = ((QQComicTabBarView.ViewHolder)localObject1).jdField_a_of_type_ComTencentComicUiRedTouchUI;
          if ((localRedTouchUI != null) && (!localRedTouchUI.c()))
          {
            localObject1 = (RedAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
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
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_b_of_type_Int);
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof QQComicTabBarView.ViewHolder)) {
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_a_of_type_Int);
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
      localObject = ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentComicUiRedTouchUI;
      if (localObject == null) {
        return;
      }
      ((RedTouchUI)localObject).d();
      if ((paramBoolean) && (QQComicPluginBridge.a != null)) {
        QQComicPluginBridge.a.a();
      }
    }
  }
  
  public void a(Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
    int k;
    if (paramIntent != null)
    {
      k = paramIntent.getIntExtra("key_maintab", -1);
      paramIntent.removeExtra("key_maintab");
    }
    else
    {
      k = -1;
    }
    boolean bool2 = DeviceInfoUtil.h();
    boolean bool1 = true;
    if ((bool2) || (VipComicDataHelper.a.optInt("navSwitchAnimation", 1) != 1)) {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramList != null)
    {
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext()) {
        if (TextUtils.isEmpty(((WebViewTabBarData)paramIntent.next()).tabIcon)) {
          this.jdField_a_of_type_Boolean = false;
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
    if (k != -1)
    {
      this.g = k;
      b(this.j, this.g);
      this.i = this.g;
      this.j = this.i;
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
    if ((paramRedTouchUI != null) && (paramRedAppInfo != null) && (paramRedAppInfo.a() != null))
    {
      if (paramRedAppInfo.a().a() == null) {
        return;
      }
      if ((paramBoolean) && (paramRedTouchUI.a != null)) {
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      Iterator localIterator = paramRedAppInfo.a().a().iterator();
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
      paramRedAppInfo.a().a(localArrayList);
      paramRedTouchUI.a(paramRedAppInfo);
    }
  }
  
  void b()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentComicUtilsSimpleBiMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (RedTouchUI)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null) && (((RedTouchUI)localObject).c()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
          if ("1113.100800".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "100" });
          } else if ("1113.100801".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "102" });
          } else if ("1113.100802".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "103" });
          } else if ("1113.100803".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "104" });
          } else if ("1113.100804".equals(str)) {
            ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "1", "30012", "", new String[] { "101" });
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
      localObject1 = ((QQComicTabBarView.ViewHolder)localObject1).jdField_a_of_type_ComTencentComicUiRedTouchUI;
      if (localObject1 != null)
      {
        if (!((RedTouchUI)localObject1).c()) {
          return;
        }
        ((RedTouchUI)localObject1).d();
        Object localObject2 = (String)this.jdField_a_of_type_ComTencentComicUtilsSimpleBiMap.a(localObject1);
        IQQComicRedTouchService localIQQComicRedTouchService = this.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService;
        if (localIQQComicRedTouchService != null)
        {
          localIQQComicRedTouchService.reportRedTouchClick((String)localObject2);
          this.jdField_a_of_type_ComTencentComicApiIQQComicRedTouchService.reportRedTouchClick((String)this.jdField_b_of_type_ComTencentComicUtilsSimpleBiMap.get(localObject2));
        }
        localObject2 = (RedAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if ((localObject2 != null) && (((RedTouchUI)localObject1).a == localObject2)) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          localObject1 = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "3014", "2", "40049", "", new String[] { (String)jdField_c_of_type_JavaUtilMap.get(((WebViewTabBarData)localObject1).tag) });
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
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(0);
        ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
        if ((((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView != null))
        {
          ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(8);
          URLDrawable localURLDrawable = ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
          ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((QQComicTabBarView.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
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
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramCanvas);
      return;
    }
    View localView1 = super.getChildAt(this.i);
    View localView2 = super.getChildAt(this.h);
    if ((localView1 != null) && (localView2 != null))
    {
      int n = localView1.getLeft();
      int k = localView1.getRight();
      if (this.jdField_b_of_type_Float > 0.0F)
      {
        boolean bool;
        if (this.i < this.h) {
          bool = true;
        } else {
          bool = false;
        }
        k = (int)(localView1.getLeft() + a(this.jdField_b_of_type_Float, bool) * (localView2.getLeft() - localView1.getLeft()));
        m = (int)(localView1.getRight() + a(this.jdField_b_of_type_Float, bool ^ true) * (localView2.getRight() - localView1.getRight()));
        n = k;
      }
      else
      {
        m = k;
      }
      paramCanvas.drawRect(n, super.getHeight() - this.d, m, super.getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
      k = (localView2.getLeft() + localView2.getRight()) / 2;
      int m = (localView2.getTop() + localView2.getBottom()) / 2;
      float f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)((1.0F - this.jdField_b_of_type_Float) * 96.0F));
      paramCanvas.drawCircle(k, m, f1 * 1.2F * this.jdField_b_of_type_Float, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    a(paramCanvas);
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
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    super.setMeasuredDimension(super.getMeasuredWidth(), this.f);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    int m = super.getChildCount();
    paramInt = k;
    if (k >= m) {
      paramInt = m - 1;
    }
    k = this.i;
    if (k != paramInt)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener;
      if (localObject != null) {
        ((TabBarView.OnTabChangeListener)localObject).onTabSelected(k, paramInt);
      }
      if (this.jdField_a_of_type_Boolean) {
        b(this.j, paramInt);
      }
      if (paramBoolean)
      {
        this.h = paramInt;
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      else
      {
        this.h = paramInt;
        this.jdField_b_of_type_Float = 1.0F;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      this.j = this.h;
      localObject = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((WebViewTabBarData)localObject).tag, false);
      b(paramInt);
      paramBoolean = bool;
      if (paramInt == VipComicJumpActivity.getIndexByTag("fav", this.jdField_a_of_type_JavaUtilList)) {
        paramBoolean = true;
      }
      a(paramInt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView
 * JD-Core Version:    0.7.0.1
 */