import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anbf
  extends ampb<anbe>
{
  public static anbe a()
  {
    return (anbe)ampm.a().a(342);
  }
  
  public int a()
  {
    return 342;
  }
  
  @NonNull
  public anbe a(int paramInt)
  {
    return new anbe();
  }
  
  @Nullable
  public anbe a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anbe.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anbe> a()
  {
    return anbe.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocAIOShowGuideDialogProcessor", 1, "TENCENT_DOC_AIO_SHOW_GUIDE_DIALOG failed, resultCode:" + paramInt);
  }
  
  public void a(anbe paramanbe) {}
  
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
 * Qualified Name:     anbf
 * JD-Core Version:    0.7.0.1
 */