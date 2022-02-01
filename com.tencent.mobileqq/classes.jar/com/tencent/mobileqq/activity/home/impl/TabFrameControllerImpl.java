package com.tencent.mobileqq.activity.home.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.FrameControllerInjectUtil;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TabFrameControllerImpl
  implements ITabFrameController
{
  public static final float TAB_HOST_HEIGHT_DP_DEFAULT_THEME = 54.0F;
  public static final float TAB_HOST_HEIGHT_DP_THIRD_PARTY_THEME = 64.0F;
  public static final String TAG = "TabFrameControllerImpl";
  protected static ArrayList<FrameInfoBean> mFrameInfoBeans;
  protected static final ArrayList<IFrameBusinessInterface> sFrameBusinessCallbacks = new ArrayList();
  protected static IFrameControllerInterface sFrameControllerInjectInterface;
  private FrameInitBean mFrameInitBean;
  
  static
  {
    mFrameInfoBeans = new ArrayList();
    try
    {
      Iterator localIterator = FrameControllerInjectUtil.b.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        sFrameBusinessCallbacks.add(localClass.newInstance());
        QLog.d("TabFrameControllerImpl", 1, "TabFrameControllerImpl add newInstance");
      }
      if (FrameControllerInjectUtil.a.size() > 0)
      {
        sFrameControllerInjectInterface = (IFrameControllerInterface)((Class)FrameControllerInjectUtil.a.get(0)).newInstance();
        QLog.d("TabFrameControllerImpl", 1, "TabFrameControllerImpl newInstance");
      }
      dispatchRegisterInfo();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabFrameControllerImpl", 1, "TabFrameControllerImpl static statement: ", localException);
    }
  }
  
  private void dispatchFragmentDrawerClose(FrameFragment paramFrameFragment, int paramInt1, int paramInt2)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment, paramInt1, paramInt2);
    }
  }
  
  static void dispatchOnDoubleTap(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).c(paramFrameFragment);
    }
  }
  
  static void dispatchRegisterInfo()
  {
    Object localObject = mFrameInfoBeans;
    if (localObject == null) {
      return;
    }
    ((ArrayList)localObject).clear();
    localObject = sFrameBusinessCallbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IFrameBusinessInterface)((Iterator)localObject).next()).a();
    }
  }
  
  private boolean isChannelTab(FrameFragment paramFrameFragment, int paramInt)
  {
    return (!paramFrameFragment.J) && (FrameControllerUtil.k == paramInt);
  }
  
  public static void registerFrameInfo(FrameInfoBean paramFrameInfoBean)
  {
    if (mFrameInfoBeans == null)
    {
      QLog.d("TabFrameControllerImpl", 1, "registerFrameInfo mFrameInfoBeans == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerFrameInfo frameInfoBean index: ");
    localStringBuilder.append(paramFrameInfoBean.c());
    localStringBuilder.append("ClassName: ");
    localStringBuilder.append(paramFrameInfoBean.a().getName());
    QLog.d("TabFrameControllerImpl", 1, localStringBuilder.toString());
    mFrameInfoBeans.add(paramFrameInfoBean);
  }
  
  public void addFrame(FrameFragment paramFrameFragment, View paramView1, Class<? extends Frame> paramClass, View paramView2)
  {
    if (paramFrameFragment.s == null)
    {
      paramFrameFragment.s = ((QQTabHost)paramView1.findViewById(16908306));
      paramFrameFragment.s.setup();
      paramFrameFragment.s.setOnTabChangedListener(paramFrameFragment);
      paramFrameFragment.s.setOnTabSelectionListener(new TabFrameControllerImpl.2(this, paramFrameFragment));
      paramFrameFragment.V = new HashMap(4);
    }
    String str = paramClass.getName();
    paramClass = (TabHost.TabSpec)paramFrameFragment.V.get(str);
    paramView1 = paramClass;
    if (paramClass == null)
    {
      paramView1 = paramFrameFragment.s.newTabSpec(str).setIndicator(paramView2).setContent(paramFrameFragment);
      paramFrameFragment.V.put(str, paramView1);
    }
    if (paramFrameFragment.u != null) {
      paramFrameFragment.u.add(paramView1);
    }
  }
  
  public Frame buildFrame(FrameFragment paramFrameFragment, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildFrame before tag: ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("TabFrameControllerImpl", 1, ((StringBuilder)localObject1).toString());
    int i = 0;
    for (;;)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      try
      {
        if (i < mFrameInfoBeans.size())
        {
          localObject1 = (FrameInfoBean)mFrameInfoBeans.get(i);
          Class localClass = ((FrameInfoBean)localObject1).a();
          String str = localClass.getName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildFrame matching className: ");
          localStringBuilder.append(str);
          QLog.d("TabFrameControllerImpl", 1, localStringBuilder.toString());
          if (paramString.equals(str))
          {
            if (((FrameInfoBean)localObject1).b()) {
              paramFrameFragment = (Frame)localClass.getConstructor(new Class[] { FrameFragment.class }).newInstance(new Object[] { paramFrameFragment });
            } else {
              paramFrameFragment = (Frame)localClass.newInstance();
            }
            localObject1 = paramFrameFragment;
          }
          else
          {
            i += 1;
          }
        }
      }
      catch (Exception paramFrameFragment)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("buildFrame error: ");
        ((StringBuilder)localObject1).append(paramFrameFragment);
        QLog.e("TabFrameControllerImpl", 1, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
        if (localObject1 == null)
        {
          paramFrameFragment = new StringBuilder();
          paramFrameFragment.append("buildFrame null tag: ");
          paramFrameFragment.append(paramString);
          QLog.d("TabFrameControllerImpl", 1, paramFrameFragment.toString());
        }
      }
    }
    return localObject1;
  }
  
  public void checkEnableTabAnim(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    paramFrameFragment.J = FrameControllerUtil.a();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkEnableTabAnim() called with: onPostThemeChanged = [");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("], mIsDefaultTheme=[");
      ((StringBuilder)localObject1).append(paramFrameFragment.J);
      ((StringBuilder)localObject1).append("]");
      QLog.d("TabFrameControllerImpl", 2, ((StringBuilder)localObject1).toString());
    }
    float f2 = paramFrameFragment.getResources().getDisplayMetrics().density;
    float f1;
    if (QQTheme.isCustomTheme("", false)) {
      f1 = 64.0F;
    } else {
      f1 = 54.0F;
    }
    int k = Math.round(f1 * f2);
    replaceExtraIcon(paramFrameFragment, Math.round(6.0F * f2));
    int i;
    Object localObject2;
    if (paramFrameFragment.B != null)
    {
      if (paramFrameFragment.J)
      {
        i = sFrameControllerInjectInterface.a(paramFrameFragment);
        updateTabDefaultFocusIcon(paramFrameFragment.A, paramFrameFragment.J, paramFrameFragment.B, i);
      }
      else
      {
        dispatchResetTabDrag(paramFrameFragment);
      }
      boolean bool = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).isNowThemeIsAnimate();
      i = 0;
      while (i < paramFrameFragment.B.size())
      {
        localObject1 = (TabDragAnimationView)paramFrameFragment.B.valueAt(i);
        ((TabDragAnimationView)localObject1).s = bool;
        ((TabDragAnimationView)localObject1).r = null;
        int j;
        if ((!paramFrameFragment.J) && (!TabDragAnimationView.g())) {
          j = -1;
        } else {
          j = (int)(29.0F * f2 + 0.5F);
        }
        ((TabDragAnimationView)localObject1).setIconSize(j, j);
        ((TabDragAnimationView)localObject1).setAnimEnable(paramFrameFragment.J);
        if ((!paramFrameFragment.J) && (!TabDragAnimationView.g())) {
          j = 0;
        } else {
          j = 1;
        }
        ((TabDragAnimationView)localObject1).setIconGravity(j);
        if ((!paramFrameFragment.J) && (!TabDragAnimationView.g())) {
          j = 0;
        } else {
          j = (int)(5.0F * f2 + 0.5F);
        }
        ((TabDragAnimationView)localObject1).setPadding(0, j, 0, j);
        localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
        ((RelativeLayout.LayoutParams)localObject2).height = k;
        ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
    }
    if (paramFrameFragment.W != null)
    {
      localObject1 = paramFrameFragment.W.findViewById(16908307);
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = k;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (paramFrameFragment.J))
      {
        long l = System.currentTimeMillis();
        localObject2 = paramFrameFragment.W.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          i = ((View)localObject2).getPaddingBottom();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkEnableTabAnim, height=");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(", padding=");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", cost=");
            ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
            QLog.d("TabFrameControllerImpl", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      localObject2 = paramFrameFragment.W.findViewById(16908305);
      paramFrameFragment.K = ((QQBlurView)paramFrameFragment.W.findViewById(2131449311));
      paramFrameFragment.K.setDebugTag("TAB");
      paramFrameFragment.K.setVisibility(8);
      paramFrameFragment.K.b();
      paramFrameFragment.K.c();
      if (paramFrameFragment.u()) {
        paramFrameFragment.a((View)localObject1, (View)localObject2);
      } else {
        paramFrameFragment.a((View)localObject1);
      }
      if (paramFrameFragment.B != null)
      {
        i = 0;
        while (i < paramFrameFragment.B.size())
        {
          localObject1 = (TabDragAnimationView)paramFrameFragment.B.valueAt(i);
          if (TabDragAnimationView.g()) {
            ((TabDragAnimationView)localObject1).setEnableClickScaleAnimation(false);
          } else {
            ((TabDragAnimationView)localObject1).setEnableClickScaleAnimation(true);
          }
          ((TabDragAnimationView)localObject1).setClickAnimationDrawable(null);
          i += 1;
        }
      }
      dispatchUpdateFaceId(paramFrameFragment);
    }
  }
  
  boolean dispatchCheckUnReadRedPacket(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((IFrameBusinessInterface)localIterator.next()).a(paramAppRuntime);
    }
    return bool;
  }
  
  void dispatchCommonBusinessOnTabChange(FrameFragment paramFrameFragment, String paramString)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).b(paramFrameFragment, paramString);
    }
  }
  
  void dispatchOnResumeAfter(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).d(paramFrameFragment);
    }
  }
  
  void dispatchOnRevertIconChange(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).f(paramFrameFragment);
    }
  }
  
  void dispatchOnTabChangeAfter(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).e(paramFrameFragment);
    }
  }
  
  void dispatchPostThemeChanged(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment);
    }
  }
  
  void dispatchResetTabDrag(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).g(paramFrameFragment);
    }
  }
  
  void dispatchResumeUpdateSound(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramHashMap, paramBoolean);
    }
  }
  
  void dispatchTabChangeAfterFramesPause(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).h(paramFrameFragment);
    }
  }
  
  void dispatchTabContentDescription(FrameFragment paramFrameFragment, String paramString)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment, paramString);
    }
  }
  
  void dispatchTabDragIconAddTv(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment, paramDragViewTouchListener);
    }
  }
  
  void dispatchUpdateFaceId(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).b(paramFrameFragment);
    }
  }
  
  void dispatchUpdateFrameInfo()
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).b();
    }
  }
  
  void dispatchUpdateFrameOnTabChange(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment, paramInt1, paramFrame, paramInt2);
    }
  }
  
  void dispatchUpdateFrameOnTabClick(FrameFragment paramFrameFragment, int paramInt)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment, paramInt);
    }
  }
  
  void dispatchUpdateTabFocusIcon(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramAppRuntime, paramSparseArray, paramInt);
    }
  }
  
  void dispatchUpdateTadRedTouch(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramRedTouch, paramFrameFragment, paramInt, paramRedTypeInfo, paramIRedTouchManager);
    }
  }
  
  public void doFramesPauseAfter(FrameFragment paramFrameFragment)
  {
    dispatchOnRevertIconChange(paramFrameFragment);
  }
  
  public void doOnEntry(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    paramFrameFragment.F = paramIntent;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnNewIntent1 : url");
      ((StringBuilder)localObject1).append(paramIntent.getStringExtra("url"));
      QLog.d("CampusNoticeManager", 1, ((StringBuilder)localObject1).toString());
    }
    FrameFragment.o = false;
    if (sFrameControllerInjectInterface.c(paramFrameFragment))
    {
      if (QLog.isColorLevel()) {
        QLog.d("doOnEntry", 1, "doCheckOnEntryInvalid");
      }
      return;
    }
    sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent);
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    if (((Bundle)localObject1).getBoolean("EXIT", false))
    {
      paramFrameFragment.C().finish();
      return;
    }
    int i = -1;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      i = ((Bundle)localObject1).getInt("tab_index");
    } else if (((Bundle)localObject1).containsKey("main_tab_id")) {
      i = mainTabID2TabIndex((Bundle)localObject1);
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNewIntent tabIndex: ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("TabFrameControllerImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramFrameFragment.s != null) && (i >= 0) && (paramFrameFragment.v != null) && (i < paramFrameFragment.v.size()))
    {
      localObject2 = (TabHost.TabSpec)paramFrameFragment.v.get(i);
      if (localObject2 != null) {
        TabControlReporter.a(((TabHost.TabSpec)localObject2).getTag(), i);
      }
    }
    sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent, (Bundle)localObject1, i);
  }
  
  public int findIndexForList(String paramString, ArrayList<String> paramArrayList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramArrayList == null) {
        return -100;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (paramString.equals(paramArrayList.get(i))) {
          return i;
        }
        i += 1;
      }
    }
    return -100;
  }
  
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplication.getContext() == null) {
      return null;
    }
    View localView = View.inflate(BaseApplication.getContext(), 2131629365, null);
    ((DragTextView)localView.findViewById(2131449076)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131446751)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131448791)).setText(paramInt5);
    return localView;
  }
  
  public String getCurrentTabTag(QQTabHost paramQQTabHost)
  {
    if (paramQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabFrameControllerImpl", 2, "getCurrentTabTag. mTabHost is null");
      }
      return null;
    }
    paramQQTabHost = paramQQTabHost.getCurrentTabTag();
    if (paramQQTabHost != null)
    {
      int i = 0;
      while (i < mFrameInfoBeans.size())
      {
        FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
        if (paramQQTabHost.equals(localFrameInfoBean.a().getName())) {
          return localFrameInfoBean.d();
        }
        i += 1;
      }
    }
    return "";
  }
  
  public FrameInfoBean getFrameInfoByClazz(Class paramClass)
  {
    if (mFrameInfoBeans != null)
    {
      if (paramClass == null) {
        return null;
      }
      int i = 0;
      while (i < mFrameInfoBeans.size())
      {
        FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
        if (paramClass.getName().equals(localFrameInfoBean.a().getName())) {
          return localFrameInfoBean;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public FrameInfoBean getFrameInfoByIndex(int paramInt)
  {
    if (mFrameInfoBeans == null) {
      return null;
    }
    int i = 0;
    while (i < mFrameInfoBeans.size())
    {
      FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
      if (paramInt == localFrameInfoBean.c()) {
        return localFrameInfoBean;
      }
      i += 1;
    }
    return null;
  }
  
  public int getTabIndexFromName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = 0;
    while (i < mFrameInfoBeans.size())
    {
      FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
      if (paramString.equals(localFrameInfoBean.a().getName())) {
        return localFrameInfoBean.c();
      }
      i += 1;
    }
    return 0;
  }
  
  public int getTabNoteTextStyle(HashMap<String, Object> paramHashMap, String paramString)
  {
    int j = sFrameControllerInjectInterface.a(0);
    if (paramHashMap == null) {
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_new");
    localObject = paramHashMap.get(((StringBuilder)localObject).toString());
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return sFrameControllerInjectInterface.a(2);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_num");
    localObject = paramHashMap.get(((StringBuilder)localObject).toString());
    if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0)) {
      return sFrameControllerInjectInterface.a(3);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_icon");
    paramHashMap = paramHashMap.get(((StringBuilder)localObject).toString());
    int i = j;
    if ((paramHashMap instanceof Boolean))
    {
      i = j;
      if (((Boolean)paramHashMap).booleanValue()) {
        i = sFrameControllerInjectInterface.a(1);
      }
    }
    return i;
  }
  
  public View[] getTabViews(LayoutInflater paramLayoutInflater)
  {
    return sFrameControllerInjectInterface.a(this, paramLayoutInflater);
  }
  
  public String getTagFromType(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 18: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_icon");
      return localStringBuilder.toString();
    case 17: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_new");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_num");
    return localStringBuilder.toString();
  }
  
  public void handleThemeChanged(FrameFragment paramFrameFragment)
  {
    if ((TabDragAnimationView.g()) && (TabDragAnimationView.h())) {
      paramFrameFragment.y = true;
    } else {
      paramFrameFragment.y = false;
    }
    int i;
    if (paramFrameFragment.x != QQTheme.isNowSimpleUI()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramFrameFragment.z != null)) {
      setFrames(paramFrameFragment, false);
    }
    dispatchPostThemeChanged(paramFrameFragment);
    checkEnableTabAnim(paramFrameFragment, true);
  }
  
  public boolean hasUnReadRedPacket(AppRuntime paramAppRuntime)
  {
    return dispatchCheckUnReadRedPacket(paramAppRuntime);
  }
  
  public void initTabDragIconsAbdTextVuews(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.B = new SparseArray(3);
    paramFrameFragment.C = new SparseArray(3);
    dispatchTabDragIconAddTv(paramFrameFragment, new FrameFragment.DragViewTouchListener());
  }
  
  public void initTabIndexByConfig(FrameInitBean paramFrameInitBean)
  {
    StringBuilder localStringBuilder = new StringBuilder("CONVERSATION CONTACT LEBA");
    if (paramFrameInitBean.b())
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("NEW_WORLD");
    }
    if (paramFrameInitBean.a())
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("RIJ");
    }
    if (paramFrameInitBean.c())
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("GUILD");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < TabDataHelper.TAB_CONFIG_ARRAY.length)
    {
      String str = TabDataHelper.TAB_CONFIG_ARRAY[i];
      if (localStringBuilder.toString().contains(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    FrameControllerUtil.a = findIndexForList("CONVERSATION", localArrayList);
    FrameControllerUtil.k = findIndexForList("GUILD", localArrayList);
    FrameControllerUtil.b = -100;
    FrameControllerUtil.e = -100;
    FrameControllerUtil.c = findIndexForList("CONTACT", localArrayList);
    FrameControllerUtil.g = findIndexForList("RIJ", localArrayList);
    FrameControllerUtil.d = findIndexForList("LEBA", localArrayList);
    FrameControllerUtil.j = findIndexForList("NEW_WORLD", localArrayList);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("initTabIndexByConfig ConversationTab: ");
    localStringBuilder.append(FrameControllerUtil.a);
    localStringBuilder.append(" GuildTab: ");
    localStringBuilder.append(FrameControllerUtil.k);
    localStringBuilder.append(" ContactTab: ");
    localStringBuilder.append(FrameControllerUtil.c);
    localStringBuilder.append(" KandianTab: ");
    localStringBuilder.append(FrameControllerUtil.g);
    localStringBuilder.append(" LebaTab: ");
    localStringBuilder.append(FrameControllerUtil.d);
    localStringBuilder.append(" QCircleTab: ");
    localStringBuilder.append(FrameControllerUtil.j);
    QLog.d("TabFrameControllerImpl", 1, localStringBuilder.toString());
    this.mFrameInitBean = paramFrameInitBean;
    dispatchUpdateFrameInfo();
  }
  
  public View[] initTabs(FrameFragment paramFrameFragment, View paramView)
  {
    return sFrameControllerInjectInterface.a(this, paramFrameFragment, paramView);
  }
  
  public boolean isFragmentNotMatch()
  {
    return sFrameControllerInjectInterface.a();
  }
  
  public int mainTabID2TabIndex(Bundle paramBundle)
  {
    int i = -2147483648;
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("main_tab_id")) {
        return -2147483648;
      }
      switch (paramBundle.getInt("main_tab_id"))
      {
      case 6: 
      case 7: 
      case 8: 
      default: 
        return -2147483648;
      case 11: 
        return FrameControllerUtil.k;
      case 10: 
        return FrameControllerUtil.j;
      case 9: 
        return FrameControllerUtil.i;
      case 5: 
        return FrameControllerUtil.e;
      case 4: 
        return FrameControllerUtil.d;
      case 3: 
        return FrameControllerUtil.c;
      case 2: 
        return FrameControllerUtil.b;
      }
      i = FrameControllerUtil.a;
    }
    return i;
  }
  
  public void onDrawCompleteAfter(FrameFragment paramFrameFragment)
  {
    sFrameControllerInjectInterface.a(this, paramFrameFragment);
  }
  
  public void onFragmentDrawerClosed(FrameFragment paramFrameFragment, int paramInt1, int paramInt2)
  {
    dispatchFragmentDrawerClose(paramFrameFragment, paramInt1, paramInt2);
  }
  
  public void onFragmentDrawerInit(boolean paramBoolean)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void onResumeAfter(FrameFragment paramFrameFragment)
  {
    dispatchOnResumeAfter(paramFrameFragment);
  }
  
  public void onResumeUpdateSound(FrameFragment paramFrameFragment)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new TabFrameControllerImpl.1(this, paramFrameFragment), 1000L);
  }
  
  public void onTabChangeDelayAction(FrameFragment paramFrameFragment, int paramInt)
  {
    if (paramFrameFragment.Z == null) {
      paramFrameFragment.Z = new MqqHandler();
    }
    paramFrameFragment.Z.postDelayed(new TabFrameControllerImpl.3(this, paramFrameFragment, paramInt), 100L);
  }
  
  public void onTouchDragChange(boolean paramBoolean)
  {
    sFrameControllerInjectInterface.a(paramBoolean);
  }
  
  public void realUpdateRedTouch(RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTouch != null)
    {
      paramRedTouch.a();
      paramRedTouch.a(paramRedTypeInfo);
    }
  }
  
  public boolean replaceExtraIcon(FrameFragment paramFrameFragment, int paramInt)
  {
    if ((paramFrameFragment.B != null) && (paramFrameFragment.B.size() > 0))
    {
      int k = 0;
      while (k < paramFrameFragment.B.size())
      {
        int i3 = paramFrameFragment.B.keyAt(k);
        Object localObject1 = (TabDragAnimationView)paramFrameFragment.B.get(i3);
        if (localObject1 != null)
        {
          int m;
          Object localObject2;
          int n;
          do
          {
            do
            {
              int j;
              int i;
              Object localObject3;
              if (!paramFrameFragment.J)
              {
                try
                {
                  m = FrameControllerUtil.a;
                  j = 2130852545;
                  i = 2130852544;
                  if ((i3 == m) && (SkinEngine.getInstances().checkResExist(2130852542)) && (SkinEngine.getInstances().checkResExist(2130852543)))
                  {
                    i = 2130852542;
                    j = 2130852543;
                  }
                  else if ((i3 != FrameControllerUtil.c) || (!SkinEngine.getInstances().checkResExist(2130852544)) || (!SkinEngine.getInstances().checkResExist(2130852545)))
                  {
                    if ((i3 == FrameControllerUtil.g) && (SkinEngine.getInstances().checkResExist(2130852546)) && (SkinEngine.getInstances().checkResExist(2130852547)))
                    {
                      i = 2130852546;
                      j = 2130852547;
                    }
                    else if ((i3 == FrameControllerUtil.d) && (SkinEngine.getInstances().checkResExist(2130852548)) && (SkinEngine.getInstances().checkResExist(2130852549)))
                    {
                      i = 2130852548;
                      j = 2130852549;
                    }
                    else if (((i3 == FrameControllerUtil.j) || (i3 == FrameControllerUtil.k)) && (SkinEngine.getInstances().checkResExist(2130852550)))
                    {
                      boolean bool = SkinEngine.getInstances().checkResExist(2130852551);
                      if (bool)
                      {
                        i = 2130852550;
                        j = 2130852551;
                      }
                    }
                  }
                }
                catch (Exception localException)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("replaceExtraIcon excetpion: ");
                  ((StringBuilder)localObject3).append(localException);
                  QLog.e("TabFrameControllerImpl", 1, ((StringBuilder)localObject3).toString());
                }
              }
              else
              {
                i = -1;
                j = -1;
              }
              localObject2 = this.mFrameInitBean;
              if ((localObject2 != null) && (((FrameInitBean)localObject2).d()) && (this.mFrameInitBean.b())) {
                m = 1;
              } else {
                m = 0;
              }
              if ((i != -1) && (j != -1)) {
                n = 1;
              } else {
                n = 0;
              }
              int i1 = i;
              int i2 = j;
              if (n == 0)
              {
                localObject2 = mFrameInfoBeans;
                i1 = i;
                i2 = j;
                if (localObject2 != null)
                {
                  localObject2 = ((ArrayList)localObject2).iterator();
                  for (;;)
                  {
                    i1 = i;
                    i2 = j;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    localObject3 = (FrameInfoBean)((Iterator)localObject2).next();
                    if (((FrameInfoBean)localObject3).c() == i3)
                    {
                      i = ((FrameInfoBean)localObject3).e();
                      j = ((FrameInfoBean)localObject3).f();
                    }
                  }
                }
              }
              if ((i1 != -1) && (i2 != -1) && (m == 0))
              {
                ((TabDragAnimationView)localObject1).setBgDrawable(i1);
                ((TabDragAnimationView)localObject1).setBgPressedDrawable(i2);
              }
            } while (paramFrameFragment.C == null);
            localObject1 = (TextView)paramFrameFragment.C.get(i3);
          } while (localObject1 == null);
          if ((n == 0) && (!paramFrameFragment.J) && ((i3 != FrameControllerUtil.j) || (QQTheme.isThemeSimpleUI(QQTheme.getCurrentThemeId())) || (!QQTheme.isCustomTheme("", false))) && (!QQTheme.isNowSimpleUI()) && (m == 0)) {
            ((TextView)localObject1).setVisibility(8);
          }
          for (;;)
          {
            break;
            ((TextView)localObject1).setVisibility(0);
            localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            if (localObject2 != null)
            {
              ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramInt;
              ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          updateTabSelectStatusOnTabChange(paramFrameFragment, getTabIndexFromName(paramFrameFragment.z()));
        }
        k += 1;
      }
      return true;
    }
    return false;
  }
  
  public void revertTabIconChange(FrameFragment paramFrameFragment)
  {
    dispatchTabChangeAfterFramesPause(paramFrameFragment);
  }
  
  public void setContactAndLebaTabDesc(FrameFragment paramFrameFragment, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 33)
    {
      paramFrameFragment.H = paramString1;
      return;
    }
    paramFrameFragment.I = paramString2;
  }
  
  public void setCurrentIntentParams(FrameFragment paramFrameFragment)
  {
    try
    {
      Intent localIntent = paramFrameFragment.C().getIntent();
      if (localIntent != null)
      {
        localIntent.putExtra("current_tab_tag", paramFrameFragment.w());
        return;
      }
    }
    catch (Exception paramFrameFragment)
    {
      QLog.e("TabFrameControllerImpl", 1, "setCurrentIntentParams", paramFrameFragment);
    }
  }
  
  public void setFrames(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    sFrameControllerInjectInterface.a(this, paramFrameFragment, paramBoolean);
  }
  
  public void setSoundEffectsEnableForTab(HashMap<String, View> paramHashMap, boolean paramBoolean, String paramString)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.get(paramString) == null) {
        return;
      }
      ((View)paramHashMap.get(paramString)).setSoundEffectsEnabled(paramBoolean);
    }
  }
  
  public void updateCommonBusinessOnTabChange(FrameFragment paramFrameFragment, String paramString)
  {
    dispatchCommonBusinessOnTabChange(paramFrameFragment, paramString);
  }
  
  public void updateFrames(FrameFragment paramFrameFragment, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramFrameFragment.z == null) {
      return;
    }
    String str = "";
    Object localObject1;
    if (paramInt1 != 32)
    {
      if (paramInt1 != 33)
      {
        if (paramInt1 != 39)
        {
          if (paramInt1 != 48) {
            localObject1 = "";
          } else {
            localObject1 = FrameControllerUtil.s;
          }
        }
        else {
          sFrameControllerInjectInterface.a(this, paramFrameFragment, paramInt2);
        }
      }
      else {
        localObject1 = FrameControllerUtil.m;
      }
    }
    else {
      localObject1 = FrameControllerUtil.l;
    }
    Object localObject3 = getTagFromType(paramInt2, (String)localObject1);
    Object localObject2 = paramFrameFragment.G;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("_num");
    localObject2 = (TextView)((HashMap)localObject2).get(((StringBuilder)localObject4).toString());
    if (localObject2 != null)
    {
      if (localObject3 == null) {
        return;
      }
      boolean bool;
      if ((paramObject instanceof Integer))
      {
        i = ((Integer)paramObject).intValue();
        bool = false;
      }
      else
      {
        if ((paramObject instanceof Boolean)) {
          bool = ((Boolean)paramObject).booleanValue();
        } else {
          bool = false;
        }
        i = 0;
      }
      localObject4 = PreferenceManager.getDefaultSharedPreferences(paramFrameFragment.A.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_num");
      if (((String)localObject3).equals(localStringBuilder.toString()))
      {
        localObject4 = ((SharedPreferences)localObject4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(paramFrameFragment.A.getAccount());
        ((SharedPreferences.Editor)localObject4).putInt(localStringBuilder.toString(), i).commit();
      }
      else
      {
        localObject4 = ((SharedPreferences)localObject4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(paramFrameFragment.A.getAccount());
        ((SharedPreferences.Editor)localObject4).putBoolean(localStringBuilder.toString(), bool).commit();
      }
      paramFrameFragment.R.put(localObject3, paramObject);
      int j = getTabNoteTextStyle(paramFrameFragment.R, (String)localObject1);
      if (j == sFrameControllerInjectInterface.a(3))
      {
        paramObject = paramFrameFragment.R;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_num");
        localObject1 = paramObject.get(((StringBuilder)localObject3).toString());
        paramObject = str;
        if ((localObject1 instanceof Integer))
        {
          i = ((Integer)localObject1).intValue();
          paramObject = "";
          break label564;
        }
      }
      else
      {
        paramObject = str;
        if (j == sFrameControllerInjectInterface.a(5))
        {
          paramObject = paramFrameFragment.R;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("_text");
          localObject1 = paramObject.get(((StringBuilder)localObject3).toString());
          paramObject = str;
          if ((localObject1 instanceof String)) {
            paramObject = (String)localObject1;
          }
        }
      }
      int i = 0;
      label564:
      if (paramInt1 == 32)
      {
        int k = paramFrameFragment.getResources().getDimensionPixelSize(2131297775);
        int m = ViewUtils.dpToPx(5.0F);
        localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).setMargins(m, k, 0, 0);
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (hasUnReadRedPacket(paramFrameFragment.A)) {
          paramFrameFragment.N = false;
        }
        if (!paramFrameFragment.N) {
          updateTabDefaultFocusIcon(paramFrameFragment.A, paramFrameFragment.J, paramFrameFragment.B, i);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateMain, [");
        ((StringBuilder)localObject1).append("tabIndex = ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("type = ");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("style = ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("num = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("isVisable = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("tv = ");
        ((StringBuilder)localObject1).append(((TextView)localObject2).toString());
        ((StringBuilder)localObject1).append(" ]");
        QLog.d("TabFrameControllerImpl", 4, ((StringBuilder)localObject1).toString());
      }
      localObject1 = sFrameControllerInjectInterface;
      ((IFrameControllerInterface)localObject1).a((TextView)localObject2, i, paramObject, j, 0, ((IFrameControllerInterface)localObject1).a(99));
      if (AppSetting.e) {
        dispatchTabContentDescription(paramFrameFragment, getCurrentTabTag(paramFrameFragment.s));
      }
    }
  }
  
  public void updateRedTouch(FrameFragment paramFrameFragment, int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((paramRedTouch != null) && (paramRedTypeInfo != null))
    {
      int i = paramRedTypeInfo.red_type.get();
      if (i != 0)
      {
        if ((i == 4) || (i == 5))
        {
          paramRedTouch.d(5);
          if (paramInt == 39) {
            paramRedTouch.d(15);
          }
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramRedTypeInfo.red_content.get());
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131897678));
          String str = ((StringBuilder)localObject1).toString();
          localObject1 = paramRedTypeInfo.red_content.get();
          Object localObject2;
          try
          {
            if (Integer.parseInt((String)localObject1) > 99) {
              localObject1 = "多于99条更新";
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            localObject2 = str;
          }
          setContactAndLebaTabDesc(paramFrameFragment, paramInt, localObject2, str);
        }
      }
      else
      {
        paramRedTouch.d(15);
        setContactAndLebaTabDesc(paramFrameFragment, paramInt, HardCodeUtil.a(2131897677), HardCodeUtil.a(2131897677));
      }
      realUpdateRedTouch(paramRedTouch, paramRedTypeInfo);
      return;
    }
    realUpdateRedTouch(paramRedTouch, null);
    setContactAndLebaTabDesc(paramFrameFragment, paramInt, "", "");
  }
  
  public void updateTabContentDescription(FrameFragment paramFrameFragment, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString2 = (View)paramFrameFragment.G.get(paramString1);
    if (paramString2 == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (FrameControllerUtil.l.equals(paramString1))
    {
      localStringBuilder.append("消息 ");
    }
    else if (FrameControllerUtil.m.equals(paramString1))
    {
      localStringBuilder.append("联系人 ");
    }
    else if (FrameControllerUtil.o.equals(paramString1))
    {
      localStringBuilder.append("动态 ");
    }
    else if (FrameControllerUtil.p.equals(paramString1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131897681));
      ((StringBuilder)localObject1).append(" ");
      localStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    else
    {
      if (!FrameControllerUtil.s.equals(paramString1)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131890238));
      ((StringBuilder)localObject1).append(" ");
      localStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    int i = getTabNoteTextStyle(paramFrameFragment.R, paramString1);
    Object localObject1 = paramFrameFragment.G;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("_num");
    localObject1 = (TextView)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    if (i == sFrameControllerInjectInterface.a(2)) {
      localStringBuilder.append("有更新");
    } else if (i == sFrameControllerInjectInterface.a(3))
    {
      if (FrameControllerUtil.l.equals(paramString1))
      {
        localObject1 = ((TextView)localObject1).getText().toString();
        if ("".equals(localObject1))
        {
          localStringBuilder.append("多于99条未读");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("条未读");
          localStringBuilder.append(((StringBuilder)localObject2).toString());
        }
      }
      else if ((!FrameControllerUtil.m.equals(paramString1)) && (!FrameControllerUtil.s.equals(paramString1)))
      {
        if (FrameControllerUtil.p.equals(paramString1))
        {
          localObject2 = ((TextView)localObject1).getText().toString();
          if (((TextView)localObject1).getVisibility() == 0) {
            if ("99+".equals(localObject2))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("多于99个新的");
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131897681));
              localStringBuilder.append(((StringBuilder)localObject1).toString());
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append("个新的");
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131897681));
              localStringBuilder.append(((StringBuilder)localObject1).toString());
            }
          }
        }
      }
      else
      {
        localObject2 = ((TextView)localObject1).getText().toString();
        if (((TextView)localObject1).getVisibility() == 0)
        {
          if ("99+".equals(localObject2))
          {
            localStringBuilder.append("多于99条更新");
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("条更新");
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
        }
        else {
          localStringBuilder.append(paramFrameFragment.H);
        }
      }
    }
    else if (i == sFrameControllerInjectInterface.a(1)) {
      localStringBuilder.append("有新消息");
    } else if (FrameControllerUtil.m.equals(paramString1)) {
      localStringBuilder.append(paramFrameFragment.H);
    }
    if (FrameControllerUtil.o.equals(paramString1)) {
      localStringBuilder.append(paramFrameFragment.I);
    }
    paramFrameFragment = (TextView)paramString2.findViewById(2131448791);
    localObject1 = paramString2.findViewById(2131446751);
    if (localObject1 != null)
    {
      ((View)localObject1).setContentDescription(paramString1);
      AccessibilityUtil.a((View)localObject1, false);
    }
    if (paramFrameFragment != null) {
      AccessibilityUtil.a(paramFrameFragment, false);
    }
    if ((paramString2 instanceof RedTouchTab))
    {
      ((RedTouchTab)paramString2).getTarget().setContentDescription(localStringBuilder.toString());
      return;
    }
    paramString2.setContentDescription(localStringBuilder.toString());
  }
  
  public void updateTabDefaultFocusIcon(AppRuntime paramAppRuntime, boolean paramBoolean, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    if ((paramBoolean) && (paramSparseArray != null))
    {
      dispatchUpdateTabFocusIcon(paramAppRuntime, paramSparseArray, paramInt);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("mIsDefaultTheme = ");
      paramAppRuntime.append(paramBoolean);
      paramAppRuntime.append(", mTabDragIcon is null ");
      if (paramSparseArray == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramAppRuntime.append(paramBoolean);
      QLog.d("DynimiIcon", 2, paramAppRuntime.toString());
    }
  }
  
  public void updateTabRedTouch(FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramFrameFragment.G == null) {
      return;
    }
    dispatchUpdateTadRedTouch(null, paramFrameFragment, paramInt, paramRedTypeInfo, (IRedTouchManager)paramFrameFragment.A.getRuntimeService(IRedTouchManager.class, ""));
  }
  
  public void updateTabSelectStatusOnTabChange(FrameFragment paramFrameFragment, int paramInt)
  {
    Object localObject = (TabDragAnimationView)paramFrameFragment.B.get(paramInt);
    if (localObject != null) {
      ((TabDragAnimationView)localObject).setPressChanged(true);
    }
    localObject = (TextView)paramFrameFragment.C.get(paramInt);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(TabDragAnimationView.a(paramFrameFragment.getResources()));
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramFrameFragment.B.size()) {
        break;
      }
      if (paramFrameFragment.B.keyAt(i) != paramInt) {
        ((TabDragAnimationView)paramFrameFragment.B.valueAt(i)).setPressChanged(false);
      }
      i += 1;
    }
    while (j < paramFrameFragment.C.size())
    {
      if (paramFrameFragment.B.keyAt(j) != paramInt) {
        ((TextView)paramFrameFragment.C.valueAt(j)).setTextColor(TabDragAnimationView.b(paramFrameFragment.getResources()));
      }
      j += 1;
    }
  }
  
  public void updateUIAfterTabChange(FrameFragment paramFrameFragment, String paramString1, String paramString2, Frame paramFrame)
  {
    try
    {
      int i = getTabIndexFromName(paramString2);
      int j = getTabIndexFromName(paramString1);
      updateCommonBusinessOnTabChange(paramFrameFragment, paramString1);
      dispatchUpdateFrameOnTabChange(paramFrameFragment, i, paramFrame, j);
      paramFrameFragment.J = FrameControllerUtil.a();
      updateTabSelectStatusOnTabChange(paramFrameFragment, j);
      onTabChangeDelayAction(paramFrameFragment, j);
      dispatchOnTabChangeAfter(paramFrameFragment);
      return;
    }
    catch (Exception paramFrameFragment)
    {
      paramString1 = new StringBuilder();
      paramString1.append("updateUIAfterTabChange excetpion: ");
      paramString1.append(paramFrameFragment);
      QLog.e("TabFrameControllerImpl", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl
 * JD-Core Version:    0.7.0.1
 */