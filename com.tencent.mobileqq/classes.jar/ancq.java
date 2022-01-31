import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ancq
  extends ampb<ancp>
{
  public static ancp a()
  {
    return (ancp)ampm.a().a(335);
  }
  
  public int a()
  {
    return 335;
  }
  
  @NonNull
  public ancp a(int paramInt)
  {
    return new ancp();
  }
  
  @Nullable
  public ancp a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return ancp.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<ancp> a()
  {
    return ancp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocSelectAddDocsProcessor", 1, "handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:" + paramInt);
  }
  
  public void a(ancp paramancp) {}
  
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancq
 * JD-Core Version:    0.7.0.1
 */