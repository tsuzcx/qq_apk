package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import svx;
import ymb;
import ymf;

public class SubscribeDraftManager$2
  implements Runnable
{
  public SubscribeDraftManager$2(ymb paramymb, String paramString, ymf paramymf) {}
  
  public void run()
  {
    Object localObject1 = new File(ymb.a(this.this$0) + Md5Utils.getMD5(this.jdField_a_of_type_JavaLangString));
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      QLog.d(ymb.jdField_a_of_type_JavaLangString, 4, "qureyAllSimpleDraft count:" + localObject1.length);
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
          localObject2 = ymb.a(this.this$0, ((File)localObject2).getAbsolutePath());
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = (SubscribeDraftBean)svx.a().a((String)localObject2, SubscribeDraftBean.class);
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(ymb.jdField_a_of_type_JavaLangString, 4, "readString failed:");
          }
        }
        i += 1;
      }
      label181:
      Collections.sort(localArrayList);
      if (!localArrayList.isEmpty()) {
        if (this.jdField_a_of_type_Ymf != null) {
          this.jdField_a_of_type_Ymf.a(4, true, "", new Object[] { localArrayList });
        }
      }
    }
    while (this.jdField_a_of_type_Ymf == null)
    {
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject2;
      do
      {
        return;
      } while (this.jdField_a_of_type_Ymf == null);
      this.jdField_a_of_type_Ymf.a(4, false, "", null);
      return;
    }
    this.jdField_a_of_type_Ymf.a(4, false, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.2
 * JD-Core Version:    0.7.0.1
 */