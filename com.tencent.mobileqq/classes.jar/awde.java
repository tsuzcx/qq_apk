import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class awde
{
  private static volatile awde jdField_a_of_type_Awde;
  private awbo jdField_a_of_type_Awbo;
  public awbt a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public static awde a()
  {
    if (jdField_a_of_type_Awde == null) {}
    try
    {
      if (jdField_a_of_type_Awde == null) {
        jdField_a_of_type_Awde = new awde();
      }
      return jdField_a_of_type_Awde;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Awde != null) {
      jdField_a_of_type_Awde.b();
    }
  }
  
  public awbt a()
  {
    return this.jdField_a_of_type_Awbt;
  }
  
  public String a(String paramString)
  {
    return InnerDns.getInstance().reqDns(paramString, 1017);
  }
  
  public Future<Bundle> a(String paramString1, String paramString2)
  {
    return aoik.a(128).submit(new awdk(this, paramString2, paramString1));
  }
  
  public Future<Bundle> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return aoik.a(128).submit(new awdi(this, paramString1, paramString2, paramString3, paramString4));
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
      this.jdField_a_of_type_Awbo = awbo.jdField_a_of_type_Awbo;
      this.jdField_a_of_type_Awbo.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Awbo.a(str, new awdg(this, paramDownloadCallback, str));
      this.jdField_a_of_type_Awbo.a(awbq.a(str, "com.tencent.now", paramBundle));
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
    String str1 = paramBundle.getString("serviceName");
    String str2 = paramBundle.getString("serviceCmd");
    paramBundle = paramBundle.getByteArray("buffer");
    ((awdn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(145)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_Awbt == null) {
      this.jdField_a_of_type_Awbt = new awbt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    NowLive.setCustomizedTicket(new awdf(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    jdField_a_of_type_Awde = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Awbt = null;
    if (this.jdField_a_of_type_Awbo != null)
    {
      this.jdField_a_of_type_Awbo.a();
      this.jdField_a_of_type_Awbo = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public void b(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    nqo localnqo = (nqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(130);
    localnqo.a(paramBundle.getString("fromId"), paramBundle.getLong("roomId"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new awdh(this, localnqo, paramCommonCallback));
  }
  
  public void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
 * Qualified Name:     awde
 * JD-Core Version:    0.7.0.1
 */