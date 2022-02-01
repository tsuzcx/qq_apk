import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class bmon
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  bmon(bmom parambmom) {}
  
  public void onInstallBegin(String paramString)
  {
    bmqw.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      bmqw.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bmqw.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    bmom.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bmqw.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    bmom.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((bmom.a(this.jdField_a_of_type_Bmom) != null) && (((WeakReference)bmom.a(this.jdField_a_of_type_Bmom).first).get() != null))
    {
      bmom.a(this.jdField_a_of_type_Bmom, (Context)((WeakReference)bmom.a(this.jdField_a_of_type_Bmom).first).get(), ((Integer)bmom.a(this.jdField_a_of_type_Bmom).second).intValue());
      bmom.a(this.jdField_a_of_type_Bmom, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmon
 * JD-Core Version:    0.7.0.1
 */