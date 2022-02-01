import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aren
  extends arac<arem>
{
  @NonNull
  public arem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arem();
  }
  
  @Nullable
  public arem a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arem localarem = arem.a(paramArrayOfaraj[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarem;
    }
    return new arem();
  }
  
  public void a(arem paramarem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramarem);
    }
  }
  
  public Class<arem> clazz()
  {
    return arem.class;
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
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 492;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aren
 * JD-Core Version:    0.7.0.1
 */