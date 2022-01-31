import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgl
  extends ampa<amgk>
{
  public static amgk a()
  {
    return (amgk)ampl.a().a(549);
  }
  
  public int a()
  {
    return 549;
  }
  
  @NonNull
  public amgk a(int paramInt)
  {
    return new amgk();
  }
  
  @Nullable
  public amgk a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amgk localamgk = amgk.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamgk;
    }
    return null;
  }
  
  public Class a()
  {
    return amgk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amgk paramamgk) {}
  
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
 * Qualified Name:     amgl
 * JD-Core Version:    0.7.0.1
 */