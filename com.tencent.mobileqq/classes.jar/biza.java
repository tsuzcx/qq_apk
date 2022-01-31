import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class biza
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int;
  
  biza(biyz parambiyz) {}
  
  public void onInstallBegin(String paramString)
  {
    bjbl.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      bjbl.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    bjbl.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    biyz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    bjbl.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    biyz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((biyz.a(this.jdField_a_of_type_Biyz) != null) && (((WeakReference)biyz.a(this.jdField_a_of_type_Biyz).first).get() != null))
    {
      biyz.a(this.jdField_a_of_type_Biyz, (Context)((WeakReference)biyz.a(this.jdField_a_of_type_Biyz).first).get(), ((Integer)biyz.a(this.jdField_a_of_type_Biyz).second).intValue());
      biyz.a(this.jdField_a_of_type_Biyz, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biza
 * JD-Core Version:    0.7.0.1
 */