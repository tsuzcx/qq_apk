package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.JsonBinder;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SubscribeDraftManager$2
  implements Runnable
{
  SubscribeDraftManager$2(SubscribeDraftManager paramSubscribeDraftManager, String paramString, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Object localObject1 = new File(SubscribeDraftManager.a(this.this$0) + Md5Utils.getMD5(this.jdField_a_of_type_JavaLangString));
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      QLog.d(SubscribeDraftManager.jdField_a_of_type_JavaLangString, 4, "qureyAllSimpleDraft count:" + localObject1.length);
      localArrayList = new ArrayList();
      j = localObject1.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label181;
        }
        localObject2 = localObject1[i];
        try
        {
          localObject2 = SubscribeDraftManager.a(this.this$0, ((File)localObject2).getAbsolutePath());
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = (SubscribeDraftBean)JsonBinder.a().a((String)localObject2, SubscribeDraftBean.class);
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(SubscribeDraftManager.jdField_a_of_type_JavaLangString, 4, "readString failed:");
          }
        }
        i += 1;
      }
      label181:
      Collections.sort(localArrayList);
      if (!localArrayList.isEmpty()) {
        if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(4, true, "", new Object[] { localArrayList });
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener == null)
    {
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject2;
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener == null);
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(4, false, "", null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(4, false, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.2
 * JD-Core Version:    0.7.0.1
 */