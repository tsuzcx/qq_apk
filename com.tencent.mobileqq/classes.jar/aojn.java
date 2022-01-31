import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aojn
  extends ampa<aoju>
{
  public static aoju a()
  {
    return (aoju)ampl.a().a(532);
  }
  
  public int a()
  {
    return 532;
  }
  
  @NonNull
  public aoju a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aoju();
  }
  
  @Nullable
  public aoju a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return aoju.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<aoju> a()
  {
    return aoju.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoju paramaoju)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaoju == null) {
        break label73;
      }
    }
    label73:
    for (paramaoju = paramaoju.toString();; paramaoju = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramaoju);
      paramaoju = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramaoju instanceof QQAppInterface)) {
        ((aoeu)((QQAppInterface)paramaoju).getManager(264)).b();
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
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */