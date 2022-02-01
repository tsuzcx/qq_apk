import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class bdef
  extends anvp
{
  bdef(bdee parambdee) {}
  
  protected void a(boolean paramBoolean, bdei parambdei)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (parambdei == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!bdee.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = parambdei.c;
      break;
      label73:
      if ((!bdee.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(bdee.a(this.a), 100L);
      }
      if (parambdei != null)
      {
        if (parambdei.a()) {
          bddy.a(bdee.a(this.a), parambdei.a(), 2);
        }
        if (parambdei.b())
        {
          ??? = parambdei.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              bddy.c(bdee.a(this.a), (String)localObject2);
            }
          }
        }
        parambdei.a();
      }
      synchronized (bdee.c())
      {
        bdee.c(this.a, false);
        bdee.d(this.a, true);
        if ((parambdei == null) || (!parambdei.b)) {
          continue;
        }
        bddy.a(bdee.a(this.a), parambdei.c, false);
        ??? = (aqtu)aqlk.a().a(607);
        if ((??? == null) || (((aqtu)???).a)) {
          continue;
        }
        bdeg.a(bdee.a(this.a), parambdei.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, bdei arg2)
  {
    synchronized ()
    {
      bdee.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, bdei arg2)
  {
    synchronized ()
    {
      bdee.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdef
 * JD-Core Version:    0.7.0.1
 */