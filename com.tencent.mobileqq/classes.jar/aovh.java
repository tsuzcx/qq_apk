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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.ByteArrayInputStream;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;

public class aovh
  extends ReportDialog
{
  public static int a;
  public static long a;
  public static Intent a;
  public static bihu a;
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
    jdField_b_of_type_JavaLangString = antf.ba + "MsgPushNotify" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaLangString + "msgnotify_pic" + File.separator;
    jdField_d_of_type_JavaLangString = "msgnotify_pic.zip";
    jdField_e_of_type_JavaLangString = "msgnotify_pic_%d.jpg";
    jdField_a_of_type_Int = 25;
    jdField_f_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_g_of_type_JavaLangString = anzj.a(2131705844);
    h = anzj.a(2131705838);
    i = anzj.a(2131705841);
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 7;
    jdField_f_of_type_Int = 3;
    jdField_g_of_type_Int = 30;
  }
  
  @TargetApi(14)
  public aovh(Context paramContext)
  {
    super(paramContext, 2131755824);
    super.getWindow().setWindowAnimations(2131755130);
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
    if (paramString == null) {
      jdField_a_of_type_AndroidContentIntent = bhnl.a(paramQQAppInterface.getApp());
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
          XmlPullParser localXmlPullParser = Xml.newPullParser();
          localXmlPullParser.setInput(paramString, "utf-8");
          a(localXmlPullParser);
          if (QLog.isColorLevel()) {
            QLog.d("PushOpenNotify", 2, new Object[] { "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(jdField_a_of_type_Boolean), ", frequency:", Integer.valueOf(jdField_c_of_type_Int), " ", Integer.valueOf(jdField_d_of_type_Int), " ", Integer.valueOf(jdField_e_of_type_Int), " ", Integer.valueOf(jdField_f_of_type_Int), " ", Integer.valueOf(jdField_g_of_type_Int), ", intent:", jdField_a_of_type_AndroidContentIntent });
          }
          if ((jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean) && (jdField_a_of_type_AndroidContentIntent == null))
          {
            jdField_a_of_type_AndroidContentIntent = bhnl.a(paramQQAppInterface.getApp());
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("PushOpenNotify", 2, "handlePushOpenNotifyConfig, exception: " + paramQQAppInterface.getStackTrace());
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    int k = paramXmlPullParser.getEventType();
    label440:
    if (k != 1)
    {
      String str;
      if (paramXmlPullParser.getEventType() == 2)
      {
        str = paramXmlPullParser.getName();
        if (!str.equals("switch")) {
          break label64;
        }
        jdField_a_of_type_Boolean = paramXmlPullParser.nextText().equals("true");
      }
      label64:
      do
      {
        do
        {
          for (;;)
          {
            k = paramXmlPullParser.next();
            break;
            if (str.equals("frequency"))
            {
              jdField_b_of_type_Long = Long.valueOf(paramXmlPullParser.nextText()).longValue();
              if (jdField_b_of_type_Long < 0L) {
                jdField_b_of_type_Long = 0L;
              }
            }
            else if (str.equals("wording"))
            {
              jdField_g_of_type_JavaLangString = paramXmlPullParser.nextText();
            }
            else if (str.equals("title"))
            {
              h = paramXmlPullParser.nextText();
            }
            else if (str.equals("content"))
            {
              i = paramXmlPullParser.nextText();
            }
            else if (str.equals("frequency_OneTime"))
            {
              jdField_c_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("frequency_OneMax"))
            {
              jdField_d_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("frequency_TwoTime"))
            {
              jdField_e_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("frequency_TwoMax"))
            {
              jdField_f_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("frequency_ThreeTime"))
            {
              jdField_g_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("maxOSVersion"))
            {
              jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
            }
            else if (str.equals("defaultSwitch"))
            {
              jdField_b_of_type_Boolean = paramXmlPullParser.nextText().equals("true");
            }
            else
            {
              if ((!str.equals("rom")) || (!paramXmlPullParser.getAttributeValue(null, "name").equals(ROMUtil.getRomName())) || (!paramXmlPullParser.getAttributeValue(null, "sdk").equals(Build.VERSION.SDK_INT + ""))) {
                break label440;
              }
              b(paramXmlPullParser);
            }
          }
        } while ((!str.equals("device")) || (!paramXmlPullParser.getAttributeValue(null, "id").equals(bhlo.d())));
        b(paramXmlPullParser);
      } while (jdField_a_of_type_AndroidContentIntent == null);
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
        bhmi.d(String.format(jdField_c_of_type_JavaLangString + jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(k) }));
        k += 1;
      }
      else
      {
        if (paramFile.exists())
        {
          bhmi.a(paramFile.getPath(), jdField_b_of_type_JavaLangString, false);
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
  
  private static void b(XmlPullParser paramXmlPullParser)
  {
    jdField_a_of_type_AndroidContentIntent = null;
    for (;;)
    {
      Object localObject;
      if (paramXmlPullParser.next() != 3)
      {
        if (paramXmlPullParser.getEventType() != 2) {
          continue;
        }
        if (jdField_a_of_type_AndroidContentIntent == null) {
          jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        localObject = paramXmlPullParser.getName();
        if (((String)localObject).equals("action"))
        {
          jdField_a_of_type_AndroidContentIntent.setAction(paramXmlPullParser.nextText());
          continue;
        }
        if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramXmlPullParser.nextText());
          jdField_a_of_type_AndroidContentIntent.setData((Uri)localObject);
          continue;
        }
        if (((String)localObject).equals("type"))
        {
          jdField_a_of_type_AndroidContentIntent.setType(paramXmlPullParser.nextText());
          continue;
        }
        if (((String)localObject).equals("package"))
        {
          jdField_a_of_type_AndroidContentIntent.setPackage(paramXmlPullParser.nextText());
          continue;
        }
        if (((String)localObject).equals("component"))
        {
          localObject = paramXmlPullParser.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          jdField_a_of_type_AndroidContentIntent.setComponent((ComponentName)localObject);
          continue;
        }
        if (((String)localObject).equals("category"))
        {
          jdField_a_of_type_AndroidContentIntent.addCategory(paramXmlPullParser.nextText());
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
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    String str = jdField_b_of_type_JavaLangString + jdField_d_of_type_JavaLangString;
    File localFile = new File(str);
    if ((localFile.exists()) && (a(localFile))) {
      return true;
    }
    if (bhnv.a(BaseApplicationImpl.getApplication()) == 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "res download give up");
      return false;
    }
    if (jdField_a_of_type_Bihu != null)
    {
      if ((jdField_a_of_type_Bihu.a() == 2) || (jdField_a_of_type_Bihu.a() == 3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "res download duplicated, " + str);
        return false;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "res download task status error, cancel it, status: " + jdField_a_of_type_Bihu.a());
      jdField_a_of_type_Bihu.a(true);
    }
    jdField_a_of_type_Bihu = new bihu(jdField_f_of_type_JavaLangString, localFile);
    jdField_a_of_type_Bihu.n = true;
    paramQQAppInterface = ((bihw)paramQQAppInterface.getManager(47)).a(1);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "start download ");
    paramQQAppInterface.a(jdField_a_of_type_Bihu, new aovl(str), null);
    return false;
  }
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559017);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365512));
    paramBundle = (TextView)findViewById(2131365523);
    TextView localTextView = (TextView)findViewById(2131365491);
    Button localButton = (Button)findViewById(2131365488);
    ImageView localImageView = (ImageView)findViewById(2131364593);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(String.format(jdField_c_of_type_JavaLangString + jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(0) }));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      paramBundle.setText(h);
      localTextView.setText(i);
      localButton.setText(anzj.a(2131705839));
      localButton.setOnClickListener(new aovi(this));
      localImageView.setOnClickListener(new aovj(this));
      localImageView.setOnTouchListener(new aovk(this, localImageView));
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
      ThreadManager.post(new MsgNotifyPushDialog.4(this), 10, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */