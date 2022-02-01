import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class blau
  implements IActivityResultListener
{
  blau(blao paramblao, File paramFile, IActivityResultManager paramIActivityResultManager, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.jdField_a_of_type_JavaIoFile.deleteOnExit();
      blao.a(this.jdField_a_of_type_Blao, blao.a(this.jdField_a_of_type_Blao), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    blao.a(this.jdField_a_of_type_Blao, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blau
 * JD-Core Version:    0.7.0.1
 */