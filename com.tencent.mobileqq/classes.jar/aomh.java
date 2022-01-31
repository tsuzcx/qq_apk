import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomh
  extends aofy<aomf>
{
  public int a()
  {
    return 534;
  }
  
  @NonNull
  public aomf a(int paramInt)
  {
    return new aomf();
  }
  
  @Nullable
  public aomf a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aomf localaomf = aomf.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfaogf[0].a);
      }
      return localaomf;
    }
    return null;
  }
  
  public Class<aomf> a()
  {
    return aomf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aomf paramaomf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramaomf.toString());
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
 * Qualified Name:     aomh
 * JD-Core Version:    0.7.0.1
 */