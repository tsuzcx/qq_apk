import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class bksc
  implements IActivityResultListener
{
  bksc(bkrw parambkrw, File paramFile, IActivityResultManager paramIActivityResultManager, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.jdField_a_of_type_JavaIoFile.deleteOnExit();
      bkrw.a(this.jdField_a_of_type_Bkrw, bkrw.a(this.jdField_a_of_type_Bkrw), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    bkrw.a(this.jdField_a_of_type_Bkrw, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksc
 * JD-Core Version:    0.7.0.1
 */