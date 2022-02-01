import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqou
  extends aqkz<aqot>
{
  @NonNull
  public static aqot a()
  {
    aqot localaqot2 = (aqot)aqlk.a().a(455);
    aqot localaqot1 = localaqot2;
    if (localaqot2 == null) {
      localaqot1 = new aqot();
    }
    return localaqot1;
  }
  
  @NonNull
  public aqot a(int paramInt)
  {
    return new aqot();
  }
  
  @Nullable
  public aqot a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqot localaqot = aqot.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqot;
    }
    return new aqot();
  }
  
  public void a(aqot paramaqot)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramaqot);
    }
  }
  
  public Class<aqot> clazz()
  {
    return aqot.class;
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
 * Qualified Name:     aqou
 * JD-Core Version:    0.7.0.1
 */