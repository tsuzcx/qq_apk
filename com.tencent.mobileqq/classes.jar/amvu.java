import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvu
  extends ampb<amvt>
{
  public int a()
  {
    return 490;
  }
  
  @NonNull
  public amvt a(int paramInt)
  {
    return new amvt();
  }
  
  @Nullable
  public amvt a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amvt localamvt = amvt.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamvt;
    }
    return new amvt();
  }
  
  public Class<amvt> a()
  {
    return amvt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvt paramamvt) {}
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     amvu
 * JD-Core Version:    0.7.0.1
 */