import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxs
  extends aptq<apxr>
{
  @NonNull
  public static apxr a()
  {
    apxr localapxr2 = (apxr)apub.a().a(455);
    apxr localapxr1 = localapxr2;
    if (localapxr2 == null) {
      localapxr1 = new apxr();
    }
    return localapxr1;
  }
  
  @NonNull
  public apxr a(int paramInt)
  {
    return new apxr();
  }
  
  @Nullable
  public apxr a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apxr localapxr = apxr.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapxr;
    }
    return new apxr();
  }
  
  public void a(apxr paramapxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramapxr);
    }
  }
  
  public Class<apxr> clazz()
  {
    return apxr.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 455;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxs
 * JD-Core Version:    0.7.0.1
 */