import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aspw
  extends ampa<aspv>
{
  public int a()
  {
    return 478;
  }
  
  @NonNull
  public aspv a(int paramInt)
  {
    return new aspv();
  }
  
  @Nullable
  public aspv a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfamph[0].a);
      }
      return aspv.a(paramArrayOfamph[0].a);
    }
    return new aspv();
  }
  
  public Class<aspv> a()
  {
    return aspv.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(aspv paramaspv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramaspv);
    }
    ((aspx)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramaspv);
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
 * Qualified Name:     aspw
 * JD-Core Version:    0.7.0.1
 */