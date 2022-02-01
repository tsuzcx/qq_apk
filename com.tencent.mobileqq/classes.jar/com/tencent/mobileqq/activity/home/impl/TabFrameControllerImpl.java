package com.tencent.mobileqq.activity.home.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.home.FrameControllerInjectUtil;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TabFrameControllerImpl
  implements ITabFrameController
{
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
      if (FrameControllerInjectUtil.a.size() <= 0) {
        break label115;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TabFrameControllerImpl", 1, "TabFrameControllerImpl static statement: ", localException);
      return;
    }
    sFrameControllerInjectInterface = (IFrameControllerInterface)((Class)FrameControllerInjectUtil.a.get(0)).newInstance();
    QLog.d("TabFrameControllerImpl", 1, "TabFrameControllerImpl newInstance");
    label115:
    dispatchRegisterInfo();
  }
  
  private static Object[] collectFrameBusinessCallbacks()
  {
    Object[] arrayOfObject = null;
    synchronized (sFrameBusinessCallbacks)
    {
      if (sFrameBusinessCallbacks.size() > 0) {
        arrayOfObject = sFrameBusinessCallbacks.toArray();
      }
      return arrayOfObject;
    }
  }
  
  static void dispatchOnDoubleTap(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).c(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  static void dispatchRegisterInfo()
  {
    if (mFrameInfoBeans == null) {}
    for (;;)
    {
      return;
      mFrameInfoBeans.clear();
      Object[] arrayOfObject = collectFrameBusinessCallbacks();
      if (arrayOfObject != null)
      {
        int j = arrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          ((IFrameBusinessInterface)arrayOfObject[i]).a();
          i += 1;
        }
      }
    }
  }
  
  public static void registerFrameInfo(FrameInfoBean paramFrameInfoBean)
  {
    if (mFrameInfoBeans == null) {
      return;
    }
    QLog.d("TabFrameControllerImpl", 1, "registerFrameInfo frameInfoBean index: " + paramFrameInfoBean.a() + "ClassName: " + paramFrameInfoBean.a().getName());
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
    QLog.d("TabFrameControllerImpl", 1, "buildFrame before tag: " + paramString);
    int i = 0;
    try
    {
      while (i < mFrameInfoBeans.size())
      {
        FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
        Class localClass = localFrameInfoBean.a();
        String str = localClass.getName();
        QLog.d("TabFrameControllerImpl", 1, "buildFrame matching className: " + str);
        if (paramString.equals(str))
        {
          if (localFrameInfoBean.a()) {}
          for (paramFrameFragment = (Frame)localClass.getConstructor(new Class[] { FrameFragment.class }).newInstance(new Object[] { paramFrameFragment });; paramFrameFragment = (Frame)localClass.newInstance())
          {
            if (paramFrameFragment == null) {
              QLog.d("TabFrameControllerImpl", 1, "buildFrame null tag: " + paramString);
            }
            return paramFrameFragment;
          }
        }
        i += 1;
      }
    }
    catch (Exception paramFrameFragment)
    {
      for (;;)
      {
        QLog.e("TabFrameControllerImpl", 1, "buildFrame error: " + paramFrameFragment);
        paramFrameFragment = null;
      }
    }
  }
  
  public void checkEnableTabAnim(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    int m = 0;
    paramFrameFragment.h = updateIsDefaultTheme();
    if (QLog.isColorLevel()) {
      QLog.d("TabFrameControllerImpl", 2, "checkEnableTabAnim() called with: onPostThemeChanged = [" + paramBoolean + "], mIsDefaultTheme=[" + paramFrameFragment.h + "]");
    }
    float f = paramFrameFragment.getResources().getDisplayMetrics().density;
    int i;
    int n;
    int j;
    label143:
    label151:
    Object localObject1;
    if (paramFrameFragment.h)
    {
      i = Math.round(54.0F * f);
      n = Math.round(6.0F * f);
      if (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray == null) {
        break label344;
      }
      if (!paramFrameFragment.h) {
        break label318;
      }
      j = sFrameControllerInjectInterface.a(paramFrameFragment);
      updateTabDefaultFocusIcon(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.h, paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray, j);
      boolean bool = ThemeUtil.c();
      j = 0;
      if (j >= paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size()) {
        break label344;
      }
      localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.valueAt(j);
      ((TabDragAnimationView)localObject1).c = bool;
      ((TabDragAnimationView)localObject1).a = null;
      if (!paramFrameFragment.h) {
        break label326;
      }
      k = (int)(29.0F * f + 0.5F);
      label209:
      ((TabDragAnimationView)localObject1).setIconSize(k, k);
      ((TabDragAnimationView)localObject1).setAnimEnable(paramFrameFragment.h);
      if (!paramFrameFragment.h) {
        break label332;
      }
      k = 1;
      label237:
      ((TabDragAnimationView)localObject1).setIconGravity(k);
      if (!paramFrameFragment.h) {
        break label338;
      }
    }
    Object localObject2;
    label318:
    label326:
    label332:
    label338:
    for (int k = (int)(5.0F * f + 0.5F);; k = 0)
    {
      ((TabDragAnimationView)localObject1).setPadding(0, k, 0, k);
      localObject2 = new RelativeLayout.LayoutParams(((TabDragAnimationView)localObject1).getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject2).height = i;
      ((TabDragAnimationView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      j += 1;
      break label151;
      i = -2;
      break;
      dispatchResetTabDrag(paramFrameFragment);
      break label143;
      k = -1;
      break label209;
      k = 0;
      break label237;
    }
    label344:
    if (paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray != null)
    {
      j = 0;
      if (j < paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j);
        if (paramFrameFragment.h)
        {
          ((TextView)localObject1).setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = n;
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          j += 1;
          break;
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    if (paramFrameFragment.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = paramFrameFragment.jdField_a_of_type_AndroidViewView.findViewById(16908307);
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((!paramBoolean) && (paramFrameFragment.h))
      {
        long l = System.currentTimeMillis();
        localObject2 = paramFrameFragment.jdField_a_of_type_AndroidViewView.findViewById(16908305);
        if ((localObject1 != null) && (localObject2 != null))
        {
          j = ((View)localObject2).getPaddingBottom();
          if (((i <= 0) || (j == i)) || (QLog.isColorLevel())) {
            QLog.d("TabFrameControllerImpl", 2, "checkEnableTabAnim, height=" + i + ", padding=" + j + ", cost=" + (System.currentTimeMillis() - l));
          }
        }
      }
      localObject2 = paramFrameFragment.jdField_a_of_type_AndroidViewView.findViewById(16908305);
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)paramFrameFragment.jdField_a_of_type_AndroidViewView.findViewById(2131381111));
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDebugTag("TAB");
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      if (paramFrameFragment.a())
      {
        paramFrameFragment.a((View)localObject1, (View)localObject2);
        i = m;
      }
      while (i < paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        ((TabDragAnimationView)localObject1).setEnableClickScaleAnimation(true);
        ((TabDragAnimationView)localObject1).setClickAnimationDrawable(null);
        i += 1;
        continue;
        paramFrameFragment.a((View)localObject1);
        i = m;
      }
      dispatchUpdateFaceId(paramFrameFragment);
    }
  }
  
  void dispatchCommonBusinessOnTabChange(FrameFragment paramFrameFragment, String paramString)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).b(paramFrameFragment, paramString);
        i += 1;
      }
    }
  }
  
  void dispatchOnResumeAfter(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).d(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchOnRevertIconChange(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).e(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchOnTabChangeAfter(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchPostThemeChanged(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchResetTabDrag(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).f(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchResumeUpdateSound(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramHashMap, paramBoolean);
        i += 1;
      }
    }
  }
  
  void dispatchTabContentDescription(FrameFragment paramFrameFragment, String paramString)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramFrameFragment, paramString);
        i += 1;
      }
    }
  }
  
  void dispatchTabDragIconAddTv(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramFrameFragment, paramDragViewTouchListener);
        i += 1;
      }
    }
  }
  
  void dispatchUpdateFaceId(FrameFragment paramFrameFragment)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).b(paramFrameFragment);
        i += 1;
      }
    }
  }
  
  void dispatchUpdateFrameInfo()
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).b();
        i += 1;
      }
    }
  }
  
  void dispatchUpdateFrameOnTabChange(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramFrameFragment, paramInt1, paramFrame, paramInt2);
        i += 1;
      }
    }
  }
  
  void dispatchUpdateTabFocusIcon(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramAppRuntime, paramSparseArray, paramInt);
        i += 1;
      }
    }
  }
  
  void dispatchUpdateTadRedTouch(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    Object[] arrayOfObject = collectFrameBusinessCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((IFrameBusinessInterface)arrayOfObject[i]).a(paramRedTouch, paramFrameFragment, paramInt, paramRedTypeInfo, paramRedTouchManager);
        i += 1;
      }
    }
  }
  
  public void doFramesPauseAfter(FrameFragment paramFrameFragment)
  {
    dispatchOnRevertIconChange(paramFrameFragment);
  }
  
  public void doOnEntry(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    paramFrameFragment.jdField_b_of_type_AndroidContentIntent = paramIntent;
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 1, "doOnNewIntent1 : url" + paramIntent.getStringExtra("url"));
    }
    FrameFragment.e = false;
    if (sFrameControllerInjectInterface.a(paramFrameFragment)) {
      if (QLog.isColorLevel()) {
        QLog.d("doOnEntry", 1, "doCheckOnEntryInvalid");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent);
      localBundle = paramIntent.getExtras();
    } while (localBundle == null);
    if (localBundle.getBoolean("EXIT", false))
    {
      paramFrameFragment.getActivity().finish();
      return;
    }
    int i = -1;
    if (localBundle.containsKey("tab_index")) {
      i = localBundle.getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabFrameControllerImpl", 2, "onNewIntent tabIndex: " + i);
      }
      sFrameControllerInjectInterface.a(paramFrameFragment, paramIntent, localBundle, i);
      return;
      if (localBundle.containsKey("main_tab_id")) {
        i = mainTabID2TabIndex(localBundle);
      }
    }
  }
  
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplication.getContext() == null) {
      return null;
    }
    View localView = View.inflate(BaseApplication.getContext(), 2131563078, null);
    ((DragTextView)localView.findViewById(2131380896)).setDragViewType(2);
    ((TabDragAnimationView)localView.findViewById(2131378843)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131380635)).setText(paramInt5);
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
    Object localObject;
    if ((mFrameInfoBeans == null) || (paramClass == null))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= mFrameInfoBeans.size()) {
        break label66;
      }
      FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
      localObject = localFrameInfoBean;
      if (paramClass.getName().equals(localFrameInfoBean.a().getName())) {
        break;
      }
      i += 1;
    }
    label66:
    return null;
  }
  
  public FrameInfoBean getFrameInfoByIndex(int paramInt)
  {
    Object localObject;
    if (mFrameInfoBeans == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= mFrameInfoBeans.size()) {
        break label53;
      }
      FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
      localObject = localFrameInfoBean;
      if (paramInt == localFrameInfoBean.a()) {
        break;
      }
      i += 1;
    }
    label53:
    return null;
  }
  
  public int getRedTypeByRedTypeInfo(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 0: 
      return 2;
    case 3: 
      return 6;
    case 4: 
      return 5;
    case 5: 
      return 1;
    }
    return 4;
  }
  
  public int getTabIndexFromName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      int i = 0;
      while (i < mFrameInfoBeans.size())
      {
        FrameInfoBean localFrameInfoBean = (FrameInfoBean)mFrameInfoBeans.get(i);
        if (paramString.equals(localFrameInfoBean.a().getName())) {
          return localFrameInfoBean.a();
        }
        i += 1;
      }
    }
  }
  
  public int getTabNoteTextStyle(HashMap<String, Object> paramHashMap, String paramString)
  {
    int i = sFrameControllerInjectInterface.a(0);
    if (paramHashMap == null) {
      return i;
    }
    Object localObject = paramHashMap.get(paramString + "_new");
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      i = sFrameControllerInjectInterface.a(2);
    }
    for (;;)
    {
      return i;
      localObject = paramHashMap.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        i = sFrameControllerInjectInterface.a(3);
      }
      else
      {
        paramHashMap = paramHashMap.get(paramString + "_icon");
        if (((paramHashMap instanceof Boolean)) && (((Boolean)paramHashMap).booleanValue())) {
          i = sFrameControllerInjectInterface.a(1);
        }
      }
    }
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
    case 16: 
      return paramString + "_num";
    case 18: 
      return paramString + "_icon";
    }
    return paramString + "_new";
  }
  
  public void handleThemeChanged(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.g != ((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView != null)) {
        setFrames(paramFrameFragment, false);
      }
      dispatchPostThemeChanged(paramFrameFragment);
      checkEnableTabAnim(paramFrameFragment, true);
      return;
    }
  }
  
  public boolean hasUnReadRedPacket(AppRuntime paramAppRuntime)
  {
    return sFrameControllerInjectInterface.a(paramAppRuntime);
  }
  
  public void initTabDragIconsAbdTextVuews(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    dispatchTabDragIconAddTv(paramFrameFragment, new FrameFragment.DragViewTouchListener());
  }
  
  public void initTabIndex(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = 0;
    int j = 2;
    int k = 1;
    if (paramBoolean1)
    {
      FrameControllerUtil.jdField_a_of_type_Int = 0;
      FrameControllerUtil.jdField_b_of_type_Int = 1;
      FrameControllerUtil.c = 2;
      FrameControllerUtil.jdField_d_of_type_Int = 3;
      FrameControllerUtil.f = -100;
    }
    for (FrameControllerUtil.jdField_e_of_type_Int = -100;; FrameControllerUtil.jdField_e_of_type_Int = -100)
    {
      dispatchUpdateFrameInfo();
      return;
      if (paramInt < 0) {
        break;
      }
      if (paramInt <= 0) {
        i = 1;
      }
      FrameControllerUtil.jdField_a_of_type_Int = i;
      i = k;
      if (1 >= paramInt) {
        i = 2;
      }
      FrameControllerUtil.c = i;
      i = j;
      if (2 >= paramInt) {
        i = 3;
      }
      FrameControllerUtil.jdField_d_of_type_Int = i;
      FrameControllerUtil.f = paramInt;
      FrameControllerUtil.jdField_b_of_type_Int = -100;
    }
    FrameControllerUtil.jdField_a_of_type_Int = 0;
    FrameControllerUtil.jdField_b_of_type_Int = -100;
    FrameControllerUtil.c = 1;
    FrameControllerUtil.jdField_d_of_type_Int = 2;
    if (paramBoolean2)
    {
      FrameControllerUtil.g = FrameControllerUtil.h;
      FrameControllerUtil.jdField_d_of_type_Int = 3;
    }
    for (;;)
    {
      FrameControllerUtil.f = -100;
      FrameControllerUtil.jdField_b_of_type_Int = -100;
      FrameControllerUtil.jdField_e_of_type_Int = -100;
      break;
      FrameControllerUtil.g = -100;
    }
  }
  
  public View[] initTabs(FrameFragment paramFrameFragment, View paramView)
  {
    return sFrameControllerInjectInterface.a(this, paramFrameFragment, paramView);
  }
  
  public boolean isFragmentNotMatch()
  {
    return sFrameControllerInjectInterface.a();
  }
  
  public boolean isLebaHasRedPoint(HashMap<String, View> paramHashMap)
  {
    paramHashMap = (RedTouch)paramHashMap.get(FrameControllerUtil.jdField_d_of_type_JavaLangString);
    if (paramHashMap == null) {
      return false;
    }
    return paramHashMap.c();
  }
  
  public int mainTabID2TabIndex(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("main_tab_id"))) {
      return -2147483648;
    }
    switch (paramBundle.getInt("main_tab_id"))
    {
    case 7: 
    case 8: 
    default: 
      return -2147483648;
    case 1: 
      return FrameControllerUtil.jdField_a_of_type_Int;
    case 2: 
      return FrameControllerUtil.jdField_b_of_type_Int;
    case 3: 
      return FrameControllerUtil.c;
    case 4: 
      return FrameControllerUtil.jdField_d_of_type_Int;
    case 5: 
      return FrameControllerUtil.jdField_e_of_type_Int;
    case 6: 
      return FrameControllerUtil.f;
    case 9: 
      return FrameControllerUtil.i;
    }
    return FrameControllerUtil.j;
  }
  
  public void onDrawCompleteAfter(FrameFragment paramFrameFragment)
  {
    sFrameControllerInjectInterface.a(this, paramFrameFragment);
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
  
  public void realUpdateRedTouch(RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTouch != null)
    {
      paramRedTouch.a();
      paramRedTouch.a(paramRedTypeInfo);
    }
  }
  
  public void revertTabIconChange(FrameFragment paramFrameFragment)
  {
    sFrameControllerInjectInterface.a(paramFrameFragment);
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
      Intent localIntent = paramFrameFragment.getActivity().getIntent();
      if (localIntent != null) {
        localIntent.putExtra("current_tab_tag", paramFrameFragment.a());
      }
      return;
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
    if ((paramHashMap == null) || (paramHashMap.get(paramString) == null)) {
      return;
    }
    ((View)paramHashMap.get(paramString)).setSoundEffectsEnabled(paramBoolean);
  }
  
  public void updateCommonBusinessOnTabChange(FrameFragment paramFrameFragment, String paramString)
  {
    dispatchCommonBusinessOnTabChange(paramFrameFragment, paramString);
  }
  
  public void updateFrames(FrameFragment paramFrameFragment, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    Object localObject;
    label49:
    String str;
    TextView localTextView;
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        localObject = "";
        str = getTagFromType(paramInt2, (String)localObject);
        localTextView = (TextView)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get((String)localObject + "_num");
      }
    } while ((localTextView == null) || (str == null));
    int i;
    boolean bool;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      bool = false;
    }
    for (;;)
    {
      label122:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getApp());
      label208:
      int k;
      if (str.equals((String)localObject + "_num"))
      {
        localSharedPreferences.edit().putInt(str + paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getAccount(), i).commit();
        paramFrameFragment.jdField_b_of_type_JavaUtilHashMap.put(str, paramObject);
        k = getTabNoteTextStyle(paramFrameFragment.jdField_b_of_type_JavaUtilHashMap, (String)localObject);
        if (k != sFrameControllerInjectInterface.a(3)) {
          break label736;
        }
        paramObject = paramFrameFragment.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        if (!(paramObject instanceof Integer)) {
          break label879;
        }
        i = ((Integer)paramObject).intValue();
        paramObject = "";
      }
      for (;;)
      {
        label299:
        int m = 0;
        int j;
        label348:
        int i1;
        int n;
        if (paramInt1 == 32) {
          if ((i > 99) && (!SimpleUIUtil.a()))
          {
            m = paramFrameFragment.getResources().getDimensionPixelSize(2131297352);
            if (paramFrameFragment.h)
            {
              j = ViewUtils.b(7.0F);
              i1 = sFrameControllerInjectInterface.a(4);
              k = 2130850839;
              n = j;
              j = i1;
              i1 = m;
              localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
              if (localObject != null)
              {
                ((RelativeLayout.LayoutParams)localObject).setMargins(n, i1, 0, 0);
                localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              if (hasUnReadRedPacket(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime)) {
                paramFrameFragment.j = false;
              }
              if (!paramFrameFragment.j) {
                updateTabDefaultFocusIcon(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.h, paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray, i);
              }
            }
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(j).append(",").append("num = ").append(i).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
            QLog.d("TabFrameControllerImpl", 4, ((StringBuilder)localObject).toString());
          }
          sFrameControllerInjectInterface.a(localTextView, i, paramObject, j, k, sFrameControllerInjectInterface.a(99));
          if (!AppSetting.d) {
            break;
          }
          dispatchTabContentDescription(paramFrameFragment, getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
          return;
          localObject = FrameControllerUtil.jdField_a_of_type_JavaLangString;
          break label49;
          localObject = FrameControllerUtil.jdField_b_of_type_JavaLangString;
          break label49;
          sFrameControllerInjectInterface.a(this, paramFrameFragment, paramInt2);
          return;
          if (!(paramObject instanceof Boolean)) {
            break label890;
          }
          bool = ((Boolean)paramObject).booleanValue();
          i = 0;
          break label122;
          localSharedPreferences.edit().putBoolean(str + paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getAccount(), bool).commit();
          break label208;
          label736:
          if (k != sFrameControllerInjectInterface.a(5)) {
            break label879;
          }
          paramObject = paramFrameFragment.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_text");
          if (!(paramObject instanceof String)) {
            break label879;
          }
          paramObject = (String)paramObject;
          i = 0;
          break label299;
          j = ViewUtils.b(5.0F);
          break label348;
          i1 = paramFrameFragment.getResources().getDimensionPixelSize(2131297351);
          if (paramFrameFragment.h) {}
          for (j = ViewUtils.b(7.0F);; j = ViewUtils.b(5.0F))
          {
            m = k;
            k = 0;
            n = j;
            j = m;
            break;
          }
          j = k;
          k = m;
        }
        label879:
        i = 0;
        paramObject = "";
      }
      label890:
      i = 0;
      bool = false;
    }
  }
  
  public boolean updateIsDefaultTheme()
  {
    String str = ThemeUtil.a();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public void updateRedTouch(FrameFragment paramFrameFragment, int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    String str3;
    if ((paramRedTouch != null) && (paramRedTypeInfo != null))
    {
      switch (paramRedTypeInfo.red_type.get())
      {
      }
      for (;;)
      {
        realUpdateRedTouch(paramRedTouch, paramRedTypeInfo);
        return;
        paramRedTouch.c(15);
        setContactAndLebaTabDesc(paramFrameFragment, paramInt, HardCodeUtil.a(2131706430), HardCodeUtil.a(2131706430));
        continue;
        paramRedTouch.c(5);
        if (paramInt == 39) {
          paramRedTouch.c(15);
        }
        str3 = paramRedTypeInfo.red_content.get() + HardCodeUtil.a(2131706432);
        String str1 = paramRedTypeInfo.red_content.get();
        try
        {
          if (Integer.parseInt(str1) <= 99) {
            break;
          }
          str1 = "多于99条更新";
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
            String str2 = str3;
          }
        }
        setContactAndLebaTabDesc(paramFrameFragment, paramInt, str1, str3);
      }
    }
    realUpdateRedTouch(paramRedTouch, null);
    setContactAndLebaTabDesc(paramFrameFragment, paramInt, "", "");
  }
  
  public void updateTabContentDescription(FrameFragment paramFrameFragment, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label52:
    int i;
    Object localObject;
    if (FrameControllerUtil.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      i = getTabNoteTextStyle(paramFrameFragment.jdField_b_of_type_JavaUtilHashMap, paramString1);
      localObject = (TextView)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i != sFrameControllerInjectInterface.a(2)) {
        break label295;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if (FrameControllerUtil.jdField_d_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(paramFrameFragment.jdField_d_of_type_JavaLangString);
      }
      paramFrameFragment = (TextView)paramString2.findViewById(2131380635);
      localObject = paramString2.findViewById(2131378843);
      if (localObject != null)
      {
        ((View)localObject).setContentDescription(paramString1);
        AccessibilityUtil.a((View)localObject, false);
      }
      if (paramFrameFragment != null) {
        AccessibilityUtil.a(paramFrameFragment, false);
      }
      if (!(paramString2 instanceof RedTouchTab)) {
        break label643;
      }
      ((RedTouchTab)paramString2).a().setContentDescription(localStringBuilder.toString());
      return;
      if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1))
      {
        localStringBuilder.append("联系人 ");
        break label52;
      }
      if (FrameControllerUtil.jdField_d_of_type_JavaLangString.equals(paramString1))
      {
        localStringBuilder.append("动态 ");
        break label52;
      }
      if (!FrameControllerUtil.jdField_e_of_type_JavaLangString.equals(paramString1)) {
        break;
      }
      localStringBuilder.append(HardCodeUtil.a(2131710787) + " ");
      break label52;
      label295:
      if (i == sFrameControllerInjectInterface.a(3))
      {
        if (FrameControllerUtil.jdField_a_of_type_JavaLangString.equals(paramString1))
        {
          localObject = ((TextView)localObject).getText().toString();
          if ("".equals(localObject)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append((String)localObject + "条未读");
          }
        }
        else
        {
          String str;
          if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0)
            {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99条更新");
              } else {
                localStringBuilder.append(str + "条更新");
              }
            }
            else {
              localStringBuilder.append(paramFrameFragment.jdField_c_of_type_JavaLangString);
            }
          }
          else if (FrameControllerUtil.jdField_e_of_type_JavaLangString.equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个新的" + HardCodeUtil.a(2131710787));
              } else {
                localStringBuilder.append(str + "个新的" + HardCodeUtil.a(2131710787));
              }
            }
          }
        }
      }
      else if (i == sFrameControllerInjectInterface.a(1)) {
        localStringBuilder.append("有新消息");
      } else if (FrameControllerUtil.jdField_b_of_type_JavaLangString.equals(paramString1)) {
        localStringBuilder.append(paramFrameFragment.jdField_c_of_type_JavaLangString);
      }
    }
    label643:
    paramString2.setContentDescription(localStringBuilder.toString());
  }
  
  public void updateTabDefaultFocusIcon(AppRuntime paramAppRuntime, boolean paramBoolean, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    if ((!paramBoolean) || (paramSparseArray == null))
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder().append("mIsDefaultTheme = ").append(paramBoolean).append(", mTabDragIcon is null ");
        if (paramSparseArray != null) {
          break label60;
        }
      }
      label60:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("DynimiIcon", 2, paramBoolean);
        return;
      }
    }
    dispatchUpdateTabFocusIcon(paramAppRuntime, paramSparseArray, paramInt);
  }
  
  public void updateTabRedTouch(FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramFrameFragment.jdField_a_of_type_JavaUtilHashMap == null) {
      return;
    }
    dispatchUpdateTadRedTouch(null, paramFrameFragment, paramInt, paramRedTypeInfo, (RedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH));
  }
  
  public void updateTabSelectStatusOnTabChange(FrameFragment paramFrameFragment, int paramInt)
  {
    int k = 0;
    Object localObject = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TabDragAnimationView)localObject).setPressChanged(true);
    }
    localObject = (TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramFrameFragment.getResources().getColor(2131167235));
    }
    int i = 0;
    int j = k;
    if (i < paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) == paramInt) {}
      for (;;)
      {
        i += 1;
        break;
        ((TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).setPressChanged(false);
      }
    }
    if (j < paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      if (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j) == paramInt) {}
      for (;;)
      {
        j += 1;
        break;
        ((TextView)paramFrameFragment.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).setTextColor(paramFrameFragment.getResources().getColor(2131167234));
      }
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
      paramFrameFragment.h = updateIsDefaultTheme();
      updateTabSelectStatusOnTabChange(paramFrameFragment, j);
      onTabChangeDelayAction(paramFrameFragment, j);
      dispatchOnTabChangeAfter(paramFrameFragment);
      return;
    }
    catch (Exception paramFrameFragment)
    {
      QLog.e("TabFrameControllerImpl", 1, "updateUIAfterTabChange excetpion: " + paramFrameFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl
 * JD-Core Version:    0.7.0.1
 */