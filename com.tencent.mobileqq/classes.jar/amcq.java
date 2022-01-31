import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amcq
  extends alzl<amcp>
{
  public static amcp a()
  {
    amcp localamcp2 = (amcp)alzw.a().a(492);
    amcp localamcp1 = localamcp2;
    if (localamcp2 == null) {
      localamcp1 = new amcp();
    }
    return localamcp1;
  }
  
  public int a()
  {
    return 492;
  }
  
  @NonNull
  public amcp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amcp();
  }
  
  @Nullable
  public amcp a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amcp localamcp = amcp.a(paramArrayOfalzs[0]);
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamcp;
    }
    return new amcp();
  }
  
  public Class<amcp> a()
  {
    return amcp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amcp paramamcp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramamcp);
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
 * Qualified Name:     amcq
 * JD-Core Version:    0.7.0.1
 */