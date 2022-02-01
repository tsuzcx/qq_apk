import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;

public class bnuq
  extends aqwt<AEEditorEffectGroupListBean>
{
  @NonNull
  public AEEditorEffectGroupListBean a(int paramInt)
  {
    return new AEEditorEffectGroupListBean();
  }
  
  @Nullable
  public AEEditorEffectGroupListBean a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      paramArrayOfaqxa = AEEditorEffectGroupListBean.parse(paramArrayOfaqxa[0].a);
      bnrh.a("AEEditorFilterConfigProcessor", "effect group list version: " + paramArrayOfaqxa.version);
      return paramArrayOfaqxa;
    }
    bnrh.a("AEEditorFilterConfigProcessor", "confFiles is empty");
    return null;
  }
  
  public void a()
  {
    aqxe.a().a(new int[] { 643 });
    bnrh.a("AEEditorFilterConfigProcessor", "getConfigData.");
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    bnrh.a("AEEditorFilterConfigProcessor", "onUpdate");
    bnuo.a().a(paramAEEditorEffectGroupListBean);
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
    bnrh.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
    return true;
  }
  
  public int migrateOldVersion()
  {
    bnrh.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    bnrh.a("AEEditorFilterConfigProcessor", "onReqFailed");
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    bnrh.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
  }
  
  public int onSend(int paramInt)
  {
    try
    {
      if (bnut.a(bnuo.a()) == null)
      {
        aqxe.a().a(643, 0);
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
 * Qualified Name:     bnuq
 * JD-Core Version:    0.7.0.1
 */