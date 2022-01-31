import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class anjk
  implements Runnable
{
  public anjk(QZoneDNSAnalyzeJsPlugin paramQZoneDNSAnalyzeJsPlugin, int paramInt) {}
  
  public void run()
  {
    int i = HttpUtil.a();
    if ((i != 0) && (i != -1)) {
      try
      {
        String str = InetAddress.getByName("h5.qzone.qq.com").getHostAddress();
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.jdField_a_of_type_Int + ", Analyze h5.qzone.qq.com ip address : " + str);
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localUnknownHostException.printStackTrace();
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.jdField_a_of_type_Int + ", UnknownHostException:Analyze  h5.qzone.qq.com  ip address failed");
        return;
      }
    }
    QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.jdField_a_of_type_Int + ", No ActiveNetwork, Analyze  h5.qzone.qq.com  ip address failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjk
 * JD-Core Version:    0.7.0.1
 */