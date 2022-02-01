import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public class aunx
{
  private static aunx jdField_a_of_type_Aunx;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.qflutterCfg.name();
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private aunx()
  {
    DeviceProfileManager.a(new auny(this));
    a();
  }
  
  public static aunx a()
  {
    if (jdField_a_of_type_Aunx == null) {}
    try
    {
      if (jdField_a_of_type_Aunx == null) {
        jdField_a_of_type_Aunx = new aunx();
      }
      return jdField_a_of_type_Aunx;
    }
    finally {}
  }
  
  public void a()
  {
    String str = DeviceProfileManager.b().a(jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 3) {}
      try
      {
        if (Integer.valueOf(arrayOfString[0]).intValue() == 1)
        {
          this.jdField_a_of_type_Boolean = true;
          if (jdField_a_of_type_JavaUtilRandom.nextFloat() >= Float.valueOf(arrayOfString[1]).floatValue()) {
            break label196;
          }
          this.b = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("QFlutterDPC", 1, "loadConfig exception :" + localException.getMessage());
          this.b = true;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Int = 0;
          continue;
          label196:
          this.b = false;
        }
      }
    }
    for (this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[2]).intValue();; this.jdField_a_of_type_Int = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutterDPC", 2, String.format("loadConfig, dpcValue: %s, mIsSupport: %s, mNeedReport: %s, mVoteRankingFlutterThreashold=%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      this.b = true;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(str).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label26:
      int i;
      break label26;
    }
    i = (int)(l1 % 10L);
    QLog.d("QFlutterDPC", 1, String.format("isVoteRankingFlutterOpen lastNum=%d threashold=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
    return (this.jdField_a_of_type_Boolean) && (i < this.jdField_a_of_type_Int);
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunx
 * JD-Core Version:    0.7.0.1
 */