import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anau
  extends ampa<anav>
{
  public int a()
  {
    return 589;
  }
  
  @NonNull
  public anav a(int paramInt)
  {
    return new anav();
  }
  
  @Nullable
  public anav a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      anav localanav = anav.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfamph[0].a);
      }
      return localanav;
    }
    return new anav();
  }
  
  public Class<anav> a()
  {
    return anav.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public void a(anav paramanav)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
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
 * Qualified Name:     anau
 * JD-Core Version:    0.7.0.1
 */