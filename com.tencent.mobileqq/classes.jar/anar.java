import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anar
  extends ampb<anap>
{
  public int a()
  {
    return 456;
  }
  
  @NonNull
  public anap a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anap();
  }
  
  @Nullable
  public anap a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return anap.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return anap.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anap paramanap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanap == null) {
        break label43;
      }
    }
    label43:
    for (paramanap = paramanap.toString();; paramanap = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramanap);
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
 * Qualified Name:     anar
 * JD-Core Version:    0.7.0.1
 */