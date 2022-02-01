package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "qq-newer-guide_release"}, k=1, mv={1, 1, 16})
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
    if (QLog.isColorLevel()) {
      QLog.d("NewerBannerGuidePreloadWebProcessConfigProcessor", 2, "onParsed");
    }
    NewerGuideBannerPreloadWebProcessConfigProcessor.Config localConfig = new NewerGuideBannerPreloadWebProcessConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
    }
    return localConfig;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor
 * JD-Core Version:    0.7.0.1
 */