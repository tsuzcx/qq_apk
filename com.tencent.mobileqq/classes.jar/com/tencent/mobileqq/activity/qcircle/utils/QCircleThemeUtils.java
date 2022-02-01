package com.tencent.mobileqq.activity.qcircle.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;

public class QCircleThemeUtils
{
  private static String a = "NIGHT_MODE";
  private static String b = "WHITE_DEFAULT_MODE";
  private static String c = "DARK_DEFAULT_MODE";
  private static String d = "WHITE_SIMPLE_MODE";
  private static String e = "DARK_SIMPLE_MODE";
  private static String f = "DARK_OTHER_MODE";
  private static String g = "WHITE_OTHER_MODE";
  private static String h = "com.tencent.mobileqq.activity.home.Conversation";
  private static String i = "com.tencent.mobileqq.activity.contacts.base.Contacts";
  private static String j = "com.tencent.mobileqq.leba.Leba";
  private static String k = "com.tencent.mobileqq.activity.leba.QzoneFrame";
  private static String l = "com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame";
  private static String m = "com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame";
  private static String n = "com.tencent.mobileqq.activity.qcircle.QCircleFrame";
  private static String o = "com.tencent.mobileqq.guild.mainframe.GuildMainFrame";
  private static FrameInitBean p;
  private static HashMap<String, HashMap<String, Pair<Integer, Integer>>> q = new HashMap(8);
  private static HashMap<String, String> r = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    String str = a;
    Integer localInteger1 = Integer.valueOf(2130848895);
    Integer localInteger2 = Integer.valueOf(2130852561);
    localHashMap.put(str, new Pair(localInteger1, localInteger2));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852558), Integer.valueOf(2130852560)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130848904), Integer.valueOf(2130852560)));
    localHashMap.put(g, new Pair(localInteger1, localInteger2));
    localHashMap.put(f, new Pair(localInteger1, localInteger2));
    localHashMap.put(d, new Pair(Integer.valueOf(2130852559), localInteger2));
    localHashMap.put(e, new Pair(localInteger1, localInteger2));
    q.put(FrameControllerUtil.l, localHashMap);
    r.put(FrameControllerUtil.l, h);
    localHashMap = new HashMap();
    str = a;
    localInteger1 = Integer.valueOf(2130852557);
    localHashMap.put(str, new Pair(Integer.valueOf(2130848892), localInteger1));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852554), Integer.valueOf(2130852556)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130848903), Integer.valueOf(2130848903)));
    localHashMap.put(g, new Pair(Integer.valueOf(2130848892), localInteger1));
    localHashMap.put(f, new Pair(Integer.valueOf(2130848892), localInteger1));
    localHashMap.put(d, new Pair(Integer.valueOf(2130852555), localInteger1));
    localHashMap.put(e, new Pair(Integer.valueOf(2130848892), localInteger1));
    q.put(FrameControllerUtil.m, localHashMap);
    r.put(FrameControllerUtil.m, i);
    localHashMap = new HashMap();
    str = a;
    localInteger1 = Integer.valueOf(2130852573);
    localHashMap.put(str, new Pair(Integer.valueOf(2130848893), localInteger1));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852570), Integer.valueOf(2130852572)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130848905), Integer.valueOf(2130852572)));
    localHashMap.put(g, new Pair(Integer.valueOf(2130848893), localInteger1));
    localHashMap.put(f, new Pair(Integer.valueOf(2130848893), localInteger1));
    localHashMap.put(d, new Pair(Integer.valueOf(2130852571), localInteger1));
    localHashMap.put(e, new Pair(Integer.valueOf(2130848893), localInteger1));
    q.put(FrameControllerUtil.o, localHashMap);
    r.put(FrameControllerUtil.o, j);
    localHashMap = new HashMap();
    str = a;
    localInteger1 = Integer.valueOf(2130852577);
    localHashMap.put(str, new Pair(Integer.valueOf(2130848891), localInteger1));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852574), Integer.valueOf(2130852576)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130848906), Integer.valueOf(2130852576)));
    localHashMap.put(g, new Pair(Integer.valueOf(2130848891), localInteger1));
    localHashMap.put(f, new Pair(Integer.valueOf(2130848891), localInteger1));
    localHashMap.put(d, new Pair(Integer.valueOf(2130852575), localInteger1));
    localHashMap.put(e, new Pair(Integer.valueOf(2130848891), localInteger1));
    q.put(FrameControllerUtil.q, localHashMap);
    r.put(FrameControllerUtil.q, l);
    localHashMap = new HashMap();
    str = a;
    localInteger1 = Integer.valueOf(2130852579);
    localHashMap.put(str, new Pair(localInteger1, Integer.valueOf(2130848896)));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852578), Integer.valueOf(2130852580)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130852578), Integer.valueOf(2130852580)));
    localHashMap.put(g, new Pair(localInteger1, Integer.valueOf(2130848896)));
    localHashMap.put(f, new Pair(localInteger1, Integer.valueOf(2130848896)));
    localHashMap.put(d, new Pair(localInteger1, Integer.valueOf(2130852581)));
    localHashMap.put(e, new Pair(localInteger1, Integer.valueOf(2130852581)));
    q.put(FrameControllerUtil.r, localHashMap);
    r.put(FrameControllerUtil.r, n);
    localHashMap = new HashMap();
    str = a;
    localInteger1 = Integer.valueOf(2130852567);
    localHashMap.put(str, new Pair(Integer.valueOf(2130848894), localInteger1));
    localHashMap.put(b, new Pair(Integer.valueOf(2130852562), Integer.valueOf(2130852566)));
    localHashMap.put(c, new Pair(Integer.valueOf(2130852562), Integer.valueOf(2130852566)));
    localHashMap.put(g, new Pair(Integer.valueOf(2130848894), localInteger1));
    localHashMap.put(f, new Pair(Integer.valueOf(2130848894), localInteger1));
    localHashMap.put(d, new Pair(Integer.valueOf(2130852564), localInteger1));
    localHashMap.put(e, new Pair(Integer.valueOf(2130848894), localInteger1));
    q.put(FrameControllerUtil.s, localHashMap);
    r.put(FrameControllerUtil.s, o);
  }
  
  private int a(Resources paramResources)
  {
    if (paramResources == null)
    {
      QLog.e("TabDragAnimationView", 1, "getTabTextViewColor called error: resources == null");
      return Color.parseColor("#000000");
    }
    String str = QQTheme.getCurrentThemeId();
    if (TextUtils.isEmpty(str)) {
      return paramResources.getColor(2131168196);
    }
    if (TabDragAnimationView.q == null)
    {
      TabDragAnimationView.q = new HashMap();
      TabDragAnimationView.q.put("2971", "#0099FF");
      TabDragAnimationView.q.put("2921", "#0099FF");
      TabDragAnimationView.q.put("3491", "#19497D");
      TabDragAnimationView.q.put("3063", "#12D6BC");
      TabDragAnimationView.q.put("3064", "#FFE454");
      TabDragAnimationView.q.put("3066", "#FF779A");
      TabDragAnimationView.q.put("3065", "#6532D7");
      TabDragAnimationView.q.put("3067", "#FF6772");
      TabDragAnimationView.q.put("2920", "#0066CC");
    }
    str = (String)TabDragAnimationView.q.get(str);
    if (!TextUtils.isEmpty(str)) {
      return Color.parseColor(str);
    }
    return paramResources.getColor(2131168196);
  }
  
  private Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if ((SkinEngine.getInstances().checkResExist(paramInt1)) && (SkinEngine.getInstances().checkResExist(paramInt2))) {
      return new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    return new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
  }
  
  private Pair<Integer, Integer> a(Pair<Integer, Integer> paramPair, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, Pair<Integer, Integer>> paramHashMap, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      if (paramBoolean1) {
        return (Pair)paramHashMap.get(f);
      }
    }
    else
    {
      if (paramBoolean1) {
        return paramPair;
      }
      if (paramBoolean2) {
        paramPair = (Pair)paramHashMap.get(f);
      }
    }
    return paramPair;
  }
  
  private Pair<Integer, Integer> a(String paramString)
  {
    Object localObject = b(paramString);
    int i1;
    if ((((Integer)((Pair)localObject).first).intValue() != -1) && (((Integer)((Pair)localObject).second).intValue() != -1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      QLog.d("QCircleThemeUtils", 1, "find night modeIcon in engine");
      return localObject;
    }
    localObject = d(paramString);
    int i2;
    if (localObject != null)
    {
      i2 = ((FrameInfoBean)localObject).e();
      i1 = ((FrameInfoBean)localObject).f();
    }
    else
    {
      i1 = -1;
      i2 = -1;
    }
    if ((i2 != -1) && (i1 != -1))
    {
      QLog.d("QCircleThemeUtils", 1, "find night modeIcon in infoBean");
      return new Pair(Integer.valueOf(i2), Integer.valueOf(i1));
    }
    QLog.d("QCircleThemeUtils", 1, "find night modeIcon in qcircle Native");
    return (Pair)((HashMap)q.get(paramString)).get(a);
  }
  
  private Pair<Integer, Integer> a(boolean paramBoolean1, boolean paramBoolean2, HashMap<String, Pair<Integer, Integer>> paramHashMap, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      if (paramBoolean1) {
        return (Pair)paramHashMap.get(e);
      }
      return (Pair)paramHashMap.get(d);
    }
    if (paramBoolean1) {
      return (Pair)paramHashMap.get(d);
    }
    if (paramBoolean2) {
      return (Pair)paramHashMap.get(e);
    }
    return (Pair)paramHashMap.get(d);
  }
  
  private FrameInfoBean a(Class paramClass)
  {
    return ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(paramClass);
  }
  
  private String a(View paramView, TextView paramTextView)
  {
    if ((paramView instanceof RedTouchTab))
    {
      paramView = (String)((RedTouchTab)paramView).getTarget().getContentDescription();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTag form RedTouchTab:");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("TabFrameControllerImpl", 1, ((StringBuilder)localObject).toString());
    }
    else if ((paramView instanceof RedTouch))
    {
      paramView = (String)((RedTouch)paramView).getTarget().getContentDescription();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTag form RedTouch:");
      ((StringBuilder)localObject).append(paramView);
      QLog.i("TabFrameControllerImpl", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramView = "";
    }
    Object localObject = paramView;
    if (TextUtils.isEmpty(paramView))
    {
      localObject = paramTextView.getText().toString();
      paramView = new StringBuilder();
      paramView.append("getTag form tabText:");
      paramView.append((String)localObject);
      QLog.i("TabFrameControllerImpl", 1, paramView.toString());
    }
    return localObject;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramTextView == null) {
        return;
      }
      paramTextView.setText(QCircleConfigHelper.bo());
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsSimple(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    boolean bool2 = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    boolean bool3 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if ((paramBoolean1) && (paramBoolean2))
    {
      b(paramTextView, bool1, bool2, bool3);
      return;
    }
    if ((!paramBoolean1) && (paramBoolean3))
    {
      if (bool1) {
        paramTextView.setTextColor(a(BaseApplication.getContext().getResources()));
      }
    }
    else if ((paramBoolean2) && (bool1)) {
      paramTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131168464));
    }
  }
  
  public static void a(FrameInitBean paramFrameInitBean)
  {
    p = paramFrameInitBean;
  }
  
  private void a(FrameFragment paramFrameFragment, View paramView)
  {
    if (paramFrameFragment.W == null) {
      return;
    }
    View localView = paramFrameFragment.W.findViewById(16908305);
    paramFrameFragment.K = ((QQBlurView)paramFrameFragment.W.findViewById(2131449311));
    if (paramFrameFragment.K != null)
    {
      if (localView == null) {
        return;
      }
      paramFrameFragment.K.setDebugTag("TAB");
      paramFrameFragment.K.setVisibility(8);
      paramFrameFragment.K.b();
      paramFrameFragment.K.c();
      if (paramFrameFragment.u())
      {
        paramFrameFragment.a(paramView, localView);
        return;
      }
      paramFrameFragment.a(paramView);
    }
  }
  
  private void a(TabDragAnimationView paramTabDragAnimationView, Pair<Integer, Integer> paramPair)
  {
    paramTabDragAnimationView.setBgPressedDrawable(((Integer)paramPair.second).intValue());
    paramTabDragAnimationView.setBgDrawable(((Integer)paramPair.first).intValue());
    int i2 = ((Integer)paramPair.first).intValue();
    int i1 = -1;
    if (i2 != -1) {
      i1 = BaseApplication.getContext().getResources().getDrawable(((Integer)paramPair.first).intValue()).getIntrinsicWidth();
    }
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    if ((!ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) && (!QQTheme.isNowSimpleUI())) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if (i2 != 0) {
      i1 = (int)(29.0F * f1 + 0.5F);
    }
    int i3;
    if (i2 != 0) {
      i3 = (int)(f1 * 5.0F + 0.5F);
    } else {
      i3 = 0;
    }
    paramTabDragAnimationView.setPadding(0, i3, 0, i3);
    paramTabDragAnimationView.setIconSize(i1, i1);
    paramTabDragAnimationView.setIconGravity(i2);
  }
  
  private void a(String paramString, TabDragAnimationView paramTabDragAnimationView, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    boolean bool2 = ThemeUtil.isNowThemeIsSimple(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    boolean bool3 = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    HashMap localHashMap = (HashMap)q.get(paramString);
    boolean bool4 = c(paramString);
    if (bool3)
    {
      a(paramTabDragAnimationView, b(paramBoolean1, paramBoolean2, localHashMap, bool4));
    }
    else if (bool2)
    {
      a(paramTabDragAnimationView, a(paramBoolean1, paramBoolean2, localHashMap, bool4));
    }
    else if (bool1)
    {
      a(paramTabDragAnimationView, a(paramString));
    }
    else
    {
      a(paramTabDragAnimationView, a(b(paramString), paramBoolean1, paramBoolean2, localHashMap, bool4));
      QLog.d("QCircleThemeUtils", 1, "DIY Theme");
    }
    a(paramTextView, bool4, paramBoolean2, paramBoolean1);
    a(paramTextView, bool4);
    if ((bool1) && (bool2))
    {
      paramTextView.setVisibility(0);
      return;
    }
    if (bool1)
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool3 = paramString3.equals(FrameControllerUtil.o);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if ((paramString1.equals(j)) || (paramString1.equals(k))) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramString3.equals(FrameControllerUtil.q))
    {
      if (!paramString1.equals(l))
      {
        bool1 = bool2;
        if (!paramString1.equals(m)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    return paramString1.equals(paramString2);
  }
  
  private Pair<Integer, Integer> b(String paramString)
  {
    try
    {
      if (FrameControllerUtil.l.equals(paramString)) {
        return a(2130852542, 2130852543);
      }
      if (FrameControllerUtil.m.equals(paramString)) {
        return a(2130852544, 2130852545);
      }
      if (FrameControllerUtil.q.equals(paramString)) {
        return a(2130852546, 2130852547);
      }
      if (FrameControllerUtil.o.equals(paramString)) {
        return a(2130852548, 2130852549);
      }
      if ((FrameControllerUtil.r.equals(paramString)) || (FrameControllerUtil.s.equals(paramString)))
      {
        paramString = a(2130852550, 2130852551);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("replaceExtraIcon excetpion: ");
      localStringBuilder.append(paramString);
      QLog.e("QCircleThemeUtils", 1, localStringBuilder.toString());
    }
    return new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
  }
  
  private Pair<Integer, Integer> b(boolean paramBoolean1, boolean paramBoolean2, HashMap<String, Pair<Integer, Integer>> paramHashMap, boolean paramBoolean3)
  {
    if (paramBoolean3)
    {
      if (paramBoolean1) {
        return (Pair)paramHashMap.get(c);
      }
      return (Pair)paramHashMap.get(b);
    }
    if (paramBoolean1) {
      return (Pair)paramHashMap.get(b);
    }
    if (paramBoolean2) {
      return (Pair)paramHashMap.get(c);
    }
    return (Pair)paramHashMap.get(b);
  }
  
  private void b(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!QQTheme.isCustomTheme("", false)) && (!paramBoolean2))
    {
      if (paramBoolean1)
      {
        paramTextView.setTextColor(a(BaseApplication.getContext().getResources()));
        return;
      }
      if (paramBoolean3)
      {
        paramTextView.setTextColor(Color.parseColor("#0071FF"));
        return;
      }
      paramTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131168464));
      return;
    }
    paramTextView.setTextColor(Color.parseColor("#0099ff"));
  }
  
  private void b(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment != null) && (paramFrameFragment.s != null))
    {
      View localView = paramFrameFragment.s.findViewById(16908307);
      if (localView == null)
      {
        QLog.d("QCircleThemeUtils", 1, "changeTabHostBackGround failed NO widget");
        return;
      }
      boolean bool = a(paramFrameFragment.z(), n, FrameControllerUtil.r);
      if (bool) {
        localView.setBackgroundDrawable(new ColorDrawable(-16777216));
      } else {
        a(paramFrameFragment, localView);
      }
      SimpleModeHelper.a(bool, paramFrameFragment.s.findViewById(2131446748));
      return;
    }
    QLog.d("QCircleThemeUtils", 1, "changeTabHostBackGround failed");
  }
  
  private void c(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment == null)
    {
      QLog.i("TabFrameControllerImpl", 1, "initFlashShowTab remove flashShow");
      return;
    }
    String str = paramFrameFragment.z();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeTab Name：");
    ((StringBuilder)localObject1).append(str);
    QLog.i("QCircleThemeUtils", 1, ((StringBuilder)localObject1).toString());
    paramFrameFragment = paramFrameFragment.z;
    if (paramFrameFragment == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramFrameFragment.length)
    {
      Object localObject2 = paramFrameFragment[i1];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("changeTab index：");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(paramFrameFragment.length);
      QLog.i("QCircleThemeUtils", 1, ((StringBuilder)localObject1).toString());
      if (localObject2 != null)
      {
        localObject1 = (TabDragAnimationView)((View)localObject2).findViewById(2131446751);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131448791);
        if ((localObject1 != null) && (localTextView != null))
        {
          localObject2 = a((View)localObject2, localTextView);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("changeTab index：");
          localStringBuilder.append(i1);
          localStringBuilder.append("| ");
          localStringBuilder.append((String)localObject2);
          QLog.i("QCircleThemeUtils", 1, localStringBuilder.toString());
          if (q.containsKey(localObject2)) {
            a((String)localObject2, (TabDragAnimationView)localObject1, localTextView, a(str, (String)r.get(localObject2), (String)localObject2), str.equals(n));
          }
        }
      }
      i1 += 1;
    }
  }
  
  private boolean c(String paramString)
  {
    return FrameControllerUtil.r.equals(paramString);
  }
  
  private FrameInfoBean d(String paramString)
  {
    if (paramString.equals(FrameControllerUtil.r)) {
      return e(n);
    }
    if (paramString.equals(FrameControllerUtil.l)) {
      return e(h);
    }
    if (paramString.equals(FrameControllerUtil.m)) {
      return e(i);
    }
    FrameInfoBean localFrameInfoBean;
    if (paramString.equals(FrameControllerUtil.q))
    {
      localFrameInfoBean = e(l);
      paramString = localFrameInfoBean;
      if (localFrameInfoBean == null) {
        paramString = e(m);
      }
      return paramString;
    }
    if (paramString.equals(FrameControllerUtil.o))
    {
      localFrameInfoBean = e(j);
      paramString = localFrameInfoBean;
      if (localFrameInfoBean == null) {
        paramString = e(k);
      }
      return paramString;
    }
    if (paramString.equals(FrameControllerUtil.s))
    {
      localFrameInfoBean = e(o);
      paramString = localFrameInfoBean;
      if (localFrameInfoBean == null) {
        paramString = e(o);
      }
      return paramString;
    }
    return null;
  }
  
  private FrameInfoBean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(Class.forName(paramString));
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    FrameInitBean localFrameInitBean = p;
    if (localFrameInitBean == null)
    {
      TabDragAnimationView.setIsQCircleLayerMode(false);
      QLog.d("QCircleThemeUtils", 1, "sInitBean is empty");
      return;
    }
    if (!localFrameInitBean.b())
    {
      TabDragAnimationView.setIsQCircleLayerMode(false);
      QLog.d("QCircleThemeUtils", 1, "sInitBean no qCircle");
      return;
    }
    if (!p.d())
    {
      TabDragAnimationView.setIsQCircleLayerMode(false);
      QLog.d("QCircleThemeUtils", 1, "sInitBean not layerMode");
      return;
    }
    TabDragAnimationView.setIsQCircleLayerMode(true);
    c(paramFrameFragment);
    b(paramFrameFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.utils.QCircleThemeUtils
 * JD-Core Version:    0.7.0.1
 */