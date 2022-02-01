import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class arbu
  extends aqwt<arbt>
{
  public static arbt a()
  {
    return (arbt)aqxe.a().a(446);
  }
  
  @NonNull
  public arbt a(int paramInt)
  {
    return new arbt();
  }
  
  @Nullable
  public arbt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arbt.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arbt paramarbt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramarbt.toString());
    }
    paramarbt = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramarbt instanceof QQAppInterface))
    {
      paramarbt = (MiniAppEntryHandler)((QQAppInterface)paramarbt).getBusinessHandler(BusinessHandlerFactory.MINI_APP_ENTRY_HANDLER);
      if (paramarbt != null) {
        paramarbt.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<arbt> clazz()
  {
    return arbt.class;
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
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */