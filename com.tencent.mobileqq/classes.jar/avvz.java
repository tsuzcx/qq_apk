import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class avvz
{
  private static volatile avvz jdField_a_of_type_Avvz;
  private avuj jdField_a_of_type_Avuj;
  public avuo a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public static avvz a()
  {
    if (jdField_a_of_type_Avvz == null) {}
    try
    {
      if (jdField_a_of_type_Avvz == null) {
        jdField_a_of_type_Avvz = new avvz();
      }
      return jdField_a_of_type_Avvz;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Avvz != null) {
      jdField_a_of_type_Avvz.b();
    }
  }
  
  public avuo a()
  {
    return this.jdField_a_of_type_Avuo;
  }
  
  public String a(String paramString)
  {
    return InnerDns.getInstance().reqDns(paramString, 1017);
  }
  
  public Future<Bundle> a(String paramString1, String paramString2)
  {
    return ThreadManagerExecutor.getExecutorService(128).submit(new avwf(this, paramString2, paramString1));
  }
  
  public Future<Bundle> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return ThreadManagerExecutor.getExecutorService(128).submit(new avwd(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("url", "");
    QLog.i("PluginManagerInterfaceImpl", 1, "跳转web页面 URL = " + (String)localObject);
    localObject = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtras(paramBundle);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  public void a(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    try
    {
      String str = paramBundle.getString("url", "");
      paramBundle = paramBundle.getString("path", "");
      this.jdField_a_of_type_Avuj = avuj.jdField_a_of_type_Avuj;
      this.jdField_a_of_type_Avuj.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Avuj.a(str, new avwb(this, paramDownloadCallback, str));
      this.jdField_a_of_type_Avuj.a(avul.a(str, "com.tencent.now", paramBundle));
      return;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public void a(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.i("PluginManagerInterfaceImpl", 1, "sendCsTask(): mApp is null, PluginManagerInterfaceImpl had unInit.");
      return;
    }
    String str1 = paramBundle.getString("serviceName");
    String str2 = paramBundle.getString("serviceCmd");
    paramBundle = paramBundle.getByteArray("buffer");
    ((avwi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_Avuo == null) {
      this.jdField_a_of_type_Avuo = new avuo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    NowLive.setCustomizedTicket(new avwa(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    jdField_a_of_type_Avvz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Avuo = null;
    if (this.jdField_a_of_type_Avuj != null)
    {
      this.jdField_a_of_type_Avuj.a();
      this.jdField_a_of_type_Avuj = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public void b(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    nyy localnyy = (nyy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOW_PROXY_HANDLER);
    localnyy.a(paramBundle.getString("fromId"), paramBundle.getLong("roomId"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new avwc(this, localnyy, paramCommonCallback));
  }
  
  public void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void d(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_title", paramBundle.getString("title"));
    localIntent.putExtra("arg_src", paramBundle.getString("anchor_name"));
    localIntent.putExtra("arg_cover", paramBundle.getString("cover_url"));
    localIntent.putExtra("arg_source_url", paramBundle.getString("room_url"));
    localIntent.putExtra("biu_src", 24);
    localIntent.putExtra("arg_now_live_vid", paramBundle.getString("vid"));
    localIntent.putExtra("arg_now_anchor_uin", paramBundle.getLong("qq_number"));
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvz
 * JD-Core Version:    0.7.0.1
 */