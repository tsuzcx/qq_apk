import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.manager.EngineManager.2;

public class bgwf
  implements bgwd
{
  public bgwf(EngineManager.2 param2) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(54, null);
    bgwa localbgwa = (bgwa)bgwe.b(this.a.this$0).get(this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType);
    if (localbgwa != null) {
      localbgwa.b(this);
    }
  }
  
  public void a(float paramFloat, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("engineInstallerProgress", paramFloat);
    localBundle.putString("engineInstallerMessage", paramString);
    this.a.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(53, localBundle);
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(52, null);
  }
  
  public void c()
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel.a(54, null);
    bgwa localbgwa = (bgwa)bgwe.b(this.a.this$0).get(this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType);
    if (localbgwa != null) {
      localbgwa.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwf
 * JD-Core Version:    0.7.0.1
 */