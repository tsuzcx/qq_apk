import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class aqpt
  extends aqkz<aqps>
{
  public static aqps a()
  {
    return (aqps)aqlk.a().a(446);
  }
  
  @NonNull
  public aqps a(int paramInt)
  {
    return new aqps();
  }
  
  @Nullable
  public aqps a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqps.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqps paramaqps)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramaqps.toString());
    }
    paramaqps = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaqps instanceof QQAppInterface))
    {
      paramaqps = (MiniAppEntryHandler)((QQAppInterface)paramaqps).a(149);
      if (paramaqps != null) {
        paramaqps.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<aqps> clazz()
  {
    return aqps.class;
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
 * Qualified Name:     aqpt
 * JD-Core Version:    0.7.0.1
 */