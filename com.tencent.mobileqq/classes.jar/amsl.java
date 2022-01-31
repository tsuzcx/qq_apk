import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amsl
  extends ampa<amsk>
{
  public int a()
  {
    return 417;
  }
  
  @NonNull
  public amsk a(int paramInt)
  {
    return new amsk();
  }
  
  @Nullable
  public amsk a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amsk localamsk = new amsk();
      localamsk.a = paramArrayOfamph[0].a;
      return localamsk;
    }
    return null;
  }
  
  public Class<amsk> a()
  {
    return amsk.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    amsk localamsk = (amsk)ampl.a().a(417);
    if (localamsk != null) {
      ((airx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localamsk.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsk paramamsk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    airx localairx = (airx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramamsk != null) {}
    for (paramamsk = paramamsk.a;; paramamsk = null)
    {
      localairx.d(paramamsk);
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
 * Qualified Name:     amsl
 * JD-Core Version:    0.7.0.1
 */