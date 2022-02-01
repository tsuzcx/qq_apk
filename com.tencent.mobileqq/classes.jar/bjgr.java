import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class bjgr
  implements IActivityResultListener
{
  bjgr(bjgl parambjgl, File paramFile, IActivityResultManager paramIActivityResultManager, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.jdField_a_of_type_JavaIoFile.deleteOnExit();
      bjgl.a(this.jdField_a_of_type_Bjgl, bjgl.a(this.jdField_a_of_type_Bjgl), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    bjgl.a(this.jdField_a_of_type_Bjgl, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgr
 * JD-Core Version:    0.7.0.1
 */