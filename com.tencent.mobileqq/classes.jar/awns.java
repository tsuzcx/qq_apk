import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class awns
  extends axmg
{
  awns(awnq paramawnq) {}
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    default: 
      paramInt = 3;
    }
    while (paramInt == 0) {
      if (!AppNetConnInfo.isNetSupport())
      {
        this.a.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.a.a), Integer.valueOf(6) });
        bool = awnq.a(this.a, false, "211", awnu.b(), false, awnp.b[awnu.c()]);
        if (!bool)
        {
          awnq.a(this.a).set(-2147483648);
          awnq.b(this.a).set(-2147483648);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool) }));
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
        awnq localawnq = (awnq)this.a.app.a(154);
        if (awnq.a(this.a).get() == 1) {
          bool = true;
        }
        long l = localawnq.a(bool, awnq.b(this.a).get(), this.a.a);
        awnq.a(this.a).set(l);
        return true;
      }
    }
    awnq.a(this.a).set(-2147483648);
    awnq.b(this.a).set(-2147483648);
    this.a.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.a.a), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awns
 * JD-Core Version:    0.7.0.1
 */