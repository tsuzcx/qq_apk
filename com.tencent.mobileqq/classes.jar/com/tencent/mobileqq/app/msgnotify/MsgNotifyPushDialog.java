package com.tencent.mobileqq.app.msgnotify;

import aaba;
import aabb;
import aabc;
import aabd;
import aabf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.util.Xml;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

public class MsgNotifyPushDialog
  extends Dialog
{
  public static int a;
  public static long a;
  public static Intent a;
  public static DownloadTask a;
  public static String a;
  public static boolean a;
  public static int b;
  @Deprecated
  public static long b;
  public static String b;
  public static boolean b;
  public static int c;
  private static long c;
  public static String c;
  public static boolean c;
  public static int d;
  public static String d;
  public static boolean d;
  public static int e;
  public static String e;
  public static int f;
  public static String f;
  public static int g;
  @Deprecated
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  private Context a;
  public ImageView a;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PushOpenNotify";
    jdField_c_of_type_Long = -1L;
    jdField_a_of_type_Long = 86400000L;
    jdField_b_of_type_JavaLangString = AppConstants.aK + "MsgPushNotify" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaLangString + "msgnotify_pic" + File.separator;
    jdField_d_of_type_JavaLangString = "msgnotify_pic.zip";
    jdField_e_of_type_JavaLangString = "msgnotify_pic_%d.jpg";
    jdField_a_of_type_Int = 25;
    jdField_f_of_type_JavaLangString = "http://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_g_of_type_JavaLangString = "你的推送功能尚未开启，不能及时看到好友发来的消息，请开启QQ消息通知。";
    h = "开启消息推送";
    i = "及时接收好友消息，不再错过任何精彩。";
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 7;
    jdField_f_of_type_Int = 3;
    jdField_g_of_type_Int = 30;
  }
  
  @TargetApi(14)
  public MsgNotifyPushDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    super.getWindow().setWindowAnimations(2131624572);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((!jdField_d_of_type_Boolean) || (!paramQQAppInterface.c().equals(j)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
      }
      jdField_d_of_type_Boolean = true;
      j = paramQQAppInterface.c();
      a(paramQQAppInterface, null, true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).getString(paramQQAppInterface.c() + "_" + "push_open_notify_xml", null);
    }
    if (paramString == null)
    {
      jdField_a_of_type_AndroidContentIntent = new Intent();
      jdField_a_of_type_AndroidContentIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramQQAppInterface = Uri.parse("package:" + paramQQAppInterface.getApp().getPackageName());
      jdField_a_of_type_AndroidContentIntent.setData(paramQQAppInterface);
      return;
    }
    Object localObject;
    label190:
    do
    {
      for (;;)
      {
        try
        {
          localObject = new ByteArrayInputStream(paramString.getBytes("utf-8"));
          paramString = Xml.newPullParser();
          paramString.setInput((InputStream)localObject, "utf-8");
          int k = paramString.getEventType();
          if (k == 1) {
            break label851;
          }
          if (paramString.getEventType() == 2)
          {
            localObject = paramString.getName();
            if (((String)localObject).equals("switch")) {
              jdField_a_of_type_Boolean = paramString.nextText().equals("true");
            }
          }
          else
          {
            k = paramString.next();
            continue;
          }
          if (!((String)localObject).equals("frequency")) {
            break label278;
          }
          jdField_b_of_type_Long = Long.valueOf(paramString.nextText()).longValue();
          if (jdField_b_of_type_Long >= 0L) {
            continue;
          }
          jdField_b_of_type_Long = 0L;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramQQAppInterface) {}
        QLog.i("PushOpenNotify", 2, "handlePushOpenNotifyConfig, exception: " + paramQQAppInterface.getStackTrace());
        return;
        if (((String)localObject).equals("wording"))
        {
          jdField_g_of_type_JavaLangString = paramString.nextText();
        }
        else if (((String)localObject).equals("title"))
        {
          h = paramString.nextText();
        }
        else if (((String)localObject).equals("content"))
        {
          i = paramString.nextText();
        }
        else if (((String)localObject).equals("frequency_OneTime"))
        {
          jdField_c_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_OneMax"))
        {
          jdField_d_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_TwoTime"))
        {
          jdField_e_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_TwoMax"))
        {
          jdField_f_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_ThreeTime"))
        {
          jdField_g_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("maxOSVersion"))
        {
          jdField_b_of_type_Int = Integer.valueOf(paramString.nextText()).intValue();
        }
        else
        {
          if (!((String)localObject).equals("defaultSwitch")) {
            break label550;
          }
          jdField_b_of_type_Boolean = paramString.nextText().equals("true");
        }
      }
    } while ((!((String)localObject).equals("device")) || (!paramString.getAttributeValue(null, "id").equals(DeviceInfoUtil.e())));
    for (;;)
    {
      label278:
      label550:
      if (paramString.next() != 3)
      {
        if (paramString.getEventType() != 2) {
          continue;
        }
        if (jdField_a_of_type_AndroidContentIntent == null) {
          jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        localObject = paramString.getName();
        if (((String)localObject).equals("action"))
        {
          jdField_a_of_type_AndroidContentIntent.setAction(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramString.nextText());
          jdField_a_of_type_AndroidContentIntent.setData((Uri)localObject);
          continue;
        }
        if (((String)localObject).equals("type"))
        {
          jdField_a_of_type_AndroidContentIntent.setType(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("package"))
        {
          jdField_a_of_type_AndroidContentIntent.setPackage(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("component"))
        {
          localObject = paramString.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          jdField_a_of_type_AndroidContentIntent.setComponent((ComponentName)localObject);
          continue;
        }
        if (((String)localObject).equals("category"))
        {
          jdField_a_of_type_AndroidContentIntent.addCategory(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("blackList"))
        {
          jdField_c_of_type_Boolean = true;
          jdField_a_of_type_AndroidContentIntent = null;
        }
      }
      else
      {
        if (jdField_a_of_type_AndroidContentIntent == null) {
          break label190;
        }
        label851:
        if (QLog.isColorLevel()) {
          QLog.d("PushOpenNotify", 2, new Object[] { "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(jdField_a_of_type_Boolean), ", frequency:", Integer.valueOf(jdField_c_of_type_Int), " ", Integer.valueOf(jdField_d_of_type_Int), " ", Integer.valueOf(jdField_e_of_type_Int), " ", Integer.valueOf(jdField_f_of_type_Int), " ", Integer.valueOf(jdField_g_of_type_Int), ", intent:", jdField_a_of_type_AndroidContentIntent });
        }
        if ((!jdField_b_of_type_Boolean) || (jdField_c_of_type_Boolean) || (jdField_a_of_type_AndroidContentIntent != null)) {
          break;
        }
        jdField_a_of_type_AndroidContentIntent = new Intent();
        jdField_a_of_type_AndroidContentIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        paramQQAppInterface = Uri.parse("package:" + paramQQAppInterface.getApp().getPackageName());
        jdField_a_of_type_AndroidContentIntent.setData(paramQQAppInterface);
        return;
      }
      if (((String)localObject).equals("app_uid"))
      {
        jdField_a_of_type_AndroidContentIntent.putExtra("app_uid", Process.myUid());
        paramString.nextText();
      }
      else
      {
        jdField_a_of_type_AndroidContentIntent.putExtra((String)localObject, paramString.nextText());
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    int k = 0;
    for (;;)
    {
      try
      {
        if (k >= jdField_a_of_type_Int) {
          break label151;
        }
        if (new File(String.format(jdField_c_of_type_JavaLangString + jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(k) })).exists()) {
          break label159;
        }
        k = 0;
      }
      catch (Exception paramFile)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unzipFile err, ", paramFile);
      }
      if (k < jdField_a_of_type_Int)
      {
        FileUtils.d(String.format(jdField_c_of_type_JavaLangString + jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(k) }));
        k += 1;
      }
      else
      {
        if (paramFile.exists())
        {
          FileUtils.a(paramFile.getPath(), jdField_b_of_type_JavaLangString, false);
          return true;
        }
        return false;
        label151:
        k = 1;
        if (k != 0)
        {
          return true;
          label159:
          k += 1;
        }
        else
        {
          k = 0;
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    String str = jdField_b_of_type_JavaLangString + jdField_d_of_type_JavaLangString;
    File localFile = new File(str);
    if ((localFile.exists()) && (a(localFile))) {
      return true;
    }
    if (NetworkUtil.a(BaseApplicationImpl.getApplication()) == 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "res download give up");
      return false;
    }
    if (jdField_a_of_type_ComTencentMobileqqVipDownloadTask != null)
    {
      if ((jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a() == 2) || (jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a() == 3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "res download duplicated, " + str);
        return false;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "res download task status error, cancel it, status: " + jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a());
      jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(true);
    }
    jdField_a_of_type_ComTencentMobileqqVipDownloadTask = new DownloadTask(jdField_f_of_type_JavaLangString, localFile);
    jdField_a_of_type_ComTencentMobileqqVipDownloadTask.l = true;
    paramQQAppInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "start download ");
    paramQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqVipDownloadTask, new aabf(str), null);
    return false;
  }
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130968861);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364103));
    paramBundle = (TextView)findViewById(2131364059);
    TextView localTextView = (TextView)findViewById(2131364104);
    Button localButton = (Button)findViewById(2131364105);
    ImageView localImageView = (ImageView)findViewById(2131364003);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(String.format(jdField_c_of_type_JavaLangString + jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(0) }));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      paramBundle.setText(h);
      localTextView.setText(i);
      localButton.setText("马上设置");
      localButton.setOnClickListener(new aaba(this));
      localImageView.setOnClickListener(new aabb(this));
      localImageView.setOnTouchListener(new aabc(this, localImageView));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        getOwnerActivity().finish();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!this.jdField_e_of_type_Boolean) {
      ThreadManager.post(new aabd(this), 10, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog
 * JD-Core Version:    0.7.0.1
 */