import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class axas
  extends ajss
{
  axas(axar paramaxar) {}
  
  protected void a(boolean paramBoolean, axau paramaxau)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramaxau == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!axar.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramaxau.c;
      break;
      label73:
      if ((!axar.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(axar.a(this.a), 100L);
      }
      if (paramaxau != null)
      {
        if (paramaxau.a()) {
          axam.a(axar.a(this.a), paramaxau.a(), 2);
        }
        if (paramaxau.b())
        {
          ??? = paramaxau.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              axam.c(axar.a(this.a), (String)localObject2);
            }
          }
        }
        paramaxau.a();
      }
      synchronized (axar.c())
      {
        axar.c(this.a, false);
        axar.d(this.a, true);
        if ((paramaxau == null) || (!paramaxau.b)) {
          continue;
        }
        axam.a(axar.a(this.a), paramaxau.c, false);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, axau arg2)
  {
    synchronized ()
    {
      axar.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, axau arg2)
  {
    synchronized ()
    {
      axar.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axas
 * JD-Core Version:    0.7.0.1
 */