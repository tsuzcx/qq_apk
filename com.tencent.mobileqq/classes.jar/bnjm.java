import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.cmshow.config.AECMShowConfig;

public class bnjm
  extends aqwt<AECMShowConfig>
{
  @NonNull
  public AECMShowConfig a(int paramInt)
  {
    bnrh.a("AECMShowQConfigProcessor", "[migrateOldOrDefaultContent]");
    return new AECMShowConfig();
  }
  
  @Nullable
  public AECMShowConfig a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      bnrh.a("AECMShowQConfigProcessor", "[onParsed] content=" + paramArrayOfaqxa[0].a);
      return bnji.a(paramArrayOfaqxa[0].a);
    }
    bnrh.a("AECMShowQConfigProcessor", "[onParsed] config invalid");
    return null;
  }
  
  public void a(AECMShowConfig paramAECMShowConfig)
  {
    bnrh.a("AECMShowQConfigProcessor", "[onUpdate]");
    bnji.a().a(paramAECMShowConfig);
  }
  
  public Class<AECMShowConfig> clazz()
  {
    return AECMShowConfig.class;
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
    bnrh.a("AECMShowQConfigProcessor", "[migrateOldVersion]");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    bnrh.a("AECMShowQConfigProcessor", "[onReqFailed], failCode=" + paramInt);
  }
  
  public int onSend(int paramInt)
  {
    bnrh.a("AECMShowQConfigProcessor", "[onSend], confVersion=" + paramInt);
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 700;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjm
 * JD-Core Version:    0.7.0.1
 */