import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class amcy
  extends alzl<amcx>
{
  public static amcx a()
  {
    return (amcx)alzw.a().a(446);
  }
  
  public int a()
  {
    return 446;
  }
  
  @NonNull
  public amcx a(int paramInt)
  {
    return new amcx();
  }
  
  @Nullable
  public amcx a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amcx.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amcx> a()
  {
    return amcx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amcx paramamcx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramamcx.toString());
    }
    paramamcx = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramamcx instanceof QQAppInterface))
    {
      paramamcx = (MiniAppEntryHandler)((QQAppInterface)paramamcx).a(149);
      if (paramamcx != null) {
        paramamcx.notifyUI(0, true, null);
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
 * Qualified Name:     amcy
 * JD-Core Version:    0.7.0.1
 */