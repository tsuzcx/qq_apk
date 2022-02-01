import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;

public class bmey
  extends aptq<AEEditorEffectGroupListBean>
{
  @NonNull
  public AEEditorEffectGroupListBean a(int paramInt)
  {
    return new AEEditorEffectGroupListBean();
  }
  
  @Nullable
  public AEEditorEffectGroupListBean a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      paramArrayOfaptx = AEEditorEffectGroupListBean.parse(paramArrayOfaptx[0].a);
      bmbx.a("AEEditorFilterConfigProcessor", "effect group list version: " + paramArrayOfaptx.version);
      return paramArrayOfaptx;
    }
    bmbx.a("AEEditorFilterConfigProcessor", "confFiles is empty");
    return null;
  }
  
  public void a()
  {
    apub.a().a(new int[] { 643 });
    bmbx.a("AEEditorFilterConfigProcessor", "getConfigData.");
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    bmbx.a("AEEditorFilterConfigProcessor", "onUpdate");
    bmew.a().a(paramAEEditorEffectGroupListBean);
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
    bmbx.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
    return true;
  }
  
  public int migrateOldVersion()
  {
    bmbx.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    bmbx.a("AEEditorFilterConfigProcessor", "onReqFailed");
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    bmbx.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
  }
  
  public int onSend(int paramInt)
  {
    try
    {
      if (bmfb.a(bmew.a()) == null)
      {
        apub.a().a(643, 0);
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
 * Qualified Name:     bmey
 * JD-Core Version:    0.7.0.1
 */