import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class ayau
  extends akhc
{
  ayau(ayat paramayat) {}
  
  protected void a(boolean paramBoolean, ayaw paramayaw)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramayaw == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!ayat.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramayaw.c;
      break;
      label73:
      if ((!ayat.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(ayat.a(this.a), 100L);
      }
      if (paramayaw != null)
      {
        if (paramayaw.a()) {
          ayao.a(ayat.a(this.a), paramayaw.a(), 2);
        }
        if (paramayaw.b())
        {
          ??? = paramayaw.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              ayao.c(ayat.a(this.a), (String)localObject2);
            }
          }
        }
        paramayaw.a();
      }
      synchronized (ayat.c())
      {
        ayat.c(this.a, false);
        ayat.d(this.a, true);
        if ((paramayaw == null) || (!paramayaw.b)) {
          continue;
        }
        ayao.a(ayat.a(this.a), paramayaw.c, false);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, ayaw arg2)
  {
    synchronized ()
    {
      ayat.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, ayaw arg2)
  {
    synchronized ()
    {
      ayat.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayau
 * JD-Core Version:    0.7.0.1
 */