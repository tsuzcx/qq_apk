import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.TextUtils;

public class bfpv
  extends AsyncTask<Void, Long, Boolean>
{
  Activity jdField_a_of_type_AndroidAppActivity;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  String jdField_a_of_type_JavaLangString;
  
  public bfpv(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bfpv(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(false);
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    a();
    if (paramBoolean.booleanValue())
    {
      if ((bfpu.a()) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        bfmy.a("311", this.jdField_a_of_type_JavaLangString, "1101070898");
      }
      return;
    }
    bflz.a().a(alud.a(2131717428), 1);
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpv
 * JD-Core Version:    0.7.0.1
 */