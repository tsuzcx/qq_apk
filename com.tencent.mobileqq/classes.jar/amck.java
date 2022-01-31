import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amck
  extends alzl<amcj>
{
  @NonNull
  public static amcj a()
  {
    amcj localamcj2 = (amcj)alzw.a().a(455);
    amcj localamcj1 = localamcj2;
    if (localamcj2 == null) {
      localamcj1 = new amcj();
    }
    return localamcj1;
  }
  
  public int a()
  {
    return 455;
  }
  
  @NonNull
  public amcj a(int paramInt)
  {
    return new amcj();
  }
  
  @Nullable
  public amcj a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amcj localamcj = amcj.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamcj;
    }
    return new amcj();
  }
  
  public Class<amcj> a()
  {
    return amcj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amcj paramamcj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamcj);
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
 * Qualified Name:     amck
 * JD-Core Version:    0.7.0.1
 */