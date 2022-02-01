import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.transfile.quic.QuicNetResMgr;
import com.tencent.qphone.base.util.QLog;

public class aqbp
  extends aptq<aqbq>
{
  public static aqbq a()
  {
    return (aqbq)apub.a().a(685);
  }
  
  @NonNull
  public aqbq a(int paramInt)
  {
    return new aqbq();
  }
  
  @Nullable
  public aqbq a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqbq.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqbq paramaqbq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoQuicNetProcessor", 2, "QQShortVideoQuicNetProcessor onUpdate");
    }
    QuicNetResMgr.getInstance().downloadQuicRes(paramaqbq);
  }
  
  public Class<aqbq> clazz()
  {
    return aqbq.class;
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
    return 685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbp
 * JD-Core Version:    0.7.0.1
 */