import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbg
  extends aqwt<arbf>
{
  @NonNull
  public arbf a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arbf();
  }
  
  @Nullable
  public arbf a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arbf localarbf = arbf.a(paramArrayOfaqxa[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarbf;
    }
    return new arbf();
  }
  
  public void a(arbf paramarbf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramarbf);
    }
  }
  
  public Class<arbf> clazz()
  {
    return arbf.class;
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
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */