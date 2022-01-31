import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomq
  extends aofy<aomp>
{
  public static aomp a()
  {
    return (aomp)aogj.a().a(292);
  }
  
  public int a()
  {
    return 292;
  }
  
  @NonNull
  public aomp a(int paramInt)
  {
    return new aomp();
  }
  
  @Nullable
  public aomp a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaogf);
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaogf[0].a);
      }
      return aomp.a(paramArrayOfaogf[0].a);
    }
    return null;
  }
  
  public Class<aomp> a()
  {
    return aomp.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aomp paramaomp) {}
  
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
 * Qualified Name:     aomq
 * JD-Core Version:    0.7.0.1
 */