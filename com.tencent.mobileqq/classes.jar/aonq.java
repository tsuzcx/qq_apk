import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aonq
  extends aokh<aonp>
{
  @NonNull
  public static aonp a()
  {
    aonp localaonp2 = (aonp)aoks.a().a(455);
    aonp localaonp1 = localaonp2;
    if (localaonp2 == null) {
      localaonp1 = new aonp();
    }
    return localaonp1;
  }
  
  public int a()
  {
    return 455;
  }
  
  @NonNull
  public aonp a(int paramInt)
  {
    return new aonp();
  }
  
  @Nullable
  public aonp a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aonp localaonp = aonp.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaonp;
    }
    return new aonp();
  }
  
  public Class<aonp> a()
  {
    return aonp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(aonp paramaonp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramaonp);
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
 * Qualified Name:     aonq
 * JD-Core Version:    0.7.0.1
 */