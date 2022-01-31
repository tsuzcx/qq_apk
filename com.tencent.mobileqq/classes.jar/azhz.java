import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

class azhz
  extends bakk
{
  azhz(azhx paramazhx) {}
  
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
        bool1 = azhx.a(this.a, false, "211", azib.b(), true, azhw.b[azib.c()]);
        if (!bool1) {
          azhx.a(this.a, azhx.a(this.a), -2147483648, azhx.b(this.a), -2147483648, null, -2147483648);
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
        azhx localazhx = (azhx)this.a.app.a(154);
        if (azhx.a(this.a, azhx.a(this.a)) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramInt = azhx.a(this.a, azhx.b(this.a));
          if (azhx.a(this.a, azhx.c(this.a)) == 1) {
            bool2 = true;
          }
          long l = localazhx.a(bool1, paramInt, this.a.a, bool2);
          azhx.a(this.a).set(l);
          return true;
        }
      }
    }
    azhx.a(this.a, azhx.a(this.a), -2147483648, azhx.b(this.a), -2147483648, azhx.c(this.a), -2147483648);
    this.a.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.a.a), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhz
 * JD-Core Version:    0.7.0.1
 */