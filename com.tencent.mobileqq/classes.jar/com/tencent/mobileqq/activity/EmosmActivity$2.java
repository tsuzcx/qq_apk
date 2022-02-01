package com.tencent.mobileqq.activity;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;

class EmosmActivity$2
  implements Runnable
{
  EmosmActivity$2(EmosmActivity paramEmosmActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2 = MobileQQ.sMobileQQ;
    Object localObject1 = null;
    localObject2 = ((MobileQQ)localObject2).waitAppRuntime(null);
    if ((localObject2 instanceof BaseQQAppInterface)) {
      localObject1 = (BaseQQAppInterface)localObject2;
    }
    if (localObject1 != null)
    {
      localObject1 = ((IEmoticonManagerService)((BaseQQAppInterface)localObject1).getRuntimeService(IEmoticonManagerService.class)).findEmoticonTabById(this.a);
      if ((localObject1 == null) || ((!((EmoticonTab)localObject1).aioHave) && (!((EmoticonTab)localObject1).kandianHave)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.SDCARD_EMOTICON_SAVE);
        ((StringBuilder)localObject1).append(this.a);
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = new File((String)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("del");
        localObject2 = new File(localStringBuilder.toString());
        if (((File)localObject1).renameTo((File)localObject2))
        {
          FileUtils.deleteDirectory(((File)localObject2).getAbsolutePath());
          return;
        }
        FileUtils.deleteDirectory(((File)localObject1).getAbsolutePath());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.2
 * JD-Core Version:    0.7.0.1
 */