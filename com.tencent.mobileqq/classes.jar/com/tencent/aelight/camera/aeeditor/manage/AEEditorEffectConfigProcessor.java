package com.tencent.aelight.camera.aeeditor.manage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class AEEditorEffectConfigProcessor
  extends IQConfigProcessor<AEEditorEffectGroupListBean>
{
  @NonNull
  public AEEditorEffectGroupListBean a(int paramInt)
  {
    return new AEEditorEffectGroupListBean();
  }
  
  @Nullable
  public AEEditorEffectGroupListBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i = paramArrayOfQConfItem.length - 1;
      if (paramArrayOfQConfItem[i] != null)
      {
        paramArrayOfQConfItem = AEEditorEffectGroupListBean.parse(paramArrayOfQConfItem[i].a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("effect group list version: ");
        localStringBuilder.append(paramArrayOfQConfItem.version);
        AEQLog.a("AEEditorFilterConfigProcessor", localStringBuilder.toString());
        return paramArrayOfQConfItem;
      }
    }
    else
    {
      AEQLog.a("AEEditorFilterConfigProcessor", "confFiles is empty");
    }
    return null;
  }
  
  public void a()
  {
    QConfigManager.a().a(new int[] { 643 });
    AEQLog.a("AEEditorFilterConfigProcessor", "getConfigData.");
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    AEQLog.a("AEEditorFilterConfigProcessor", "onUpdate");
    AEEditorEffectConfigManager.a().a(paramAEEditorEffectGroupListBean);
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
    AEQLog.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
    return true;
  }
  
  public int migrateOldVersion()
  {
    AEQLog.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    AEQLog.a("AEEditorFilterConfigProcessor", "onReqFailed");
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    AEQLog.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
  }
  
  public int onSend(int paramInt)
  {
    try
    {
      if (AEEditorEffectUtils.a(AEEditorEffectConfigManager.a()) == null)
      {
        QConfigManager.a().a(643, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigProcessor
 * JD-Core Version:    0.7.0.1
 */