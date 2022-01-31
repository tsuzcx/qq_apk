import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class answ
  extends alzl<antd>
{
  public static antd a()
  {
    return (antd)alzw.a().a(532);
  }
  
  public int a()
  {
    return 532;
  }
  
  @NonNull
  public antd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new antd();
  }
  
  @Nullable
  public antd a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return antd.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<antd> a()
  {
    return antd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(antd paramantd)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramantd == null) {
        break label43;
      }
    }
    label43:
    for (paramantd = paramantd.toString();; paramantd = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramantd);
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
 * Qualified Name:     answ
 * JD-Core Version:    0.7.0.1
 */