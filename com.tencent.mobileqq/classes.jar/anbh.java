import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class anbh
  extends ampb<anbg>
{
  public static anbg a()
  {
    return (anbg)ampm.a().a(327);
  }
  
  public int a()
  {
    return 327;
  }
  
  @NonNull
  public anbg a(int paramInt)
  {
    return new anbg();
  }
  
  @Nullable
  public anbg a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anbg.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anbg> a()
  {
    return anbg.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anbg paramanbg)
  {
    if (paramanbg == null) {}
    Object localObject;
    do
    {
      return;
      localObject = apue.a(paramanbg.e());
      String str = bbdm.a(apue.d(paramanbg.e()));
      if ((str != null) && (str.equalsIgnoreCase((String)localObject)))
      {
        QLog.i("TencentDocBannerProcessor", 1, "pic check is OK!");
        return;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    ((aptp)((AppRuntime)localObject).getManager(281)).a(paramanbg);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbh
 * JD-Core Version:    0.7.0.1
 */