import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class aslf
{
  public static int a;
  private static aslf jdField_a_of_type_Aslf;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  private long jdField_a_of_type_Long;
  private int e = -1;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static aslf a()
  {
    if (jdField_a_of_type_Aslf == null) {
      jdField_a_of_type_Aslf = new aslf();
    }
    return jdField_a_of_type_Aslf;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockPhoneStatus", 2, "pre:" + this.e + " now:" + paramInt);
    }
    this.e = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    aslg localaslg = new aslg(this);
    String str2 = paramContext.getString(2131691983);
    String str1 = paramContext.getString(2131691969);
    long l = this.jdField_a_of_type_Long * 1000L;
    if (l > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l);
    }
    for (Object localObject = String.format(paramContext.getString(2131691981), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });; localObject = paramContext.getString(2131691982))
    {
      paramContext = bhdj.a(paramContext, 230, str2, String.format(paramContext.getString(2131691980), new Object[] { paramString, localObject }), null, localaslg);
      if (paramContext != null)
      {
        paramContext.setNegativeButton(str1, localaslg);
        paramContext.show();
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = 0L;
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
          this.e = localstatus.u32_mb_mobile_state.get();
        }
        if (localstatus.u32_audit_time.has())
        {
          this.jdField_a_of_type_Long = localstatus.u32_audit_time.get();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslf
 * JD-Core Version:    0.7.0.1
 */