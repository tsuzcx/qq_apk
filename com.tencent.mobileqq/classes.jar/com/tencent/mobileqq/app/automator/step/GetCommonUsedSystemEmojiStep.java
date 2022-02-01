package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GetCommonUsedSystemEmojiStep
  extends AsyncStep
{
  protected int doStep()
  {
    SharedPreferences localSharedPreferences = this.mAutomator.a.getApp().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
    long l = localSharedPreferences.getLong("lastRequestTime", 0L);
    IEmoticonHandler localIEmoticonHandler = (IEmoticonHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("commonusedSystemEmojiInfoFile_v2_");
    ((StringBuilder)localObject).append(this.mAutomator.a.getCurrentAccountUin());
    localFile = new File(localFile, ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.sApplication.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commonusedSystemEmojiInfoFile_v3_");
    localStringBuilder.append(this.mAutomator.a.getCurrentAccountUin());
    localObject = new File((File)localObject, localStringBuilder.toString());
    if ((!localFile.exists()) && (!((File)localObject).exists()))
    {
      QLog.d("QQInitHandler", 1, "GetCommonUsedSystemEmojiStep file and fileV2  not exsist");
      localIEmoticonHandler.b();
      localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
      return 7;
    }
    if ((localFile.exists()) && (!((File)localObject).exists())) {
      ((ICommonUsedSystemEmojiManagerService)this.mAutomator.a.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).copySystemEmojiFileToFileV2(localFile, (File)localObject);
    }
    if ((System.currentTimeMillis() - l <= 43200000L) && (System.currentTimeMillis() - l >= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep updateCacheFromFile");
      }
      ((ICommonUsedSystemEmojiManagerService)this.mAutomator.a.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getLocalSystemEmojiInfoFromFile();
      return 7;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetCommonUsedSystemEmojiStep send req");
    }
    localIEmoticonHandler.b();
    localSharedPreferences.edit().putLong("lastRequestTime", System.currentTimeMillis()).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep
 * JD-Core Version:    0.7.0.1
 */