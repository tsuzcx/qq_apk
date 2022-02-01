import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbl
  extends aqkz<arbk>
{
  public static arbk a()
  {
    return (arbk)aqlk.a().a(335);
  }
  
  @NonNull
  public arbk a(int paramInt)
  {
    return new arbk();
  }
  
  @Nullable
  public arbk a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arbk.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arbk paramarbk) {}
  
  public Class<arbk> clazz()
  {
    return arbk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TencentDocSelectAddDocsProcessor", 1, "handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */