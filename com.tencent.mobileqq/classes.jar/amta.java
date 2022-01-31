import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class amta
  extends ampb<amsz>
{
  public static amsz a()
  {
    return (amsz)ampm.a().a(446);
  }
  
  public int a()
  {
    return 446;
  }
  
  @NonNull
  public amsz a(int paramInt)
  {
    return new amsz();
  }
  
  @Nullable
  public amsz a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return amsz.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amsz> a()
  {
    return amsz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsz paramamsz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramamsz.toString());
    }
    paramamsz = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramamsz instanceof QQAppInterface))
    {
      paramamsz = (MiniAppEntryHandler)((QQAppInterface)paramamsz).a(149);
      if (paramamsz != null) {
        paramamsz.notifyUI(0, true, null);
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
 * Qualified Name:     amta
 * JD-Core Version:    0.7.0.1
 */