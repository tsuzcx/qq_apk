package com.tencent.mobileqq.activity;

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
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class ShortcutGuideActivity
  extends AppActivity
  implements View.OnClickListener
{
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private Bitmap a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 29	com/tencent/mobileqq/activity/ShortcutGuideActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc 31
    //   6: invokevirtual 37	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 21	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   14: astore_3
    //   15: aconst_null
    //   16: astore_2
    //   17: aload_3
    //   18: ifnonnull +22 -> 40
    //   21: aload_0
    //   22: aload_0
    //   23: ldc 39
    //   25: invokestatic 44	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   28: putfield 21	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 21	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   35: ifnonnull +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: new 46	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   47: astore_3
    //   48: aload_3
    //   49: ldc 49
    //   51: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload_0
    //   57: getfield 21	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   60: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc 55
    //   67: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_3
    //   76: aload_0
    //   77: invokevirtual 63	com/tencent/mobileqq/activity/ShortcutGuideActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   80: astore 4
    //   82: aload 4
    //   84: aload_3
    //   85: invokestatic 69	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   88: iconst_1
    //   89: anewarray 71	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: ldc 73
    //   96: aastore
    //   97: ldc 75
    //   99: iconst_1
    //   100: anewarray 71	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload_1
    //   106: aastore
    //   107: aconst_null
    //   108: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +51 -> 164
    //   116: aload_1
    //   117: invokeinterface 87 1 0
    //   122: ifeq +88 -> 210
    //   125: aload_1
    //   126: iconst_0
    //   127: invokeinterface 91 2 0
    //   132: astore_2
    //   133: goto +3 -> 136
    //   136: aload_2
    //   137: ifnull +27 -> 164
    //   140: aload_2
    //   141: invokestatic 94	com/tencent/mobileqq/activity/ShortcutGuideActivity:a	([B)Landroid/graphics/Bitmap;
    //   144: astore_2
    //   145: aload_1
    //   146: ifnull +9 -> 155
    //   149: aload_1
    //   150: invokeinterface 97 1 0
    //   155: aload_2
    //   156: areturn
    //   157: astore_2
    //   158: goto +18 -> 176
    //   161: goto +29 -> 190
    //   164: aload_1
    //   165: ifnull +35 -> 200
    //   168: goto +26 -> 194
    //   171: astore_3
    //   172: aload_2
    //   173: astore_1
    //   174: aload_3
    //   175: astore_2
    //   176: aload_1
    //   177: ifnull +9 -> 186
    //   180: aload_1
    //   181: invokeinterface 97 1 0
    //   186: aload_2
    //   187: athrow
    //   188: aconst_null
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +9 -> 200
    //   194: aload_1
    //   195: invokeinterface 97 1 0
    //   200: aconst_null
    //   201: areturn
    //   202: astore_1
    //   203: goto -15 -> 188
    //   206: astore_2
    //   207: goto -46 -> 161
    //   210: aconst_null
    //   211: astore_2
    //   212: goto -76 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	ShortcutGuideActivity
    //   9	186	1	localObject1	Object
    //   202	1	1	localException1	Exception
    //   16	140	2	localObject2	Object
    //   157	16	2	localObject3	Object
    //   175	12	2	localObject4	Object
    //   206	1	2	localException2	Exception
    //   211	1	2	localObject5	Object
    //   14	71	3	localObject6	Object
    //   171	4	3	localObject7	Object
    //   80	3	4	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   116	133	157	finally
    //   140	145	157	finally
    //   82	112	171	finally
    //   82	112	202	java/lang/Exception
    //   116	133	206	java/lang/Exception
    //   140	145	206	java/lang/Exception
  }
  
  private Bitmap a(boolean paramBoolean, String paramString)
  {
    Object localObject = b(paramBoolean, paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = a();
    }
    localObject = paramString;
    if (paramString == null)
    {
      AppRuntime localAppRuntime = getAppRuntime();
      localObject = paramString;
      if (localAppRuntime != null)
      {
        localObject = paramString;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = ((QQAppInterface)localAppRuntime).getFaceBitmap(getIntent().getStringExtra("uin"), (byte)3, true);
        }
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      int i = getResources().getDimensionPixelSize(2131298973);
      paramString = ImageUtil.c((Bitmap)localObject, i, i);
      this.jdField_b_of_type_Boolean = true;
    }
    return paramString;
  }
  
  private static Bitmap a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 0) {
      return BitmapManager.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getStringExtra("from");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showPreview from=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("ShortcutGuideActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if ("shortcutFromQZonePhotolist".equals(localObject2)) {
      return;
    }
    if ("shortcutFromQZonePhotolist".equals(localObject2))
    {
      findViewById(2131365640).setVisibility(8);
      return;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
    {
      findViewById(2131374344).setVisibility(8);
      findViewById(2131374347).setVisibility(8);
      localObject1 = a(false, localIntent.getStringExtra("sid"));
    }
    else
    {
      findViewById(2131374344).setOnClickListener(this);
      findViewById(2131374347).setOnClickListener(this);
      localObject1 = a(true, localIntent.getStringExtra("uin"));
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(b());
    }
    findViewById(2131365640).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    if (localObject1 != null) {
      ((ImageView)findViewById(2131374343)).setImageBitmap((Bitmap)localObject1);
    } else {
      ((ImageView)findViewById(2131374343)).setImageResource(2130840405);
    }
    Object localObject1 = localIntent.getStringExtra("uinname");
    TextView localTextView = (TextView)findViewById(2131374345);
    if (localObject1 != null)
    {
      localTextView.setText((CharSequence)localObject1);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131713896));
        localTextView.setText(((StringBuilder)localObject2).toString());
        localTextView.setTextSize(16.0F);
        ((TextView)findViewById(2131374346)).setVisibility(8);
        ((TextView)findViewById(2131377826)).setVisibility(0);
        localObject1 = (TextView)findViewById(2131377827);
        localObject2 = (String)((TextView)localObject1).getText();
        int i = ((String)localObject2).indexOf("TA");
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(2131167238)), i, i + 2, 17);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).setVisibility(0);
      }
    }
    if ((this.mRuntime != null) && ((this.mRuntime instanceof QQAppInterface)) && (QidianManager.a((QQAppInterface)this.mRuntime, localIntent.getStringExtra("uin")))) {
      findViewById(2131374347).setVisibility(8);
    }
  }
  
  private boolean a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    int m = -k;
    return (i < m) || (j < m) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  private Bitmap b()
  {
    return ImageUtil.b(BitmapManager.a(getResources(), 2130846298), 14.0F, 540, 620);
  }
  
  private Bitmap b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      paramString = QQAppInterface.getBuddyFaceFilePath(paramString);
    } else {
      paramString = QQUtils.a(paramString);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return BitmapManager.a(paramString, localOptions);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    try
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("doOnCreate from=");
        paramBundle.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ShortcutGuideActivity", 2, paramBundle.toString());
      }
      boolean bool = "qqbrowser_float_shortcut".equals(this.jdField_a_of_type_JavaLangString);
      if (bool)
      {
        bool = getAppRuntime().isLogin();
        if (!bool)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("action_name", "webview");
          paramBundle.putExtra("key_isReadModeEnabled", true);
          paramBundle.putExtra("url", localIntent.getStringExtra("url"));
          RouteUtils.a(this, paramBundle, "/base/login");
          finish();
          return false;
        }
        paramBundle = new Intent(this, QQBrowserActivity.class);
        paramBundle.putExtra("key_isReadModeEnabled", true);
        paramBundle.putExtra("url", localIntent.getStringExtra("url"));
        startActivity(paramBundle);
        finish();
        return true;
      }
      if ("shortcutFromQZonePhotolist".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (!getAppRuntime().isLogin())
        {
          paramBundle = new Intent();
          paramBundle.putExtra("UploadPhoto.key_from_album_shortcut", true);
          paramBundle.putExtras(localIntent);
          RouteUtils.a(this, paramBundle, "/base/login");
          finish();
          return true;
        }
        paramBundle = (QQAppInterface)getAppRuntime();
        if (paramBundle != null) {
          paramBundle.initFaceSettingCache();
        }
        QZoneHelper.goQZoneAlbumPhotoList(this, getIntent().getStringExtra("UploadPhoto.key_album_id"), getIntent().getLongExtra("UploadPhoto.key_album_owner_uin", 0L), String.valueOf(getAppRuntime().getLongAccountUin()));
        finish();
        return true;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!showPreview()))
      {
        finish();
        return false;
      }
      if (this.jdField_b_of_type_Boolean) {}
    }
    catch (Throwable paramBundle)
    {
      label423:
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    try
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("starShortcut"))) {
        paramBundle = a(false, localIntent.getStringExtra("starId"));
      } else {
        paramBundle = a(true, localIntent.getStringExtra("uin"));
      }
      if (paramBundle != null) {
        ((ImageView)findViewById(2131374343)).setImageBitmap(paramBundle);
      } else {
        ((ImageView)findViewById(2131374343)).setImageResource(2130840405);
      }
    }
    catch (Throwable paramBundle)
    {
      break label423;
    }
    finish();
    return false;
    ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_head", 0, 0, "", "", "", "");
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("starShortcut")))
    {
      localIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
      localIntent.putExtra("forward", "starClub");
      localIntent.setClassName(this, ShortcutRouterActivity.class.getName());
      startActivity(localIntent);
      finish();
    }
    if (BaseApplicationImpl.appStartTime > 0L)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("actStartShort, cost=");
      paramBundle.append(SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime);
      Log.d("AutoMonitor", paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
    int i = paramView.getId();
    if (i != 2131374344)
    {
      if (i == 2131374347)
      {
        localIntent.putExtra("shotcut_forward", AVActivity.class.getName());
        ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_call", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localIntent.putExtra("shotcut_forward", SplashActivity.class.getName());
      AIOUtils.a(localIntent, new int[] { 2 });
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "0", "", "", "");
    }
    localIntent.setClassName(this, ShortcutRouterActivity.class.getName());
    startActivity(localIntent);
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
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
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPreview from=");
        localStringBuilder.append(str);
        QLog.d("ShortcutGuideActivity", 2, localStringBuilder.toString());
      }
      if ("shortcutFromQZonePhotolist".equals(str)) {
        return true;
      }
      super.setContentView(2131561481);
      a();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      localThrowable.printStackTrace();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("create exception :");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d("ShortcutGuideActivity", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideActivity
 * JD-Core Version:    0.7.0.1
 */