package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  
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
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString3);
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130838604);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = localTextView.getCompoundDrawables();
    this.jdField_a_of_type_Int = localTextView.getCompoundDrawablePadding();
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
      localTextView.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */