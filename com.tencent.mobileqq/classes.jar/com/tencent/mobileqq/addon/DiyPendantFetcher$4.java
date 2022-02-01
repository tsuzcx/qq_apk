package com.tencent.mobileqq.addon;

import android.graphics.Typeface;
import com.etrump.mixlayout.FontInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import mqq.app.AppRuntime;

class DiyPendantFetcher$4
  implements Runnable
{
  DiyPendantFetcher$4(DiyPendantFetcher paramDiyPendantFetcher, int paramInt, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (AvatarPendantUtil.b(String.valueOf(this.a)))
    {
      if (this.a != 1)
      {
        try
        {
          ((FontInfo)this.this$0.e.get(Integer.valueOf(this.a))).d = Typeface.createFromFile(this.b);
        }
        catch (RuntimeException localRuntimeException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Typeface createFromFile Exception path:");
          localStringBuilder.append(this.b);
          localStringBuilder.append("  Message:");
          localStringBuilder.append(localRuntimeException.getMessage());
          QLog.e("DiyPendantFetcher", 1, localStringBuilder.toString());
        }
        this.this$0.e();
      }
    }
    else
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (IVasQuickUpdateService)((AppRuntime)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("faceAddon.stickerFont.android.");
        localStringBuilder.append(this.a);
        ((IVasQuickUpdateService)localObject).downloadItem(4L, localStringBuilder.toString(), "DiyPendantFetcher");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.4
 * JD-Core Version:    0.7.0.1
 */