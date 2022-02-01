package com.tencent.mobileqq.activity.home.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.FrameControllerInjectUtil;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
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
  public static final float TAB_HOST_HEIGHT_DP_THIRD_PARTY_THEME = 74.300003F;
  public static final String TAG = "TabFrameControllerImpl";
  protected static ArrayList<FrameInfoBean> mFrameInfoBeans;
  protected static final ArrayList<IFrameBusinessInterface> sFrameBusinessCallbacks = new ArrayList();
  protected static IFrameControllerInterface sFrameControllerInjectInterface;
  
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
  
  public static void registerFrameInfo(FrameInfoBean paramFrameInfoBean)
  {
    if (mFrameInfoBeans == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerFrameInfo frameInfoBean index: ");
    localStringBuilder.append(paramFrameInfoBean.a());
    localStringBuilder.append("ClassName: ");
    localStringBuilder.append(paramFrameInfoBean.a().getName());
    QLog.d("TabFrameControllerImpl", 1, localStringBuilder.toString());
    mFrameInfoBeans.add(paramFrameInfoBean);
  }
  
  public void addFrame(FrameFragment paramFrameFragment, View paramView1, Class<? extends Frame> paramClass, View paramView2)
  {
    if (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost = ((QQTabHost)paramView1.findViewById(16908306));
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setup();
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabChangedListener(paramFrameFragment);
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabSelectionListener(new TabFrameControllerImpl.2(this, paramFrameFragment));
      paramFrameFragment.jdField_c_of_type_JavaUtilHashMap = new HashMap(4);
    }
    String str = paramClass.getName();
    paramClass = (TabHost.TabSpec)paramFrameFragment.jdField_c_of_type_JavaUtilHashMap.get(str);
    paramView1 = paramClass;
    if (paramClass == null)
    {
      paramView1 = paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.newTabSpec(str).setIndicator(paramView2).setContent(paramFrameFragment);
      paramFrameFragment.jdField_c_of_type_JavaUtilHashMap.put(str, paramView1);
    }
    paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.addTab(paramView1);
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
            if (((FrameInfoBean)localObject1).a()) {
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      ((IFrameBusinessInterface)localIterator.next()).e(paramFrameFragment);
    }
  }
  
  void dispatchOnTabChangeAfter(FrameFragment paramFrameFragment)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramFrameFragment);
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
      ((IFrameBusinessInterface)localIterator.next()).f(paramFrameFragment);
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
      ((IFrameBusinessInterface)localIterator.next()).g(paramFrameFragment);
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
  
  void dispatchUpdateFrameOnTabClick(int paramInt)
  {
    Iterator localIterator = sFrameBusinessCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((IFrameBusinessInterface)localIterator.next()).a(paramInt);
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
    paramFrameFragment.jdField_b_of_type_AndroidContentIntent = paramIntent;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnNewIntent1 : url");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("url"));
      QLog.d("CampusNoticeManager", 1, ((StringBuilder)localObject).toString());
    }
    FrameFragment.e = false;
    if (sFrameControllerInjectInterface.a(paramFrameFragment))
    {
      if (QLog.isColorLevel()) {
        QLog.d("doOnEntry", 1, "doCheckOnEntryInvalid");
      }
      return;
    }
    sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent);
    Object localObject = paramIntent.getExtras();
    if (localObject == null) {
      return;
    }
    if (((Bundle)localObject).getBoolean("EXIT", false))
    {
      paramFrameFragment.a().finish();
      return;
    }
    int i = -1;
    if (((Bundle)localObject).containsKey("tab_index")) {
      i = ((Bundle)localObject).getInt("tab_index");
    } else if (((Bundle)localObject).containsKey("main_tab_id")) {
      i = mainTabID2TabIndex((Bundle)localObject);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNewIntent tabIndex: ");
      localStringBuilder.append(i);
      QLog.d("TabFrameControllerImpl", 2, localStringBuilder.toString());
    }
    sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent, (Bundle)localObject, i);
  }
  
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplication.getContext() == null) {
      return null;
    }
    View localView = View.inflate(BaseApplication.getContext(), 2131562905, null);
    ((DragTextView)localView.findViewById(2131380161)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131378232)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131379917)).setText(paramInt5);
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
          return localFrameInfoBean.a();
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
      if (paramInt == localFrameInfoBean.a()) {
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
        return localFrameInfoBean.a();
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
    int i;
    if (paramFrameFragment.g != QQTheme.f()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView != null)) {
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
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    dispatchTabDragIconAddTv(paramFrameFragment, new FrameFragment.DragViewTouchListener());
  }
  
  public void initTabIndex(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int j = 3;
    int i = 0;
    int k = 1;
    if (paramBoolean1)
    {
      FrameControllerUtil.jdField_a_of_type_Int = 0;
      FrameControllerUtil.jdField_b_of_type_Int = 1;
      FrameControllerUtil.c = 2;
      FrameControllerUtil.jdField_d_of_type_Int = 3;
      FrameControllerUtil.f = -100;
      FrameControllerUtil.jdField_e_of_type_Int = -100;
    }
    else if (paramInt >= 0)
    {
      if (paramInt <= 0) {
        i = 1;
      }
      FrameControllerUtil.jdField_a_of_type_Int = i;
      i = k;
      if (1 >= paramInt) {
        i = 2;
      }
      FrameControllerUtil.c = i;
      if (2 >= paramInt) {
        i = j;
      } else {
        i = 2;
      }
      FrameControllerUtil.jdField_d_of_type_Int = i;
      FrameControllerUtil.f = paramInt;
      FrameControllerUtil.jdField_b_of_type_Int = -100;
      FrameControllerUtil.jdField_e_of_type_Int = -100;
    }
    else
    {
      FrameControllerUtil.jdField_a_of_type_Int = 0;
      FrameControllerUtil.jdField_b_of_type_Int = -100;
      FrameControllerUtil.c = 1;
      FrameControllerUtil.jdField_d_of_type_Int = 2;
      if (paramBoolean2)
      {
        FrameControllerUtil.g = FrameControllerUtil.h;
        FrameControllerUtil.jdField_d_of_type_Int = 3;
      }
      else
      {
        FrameControllerUtil.g = -100;
      }
      FrameControllerUtil.f = -100;
      FrameControllerUtil.jdField_b_of_type_Int = -100;
      FrameControllerUtil.jdField_e_of_type_Int = -100;
    }
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
      case 7: 
      case 8: 
      default: 
        return -2147483648;
      case 10: 
        return FrameControllerUtil.j;
      case 9: 
        return FrameControllerUtil.i;
      case 6: 
        return FrameControllerUtil.f;
      case 5: 
        return FrameControllerUtil.jdField_e_of_type_Int;
      case 4: 
        return FrameControllerUtil.jdField_d_of_type_Int;
      case 3: 
        return FrameControllerUtil.c;
      case 2: 
        return FrameControllerUtil.jdField_b_of_type_Int;
      }
      i = FrameControllerUtil.jdField_a_of_type_Int;
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
    if (paramFrameFragment.jdField_a_of_type_MqqOsMqqHandler == null) {
      paramFrameFragment.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
    }
    paramFrameFragment.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new TabFrameControllerImpl.3(this, paramFrameFragment, paramInt), 100L);
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
    if ((paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray != null) && (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int k = 0;
      while (k < paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int i2 = paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
        Object localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(i2);
        if (localObject1 != null)
        {
          int m;
          label308:
          Object localObject2;
          do
          {
            do
            {
              int j;
              int i;
              Object localObject3;
              if (!paramFrameFragment.h)
              {
                try
                {
                  m = FrameControllerUtil.jdField_a_of_type_Int;
                  j = 2130850741;
                  i = 2130850740;
                  if ((i2 == m) && (SkinEngine.getInstances().checkResExist(2130850738)) && (SkinEngine.getInstances().checkResExist(2130850739)))
                  {
                    i = 2130850738;
                    j = 2130850739;
                  }
                  else if ((i2 != FrameControllerUtil.c) || (!SkinEngine.getInstances().checkResExist(2130850740)) || (!SkinEngine.getInstances().checkResExist(2130850741)))
                  {
                    if ((i2 == FrameControllerUtil.j) && (SkinEngine.getInstances().checkResExist(2130850742)) && (SkinEngine.getInstances().checkResExist(2130850743)))
                    {
                      i = 2130850742;
                      j = 2130850743;
                    }
                    else if ((i2 == FrameControllerUtil.jdField_d_of_type_Int) && (SkinEngine.getInstances().checkResExist(2130850744)) && (SkinEngine.getInstances().checkResExist(2130850745)))
                    {
                      i = 2130850744;
                      j = 2130850745;
                    }
                    else
                    {
                      if ((i2 == FrameControllerUtil.g) && (SkinEngine.getInstances().checkResExist(2130850746)))
                      {
                        boolean bool = SkinEngine.getInstances().checkResExist(2130850747);
                        if (bool)
                        {
                          i = 2130850746;
                          j = 2130850747;
                          break label308;
                        }
                      }
                      i = -1;
                      j = -1;
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
              if ((i != -1) && (j != -1)) {
                m = 1;
              } else {
                m = 0;
              }
              int n = i;
              int i1 = j;
              if (m == 0)
              {
                localObject2 = mFrameInfoBeans;
                n = i;
                i1 = j;
                if (localObject2 != null)
                {
                  localObject2 = ((ArrayList)localObject2).iterator();
                  for (;;)
                  {
                    n = i;
                    i1 = j;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    localObject3 = (FrameInfoBean)((Iterator)localObject2).next();
                    if (((FrameInfoBean)localObject3).a() == i2)
                    {
                      i = ((FrameInfoBean)localObject3).b();
                      j = ((FrameInfoBean)localObject3).c();
                    }
                  }
                }
              }
              if ((n != -1) && (i1 != -1))
              {
                ((TabDragAnimationView)localObject1).setBgDrawable(n);
                ((TabDragAnimationView)localObject1).setBgPressedDrawable(i1);
              }
            } while (paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray == null);
            localObject1 = (TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.get(i2);
          } while (localObject1 == null);
          if ((m == 0) && (!paramFrameFragment.h) && ((i2 != FrameControllerUtil.j) || (QQTheme.c(QQTheme.a())) || (!QQTheme.a("", false)))) {
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
          updateTabSelectStatusOnTabChange(paramFrameFragment, getTabIndexFromName(paramFrameFragment.c()));
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
      paramFrameFragment.jdField_c_of_type_JavaLangString = paramString1;
      return;
    }
    paramFrameFragment.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  public void setCurrentIntentParams(FrameFragment paramFrameFragment)
  {
    try
    {
      Intent localIntent = paramFrameFragment.a().getIntent();
      if (localIntent != null)
      {
        localIntent.putExtra("current_tab_tag", paramFrameFragment.a());
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
    if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView == null) {
      return;
    }
    String str = "";
    Object localObject1;
    if (paramInt1 != 32)
    {
      if (paramInt1 != 33)
      {
        if (paramInt1 != 39) {
          localObject1 = "";
        } else {
          sFrameControllerInjectInterface.a(this, paramFrameFragment, paramInt2);
        }
      }
      else {
        localObject1 = FrameControllerUtil.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      localObject1 = FrameControllerUtil.jdField_a_of_type_JavaLangString;
    }
    Object localObject3 = getTagFromType(paramInt2, (String)localObject1);
    Object localObject2 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("_num");
    localObject2 = (TextView)((HashMap)localObject2).get(((StringBuilder)localObject4).toString());
    if (localObject2 != null)
    {
      if (localObject3 == null) {
        return;
      }
      int i;
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
      localObject4 = PreferenceManager.getDefaultSharedPreferences(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_num");
      if (((String)localObject3).equals(localStringBuilder.toString()))
      {
        localObject4 = ((SharedPreferences)localObject4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        ((SharedPreferences.Editor)localObject4).putInt(localStringBuilder.toString(), i).commit();
      }
      else
      {
        localObject4 = ((SharedPreferences)localObject4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        ((SharedPreferences.Editor)localObject4).putBoolean(localStringBuilder.toString(), bool).commit();
      }
      paramFrameFragment.jdField_b_of_type_JavaUtilHashMap.put(localObject3, paramObject);
      int j = getTabNoteTextStyle(paramFrameFragment.jdField_b_of_type_JavaUtilHashMap, (String)localObject1);
      if (j == sFrameControllerInjectInterface.a(3))
      {
        paramObject = paramFrameFragment.jdField_b_of_type_JavaUtilHashMap;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_num");
        localObject1 = paramObject.get(((StringBuilder)localObject3).toString());
        paramObject = str;
        if ((localObject1 instanceof Integer))
        {
          m = ((Integer)localObject1).intValue();
          paramObject = "";
          break label550;
        }
      }
      else
      {
        paramObject = str;
        if (j == sFrameControllerInjectInterface.a(5))
        {
          paramObject = paramFrameFragment.jdField_b_of_type_JavaUtilHashMap;
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
      int m = 0;
      label550:
      int k;
      if (paramInt1 == 32)
      {
        int n;
        if ((m > 99) && (!SimpleUIUtil.a()))
        {
          j = 2130850776;
          n = paramFrameFragment.getResources().getDimensionPixelSize(2131297341);
          if (paramFrameFragment.h) {
            i = ViewUtils.b(7.0F);
          } else {
            i = ViewUtils.b(5.0F);
          }
          k = sFrameControllerInjectInterface.a(4);
        }
        else
        {
          n = paramFrameFragment.getResources().getDimensionPixelSize(2131297340);
          if (paramFrameFragment.h) {
            i = ViewUtils.b(7.0F);
          } else {
            i = ViewUtils.b(5.0F);
          }
          k = j;
          j = 0;
        }
        localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).setMargins(i, n, 0, 0);
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (hasUnReadRedPacket(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime)) {
          paramFrameFragment.j = false;
        }
        if (!paramFrameFragment.j) {
          updateTabDefaultFocusIcon(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.h, paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray, m);
        }
        i = j;
      }
      else
      {
        i = 0;
        k = j;
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
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("num = ");
        ((StringBuilder)localObject1).append(m);
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
      ((IFrameControllerInterface)localObject1).a((TextView)localObject2, m, paramObject, k, i, ((IFrameControllerInterface)localObject1).a(99));
      if (AppSetting.d) {
        dispatchTabContentDescription(paramFrameFragment, getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
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
          paramRedTouch.c(5);
          if (paramInt == 39) {
            paramRedTouch.c(15);
          }
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramRedTypeInfo.red_content.get());
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699645));
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
        paramRedTouch.c(15);
        setContactAndLebaTabDesc(paramFrameFragment, paramInt, HardCodeUtil.a(2131699644), HardCodeUtil.a(2131699644));
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
    paramString2 = (View)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (paramString2 == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (FrameControllerUtil.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      localStringBuilder.append("消息 ");
    }
    else if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1))
    {
      localStringBuilder.append("联系人 ");
    }
    else if (FrameControllerUtil.jdField_d_of_type_JavaLangString.equals(paramString1))
    {
      localStringBuilder.append("动态 ");
    }
    else
    {
      if (!FrameControllerUtil.jdField_e_of_type_JavaLangString.equals(paramString1)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699648));
      ((StringBuilder)localObject1).append(" ");
      localStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    int i = getTabNoteTextStyle(paramFrameFragment.jdField_b_of_type_JavaUtilHashMap, paramString1);
    Object localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("_num");
    localObject1 = (TextView)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    if (i == sFrameControllerInjectInterface.a(2)) {
      localStringBuilder.append("有更新");
    } else if (i == sFrameControllerInjectInterface.a(3))
    {
      if (FrameControllerUtil.jdField_a_of_type_JavaLangString.equals(paramString1))
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
      else if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1))
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
          localStringBuilder.append(paramFrameFragment.jdField_c_of_type_JavaLangString);
        }
      }
      else if (FrameControllerUtil.jdField_e_of_type_JavaLangString.equals(paramString1))
      {
        localObject2 = ((TextView)localObject1).getText().toString();
        if (((TextView)localObject1).getVisibility() == 0) {
          if ("99+".equals(localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("多于99个新的");
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699648));
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("个新的");
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699648));
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    else if (i == sFrameControllerInjectInterface.a(1)) {
      localStringBuilder.append("有新消息");
    } else if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      localStringBuilder.append(paramFrameFragment.jdField_c_of_type_JavaLangString);
    }
    if (FrameControllerUtil.jdField_d_of_type_JavaLangString.equals(paramString1)) {
      localStringBuilder.append(paramFrameFragment.jdField_d_of_type_JavaLangString);
    }
    paramFrameFragment = (TextView)paramString2.findViewById(2131379917);
    localObject1 = paramString2.findViewById(2131378232);
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
      ((RedTouchTab)paramString2).a().setContentDescription(localStringBuilder.toString());
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
    if (paramFrameFragment.jdField_a_of_type_JavaUtilHashMap == null) {
      return;
    }
    dispatchUpdateTadRedTouch(null, paramFrameFragment, paramInt, paramRedTypeInfo, (IRedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, ""));
  }
  
  public void updateTabSelectStatusOnTabChange(FrameFragment paramFrameFragment, int paramInt)
  {
    Object localObject = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TabDragAnimationView)localObject).setPressChanged(true);
    }
    localObject = (TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramFrameFragment.getResources().getColor(2131167056));
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break;
      }
      if (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) != paramInt) {
        ((TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).setPressChanged(false);
      }
      i += 1;
    }
    while (j < paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      if (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j) != paramInt) {
        ((TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).setTextColor(paramFrameFragment.getResources().getColor(2131167138));
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
      paramFrameFragment.h = FrameControllerUtil.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl
 * JD-Core Version:    0.7.0.1
 */