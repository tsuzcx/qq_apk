import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arnq
  extends aqwt<arno>
{
  public static arno a()
  {
    return (arno)aqxe.a().a(569);
  }
  
  @NonNull
  public arno a(int paramInt)
  {
    return new arno();
  }
  
  @Nullable
  public arno a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arno.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arno paramarno) {}
  
  public Class<arno> clazz()
  {
    return arno.class;
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
    QLog.d("TencentDocFormKeyWordsProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 569;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnq
 * JD-Core Version:    0.7.0.1
 */