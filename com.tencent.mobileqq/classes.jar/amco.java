import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amco
  extends alzl<amcn>
{
  public int a()
  {
    return 414;
  }
  
  @NonNull
  public amcn a(int paramInt)
  {
    return new amcn();
  }
  
  @Nullable
  public amcn a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amcn localamcn = amcn.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamcn;
    }
    return null;
  }
  
  public Class<amcn> a()
  {
    return amcn.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amcn paramamcn)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramamcn.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramamcn.toString());
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
 * Qualified Name:     amco
 * JD-Core Version:    0.7.0.1
 */