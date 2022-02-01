package com.tencent.mobileqq.activity;

import Override;
import afur;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anni;
import bcst;
import bggl;
import bgmo;
import bgrj;
import bjft;
import blsb;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class ShortcutGuideActivity
  extends AppActivity
  implements View.OnClickListener
{
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 25	com/tencent/mobileqq/activity/ShortcutGuideActivity:getIntent	()Landroid/content/Intent;
    //   6: ldc 27
    //   8: invokevirtual 33	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 35	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: ifnonnull +24 -> 40
    //   19: aload_0
    //   20: aload_0
    //   21: ldc 37
    //   23: invokestatic 42	bgrj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   26: putfield 35	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 35	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   33: ifnonnull +7 -> 40
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_2
    //   39: areturn
    //   40: new 44	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   47: ldc 47
    //   49: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 35	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 53
    //   61: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_0
    //   69: invokevirtual 61	com/tencent/mobileqq/activity/ShortcutGuideActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   72: astore 4
    //   74: aload 4
    //   76: aload_3
    //   77: invokestatic 67	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   80: iconst_1
    //   81: anewarray 69	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: ldc 71
    //   88: aastore
    //   89: ldc 73
    //   91: iconst_1
    //   92: anewarray 69	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: aconst_null
    //   100: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +43 -> 148
    //   108: aload_1
    //   109: invokeinterface 85 1 0
    //   114: ifeq +87 -> 201
    //   117: aload_1
    //   118: iconst_0
    //   119: invokeinterface 89 2 0
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +22 -> 148
    //   129: aload_2
    //   130: invokestatic 92	com/tencent/mobileqq/activity/ShortcutGuideActivity:a	([B)Landroid/graphics/Bitmap;
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull -99 -> 38
    //   140: aload_1
    //   141: invokeinterface 95 1 0
    //   146: aload_3
    //   147: areturn
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 95 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull -6 -> 158
    //   167: aload_1
    //   168: invokeinterface 95 1 0
    //   173: goto -15 -> 158
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull +9 -> 187
    //   181: aload_2
    //   182: invokeinterface 95 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_3
    //   190: aload_1
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: goto -17 -> 177
    //   197: astore_2
    //   198: goto -35 -> 163
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -78 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ShortcutGuideActivity
    //   11	142	1	localObject1	Object
    //   160	1	1	localException1	Exception
    //   162	6	1	localObject2	Object
    //   176	15	1	localObject3	Object
    //   193	1	1	localObject4	Object
    //   1	191	2	localObject5	Object
    //   197	1	2	localException2	Exception
    //   202	1	2	localObject6	Object
    //   67	80	3	localObject7	Object
    //   189	4	3	localObject8	Object
    //   72	3	4	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   74	104	160	java/lang/Exception
    //   74	104	176	finally
    //   108	125	189	finally
    //   129	134	189	finally
    //   108	125	197	java/lang/Exception
    //   129	134	197	java/lang/Exception
  }
  
  private Bitmap a(boolean paramBoolean, String paramString)
  {
    Object localObject = b(paramBoolean, paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = a();
    }
    if (paramString == null)
    {
      localObject = getAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        paramString = ((QQAppInterface)localObject).a(getIntent().getStringExtra("uin"), (byte)3, true);
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString != null)
      {
        int i = getResources().getDimensionPixelSize(2131298799);
        localObject = bgmo.c(paramString, i, i);
        this.jdField_b_of_type_Boolean = true;
      }
      return localObject;
    }
  }
  
  private static Bitmap a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 0) {
      return bggl.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getStringExtra("from");
    if (QLog.isColorLevel()) {
      QLog.d("ShortcutGuideActivity", 2, "showPreview from=" + (String)localObject2);
    }
    if ("shortcutFromQZonePhotolist".equals(localObject2)) {
      return;
    }
    if ("shortcutFromQZonePhotolist".equals(localObject2))
    {
      findViewById(2131365471).setVisibility(8);
      return;
    }
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
    {
      findViewById(2131374304).setVisibility(8);
      findViewById(2131374307).setVisibility(8);
      localObject1 = a(false, localIntent.getStringExtra("sid"));
      label130:
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(b());
      }
      findViewById(2131365471).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      if (localObject1 == null) {
        break label448;
      }
      ((ImageView)findViewById(2131374303)).setImageBitmap((Bitmap)localObject1);
    }
    for (;;)
    {
      localObject1 = localIntent.getStringExtra("uinname");
      TextView localTextView = (TextView)findViewById(2131374305);
      if (localObject1 != null)
      {
        localTextView.setText((CharSequence)localObject1);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
        {
          localTextView.setText((String)localObject1 + anni.a(2131712781));
          localTextView.setTextSize(16.0F);
          ((TextView)findViewById(2131374306)).setVisibility(8);
          ((TextView)findViewById(2131377790)).setVisibility(0);
          localObject1 = (TextView)findViewById(2131377791);
          localObject2 = (String)((TextView)localObject1).getText();
          int i = ((String)localObject2).indexOf("TA");
          localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(2131167151)), i, i + 2, 17);
          ((TextView)localObject1).setText((CharSequence)localObject2);
          ((TextView)localObject1).setVisibility(0);
        }
      }
      if ((this.mRuntime == null) || (!(this.mRuntime instanceof QQAppInterface)) || (!bjft.b((QQAppInterface)this.mRuntime, localIntent.getStringExtra("uin")))) {
        break;
      }
      findViewById(2131374307).setVisibility(8);
      return;
      findViewById(2131374304).setOnClickListener(this);
      findViewById(2131374307).setOnClickListener(this);
      localObject1 = a(true, localIntent.getStringExtra("uin"));
      break label130;
      label448:
      ((ImageView)findViewById(2131374303)).setImageResource(2130840337);
    }
  }
  
  private boolean a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    return (i < -k) || (j < -k) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  private Bitmap b()
  {
    return bgmo.b(bggl.a(getResources(), 2130846106), 14.0F, 540, 620);
  }
  
  private Bitmap b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    for (paramString = QQAppInterface.a(paramString);; paramString = bgrj.a(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      return bggl.a(paramString, localOptions);
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
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    try
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from");
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutGuideActivity", 2, "doOnCreate from=" + this.jdField_a_of_type_JavaLangString);
      }
      if ("qqbrowser_float_shortcut".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (!getAppRuntime().isLogin())
        {
          paramBundle = new Intent(this, LoginActivity.class);
          paramBundle.putExtra("action_name", "webview");
        }
        for (boolean bool = false;; bool = true)
        {
          paramBundle.putExtra("key_isReadModeEnabled", true);
          paramBundle.putExtra("url", localIntent.getStringExtra("url"));
          startActivity(paramBundle);
          finish();
          return bool;
          paramBundle = new Intent(this, QQBrowserActivity.class);
        }
      }
      if ("shortcutFromQZonePhotolist".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (!getAppRuntime().isLogin())
        {
          paramBundle = new Intent(this, LoginActivity.class);
          paramBundle.putExtra("UploadPhoto.key_from_album_shortcut", true);
          paramBundle.putExtras(localIntent);
          startActivity(paramBundle);
          finish();
          return true;
        }
        paramBundle = (QQAppInterface)getAppRuntime();
        if (paramBundle != null) {
          paramBundle.b();
        }
        blsb.a(this, getIntent().getStringExtra("UploadPhoto.key_album_id"), getIntent().getLongExtra("UploadPhoto.key_album_owner_uin", 0L), String.valueOf(getAppRuntime().getLongAccountUin()));
        finish();
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!showPreview()))
    {
      finish();
      return false;
    }
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("starShortcut")))
      {
        paramBundle = a(false, localIntent.getStringExtra("starId"));
        if (paramBundle == null) {
          break label528;
        }
        ((ImageView)findViewById(2131374303)).setImageBitmap(paramBundle);
      }
      for (;;)
      {
        bcst.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_head", 0, 0, "", "", "", "");
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("starShortcut")))
        {
          localIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          localIntent.putExtra("forward", "starClub");
          localIntent.setClassName(this, ShortcutRouterActivity.class.getName());
          startActivity(localIntent);
          finish();
        }
        if (BaseApplicationImpl.appStartTime > 0L) {
          Log.d("AutoMonitor", "actStartShort, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
        }
        return true;
        paramBundle = a(true, localIntent.getStringExtra("uin"));
        break;
        label528:
        ((ImageView)findViewById(2131374303)).setImageResource(2130840337);
      }
      return false;
    }
    catch (Throwable paramBundle)
    {
      finish();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    try
    {
      a();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = getIntent();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      localIntent.setClassName(this, ShortcutRouterActivity.class.getName());
      startActivity(localIntent);
      finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("shotcut_forward", SplashActivity.class.getName());
      afur.a(localIntent, new int[] { 2 });
      bcst.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "0", "", "", "");
      continue;
      localIntent.putExtra("shotcut_forward", AVActivity.class.getName());
      bcst.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_call", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (a(this, paramMotionEvent)))
    {
      finish();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean showPreview()
  {
    try
    {
      String str = getIntent().getStringExtra("from");
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutGuideActivity", 2, "showPreview from=" + str);
      }
      if ("shortcutFromQZonePhotolist".equals(str)) {
        return true;
      }
      super.setContentView(2131561535);
      a();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortcutGuideActivity", 2, "create exception :" + localThrowable.getMessage());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideActivity
 * JD-Core Version:    0.7.0.1
 */