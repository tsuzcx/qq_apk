import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amuf
  extends ampa<amue>
{
  public int a()
  {
    return 442;
  }
  
  @NonNull
  public amue a(int paramInt)
  {
    return new amue();
  }
  
  @Nullable
  public amue a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amue localamue = amue.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamue;
    }
    return null;
  }
  
  public Class<amue> a()
  {
    return amue.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amue paramamue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramamue.toString());
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
 * Qualified Name:     amuf
 * JD-Core Version:    0.7.0.1
 */