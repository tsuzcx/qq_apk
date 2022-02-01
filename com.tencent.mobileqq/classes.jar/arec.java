import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arec
  extends arac<areb>
{
  @NonNull
  public static areb a()
  {
    areb localareb2 = (areb)aran.a().a(455);
    areb localareb1 = localareb2;
    if (localareb2 == null) {
      localareb1 = new areb();
    }
    return localareb1;
  }
  
  @NonNull
  public areb a(int paramInt)
  {
    return new areb();
  }
  
  @Nullable
  public areb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      areb localareb = areb.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localareb;
    }
    return new areb();
  }
  
  public void a(areb paramareb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramareb);
    }
  }
  
  public Class<areb> clazz()
  {
    return areb.class;
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
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */