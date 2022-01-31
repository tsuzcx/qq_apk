import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class amle
  implements Runnable
{
  public amle(QZoneDNSAnalyzeJsPlugin paramQZoneDNSAnalyzeJsPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    try
    {
      String str = InetAddress.getByName(this.jdField_a_of_type_JavaLangString).getHostAddress();
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "Analyze " + this.jdField_a_of_type_JavaLangString + " ip address : " + str);
        localObject = str;
        QZoneDNSAnalyzeJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneDNSAnalyzeJsPlugin, this.b, 0, str);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "UnknownHostException:Analyze " + this.jdField_a_of_type_JavaLangString + " ip address failed");
      QZoneDNSAnalyzeJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneDNSAnalyzeJsPlugin, this.b, -1, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amle
 * JD-Core Version:    0.7.0.1
 */