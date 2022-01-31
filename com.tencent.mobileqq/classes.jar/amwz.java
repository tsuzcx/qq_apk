import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwz
  extends ampa<amwy>
{
  public int a()
  {
    return 207;
  }
  
  @NonNull
  public amwy a(int paramInt)
  {
    return new amwy();
  }
  
  @Nullable
  public amwy a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amwy localamwy = amwy.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfamph[0].a);
      }
      return localamwy;
    }
    return null;
  }
  
  public Class<amwy> a()
  {
    return amwy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwy paramamwy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramamwy.toString());
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
 * Qualified Name:     amwz
 * JD-Core Version:    0.7.0.1
 */