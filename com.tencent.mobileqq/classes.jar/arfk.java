import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfk
  extends aqwt<arfl>
{
  @NonNull
  public arfl a(int paramInt)
  {
    return new arfl();
  }
  
  @Nullable
  public arfl a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arfl localarfl = new arfl();
      localarfl.a(paramArrayOfaqxa);
      return localarfl;
    }
    return new arfl();
  }
  
  public void a(arfl paramarfl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<arfl> clazz()
  {
    return arfl.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return bhhr.O(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 368;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfk
 * JD-Core Version:    0.7.0.1
 */