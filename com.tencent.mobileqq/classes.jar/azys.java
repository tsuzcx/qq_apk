import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class azys
  extends alyr
{
  azys(azyr paramazyr) {}
  
  protected void a(boolean paramBoolean, azyv paramazyv)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramazyv == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!azyr.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = paramazyv.c;
      break;
      label73:
      if ((!azyr.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(azyr.a(this.a), 100L);
      }
      if (paramazyv != null)
      {
        if (paramazyv.a()) {
          azyl.a(azyr.a(this.a), paramazyv.a(), 2);
        }
        if (paramazyv.b())
        {
          ??? = paramazyv.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              azyl.c(azyr.a(this.a), (String)localObject2);
            }
          }
        }
        paramazyv.a();
      }
      synchronized (azyr.c())
      {
        azyr.c(this.a, false);
        azyr.d(this.a, true);
        if ((paramazyv == null) || (!paramazyv.b)) {
          continue;
        }
        azyl.a(azyr.a(this.a), paramazyv.c, false);
        ??? = (aonj)aogj.a().a(607);
        if ((??? == null) || (((aonj)???).a)) {
          continue;
        }
        azyt.a(azyr.a(this.a), paramazyv.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, azyv arg2)
  {
    synchronized ()
    {
      azyr.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, azyv arg2)
  {
    synchronized ()
    {
      azyr.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azys
 * JD-Core Version:    0.7.0.1
 */