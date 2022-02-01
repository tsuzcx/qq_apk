import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apxu
  extends aptq<apxt>
{
  @NonNull
  public apxt a(int paramInt)
  {
    return new apxt();
  }
  
  @Nullable
  public apxt a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apxt localapxt = new apxt();
      localapxt.a = paramArrayOfaptx[0].a;
      return localapxt;
    }
    return null;
  }
  
  public void a(apxt paramapxt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    alnr localalnr = (alnr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramapxt != null) {}
    for (paramapxt = paramapxt.a;; paramapxt = null)
    {
      localalnr.d(paramapxt);
      return;
    }
  }
  
  public Class<apxt> clazz()
  {
    return apxt.class;
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
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    apxt localapxt = (apxt)apub.a().a(417);
    if (localapxt != null) {
      ((alnr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localapxt.a);
    }
  }
  
  public int type()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxu
 * JD-Core Version:    0.7.0.1
 */