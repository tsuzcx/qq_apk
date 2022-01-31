import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apbq
  implements View.OnClickListener
{
  public apbq(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool = bdcs.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db"), new File(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getExternalCacheDir(), this.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + ".db"));
    QLog.e(DBFixConfigActivity.jdField_a_of_type_JavaLangString, 2, "copy " + bool + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbq
 * JD-Core Version:    0.7.0.1
 */