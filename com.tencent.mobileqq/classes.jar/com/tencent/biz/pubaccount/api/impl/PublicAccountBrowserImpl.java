package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.FadeIconImageView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="PublicAccountBrowser", path="/pubaccount/browser")
public class PublicAccountBrowserImpl
  extends QQBrowserActivity
  implements IPublicAccountBrowser
{
  private static final String BANNER_TIPS = HardCodeUtil.a(2131708759);
  public static final int CALL_FROM_SUBSCRIPT_FULL_RECOMMEND = 1001;
  public static final long CONNECT_APPID = 100298324L;
  public static final String FULL_TEXT_URL = "http://s.p.qq.com/pub/msg";
  public static final String FULL_TEXT_URL2 = "http://s.p.qq.com/pub/show";
  public static final String HISTORY_MSG_URL = "http://s.p.qq.com/pub/history";
  protected static final int ITEM_COL_PER_ROW = 3;
  protected static final int ITEM_PER_PAGE = 9;
  public static final String KEY_FINISH_ANIMATION_OUT_TO_BOTTOM = "public_account_finish_animation_out_to_bottom";
  public static final String KEY_OPEN_ID = "openid";
  public static final String KEY_SLIDE_RIGHT_BACK_ENABLE = "KEY_SLIDE_RIGHT_BACK_ENABLE";
  public static final String KEY_TITLE = "title";
  public static final String KEY_TOKEN = "token";
  public static final String PUBLIC_JUMP_URL = "http://s.p.qq.com/pub/jump";
  static final String TAG = "PublicAccountBrowser";
  public final Pattern ARTICLE_TITLE_PATTERN = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
  protected boolean hideLeftView = false;
  public String publicUin = "";
  public String publicUinName = "";
  public int publicUinType = 0;
  private RIJRewardTaskArticleTimer rewardTaskTimer = new RIJRewardTaskArticleTimer();
  private FadeIconImageView rightSecondButton;
  
  public PublicAccountBrowserImpl()
  {
    this.mFragmentClass = PublicAccountBrowserImpl.PublicAccountBrowserFragment.class;
  }
  
  private void handleStyleFromUrl(String paramString)
  {
    if (this.rightSecondButton != null) {
      this.rightSecondButton.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      if ((paramString != null) && ("1".equals(paramString.get("showProfileBtn"))) && (this.rightSecondButton != null))
      {
        this.rightSecondButton.setImageResource(2130850548);
        this.rightSecondButton.setOnClickListener(new PublicAccountBrowserImpl.2(this));
        this.rightSecondButton.setContentDescription(super.getText(2131696406));
        this.rightSecondButton.setVisibility(0);
      }
    }
  }
  
  private void initRightButton()
  {
    if (this.rightSecondButton == null) {
      this.rightSecondButton = ((FadeIconImageView)findViewById(2131369506));
    }
  }
  
  private void saveUrl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = ReadInJoyHelper.a(paramString.getRuntime(), false, true);
      if (paramString != null)
      {
        paramString = paramString.edit();
        paramString.putString("mLoadingUrl", str);
        paramString.commit();
        Log.d("KandianVideoUpload", "正在添加url" + str);
      }
    }
  }
  
  private void tryStartTiming(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("https://post.mp.qq.com/kan/article/"))) {}
    do
    {
      return;
      paramString = Uri.parse(paramString).getQueryParameter("rowkey");
    } while ((TextUtils.isEmpty(paramString)) || (!RIJRewardTaskArticleTimer.b()));
    this.rewardTaskTimer.a(this);
    this.rewardTaskTimer.a(paramString, RIJRewardTaskConfig.c());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    saveUrl(str);
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    super.disableSwipeLayout();
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_SLIDE_RIGHT_BACK_ENABLE", true))
    {
      super.enableSwipeLayout();
      initColorNote(new PublicAccountCompactSwipeBackLayout(this));
      paramBundle = super.getColorNoteController();
      if (paramBundle != null) {
        paramBundle.g();
      }
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.publicUin = paramBundle.getString("puin");
      this.publicUinType = paramBundle.getInt("puin_type");
      this.publicUinName = paramBundle.getString("puin_name");
    }
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (RIJRewardTaskArticleTimer.b())
    {
      this.rewardTaskTimer.b();
      this.rewardTaskTimer.a();
    }
    OfficialAccountReporter.a.b(getIntent().getStringExtra("friend_uin"));
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    OfficialAccountReporter.a.b();
    String str = getIntent().getStringExtra("url");
    initRightButton();
    new Handler().postDelayed(new PublicAccountBrowserImpl.1(this, str), 200L);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("public_account_finish_animation_out_to_bottom", false)) {
      overridePendingTransition(0, 2130771980);
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote localColorNote = super.getColorNote();
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(getIntent().getStringExtra("url"))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(localColorNote.getReserve()));
      localJSONObject.put("h5_type_read_in_joy", true);
      localColorNote.mReserve = localJSONObject.toString().getBytes();
      return localColorNote;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublicAccountBrowser", 1, localJSONException, new Object[0]);
    }
    return localColorNote;
  }
  
  public String getPubUin()
  {
    return getIntent().getExtras().getString("puin");
  }
  
  public WebAIOController getWebAIOController()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment instanceof PublicAccountBrowserImpl.PublicAccountBrowserFragment)) {
      return ((PublicAccountBrowserImpl.PublicAccountBrowserFragment)localWebViewFragment).a();
    }
    QLog.e("PublicAccountBrowser", 1, "getWebAIOController fragment error");
    return null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131381863);
    if (localTouchWebView != null) {
      localTouchWebView.addScrollChangedListener(new PublicAccountBrowserImpl.3(this));
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl
 * JD-Core Version:    0.7.0.1
 */