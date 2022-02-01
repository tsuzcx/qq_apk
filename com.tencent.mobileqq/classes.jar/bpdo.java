import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;

public class bpdo
  extends arac<AEEditorEffectGroupListBean>
{
  @NonNull
  public AEEditorEffectGroupListBean a(int paramInt)
  {
    return new AEEditorEffectGroupListBean();
  }
  
  @Nullable
  public AEEditorEffectGroupListBean a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      paramArrayOfaraj = AEEditorEffectGroupListBean.parse(paramArrayOfaraj[0].a);
      bpam.a("AEEditorFilterConfigProcessor", "effect group list version: " + paramArrayOfaraj.version);
      return paramArrayOfaraj;
    }
    bpam.a("AEEditorFilterConfigProcessor", "confFiles is empty");
    return null;
  }
  
  public void a()
  {
    aran.a().a(new int[] { 643 });
    bpam.a("AEEditorFilterConfigProcessor", "getConfigData.");
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    bpam.a("AEEditorFilterConfigProcessor", "onUpdate");
    bpdm.a().a(paramAEEditorEffectGroupListBean);
  }
  
  public Class<AEEditorEffectGroupListBean> clazz()
  {
    return AEEditorEffectGroupListBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    bpam.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
    return true;
  }
  
  public int migrateOldVersion()
  {
    bpam.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    bpam.a("AEEditorFilterConfigProcessor", "onReqFailed");
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    bpam.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
  }
  
  public int onSend(int paramInt)
  {
    try
    {
      if (bpdr.a(bpdm.a()) == null)
      {
        aran.a().a(643, 0);
        return 0;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 643;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdo
 * JD-Core Version:    0.7.0.1
 */