import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class bmed
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  bmed(bmec parambmec) {}
  
  public void onInstallBegin(String paramString)
  {
    bmgm.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      bmgm.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bmgm.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bmec.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bmgm.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bmec.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((bmec.a(this.jdField_a_of_type_Bmec) != null) && (((WeakReference)bmec.a(this.jdField_a_of_type_Bmec).first).get() != null))
    {
      bmec.a(this.jdField_a_of_type_Bmec, (Context)((WeakReference)bmec.a(this.jdField_a_of_type_Bmec).first).get(), ((Integer)bmec.a(this.jdField_a_of_type_Bmec).second).intValue());
      bmec.a(this.jdField_a_of_type_Bmec, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmed
 * JD-Core Version:    0.7.0.1
 */