import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amkd
  extends alzl<amkc>
{
  public int a()
  {
    return 434;
  }
  
  @NonNull
  public amkc a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amkc();
  }
  
  @Nullable
  public amkc a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return amkc.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<amkc> a()
  {
    return amkc.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amkc paramamkc)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamkc == null) {
        break label43;
      }
    }
    label43:
    for (paramamkc = paramamkc.toString();; paramamkc = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramamkc);
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
 * Qualified Name:     amkd
 * JD-Core Version:    0.7.0.1
 */