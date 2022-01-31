import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

class azmi
  extends baot
{
  azmi(azmg paramazmg) {}
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    default: 
      paramInt = 3;
    }
    while (paramInt == 0)
    {
      boolean bool1;
      if (!AppNetConnInfo.isNetSupport())
      {
        this.a.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.a.a), Integer.valueOf(6) });
        bool1 = azmg.a(this.a, false, "211", azmk.b(), true, azmf.b[azmk.c()]);
        if (!bool1) {
          azmg.a(this.a, azmg.a(this.a), -2147483648, azmg.b(this.a), -2147483648, null, -2147483648);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool1) }));
        }
        return true;
        paramInt = 0;
        continue;
        paramInt = 3;
        continue;
        paramInt = 1;
      }
      else
      {
        azmg localazmg = (azmg)this.a.app.a(154);
        if (azmg.a(this.a, azmg.a(this.a)) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramInt = azmg.a(this.a, azmg.b(this.a));
          if (azmg.a(this.a, azmg.c(this.a)) == 1) {
            bool2 = true;
          }
          long l = localazmg.a(bool1, paramInt, this.a.a, bool2);
          azmg.a(this.a).set(l);
          return true;
        }
      }
    }
    azmg.a(this.a, azmg.a(this.a), -2147483648, azmg.b(this.a), -2147483648, azmg.c(this.a), -2147483648);
    this.a.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.a.a), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmi
 * JD-Core Version:    0.7.0.1
 */