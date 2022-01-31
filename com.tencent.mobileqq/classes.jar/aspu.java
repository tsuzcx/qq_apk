import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aspu
  extends ampb<aspt>
{
  public int a()
  {
    return 478;
  }
  
  @NonNull
  public aspt a(int paramInt)
  {
    return new aspt();
  }
  
  @Nullable
  public aspt a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfampi[0].a);
      }
      return aspt.a(paramArrayOfampi[0].a);
    }
    return new aspt();
  }
  
  public Class<aspt> a()
  {
    return aspt.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(aspt paramaspt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramaspt);
    }
    ((aspv)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramaspt);
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
 * Qualified Name:     aspu
 * JD-Core Version:    0.7.0.1
 */