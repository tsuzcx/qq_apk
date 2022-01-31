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

public class arjj
{
  private static volatile arjj jdField_a_of_type_Arjj;
  private arhw jdField_a_of_type_Arhw;
  public arib a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public static arjj a()
  {
    if (jdField_a_of_type_Arjj == null) {}
    try
    {
      if (jdField_a_of_type_Arjj == null) {
        jdField_a_of_type_Arjj = new arjj();
      }
      return jdField_a_of_type_Arjj;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Arjj != null) {
      jdField_a_of_type_Arjj.b();
    }
  }
  
  public arib a()
  {
    return this.jdField_a_of_type_Arib;
  }
  
  public String a(String paramString)
  {
    return ayxg.a().a(paramString, 1017);
  }
  
  public Future<Bundle> a(String paramString1, String paramString2)
  {
    return akhk.a(128).submit(new arjp(this, paramString2, paramString1));
  }
  
  public Future<Bundle> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return akhk.a(128).submit(new arjn(this, paramString1, paramString2, paramString3, paramString4));
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
      this.jdField_a_of_type_Arhw = arhw.jdField_a_of_type_Arhw;
      this.jdField_a_of_type_Arhw.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Arhw.a(str, new arjl(this, paramDownloadCallback, str));
      this.jdField_a_of_type_Arhw.a(arhy.a(str, "com.tencent.now", paramBundle));
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
    ((arjs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(145)).a(str1, str2, paramBundle, paramCommonCallback);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_Arib == null) {
      this.jdField_a_of_type_Arib = new arib(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    NowLive.setCustomizedTicket(new arjk(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    jdField_a_of_type_Arjj = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Arib = null;
    if (this.jdField_a_of_type_Arhw != null)
    {
      this.jdField_a_of_type_Arhw.a();
      this.jdField_a_of_type_Arhw = null;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void b(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    ndh localndh = (ndh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(130);
    localndh.a(paramBundle.getString("fromId"), paramBundle.getLong("roomId"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new arjm(this, localndh, paramCommonCallback));
  }
  
  public void c(Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arjj
 * JD-Core Version:    0.7.0.1
 */