import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvf
  extends ampa<amve>
{
  public static amve a()
  {
    return (amve)ampl.a().a(441);
  }
  
  public int a()
  {
    return 441;
  }
  
  @NonNull
  public amve a(int paramInt)
  {
    return new amve();
  }
  
  @Nullable
  public amve a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      new amve();
      return amve.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amve> a()
  {
    return amve.class;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amve paramamve)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramamve.toString());
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
 * Qualified Name:     amvf
 * JD-Core Version:    0.7.0.1
 */