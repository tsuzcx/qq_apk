import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aonw
  extends aokh<aonv>
{
  public int a()
  {
    return 414;
  }
  
  @NonNull
  public aonv a(int paramInt)
  {
    return new aonv();
  }
  
  @Nullable
  public aonv a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aonv localaonv = aonv.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaonv;
    }
    return null;
  }
  
  public Class<aonv> a()
  {
    return aonv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aonv paramaonv)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramaonv.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramaonv.toString());
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
 * Qualified Name:     aonw
 * JD-Core Version:    0.7.0.1
 */