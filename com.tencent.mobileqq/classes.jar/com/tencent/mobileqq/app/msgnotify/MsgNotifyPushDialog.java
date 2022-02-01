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
  private static long A = -1L;
  public static String a = "PushOpenNotify";
  public static long b = 86400000L;
  public static String c;
  public static String d;
  public static String e = "msgnotify_pic.zip";
  public static String f = "msgnotify_pic_%d.jpg";
  public static int g = 25;
  public static String h = "https://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
  public static DownloadTask i;
  public static boolean k = true;
  public static boolean l = true;
  public static int m = 0;
  public static Intent n = null;
  public static boolean o = false;
  @Deprecated
  public static long p = 0L;
  @Deprecated
  public static String q = HardCodeUtil.a(2131904831);
  public static String r = HardCodeUtil.a(2131904825);
  public static String s = HardCodeUtil.a(2131904828);
  public static int t = 0;
  public static int u = 3;
  public static int v = 7;
  public static int w = 3;
  public static int x = 30;
  public static boolean y = false;
  public static String z = null;
  private Context B;
  private boolean C;
  ImageView j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("MsgPushNotify");
    localStringBuilder.append(File.separator);
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("msgnotify_pic");
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
  }
  
  @TargetApi(14)
  public MsgNotifyPushDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.B = paramContext;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((!y) || (!paramQQAppInterface.getCurrentUin().equals(z)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
      }
      y = true;
      z = paramQQAppInterface.getCurrentUin();
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
      n = JumpToNotificationSettingUtil.a(paramAppRuntime.getApp());
      return;
    }
    try
    {
      paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
      localObject = Xml.newPullParser();
      ((XmlPullParser)localObject).setInput(paramString, "utf-8");
      a((XmlPullParser)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, new Object[] { "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(k), ", frequency:", Integer.valueOf(t), " ", Integer.valueOf(u), " ", Integer.valueOf(v), " ", Integer.valueOf(w), " ", Integer.valueOf(x), ", intent:", n });
      }
      if ((l) && (!o) && (n == null))
      {
        n = JumpToNotificationSettingUtil.a(paramAppRuntime.getApp());
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
    for (int i1 = paramXmlPullParser.getEventType(); i1 != 1; i1 = paramXmlPullParser.next()) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str1 = paramXmlPullParser.getName();
        if (str1.equals("switch"))
        {
          k = paramXmlPullParser.nextText().equals("true");
        }
        else if (str1.equals("frequency"))
        {
          p = Long.valueOf(paramXmlPullParser.nextText()).longValue();
          if (p < 0L) {
            p = 0L;
          }
        }
        else if (str1.equals("wording"))
        {
          q = paramXmlPullParser.nextText();
        }
        else if (str1.equals("title"))
        {
          r = paramXmlPullParser.nextText();
        }
        else if (str1.equals("content"))
        {
          s = paramXmlPullParser.nextText();
        }
        else if (str1.equals("frequency_OneTime"))
        {
          t = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_OneMax"))
        {
          u = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_TwoTime"))
        {
          v = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_TwoMax"))
        {
          w = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("frequency_ThreeTime"))
        {
          x = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("maxOSVersion"))
        {
          m = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
        }
        else if (str1.equals("defaultSwitch"))
        {
          l = paramXmlPullParser.nextText().equals("true");
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
          if ((str1.equals("device")) && (paramXmlPullParser.getAttributeValue(null, "id").equals(DeviceInfoUtil.f())))
          {
            b(paramXmlPullParser);
            if (n != null) {
              return;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= g) {
          break label170;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(d);
        localStringBuilder.append(f);
        if (new File(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(i1) })).exists()) {
          break label163;
        }
        i1 = 0;
      }
      catch (Exception paramFile)
      {
        StringBuilder localStringBuilder;
        QLog.e(a, 1, "unzipFile err, ", paramFile);
      }
      if (i1 < g)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(d);
        localStringBuilder.append(f);
        FileUtils.deleteFile(String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(i1) }));
        i1 += 1;
      }
      else
      {
        if (paramFile.exists())
        {
          FileUtils.uncompressZip(paramFile.getPath(), c, false);
          return true;
        }
        return false;
        label163:
        i1 += 1;
        continue;
        label170:
        i1 = 1;
        if (i1 != 0) {
          return true;
        }
        i1 = 0;
      }
    }
  }
  
  private static void b(XmlPullParser paramXmlPullParser)
  {
    n = null;
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        if (n == null) {
          n = new Intent();
        }
        Object localObject = paramXmlPullParser.getName();
        if (((String)localObject).equals("action"))
        {
          n.setAction(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramXmlPullParser.nextText());
          n.setData((Uri)localObject);
        }
        else if (((String)localObject).equals("type"))
        {
          n.setType(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("package"))
        {
          n.setPackage(paramXmlPullParser.nextText());
        }
        else if (((String)localObject).equals("component"))
        {
          localObject = paramXmlPullParser.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          n.setComponent((ComponentName)localObject);
        }
        else if (((String)localObject).equals("category"))
        {
          n.addCategory(paramXmlPullParser.nextText());
        }
        else
        {
          if (((String)localObject).equals("blackList"))
          {
            o = true;
            n = null;
            return;
          }
          if (((String)localObject).equals("app_uid"))
          {
            n.putExtra("app_uid", Process.myUid());
            paramXmlPullParser.nextText();
          }
          else
          {
            n.putExtra((String)localObject, paramXmlPullParser.nextText());
          }
        }
      }
    }
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c);
    ((StringBuilder)localObject1).append(e);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if ((((File)localObject2).exists()) && (a((File)localObject2))) {
      return true;
    }
    if (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0)
    {
      QLog.d(a, 1, "res download give up");
      return false;
    }
    Object localObject3 = i;
    if (localObject3 != null) {
      if ((((DownloadTask)localObject3).e() != 2) && (i.e() != 3))
      {
        localObject3 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("res download task status error, cancel it, status: ");
        localStringBuilder.append(i.e());
        QLog.d((String)localObject3, 1, localStringBuilder.toString());
        i.a(true);
      }
      else
      {
        paramQQAppInterface = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("res download duplicated, ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d(paramQQAppInterface, 1, ((StringBuilder)localObject2).toString());
        return false;
      }
    }
    i = new DownloadTask(h, (File)localObject2);
    i.J = true;
    paramQQAppInterface = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    QLog.d(a, 1, "start download ");
    paramQQAppInterface.startDownload(i, new MsgNotifyPushDialog.5((String)localObject1), null);
    return false;
  }
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131624621);
    this.j = ((ImageView)findViewById(2131431868));
    paramBundle = (TextView)findViewById(2131431880);
    TextView localTextView = (TextView)findViewById(2131431844);
    Button localButton = (Button)findViewById(2131431841);
    ImageView localImageView = (ImageView)findViewById(2131430817);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(f);
      localObject = BitmapFactory.decodeFile(String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(0) }));
      this.j.setBackgroundDrawable(new BitmapDrawable(this.B.getResources(), (Bitmap)localObject));
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label148:
      break label148;
    }
    getOwnerActivity().finish();
    paramBundle.setText(r);
    localTextView.setText(s);
    localButton.setText(HardCodeUtil.a(2131904826));
    localButton.setOnClickListener(new MsgNotifyPushDialog.1(this));
    localImageView.setOnClickListener(new MsgNotifyPushDialog.2(this));
    localImageView.setOnTouchListener(new MsgNotifyPushDialog.3(this, localImageView));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!this.C) {
      ThreadManager.post(new MsgNotifyPushDialog.4(this), 10, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog
 * JD-Core Version:    0.7.0.1
 */