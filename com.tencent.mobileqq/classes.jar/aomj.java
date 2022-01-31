import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomj
  extends aofy<aomi>
{
  public static aomi a()
  {
    return (aomi)aogj.a().a(441);
  }
  
  public int a()
  {
    return 441;
  }
  
  @NonNull
  public aomi a(int paramInt)
  {
    return new aomi();
  }
  
  @Nullable
  public aomi a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      new aomi();
      return aomi.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aomi> a()
  {
    return aomi.class;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aomi paramaomi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramaomi.toString());
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     aomj
 * JD-Core Version:    0.7.0.1
 */