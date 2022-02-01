import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argt
  extends arac<args>
{
  @NonNull
  public args a(int paramInt)
  {
    return new args();
  }
  
  @Nullable
  public args a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      args localargs = args.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localargs;
    }
    return null;
  }
  
  public void a(args paramargs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramargs.toString());
    }
  }
  
  public Class<args> clazz()
  {
    return args.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argt
 * JD-Core Version:    0.7.0.1
 */