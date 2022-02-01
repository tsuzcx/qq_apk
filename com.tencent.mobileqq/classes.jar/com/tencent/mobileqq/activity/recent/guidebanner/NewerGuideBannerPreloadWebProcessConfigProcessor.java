package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NewerGuideBannerPreloadWebProcessConfigProcessor
  extends IQConfigProcessor<NewerGuideBannerPreloadWebProcessConfigProcessor.Config>
{
  public static final NewerGuideBannerPreloadWebProcessConfigProcessor.Companion a = new NewerGuideBannerPreloadWebProcessConfigProcessor.Companion(null);
  
  @NotNull
  public NewerGuideBannerPreloadWebProcessConfigProcessor.Config a(int paramInt)
  {
    return new NewerGuideBannerPreloadWebProcessConfigProcessor.Config();
  }
  
  @Nullable
  public NewerGuideBannerPreloadWebProcessConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewerBannerGuidePreloadWebProcessConfigProcessor", 2, "onParsed");
    }
    NewerGuideBannerPreloadWebProcessConfigProcessor.Config localConfig = new NewerGuideBannerPreloadWebProcessConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
      return localConfig;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable NewerGuideBannerPreloadWebProcessConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<NewerGuideBannerPreloadWebProcessConfigProcessor.Config> clazz()
  {
    return NewerGuideBannerPreloadWebProcessConfigProcessor.Config.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 699;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor
 * JD-Core Version:    0.7.0.1
 */