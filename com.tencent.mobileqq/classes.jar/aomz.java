import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomz
  extends aofy<aona>
{
  public static aona a()
  {
    return (aona)aogj.a().a(564);
  }
  
  public int a()
  {
    return 564;
  }
  
  @NonNull
  public aona a(int paramInt)
  {
    return new aona();
  }
  
  @Nullable
  public aona a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return null;
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaogf);
    }
    return aona.a(paramArrayOfaogf);
  }
  
  public Class<aona> a()
  {
    return aona.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aona paramaona)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramaona != null) {
      axwx.a = (int)(paramaona.a * 60.0D * 60.0D);
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
 * Qualified Name:     aomz
 * JD-Core Version:    0.7.0.1
 */