import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amxl
  extends ampb<amxk>
{
  public static amxk a()
  {
    amxk localamxk2 = (amxk)ampm.a().a(493);
    amxk localamxk1 = localamxk2;
    if (localamxk2 == null) {
      localamxk1 = new amxk();
    }
    return localamxk1;
  }
  
  public int a()
  {
    return 493;
  }
  
  @NonNull
  public amxk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amxk();
  }
  
  @Nullable
  public amxk a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return amxk.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class<amxk> a()
  {
    return amxk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amxk paramamxk)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamxk == null) {
        break label43;
      }
    }
    label43:
    for (paramamxk = paramamxk.toString();; paramamxk = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramamxk);
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
 * Qualified Name:     amxl
 * JD-Core Version:    0.7.0.1
 */