import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.QLogReporter.1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class amkg
{
  private static volatile amkg a;
  public static final SimpleDateFormat a;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy.MM.dd");
  }
  
  public static amkg a()
  {
    if (jdField_a_of_type_Amkg == null) {}
    try
    {
      if (jdField_a_of_type_Amkg == null) {
        jdField_a_of_type_Amkg = new amkg();
      }
      return jdField_a_of_type_Amkg;
    }
    finally {}
  }
  
  public void a()
  {
    if (new GregorianCalendar().get(11) < 2) {}
    SharedPreferences localSharedPreferences;
    long l1;
    Calendar localCalendar;
    String str;
    do
    {
      return;
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qlog_reporter", 0);
      l1 = System.currentTimeMillis();
      long l2 = localSharedPreferences.getLong("LastLogSizeReportTime", 0L);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l2);
      str = jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime());
      localCalendar.setTimeInMillis(l1);
    } while (str.equals(jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime())));
    ThreadManager.executeOnSubThread(new QLogReporter.1(this, localSharedPreferences, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */