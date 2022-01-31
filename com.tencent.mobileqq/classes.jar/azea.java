import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class azea
  extends AsyncTask<Void, Void, String>
{
  public azea(MediaPreviewActivity paramMediaPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        bbef.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, paramVarArgs);
        return this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131695191) + " " + paramVarArgs;
      }
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPreviewActivity", 2, QLog.getStackTraceString(paramVarArgs));
        }
        paramVarArgs = null;
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131695190);
  }
  
  protected void a(String paramString)
  {
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azea
 * JD-Core Version:    0.7.0.1
 */