package com.tencent.biz.pubaccount.qqnews;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/qqnews/QQNewsConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/biz/pubaccount/qqnews/QQNewsConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/biz/pubaccount/qqnews/QQNewsConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQNewsConfigProcessor
  extends IQConfigProcessor<QQNewsConfigProcessor.Config>
{
  public static final QQNewsConfigProcessor.Companion a = new QQNewsConfigProcessor.Companion(null);
  
  @NotNull
  public QQNewsConfigProcessor.Config a(int paramInt)
  {
    return new QQNewsConfigProcessor.Config();
  }
  
  @Nullable
  public QQNewsConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQNewsConfigProcessor", 2, "onParsed");
    }
    QQNewsConfigProcessor.Config localConfig = new QQNewsConfigProcessor.Config();
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
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
    }
    return localConfig;
  }
  
  public void a(@Nullable QQNewsConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<QQNewsConfigProcessor.Config> clazz()
  {
    return QQNewsConfigProcessor.Config.class;
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
    return 729;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */