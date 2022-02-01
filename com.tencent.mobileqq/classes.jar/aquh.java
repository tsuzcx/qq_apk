import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aquh
  extends aqkz<aqug>
{
  @NonNull
  public static aqug a()
  {
    aqug localaqug2 = (aqug)aqlk.a().a(550);
    aqug localaqug1 = localaqug2;
    if (localaqug2 == null) {
      localaqug1 = new aqug();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localaqug1.toString());
    }
    return localaqug1;
  }
  
  @NonNull
  public aqug a(int paramInt)
  {
    return new aqug();
  }
  
  @Nullable
  public aqug a(aqlg[] paramArrayOfaqlg)
  {
    return aqug.a(paramArrayOfaqlg);
  }
  
  public void a(aqug paramaqug)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((awvy)((QQAppInterface)localObject).getManager(347)).a = paramaqug;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramaqug.toString());
        }
      }
    }
  }
  
  public Class clazz()
  {
    return aqug.class;
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
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aquh
 * JD-Core Version:    0.7.0.1
 */