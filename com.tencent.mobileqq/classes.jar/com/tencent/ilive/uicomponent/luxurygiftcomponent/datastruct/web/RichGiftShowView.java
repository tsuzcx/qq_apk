package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.IGiftAnimation;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.okweb.webview.DefaultWebView;
import com.tencent.okweb.webview.js.IJsBridgeListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.e;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RichGiftShowView
  extends DefaultWebView
  implements ThreadCenter.HandlerKeyable, IJsBridgeListener
{
  private static final String JS_CALLBACK_PLAY_ANIM = "__WEBVIEW_PLAY_ANIMATION";
  private static final String JS_CALLBACL_CANCEL_ANIM = "__WEBVIEW_CANCEL_ANIMATION";
  private static final String TAG = "GiftAnimation";
  private static final String URL = "https://now.qq.com/mobile/gift/index.html?_bid=2377";
  private Handler exceptionHandler;
  private IGiftAnimation mAnimationListener;
  private Runnable mDelayRunnable = new RichGiftShowView.2(this);
  private boolean mIsAnimationReady;
  private boolean mIsContainerShow = true;
  private boolean mIsWorking;
  private LuxuryGiftAdapter mLuxuryGiftAdapter;
  private Runnable mReload = new RichGiftShowView.1(this);
  private IRichGiftShowPlay mRichGiftPlayListener;
  
  public RichGiftShowView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext);
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    init();
    paramLuxuryGiftAdapter = new StringBuilder();
    paramLuxuryGiftAdapter.append("RichGiftShowView create: ");
    paramLuxuryGiftAdapter.append(this);
    Log.i("GiftAnimation", paramLuxuryGiftAdapter.toString());
    if ((!QbSdk.getIsSysWebViewForcedByOuter()) || (!TbsShareManager.isThirdPartyApp(paramContext))) {
      try
      {
        paramContext = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        paramContext.setAccessible(true);
        this.exceptionHandler = ((Handler)paramContext.invoke(null, new Object[0]));
        this.exceptionHandler.getLooper().getThread().setUncaughtExceptionHandler(new e());
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void cancelAnimation()
  {
    if (this.mIsAnimationReady)
    {
      loadUrl("javascript:__WEBVIEW_CANCEL_ANIMATION('')");
      Object localObject = this.mRichGiftPlayListener;
      if (localObject != null) {
        ((IRichGiftShowPlay)localObject).onEnd();
      }
      localObject = this.mAnimationListener;
      if (localObject != null) {
        ((IGiftAnimation)localObject).animationCancel();
      }
    }
    this.mIsWorking = false;
    this.mLuxuryGiftAdapter.getLogger().i("GiftAnimation", "rich animation cancel", new Object[0]);
  }
  
  public void init()
  {
    this.mLuxuryGiftAdapter.getLogger().i("GiftAnimation", "rich animation view create", new Object[0]);
    setBackgroundColor(0);
    setVisibility(4);
    setJsBridgeListener(this);
    setLayerType(2, null);
    Activity localActivity = this.mLuxuryGiftAdapter.getActivityLifeService().getTopActivity();
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = this.mLuxuryGiftAdapter.getContext();
    }
    int i = UIUtil.getScreenWidth((Context)localObject);
    int j = UIUtil.getScreenHeight((Context)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://now.qq.com/mobile/gift/index.html?_bid=2377&width=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("&height=");
    ((StringBuilder)localObject).append(j);
    offlineLoadUrl(((StringBuilder)localObject).toString());
    ThreadCenter.postDelayedUITask(this, this.mReload, 10000L);
  }
  
  public boolean isAnimViewReady()
  {
    return this.mIsAnimationReady;
  }
  
  public boolean isWorking()
  {
    return this.mIsWorking;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    Log.i("GiftAnimation", "onDetachedFromWindow...");
    if (this.exceptionHandler != null)
    {
      Log.i("GiftAnimation", "remove exception handler task");
      this.exceptionHandler.removeCallbacksAndMessages(null);
    }
    cancelAnimation();
    ThreadCenter.clear(this);
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onJsBridge(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (("app".equals(paramString1)) && ("sendMessage".equals(paramString2)))
    {
      paramString1 = (String)paramMap.get("messageID");
      if ("animationEnd".equals(paramString1))
      {
        paramString1 = this.mLuxuryGiftAdapter;
        if (paramString1 != null) {
          paramString1.getLogger().i("GiftAnimation", "rich animation end", new Object[0]);
        }
        ThreadCenter.removeUITask(this, this.mDelayRunnable);
        this.mIsWorking = false;
        paramString1 = this.mRichGiftPlayListener;
        if (paramString1 != null) {
          paramString1.onEnd();
        }
        paramString1 = this.mAnimationListener;
        if (paramString1 != null) {
          paramString1.animationEnd();
        }
      }
      else
      {
        if ("animationReady".equals(paramString1))
        {
          this.mIsAnimationReady = true;
          paramString1 = this.mLuxuryGiftAdapter;
          if (paramString1 != null) {
            paramString1.getLogger().i("GiftAnimation", "rich webView ready", new Object[0]);
          }
          paramString1 = this.mAnimationListener;
          if (paramString1 != null) {
            paramString1.animViewReady();
          }
          ThreadCenter.removeUITask(this, this.mReload);
          return;
        }
        if ("animationLog".equals(paramString1))
        {
          paramString1 = this.mLuxuryGiftAdapter;
          if (paramString1 != null)
          {
            paramString1 = paramString1.getLogger();
            paramString2 = new StringBuilder();
            paramString2.append("JS: ");
            paramString2.append((String)paramMap.get("log"));
            paramString1.i("GiftAnimation", paramString2.toString(), new Object[0]);
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAnimationListener(IGiftAnimation paramIGiftAnimation)
  {
    this.mAnimationListener = paramIGiftAnimation;
  }
  
  public void setmRichGiftPlayListener(IRichGiftShowPlay paramIRichGiftShowPlay)
  {
    this.mRichGiftPlayListener = paramIRichGiftShowPlay;
  }
  
  public void showAnimation(WebGiftInfo paramWebGiftInfo)
  {
    this.mLuxuryGiftAdapter.getLogger().e("GiftAnimation", " rich h5  start to play", new Object[0]);
    if ((this.mIsAnimationReady) && (paramWebGiftInfo != null))
    {
      int i;
      if (this.mIsContainerShow) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("effect_id", paramWebGiftInfo.effectId);
        localJSONObject.put("gift_name", paramWebGiftInfo.giftName);
        localJSONObject.put("count", paramWebGiftInfo.effectNum);
        localJSONObject.put("gift_action", paramWebGiftInfo.comment);
        localJSONObject.put("sender_nickname", paramWebGiftInfo.senderName);
        localJSONObject.put("sender_image", paramWebGiftInfo.senderHeadKey);
        if ((paramWebGiftInfo.senderHeadUrl != null) && (paramWebGiftInfo.senderHeadUrl.length() > 0) && (!paramWebGiftInfo.senderHeadUrl.endsWith("/")))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramWebGiftInfo.senderHeadUrl);
          localStringBuilder1.append("/");
          paramWebGiftInfo.senderHeadUrl = localStringBuilder1.toString();
        }
        localJSONObject.put("sender_image_url", paramWebGiftInfo.senderHeadUrl);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ThreadCenter.postDelayedUITask(this, this.mDelayRunnable, 20000L);
      Object localObject = this.mLuxuryGiftAdapter.getLogger();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" jsonObj=");
      localStringBuilder2.append(localJSONObject.toString());
      ((LogInterface)localObject).i("GiftAnimation", localStringBuilder2.toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("javascript:__WEBVIEW_PLAY_ANIMATION(");
      ((StringBuilder)localObject).append(localJSONObject.toString());
      ((StringBuilder)localObject).append(")");
      loadUrl(((StringBuilder)localObject).toString());
      this.mLuxuryGiftAdapter.getLogger().i("GiftAnimation", "start rich gift animation, effect_id=%s, gift_name=%s, sender_nickname=%s", new Object[] { paramWebGiftInfo.effectId, paramWebGiftInfo.giftName, paramWebGiftInfo.senderName });
      this.mIsWorking = true;
      return;
    }
    paramWebGiftInfo = this.mRichGiftPlayListener;
    if (paramWebGiftInfo != null) {
      paramWebGiftInfo.onEnd();
    }
    paramWebGiftInfo = this.mAnimationListener;
    if (paramWebGiftInfo != null) {
      paramWebGiftInfo.animationEnd();
    }
  }
  
  public void showCtrls(boolean paramBoolean)
  {
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("h5=");
    localStringBuilder.append(paramBoolean);
    localLogInterface.e("GiftAnimation", localStringBuilder.toString(), new Object[0]);
    this.mIsContainerShow = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web.RichGiftShowView
 * JD-Core Version:    0.7.0.1
 */