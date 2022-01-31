import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class aszx
{
  private static volatile aszx jdField_a_of_type_Aszx;
  private asyk jdField_a_of_type_Asyk;
  public asyp a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public static aszx a()
  {
    if (jdField_a_of_type_Aszx == null) {}
    try
    {
      if (jdField_a_of_type_Aszx == null) {
        jdField_a_of_type_Aszx = new aszx();
      }
      return jdField_a_of_type_Aszx;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Aszx != null) {
      jdField_a_of_type_Aszx.b();
    }
  }
  
  public asyp a()
  {
    return this.jdField_a_of_type_Asyp;
  }
  
  public String a(String paramString)
  {
    return bavf.a().a(paramString, 1017);
  }
  
  public Future<Bundle> a(String paramString1, String paramString2)
  {
    return alza.a(128).submit(new atad(this, paramString2, paramString1));
  }
  
  public Future<Bundle> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return alza.a(128).submit(new atab(this, paramString1, paramString2, paramString3, paramString4));
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
      this.jdField_a_of_type_Asyk = asyk.jdField_a_of_type_Asyk;
      this.jdField_a_of_type_Asyk.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Asyk.a(str, new aszz(this, paramDownloadCallback, str));
      this.jdField_a_of_type_Asyk.a(asym.a(str, "com.tencent.now", paramBundle));
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
    ((atag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(145)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_Asyp == null) {
      this.jdField_a_of_type_Asyp = new asyp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    NowLive.setCustomizedTicket(new aszy(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    jdField_a_of_type_Aszx = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Asyp = null;
    if (this.jdField_a_of_type_Asyk != null)
    {
      this.jdField_a_of_type_Asyk.a();
      this.jdField_a_of_type_Asyk = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i(paramBundle.getString("tag", "nowplugin_dynamic"), 1, paramBundle.getString("msg", ""));
  }
  
  public void b(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    ngd localngd = (ngd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(130);
    localngd.a(paramBundle.getString("fromId"), paramBundle.getLong("roomId"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new ataa(this, localngd, paramCommonCallback));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszx
 * JD-Core Version:    0.7.0.1
 */