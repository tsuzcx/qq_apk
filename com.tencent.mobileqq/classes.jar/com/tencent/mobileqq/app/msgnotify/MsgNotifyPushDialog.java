package com.tencent.mobileqq.app.msgnotify;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpToNotificationSettingUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.ByteArrayInputStream;
import java.io.File;
import mqq.app.AppRuntime;
import org.xmlpull.v1.XmlPullParser;

public class MsgNotifyPushDialog
  extends ReportDialog
{
  public static int a = 0;
  public static long a = 86400000L;
  public static Intent a;
  public static DownloadTask a;
  public static String a = "PushOpenNotify";
  public static boolean a = false;
  public static int b = 0;
  @Deprecated
  public static long b = 0L;
  public static String b;
  public static boolean b = false;
  public static int c = 0;
  private static long c = -1L;
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
  public static String j = null;
  private Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("MsgPushNotify");
    localStringBuilder.append(File.separator);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("msgnotify_pic");
    localStringBuilder.append(File.separator);
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    jdField_d_of_type_JavaLangString = "msgnotify_pic.zip";
    jdField_e_of_type_JavaLangString = "msgnotify_pic_%d.jpg";
    jdField_a_of_type_Int = 25;
    jdField_f_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_AndroidContentIntent = null;
    jdField_c_of_type_Boolean = false;
    jdField_b_of_type_Long = 0L;
    jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131706989);
    h = HardCodeUtil.a(2131706983);
    i = HardCodeUtil.a(2131706986);
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 7;
    jdField_f_of_type_Int = 3;
    jdField_g_of_type_Int = 30;
    jdField_d_of_type_Boolean = false;
  }
  
  @TargetApi(14)
  public MsgNotifyPushDialog(Context paramContext)
  {
    super(paramContext, 2131756189);
    super.getWindow().setWindowAnimations(2131755294);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((!jdField_d_of_type_Boolean) || (!paramQQAppInterface.getCurrentUin().equals(j)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
      }
      jdField_d_of_type_Boolean = true;
      j = paramQQAppInterface.getCurrentUin();
      a(paramQQAppInterface, null, true);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApp());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppRuntime.getCurrentUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("push_open_notify_xml");
      paramString = paramString.getString(((StringBuilder)localObject).toString(), null);
    }
    if (paramString == null)
    {
      jdField_a_of_type_AndroidContentIntent = JumpToNotificationSettingUtil.a(paramAppRuntime.getApp());
      return;
    }
    try
    {
      paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
      localObject = Xml.newPullParser();
      ((XmlPullParser)localObject).setInput(paramString, "utf-8");
      a((XmlPullParser)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, new Object[] { "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(jdField_a_of_type_Boolean), ", frequency:", Integer.valueOf(jdField_c_of_type_Int), " ", Integer.valueOf(jdField_d_of_type_Int), " ", Integer.valueOf(jdField_e_of_type_Int), " ", Integer.valueOf(jdField_f_of_type_Int), " ", Integer.valueOf(jdField_g_of_type_Int), ", intent:", jdField_a_of_type_AndroidContentIntent });
      }
      if ((jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean) && (jdField_a_of_type_AndroidContentIntent == null))
      {
        jdField_a_of_type_AndroidContentIntent = JumpToNotificationSettingUtil.a(paramAppRuntime.getApp());
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handlePushOpenNotifyConfig, exception: ");
        paramString.append(paramAppRuntime.getStackTrace());
        QLog.i("PushOpenNotify", 2, paramString.toString());
      }
    }
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    for (int k = paramXmlPullParser.getEventType(); k != 1; k = paramXmlPullParser.next()) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str1 = paramXmlPullParser.getName();
        if (str1.equals("switch"))
        {
          jdField_a_of_type_Boolean = paramXmlPullParser.nextText().equals("true");
        }
        else if (str1.equals("frequency"))
        {
          jdField_b_of_type_Long = Long.valueOf(paramXmlPullParser.nextText()).longValue();
          if (jdField_b_of_type_Long < 0L) {
            jdField_b_of_type_Long = 0L;
          }
        }
        else if (str1.equals("wording"))
        {
          jdField_g_of_type_JavaLangString = paramXmlPullParser.nextText();
        }
        else if (str1.equals("title"))
        {
          h = paramXmlPullParser.nextText();
        }
        else if (str1.equals("content"))
        {
          i = paramXmlPullParser.nextText();
        }
        else if (str1.equals("frequency_OneTime"))
        {
          jdField_c_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_OneMax"))
        {
          jdField_d_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_TwoTime"))
        {
          jdField_e_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_TwoMax"))
        {
          jdField_f_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_ThreeTime"))
        {
          jdField_g_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("maxOSVersion"))
        {
          jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("defaultSwitch"))
        {
          jdField_b_of_type_Boolean = paramXmlPullParser.nextText().equals("true");
        }
        else
        {
          if ((str1.equals("rom")) && (paramXmlPullParser.getAttributeValue(null, "name").equals(ROMUtil.getRomName())))
          {
            String str2 = paramXmlPullParser.getAttributeValue(null, "sdk");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(Build.VERSION.SDK_INT);
            localStringBuilder.append("");
            if (str2.equals(localStringBuilder.toString()))
            {
              b(paramXmlPullParser);
              continue;
            }
          }
          if ((str1.equals("device")) && (paramXmlPullParser.getAttributeValue(null, "id").equals(DeviceInfoUtil.d())))
          {
            b(paramXmlPullParser);
            if (jdField_a_of_type_AndroidContentIntent != null) {
              return;
            }
          }
        }
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
          break label170;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_c_of_type_JavaLangString);
        localStringBuilder.append(jdField_e_of_type_JavaLangString);
        if (new File(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(k) })).exists()) {
          break label163;
        }
        k = 0;
      }
      catch (Exception paramFile)
      {
        StringBuilder localStringBuilder;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unzipFile err, ", paramFile);
      }
      if (k < jdField_a_of_type_Int)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_c_of_type_JavaLangString);
        localStringBuilder.append(jdField_e_of_type_JavaLangString);
        FileUtils.deleteFile(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(k) }));
        k += 1;
      }
      else
      {
        if (paramFile.exists())
        {
          FileUtils.uncompressZip(paramFile.getPath(), jdField_b_of_type_JavaLangString, false);
          return true;
        }
        return false;
        label163:
        k += 1;
        continue;
        label170:
        k = 1;
        if (k != 0) {
          return true;
        }
        k = 0;
      }
    }
  }
  
  private static void b(XmlPullParser paramXmlPullParser)
  {
    jdField_a_of_type_AndroidContentIntent = null;
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        if (jdField_a_of_type_AndroidContentIntent == null) {
          jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        Object localObject = paramXmlPullParser.getName();
        if (((String)localObject).equals("action"))
        {
          jdField_a_of_type_AndroidContentIntent.setAction(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramXmlPullParser.nextText());
          jdField_a_of_type_AndroidContentIntent.setData((Uri)localObject);
        }
        else if (((String)localObject).equals("type"))
        {
          jdField_a_of_type_AndroidContentIntent.setType(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("package"))
        {
          jdField_a_of_type_AndroidContentIntent.setPackage(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("component"))
        {
          localObject = paramXmlPullParser.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          jdField_a_of_type_AndroidContentIntent.setComponent((ComponentName)localObject);
        }
        else if (((String)localObject).equals("category"))
        {
          jdField_a_of_type_AndroidContentIntent.addCategory(paramXmlPullParser.nextText());
        }
        else
        {
          if (((String)localObject).equals("blackList"))
          {
            jdField_c_of_type_Boolean = true;
            jdField_a_of_type_AndroidContentIntent = null;
            return;
          }
          if (((String)localObject).equals("app_uid"))
          {
            jdField_a_of_type_AndroidContentIntent.putExtra("app_uid", Process.myUid());
            paramXmlPullParser.nextText();
          }
          else
          {
            jdField_a_of_type_AndroidContentIntent.putExtra((String)localObject, paramXmlPullParser.nextText());
          }
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(jdField_d_of_type_JavaLangString);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if ((((File)localObject2).exists()) && (a((File)localObject2))) {
      return true;
    }
    if (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "res download give up");
      return false;
    }
    Object localObject3 = jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
    if (localObject3 != null) {
      if ((((DownloadTask)localObject3).a() != 2) && (jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a() != 3))
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("res download task status error, cancel it, status: ");
        localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a());
        QLog.d((String)localObject3, 1, localStringBuilder.toString());
        jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(true);
      }
      else
      {
        paramQQAppInterface = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("res download duplicated, ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramQQAppInterface, 1, ((StringBuilder)localObject2).toString());
        return false;
      }
    }
    jdField_a_of_type_ComTencentMobileqqVipDownloadTask = new DownloadTask(jdField_f_of_type_JavaLangString, (File)localObject2);
    jdField_a_of_type_ComTencentMobileqqVipDownloadTask.n = true;
    paramQQAppInterface = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "start download ");
    paramQQAppInterface.startDownload(jdField_a_of_type_ComTencentMobileqqVipDownloadTask, new MsgNotifyPushDialog.5((String)localObject1), null);
    return false;
  }
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558988);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365637));
    paramBundle = (TextView)findViewById(2131365648);
    TextView localTextView = (TextView)findViewById(2131365613);
    Button localButton = (Button)findViewById(2131365610);
    ImageView localImageView = (ImageView)findViewById(2131364711);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(jdField_e_of_type_JavaLangString);
      localObject = BitmapFactory.decodeFile(String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(0) }));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject));
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label148:
      break label148;
    }
    getOwnerActivity().finish();
    paramBundle.setText(h);
    localTextView.setText(i);
    localButton.setText(HardCodeUtil.a(2131706984));
    localButton.setOnClickListener(new MsgNotifyPushDialog.1(this));
    localImageView.setOnClickListener(new MsgNotifyPushDialog.2(this));
    localImageView.setOnTouchListener(new MsgNotifyPushDialog.3(this, localImageView));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!this.jdField_e_of_type_Boolean) {
      ThreadManager.post(new MsgNotifyPushDialog.4(this), 10, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog
 * JD-Core Version:    0.7.0.1
 */