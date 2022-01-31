import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvd
  extends ampa<amvb>
{
  public int a()
  {
    return 534;
  }
  
  @NonNull
  public amvb a(int paramInt)
  {
    return new amvb();
  }
  
  @Nullable
  public amvb a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amvb localamvb = amvb.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfamph[0].a);
      }
      return localamvb;
    }
    return null;
  }
  
  public Class<amvb> a()
  {
    return amvb.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvb paramamvb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramamvb.toString());
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
 * Qualified Name:     amvd
 * JD-Core Version:    0.7.0.1
 */