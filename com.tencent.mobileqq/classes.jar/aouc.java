import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aouc
  extends aofy<aoub>
{
  public static aoub a()
  {
    return (aoub)aogj.a().a(335);
  }
  
  public int a()
  {
    return 335;
  }
  
  @NonNull
  public aoub a(int paramInt)
  {
    return new aoub();
  }
  
  @Nullable
  public aoub a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aoub.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aoub> a()
  {
    return aoub.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocSelectAddDocsProcessor", 1, "handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:" + paramInt);
  }
  
  public void a(aoub paramaoub) {}
  
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
 * Qualified Name:     aouc
 * JD-Core Version:    0.7.0.1
 */