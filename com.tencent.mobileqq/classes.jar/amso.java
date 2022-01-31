import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amso
  extends ampb<amsn>
{
  public int a()
  {
    return 414;
  }
  
  @NonNull
  public amsn a(int paramInt)
  {
    return new amsn();
  }
  
  @Nullable
  public amsn a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amsn localamsn = amsn.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamsn;
    }
    return null;
  }
  
  public Class<amsn> a()
  {
    return amsn.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsn paramamsn)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramamsn.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramamsn.toString());
    }
  }
  
  public boolean a()
  {
    return false;
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
 * Qualified Name:     amso
 * JD-Core Version:    0.7.0.1
 */