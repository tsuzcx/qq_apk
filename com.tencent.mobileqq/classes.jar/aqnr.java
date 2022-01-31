import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import java.io.File;

final class aqnr
  extends AsyncTask<Void, Void, Boolean>
{
  aqnr(File paramFile1, File paramFile2, Activity paramActivity, aqns paramaqns) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      if (gp.a(this.jdField_a_of_type_JavaIoFile, this.b))
      {
        bbdr.a(BaseApplicationImpl.getApplication(), this.b);
        bbdr.a(this.jdField_a_of_type_AndroidAppActivity, this.b.getAbsolutePath());
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      aqmb.a().a().a("AIOGalleryUtils", 4, "savePhoto exception = " + paramVarArgs.getMessage());
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();; i = 0)
    {
      if (paramBoolean.booleanValue()) {}
      for (String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131695163);; str = this.jdField_a_of_type_AndroidAppActivity.getString(2131695189))
      {
        bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, 0).b(i);
        if (this.jdField_a_of_type_Aqns != null) {
          this.jdField_a_of_type_Aqns.a(paramBoolean.booleanValue());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnr
 * JD-Core Version:    0.7.0.1
 */