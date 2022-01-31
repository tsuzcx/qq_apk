import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class amsz
  extends ampa<amsy>
{
  public static amsy a()
  {
    return (amsy)ampl.a().a(446);
  }
  
  public int a()
  {
    return 446;
  }
  
  @NonNull
  public amsy a(int paramInt)
  {
    return new amsy();
  }
  
  @Nullable
  public amsy a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return amsy.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amsy> a()
  {
    return amsy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsy paramamsy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramamsy.toString());
    }
    paramamsy = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramamsy instanceof QQAppInterface))
    {
      paramamsy = (MiniAppEntryHandler)((QQAppInterface)paramamsy).a(149);
      if (paramamsy != null) {
        paramamsy.notifyUI(0, true, null);
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
 * Qualified Name:     amsz
 * JD-Core Version:    0.7.0.1
 */