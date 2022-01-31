import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aule
  extends aokh<auld>
{
  public int a()
  {
    return 478;
  }
  
  @NonNull
  public auld a(int paramInt)
  {
    return new auld();
  }
  
  @Nullable
  public auld a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaoko[0].a);
      }
      return auld.a(paramArrayOfaoko[0].a);
    }
    return new auld();
  }
  
  public Class<auld> a()
  {
    return auld.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(auld paramauld)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramauld);
    }
    ((aulf)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramauld);
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
 * Qualified Name:     aule
 * JD-Core Version:    0.7.0.1
 */