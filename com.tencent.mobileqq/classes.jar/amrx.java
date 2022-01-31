import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amrx
  extends ampa<amrw>
{
  public static amrw a()
  {
    return (amrw)ampl.a().a(452);
  }
  
  public int a()
  {
    return 452;
  }
  
  @NonNull
  public amrw a(int paramInt)
  {
    return new amrw().b("0");
  }
  
  @Nullable
  public amrw a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amrw localamrw = amrw.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamrw;
    }
    return null;
  }
  
  public Class<amrw> a()
  {
    return amrw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amrw paramamrw) {}
  
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
 * Qualified Name:     amrx
 * JD-Core Version:    0.7.0.1
 */