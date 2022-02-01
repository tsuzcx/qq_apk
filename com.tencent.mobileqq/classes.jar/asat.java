import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class asat
  extends aqwt<asas>
{
  public static asas a()
  {
    return (asas)aqxe.a().a(692);
  }
  
  @NonNull
  public asas a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadConfigProcessor", 2, new Object[] { "[config] migrateOldOrDefaultContent: invoked. ", " type: ", Integer.valueOf(paramInt) });
    }
    return new asas();
  }
  
  @Nullable
  public asas a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("[UniteDownload] DownloadConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return asas.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(asas paramasas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadConfigProcessor", 2, new Object[] { "[config] onUpdate: invoked. ", " newConf: ", paramasas });
    }
  }
  
  public Class<asas> clazz()
  {
    return asas.class;
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
    return 692;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asat
 * JD-Core Version:    0.7.0.1
 */