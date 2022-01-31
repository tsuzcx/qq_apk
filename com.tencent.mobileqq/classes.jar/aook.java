import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class aook
  extends aokh<aooj>
{
  public static aooj a()
  {
    return (aooj)aoks.a().a(446);
  }
  
  public int a()
  {
    return 446;
  }
  
  @NonNull
  public aooj a(int paramInt)
  {
    return new aooj();
  }
  
  @Nullable
  public aooj a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aooj.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aooj> a()
  {
    return aooj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aooj paramaooj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramaooj.toString());
    }
    paramaooj = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaooj instanceof QQAppInterface))
    {
      paramaooj = (MiniAppEntryHandler)((QQAppInterface)paramaooj).a(149);
      if (paramaooj != null) {
        paramaooj.notifyUI(0, true, null);
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
 * Qualified Name:     aook
 * JD-Core Version:    0.7.0.1
 */