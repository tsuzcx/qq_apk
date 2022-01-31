import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;

class bgrz
  implements bgrw
{
  bgrz(bgrx parambgrx, EngineChannel paramEngineChannel, BaseLibInfo paramBaseLibInfo) {}
  
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
    bgrt localbgrt = (bgrt)bgrx.b(this.jdField_a_of_type_Bgrx).get(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType);
    if (localbgrt != null) {
      localbgrt.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrz
 * JD-Core Version:    0.7.0.1
 */