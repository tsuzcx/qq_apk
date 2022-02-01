import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class blnl
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  blnl(blnk paramblnk) {}
  
  public void onInstallBegin(String paramString)
  {
    blpu.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      blpu.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    blpu.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    blnk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    blpu.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    blnk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((blnk.a(this.jdField_a_of_type_Blnk) != null) && (((WeakReference)blnk.a(this.jdField_a_of_type_Blnk).first).get() != null))
    {
      blnk.a(this.jdField_a_of_type_Blnk, (Context)((WeakReference)blnk.a(this.jdField_a_of_type_Blnk).first).get(), ((Integer)blnk.a(this.jdField_a_of_type_Blnk).second).intValue());
      blnk.a(this.jdField_a_of_type_Blnk, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnl
 * JD-Core Version:    0.7.0.1
 */