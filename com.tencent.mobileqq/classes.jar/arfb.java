import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class arfb
  extends arac<arfa>
{
  public static arfa a()
  {
    return (arfa)aran.a().a(446);
  }
  
  @NonNull
  public arfa a(int paramInt)
  {
    return new arfa();
  }
  
  @Nullable
  public arfa a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arfa.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arfa paramarfa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramarfa.toString());
    }
    paramarfa = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramarfa instanceof QQAppInterface))
    {
      paramarfa = (MiniAppEntryHandler)((QQAppInterface)paramarfa).a(149);
      if (paramarfa != null) {
        paramarfa.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<arfa> clazz()
  {
    return arfa.class;
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
 * Qualified Name:     arfb
 * JD-Core Version:    0.7.0.1
 */