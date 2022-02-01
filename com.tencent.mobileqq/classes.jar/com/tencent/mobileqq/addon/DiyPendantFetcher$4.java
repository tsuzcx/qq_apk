package com.tencent.mobileqq.addon;

import amks;
import android.graphics.Typeface;
import bhcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import ga;
import mqq.app.AppRuntime;

public class DiyPendantFetcher$4
  implements Runnable
{
  public DiyPendantFetcher$4(amks paramamks, int paramInt, String paramString) {}
  
  public void run()
  {
    if (bhcs.a(String.valueOf(this.jdField_a_of_type_Int))) {
      if (this.jdField_a_of_type_Int == 1) {}
    }
    AppRuntime localAppRuntime;
    do
    {
      try
      {
        ((ga)this.this$0.b.get(Integer.valueOf(this.jdField_a_of_type_Int))).a = Typeface.createFromFile(this.jdField_a_of_type_JavaLangString);
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
    ((VasQuickUpdateManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(4L, "faceAddon.stickerFont.android." + this.jdField_a_of_type_Int, "DiyPendantFetcher");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.4
 * JD-Core Version:    0.7.0.1
 */