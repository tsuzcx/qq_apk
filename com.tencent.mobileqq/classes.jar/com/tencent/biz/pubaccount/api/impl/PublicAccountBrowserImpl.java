package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskArticleTimer;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.FadeIconImageView;
import java.util.Map;
import java.util.regex.Pattern;

@RoutePage(desc="PublicAccountBrowser", path="/pubaccount/browser")
public class PublicAccountBrowserImpl
  extends QQBrowserActivity
  implements IPublicAccountBrowser
{
  private static final String BANNER_TIPS = HardCodeUtil.a(2131708765);
  public static final long CONNECT_APPID = 100298324L;
  public static final String FULL_TEXT_URL = "http://s.p.qq.com/pub/msg";
  public static final String FULL_TEXT_URL2 = "http://s.p.qq.com/pub/show";
  public static final String HISTORY_MSG_URL = "http://s.p.qq.com/pub/history";
  protected static final int ITEM_COL_PER_ROW = 3;
  protected static final int ITEM_PER_PAGE = 9;
  public static final String KEY_OPEN_ID = "openid";
  public static final String KEY_TITLE = "title";
  public static final String KEY_TOKEN = "token";
  public static final String PUBLIC_JUMP_URL = "http://s.p.qq.com/pub/jump";
  static final String TAG = "PublicAccountBrowser";
  public final Pattern ARTICLE_TITLE_PATTERN = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
  protected boolean hideLeftView = false;
  public String publicUin = "";
  public String publicUinName = "";
  public int publicUinType = 0;
  private final IRIJRewardTaskArticleTimer rewardTaskTimer = (IRIJRewardTaskArticleTimer)QRoute.api(IRIJRewardTaskArticleTimer.class);
  private FadeIconImageView rightSecondButton;
  
  public PublicAccountBrowserImpl()
  {
    this.mFragmentClass = PublicAccountBrowserImpl.PublicAccountBrowserFragment.class;
  }
  
  private void handleStyleFromUrl(String paramString)
  {
    FadeIconImageView localFadeIconImageView = this.rightSecondButton;
    if (localFadeIconImageView != null) {
      localFadeIconImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      if ((paramString != null) && ("1".equals(paramString.get("showProfileBtn"))))
      {
        paramString = this.rightSecondButton;
        if (paramString != null)
        {
          paramString.setImageResource(2130850474);
          this.rightSecondButton.setOnClickListener(new PublicAccountBrowserImpl.2(this));
          this.rightSecondButton.setContentDescription(super.getText(2131696425));
          this.rightSecondButton.setVisibility(0);
        }
      }
    }
  }
  
  private void initRightButton()
  {
    if (this.rightSecondButton == null) {
      this.rightSecondButton = ((FadeIconImageView)findViewById(2131369221));
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
      paramString.getRuntime();
      paramString = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySP(false, true);
      if (paramString != null)
      {
        paramString = paramString.edit();
        paramString.putString("mLoadingUrl", str);
        paramString.commit();
        paramString = new StringBuilder();
        paramString.append("正在添加url");
        paramString.append(str);
        Log.d("PublicAccountBrowser", paramString.toString());
      }
    }
  }
  
  private void tryStartTiming(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("https://post.mp.qq.com/kan/article/")) {
        return;
      }
      paramString = Uri.parse(paramString).getQueryParameter("rowkey");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab()) {
        this.rewardTaskTimer.startTiming(paramString, ((IRIJRewardTaskConfig)QRoute.api(IRIJRewardTaskConfig.class)).getMaxTaskTimeForArticleInMs());
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    saveUrl(str);
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.a(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    localIntent.putExtra("web_color_note_type", 2);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.publicUin = paramBundle.getString("puin");
      this.publicUinType = paramBundle.getInt("puin_type");
      this.publicUinName = paramBundle.getString("puin_name");
    }
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab())
    {
      this.rewardTaskTimer.resetStationaryTime();
      this.rewardTaskTimer.stopTiming();
    }
    OfficialAccountReporter.a.b(getIntent().getStringExtra("friend_uin"));
  }
  
  protected void doOnResume()
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
      overridePendingTransition(0, 2130771992);
    }
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
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131381075);
    if (localTouchWebView != null) {
      localTouchWebView.addScrollChangedListener(new PublicAccountBrowserImpl.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl
 * JD-Core Version:    0.7.0.1
 */