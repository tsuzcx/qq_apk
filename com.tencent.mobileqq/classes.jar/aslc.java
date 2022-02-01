import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aslc
  extends aqkz<aslk>
{
  public static aslk a()
  {
    return (aslk)aqlk.a().a(532);
  }
  
  @NonNull
  public aslk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aslk();
  }
  
  @Nullable
  public aslk a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
      }
      return aslk.a(paramArrayOfaqlg[0]);
    }
    return null;
  }
  
  public void a(aslk paramaslk)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaslk == null) {
        break label73;
      }
    }
    label73:
    for (paramaslk = paramaslk.toString();; paramaslk = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramaslk);
      paramaslk = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramaslk instanceof QQAppInterface)) {
        ((asfu)((QQAppInterface)paramaslk).getManager(264)).c();
      }
      return;
    }
  }
  
  public Class<aslk> clazz()
  {
    return aslk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 532;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslc
 * JD-Core Version:    0.7.0.1
 */