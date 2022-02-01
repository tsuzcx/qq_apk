import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class areu
  extends aqwt<arex>
{
  @NonNull
  public arex a(int paramInt)
  {
    return new arex();
  }
  
  @Nullable
  public arex a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arex.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arex paramarex)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramarex != null) {
      arex.a(paramarex);
    }
    asjb.a().a();
  }
  
  public Class<arex> clazz()
  {
    return arex.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 545;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */