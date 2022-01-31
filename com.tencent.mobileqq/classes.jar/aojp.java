import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojp
  extends aofy<aojo>
{
  public int a()
  {
    return 492;
  }
  
  @NonNull
  public aojo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aojo();
  }
  
  @Nullable
  public aojo a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aojo localaojo = aojo.a(paramArrayOfaogf[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaojo;
    }
    return new aojo();
  }
  
  public Class<aojo> a()
  {
    return aojo.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(aojo paramaojo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramaojo);
    }
  }
  
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aojp
 * JD-Core Version:    0.7.0.1
 */