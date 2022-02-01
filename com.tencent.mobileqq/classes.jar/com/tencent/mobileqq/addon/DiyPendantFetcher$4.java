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
    if (AvatarPendantUtil.a(String.valueOf(this.jdField_a_of_type_Int))) {
      if (this.jdField_a_of_type_Int == 1) {}
    }
    AppRuntime localAppRuntime;
    do
    {
      try
      {
        ((FontInfo)this.this$0.b.get(Integer.valueOf(this.jdField_a_of_type_Int))).a = Typeface.createFromFile(this.jdField_a_of_type_JavaLangString);
        this.this$0.d();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          QLog.e("DiyPendantFetcher", 1, "Typeface createFromFile Exception path:" + this.jdField_a_of_type_JavaLangString + "  Message:" + localRuntimeException.getMessage());
        }
      }
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    ((IVasQuickUpdateService)localAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(4L, "faceAddon.stickerFont.android." + this.jdField_a_of_type_Int, "DiyPendantFetcher");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.4
 * JD-Core Version:    0.7.0.1
 */