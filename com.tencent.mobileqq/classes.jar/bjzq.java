import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class bjzq
  implements IActivityResultListener
{
  bjzq(bjzk parambjzk, File paramFile, IActivityResultManager paramIActivityResultManager, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.jdField_a_of_type_JavaIoFile.deleteOnExit();
      bjzk.a(this.jdField_a_of_type_Bjzk, bjzk.a(this.jdField_a_of_type_Bjzk), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    bjzk.a(this.jdField_a_of_type_Bjzk, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzq
 * JD-Core Version:    0.7.0.1
 */