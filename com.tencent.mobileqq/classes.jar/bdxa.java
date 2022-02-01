import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class bdxa
  extends aoib
{
  bdxa(bdwz parambdwz) {}
  
  protected void a(boolean paramBoolean, bdxd parambdxd)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (parambdxd == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!bdwz.a(this.a).l) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = parambdxd.c;
      break;
      label73:
      if ((!bdwz.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(bdwz.a(this.a), 100L);
      }
      if (parambdxd != null)
      {
        if (parambdxd.a()) {
          bdwt.a(bdwz.a(this.a), parambdxd.a(), 2);
        }
        if (parambdxd.b())
        {
          ??? = parambdxd.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              bdwt.c(bdwz.a(this.a), (String)localObject2);
            }
          }
        }
        parambdxd.a();
      }
      synchronized (bdwz.c())
      {
        bdwz.c(this.a, false);
        bdwz.d(this.a, true);
        if ((parambdxd == null) || (!parambdxd.b)) {
          continue;
        }
        bdwt.a(bdwz.a(this.a), parambdxd.c, false);
        ??? = (arjg)aran.a().a(607);
        if ((??? == null) || (((arjg)???).a)) {
          continue;
        }
        bdxb.a(bdwz.a(this.a), parambdxd.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, bdxd arg2)
  {
    synchronized ()
    {
      bdwz.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, bdxd arg2)
  {
    synchronized ()
    {
      bdwz.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxa
 * JD-Core Version:    0.7.0.1
 */