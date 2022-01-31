import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojn
  extends aofy<aojm>
{
  public int a()
  {
    return 414;
  }
  
  @NonNull
  public aojm a(int paramInt)
  {
    return new aojm();
  }
  
  @Nullable
  public aojm a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aojm localaojm = aojm.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaojm;
    }
    return null;
  }
  
  public Class<aojm> a()
  {
    return aojm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aojm paramaojm)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramaojm.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramaojm.toString());
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
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */