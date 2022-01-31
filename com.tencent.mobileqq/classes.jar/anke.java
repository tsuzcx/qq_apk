import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anke
  implements View.OnClickListener
{
  public anke(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db"), new File(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getExternalCacheDir(), this.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + ".db"));
    QLog.e(DBFixConfigActivity.jdField_a_of_type_JavaLangString, 2, "copy " + bool + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anke
 * JD-Core Version:    0.7.0.1
 */