import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.transfile.quic.QuicNetResMgr;
import com.tencent.qphone.base.util.QLog;

public class ares
  extends aqwt<aret>
{
  public static aret a()
  {
    return (aret)aqxe.a().a(685);
  }
  
  @NonNull
  public aret a(int paramInt)
  {
    return new aret();
  }
  
  @Nullable
  public aret a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aret.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aret paramaret)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQShortVideoQuicNetProcessor", 2, "QQShortVideoQuicNetProcessor onUpdate");
    }
    QuicNetResMgr.getInstance().downloadQuicRes(paramaret);
  }
  
  public Class<aret> clazz()
  {
    return aret.class;
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
 * Qualified Name:     ares
 * JD-Core Version:    0.7.0.1
 */