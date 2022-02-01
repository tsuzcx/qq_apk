import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ataz
  extends arac<atbh>
{
  public static atbh a()
  {
    return (atbh)aran.a().a(532);
  }
  
  @NonNull
  public atbh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new atbh();
  }
  
  @Nullable
  public atbh a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return atbh.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(atbh paramatbh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramatbh == null) {
        break label73;
      }
    }
    label73:
    for (paramatbh = paramatbh.toString();; paramatbh = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramatbh);
      paramatbh = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramatbh instanceof QQAppInterface)) {
        ((asvi)((QQAppInterface)paramatbh).getManager(264)).c();
      }
      return;
    }
  }
  
  public Class<atbh> clazz()
  {
    return atbh.class;
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
 * Qualified Name:     ataz
 * JD-Core Version:    0.7.0.1
 */