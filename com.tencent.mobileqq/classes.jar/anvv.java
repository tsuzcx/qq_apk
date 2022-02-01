import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class anvv
  implements Printer
{
  public static int a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  
  static
  {
    jdField_a_of_type_Int = 200;
  }
  
  anvv(int paramInt, String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {
      return null;
    }
    int i = paramString.indexOf('(');
    if (i == -1) {
      return null;
    }
    int j = paramString.indexOf(')', i);
    if (j == -1) {
      return null;
    }
    String str1 = paramString.substring(i + 1, j);
    int k = paramString.indexOf("} ", j);
    if (k == -1) {
      return null;
    }
    j = paramString.indexOf('@', k + 2);
    i = j;
    if (j == -1)
    {
      j = paramString.indexOf(':', k + 2);
      i = j;
      if (j == -1)
      {
        i = paramString.indexOf(' ', k + 2);
        if (i == -1) {
          break label150;
        }
      }
    }
    String str2 = paramString.substring(k + 2, i);
    i = paramString.indexOf(": ", i);
    if (i == -1)
    {
      return null;
      label150:
      return null;
    }
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global.LooperPrinter", 2, "setting threshold, threshold=" + paramInt);
    }
    jdField_a_of_type_Int = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.jdField_c_of_type_Int);
      }
    }
    while ((this.jdField_c_of_type_Long == 0L) || (!paramString.startsWith("<<"))) {
      return;
    }
    this.jdField_a_of_type_Long += 1L;
    long l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long += l;
    Object localObject = null;
    paramString = (String)localObject;
    if (QLog.isColorLevel())
    {
      if (!ThreadSetting.logcatBgTaskMonitor) {
        break label192;
      }
      paramString = a(this.jdField_a_of_type_JavaLangString);
      QLog.d("AutoMonitor", 2, this.jdField_b_of_type_JavaLangString + ", cost=" + l + ", " + paramString);
    }
    while (l > jdField_a_of_type_Int) {
      if (!UnifiedMonitor.a().whetherReportThisTime(this.jdField_c_of_type_Int))
      {
        this.jdField_b_of_type_Int = 0;
        return;
        label192:
        paramString = (String)localObject;
        if (l >= 200L)
        {
          paramString = a(this.jdField_a_of_type_JavaLangString);
          QLog.e("AutoMonitor", 2, this.jdField_b_of_type_JavaLangString + " OOT cost=" + l + ", " + paramString);
        }
      }
      else
      {
        HashMap localHashMap;
        if (paramString == null)
        {
          paramString = a(this.jdField_a_of_type_JavaLangString);
          localHashMap = new HashMap(8);
          localObject = BaseActivity.sTopActivity;
          if (localObject == null) {
            break label338;
          }
        }
        label338:
        for (localObject = localObject.getClass().getName();; localObject = "")
        {
          localHashMap.put("act", localObject);
          UnifiedMonitor.a().addEvent(this.jdField_c_of_type_Int, paramString, (int)l, this.jdField_b_of_type_Int, localHashMap);
          this.jdField_b_of_type_Int = 0;
          return;
          break;
        }
      }
    }
    if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
      UnifiedMonitor.a().notifyNotTimeout(this.jdField_c_of_type_Int);
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.jdField_a_of_type_Long + ", totalCost = " + this.jdField_b_of_type_Long + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */