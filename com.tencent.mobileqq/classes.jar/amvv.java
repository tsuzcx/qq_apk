import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvv
  extends ampb<amvw>
{
  public static amvw a()
  {
    return (amvw)ampm.a().a(564);
  }
  
  public int a()
  {
    return 564;
  }
  
  @NonNull
  public amvw a(int paramInt)
  {
    return new amvw();
  }
  
  @Nullable
  public amvw a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0)) {
      return null;
    }
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfampi);
    }
    return amvw.a(paramArrayOfampi);
  }
  
  public Class<amvw> a()
  {
    return amvw.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvw paramamvw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramamvw != null) {
      awbs.a = (int)(paramamvw.a * 60.0D * 60.0D);
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
 * Qualified Name:     amvv
 * JD-Core Version:    0.7.0.1
 */