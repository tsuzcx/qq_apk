import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsq
  extends ampb<amsp>
{
  public static amsp a()
  {
    amsp localamsp2 = (amsp)ampm.a().a(492);
    amsp localamsp1 = localamsp2;
    if (localamsp2 == null) {
      localamsp1 = new amsp();
    }
    return localamsp1;
  }
  
  public int a()
  {
    return 492;
  }
  
  @NonNull
  public amsp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amsp();
  }
  
  @Nullable
  public amsp a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amsp localamsp = amsp.a(paramArrayOfampi[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamsp;
    }
    return new amsp();
  }
  
  public Class<amsp> a()
  {
    return amsp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amsp paramamsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamsp);
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
 * Qualified Name:     amsq
 * JD-Core Version:    0.7.0.1
 */