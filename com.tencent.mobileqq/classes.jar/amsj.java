import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsj
  extends ampa<amsi>
{
  @NonNull
  public static amsi a()
  {
    amsi localamsi2 = (amsi)ampl.a().a(455);
    amsi localamsi1 = localamsi2;
    if (localamsi2 == null) {
      localamsi1 = new amsi();
    }
    return localamsi1;
  }
  
  public int a()
  {
    return 455;
  }
  
  @NonNull
  public amsi a(int paramInt)
  {
    return new amsi();
  }
  
  @Nullable
  public amsi a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amsi localamsi = amsi.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamsi;
    }
    return new amsi();
  }
  
  public Class<amsi> a()
  {
    return amsi.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amsi paramamsi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamsi);
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
 * Qualified Name:     amsj
 * JD-Core Version:    0.7.0.1
 */