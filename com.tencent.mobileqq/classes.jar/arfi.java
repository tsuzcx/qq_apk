import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfi
  extends aqwt<arfj>
{
  @NonNull
  public arfj a(int paramInt)
  {
    return new arfj();
  }
  
  @Nullable
  public arfj a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arfj localarfj = new arfj();
      localarfj.a(paramArrayOfaqxa);
      return localarfj;
    }
    return new arfj();
  }
  
  public void a(arfj paramarfj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<arfj> clazz()
  {
    return arfj.class;
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
      return bhhr.N(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 92;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfi
 * JD-Core Version:    0.7.0.1
 */