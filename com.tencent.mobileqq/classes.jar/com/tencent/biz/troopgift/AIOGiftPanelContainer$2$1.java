package com.tencent.biz.troopgift;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AIOGiftPanelContainer$2$1
  extends TroopGiftCallback
{
  AIOGiftPanelContainer$2$1(AIOGiftPanelContainer.2 param2, TroopGiftManager paramTroopGiftManager, long paramLong, AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError() time =  ");
      localStringBuilder.append(System.currentTimeMillis() - this.b);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorMsg = ");
      localStringBuilder.append(paramString);
      QLog.d("AIOGiftPanelContainer", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = System.currentTimeMillis();
    int i = this.a.a(this.d.b);
    if (this.d.b == 5) {
      TroopGiftAioPanelData.a(paramString2);
    } else if ((this.d.b == 1) || (this.d.b == 6) || (this.d.b == 4)) {
      TroopGiftAioPanelData.a(paramString2, this.d.this$0.b.ah.c);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetExtraData() , configURL = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", serverVer=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", localVer=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", exIds=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("AIOGiftPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetExtraData, time=");
    ((StringBuilder)localObject).append(l - this.b);
    ((StringBuilder)localObject).append(", total=");
    ((StringBuilder)localObject).append(l - this.d.a);
    QLog.d("TroopGiftPanel.time", 1, ((StringBuilder)localObject).toString());
    this.d.this$0.f = TroopGiftAioPanelData.a(this.d.this$0.b.e, this.d.b, this.d.this$0.b.ah.c);
    if ((paramInt <= i) && (this.d.this$0.f != null))
    {
      AIOGiftPanelContainer.a(this.d.this$0, true);
      this.d.this$0.a(0);
      return;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      ((StringBuilder)localObject).append("troopGiftConfig.tmp");
      localObject = ((StringBuilder)localObject).toString();
      paramString1 = new DownloadTask(paramString1, new File((String)localObject));
      paramString1.e = 3;
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", (String)localObject);
      this.c.i().startDownload(paramString1, new AIOGiftPanelContainer.2.1.1(this, l, paramString2, paramInt), localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1
 * JD-Core Version:    0.7.0.1
 */