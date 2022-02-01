package com.tencent.mobileqq.activity;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public class H5MagicPlayerActivity
  extends BaseActivity
{
  WebViewClient a;
  WebView b;
  SessionInfo c;
  Emoticon d;
  Emoticon e;
  String f;
  boolean g;
  Vibrator h;
  protected SoundPool i;
  String j = null;
  int k = -1;
  int l = 0;
  String m;
  String n;
  float o;
  float p;
  float q;
  ShakeListener r = new H5MagicPlayerActivity.6(this);
  
  private void a()
  {
    this.b = new DtX5WebView(this);
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131445137);
    localFrameLayout.addView(this.b, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(DisplayUtil.a(this, 24.0F), DisplayUtil.a(this, 24.0F));
    localLayoutParams.setMargins(0, DisplayUtil.a(this, 9.0F), DisplayUtil.a(this, 10.0F), 0);
    localLayoutParams.gravity = 53;
    localButton.setLayoutParams(localLayoutParams);
    localButton.setBackgroundDrawable(getResources().getDrawable(2130849066));
    localButton.setOnClickListener(new H5MagicPlayerActivity.1(this));
    localFrameLayout.addView(localButton);
    this.b.setBackgroundColor(0);
    if (this.b.getBackground() != null) {
      this.b.getBackground().setAlpha(0);
    }
    this.b.setScrollBarStyle(33554432);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "magicCalljs sn is empty");
      }
      return;
    }
    paramString1 = "javascript:execGlobalCallback(((0)),((1)))".replace("((0))", paramString1).replace("((1))", paramString2);
    this.b.loadUrl(paramString1);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("magicCalljs calljs = ");
      paramString2.append(paramString1);
      QLog.d("H5MagicPlayerActivity", 2, paramString2.toString());
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    l2 = 1000L;
    l1 = l2;
    if (paramJSONObject != null) {
      l1 = l2;
    }
    try
    {
      if (paramJSONObject.has("duration"))
      {
        int i1 = paramJSONObject.getInt("duration");
        l1 = i1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    if (this.h == null) {
      this.h = ((Vibrator)getSystemService("vibrator"));
    }
    paramJSONObject = this.h;
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(l1);
    }
  }
  
  private JSONObject b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramString.contains("=")) {
      return null;
    }
    paramString = paramString.split("=");
    String str;
    if ((paramString != null) && (paramString.length >= 2))
    {
      paramString = paramString[1].split("#");
      if ((paramString != null) && (paramString.length >= 2))
      {
        str = paramString[0];
        if (str == null) {
          return null;
        }
      }
    }
    try
    {
      paramString = URLDecoder.decode(str, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label82:
      break label82;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Failed to decode json str, josn=");
      paramString.append(str);
      QLog.d("H5MagicPlayerActivity", 2, paramString.toString());
    }
    paramString = null;
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (Exception paramString)
    {
      label139:
      break label139;
    }
    if (QLog.isColorLevel()) {
      QLog.d("H5MagicPlayerActivity", 2, "Failed to parse json str,json=");
    }
    paramString = null;
    if (paramString == null) {
      return null;
    }
    return paramString;
    if (QLog.isColorLevel()) {
      QLog.d("H5MagicPlayerActivity", 2, "jsons # error ");
    }
    return null;
    if (QLog.isColorLevel()) {
      QLog.d("H5MagicPlayerActivity", 2, "jsons = error ");
    }
    return null;
  }
  
  private void b()
  {
    Object localObject = this.b.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowContentAccess(true);
    ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
    this.a = new H5MagicPlayerActivity.2(this);
    this.b.setWebViewClient(this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if ((Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(localObject))) {
      getWindow().addFlags(16777216);
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.b.removeJavascriptInterface("searchBoxJavaBridge_");
      this.b.removeJavascriptInterface("accessibility");
      this.b.removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    if (TextUtils.isEmpty(this.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "audioFilePath = null ");
      }
      return;
    }
    c(this.j);
  }
  
  private void c()
  {
    this.b.removeAllViews();
    this.b.destroy();
    g();
    h();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(getApplicationContext());
  }
  
  private void c(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "playAudio file dont exist ");
      }
      return;
    }
    if (this.k == -1) {
      return;
    }
    QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
    if (this.i == null) {
      this.i = new SoundPool(5, 3, 0);
    }
    this.l = this.i.load(((File)localObject).getAbsolutePath(), 1);
    if (this.l == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load failure filepath=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("H5MagicPlayerActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.i.setOnLoadCompleteListener(new H5MagicPlayerActivity.4(this, paramString));
      return;
    }
    ThreadManager.getTimer().schedule(new H5MagicPlayerActivity.5(this, paramString), 200L);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "getAudioFilePath json = null ");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("file")) {
          break label185;
        }
        str = paramJSONObject.getString("file");
        if (!paramJSONObject.has("loop")) {
          break label190;
        }
        i1 = paramJSONObject.getInt("loop");
        this.k = i1;
      }
      catch (Exception paramJSONObject)
      {
        this.k = -1;
        paramJSONObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "playAudio json error ");
        }
        str = null;
      }
      if (str == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "playAudio fileName = null ");
        }
        return;
      }
      if (this.k == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "playAudio loop = -1 ");
        }
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(EmotionPanelConstans.H5MagicRootPath.replace("[epId]", this.d.epId));
      paramJSONObject.append(str);
      this.j = paramJSONObject.toString();
      return;
      label185:
      String str = null;
      continue;
      label190:
      int i1 = -1;
    }
  }
  
  private void d()
  {
    super.finish();
  }
  
  private void d(String paramString)
  {
    this.f = paramString;
    this.g = true;
    paramString = (SensorManager)getSystemService("sensor");
    paramString.registerListener(this.r, paramString.getDefaultSensor(1), 0);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (paramJSONObject.has("message")) {
        paramJSONObject = paramJSONObject.getString("message");
      } else {
        paramJSONObject = "";
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      paramJSONObject = "json parse erro";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("log ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("H5MagicPlayerActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "openRedPacket:sessionInfo = null ");
      }
      return;
    }
    int i1 = 0;
    if (((SessionInfo)localObject1).a == 0) {
      i1 = 1;
    } else if (this.c.a == 3000) {
      i1 = 2;
    } else if (this.c.a == 1) {
      i1 = 3;
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("recv_uin", this.c.b);
      ((JSONObject)localObject1).put("recv_type", i1);
      if (!TextUtils.isEmpty("")) {
        ((JSONObject)localObject1).put("session_token", "");
      }
      ((JSONObject)localObject1).put("channel", 1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("click HongBao:params=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      QLog.d("H5MagicPlayerActivity", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("groupType=");
    ((StringBuilder)localObject2).append(i1);
    long l1 = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", ((StringBuilder)localObject2).toString(), 0, null);
    localObject2 = new ActivityURIRequest(BaseApplicationImpl.getContext(), "/qwallet/redpacket/sendhb");
    ((ActivityURIRequest)localObject2).extra().putLong("vacreport_key_seq", l1);
    ((ActivityURIRequest)localObject2).extra().putInt("come_from", 2);
    ((ActivityURIRequest)localObject2).extra().putString("extra_data", ((JSONObject)localObject1).toString());
    ((ActivityURIRequest)localObject2).extra().putString("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#mobiao");
    QRoute.startUri((URIRequest)localObject2, new H5MagicPlayerActivity.3(this));
    ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8005FE5", 0, 0, "", "", "", "");
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (paramJSONObject.has("click")) {
        i1 = paramJSONObject.getInt("click");
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reportClick json error");
      }
      paramJSONObject.printStackTrace();
      i1 = i2;
    }
    paramJSONObject = this.d.epId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ReportController.b(null, "CliOper", "", "", "ep_mall", "itemclick", 0, 0, paramJSONObject, localStringBuilder.toString(), "", "");
  }
  
  private void f()
  {
    if (this.e != null)
    {
      Object localObject2 = EmotionPanelConstans.H5MagicIndexHtmlPath.replace("[epId]", this.e.epId);
      Object localObject1 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append((String)localObject2);
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("?sender_uin=");
      ((StringBuilder)localObject2).append(this.m);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&self_uin=");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      ((StringBuilder)localObject1).append("&auto_play=0");
      ((StringBuilder)localObject1).append("&platform=android");
      ((StringBuilder)localObject1).append("&version=8.8.17");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&start_time=");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&width=");
      ((StringBuilder)localObject2).append(this.p);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&height=");
      ((StringBuilder)localObject2).append(this.q);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&pixel_ratio=");
      ((StringBuilder)localObject2).append(this.o);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      localObject1 = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reply url = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("H5MagicPlayerActivity", 2, ((StringBuilder)localObject2).toString());
      }
      this.b.loadUrl((String)localObject1);
      if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putSerializable("emoticon", this.e);
        ((Bundle)localObject1).putParcelable("sessionInfo", this.c);
        localObject1 = DataFactory.a("ipc_h5magic_sendmsg", "", -1, (Bundle)localObject1);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq((Bundle)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("send childEmoticon: childEmotcionEpid = ");
          ((StringBuilder)localObject1).append(this.e.epId);
          QLog.d("H5MagicPlayerActivity", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: service not bind");
        }
        d();
      }
      this.d = this.e;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reply childemoticon doesnt exit ");
      }
      d();
    }
    ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8005FE6", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    if (this.i != null)
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
      this.i.stop(this.l);
      this.i.release();
    }
  }
  
  private void h()
  {
    this.g = false;
    ((SensorManager)getSystemService("sensor")).unregisterListener(this.r);
  }
  
  public boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("jsbridge://")))
    {
      Object localObject3 = paramString.split("/");
      Object localObject1;
      if ((localObject3 != null) && (localObject3.length >= 4))
      {
        if (!"magicEmotion".equals(localObject3[2]))
        {
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "objectName is error ");
          }
          return false;
        }
        localObject1 = "#";
        Object localObject2 = paramString.split("#");
        if ((localObject2 != null) && (localObject2.length >= 2))
        {
          localObject2 = localObject2[1];
          JSONObject localJSONObject = b(paramString);
          localObject3 = localObject3[3];
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("H5MagicPlayerActivity", 2, "method error ");
            }
            return false;
          }
          if (!paramString.contains("?")) {
            paramString = (String)localObject1;
          } else {
            paramString = "\\?";
          }
          paramString = ((String)localObject3).split(paramString);
          if ((paramString != null) && (paramString.length >= 2))
          {
            paramString = paramString[0];
            if ("close".equals(paramString))
            {
              d();
              return true;
            }
            if ("openRedPacket".equals(paramString))
            {
              e();
              return true;
            }
            if ("reply".equals(paramString))
            {
              f();
              return true;
            }
            if ("reportClick".equals(paramString))
            {
              e(localJSONObject);
              return true;
            }
            if ("vibrate".equals(paramString))
            {
              a(localJSONObject);
              return true;
            }
            if ("playAudio".equals(paramString))
            {
              b(localJSONObject);
              return true;
            }
            if ("addShakeEventListener".equals(paramString))
            {
              d((String)localObject2);
              return true;
            }
            if ("removeShakeEventListener".equals(paramString))
            {
              h();
              return true;
            }
            if ("log".equals(paramString)) {
              d(localJSONObject);
            }
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "methods error ");
          }
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "sn error ");
        }
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("url js error : length < 4 js = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("H5MagicPlayerActivity", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    super.setContentView(2131628330);
    a();
    b();
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(getApplicationContext());
    }
    paramBundle = getApplication().getSharedPreferences("h5magic_sp_name", 4);
    if (paramBundle != null) {
      paramBundle.edit().putBoolean("h5magic_sp_isplay_key", true).commit();
    }
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.o = paramBundle.density;
    this.p = (paramBundle.widthPixels / this.o);
    this.q = (paramBundle.heightPixels / this.o);
    paramBundle = super.getIntent();
    long l1 = paramBundle.getLongExtra("clickTime", 0L);
    this.c = ((SessionInfo)paramBundle.getParcelableExtra("sessionInfo"));
    this.d = ((Emoticon)paramBundle.getSerializableExtra("emoticon"));
    Object localObject1 = paramBundle.getStringExtra("autoPlay");
    this.m = paramBundle.getStringExtra("senderUin");
    if (paramBundle.hasExtra("childEmoticon")) {
      this.e = ((Emoticon)paramBundle.getSerializableExtra("childEmoticon"));
    }
    this.n = paramBundle.getStringExtra("selfUin");
    Object localObject2 = EmotionPanelConstans.H5MagicIndexHtmlPath.replace("[epId]", this.d.epId);
    paramBundle = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append((String)localObject2);
    paramBundle.append(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?sender_uin=");
    ((StringBuilder)localObject2).append(this.m);
    paramBundle.append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&self_uin=");
    ((StringBuilder)localObject2).append(this.n);
    paramBundle.append(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&auto_play=");
    ((StringBuilder)localObject2).append((String)localObject1);
    paramBundle.append(((StringBuilder)localObject2).toString());
    paramBundle.append("&platform=android");
    paramBundle.append("&version=8.8.17");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&start_time=");
    ((StringBuilder)localObject1).append(l1);
    paramBundle.append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&width=");
    ((StringBuilder)localObject1).append(this.p);
    paramBundle.append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&height=");
    ((StringBuilder)localObject1).append(this.q);
    paramBundle.append(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&pixel_ratio=");
    ((StringBuilder)localObject1).append(this.o);
    paramBundle.append(((StringBuilder)localObject1).toString());
    paramBundle = paramBundle.toString();
    this.b.loadUrl(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SharedPreferences localSharedPreferences = getApplication().getSharedPreferences("h5magic_sp_name", 4);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("h5magic_sp_isplay_key", false).commit();
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */