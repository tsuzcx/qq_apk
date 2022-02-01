import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class argt
  extends aqwt<args>
{
  @NonNull
  public static args a()
  {
    args localargs2 = (args)aqxe.a().a(550);
    args localargs1 = localargs2;
    if (localargs2 == null) {
      localargs1 = new args();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localargs1.toString());
    }
    return localargs1;
  }
  
  @NonNull
  public args a(int paramInt)
  {
    return new args();
  }
  
  @Nullable
  public args a(aqxa[] paramArrayOfaqxa)
  {
    return args.a(paramArrayOfaqxa);
  }
  
  public void a(args paramargs)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isCreateManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER))
      {
        ((axia)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER)).a = paramargs;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramargs.toString());
        }
      }
    }
  }
  
  public Class clazz()
  {
    return args.class;
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
 * Qualified Name:     argt
 * JD-Core Version:    0.7.0.1
 */