import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class apyr
  extends aptq<apyq>
{
  public static apyq a()
  {
    return (apyq)apub.a().a(446);
  }
  
  @NonNull
  public apyq a(int paramInt)
  {
    return new apyq();
  }
  
  @Nullable
  public apyq a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apyq.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apyq paramapyq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramapyq.toString());
    }
    paramapyq = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramapyq instanceof QQAppInterface))
    {
      paramapyq = (MiniAppEntryHandler)((QQAppInterface)paramapyq).getBusinessHandler(149);
      if (paramapyq != null) {
        paramapyq.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<apyq> clazz()
  {
    return apyq.class;
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
    return 446;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyr
 * JD-Core Version:    0.7.0.1
 */