import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfy
  extends alzl<amfz>
{
  public int a()
  {
    return 362;
  }
  
  @NonNull
  public amfz a(int paramInt)
  {
    return new amfz();
  }
  
  @Nullable
  public amfz a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amfz localamfz = amfz.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamfz;
    }
    return null;
  }
  
  public Class<amfz> a()
  {
    return amfz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public void a(amfz paramamfz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramamfz });
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
 * Qualified Name:     amfy
 * JD-Core Version:    0.7.0.1
 */