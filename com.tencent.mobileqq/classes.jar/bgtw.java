import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgtw
{
  static final int RIGHT_CORNER_RED_DOT = 10000;
  public static final String TAG = "WebLog_SwiftIphoneTitleBarUI";
  public RelativeLayout centerContainer;
  public TextView centerView;
  Intent intent;
  boolean isRecordTitleLeftDrawable;
  boolean isRecordTitleRightDrawable;
  private int lastTitleBarButtonColor;
  public FadeIconImageView leftCloseView;
  public TextView leftView;
  int mAfterDivideAlpha = 255;
  String mAfterTitle = null;
  bfzz<Integer> mAnimUpdateListener = new bgtx(this);
  boolean mAutoHandleScroll = false;
  int mBeforeDivideAlpha = 0;
  String mBeforeTitle = null;
  int mDividePosition = 240;
  Animation mFadeIn;
  Animation mFadeOut;
  boolean mIsSetOnScrollListener = false;
  boolean mIsShade = true;
  private View mMiniViewLayout;
  TouchWebView.OnScrollChangedListener mOnScrollChangedListener = new bgty(this);
  public String mRightButtonCallback;
  public acjr mRightButtonCallback2;
  public JsBridgeListener mRightButtonListener;
  public ImageView mRightCornerIcon;
  int mScrollPos = 0;
  public boolean mShowRightCornerRedDot;
  int mTitleAlpha = -1;
  Drawable mTitleLeftDrawable;
  public WebViewTopTabView mTopSubTabView;
  public bgyi mTopTabHelper;
  public SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle mUIStyle;
  public SwiftBrowserUIStyleHandler mUIStyleHandler;
  public View mWarnCloseView;
  public ImageView mWarnIconView;
  public TextView mWarnTextView;
  public View mWarnToastView;
  @Nullable
  private Intent mWebViewFragmentIntent;
  String mWebViewScrollChangeCb = null;
  private boolean needResetTitleBarButtonColor;
  public TextView rightHighLView;
  public ImageView rightViewImg;
  public TextView rightViewText;
  public QuickPinyinEditText searchBarBackTitle;
  public ViewGroup subTitle;
  public ViewGroup titleContainer;
  
  public bgtw(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.mUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.mUIStyle = paramSwiftBrowserUIStyleHandler.mUIStyle;
    this.mTopTabHelper = new bgyi(paramSwiftBrowserUIStyleHandler);
  }
  
  private void blockRightViewImgIfNeed()
  {
    if ((this.mWebViewFragmentIntent == null) || (this.rightViewImg == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = audj.a().c();
      bool2 = this.mWebViewFragmentIntent.getBooleanExtra("fromAio", false);
    } while ((!bool1) || (!bool2));
    this.rightViewImg.setVisibility(8);
  }
  
  @TargetApi(17)
  public boolean adjustContentViewToTop()
  {
    if ((!this.mUIStyleHandler.mUIStyle.isTransparentTitle) && (!this.mUIStyle.isTransparentTitleAndClickable) && (this.titleContainer != null) && (this.mUIStyleHandler.mRootView != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.mUIStyleHandler.mRootView.findViewById(2131363713);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.mUIStyleHandler.mRootView.findViewById(2131381053);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299083);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  public void doTransparent(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    if (paramJSONObject != null) {}
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.mUIStyle.mCanTransparentTitlebar))
      {
        this.mUIStyle.mCanTransparentTitlebar = adjustContentViewToTop();
        if ((this.mUIStyle.isNeedSetBrowserTipsPadding) && (this.mUIStyleHandler.mBrowserTips != null)) {
          this.mUIStyleHandler.mBrowserTips.setPadding(0, (int)bfvh.a(BaseApplicationImpl.getApplication(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        return;
      }
      if (!this.mUIStyle.mCanTransparentTitlebar) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "titlebar config:" + paramJSONObject.toString());
      }
      localViewGroup = this.titleContainer;
      if (localViewGroup == null) {
        return;
      }
      if (!paramBoolean) {
        break label660;
      }
      localObject2 = paramJSONObject.optString("bgclr", "");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label799;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("#")) {
        localObject1 = "#" + (String)localObject2;
      }
      i = Color.parseColor((String)localObject1);
    }
    catch (Exception paramJSONObject)
    {
      ViewGroup localViewGroup;
      Object localObject2;
      Object localObject1;
      int i;
      label660:
      while (QLog.isColorLevel())
      {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "game center,doTransparent error:" + paramJSONObject.toString());
        return;
        localViewGroup.getBackground().mutate().setAlpha(j);
        this.mUIStyle.mCurrentAlpha = j;
        return;
        continue;
        i = -1;
        continue;
        localObject1 = localObject2;
        continue;
        label799:
        localObject1 = localObject2;
        i = -1;
      }
    }
    localViewGroup.setBackgroundColor(i);
    if ((this.mUIStyleHandler.mHostFragment != null) && (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null))
    {
      localObject2 = paramJSONObject.optString("statusclr", "");
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).startsWith("#"))
        {
          localObject1 = "#" + (String)localObject1;
          i = Color.parseColor((String)localObject1);
        }
      }
      else
      {
        this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(i);
        bbyp.a(true, i, this.mUIStyleHandler.mHostActivity.getWindow());
      }
    }
    else
    {
      localObject2 = paramJSONObject.optString("txtclr", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("#")) {
          localObject1 = "#" + (String)localObject2;
        }
        i = Color.parseColor((String)localObject1);
        this.leftView.setTextColor(i);
        if ((this.leftCloseView != null) && (this.leftCloseView.getVisibility() == 0))
        {
          localObject1 = bfvo.a(this.leftCloseView.getDrawable(), i);
          if (localObject1 != null) {
            this.leftCloseView.setImageDrawable((Drawable)localObject1);
          }
        }
        this.rightViewText.setTextColor(i);
        localObject1 = bfvo.a(this.leftView.getBackground(), i);
        if (localObject1 != null) {
          this.leftView.setBackgroundDrawable((Drawable)localObject1);
        }
        localObject1 = bfvo.a(this.rightViewImg.getDrawable(), i);
        if (localObject1 != null)
        {
          this.rightViewImg.setImageDrawable((Drawable)localObject1);
          setConversationBtnColor(i);
        }
        localObject1 = this.mMiniViewLayout.findViewById(2131371151);
        localObject2 = bfvo.a(((View)localObject1).getBackground(), i);
        if (localObject2 != null) {
          ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
        }
        localObject1 = paramJSONObject.optString("titleclr", "");
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!((String)localObject1).startsWith("#"))
          {
            localObject1 = "#" + (String)localObject1;
            i = Color.parseColor((String)localObject1);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.centerView.getText())) && (!TextUtils.isEmpty(this.mUIStyleHandler.webViewTitle))) {
            this.centerView.setText(this.mUIStyleHandler.webViewTitle);
          }
          this.centerView.setTextColor(i);
          if (paramJSONObject.optInt("trans", -1) == 0) {
            return;
          }
          paramBoolean = paramJSONObject.optBoolean("anim", false);
          i = paramJSONObject.optInt("dur", 0);
          j = paramJSONObject.optInt("alpha", 0);
          if ((paramBoolean) && (i > 0))
          {
            runTitleBarAnimation(localViewGroup, this.mUIStyle.mCurrentAlpha, j, i);
            return;
          }
        }
      }
    }
  }
  
  public void enableTitlebarBgGrandualChange(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.titleContainer;
    if ((this.mUIStyle.isGrandualChangeTitlebarBg) && (localViewGroup != null) && (!this.mUIStyle.mCanTransparentTitlebar) && (adjustContentViewToTop()))
    {
      this.mUIStyle.mCanTransparentTitlebar = true;
      this.mUIStyle.needSetTitlebarTextColor = true;
      this.mUIStyle.needTitlebarTranslucent = true;
      localViewGroup.setBackgroundResource(2130850751);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.rightViewImg.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListenerForBiz(new bgub(this));
    }
  }
  
  public View getMiniViewLayout()
  {
    return this.mMiniViewLayout;
  }
  
  public String getTitle()
  {
    if (this.centerView == null) {
      return "";
    }
    return this.centerView.getText().toString();
  }
  
  @TargetApi(11)
  public JSONObject getTitleBarConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localJSONObject = new JSONObject();
        try
        {
          paramString = Uri.parse(paramString);
          Object localObject = paramString.getQueryParameterNames();
          if ((localObject != null) && (((Set)localObject).size() != 0))
          {
            localObject = ((Set)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              if (str1.contains("_nav_"))
              {
                String str2 = paramString.getQueryParameter(str1);
                localJSONObject.put(str1.replace("_nav_", ""), str2);
                continue;
                return paramString;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", paramString);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      paramString = localJSONObject;
    }
  }
  
  public int getTopTabSelection()
  {
    if (this.mTopSubTabView != null)
    {
      int i = 0;
      while (i < this.mTopSubTabView.getChildCount())
      {
        if (((RadioButton)this.mTopSubTabView.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void hideCloseButton()
  {
    if (this.rightViewText != null) {
      this.rightViewText.setVisibility(8);
    }
    if (this.rightViewImg != null)
    {
      this.rightViewImg.setVisibility(0);
      blockRightViewImgIfNeed();
    }
  }
  
  public final void init(Intent paramIntent, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(this.mUIStyleHandler.mRootView.getContext()).inflate(2131558763, this.mUIStyleHandler.mRootView);
    this.mWebViewFragmentIntent = paramIntent;
    this.titleContainer = ((ViewGroup)this.mUIStyleHandler.mRootView.findViewById(2131376501));
    setLayerType(this.titleContainer);
    this.mMiniViewLayout = this.titleContainer.findViewById(2131376654);
    this.mMiniViewLayout.setVisibility(8);
    this.mMiniViewLayout.setPadding(0, -ViewUtils.dpToPx(12.0F), 0, 0);
    this.leftView = ((TextView)this.titleContainer.findViewById(2131369068));
    this.leftView.setOnClickListener(paramOnClickListener);
    setLayerType(this.leftView);
    if (AppSetting.c) {
      bfpm.b(this.leftView, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.leftView.setBackgroundDrawable(null);
    }
    this.leftCloseView = ((FadeIconImageView)this.titleContainer.findViewById(2131369071));
    this.leftCloseView.setOnClickListener(paramOnClickListener);
    this.leftCloseView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689850));
    setLeftViewName(paramIntent);
    this.centerView = ((TextView)this.titleContainer.findViewById(2131369115));
    this.centerContainer = ((RelativeLayout)this.titleContainer.findViewById(2131376633));
    this.rightViewText = ((TextView)this.titleContainer.findViewById(2131369099));
    this.rightViewImg = ((ImageView)this.titleContainer.findViewById(2131369082));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    this.rightViewText.setOnClickListener(paramOnClickListener);
    this.rightViewImg.setOnClickListener(paramOnClickListener);
    this.mWarnToastView = this.mUIStyleHandler.mRootView.findViewById(2131378889);
    this.mWarnIconView = ((ImageView)this.mWarnToastView.findViewById(2131378887));
    this.mWarnTextView = ((TextView)this.mWarnToastView.findViewById(2131378890));
    this.mWarnCloseView = this.mWarnToastView.findViewById(2131378886);
    this.mWarnCloseView.setOnClickListener(new bgtz(this));
    this.subTitle = ((ViewGroup)this.titleContainer.findViewById(2131378762));
    removeWebViewLayerType();
    setOnScrollChangedCallback(this.mWebViewScrollChangeCb);
    initPreView();
  }
  
  public void initDefaultThemeTitleBar()
  {
    if (this.mUIStyle.mIsDefaultTheme)
    {
      if ((!this.mUIStyle.isTransparentTitle) && (!this.mUIStyle.isTransparentTitleAndClickable))
      {
        Resources localResources = this.mUIStyleHandler.mHostActivity.getResources();
        this.titleContainer.setBackgroundColor(localResources.getColor(2131167241));
        if ((this.mUIStyleHandler.mHostFragment != null) && (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null)) {
          this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(0);
        }
      }
      this.leftView.setTextColor(-1);
      this.rightViewText.setTextColor(-1);
      this.centerView.setTextColor(-1);
      this.mUIStyleHandler.setDefaultThemeIcon(this.leftView, true, 2130850030, 2130850593);
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130840333, 2130840329);
    }
  }
  
  public void initPreView() {}
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    int k = 2;
    String[] arrayOfString = null;
    int j = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (this.mUIStyle.isFullScreen)) {
      return;
    }
    Object localObject;
    if ((this.mUIStyle.mRulesFromUrl & 0x4) == 0L)
    {
      if (!bgyb.a()) {
        this.leftView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131690599));
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      localObject = paramIntent.getStringExtra("title");
      this.mUIStyle.mIsHideRefresh = paramIntent.getBooleanExtra("ishiderefresh", false);
      this.mUIStyle.mIsHideBackForward = paramIntent.getBooleanExtra("ishidebackforward", false);
      boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
      this.mUIStyle.mShowRightCloseButton = paramIntent.getBooleanExtra("show_right_close_button", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "QQBrowser url=" + npn.b(paramString, new String[0]));
      }
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label688;
      }
      this.centerView.setText((CharSequence)localObject);
      label224:
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131690591));
      if (!this.mUIStyle.hideMore)
      {
        this.rightViewImg.setVisibility(0);
        localObject = this.rightViewImg.getResources().getDrawable(2130840333);
        if ((!this.mUIStyleHandler.mUIStyle.isTransparentTitle) && (!this.mUIStyle.isTransparentTitleAndClickable)) {
          break label701;
        }
        paramString = bfvo.a((Drawable)localObject, -1);
        label306:
        this.rightViewImg.setImageDrawable(paramString);
        this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692442));
        blockRightViewImgIfNeed();
      }
      if (needShowConversationBtn())
      {
        if ((!this.mUIStyleHandler.mUIStyle.isTransparentTitle) && (!this.mUIStyle.isTransparentTitleAndClickable)) {
          break label733;
        }
        setConversationBtnColor(-1);
      }
      label372:
      if (bool) {
        this.leftView.setVisibility(4);
      }
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label858;
      }
    }
    label688:
    label701:
    label845:
    label858:
    for (int i = ImmersiveUtils.getStatusBarHeight(this.mUIStyleHandler.mHostActivity) + 0;; i = 0)
    {
      for (;;)
      {
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        int n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.titleContainer.measure(m, n);
        i += this.titleContainer.getMeasuredHeight();
        if (this.mUIStyle.isHideTitleBar)
        {
          m = this.titleContainer.getTop();
          n = this.titleContainer.getBottom();
          this.titleContainer.layout(this.titleContainer.getLeft(), m - i, this.titleContainer.getRight(), n - i);
          this.titleContainer.setVisibility(8);
          label506:
          if (this.mUIStyle.mShowRightCloseButton) {
            showCloseButton(paramIntent.getStringExtra("left_close_button_text"));
          }
          if (TextUtils.isEmpty(this.mUIStyle.mControlParam)) {
            break label845;
          }
        }
        try
        {
          paramIntent = new JSONObject(URLDecoder.decode(this.mUIStyle.mControlParam));
          i = k;
          if (paramIntent.has("tabNum")) {
            i = paramIntent.getInt("tabNum");
          }
          if (paramIntent.has("subTextArray")) {}
          for (paramIntent = paramIntent.getJSONArray("subTextArray");; paramIntent = null)
          {
            paramString = arrayOfString;
            if (paramIntent == null) {
              break label823;
            }
            paramString = arrayOfString;
            if (paramIntent.length() <= 0) {
              break label823;
            }
            arrayOfString = new String[paramIntent.length()];
            for (;;)
            {
              paramString = arrayOfString;
              if (j >= paramIntent.length()) {
                break;
              }
              arrayOfString[j] = paramIntent.getString(j);
              j += 1;
            }
            if (!paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
              break;
            }
            this.leftView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131690599));
            break;
            this.centerView.setText("");
            break label224;
            paramString = (String)localObject;
            if (this.mUIStyle.mTitleStyle == null) {
              break label306;
            }
            paramString = bfvo.a((Drawable)localObject, this.mUIStyle.mTitleStyle.leftAndRightBtnColor);
            break label306;
            label733:
            if (this.mUIStyle.mTitleStyle == null) {
              break label372;
            }
            setConversationBtnColor(this.mUIStyle.mTitleStyle.leftAndRightBtnColor);
            break label372;
            m = this.titleContainer.getTop();
            n = this.titleContainer.getBottom();
            this.titleContainer.layout(this.titleContainer.getLeft(), m + i, this.titleContainer.getRight(), i + n);
            this.titleContainer.setVisibility(0);
            break label506;
          }
          setSubTab(new bgud(this.mUIStyle.mSubIndex, i, null, null, paramString));
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      initTitleContainer();
      return;
    }
  }
  
  public void initTitleContainer() {}
  
  public boolean isConversationBtnVisible()
  {
    return getMiniViewLayout().getVisibility() == 0;
  }
  
  public boolean needShowConversationBtn()
  {
    if ((this.mUIStyleHandler.getWebView() == null) || (this.mUIStyleHandler.getWebView().getPluginEngine() == null)) {}
    WebViewPlugin localWebViewPlugin;
    do
    {
      return false;
      localWebViewPlugin = this.mUIStyleHandler.getWebView().getPluginEngine().a(45, false);
    } while (((localWebViewPlugin instanceof UiApiPlugin)) && (((UiApiPlugin)localWebViewPlugin).g));
    if ((this.mUIStyle.isNeedSwitchAIO) || (this.mUIStyle.isNeedSwitchAIOForH5Game)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onDestroy()
  {
    TouchWebView localTouchWebView = this.mUIStyleHandler.getWebView();
    if (localTouchWebView != null) {
      localTouchWebView.setOnScrollChangedListenerForBiz(null);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if ((this.titleContainer == null) || (this.mUIStyle.isFullScreen)) {}
    do
    {
      return;
      localObject = (RelativeLayout)this.subTitle.findViewById(2131378762);
    } while (localObject == null);
    paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131378805);
    Object localObject = (TextView)((RelativeLayout)localObject).findViewById(2131378738);
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new SwiftIphoneTitleBarUI.6(this, (TextView)localObject, paramWebView, paramString), 50L);
      return;
    }
    if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
    {
      paramWebView.setText(paramString);
      return;
    }
    setTitle(paramString);
  }
  
  public void recycle()
  {
    if (this.mFadeIn != null) {
      this.mFadeIn.setAnimationListener(null);
    }
    if (this.mFadeOut != null) {
      this.mFadeOut.setAnimationListener(null);
    }
    if (this.mTopSubTabView != null) {
      this.mTopSubTabView.setOnCheckedChangeListener(null);
    }
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.titleContainer.setLayerType(0, null);
    }
  }
  
  public void resetTitleBarButtonColor()
  {
    if (this.needResetTitleBarButtonColor)
    {
      setTitleBarButtonColor(this.lastTitleBarButtonColor);
      this.needResetTitleBarButtonColor = false;
    }
  }
  
  public void resetTitleBarTextColor()
  {
    this.leftView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131167006));
    this.rightViewText.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131167006));
    this.centerView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167009));
    Object localObject;
    if (this.rightViewImg != null)
    {
      localObject = this.rightViewImg.getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).clearColorFilter();
        ((Drawable)localObject).invalidateSelf();
      }
      this.rightViewImg.setImageDrawable((Drawable)localObject);
    }
    if (isConversationBtnVisible())
    {
      localObject = this.mMiniViewLayout.findViewById(2131371151);
      Drawable localDrawable = ((View)localObject).getBackground();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      ((View)localObject).setBackgroundDrawable(localDrawable);
    }
    this.leftView.setBackgroundDrawable(this.mTitleLeftDrawable);
  }
  
  public void runTitleBarAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    bfzt localbfzt = new bfzt(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new bgua(this, paramView, paramInt2));
    localbfzt.setDuration(paramInt3);
    this.mUIStyle.mIsAnimating = true;
    paramView.startAnimation(localbfzt);
  }
  
  public void setConversationBtnColor(int paramInt)
  {
    if (needShowConversationBtn())
    {
      View localView = this.mMiniViewLayout.findViewById(2131371151);
      localView.setBackgroundDrawable(bfvo.a(localView.getBackground(), paramInt));
    }
  }
  
  public void setConversationBtnVisible(boolean paramBoolean)
  {
    if (this.mUIStyleHandler.mHostFragment != null)
    {
      if ((paramBoolean) && (needShowConversationBtn()))
      {
        this.mUIStyleHandler.mHostFragment.mBusiID = 100;
        this.mUIStyleHandler.mHostFragment.initNativeMiniAIOUser();
        this.mUIStyleHandler.mHostFragment.setMiniAIOEntry(true);
      }
    }
    else {
      return;
    }
    this.mUIStyleHandler.mHostFragment.setMiniAIOEntry(false);
  }
  
  public void setLastTitleBarButtonColor(int paramInt)
  {
    this.lastTitleBarButtonColor = paramInt;
  }
  
  public void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          String str2 = paramIntent.getExtras().getString("leftViewText");
          int i = paramIntent.getExtras().getInt("individuation_url_type");
          String str1 = str2;
          if (i >= 40300)
          {
            str1 = str2;
            if (i <= 40313)
            {
              str1 = str2;
              if (!TextUtils.isEmpty(str2))
              {
                str1 = str2;
                if (str2.contains(amtj.a(2131713732))) {
                  str1 = BaseApplicationImpl.getApplication().getString(2131690599);
                }
              }
            }
          }
          bool1 = paramIntent.getBooleanExtra("hide_left_button", false);
          bool2 = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = BaseApplicationImpl.getApplication().getString(2131690599);
          }
          if (!bgyb.a())
          {
            this.leftView.setText(paramIntent);
            break label317;
            this.leftView.setVisibility(4);
            label166:
            if (AppSetting.c)
            {
              str1 = this.leftView.getText().toString();
              paramIntent = str1;
              if (!str1.contains(BaseApplicationImpl.getApplication().getString(2131690599))) {
                paramIntent = BaseApplicationImpl.getApplication().getString(2131690599) + str1;
              }
              this.leftView.setContentDescription(paramIntent);
            }
            if (this.leftCloseView == null) {
              break;
            }
            if (bool2) {
              this.leftCloseView.setVisibility(0);
            }
          }
          else
          {
            if (this.leftView.getBackground() != null) {
              break label317;
            }
            this.leftView.setText(paramIntent);
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
          return;
        }
        label317:
        do
        {
          this.leftView.setVisibility(0);
          break label166;
          this.leftCloseView.setVisibility(8);
          return;
          if (bool1) {
            break;
          }
        } while (!bool2);
      }
    }
  }
  
  public void setNeedResetTitleBarButtonColor(boolean paramBoolean)
  {
    this.needResetTitleBarButtonColor = paramBoolean;
  }
  
  public void setOnScrollChangedCallback(String paramString)
  {
    this.mWebViewScrollChangeCb = paramString;
    paramString = this.mUIStyleHandler.getWebView();
    if ((paramString != null) && (!this.mIsSetOnScrollListener))
    {
      paramString.setOnScrollChangedListenerForBiz(this.mOnScrollChangedListener);
      this.mIsSetOnScrollListener = true;
    }
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, acjr paramacjr)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a)) {}
    for (int i = 1; paramBoolean; i = 0)
    {
      this.mUIStyle.hideMore = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.mRightCornerIcon != null) {
        this.mRightCornerIcon.setVisibility(8);
      }
      setConversationBtnVisible(false);
      return;
    }
    if ((this.mWebViewFragmentIntent != null) && (this.mWebViewFragmentIntent.getIntExtra("reqType", -1) == 7))
    {
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      return;
    }
    if (needShowConversationBtn()) {
      setConversationBtnVisible(true);
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          this.rightViewText.setText(paramString2);
          this.rightViewText.setVisibility(0);
          this.rightViewText.bringToFront();
          this.rightViewImg.setImageResource(0);
          this.rightViewImg.setBackgroundColor(0);
          this.rightViewImg.setVisibility(8);
        }
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.rightViewImg.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.mRightButtonCallback = paramString1.trim();
            if (this.mUIStyle.transparentTitlebarConfig.has("txtclr"))
            {
              paramString2 = this.mUIStyle.transparentTitlebarConfig.optString("txtclr", "");
              if (!TextUtils.isEmpty(paramString2))
              {
                paramString1 = paramString2;
                if (!paramString2.startsWith("#")) {
                  paramString1 = "#" + paramString2;
                }
              }
            }
          }
          try
          {
            paramInt1 = Color.parseColor(paramString1);
            paramString1 = bfvo.a(this.rightViewImg.getDrawable(), paramInt1);
            if (paramString1 != null)
            {
              this.rightViewImg.setImageDrawable(paramString1);
              setConversationBtnColor(paramInt1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
            }
          }
          setTitleBarStyle(this.mUIStyle.needTitlebarTranslucent);
          return;
          setConversationBtnVisible(false);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            if (paramacjr != null)
            {
              this.mRightButtonCallback2 = paramacjr;
            }
            else
            {
              this.mRightButtonListener = paramJsBridgeListener;
              this.mRightButtonCallback = null;
            }
          }
        }
      }
    }
    this.rightViewText.setVisibility(8);
    if ((this.mUIStyleHandler.mHostFragment == null) || (!(this.mUIStyleHandler.mHostFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)))
    {
      this.rightViewImg.setVisibility(0);
      blockRightViewImgIfNeed();
    }
    paramString3 = this.mUIStyle;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label458:
      paramString3.hideMore = paramBoolean;
      switch (paramInt1)
      {
      default: 
        this.rightViewImg.setVisibility(8);
        label597:
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2;
          if (this.mShowRightCornerRedDot) {
            paramInt1 = 10000;
          }
        }
        if (paramInt1 != 0)
        {
          if (this.mRightCornerIcon == null)
          {
            this.mRightCornerIcon = new ImageView(BaseApplicationImpl.getApplication());
            paramString3 = (RelativeLayout)this.titleContainer.findViewById(2131376632);
            paramString3 = new RelativeLayout.LayoutParams(-2, -2);
            paramString3.addRule(7, 2131369082);
            paramString3.addRule(6, 2131369082);
            paramString3.setMargins(0, 0, 0, 0);
            this.mRightCornerIcon.setLayoutParams(paramString3);
            if ((this.rightViewImg.getParent() instanceof RelativeLayout)) {
              ((RelativeLayout)this.rightViewImg.getParent()).addView(this.mRightCornerIcon);
            }
          }
          this.mRightCornerIcon.setVisibility(0);
          switch (paramInt1)
          {
          default: 
            this.mRightCornerIcon.setVisibility(8);
            label793:
            if (!TextUtils.isEmpty(paramString2)) {
              this.rightViewImg.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.rightViewImg.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.isRecordTitleLeftDrawable = false;
      this.isRecordTitleRightDrawable = false;
      break;
      paramBoolean = false;
      break label458;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130843894, 2130843893);
      this.rightViewImg.setImageDrawable(bfvo.a(this.rightViewImg.getResources().getDrawable(2130843894), this.rightViewImg.getResources().getColor(2131167009)));
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692439));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130843892, 2130843892);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692438));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130840333, 2130840333);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692440));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130839412, 2130839412);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692442));
      break label597;
      this.rightViewImg.setImageResource(2130843937);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692443));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130842537, 2130842540);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689550));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130850052, 2130850056);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689550));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130838942, 2130838942);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692441));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130850233, 2130850233);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692441));
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130846269, 2130846268);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692441));
      break label597;
      paramString3 = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
      if (paramString3 == null) {
        break label597;
      }
      this.rightViewImg.setBackgroundDrawable(paramString3);
      paramString3 = (RelativeLayout)this.titleContainer.findViewById(2131376632);
      if (paramString3 == null) {
        break label597;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
      localLayoutParams.rightMargin = ViewUtils.dpToPx(10.0F);
      paramString3.setLayoutParams(localLayoutParams);
      break label597;
      this.mUIStyleHandler.setDefaultThemeIcon(this.rightViewImg, false, 2130840333, 2130840333);
      this.rightViewImg.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131718205));
      break label597;
      this.mRightCornerIcon.setImageResource(2130843715);
      break label793;
      this.mRightCornerIcon.setImageResource(2130850321);
      break label793;
      if (this.mRightCornerIcon == null) {
        break label793;
      }
      this.mRightCornerIcon.setVisibility(8);
      break label793;
      if ((paramString1 != null) && (i == 0))
      {
        this.mRightButtonCallback = paramString1.trim();
      }
      else if (paramacjr != null)
      {
        this.mRightButtonCallback2 = paramacjr;
      }
      else
      {
        this.mRightButtonCallback = null;
        this.mRightButtonListener = paramJsBridgeListener;
      }
    }
  }
  
  public void setRightButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mUIStyle.hideMore = true;
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(8);
      }
      if (this.mRightCornerIcon != null) {
        this.mRightCornerIcon.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.rightViewText != null) && (!TextUtils.isEmpty(this.rightViewText.getText()))) {
        this.rightViewText.setVisibility(0);
      }
      if (this.rightViewImg != null)
      {
        this.rightViewImg.setVisibility(0);
        blockRightViewImgIfNeed();
      }
    } while (this.mRightCornerIcon == null);
    this.mRightCornerIcon.setVisibility(0);
  }
  
  @TargetApi(11)
  public void setRightViewTextDisable(int paramInt)
  {
    if (paramInt == 0)
    {
      this.rightViewText.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.rightViewText.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.rightViewText.setAlpha(1.0F);
  }
  
  public void setSubTab(bgud parambgud)
  {
    int i = -1;
    if (parambgud != null)
    {
      this.mTopSubTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.mTopSubTabView.setButtonNum(parambgud.jdField_b_of_type_Int, parambgud.jdField_a_of_type_Int);
      this.mTopSubTabView.setButtonText(parambgud.jdField_a_of_type_ArrayOfJavaLangString);
      this.mTopSubTabView.setButtonBackgroundResource(2130850729, 2130850730, 2130850731);
      this.mTopSubTabView.setButtonTextColorStateList(2131167323);
      this.mTopSubTabView.setLeftAndRightPaddingByDp(10);
      setTitleBarStyle(this.mUIStyle.needTitlebarTranslucent);
    }
    try
    {
      this.centerContainer.removeAllViews();
      this.centerContainer.addView(this.mTopSubTabView, new RelativeLayout.LayoutParams(-2, -1));
      this.mTopSubTabView.setOnCheckedChangeListener(new bguc(this));
      if (this.mTopTabHelper != null) {
        this.mTopTabHelper.a(parambgud.jdField_b_of_type_JavaLangString, true);
      }
      localTouchWebView = this.mUIStyleHandler.getWebView();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(parambgud.jdField_a_of_type_JavaLangString)))
      {
        str = "ok";
        if (!TextUtils.isEmpty(parambgud.jdField_b_of_type_JavaLangString)) {
          break label263;
        }
        str = "the subTabCallback isEmpty";
        localJSONObject = new JSONObject();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          TouchWebView localTouchWebView;
          String str;
          JSONObject localJSONObject;
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
          localTouchWebView.callJs(parambgud.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label263:
        i = 0;
      }
    }
  }
  
  public void setSubTabRedHot(bgue parambgue)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((parambgue != null) && (this.mTopSubTabView != null))
    {
      localObject1 = this.mTopSubTabView;
      localObject2 = parambgue.jdField_a_of_type_ArrayOfInt;
      if (parambgue.jdField_a_of_type_Int != 1) {
        break label56;
      }
      bool = true;
      ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
      localObject2 = this.mUIStyleHandler.getWebView();
      if (localObject2 != null) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      label56:
      bool = false;
      break;
      label61:
      localObject1 = "OK";
      JSONObject localJSONObject = new JSONObject();
      Object localObject3 = this.mTopSubTabView.a();
      int i;
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        i = -2;
        localObject1 = "sub tab num is error";
        localObject3 = new JSONObject();
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject3).put("code", i);
          ((JSONObject)localObject3).put("message", localObject1);
          ((JSONObject)localObject3).put("data", localJSONObject);
          if (TextUtils.isEmpty(parambgue.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ((TouchWebView)localObject2).callJs(parambgue.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
          return;
          try
          {
            JSONArray localJSONArray = new JSONArray();
            i = 0;
            while (i < localObject3.length)
            {
              localJSONArray.put(localObject3[i]);
              i += 1;
            }
            localJSONObject.put("tabsStatus", localJSONArray);
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "tabsStatusArray = " + localJSONArray.toString());
            }
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i = -3;
            String str = "construction json error";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void setTitle(String paramString)
  {
    this.centerView.setText(paramString);
  }
  
  public void setTitleBar(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.leftView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label98;
      }
      this.rightViewText.setVisibility(8);
      label39:
      if (TextUtils.isEmpty(paramString3)) {
        break label126;
      }
    }
    for (;;)
    {
      setTitle(paramString3);
      return;
      this.leftView.setVisibility(0);
      if (!bgyb.a())
      {
        this.leftView.setText(paramString1);
        break;
      }
      if (this.leftView.getBackground() != null) {
        break;
      }
      this.leftView.setText(paramString1);
      break;
      label98:
      this.rightViewText.setText(paramString2);
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      break label39;
      label126:
      paramString3 = "";
    }
  }
  
  public void setTitleBarAlpha(int paramInt)
  {
    if (this.titleContainer == null) {}
    do
    {
      do
      {
        return;
      } while (paramInt == this.mTitleAlpha);
      this.mTitleAlpha = paramInt;
      paramInt = Math.max(0, Math.min(paramInt, 255));
      this.titleContainer.getBackground().mutate().setAlpha(paramInt);
      if ((this.mUIStyleHandler.mHostFragment != null) && (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null)) {
        this.mUIStyleHandler.mHostFragment.mSystemBarComp.getBackground().mutate().setAlpha(paramInt);
      }
      if (paramInt == this.mBeforeDivideAlpha)
      {
        setTitleBarStyle(true);
        return;
      }
    } while (paramInt != this.mAfterDivideAlpha);
    setTitleBarStyle(false);
  }
  
  public void setTitleBarButtonColor(int paramInt)
  {
    int i = this.leftView.getCurrentTextColor();
    if ((i != paramInt) && (!this.needResetTitleBarButtonColor))
    {
      setNeedResetTitleBarButtonColor(true);
      setLastTitleBarButtonColor(i);
    }
    this.leftView.setTextColor(paramInt);
    this.rightViewText.setTextColor(paramInt);
    if ((this.leftCloseView != null) && (this.leftCloseView.getVisibility() == 0))
    {
      localDrawable1 = bfvo.a(this.leftCloseView.getDrawable(), paramInt);
      if (localDrawable1 != null) {
        this.leftCloseView.setImageDrawable(localDrawable1);
      }
    }
    Drawable localDrawable2 = this.leftView.getBackground();
    Drawable localDrawable1 = this.rightViewImg.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.isRecordTitleLeftDrawable)
      {
        this.mTitleLeftDrawable = localDrawable2;
        this.isRecordTitleLeftDrawable = true;
      }
      localDrawable2 = bfvo.a(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.leftView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.isRecordTitleRightDrawable) {
        this.isRecordTitleRightDrawable = true;
      }
      localDrawable1 = bfvo.a(localDrawable1, paramInt);
      if (localDrawable1 != null)
      {
        this.rightViewImg.setImageDrawable(localDrawable1);
        setConversationBtnColor(paramInt);
      }
    }
    this.rightViewImg.setColorFilter(paramInt);
  }
  
  public void setTitleBarScrollChange(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {}
    do
    {
      return;
      if (!this.mIsSetOnScrollListener)
      {
        paramTouchWebView.setOnScrollChangedListenerForBiz(this.mOnScrollChangedListener);
        this.mIsSetOnScrollListener = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "setTitleBarScrollChange:" + paramBoolean1 + ", @" + paramInt1 + ", from " + paramInt2 + " to " + paramInt3 + ", " + paramBoolean2 + ", Before: " + paramString1 + ", After: " + paramString2);
      }
      this.mAutoHandleScroll = paramBoolean1;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.mDividePosition = ((int)(paramInt1 * localBaseApplicationImpl.getResources().getDisplayMetrics().density + 0.5F));
      this.mBeforeDivideAlpha = paramInt2;
      this.mAfterDivideAlpha = paramInt3;
      this.mFadeIn = new bfzt(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.mAnimUpdateListener);
      this.mFadeIn.setDuration(300L);
      this.mFadeIn.setInterpolator(localBaseApplicationImpl, 17432581);
      this.mFadeOut = new bfzt(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.mAnimUpdateListener);
      this.mFadeOut.setDuration(300L);
      this.mFadeOut.setInterpolator(localBaseApplicationImpl, 17432581);
      this.mIsShade = paramBoolean2;
      this.mBeforeTitle = paramString1;
      this.mAfterTitle = paramString2;
      this.mTitleAlpha = -1;
      updateTitleBar(this.mScrollPos, false);
    } while (TextUtils.isEmpty(paramString3));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label332:
      paramTouchWebView.callJs(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label332;
    }
  }
  
  public void setTitleBarStyle(boolean paramBoolean)
  {
    this.mUIStyle.needTitlebarTranslucent = paramBoolean;
    if ((paramBoolean) && (this.mBeforeTitle != null)) {
      setTitle(this.mBeforeTitle);
    }
    while ((paramBoolean) || (this.mAfterTitle == null)) {
      return;
    }
    setTitle(this.mAfterTitle);
  }
  
  public void setTitleBarTextColor(int paramInt)
  {
    this.centerView.setTextColor(paramInt);
  }
  
  public boolean setTitleBarVisibility(boolean paramBoolean)
  {
    if (this.titleContainer == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.mTitleAlpha = -1;
      updateTitleBar(this.mScrollPos, this.mIsShade);
      this.titleContainer.setVisibility(0);
      if (!this.mUIStyleHandler.mUIStyle.isFullScreen) {
        this.mUIStyleHandler.mHostActivity.getWindow().clearFlags(1024);
      }
    }
    for (;;)
    {
      return true;
      setTitleBarAlpha(0);
      this.titleContainer.setVisibility(8);
      this.mUIStyleHandler.mHostActivity.getWindow().addFlags(1024);
    }
  }
  
  public void setTitleIcon(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Object localObject4 = null;
    Drawable[] arrayOfDrawable = this.centerView.getCompoundDrawables();
    Object localObject3 = arrayOfDrawable[0];
    Drawable localDrawable = arrayOfDrawable[1];
    Object localObject2 = arrayOfDrawable[2];
    Object localObject1 = arrayOfDrawable[3];
    switch (paramInt1)
    {
    default: 
      paramDrawable = (Drawable)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      if ((localObject2 != arrayOfDrawable[0]) || (localDrawable != arrayOfDrawable[1]) || (localObject1 != arrayOfDrawable[2]) || (paramDrawable != arrayOfDrawable[3]))
      {
        this.centerView.setCompoundDrawables((Drawable)localObject2, localDrawable, (Drawable)localObject1, paramDrawable);
        this.centerView.setCompoundDrawablePadding(paramInt2);
        this.centerView.setGravity(17);
      }
      return;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        if (localObject2 == null)
        {
          localObject2 = new ColorDrawable(0);
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
          continue;
        }
        if ((localObject2 instanceof ColorDrawable))
        {
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
        }
      }
      else if ((localObject2 instanceof ColorDrawable))
      {
        localObject3 = localObject1;
        localObject1 = null;
        localObject2 = paramDrawable;
        paramDrawable = (Drawable)localObject3;
        continue;
        if (paramDrawable != null)
        {
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
          localDrawable = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            if (localObject3 == null)
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
              localObject3 = localObject1;
              localObject1 = paramDrawable;
              paramDrawable = (Drawable)localObject3;
              continue;
            }
            if ((localObject3 instanceof ColorDrawable))
            {
              ((Drawable)localObject3).setBounds(paramDrawable.getBounds());
              localObject2 = localObject3;
              localObject3 = paramDrawable;
              paramDrawable = (Drawable)localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((localObject3 instanceof ColorDrawable))
          {
            localObject3 = localObject1;
            localObject1 = paramDrawable;
            localObject2 = localObject4;
            paramDrawable = (Drawable)localObject3;
            continue;
            if (paramDrawable != null) {
              paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            }
            localObject1 = localObject2;
            localObject2 = localObject3;
            continue;
          }
          localObject2 = localObject3;
          localObject3 = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject3;
          continue;
        }
        localDrawable = paramDrawable;
        paramDrawable = (Drawable)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = paramDrawable;
      paramDrawable = (Drawable)localObject3;
    }
  }
  
  public boolean setTopBarVisibility(boolean paramBoolean)
  {
    int i = 0;
    if (this.mTopSubTabView == null) {
      return false;
    }
    WebViewTopTabView localWebViewTopTabView = this.mTopSubTabView;
    if (paramBoolean) {}
    for (;;)
    {
      localWebViewTopTabView.setVisibility(i);
      return true;
      i = 8;
    }
  }
  
  public void setTopTabSelection(int paramInt)
  {
    this.mUIStyle.mSubIndex = paramInt;
    if (this.mTopSubTabView != null) {
      this.mTopSubTabView.setSelectedTab(paramInt);
    }
  }
  
  public void setWarnToastVisible(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.mWarnToastView != null)
    {
      if (paramBoolean)
      {
        paramInt1 = QQToast.a(paramInt1);
        this.mWarnIconView.setImageDrawable(this.mWarnToastView.getResources().getDrawable(paramInt1));
        this.mWarnTextView.setText(this.mWarnToastView.getResources().getString(paramInt2));
        this.mWarnToastView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mWarnToastView.setVisibility(8);
  }
  
  public void showCloseButton(String paramString)
  {
    if (this.rightViewText != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label70;
      }
      this.rightViewText.setText(paramString);
    }
    for (;;)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.bringToFront();
      if (this.rightViewImg != null)
      {
        this.rightViewImg.setImageResource(0);
        this.rightViewImg.setBackgroundColor(0);
        this.rightViewImg.setVisibility(8);
      }
      return;
      label70:
      this.rightViewText.setText(2131690768);
    }
  }
  
  public void showRightCornerRedDot(boolean paramBoolean)
  {
    if ((this.mShowRightCornerRedDot) && (!paramBoolean) && (this.mRightCornerIcon != null)) {
      this.mRightCornerIcon.setVisibility(8);
    }
    this.mShowRightCornerRedDot = paramBoolean;
  }
  
  void updateTitleBar(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (this.mAutoHandleScroll)
    {
      localObject2 = null;
      if ((paramInt < this.mDividePosition) || (!this.mUIStyle.needTitlebarTranslucent)) {
        break label94;
      }
      this.mUIStyle.needTitlebarTranslucent = false;
      if (!paramBoolean) {
        break label80;
      }
      localObject1 = this.mFadeIn;
    }
    for (;;)
    {
      if ((this.titleContainer != null) && (localObject1 != null) && (localObject1 != this.titleContainer.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.titleContainer.startAnimation((Animation)localObject1);
      }
      return;
      label80:
      setTitleBarAlpha(this.mAfterDivideAlpha);
      localObject1 = localObject2;
      continue;
      label94:
      localObject1 = localObject2;
      if (paramInt < this.mDividePosition)
      {
        localObject1 = localObject2;
        if (!this.mUIStyle.needTitlebarTranslucent)
        {
          this.mUIStyle.needTitlebarTranslucent = true;
          if (paramBoolean)
          {
            localObject1 = this.mFadeOut;
          }
          else
          {
            setTitleBarAlpha(this.mBeforeDivideAlpha);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public void updateTitleBarUI()
  {
    if (this.titleContainer == null) {}
    do
    {
      return;
      if ((this.mUIStyle.needTitlebarTranslucent) && (this.mUIStyle.needResetTitlebarTextColor))
      {
        this.mUIStyle.needResetTitlebarTextColor = false;
        this.mUIStyle.needResetTitlebarTextColor = true;
        this.titleContainer.setBackgroundResource(2130850751);
        this.centerView.setTextColor(-1);
        return;
      }
    } while ((this.mUIStyle.needTitlebarTranslucent) || (!this.mUIStyle.needResetTitlebarTextColor));
    this.mUIStyle.needResetTitlebarTextColor = false;
    this.mUIStyle.needResetTitlebarTextColor = true;
    this.titleContainer.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167070));
    resetTitleBarTextColor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */