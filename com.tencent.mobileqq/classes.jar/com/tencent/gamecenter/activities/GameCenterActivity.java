package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import aqsn;
import bcbv;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import nam;
import org.apache.http.client.ClientProtocolException;

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
      paramContext = nam.a(paramContext, paramString1, "POST", localBundle, paramString3);
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
  
  private boolean a()
  {
    TextView localTextView = b().a.b;
    if (localTextView == null) {}
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return false;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130839142);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = localTextView.getCompoundDrawables();
    this.e = localTextView.getCompoundDrawablePadding();
    localTextView.setCompoundDrawablePadding(10);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    return true;
  }
  
  private boolean b()
  {
    TextView localTextView = b().a.b;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_a_of_type_Int += 1;
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
    GameCenterVideoViewController localGameCenterVideoViewController = aqsn.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.a()))
    {
      localGameCenterVideoViewController.c();
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */