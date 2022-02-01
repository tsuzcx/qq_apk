import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class bcqr
  extends anbq
{
  bcqr(bcqq parambcqq) {}
  
  protected void a(boolean paramBoolean, bcqu parambcqu)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (parambcqu == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!bcqq.a(this.a).isReleased) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = parambcqu.c;
      break;
      label73:
      if ((!bcqq.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(bcqq.a(this.a), 100L);
      }
      if (parambcqu != null)
      {
        if (parambcqu.a()) {
          bcqk.a(bcqq.a(this.a), parambcqu.a(), 2);
        }
        if (parambcqu.b())
        {
          ??? = parambcqu.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              bcqk.c(bcqq.a(this.a), (String)localObject2);
            }
          }
        }
        parambcqu.a();
      }
      synchronized (bcqq.c())
      {
        bcqq.c(this.a, false);
        bcqq.d(this.a, true);
        if ((parambcqu == null) || (!parambcqu.b)) {
          continue;
        }
        bcqk.a(bcqq.a(this.a), parambcqu.c, false);
        ??? = (aqcz)apub.a().a(607);
        if ((??? == null) || (((aqcz)???).a)) {
          continue;
        }
        bcqs.a(bcqq.a(this.a), parambcqu.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, bcqu arg2)
  {
    synchronized ()
    {
      bcqq.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, bcqu arg2)
  {
    synchronized ()
    {
      bcqq.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqr
 * JD-Core Version:    0.7.0.1
 */