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
import apkn;
import apoq;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tgc;
import tgl;
import tgm;
import tgn;
import tgo;
import tgp;
import tgq;
import tgr;
import tgs;
import tgt;
import tgu;
import tgv;
import tgw;
import tgx;
import tgy;
import tgz;
import tho;
import thu;
import thw;
import tmd;
import tsr;
import yxi;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String BUNDLE_PAGE_CONFIG_DATA = "pageConfigParams";
  public static final int COLOR_NOTE_NO_EXIST = 0;
  public static final int COLOR_NOTE_NO_SUPPORT = -1;
  public static final int COLOR_NOTE_STATE_EXIST = 1;
  protected static final String TAG = "ViolaFragment";
  private tgl colorNote;
  private apkn colorNoteController;
  private boolean enableColorSwipeRightFlag = true;
  private boolean hasInitFragment;
  private boolean hasPlayAnimation;
  public HippyQQEngine mHippyQQEngine;
  private boolean mIsStatusFontDark;
  private tgz mViolaGestureLayoutListener;
  public tho mViolaInitDelegate = new tho(this);
  public thu mViolaUiDelegate = new thu(this);
  
  private HippyQQEngine createHippyQQEngine(String paramString)
  {
    if (paramString.equals("TKDMiniGame")) {
      return new tsr(this, paramString, getUrl());
    }
    return new HippyQQEngine(this, paramString, getUrl());
  }
  
  private void finishActivity()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
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
      this.mViolaUiDelegate.a(paramViewGroup, new tgr(this, paramBundle, paramViewGroup));
      this.mHippyQQEngine.initHippy(getContentView(), (JSONObject)localObject, this.mViolaUiDelegate.b(), new tgs(this, paramBundle, paramViewGroup));
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
        this.mViolaUiDelegate.a(paramViewGroup, new tgt(this));
        if (getContentView() == null) {
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
        this.mViolaInitDelegate.a(getContentView(), paramBundle, this.mViolaUiDelegate.b(), new tgu(this));
        return;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private static ViolaFragment newInstance(Bundle paramBundle)
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
      localBundle.putInt(thu.b, 1);
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
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690786), 5000).a();
      return;
    }
    this.colorNoteController.i();
  }
  
  public int colorBallState()
  {
    if ((this.colorNoteController == null) || (!apoq.a()) || (!this.colorNoteController.a())) {
      return -1;
    }
    if (this.colorNoteController.c()) {
      return 1;
    }
    return 0;
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
    return 2131558462;
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
  
  public thw getTtileChangelistener()
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
    int j = 0;
    String str = getUrl();
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      i = j;
      if (str.contains("v_bundleName"))
      {
        str = Uri.parse(str).getQueryParameter("v_bundleName");
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          j = HippyQQEngine.getModuleOnlineConfig(str);
          if (QLog.isColorLevel()) {
            QLog.d("Hippy", 2, "Hippy: moduleName=" + str + ", hippyOnlineConfig=" + j);
          }
          i = j;
          if (j == 1)
          {
            if (this.mHippyQQEngine == null) {
              this.mHippyQQEngine = createHippyQQEngine(str);
            }
            initHippy(paramBundle, paramViewGroup);
            i = j;
          }
        }
      }
    }
    if (i != 1) {
      initViola(paramBundle, paramViewGroup);
    }
    initSuspension(paramViewGroup);
    initFPS();
    tryInitColorNote(paramBundle);
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
      this.mViolaInitDelegate.a(new tgv(this));
      this.mViolaUiDelegate.a(new tgw(this, paramViewGroup));
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
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getActivity() == null) {
        break label74;
      }
      getActivity().finishAndRemoveTask();
    }
    try
    {
      for (;;)
      {
        this.mViolaInitDelegate.e();
        if (this.mHippyQQEngine != null)
        {
          this.mHippyQQEngine.onDestroy();
          this.mHippyQQEngine = null;
        }
        label52:
        yxi.a(getActivity());
        if (this.colorNoteController != null) {
          this.colorNoteController.c();
        }
        return;
        label74:
        BaseActivity.sTopActivity.finishAndRemoveTask();
      }
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((!this.mViolaUiDelegate.b()) && (getActivity() != null)) {
      getActivity().overridePendingTransition(0, 2130772012);
    }
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
    this.mHippyQQEngine.reload(new tgm(this));
  }
  
  public void reloadPage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.mViolaUiDelegate.a();
    this.mViolaInitDelegate.a(new tgx(this));
  }
  
  public void removeColorBall()
  {
    if ((this.colorNoteController == null) || (!this.colorNoteController.c())) {
      return;
    }
    this.colorNoteController.f();
    QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690790), 5000).a();
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
  
  public void setViolaGestureLayoutListener(tgz paramtgz)
  {
    this.mViolaGestureLayoutListener = paramtgz;
  }
  
  public void tryInitColorNote(Bundle paramBundle)
  {
    if (!apoq.a()) {}
    while (!tmd.b(getUrl())) {
      return;
    }
    this.colorNoteController = new apkn(getActivity(), true, false, true, true, 0);
    this.colorNoteController.a(getActivity());
    this.colorNoteController.a(new tgy(this, paramBundle));
    this.colorNoteController.a(new tgn(this));
    this.colorNoteController.a(new tgo(this));
    this.colorNoteController.a(new tgp(this));
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
      this.mViolaUiDelegate.a(new tgq(this));
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
    if ((getTitleRootView() != null) && (!TextUtils.isEmpty(getUrl())) && ("1".equals(tgc.a(getUrl(), "support_night"))))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */