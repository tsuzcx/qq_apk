import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.NeonControl.1;
import com.tencent.mobileqq.ar.NeonControl.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aphc
{
  private static aphc jdField_a_of_type_Aphc;
  public static boolean a;
  aphd jdField_a_of_type_Aphd;
  public final Object a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private aphc()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
    if (!((SharedPreferences)localObject1).contains("sp_cpu_neon_support")) {
      ThreadManager.post(new NeonControl.1(this, (SharedPreferences)localObject1, false), 5, null, true);
    }
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("sp_cpu_neon_support", false);
    boolean bool3 = aphn.a().e;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (bool3)
      {
        i = 1;
        if (!bool2) {
          break label174;
        }
        j = 1;
        label97:
        QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0) }));
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_JavaLangObject;
      if ((!bool3) || (!bool2)) {
        break label179;
      }
    }
    for (;;)
    {
      try
      {
        this.b = bool1;
        return;
      }
      finally {}
      i = 0;
      break;
      label174:
      j = 0;
      break label97;
      label179:
      bool1 = false;
    }
  }
  
  public static aphc a()
  {
    if (jdField_a_of_type_Aphc == null) {
      jdField_a_of_type_Aphc = new aphc();
    }
    return jdField_a_of_type_Aphc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aphd == null) {}
    aphd localaphd;
    int i;
    do
    {
      do
      {
        return;
        localaphd = new aphd(this);
        localaphd.jdField_a_of_type_Long = this.jdField_a_of_type_Aphd.jdField_a_of_type_Long;
        localaphd.jdField_a_of_type_Int = this.jdField_a_of_type_Aphd.jdField_a_of_type_Int;
        localaphd.b = this.jdField_a_of_type_Aphd.b;
        this.jdField_a_of_type_Aphd.b = -2147483648;
        this.jdField_a_of_type_Aphd.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Aphd.jdField_a_of_type_Int = 0;
      } while ((localaphd.jdField_a_of_type_Long <= 0L) || (localaphd.jdField_a_of_type_Int <= 0) || (localaphd.b == -2147483648));
      i = (int)(localaphd.jdField_a_of_type_Long / localaphd.jdField_a_of_type_Int);
    } while ((i < 0) || (i >= 600000));
    ThreadManager.post(new NeonControl.2(this, localaphd, i), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Aphd == null)
    {
      this.jdField_a_of_type_Aphd = new aphd(this);
      this.jdField_a_of_type_Aphd.b = paramInt;
    }
    if (this.jdField_a_of_type_Aphd.b != paramInt)
    {
      if ((this.jdField_a_of_type_Aphd.jdField_a_of_type_Long > 0L) || (this.jdField_a_of_type_Aphd.jdField_a_of_type_Int > 0)) {
        a();
      }
      this.jdField_a_of_type_Aphd.b = paramInt;
      this.jdField_a_of_type_Aphd.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Aphd.jdField_a_of_type_Int = 0;
    }
    aphd localaphd = this.jdField_a_of_type_Aphd;
    localaphd.jdField_a_of_type_Long += paramLong;
    localaphd = this.jdField_a_of_type_Aphd;
    localaphd.jdField_a_of_type_Int += 1;
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.b;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphc
 * JD-Core Version:    0.7.0.1
 */