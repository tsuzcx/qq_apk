import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoqs
  extends aokh<aoqr>
{
  public static aoqr a()
  {
    return (aoqr)aoks.a().a(441);
  }
  
  public int a()
  {
    return 441;
  }
  
  @NonNull
  public aoqr a(int paramInt)
  {
    return new aoqr();
  }
  
  @Nullable
  public aoqr a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      new aoqr();
      return aoqr.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoqr> a()
  {
    return aoqr.class;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoqr paramaoqr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramaoqr.toString());
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
 * Qualified Name:     aoqs
 * JD-Core Version:    0.7.0.1
 */