import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoqz
  extends aokh<aoqy>
{
  public static aoqy a()
  {
    return (aoqy)aoks.a().a(292);
  }
  
  public int a()
  {
    return 292;
  }
  
  @NonNull
  public aoqy a(int paramInt)
  {
    return new aoqy();
  }
  
  @Nullable
  public aoqy a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaoko);
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaoko[0].a);
      }
      return aoqy.a(paramArrayOfaoko[0].a);
    }
    return null;
  }
  
  public Class<aoqy> a()
  {
    return aoqy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoqy paramaoqy) {}
  
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
 * Qualified Name:     aoqz
 * JD-Core Version:    0.7.0.1
 */