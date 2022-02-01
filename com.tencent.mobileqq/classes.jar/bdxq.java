import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class bdxq
  extends aoef
{
  bdxq(bdxp parambdxp) {}
  
  protected void a(boolean paramBoolean, bdxt parambdxt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (parambdxt == null)
      {
        ??? = "data is null";
        QLog.d("SUB_ACCOUNT", 2, (String)???);
      }
    }
    else
    {
      if (!bdxp.a(this.a).isReleased) {
        break label73;
      }
    }
    for (;;)
    {
      return;
      ??? = parambdxt.c;
      break;
      label73:
      if ((!bdxp.a(this.a)) && (ThreadManager.getSubThreadHandler() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(bdxp.a(this.a), 100L);
      }
      if (parambdxt != null)
      {
        if (parambdxt.a()) {
          bdxj.a(bdxp.a(this.a), parambdxt.a(), 2);
        }
        if (parambdxt.b())
        {
          ??? = parambdxt.b();
          if (??? != null)
          {
            ??? = ((ArrayList)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (String)((Iterator)???).next();
              bdxj.c(bdxp.a(this.a), (String)localObject2);
            }
          }
        }
        parambdxt.a();
      }
      synchronized (bdxp.c())
      {
        bdxp.c(this.a, false);
        bdxp.d(this.a, true);
        if ((parambdxt == null) || (!parambdxt.b)) {
          continue;
        }
        bdxj.a(bdxp.a(this.a), parambdxt.c, false);
        ??? = (argg)aqxe.a().a(607);
        if ((??? == null) || (((argg)???).a)) {
          continue;
        }
        bdxr.a(bdxp.a(this.a), parambdxt.c);
        return;
      }
    }
  }
  
  protected void b(boolean paramBoolean, bdxt arg2)
  {
    synchronized ()
    {
      bdxp.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, bdxt arg2)
  {
    synchronized ()
    {
      bdxp.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxq
 * JD-Core Version:    0.7.0.1
 */