import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aorp
  extends aokh<aorq>
{
  public int a()
  {
    return 362;
  }
  
  @NonNull
  public aorq a(int paramInt)
  {
    return new aorq();
  }
  
  @Nullable
  public aorq a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aorq localaorq = aorq.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaorq;
    }
    return null;
  }
  
  public Class<aorq> a()
  {
    return aorq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public void a(aorq paramaorq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramaorq });
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
 * Qualified Name:     aorp
 * JD-Core Version:    0.7.0.1
 */