import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amhh
  extends alzl<amhg>
{
  public static amhg a()
  {
    amhg localamhg2 = (amhg)alzw.a().a(493);
    amhg localamhg1 = localamhg2;
    if (localamhg2 == null) {
      localamhg1 = new amhg();
    }
    return localamhg1;
  }
  
  public int a()
  {
    return 493;
  }
  
  @NonNull
  public amhg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amhg();
  }
  
  @Nullable
  public amhg a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return amhg.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<amhg> a()
  {
    return amhg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amhg paramamhg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamhg == null) {
        break label43;
      }
    }
    label43:
    for (paramamhg = paramamhg.toString();; paramamhg = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramamhg);
      return;
    }
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
 * Qualified Name:     amhh
 * JD-Core Version:    0.7.0.1
 */