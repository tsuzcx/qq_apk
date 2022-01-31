import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class artq
  extends alzl<artp>
{
  public int a()
  {
    return 478;
  }
  
  @NonNull
  public artp a(int paramInt)
  {
    return new artp();
  }
  
  @Nullable
  public artp a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfalzs[0].a);
      }
      return artp.a(paramArrayOfalzs[0].a);
    }
    return new artp();
  }
  
  public Class<artp> a()
  {
    return artp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(artp paramartp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramartp);
    }
    ((artr)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramartp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     artq
 * JD-Core Version:    0.7.0.1
 */