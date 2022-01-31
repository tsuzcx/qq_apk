import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anbx
  extends ampb<anbw>
{
  public static anbw a()
  {
    return (anbw)ampm.a().a(338);
  }
  
  public int a()
  {
    return 338;
  }
  
  @NonNull
  public anbw a(int paramInt)
  {
    return new anbw();
  }
  
  @Nullable
  public anbw a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anbw.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anbw> a()
  {
    return anbw.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocGrayTipsProcessor", 1, "TENCENT_DOC_GRAY_TIPS failed, resultCode:" + paramInt);
  }
  
  public void a(anbw paramanbw) {}
  
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
 * Qualified Name:     anbx
 * JD-Core Version:    0.7.0.1
 */