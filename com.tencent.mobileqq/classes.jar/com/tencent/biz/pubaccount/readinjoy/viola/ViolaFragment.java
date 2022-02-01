package com.tencent.biz.pubaccount.readinjoy.viola;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import aqnr;
import aqru;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.TKDHippyEngine;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tto;
import tty;
import ttz;
import tua;
import tub;
import tuc;
import tud;
import tue;
import tuf;
import tug;
import tuh;
import tui;
import tuj;
import tuk;
import tul;
import tva;
import tvg;
import tvi;
import tzr;
import uhc;
import zmk;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String BUNDLE_PAGE_CONFIG_DATA = "pageConfigParams";
  public static final int COLOR_NOTE_NO_EXIST = 0;
  public static final int COLOR_NOTE_NO_SUPPORT = -1;
  public static final int COLOR_NOTE_STATE_EXIST = 1;
  protected static final String TAG = "ViolaFragment";
  private tty colorNote;
  private aqnr colorNoteController;
  private boolean enableColorSwipeRightFlag = true;
  private boolean hasInitFragment;
  private boolean hasPlayAnimation;
  public HippyQQEngine mHippyQQEngine;
  private boolean mIsStatusFontDark;
  private tuk mViolaGestureLayoutListener;
  public tva mViolaInitDelegate = new tva(this);
  public tvg mViolaUiDelegate = new tvg(this);
  private tul violaTopGestureLayoutListener;
  
  private void finishActivity()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private tul getViolaTopGestureLayout()
  {
    if (this.violaTopGestureLayoutListener == null) {
      this.violaTopGestureLayoutListener = new tul(this, null);
    }
    return this.violaTopGestureLayoutListener;
  }
  
  private void handleTopGestureEvent(boolean paramBoolean)
  {
    if (this.mViolaUiDelegate == null) {}
    TopGestureLayout localTopGestureLayout;
    do
    {
      return;
      localTopGestureLayout = this.mViolaUiDelegate.a();
    } while (localTopGestureLayout == null);
    localTopGestureLayout.setInterceptScrollLRFlag(paramBoolean);
    localTopGestureLayout.setIsInterceptChildEventWhenScroll(paramBoolean);
  }
  
  private void initBaseUI(ViewGroup paramViewGroup)
  {
    this.mViolaUiDelegate.a(paramViewGroup);
  }
  
  private void initDataFromBundle(Bundle paramBundle)
  {
    this.mViolaInitDelegate.a(paramBundle);
  }
  
  private void initHippy(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    Object localObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramBundle.getString("param"));
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      this.mViolaUiDelegate.b(paramViewGroup);
      if (!this.mHippyQQEngine.isReady()) {
        this.mViolaUiDelegate.a();
      }
      this.mViolaUiDelegate.a(paramViewGroup, new tud(this, paramBundle, paramViewGroup));
      this.mHippyQQEngine.initHippy(getContentView(), (JSONObject)localObject, this.mViolaUiDelegate.b(), new tue(this, paramBundle, paramViewGroup));
      return;
    }
  }
  
  private void initViola(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.mViolaUiDelegate.c(paramViewGroup);
        this.mViolaUiDelegate.b(paramViewGroup);
        this.mViolaUiDelegate.a(paramViewGroup, new tuf(this));
        if (getContentView() == null) {
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
        this.mViolaInitDelegate.a(getContentView(), paramBundle, this.mViolaUiDelegate.b(), new tug(this));
        return;
      }
      paramBundle = localJSONObject;
    }
  }
  
  protected static ViolaFragment newInstance(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ViolaFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public static ViolaFragment newInstance(String paramString, ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putSerializable(BUNDLE_PAGE_CONFIG_DATA, paramSerializableMap);
    if (paramBoolean) {
      localBundle.putInt(tvg.b, 1);
    }
    return newInstance(localBundle);
  }
  
  private void playColorNoteAnimation()
  {
    this.hasPlayAnimation = true;
    if (this.colorNoteController != null) {
      this.colorNoteController.d();
    }
    if (this.colorNote != null) {
      this.colorNote.a();
    }
  }
  
  public void addToColorBall()
  {
    if (this.colorNoteController == null) {
      return;
    }
    if (this.colorNoteController.b())
    {
      this.colorNoteController.e();
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690871), 5000).a();
      return;
    }
    this.colorNoteController.i();
  }
  
  public int colorBallState()
  {
    if ((this.colorNoteController == null) || (!aqru.a()) || (!this.colorNoteController.a())) {
      return -1;
    }
    if (this.colorNoteController.c()) {
      return 1;
    }
    return 0;
  }
  
  protected HippyQQEngine createHippyQQEngine(String paramString)
  {
    if (paramString.equals("TKDMiniGame")) {
      return new uhc(this, paramString, getUrl());
    }
    return new TKDHippyEngine(this, paramString, getUrl());
  }
  
  public void dealFlingEnableWhenSwitcher(int paramInt)
  {
    this.mViolaUiDelegate.a(paramInt);
    if (paramInt != 0)
    {
      if (this.colorNoteController == null) {
        return;
      }
      this.colorNoteController.j();
      handleTopGestureEvent(true);
      return;
    }
    enableColorNoteSwipeRight(this.enableColorSwipeRightFlag);
  }
  
  public void disableSwitcher()
  {
    this.mViolaInitDelegate.a();
  }
  
  public void doOnBackPressed()
  {
    this.mViolaInitDelegate.f();
    if (this.mViolaUiDelegate.b()) {
      this.mViolaInitDelegate.a(getContentView(), true);
    }
    do
    {
      return;
      if (this.mViolaUiDelegate.c())
      {
        this.mViolaInitDelegate.g();
        return;
      }
    } while (getActivity() == null);
    getActivity().doOnBackPressed();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = this.mViolaInitDelegate.b();
      if (this.mViolaUiDelegate.b())
      {
        this.mViolaInitDelegate.a(getContentView(), true);
        return true;
      }
      if (this.mViolaUiDelegate.c())
      {
        this.mViolaInitDelegate.g();
        return true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void enableColorNoteSwipeRight(boolean paramBoolean)
  {
    if (this.colorNoteController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.colorNoteController.k();
      handleTopGestureEvent(false);
    }
    for (;;)
    {
      this.enableColorSwipeRightFlag = paramBoolean;
      return;
      this.colorNoteController.j();
      handleTopGestureEvent(true);
    }
  }
  
  public void enableFlingGesture(boolean paramBoolean)
  {
    if (this.mViolaUiDelegate == null) {
      return;
    }
    this.mViolaUiDelegate.b(paramBoolean);
    this.mViolaUiDelegate.a(getViolaTopGestureLayout());
  }
  
  public void enableFlingRight(boolean paramBoolean)
  {
    this.mViolaUiDelegate.b(paramBoolean);
  }
  
  public CommonSuspensionGestureLayout getCommonSuspensionGestureLayout()
  {
    return this.mViolaInitDelegate.a();
  }
  
  public int getContentViewId()
  {
    return 2131558464;
  }
  
  public HashMap<String, Long> getPerformanceData()
  {
    HashMap localHashMap = new HashMap();
    if (this.mHippyQQEngine != null) {
      localHashMap.putAll(this.mHippyQQEngine.getLoadStepsTime());
    }
    localHashMap.put("pageCreateStart", Long.valueOf(this.createViewStartTime));
    localHashMap.put("loadHippyStart", Long.valueOf(this.loadHippyStartTime));
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      localHashMap.put("openPageStart", Long.valueOf(localBundle.getLong("openPageStart")));
    }
    return localHashMap;
  }
  
  protected HippyMap getPropsMap()
  {
    return new HippyMap();
  }
  
  public HashMap getSusConfigMap()
  {
    return this.mViolaUiDelegate.a();
  }
  
  public TopGestureLayout getTopGestureLayout()
  {
    if (this.mViolaUiDelegate == null) {
      return null;
    }
    return this.mViolaUiDelegate.a();
  }
  
  public tvi getTtileChangelistener()
  {
    return this.mViolaUiDelegate.a();
  }
  
  public String getUrl()
  {
    return this.mViolaInitDelegate.a();
  }
  
  public ViolaBaseView getViolaBaseView()
  {
    if (this.mViolaInitDelegate != null) {
      return this.mViolaInitDelegate.a();
    }
    return null;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    initDataFromBundle(paramBundle);
    initBaseUI(paramViewGroup);
    String str = getUrl();
    int i;
    if ((!TextUtils.isEmpty(str)) && (str.contains("v_bundleName")))
    {
      str = Uri.parse(str).getQueryParameter("v_bundleName");
      if (!TextUtils.isEmpty(str))
      {
        i = HippyQQEngine.getModuleOnlineConfig(str);
        QLog.d("Hippy", 1, "Hippy: moduleName=" + str + ", hippyOnlineConfig=" + i);
        if (i == 1)
        {
          this.loadHippyStartTime = System.currentTimeMillis();
          if (this.mHippyQQEngine == null)
          {
            this.mHippyQQEngine = createHippyQQEngine(str);
            this.mHippyQQEngine.setPropsMap(getPropsMap());
          }
          initHippy(paramBundle, paramViewGroup);
        }
      }
    }
    for (;;)
    {
      if (i != 1) {
        initViola(paramBundle, paramViewGroup);
      }
      initSuspension(paramViewGroup);
      initFPS();
      tryInitColorNote(paramBundle);
      return;
      if (onHippyPageLoad(false, "hippyConfig is 0"))
      {
        return;
        i = 0;
      }
    }
  }
  
  public void initBeforeVisible(Bundle paramBundle)
  {
    this.mViolaUiDelegate.a(paramBundle);
  }
  
  protected void initFPS() {}
  
  public void initFragmentLazy(ViewGroup paramViewGroup)
  {
    this.hasInitFragment = true;
    super.initFragmentLazy(paramViewGroup);
  }
  
  public void initSuspension(ViewGroup paramViewGroup)
  {
    if (this.mViolaUiDelegate.b())
    {
      this.mViolaInitDelegate.a(paramViewGroup);
      this.mViolaInitDelegate.a(new tuh(this));
      this.mViolaUiDelegate.a(getViolaTopGestureLayout());
    }
  }
  
  public boolean isSuspension()
  {
    return this.mViolaUiDelegate.b();
  }
  
  public void judgeIfNeedInterruptLToR()
  {
    if (this.mViolaUiDelegate.b()) {
      this.mViolaInitDelegate.a(getContentView(), true);
    }
    do
    {
      return;
      if (this.mViolaUiDelegate.c())
      {
        this.mViolaInitDelegate.g();
        return;
      }
    } while (getActivity() == null);
    getActivity().doOnBackPressed();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mViolaInitDelegate.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((Build.VERSION.SDK_INT >= 21) && (shouldFinishActivity()))
    {
      if (getActivity() == null) {
        break label80;
      }
      getActivity().finishAndRemoveTask();
    }
    try
    {
      for (;;)
      {
        this.mViolaInitDelegate.e();
        ThreadManager.getUIHandler().postDelayed(new ViolaFragment.8(this), 300L);
        label58:
        zmk.a(getActivity());
        if (this.colorNoteController != null) {
          this.colorNoteController.c();
        }
        return;
        label80:
        BaseActivity.sTopActivity.finishAndRemoveTask();
      }
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((!this.mViolaUiDelegate.b()) && (getActivity() != null)) {
      getActivity().overridePendingTransition(0, 2130772012);
    }
  }
  
  public boolean onHippyPageLoad(boolean paramBoolean, String paramString)
  {
    return false;
  }
  
  public void onPause()
  {
    this.mViolaInitDelegate.d();
    super.onPause();
    if (this.colorNoteController != null) {
      this.colorNoteController.b();
    }
  }
  
  public void onResume()
  {
    this.mViolaInitDelegate.c();
    super.onResume();
    if (this.colorNoteController != null) {
      this.colorNoteController.a();
    }
  }
  
  public boolean overrideFinish()
  {
    if ((this.colorNoteController != null) && (!this.hasPlayAnimation))
    {
      playColorNoteAnimation();
      return true;
    }
    return false;
  }
  
  public void reloadHippyInstance()
  {
    this.mViolaUiDelegate.a();
    this.mHippyQQEngine.reload(new ttz(this));
  }
  
  public void reloadPage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.mViolaUiDelegate.a();
    this.mViolaInitDelegate.a(new tui(this));
  }
  
  public void removeColorBall()
  {
    if ((this.colorNoteController == null) || (!this.colorNoteController.c())) {
      return;
    }
    this.colorNoteController.f();
    QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690875), 5000).a();
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.mViolaInitDelegate.c(paramBoolean);
  }
  
  public void setColorBallData(JSONObject paramJSONObject)
  {
    if (this.colorNote == null) {
      return;
    }
    this.colorNote.a(paramJSONObject);
  }
  
  public void setPageData(Object paramObject)
  {
    this.mViolaInitDelegate.a(paramObject);
  }
  
  public void setPageData(Object paramObject, String paramString)
  {
    this.mViolaInitDelegate.a(paramObject, paramString);
  }
  
  public void setPageUiData(Object paramObject)
  {
    this.mViolaUiDelegate.a(paramObject);
  }
  
  public void setTitleConf(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.mViolaUiDelegate.a(paramHashMap, paramViewGroup);
  }
  
  public void setUrl(String paramString1, String paramString2) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.mViolaInitDelegate.a(paramBoolean);
  }
  
  public void setViolaGestureLayoutListener(tuk paramtuk)
  {
    this.mViolaGestureLayoutListener = paramtuk;
  }
  
  protected boolean shouldFinishActivity()
  {
    return true;
  }
  
  public void tryInitColorNote(Bundle paramBundle)
  {
    if (!aqru.a()) {}
    while (!tzr.b(getUrl())) {
      return;
    }
    this.colorNoteController = new aqnr(getActivity(), true, false, true, true, 0);
    this.colorNoteController.a(getActivity());
    this.colorNoteController.a(new tuj(this, paramBundle));
    this.colorNoteController.a(new tua(this));
    this.colorNoteController.a(new tub(this));
    this.colorNoteController.a(new tuc(this));
    this.colorNoteController.j();
  }
  
  public void updateColorBallData(JSONObject paramJSONObject)
  {
    if (this.colorNote == null) {
      return;
    }
    this.colorNote.b(paramJSONObject);
  }
  
  public void updateViolaPage(String paramString, JSONObject paramJSONObject)
  {
    if (this.hasInitFragment)
    {
      if ((getArguments() != null) && (TextUtils.isEmpty(getArguments().getString("url")))) {
        getArguments().putString("url", paramString);
      }
      updateViolaPageByData(paramJSONObject);
    }
    while (getArguments() == null) {
      return;
    }
    getArguments().putString("url", paramString);
  }
  
  public void updateViolaPageByData(JSONObject paramJSONObject)
  {
    this.mViolaUiDelegate.c(true);
    if (!this.mViolaInitDelegate.a()) {
      this.mViolaUiDelegate.a(getViolaTopGestureLayout());
    }
    this.mViolaInitDelegate.b();
    this.mViolaInitDelegate.a(paramJSONObject);
  }
  
  public void updateViolaPageWhenScroll(String paramString)
  {
    this.mViolaInitDelegate.a(paramString);
  }
  
  public void useNightMode()
  {
    FrameLayout localFrameLayout;
    if ((getTitleRootView() != null) && (!TextUtils.isEmpty(getUrl())) && ("1".equals(tto.a(getUrl(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(getActivity().app);
      localFrameLayout = new FrameLayout(getContentView().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      getTitleRootView().addView(localFrameLayout, localLayoutParams);
      if (!bool) {
        break label113;
      }
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(0);
        setStatusBarColor("#ff888888", true);
      }
    }
    label113:
    while (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  public void violaUpdateInstance(String paramString)
  {
    this.mViolaInitDelegate.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */