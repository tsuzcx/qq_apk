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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(SubscribeDraftManager.a(this.this$0));
    ((StringBuilder)localObject1).append(Md5Utils.getMD5(this.a));
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      Object localObject2 = SubscribeDraftManager.a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("qureyAllSimpleDraft count:");
      ((StringBuilder)localObject3).append(localObject1.length);
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
      localObject2 = new ArrayList();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = localObject1[i];
        try
        {
          localObject3 = SubscribeDraftManager.a(this.this$0, ((File)localObject3).getAbsolutePath());
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label192;
          }
          localObject3 = (SubscribeDraftBean)JsonBinder.a().a((String)localObject3, SubscribeDraftBean.class);
          if (localObject3 == null) {
            break label192;
          }
          ((List)localObject2).add(localObject3);
        }
        catch (Exception localException)
        {
          label183:
          label192:
          break label183;
        }
        QLog.d(SubscribeDraftManager.a, 4, "readString failed:");
        i += 1;
      }
      Collections.sort((List)localObject2);
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = this.b;
        if (localObject1 != null) {
          ((SubscribeDraftManager.SubDraftListener)localObject1).a(4, true, "", new Object[] { localObject2 });
        }
      }
      else
      {
        localObject1 = this.b;
        if (localObject1 != null) {
          ((SubscribeDraftManager.SubDraftListener)localObject1).a(4, false, "", null);
        }
      }
    }
    else
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((SubscribeDraftManager.SubDraftListener)localObject1).a(4, false, "", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.2
 * JD-Core Version:    0.7.0.1
 */