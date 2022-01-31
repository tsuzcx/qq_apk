import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amxk
  extends ampa<amxj>
{
  public static amxj a()
  {
    amxj localamxj2 = (amxj)ampl.a().a(493);
    amxj localamxj1 = localamxj2;
    if (localamxj2 == null) {
      localamxj1 = new amxj();
    }
    return localamxj1;
  }
  
  public int a()
  {
    return 493;
  }
  
  @NonNull
  public amxj a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amxj();
  }
  
  @Nullable
  public amxj a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return amxj.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<amxj> a()
  {
    return amxj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amxj paramamxj)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamxj == null) {
        break label43;
      }
    }
    label43:
    for (paramamxj = paramamxj.toString();; paramamxj = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramamxj);
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
 * Qualified Name:     amxk
 * JD-Core Version:    0.7.0.1
 */