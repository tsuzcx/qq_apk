import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.HashMap;

public class asej
{
  private static long jdField_a_of_type_Long;
  private aseo jdField_a_of_type_Aseo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Integer, aseq> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public asej(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aseo = new aseo(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("tmast://appdetails?");
    localStringBuilder.append("pname=").append(paramString);
    if (paramInt == 2)
    {
      localStringBuilder.append("&via=").append("ANDROIDQQ.NEWYYB.APKBYYBAPK");
      bcef.b(null, "dc00898", "", "", "0X800B00E", "0X800B00E", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localStringBuilder.append("&qimei=").append(UserAction.getQIMEI());
      return localStringBuilder.toString();
      localStringBuilder.append("&via=").append("ANDROIDQQ.YYB.APKBYYBAPK");
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast: start app store limit.");
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. apk package name can not be null.");
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : apkPkgName[" + paramString + "]");
    }
    paramString = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : jumpTmast[" + paramString + "]");
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    TMAssistantCallYYB_V2.getInstance().addDownloadTaskFromTmast((Bundle)localObject);
    localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setPackage("com.tencent.android.qqdownloader");
    ((Intent)localObject).setData(Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_file");
    try
    {
      BaseApplication.getContext().startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. " + paramString.getMessage());
    }
  }
  
  public static void b()
  {
    bcef.b(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
  }
  
  public String a(Context paramContext)
  {
    String str2 = ((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getString(2131697689);
    }
    return str1;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManagerV2.executeOnSubThread(new QFileAppStorePromoteManager.1(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("params_open_with_yyb", paramString);
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_jc_file");
    if (atdm.a().a() == null)
    {
      paramString = new Bundle();
      paramString.putString("_filename_from_dlg", paramContext.getString(2131694196));
      paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      paramString.putBundle("_user_data", (Bundle)localObject);
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramString);
      ((Intent)localObject).putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    paramString = new Bundle();
    paramString.putString("_filename_from_dlg", paramContext.getString(2131694196));
    paramString.putString("big_brother_source_key", "biz_src_jc_file");
    paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramString.putBundle("_user_data", (Bundle)localObject);
    atdm.a().a("https://a.app.qq.com/o/myapp-down?g_f=1116518", paramString);
  }
  
  public void a(String paramString, aseq paramaseq)
  {
    a();
    ThreadManagerV2.excute(new QFileAppStorePromoteManager.2(this, paramString, paramaseq), 128, null, true);
  }
  
  public boolean a()
  {
    a();
    int i = TMAssistantCallYYB_V2.getInstance().checkQQDownloaderInstalled();
    if ((i == 2) || (i == 0))
    {
      i = 1;
      if (i == 0) {
        break label53;
      }
    }
    label53:
    for (int j = GlobalUtil.getInstance().getQQDownloaderVersionCode();; j = 0)
    {
      if ((i != 0) && (j > 7342130))
      {
        return true;
        i = 0;
        break;
      }
      return false;
    }
  }
  
  public boolean a(Context paramContext, String paramString, asep paramasep)
  {
    if (((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a().jdField_a_of_type_Boolean)
    {
      String str1 = paramContext.getString(2131697695);
      paramString = String.format(paramContext.getString(2131697692), new Object[] { paramString });
      String str2 = paramContext.getString(2131697693);
      String str3 = paramContext.getString(2131697694);
      asek localasek = new asek(this, paramasep);
      paramasep = new asel(this, paramasep);
      bfur.a(paramContext, 0, str1, paramString, str2, str3, paramContext.getString(2131690620), localasek, paramasep).show();
      bcef.b(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (atdm.a().a("https://a.app.qq.com/o/myapp-down?g_f=1116518"))
    {
      QQToast.a(paramContext, 0, 2131697691, 0).a();
      return;
    }
    String str = paramContext.getString(2131697690);
    bfur.a((Activity)paramContext, str, 2131690620, 2131694201, new asem(this, paramContext, paramString), new asen(this)).show();
  }
  
  public boolean b()
  {
    return ((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a().jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asej
 * JD-Core Version:    0.7.0.1
 */