import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojh
  extends aofy<aojg>
{
  @NonNull
  public static aojg a()
  {
    aojg localaojg2 = (aojg)aogj.a().a(455);
    aojg localaojg1 = localaojg2;
    if (localaojg2 == null) {
      localaojg1 = new aojg();
    }
    return localaojg1;
  }
  
  public int a()
  {
    return 455;
  }
  
  @NonNull
  public aojg a(int paramInt)
  {
    return new aojg();
  }
  
  @Nullable
  public aojg a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aojg localaojg = aojg.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaojg;
    }
    return new aojg();
  }
  
  public Class<aojg> a()
  {
    return aojg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(aojg paramaojg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramaojg);
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
 * Qualified Name:     aojh
 * JD-Core Version:    0.7.0.1
 */