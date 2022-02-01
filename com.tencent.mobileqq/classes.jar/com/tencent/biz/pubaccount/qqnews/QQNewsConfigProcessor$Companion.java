package com.tencent.biz.pubaccount.qqnews;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/qqnews/QQNewsConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "enableOpenHippy", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQNewsConfigProcessor$Companion
{
  @JvmStatic
  public final boolean a()
  {
    QQNewsConfigProcessor.Config localConfig = (QQNewsConfigProcessor.Config)QConfigManager.a().a(729);
    if (localConfig != null) {
      return localConfig.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */