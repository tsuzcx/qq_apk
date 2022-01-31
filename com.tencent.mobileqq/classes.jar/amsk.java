import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsk
  extends ampb<amsj>
{
  @NonNull
  public static amsj a()
  {
    amsj localamsj2 = (amsj)ampm.a().a(455);
    amsj localamsj1 = localamsj2;
    if (localamsj2 == null) {
      localamsj1 = new amsj();
    }
    return localamsj1;
  }
  
  public int a()
  {
    return 455;
  }
  
  @NonNull
  public amsj a(int paramInt)
  {
    return new amsj();
  }
  
  @Nullable
  public amsj a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amsj localamsj = amsj.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamsj;
    }
    return new amsj();
  }
  
  public Class<amsj> a()
  {
    return amsj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amsj paramamsj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamsj);
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
 * Qualified Name:     amsk
 * JD-Core Version:    0.7.0.1
 */