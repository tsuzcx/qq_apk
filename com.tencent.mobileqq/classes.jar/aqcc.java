import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class aqcc
  extends aqbe
{
  protected static String h;
  aqvv jdField_a_of_type_Aqvv;
  protected ForwardFileInfo a;
  ArrayList<ForwardFileInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected long b;
  protected String i = "";
  protected String j = "";
  
  public aqcc(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject;
    if (paramLong < 1024L) {
      localObject = paramLong + " bytes";
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692558) + paramString + "\n" + this.jdField_a_of_type_AndroidContentContext.getString(2131692575) + (String)localObject;
      if (paramLong < 1048576L)
      {
        localObject = paramLong / 1024L + " KB";
      }
      else
      {
        localObject = new DecimalFormat("##0.00");
        localObject = ((DecimalFormat)localObject).format(paramLong / 1048576.0D) + " MB";
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
      return false;
    }
    return true;
  }
  
  private void f(String paramString)
  {
    bbgu localbbgu = new bbgu(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
    localbbgu.setContentView(2131558906);
    localbbgu.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131720260));
    localbbgu.setMessage(paramString);
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.setCancelable(false);
    localbbgu.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690572), new aqcd(this));
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localbbgu.show();
    }
  }
  
  protected String a(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileBaseOption", 2, "uri= " + paramUri);
    }
    if (this.jdField_a_of_type_Aqvv == null) {
      this.jdField_a_of_type_Aqvv = new aqvv(this.jdField_a_of_type_AndroidAppActivity, true, new aqcf(this));
    }
    return this.jdField_a_of_type_Aqvv.a(paramUri);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 102)
    {
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(Long.parseLong(str)))
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, ajya.a(2131704757), 2000).a();
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    else
    {
      return;
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      aent.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localArrayList, paramIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      bhwm.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public boolean a()
  {
    super.a();
    h = null;
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    if ((localUri != null) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath")))) {
      a(localUri);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("fileinfo"));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected boolean a(Uri paramUri)
  {
    String str = a(paramUri);
    if (TextUtils.isEmpty(str))
    {
      if (this.jdField_a_of_type_Aqvv != null)
      {
        paramUri = this.jdField_a_of_type_Aqvv;
        h = aqvv.jdField_a_of_type_JavaLangString;
      }
      f(e());
      return false;
    }
    File localFile = new File(str);
    long l = localFile.length();
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Aqvv != null)
    {
      bool1 = this.jdField_a_of_type_Aqvv.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Aqvv == null) {
        break label143;
      }
      bool2 = this.jdField_a_of_type_Aqvv.b;
    }
    for (;;)
    {
      if ((!bool1) && (!bool2) && (l == 0L))
      {
        if (paramUri.toString().contains("mms/part"))
        {
          f(this.jdField_a_of_type_AndroidContentContext.getString(2131692562));
          return false;
          bool1 = false;
          break;
          label143:
          bool2 = false;
          continue;
        }
        f(this.jdField_a_of_type_AndroidContentContext.getString(2131692537));
        return false;
      }
    }
    if ((true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_from_jump")) && (true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromShare")) && (b(str)))
    {
      paramUri = new bbgu(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
      paramUri.setContentView(2131558906);
      paramUri.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131720260));
      paramUri.setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131692539));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690572), new aqce(this));
      paramUri.show();
      return false;
    }
    paramUri = localFile.getName();
    boolean bool3 = localFile.canRead();
    if ((!bool1) && (!bool2) && (!bool3))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", str);
    e(str);
    this.jdField_a_of_type_JavaLangString = a(paramUri, l);
    this.j = paramUri;
    this.i = str;
    this.b = l;
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Bbgu.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_Bbgu.setMessageTextColor(2131165613);
    this.jdField_a_of_type_Bbgu.setMessageTextSize(14.0F);
  }
  
  protected boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", nnu.a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", ajya.a(2131704763));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (!this.f) {
          break label180;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label180:
      if (!bool) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
  }
  
  protected String e()
  {
    if (h == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719492);
    }
    return h;
  }
  
  protected void e(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcc
 * JD-Core Version:    0.7.0.1
 */