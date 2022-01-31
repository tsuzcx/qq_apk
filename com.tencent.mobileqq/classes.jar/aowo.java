import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aowo
  extends aokh<aowm>
{
  public int a()
  {
    return 456;
  }
  
  @NonNull
  public aowm a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aowm();
  }
  
  @Nullable
  public aowm a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aowm.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return aowm.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aowm paramaowm)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaowm == null) {
        break label43;
      }
    }
    label43:
    for (paramaowm = paramaowm.toString();; paramaowm = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramaowm);
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
 * Qualified Name:     aowo
 * JD-Core Version:    0.7.0.1
 */