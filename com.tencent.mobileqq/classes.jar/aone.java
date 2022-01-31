import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aone
  extends aokh<aond>
{
  public static aond a()
  {
    return (aond)aoks.a().a(452);
  }
  
  public int a()
  {
    return 452;
  }
  
  @NonNull
  public aond a(int paramInt)
  {
    return new aond().b("0");
  }
  
  @Nullable
  public aond a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aond localaond = aond.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaond;
    }
    return null;
  }
  
  public Class<aond> a()
  {
    return aond.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aond paramaond) {}
  
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
 * Qualified Name:     aone
 * JD-Core Version:    0.7.0.1
 */