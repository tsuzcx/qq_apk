import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgm
  extends ampb<amgl>
{
  public static amgl a()
  {
    return (amgl)ampm.a().a(549);
  }
  
  public int a()
  {
    return 549;
  }
  
  @NonNull
  public amgl a(int paramInt)
  {
    return new amgl();
  }
  
  @Nullable
  public amgl a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amgl localamgl = amgl.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamgl;
    }
    return null;
  }
  
  public Class a()
  {
    return amgl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amgl paramamgl) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgm
 * JD-Core Version:    0.7.0.1
 */