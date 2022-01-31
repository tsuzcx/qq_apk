import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvg
  extends ampb<amvf>
{
  public static amvf a()
  {
    return (amvf)ampm.a().a(441);
  }
  
  public int a()
  {
    return 441;
  }
  
  @NonNull
  public amvf a(int paramInt)
  {
    return new amvf();
  }
  
  @Nullable
  public amvf a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      new amvf();
      return amvf.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amvf> a()
  {
    return amvf.class;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amvf paramamvf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramamvf.toString());
    }
  }
  
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
 * Qualified Name:     amvg
 * JD-Core Version:    0.7.0.1
 */