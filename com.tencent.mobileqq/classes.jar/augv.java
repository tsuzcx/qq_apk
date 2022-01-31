import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class augv
  extends aofy<augu>
{
  public int a()
  {
    return 478;
  }
  
  @NonNull
  public augu a(int paramInt)
  {
    return new augu();
  }
  
  @Nullable
  public augu a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaogf[0].a);
      }
      return augu.a(paramArrayOfaogf[0].a);
    }
    return new augu();
  }
  
  public Class<augu> a()
  {
    return augu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(augu paramaugu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramaugu);
    }
    ((augw)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramaugu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     augv
 * JD-Core Version:    0.7.0.1
 */