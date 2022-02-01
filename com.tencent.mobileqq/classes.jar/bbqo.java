import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;

final class bbqo
  extends AsyncTask<Void, Void, Boolean>
{
  bbqo(File paramFile1, File paramFile2, Activity paramActivity, bbqp parambbqp) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      if (fd.a(this.jdField_a_of_type_JavaIoFile, this.b))
      {
        bheg.a(BaseApplicationImpl.getApplication(), this.b);
        bheg.a(this.jdField_a_of_type_AndroidAppActivity, this.b.getAbsolutePath());
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
      for (String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694665);; str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694684))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, 0).b(i);
        if (this.jdField_a_of_type_Bbqp != null) {
          this.jdField_a_of_type_Bbqp.a(paramBoolean.booleanValue());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqo
 * JD-Core Version:    0.7.0.1
 */