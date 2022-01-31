import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class biut
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  biut(bius parambius) {}
  
  public void onInstallBegin(String paramString)
  {
    bixe.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      bixe.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bixe.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bius.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bixe.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bius.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((bius.a(this.jdField_a_of_type_Bius) != null) && (((WeakReference)bius.a(this.jdField_a_of_type_Bius).first).get() != null))
    {
      bius.a(this.jdField_a_of_type_Bius, (Context)((WeakReference)bius.a(this.jdField_a_of_type_Bius).first).get(), ((Integer)bius.a(this.jdField_a_of_type_Bius).second).intValue());
      bius.a(this.jdField_a_of_type_Bius, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biut
 * JD-Core Version:    0.7.0.1
 */