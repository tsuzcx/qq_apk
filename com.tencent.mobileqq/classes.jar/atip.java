import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class atip
{
  private static long jdField_a_of_type_Long;
  private atiu jdField_a_of_type_Atiu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Integer, atiw> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public atip(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atiu = new atiu(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("tmast://appdetails?");
    localStringBuilder.append("pname=").append(paramString);
    if (paramInt == 2)
    {
      localStringBuilder.append("&via=").append("ANDROIDQQ.NEWYYB.APKBYYBAPK");
      bdla.b(null, "dc00898", "", "", "0X800B00E", "0X800B00E", 0, 0, "", "", "", "");
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
    bdla.b(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
  }
  
  public String a(Context paramContext)
  {
    String str2 = ((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).a().jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getString(2131697971);
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
    if (auht.a().a() == null)
    {
      paramString = new Bundle();
      paramString.putString("_filename_from_dlg", paramContext.getString(2131694394));
      paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      paramString.putBundle("_user_data", (Bundle)localObject);
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramString);
      ((Intent)localObject).putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    paramString = new Bundle();
    paramString.putString("_filename_from_dlg", paramContext.getString(2131694394));
    paramString.putString("big_brother_source_key", "biz_src_jc_file");
    paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramString.putBundle("_user_data", (Bundle)localObject);
    auht.a().a("https://a.app.qq.com/o/myapp-down?g_f=1116518", paramString);
  }
  
  public void a(String paramString, atiw paramatiw)
  {
    a();
    ThreadManagerV2.excute(new QFileAppStorePromoteManager.2(this, paramString, paramatiw), 128, null, true);
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
  
  public boolean a(Context paramContext, String paramString, ativ paramativ)
  {
    if (((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).a().jdField_a_of_type_Boolean)
    {
      String str1 = paramContext.getString(2131697977);
      paramString = String.format(paramContext.getString(2131697974), new Object[] { paramString });
      String str2 = paramContext.getString(2131697975);
      String str3 = paramContext.getString(2131697976);
      atiq localatiq = new atiq(this, paramativ);
      paramativ = new atir(this, paramativ);
      bhdj.a(paramContext, 0, str1, paramString, str2, str3, paramContext.getString(2131690697), localatiq, paramativ).show();
      bdla.b(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (auht.a().a("https://a.app.qq.com/o/myapp-down?g_f=1116518"))
    {
      QQToast.a(paramContext, 0, 2131697973, 0).a();
      return;
    }
    String str = paramContext.getString(2131697972);
    bhdj.a((Activity)paramContext, str, 2131690697, 2131694399, new atis(this, paramContext, paramString), new atit(this)).show();
  }
  
  public boolean b()
  {
    return ((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).a().jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atip
 * JD-Core Version:    0.7.0.1
 */