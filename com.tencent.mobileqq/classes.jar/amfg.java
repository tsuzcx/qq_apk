import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfg
  extends alzl<amff>
{
  public static amff a()
  {
    return (amff)alzw.a().a(292);
  }
  
  public int a()
  {
    return 292;
  }
  
  @NonNull
  public amff a(int paramInt)
  {
    return new amff();
  }
  
  @Nullable
  public amff a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfalzs);
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfalzs[0].a);
      }
      return amff.a(paramArrayOfalzs[0].a);
    }
    return null;
  }
  
  public Class<amff> a()
  {
    return amff.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amff paramamff) {}
  
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
 * Qualified Name:     amfg
 * JD-Core Version:    0.7.0.1
 */