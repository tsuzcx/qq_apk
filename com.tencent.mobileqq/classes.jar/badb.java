import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class badb
  extends amdg
{
  badb(bada parambada) {}
  
  protected void a(boolean paramBoolean, bade parambade)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (parambade == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!bada.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = parambade.c;
      break;
      label73:
      if ((!bada.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(bada.a(this.a), 100L);
      }
      if (parambade != null)
      {
        if (parambade.a()) {
          bacu.a(bada.a(this.a), parambade.a(), 2);
        }
        if (parambade.b())
        {
          ??? = parambade.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              bacu.c(bada.a(this.a), (String)localObject2);
            }
          }
        }
        parambade.a();
      }
      synchronized (bada.c())
      {
        bada.c(this.a, false);
        bada.d(this.a, true);
        if ((parambade == null) || (!parambade.b)) {
          continue;
        }
        bacu.a(bada.a(this.a), parambade.c, false);
        ??? = (aors)aoks.a().a(607);
        if ((??? == null) || (((aors)???).a)) {
          continue;
        }
        badc.a(bada.a(this.a), parambade.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, bade arg2)
  {
    synchronized ()
    {
      bada.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, bade arg2)
  {
    synchronized ()
    {
      bada.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badb
 * JD-Core Version:    0.7.0.1
 */