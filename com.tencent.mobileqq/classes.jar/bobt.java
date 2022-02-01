import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;

public class bobt
  extends aqkz<AEEditorEffectGroupListBean>
{
  @NonNull
  public AEEditorEffectGroupListBean a(int paramInt)
  {
    return new AEEditorEffectGroupListBean();
  }
  
  @Nullable
  public AEEditorEffectGroupListBean a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      paramArrayOfaqlg = AEEditorEffectGroupListBean.parse(paramArrayOfaqlg[0].a);
      bnzb.a("AEEditorFilterConfigProcessor", "effect group list version: " + paramArrayOfaqlg.version);
      return paramArrayOfaqlg;
    }
    bnzb.a("AEEditorFilterConfigProcessor", "confFiles is empty");
    return null;
  }
  
  public void a()
  {
    aqlk.a().a(new int[] { 643 });
    bnzb.a("AEEditorFilterConfigProcessor", "getConfigData.");
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    bnzb.a("AEEditorFilterConfigProcessor", "onUpdate");
    bobr.a().a(paramAEEditorEffectGroupListBean);
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
    bnzb.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
    return true;
  }
  
  public int migrateOldVersion()
  {
    bnzb.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    bnzb.a("AEEditorFilterConfigProcessor", "onReqFailed");
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    bnzb.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
  }
  
  public int onSend(int paramInt)
  {
    try
    {
      if (bobw.a(bobr.a()) == null)
      {
        aqlk.a().a(643, 0);
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
 * Qualified Name:     bobt
 * JD-Core Version:    0.7.0.1
 */