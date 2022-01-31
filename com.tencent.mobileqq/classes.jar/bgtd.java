import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;

class bgtd
  extends OnPluginInstallListener.Stub
{
  bgtd(bgtc parambgtc, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onInstallBegin(String paramString)
  {
    bgvo.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    bgvo.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bgvo.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bgtc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bgvo.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bgtc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    bgtc.a(this.jdField_a_of_type_Bgtc, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtd
 * JD-Core Version:    0.7.0.1
 */