import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsn
  extends ampa<amsm>
{
  public int a()
  {
    return 414;
  }
  
  @NonNull
  public amsm a(int paramInt)
  {
    return new amsm();
  }
  
  @Nullable
  public amsm a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amsm localamsm = amsm.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamsm;
    }
    return null;
  }
  
  public Class<amsm> a()
  {
    return amsm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsm paramamsm)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramamsm.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramamsm.toString());
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
 * Qualified Name:     amsn
 * JD-Core Version:    0.7.0.1
 */