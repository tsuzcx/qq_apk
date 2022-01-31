import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;

class bgtu
  extends OnPluginInstallListener.Stub
{
  bgtu(bgtt parambgtt, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onInstallBegin(String paramString)
  {
    bgwf.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    bgwf.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bgwf.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bgtt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bgwf.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bgtt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    bgtt.a(this.jdField_a_of_type_Bgtt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtu
 * JD-Core Version:    0.7.0.1
 */