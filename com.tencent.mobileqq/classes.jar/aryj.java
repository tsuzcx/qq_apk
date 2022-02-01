import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class aryj
  implements View.OnClickListener
{
  public aryj(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool = bhmi.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db"), new File(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getExternalCacheDir(), this.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + ".db"));
    QLog.e(DBFixConfigActivity.jdField_a_of_type_JavaLangString, 2, "copy " + bool + this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryj
 * JD-Core Version:    0.7.0.1
 */