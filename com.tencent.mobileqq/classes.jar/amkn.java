import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amkn
  extends alzl<amkl>
{
  public int a()
  {
    return 456;
  }
  
  @NonNull
  public amkl a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amkl();
  }
  
  @Nullable
  public amkl a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return amkl.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return amkl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amkl paramamkl)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamkl == null) {
        break label43;
      }
    }
    label43:
    for (paramamkl = paramamkl.toString();; paramamkl = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramamkl);
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
 * Qualified Name:     amkn
 * JD-Core Version:    0.7.0.1
 */