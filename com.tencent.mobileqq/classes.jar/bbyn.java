import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class bbyn
  extends bdbp
{
  private boolean jdField_a_of_type_Boolean;
  
  public bbyn(bbyj parambbyj) {}
  
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
          this.jdField_a_of_type_Bbyj.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Bbyj.jdField_a_of_type_Boolean), Integer.valueOf(6) });
          bool1 = this.jdField_a_of_type_Bbyj.a(false, "211", bbyp.b(), true, bbyp.a(bbyp.c()));
          if (!bool1) {
            bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.a(this.jdField_a_of_type_Bbyj), -2147483648, bbyj.b(this.jdField_a_of_type_Bbyj), -2147483648, null, -2147483648);
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
        bbyj localbbyj = (bbyj)this.jdField_a_of_type_Bbyj.app.getBusinessHandler(154);
        if (bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.a(this.jdField_a_of_type_Bbyj)) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramInt = bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.b(this.jdField_a_of_type_Bbyj));
          if (bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.c(this.jdField_a_of_type_Bbyj)) == 1) {
            bool2 = true;
          }
          try
          {
            long l = localbbyj.a(bool1, paramInt, this.jdField_a_of_type_Bbyj.jdField_a_of_type_Boolean, bool2);
            bbyj.a(this.jdField_a_of_type_Bbyj).set(l);
            return true;
          }
          catch (Exception localException)
          {
            return true;
          }
        }
      }
    }
    bbyj.a(this.jdField_a_of_type_Bbyj, bbyj.a(this.jdField_a_of_type_Bbyj), -2147483648, bbyj.b(this.jdField_a_of_type_Bbyj), -2147483648, bbyj.c(this.jdField_a_of_type_Bbyj), -2147483648);
    this.jdField_a_of_type_Bbyj.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Bbyj.jdField_a_of_type_Boolean), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyn
 * JD-Core Version:    0.7.0.1
 */