import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arcc
  extends aqwt<arcb>
{
  private static arcb a;
  
  public static arcb a()
  {
    arcb localarcb2 = (arcb)aqxe.a().a(524);
    arcb localarcb1 = localarcb2;
    if (localarcb2 == null) {
      localarcb1 = arcb.a();
    }
    return localarcb1;
  }
  
  @NonNull
  public arcb a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = arcb.a();
    return a;
  }
  
  @Nullable
  public arcb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = arcb.a(paramArrayOfaqxa[0].a);
      a = null;
      return paramArrayOfaqxa;
    }
    return arcb.a();
  }
  
  public void a(arcb paramarcb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramarcb);
    }
  }
  
  public Class<arcb> clazz()
  {
    return arcb.class;
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
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcc
 * JD-Core Version:    0.7.0.1
 */