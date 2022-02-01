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
  String a = null;
  private boolean b = false;
  private BitmapDrawable c;
  private String d = null;
  private boolean e;
  
  private Bitmap a(boolean paramBoolean, String paramString)
  {
    Object localObject = b(paramBoolean, paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = b();
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
      int i = getResources().getDimensionPixelSize(2131299699);
      paramString = ImageUtil.c((Bitmap)localObject, i, i);
      this.e = true;
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
      findViewById(2131431871).setVisibility(8);
      return;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
    {
      findViewById(2131442506).setVisibility(8);
      findViewById(2131442509).setVisibility(8);
      localObject1 = a(false, localIntent.getStringExtra("sid"));
    }
    else
    {
      findViewById(2131442506).setOnClickListener(this);
      findViewById(2131442509).setOnClickListener(this);
      localObject1 = a(true, localIntent.getStringExtra("uin"));
    }
    if (this.c == null) {
      this.c = new BitmapDrawable(c());
    }
    findViewById(2131431871).setBackgroundDrawable(this.c);
    if (localObject1 != null) {
      ((ImageView)findViewById(2131442505)).setImageBitmap((Bitmap)localObject1);
    } else {
      ((ImageView)findViewById(2131442505)).setImageResource(2130841158);
    }
    Object localObject1 = localIntent.getStringExtra("uinname");
    TextView localTextView = (TextView)findViewById(2131442507);
    if (localObject1 != null)
    {
      localTextView.setText((CharSequence)localObject1);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("starShortcut")))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131911429));
        localTextView.setText(((StringBuilder)localObject2).toString());
        localTextView.setTextSize(16.0F);
        ((TextView)findViewById(2131442508)).setVisibility(8);
        ((TextView)findViewById(2131446295)).setVisibility(0);
        localObject1 = (TextView)findViewById(2131446296);
        localObject2 = (String)((TextView)localObject1).getText();
        int i = ((String)localObject2).indexOf("TA");
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(2131168230)), i, i + 2, 17);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).setVisibility(0);
      }
    }
    if ((this.mRuntime != null) && ((this.mRuntime instanceof QQAppInterface)) && (QidianManager.a((QQAppInterface)this.mRuntime, localIntent.getStringExtra("uin")))) {
      findViewById(2131442509).setVisibility(8);
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
  
  /* Error */
  private Bitmap b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 41	com/tencent/mobileqq/activity/ShortcutGuideActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc 165
    //   6: invokevirtual 49	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 24	com/tencent/mobileqq/activity/ShortcutGuideActivity:d	Ljava/lang/String;
    //   14: astore_3
    //   15: aconst_null
    //   16: astore_2
    //   17: aload_3
    //   18: ifnonnull +23 -> 41
    //   21: aload_0
    //   22: aload_0
    //   23: ldc_w 264
    //   26: invokestatic 269	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   29: putfield 24	com/tencent/mobileqq/activity/ShortcutGuideActivity:d	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 24	com/tencent/mobileqq/activity/ShortcutGuideActivity:d	Ljava/lang/String;
    //   36: ifnonnull +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: new 87	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc_w 271
    //   53: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_0
    //   59: getfield 24	com/tencent/mobileqq/activity/ShortcutGuideActivity:d	Ljava/lang/String;
    //   62: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: ldc_w 273
    //   70: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_3
    //   79: aload_0
    //   80: invokevirtual 277	com/tencent/mobileqq/activity/ShortcutGuideActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   83: astore 4
    //   85: aload 4
    //   87: aload_3
    //   88: invokestatic 283	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   91: iconst_1
    //   92: anewarray 107	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 285
    //   100: aastore
    //   101: ldc_w 287
    //   104: iconst_1
    //   105: anewarray 107	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_1
    //   111: aastore
    //   112: aconst_null
    //   113: invokevirtual 293	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +51 -> 169
    //   121: aload_1
    //   122: invokeinterface 298 1 0
    //   127: ifeq +88 -> 215
    //   130: aload_1
    //   131: iconst_0
    //   132: invokeinterface 302 2 0
    //   137: astore_2
    //   138: goto +3 -> 141
    //   141: aload_2
    //   142: ifnull +27 -> 169
    //   145: aload_2
    //   146: invokestatic 304	com/tencent/mobileqq/activity/ShortcutGuideActivity:a	([B)Landroid/graphics/Bitmap;
    //   149: astore_2
    //   150: aload_1
    //   151: ifnull +9 -> 160
    //   154: aload_1
    //   155: invokeinterface 307 1 0
    //   160: aload_2
    //   161: areturn
    //   162: astore_2
    //   163: goto +18 -> 181
    //   166: goto +29 -> 195
    //   169: aload_1
    //   170: ifnull +35 -> 205
    //   173: goto +26 -> 199
    //   176: astore_3
    //   177: aload_2
    //   178: astore_1
    //   179: aload_3
    //   180: astore_2
    //   181: aload_1
    //   182: ifnull +9 -> 191
    //   185: aload_1
    //   186: invokeinterface 307 1 0
    //   191: aload_2
    //   192: athrow
    //   193: aconst_null
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +9 -> 205
    //   199: aload_1
    //   200: invokeinterface 307 1 0
    //   205: aconst_null
    //   206: areturn
    //   207: astore_1
    //   208: goto -15 -> 193
    //   211: astore_2
    //   212: goto -46 -> 166
    //   215: aconst_null
    //   216: astore_2
    //   217: goto -76 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ShortcutGuideActivity
    //   9	191	1	localObject1	Object
    //   207	1	1	localException1	Exception
    //   16	145	2	localObject2	Object
    //   162	16	2	localObject3	Object
    //   180	12	2	localObject4	Object
    //   211	1	2	localException2	Exception
    //   216	1	2	localObject5	Object
    //   14	74	3	localObject6	Object
    //   176	4	3	localObject7	Object
    //   83	3	4	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   121	138	162	finally
    //   145	150	162	finally
    //   85	117	176	finally
    //   85	117	207	java/lang/Exception
    //   121	138	211	java/lang/Exception
    //   145	150	211	java/lang/Exception
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
  
  private Bitmap c()
  {
    return ImageUtil.b(BitmapManager.a(getResources(), 2130847769), 14.0F, 540, 620);
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
      this.a = localIntent.getStringExtra("from");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("doOnCreate from=");
        paramBundle.append(this.a);
        QLog.d("ShortcutGuideActivity", 2, paramBundle.toString());
      }
      boolean bool = "qqbrowser_float_shortcut".equals(this.a);
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
      if ("shortcutFromQZonePhotolist".equals(this.a))
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
      if ((!this.b) && (!showPreview()))
      {
        finish();
        return false;
      }
      if (this.e) {}
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
      if ((!TextUtils.isEmpty(this.a)) && (this.a.equals("starShortcut"))) {
        paramBundle = a(false, localIntent.getStringExtra("starId"));
      } else {
        paramBundle = a(true, localIntent.getStringExtra("uin"));
      }
      if (paramBundle != null) {
        ((ImageView)findViewById(2131442505)).setImageBitmap(paramBundle);
      } else {
        ((ImageView)findViewById(2131442505)).setImageResource(2130841158);
      }
    }
    catch (Throwable paramBundle)
    {
      break label423;
    }
    finish();
    return false;
    ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_head", 0, 0, "", "", "", "");
    if ((!TextUtils.isEmpty(this.a)) && (this.a.equals("starShortcut")))
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
    if (i != 2131442506)
    {
      if (i == 2131442509)
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
      super.setContentView(2131627838);
      a();
      this.b = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideActivity
 * JD-Core Version:    0.7.0.1
 */