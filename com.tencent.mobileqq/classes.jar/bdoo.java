import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;

class bdoo
  implements bdol
{
  bdoo(bdom parambdom, EngineChannel paramEngineChannel, BaseLibInfo paramBaseLibInfo) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(54, null);
  }
  
  public void a(float paramFloat, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("engineInstallerProgress", paramFloat);
    localBundle.putString("engineInstallerMessage", paramString);
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(53, localBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(52, null);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(54, null);
    bdoi localbdoi = (bdoi)bdom.b(this.jdField_a_of_type_Bdom).get(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType);
    if (localbdoi != null) {
      localbdoi.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoo
 * JD-Core Version:    0.7.0.1
 */