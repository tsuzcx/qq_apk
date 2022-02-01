import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arnh
  extends aptq<arnp>
{
  public static arnp a()
  {
    return (arnp)apub.a().a(532);
  }
  
  @NonNull
  public arnp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arnp();
  }
  
  @Nullable
  public arnp a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return arnp.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(arnp paramarnp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarnp == null) {
        break label73;
      }
    }
    label73:
    for (paramarnp = paramarnp.toString();; paramarnp = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramarnp);
      paramarnp = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramarnp instanceof QQAppInterface)) {
        ((arhi)((QQAppInterface)paramarnp).getManager(264)).c();
      }
      return;
    }
  }
  
  public Class<arnp> clazz()
  {
    return arnp.class;
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
 * Qualified Name:     arnh
 * JD-Core Version:    0.7.0.1
 */