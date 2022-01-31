import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class amld
  extends alzl<amlc>
{
  public static amlc a()
  {
    return (amlc)alzw.a().a(327);
  }
  
  public int a()
  {
    return 327;
  }
  
  @NonNull
  public amlc a(int paramInt)
  {
    return new amlc();
  }
  
  @Nullable
  public amlc a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amlc.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amlc> a()
  {
    return amlc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amlc paramamlc)
  {
    if (paramamlc == null) {}
    Object localObject;
    do
    {
      return;
      localObject = apck.a(paramamlc.e());
      String str = bach.a(apck.d(paramamlc.e()));
      if ((str != null) && (str.equalsIgnoreCase((String)localObject)))
      {
        QLog.i("TencentDocBannerProcessor", 1, "pic check is OK!");
        return;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    ((apbv)((AppRuntime)localObject).getManager(281)).a(paramamlc);
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
 * Qualified Name:     amld
 * JD-Core Version:    0.7.0.1
 */