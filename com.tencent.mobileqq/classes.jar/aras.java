import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aras
  extends aqkz<arar>
{
  public static arar a()
  {
    return (arar)aqlk.a().a(338);
  }
  
  @NonNull
  public arar a(int paramInt)
  {
    return new arar();
  }
  
  @Nullable
  public arar a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arar.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arar paramarar) {}
  
  public Class<arar> clazz()
  {
    return arar.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
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
    QLog.d("TencentDocGrayTipsProcessor", 1, "TENCENT_DOC_GRAY_TIPS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 338;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aras
 * JD-Core Version:    0.7.0.1
 */