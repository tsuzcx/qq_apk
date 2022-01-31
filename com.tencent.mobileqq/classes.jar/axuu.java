import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;

final class axuu
  extends AsyncTask<Void, Void, Boolean>
{
  axuu(File paramFile1, File paramFile2, Activity paramActivity, axuv paramaxuv) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      if (ey.a(this.jdField_a_of_type_JavaIoFile, this.b))
      {
        bdda.a(BaseApplicationImpl.getApplication(), this.b);
        bdda.a(this.jdField_a_of_type_AndroidAppActivity, this.b.getAbsolutePath());
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryUtils", 4, "savePhoto exception = " + paramVarArgs.getMessage());
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();; i = 0)
    {
      if (paramBoolean.booleanValue()) {}
      for (String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131695322);; str = this.jdField_a_of_type_AndroidAppActivity.getString(2131695348))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, 0).b(i);
        if (this.jdField_a_of_type_Axuv != null) {
          this.jdField_a_of_type_Axuv.a(paramBoolean.booleanValue());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuu
 * JD-Core Version:    0.7.0.1
 */