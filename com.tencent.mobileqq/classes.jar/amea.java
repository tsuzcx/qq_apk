import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amea
  extends alzl<amdz>
{
  public int a()
  {
    return 442;
  }
  
  @NonNull
  public amdz a(int paramInt)
  {
    return new amdz();
  }
  
  @Nullable
  public amdz a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amdz localamdz = amdz.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamdz;
    }
    return null;
  }
  
  public Class<amdz> a()
  {
    return amdz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amdz paramamdz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramamdz.toString());
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
 * Qualified Name:     amea
 * JD-Core Version:    0.7.0.1
 */