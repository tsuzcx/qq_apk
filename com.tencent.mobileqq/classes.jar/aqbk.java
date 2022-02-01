import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.qphone.base.util.QLog;

public class aqbk
  extends aptq<QQComicConfBean>
{
  @NonNull
  public QQComicConfBean a(int paramInt)
  {
    return new QQComicConfBean();
  }
  
  @Nullable
  public QQComicConfBean a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onParsed");
    }
    return QQComicConfBean.a(paramArrayOfaptx);
  }
  
  public void a(QQComicConfBean paramQQComicConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramQQComicConfBean.toString());
    }
  }
  
  public Class<QQComicConfBean> clazz()
  {
    return QQComicConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 534;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbk
 * JD-Core Version:    0.7.0.1
 */