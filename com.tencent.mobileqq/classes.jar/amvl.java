import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvl
  extends ampa<amvk>
{
  public static amvk a()
  {
    return (amvk)ampl.a().a(292);
  }
  
  public int a()
  {
    return 292;
  }
  
  @NonNull
  public amvk a(int paramInt)
  {
    return new amvk();
  }
  
  @Nullable
  public amvk a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfamph);
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfamph[0].a);
      }
      return amvk.a(paramArrayOfamph[0].a);
    }
    return null;
  }
  
  public Class<amvk> a()
  {
    return amvk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvk paramamvk) {}
  
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
 * Qualified Name:     amvl
 * JD-Core Version:    0.7.0.1
 */