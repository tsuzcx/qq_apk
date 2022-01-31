import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class ayaw
  extends akhb
{
  ayaw(ayav paramayav) {}
  
  protected void a(boolean paramBoolean, ayay paramayay)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramayay == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!ayav.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramayay.c;
      break;
      label73:
      if ((!ayav.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(ayav.a(this.a), 100L);
      }
      if (paramayay != null)
      {
        if (paramayay.a()) {
          ayaq.a(ayav.a(this.a), paramayay.a(), 2);
        }
        if (paramayay.b())
        {
          ??? = paramayay.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              ayaq.c(ayav.a(this.a), (String)localObject2);
            }
          }
        }
        paramayay.a();
      }
      synchronized (ayav.c())
      {
        ayav.c(this.a, false);
        ayav.d(this.a, true);
        if ((paramayay == null) || (!paramayay.b)) {
          continue;
        }
        ayaq.a(ayav.a(this.a), paramayay.c, false);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, ayay arg2)
  {
    synchronized ()
    {
      ayav.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, ayay arg2)
  {
    synchronized ()
    {
      ayav.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayaw
 * JD-Core Version:    0.7.0.1
 */