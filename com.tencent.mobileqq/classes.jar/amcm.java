import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amcm
  extends alzl<amcl>
{
  public int a()
  {
    return 417;
  }
  
  @NonNull
  public amcl a(int paramInt)
  {
    return new amcl();
  }
  
  @Nullable
  public amcl a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amcl localamcl = new amcl();
      localamcl.a = paramArrayOfalzs[0].a;
      return localamcl;
    }
    return null;
  }
  
  public Class<amcl> a()
  {
    return amcl.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    amcl localamcl = (amcl)alzw.a().a(417);
    if (localamcl != null) {
      ((aifg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localamcl.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amcl paramamcl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    aifg localaifg = (aifg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramamcl != null) {}
    for (paramamcl = paramamcl.a;; paramamcl = null)
    {
      localaifg.d(paramamcl);
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcm
 * JD-Core Version:    0.7.0.1
 */