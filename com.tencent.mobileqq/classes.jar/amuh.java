import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amuh
  extends ampa<amug>
{
  public int a()
  {
    return 488;
  }
  
  @NonNull
  public amug a(int paramInt)
  {
    return new amug();
  }
  
  @Nullable
  public amug a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amug localamug = amug.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamug;
    }
    return null;
  }
  
  public Class<amug> a()
  {
    return amug.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amug paramamug)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramamug.toString());
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
 * Qualified Name:     amuh
 * JD-Core Version:    0.7.0.1
 */