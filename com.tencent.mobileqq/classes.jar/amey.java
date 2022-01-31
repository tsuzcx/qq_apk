import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amey
  extends alzl<amew>
{
  public int a()
  {
    return 534;
  }
  
  @NonNull
  public amew a(int paramInt)
  {
    return new amew();
  }
  
  @Nullable
  public amew a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amew localamew = amew.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfalzs[0].a);
      }
      return localamew;
    }
    return null;
  }
  
  public Class<amew> a()
  {
    return amew.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amew paramamew)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramamew.toString());
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
 * Qualified Name:     amey
 * JD-Core Version:    0.7.0.1
 */