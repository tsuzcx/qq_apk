import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class aoem
{
  public static int a;
  private static aoem jdField_a_of_type_Aoem;
  public static int b;
  public static int c = 2;
  public static int d = 3;
  public static int e = -1;
  public static int f = 1;
  public static int g = 2;
  public static int h = 3;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private int i = -1;
  private int j = -1;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = 1;
  }
  
  public static aoem a()
  {
    if (jdField_a_of_type_Aoem == null) {
      jdField_a_of_type_Aoem = new aoem();
    }
    return jdField_a_of_type_Aoem;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockPhoneStatus", 2, "pre:" + this.i + " now:" + paramInt);
    }
    this.i = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    aoen localaoen = new aoen(this);
    String str2 = paramContext.getString(2131692152);
    String str1 = paramContext.getString(2131692139);
    long l = this.jdField_a_of_type_Long * 1000L;
    if (l > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l);
    }
    for (Object localObject = String.format(paramContext.getString(2131692150), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });; localObject = paramContext.getString(2131692151))
    {
      paramContext = bbdj.a(paramContext, 230, str2, String.format(paramContext.getString(2131692149), new Object[] { paramString, localObject }), null, localaoen);
      if (paramContext != null)
      {
        paramContext.setNegativeButton(str1, localaoen);
        paramContext.show();
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.i = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = 0L;
    this.j = e;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "info is null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        devlock_mobile_phone.status localstatus = new devlock_mobile_phone.status();
        localstatus.mergeFrom(paramArrayOfByte);
        if (localstatus.u32_mb_mobile_state.has()) {
          this.i = localstatus.u32_mb_mobile_state.get();
        }
        if (localstatus.u32_audit_time.has()) {
          this.jdField_a_of_type_Long = localstatus.u32_audit_time.get();
        }
        if (localstatus.u32_bak_mobile_state.has()) {
          this.j = localstatus.u32_bak_mobile_state.get();
        }
        if (localstatus.str_bak_country_code.has()) {
          this.jdField_a_of_type_JavaLangString = localstatus.str_bak_country_code.get();
        }
        if (localstatus.str_bak_mobile.has())
        {
          this.jdField_b_of_type_JavaLangString = localstatus.str_bak_mobile.get();
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockPhoneStatus", 2, "exception occurs");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoem
 * JD-Core Version:    0.7.0.1
 */