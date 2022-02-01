package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IStickerRecManager
  extends IRuntimeService
{
  public abstract boolean analyzeFromQzone(String paramString1, int paramInt, String paramString2);
  
  public abstract void clearOverdueStickerCache();
  
  public abstract void deletePicCache();
  
  public abstract String getCurrentText();
  
  public abstract int getUserConfigVersion(AppInterface paramAppInterface);
  
  public abstract void handleRecommendedStickerConfig(AppInterface paramAppInterface, ConfigurationService.Config paramConfig, int paramInt);
  
  public abstract void init();
  
  public abstract boolean isEmotionRecSettingOpen();
  
  public abstract void pullWords();
  
  public abstract void reportEvent(List<StickerReportItem> paramList, boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void setCurrentText(String paramString);
  
  public abstract void setImgUpdateListener(IStickerRecManager.ImgUpdateListener paramImgUpdateListener);
  
  public abstract void updateEmotionRecSetting(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
 * JD-Core Version:    0.7.0.1
 */