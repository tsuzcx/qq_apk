package com.tencent.gamecenter.activities;

import Override;
import acea;
import anaw;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import ausy;
import autf;
import azwq;
import bhmv;
import bhqe;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import nlw;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import xen;

public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private boolean b;
  private boolean c;
  private int e;
  
  public GameCenterActivity()
  {
    this.jdField_a_of_type_JavaLangClass = GameCenterActivity.GameCenterFragment.class;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString2 = "uin=" + paramString3;
    paramString3 = new Bundle();
    paramString3.putString("Cookie", paramString2);
    try
    {
      paramContext = nlw.a(paramContext, paramString1, "POST", localBundle, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = str;
    if (localAppRuntime != null)
    {
      localObject = str;
      if (localAppRuntime.getLongAccountUin() != 0L) {
        localObject = localAppRuntime.getAccount();
      }
    }
    localObject = localSharedPreferences.getString("trace_url_keyword" + (String)localObject, "");
    bhqe.a = new ArrayList();
    QLog.d("GameCenterActivity", 1, "parseTraceUrl:" + (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          str = (String)((JSONArray)localObject).opt(i);
          bhqe.a.add(str);
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("GameCenterActivity", 1, "parseTraceUrl:", localException);
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = paramString.indexOf('?');
    if (i > 0) {}
    for (;;)
    {
      paramString = paramString.substring(0, i);
      if (a(paramString)) {
        break;
      }
      return;
      i = paramString.length();
    }
    anaw.a(123, paramString, 1, 1213, new Object[] { "current DetectedBlankScreen status:", Integer.valueOf(paramInt) });
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    while (!a(paramString)) {
      return;
    }
    Object localObject = paramString.split("\\?");
    int i;
    if (localObject.length >= 2)
    {
      HashMap localHashMap = new HashMap();
      xen.a(localObject[1], localHashMap);
      localObject = (String)localHashMap.get("ADTAG");
      if ("10001".equals(localObject)) {
        if (paramBoolean2)
        {
          i = 1;
          label77:
          if (("gzh".equals(localObject)) || ("fwh".equals(localObject)) || ("fuwuhao".equals(localObject)) || ("76902".equals(localObject)))
          {
            if (!paramBoolean2) {
              break label239;
            }
            i = 3;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterActivity", 2, new Object[] { "reportStep step:", Integer.valueOf(paramInt), ",url:", paramString, ",hasRed:", Boolean.valueOf(paramBoolean2) });
      }
      if (paramInt == 1)
      {
        anaw.a(123, null, paramString);
        anaw.a(123, paramString, 1);
      }
      if (paramInt == 13)
      {
        anaw.a(123, null, paramString, new int[] { i });
        anaw.a(123, paramString, 1, 0, new Object[0]);
        anaw.b(123, paramString);
        return;
        i = 2;
        break label77;
        label239:
        i = 4;
        continue;
      }
      if (!paramBoolean1) {
        break;
      }
      i = -100;
      switch (paramInt)
      {
      }
      for (;;)
      {
        anaw.a(123, paramString, 1, i, new Object[] { "current step:", Integer.valueOf(paramInt) });
        return;
        i = 1201;
        continue;
        i = 1202;
        continue;
        i = 1211;
        continue;
        i = 1212;
      }
      i = 0;
      break label77;
      i = 0;
    }
  }
  
  private boolean a()
  {
    TextView localTextView = a().mSwiftTitleUI.b;
    if (localTextView == null) {}
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return false;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130839404);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = localTextView.getCompoundDrawables();
    this.e = localTextView.getCompoundDrawablePadding();
    localTextView.setCompoundDrawablePadding(10);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (bhqe.a == null) {
      a();
    }
    List localList = bhqe.a;
    if ((TextUtils.isEmpty(paramString)) || (localList == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < localList.size())
      {
        if (paramString.contains((CharSequence)localList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("game_msg_enter_from", 0) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterActivity", 2, "handlePushReport() called");
      }
      localIntent.removeExtra("game_msg_enter_from");
      autf.a(10004, 2);
    }
  }
  
  private boolean b()
  {
    TextView localTextView = a().mSwiftTitleUI.b;
    if (localTextView == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localTextView.setCompoundDrawablePadding(this.e);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void a(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if ((paramWebView instanceof TouchWebView)) {
      ((TouchWebView)paramWebView).setOnScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_a_of_type_Int += 1;
    b();
    azwq.a(BaseApplicationImpl.getApplication(), new acea(this));
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int <= 0) {
      MiniMsgIPCClient.getInstance().clearBusiness(8);
    }
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 8;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 2005: 
    default: 
      return true;
    case 2003: 
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 45000L);
      return true;
    case 2004: 
      b();
      return true;
    }
    Toast.makeText(BaseApplicationImpl.getApplication(), (String)paramMessage.obj, 0).show();
    return true;
  }
  
  public boolean isNeedMiniMsg()
  {
    Intent localIntent;
    Uri localUri;
    if (!this.c)
    {
      localIntent = getIntent();
      localUri = null;
      if (localIntent == null) {}
    }
    try
    {
      localUri = Uri.parse(localIntent.getStringExtra("url"));
      if (localUri != null) {
        this.b = "1".equals(localUri.getQueryParameter("gc_mini_floating"));
      }
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    this.c = true;
    return this.b;
  }
  
  public boolean onBackEvent()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = ausy.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.a()))
    {
      localGameCenterVideoViewController.c();
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */