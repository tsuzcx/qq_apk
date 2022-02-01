package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;

class PublicAccountUtilImpl$16
  implements Runnable
{
  PublicAccountUtilImpl$16(PublicAccountUtilImpl paramPublicAccountUtilImpl, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    do
    {
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            return;
          }
          localObject2 = null;
          Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
          Object localObject1 = localObject2;
          if (localObject3 == null) {
            continue;
          }
          localObject1 = localObject2;
          if (!(localObject3 instanceof AppInterface)) {
            continue;
          }
          localObject1 = (AppInterface)localObject3;
          continue;
          localObject3 = ((AppInterface)localObject1).getCurrentAccountUin();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            return;
          }
          localObject1 = (TicketManager)((AppInterface)localObject1).getManager(2);
          if (localObject1 == null) {
            return;
          }
          Object localObject4 = ((TicketManager)localObject1).getSkey((String)localObject3);
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            return;
          }
          localObject1 = new Bundle();
          localObject2 = String.format("https://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d&rowkey=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_b_of_type_JavaLangString });
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uin=");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("; skey=");
          localStringBuilder.append((String)localObject4);
          ((Bundle)localObject1).putString("Cookie", localStringBuilder.toString());
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("BUNDLE", localObject1);
          ((HashMap)localObject3).put("CONTEXT", BaseApplicationImpl.getApplication());
          localObject4 = new PublicAccountUtilImpl.16.1(this);
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Int == 1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("&rcode=");
            ((StringBuilder)localObject1).append(Integer.toString(this.jdField_b_of_type_Int));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doVideoPlayRealtimeReport cgiUrl=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("PublicAccountUtil", 2, ((StringBuilder)localObject2).toString());
          }
          new HttpWebCgiAsyncTask2((String)localObject1, "GET", (HttpWebCgiAsyncTask.Callback)localObject4, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject3 });
          return;
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("videoPlayRealtimeReport:request OutOfMemoryError ");
          ((StringBuilder)localObject2).append(localOutOfMemoryError);
          QLog.w("PublicAccountUtil", 2, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("videoPlayRealtimeReport:request Exception ");
          ((StringBuilder)localObject2).append(localException);
          QLog.w("PublicAccountUtil", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
    } while (localException != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.16
 * JD-Core Version:    0.7.0.1
 */