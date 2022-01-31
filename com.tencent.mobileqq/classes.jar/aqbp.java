import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqbp
  extends aofy<aqbw>
{
  public static aqbw a()
  {
    return (aqbw)aogj.a().a(532);
  }
  
  public int a()
  {
    return 532;
  }
  
  @NonNull
  public aqbw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqbw();
  }
  
  @Nullable
  public aqbw a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aqbw.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aqbw> a()
  {
    return aqbw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aqbw paramaqbw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqbw == null) {
        break label73;
      }
    }
    label73:
    for (paramaqbw = paramaqbw.toString();; paramaqbw = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramaqbw);
      paramaqbw = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramaqbw instanceof QQAppInterface)) {
        ((apwx)((QQAppInterface)paramaqbw).getManager(264)).b();
      }
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbp
 * JD-Core Version:    0.7.0.1
 */