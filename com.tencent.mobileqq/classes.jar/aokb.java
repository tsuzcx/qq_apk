import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class aokb
  extends aofy<aoka>
{
  public static aoka a()
  {
    return (aoka)aogj.a().a(446);
  }
  
  public int a()
  {
    return 446;
  }
  
  @NonNull
  public aoka a(int paramInt)
  {
    return new aoka();
  }
  
  @Nullable
  public aoka a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aoka.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aoka> a()
  {
    return aoka.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoka paramaoka)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramaoka.toString());
    }
    paramaoka = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaoka instanceof QQAppInterface))
    {
      paramaoka = (MiniAppEntryHandler)((QQAppInterface)paramaoka).a(149);
      if (paramaoka != null) {
        paramaoka.notifyUI(0, true, null);
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokb
 * JD-Core Version:    0.7.0.1
 */