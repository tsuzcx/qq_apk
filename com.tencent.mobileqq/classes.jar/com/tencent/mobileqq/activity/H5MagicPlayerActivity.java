package com.tencent.mobileqq.activity;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
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
import srx;
import sry;
import srz;
import ssa;
import ssb;

public class H5MagicPlayerActivity
  extends BaseActivity
{
  float jdField_a_of_type_Float;
  public int a;
  public SoundPool a;
  Vibrator jdField_a_of_type_AndroidOsVibrator;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener = new ssb(this);
  public Emoticon a;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  WebViewClient jdField_a_of_type_ComTencentSmttSdkWebViewClient;
  public String a;
  public boolean a;
  float jdField_b_of_type_Float;
  public int b;
  Emoticon jdField_b_of_type_ComTencentMobileqqDataEmoticon;
  String jdField_b_of_type_JavaLangString = null;
  float c;
  public String c;
  public String d;
  
  public H5MagicPlayerActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
  }
  
  private JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if (!paramString.contains("=")) {
        continue;
      }
      paramString = paramString.split("=");
      if ((paramString == null) || (paramString.length < 2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("H5MagicPlayerActivity", 2, "jsons = error ");
        return null;
      }
      paramString = paramString[1].split("#");
      if ((paramString == null) || (paramString.length < 2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("H5MagicPlayerActivity", 2, "jsons # error ");
        return null;
      }
      String str = paramString[0];
      if (str == null) {
        continue;
      }
      try
      {
        paramString = URLDecoder.decode(str, "UTF-8");
        if (paramString == null) {
          continue;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString == null) {
            continue;
          }
          return paramString;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "Failed to decode json str, josn=" + str);
          }
          paramString = null;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("H5MagicPlayerActivity", 2, "Failed to parse json str,json=");
            }
            paramString = null;
          }
        }
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(this);
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131362822);
    localFrameLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkWebView, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(DisplayUtil.a(this, 24.0F), DisplayUtil.a(this, 24.0F));
    localLayoutParams.setMargins(0, DisplayUtil.a(this, 9.0F), DisplayUtil.a(this, 10.0F), 0);
    localLayoutParams.gravity = 53;
    localButton.setLayoutParams(localLayoutParams);
    localButton.setBackgroundDrawable(getResources().getDrawable(2130843874));
    localButton.setOnClickListener(new srx(this));
    localFrameLayout.addView(localButton);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setBackgroundColor(0);
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView.getBackground() != null) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.getBackground().setAlpha(0);
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(33554432);
  }
  
  private void a(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "playAudio file dont exist ");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int == -1);
      AudioUtil.a(BaseApplicationImpl.getContext(), true);
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(5, 3, 0);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(localFile.getAbsolutePath(), 1);
      if (this.jdField_b_of_type_Int != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("H5MagicPlayerActivity", 2, "load failure filepath=" + paramString);
    return;
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new srz(this, paramString));
      return;
    }
    ThreadManager.getTimer().schedule(new ssa(this, paramString), 200L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "magicCalljs sn is empty");
      }
    }
    do
    {
      return;
      paramString1 = "javascript:execGlobalCallback(((0)),((1)))".replace("((0))", paramString1).replace("((1))", paramString2);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("H5MagicPlayerActivity", 2, "magicCalljs calljs = " + paramString1);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    long l = 1000L;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("duration"))
        {
          int i = paramJSONObject.getInt("duration");
          l = i;
        }
      }
      catch (Exception paramJSONObject)
      {
        l = 1000L;
        continue;
      }
      if (this.jdField_a_of_type_AndroidOsVibrator == null) {
        this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getSystemService("vibrator"));
      }
      if (this.jdField_a_of_type_AndroidOsVibrator != null) {
        this.jdField_a_of_type_AndroidOsVibrator.vibrate(l);
      }
      return;
      l = 1000L;
    }
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowContentAccess(true);
    ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
    this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new sry(this);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
    localObject = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(localObject))) {
      getWindow().addFlags(16777216);
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    paramString = (SensorManager)getSystemService("sensor");
    paramString.registerListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener, paramString.getDefaultSensor(1), 0);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "audioFilePath = null ");
      }
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView.removeAllViews();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
    g();
    h();
    WebIPCOperator.a().a().doUnbindService(getApplicationContext());
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "getAudioFilePath json = null ");
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (paramJSONObject.has("file"))
        {
          str = paramJSONObject.getString("file");
          label38:
          if (!paramJSONObject.has("loop")) {
            break label86;
          }
        }
        label86:
        for (int i = paramJSONObject.getInt("loop");; i = -1)
        {
          this.jdField_a_of_type_Int = i;
          if (str != null) {
            break label121;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("H5MagicPlayerActivity", 2, "playAudio fileName = null ");
          return;
          str = null;
          break label38;
        }
      }
      catch (Exception paramJSONObject)
      {
        String str;
        for (;;)
        {
          this.jdField_a_of_type_Int = -1;
          paramJSONObject.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "playAudio json error ");
          }
          str = null;
        }
        label121:
        if (this.jdField_a_of_type_Int == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("H5MagicPlayerActivity", 2, "playAudio loop = -1 ");
          }
        }
        else {
          this.jdField_b_of_type_JavaLangString = (EmoticonUtils.v.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId) + str);
        }
      }
    }
  }
  
  private void d()
  {
    super.finish();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramJSONObject.has("message")) {}
        for (paramJSONObject = paramJSONObject.getString("message"); QLog.isColorLevel(); paramJSONObject = "")
        {
          QLog.d("H5MagicPlayerActivity", 2, "log " + paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = "json parse erro";
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "openRedPacket:sessionInfo = null ");
      }
      return;
    }
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      i = 1;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("recv_type", i);
        if (!TextUtils.isEmpty("")) {
          localJSONObject.put("session_token", "");
        }
        localJSONObject.put("channel", 1);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Intent localIntent;
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "click HongBao:params=" + localJSONObject.toString());
      }
      localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#mobiao");
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
      super.startActivity(localIntent);
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8005FE5", 0, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i = 3;
      }
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    int i = -1;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (paramJSONObject.has("click")) {
        i = paramJSONObject.getInt("click");
      }
      ReportController.b(null, "CliOper", "", "", "ep_mall", "itemclick", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, i + "", "", "");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "reportClick json error");
        }
        paramJSONObject.printStackTrace();
        i = -1;
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEmoticon != null)
    {
      Object localObject = EmoticonUtils.w.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqDataEmoticon.epId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://" + (String)localObject);
      localStringBuilder.append("?sender_uin=" + this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("&self_uin=" + this.d);
      localStringBuilder.append("&auto_play=0");
      localStringBuilder.append("&platform=android");
      localStringBuilder.append("&version=7.6.0");
      localStringBuilder.append("&start_time=" + System.currentTimeMillis());
      localStringBuilder.append("&width=" + this.jdField_b_of_type_Float);
      localStringBuilder.append("&height=" + this.jdField_c_of_type_Float);
      localStringBuilder.append("&pixel_ratio=" + this.jdField_a_of_type_Float);
      localObject = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reply url = " + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl((String)localObject);
      if (WebIPCOperator.a().a())
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("emoticon", this.jdField_b_of_type_ComTencentMobileqqDataEmoticon);
        ((Bundle)localObject).putParcelable("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        localObject = DataFactory.a("ipc_h5magic_sendmsg", "", -1, (Bundle)localObject);
        WebIPCOperator.a().a((Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: childEmotcionEpid = " + this.jdField_b_of_type_ComTencentMobileqqDataEmoticon.epId);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = this.jdField_b_of_type_ComTencentMobileqqDataEmoticon;
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8005FE6", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "send childEmoticon: service not bind");
      }
      d();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("H5MagicPlayerActivity", 2, "reply childemoticon doesnt exit ");
      }
      d();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      AudioUtil.a(BaseApplicationImpl.getContext(), false);
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = false;
    ((SensorManager)getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
  
  public boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("jsbridge://")))
    {
      Object localObject1 = paramString.split("/");
      if ((localObject1 == null) || (localObject1.length < 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "url js error : length < 4 js = " + paramString);
        }
        return false;
      }
      if (!"magicEmotion".equals(localObject1[2]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "objectName is error ");
        }
        return false;
      }
      Object localObject2 = paramString.split("#");
      if ((localObject2 == null) || (localObject2.length < 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "sn error ");
        }
        return false;
      }
      localObject2 = localObject2[1];
      JSONObject localJSONObject = a(paramString);
      CharSequence localCharSequence = localObject1[3];
      if (TextUtils.isEmpty(localCharSequence))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "method error ");
        }
        return false;
      }
      localObject1 = "\\?";
      if (!paramString.contains("?")) {
        localObject1 = "#";
      }
      paramString = localCharSequence.split((String)localObject1);
      if ((paramString == null) || (paramString.length < 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("H5MagicPlayerActivity", 2, "methods error ");
        }
        return false;
      }
      paramString = paramString[0];
      if ("close".equals(paramString)) {
        d();
      }
      for (;;)
      {
        return true;
        if ("openRedPacket".equals(paramString)) {
          e();
        } else if ("reply".equals(paramString)) {
          f();
        } else if ("reportClick".equals(paramString)) {
          e(localJSONObject);
        } else if ("vibrate".equals(paramString)) {
          a(localJSONObject);
        } else if ("playAudio".equals(paramString)) {
          b(localJSONObject);
        } else if ("addShakeEventListener".equals(paramString)) {
          b((String)localObject2);
        } else if ("removeShakeEventListener".equals(paramString)) {
          h();
        } else if ("log".equals(paramString)) {
          d(localJSONObject);
        }
      }
    }
    return false;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    super.setContentView(2130970909);
    a();
    b();
    if (!WebIPCOperator.a().a()) {
      WebIPCOperator.a().a().doBindService(getApplicationContext());
    }
    paramBundle = getApplication().getSharedPreferences("h5magic_sp_name", 4);
    if (paramBundle != null) {
      paramBundle.edit().putBoolean("h5magic_sp_isplay_key", true).commit();
    }
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.jdField_a_of_type_Float = paramBundle.density;
    this.jdField_b_of_type_Float = (paramBundle.widthPixels / this.jdField_a_of_type_Float);
    this.jdField_c_of_type_Float = (paramBundle.heightPixels / this.jdField_a_of_type_Float);
    Object localObject = super.getIntent();
    long l = ((Intent)localObject).getLongExtra("clickTime", 0L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)((Intent)localObject).getParcelableExtra("sessionInfo"));
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)((Intent)localObject).getSerializableExtra("emoticon"));
    paramBundle = ((Intent)localObject).getStringExtra("autoPlay");
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("senderUin");
    if (((Intent)localObject).hasExtra("childEmoticon")) {
      this.jdField_b_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)((Intent)localObject).getSerializableExtra("childEmoticon"));
    }
    this.d = ((Intent)localObject).getStringExtra("selfUin");
    localObject = EmoticonUtils.w.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://" + (String)localObject);
    localStringBuilder.append("?sender_uin=" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("&self_uin=" + this.d);
    localStringBuilder.append("&auto_play=" + paramBundle);
    localStringBuilder.append("&platform=android");
    localStringBuilder.append("&version=7.6.0");
    localStringBuilder.append("&start_time=" + l);
    localStringBuilder.append("&width=" + this.jdField_b_of_type_Float);
    localStringBuilder.append("&height=" + this.jdField_c_of_type_Float);
    localStringBuilder.append("&pixel_ratio=" + this.jdField_a_of_type_Float);
    paramBundle = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramBundle);
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