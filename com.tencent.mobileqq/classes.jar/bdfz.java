import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class bdfz
  extends beit
{
  private boolean jdField_a_of_type_Boolean;
  
  public bdfz(bdfv parambdfv) {}
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramInt = 3;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if (!AppNetConnInfo.isNetSupport())
        {
          this.jdField_a_of_type_Bdfv.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Bdfv.jdField_a_of_type_Boolean), Integer.valueOf(6) });
          bool1 = this.jdField_a_of_type_Bdfv.a(false, "211", bdgb.b(), true, bdgb.a(bdgb.c()));
          if (!bool1) {
            bdfv.a(this.jdField_a_of_type_Bdfv, bdfv.a(this.jdField_a_of_type_Bdfv), -2147483648, bdfv.b(this.jdField_a_of_type_Bdfv), -2147483648, null, -2147483648);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool1) }));
          return true;
          paramInt = 0;
          continue;
          paramInt = 3;
          continue;
          paramInt = 1;
          continue;
        }
        bdfv localbdfv = (bdfv)this.jdField_a_of_type_Bdfv.app.a(154);
        if (bdfv.a(this.jdField_a_of_type_Bdfv, bdfv.a(this.jdField_a_of_type_Bdfv)) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramInt = bdfv.a(this.jdField_a_of_type_Bdfv, bdfv.b(this.jdField_a_of_type_Bdfv));
          if (bdfv.a(this.jdField_a_of_type_Bdfv, bdfv.c(this.jdField_a_of_type_Bdfv)) == 1) {
            bool2 = true;
          }
          try
          {
            long l = localbdfv.a(bool1, paramInt, this.jdField_a_of_type_Bdfv.jdField_a_of_type_Boolean, bool2);
            bdfv.a(this.jdField_a_of_type_Bdfv).set(l);
            return true;
          }
          catch (Exception localException)
          {
            return true;
          }
        }
      }
    }
    bdfv.a(this.jdField_a_of_type_Bdfv, bdfv.a(this.jdField_a_of_type_Bdfv), -2147483648, bdfv.b(this.jdField_a_of_type_Bdfv), -2147483648, bdfv.c(this.jdField_a_of_type_Bdfv), -2147483648);
    this.jdField_a_of_type_Bdfv.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Bdfv.jdField_a_of_type_Boolean), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfz
 * JD-Core Version:    0.7.0.1
 */