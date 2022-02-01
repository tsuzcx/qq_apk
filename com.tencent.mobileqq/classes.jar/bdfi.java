import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class bdfi
  extends beip
{
  private boolean jdField_a_of_type_Boolean;
  
  public bdfi(bdfe parambdfe) {}
  
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
          this.jdField_a_of_type_Bdfe.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Bdfe.jdField_a_of_type_Boolean), Integer.valueOf(6) });
          bool1 = this.jdField_a_of_type_Bdfe.a(false, "211", bdfk.b(), true, bdfk.a(bdfk.c()));
          if (!bool1) {
            bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.a(this.jdField_a_of_type_Bdfe), -2147483648, bdfe.b(this.jdField_a_of_type_Bdfe), -2147483648, null, -2147483648);
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
        bdfe localbdfe = (bdfe)this.jdField_a_of_type_Bdfe.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        if (bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.a(this.jdField_a_of_type_Bdfe)) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramInt = bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.b(this.jdField_a_of_type_Bdfe));
          if (bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.c(this.jdField_a_of_type_Bdfe)) == 1) {
            bool2 = true;
          }
          try
          {
            long l = localbdfe.a(bool1, paramInt, this.jdField_a_of_type_Bdfe.jdField_a_of_type_Boolean, bool2);
            bdfe.a(this.jdField_a_of_type_Bdfe).set(l);
            return true;
          }
          catch (Exception localException)
          {
            return true;
          }
        }
      }
    }
    bdfe.a(this.jdField_a_of_type_Bdfe, bdfe.a(this.jdField_a_of_type_Bdfe), -2147483648, bdfe.b(this.jdField_a_of_type_Bdfe), -2147483648, bdfe.c(this.jdField_a_of_type_Bdfe), -2147483648);
    this.jdField_a_of_type_Bdfe.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Bdfe.jdField_a_of_type_Boolean), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfi
 * JD-Core Version:    0.7.0.1
 */