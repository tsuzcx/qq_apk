import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class bksu
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  bksu(bkst parambkst) {}
  
  public void onInstallBegin(String paramString)
  {
    bkvd.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      bkvd.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bkvd.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bkst.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bkvd.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bkst.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((bkst.a(this.jdField_a_of_type_Bkst) != null) && (((WeakReference)bkst.a(this.jdField_a_of_type_Bkst).first).get() != null))
    {
      bkst.a(this.jdField_a_of_type_Bkst, (Context)((WeakReference)bkst.a(this.jdField_a_of_type_Bkst).first).get(), ((Integer)bkst.a(this.jdField_a_of_type_Bkst).second).intValue());
      bkst.a(this.jdField_a_of_type_Bkst, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksu
 * JD-Core Version:    0.7.0.1
 */