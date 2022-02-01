import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aquj
  extends aqkz<aqui>
{
  @NonNull
  public static aqui a()
  {
    aqui localaqui2 = (aqui)aqlk.a().a(435);
    aqui localaqui1 = localaqui2;
    if (localaqui2 == null) {
      localaqui1 = new aqui();
    }
    return localaqui1;
  }
  
  @NonNull
  public aqui a(int paramInt)
  {
    return new aqui();
  }
  
  @Nullable
  public aqui a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = aqui.a(paramArrayOfaqlg);
      }
    }
    return localObject1;
  }
  
  public void a(aqui paramaqui)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramaqui.toString());
    }
  }
  
  public Class<aqui> clazz()
  {
    return aqui.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aquj
 * JD-Core Version:    0.7.0.1
 */