import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoji
  extends ampb<aojp>
{
  public static aojp a()
  {
    return (aojp)ampm.a().a(532);
  }
  
  public int a()
  {
    return 532;
  }
  
  @NonNull
  public aojp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aojp();
  }
  
  @Nullable
  public aojp a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return aojp.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class<aojp> a()
  {
    return aojp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aojp paramaojp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaojp == null) {
        break label73;
      }
    }
    label73:
    for (paramaojp = paramaojp.toString();; paramaojp = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramaojp);
      paramaojp = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramaojp instanceof QQAppInterface)) {
        ((aoep)((QQAppInterface)paramaojp).getManager(264)).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoji
 * JD-Core Version:    0.7.0.1
 */