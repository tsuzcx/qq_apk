import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwb
  extends ampa<amwc>
{
  public int a()
  {
    return 362;
  }
  
  @NonNull
  public amwc a(int paramInt)
  {
    return new amwc();
  }
  
  @Nullable
  public amwc a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amwc localamwc = amwc.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamwc;
    }
    return null;
  }
  
  public Class<amwc> a()
  {
    return amwc.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public void a(amwc paramamwc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramamwc });
    }
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
 * Qualified Name:     amwb
 * JD-Core Version:    0.7.0.1
 */