package com.tencent.biz.pubaccount.util;

import android.os.Bundle;
import android.text.TextUtils;
import azgl;
import azgm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import rtw;

public final class PublicAccountUtil$19
  implements Runnable
{
  public PublicAccountUtil$19(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
        break label377;
      }
      localObject1 = (QQAppInterface)localObject1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      String str;
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:request Exception " + localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (QLog.isColorLevel())
      {
        QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:request OutOfMemoryError " + localOutOfMemoryError);
        return;
        label377:
        Object localObject2 = null;
      }
    }
    if (localObject1 != null)
    {
      localObject3 = ((AppInterface)localObject1).getCurrentAccountUin();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = (TicketManager)((AppInterface)localObject1).getManager(2);
        if (localObject1 != null)
        {
          localObject4 = ((TicketManager)localObject1).getSkey((String)localObject3);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject1 = new Bundle();
            str = String.format("http://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d&rowkey=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_b_of_type_JavaLangString });
            ((Bundle)localObject1).putString("Cookie", "uin=" + (String)localObject3 + "; skey=" + (String)localObject4);
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("BUNDLE", localObject1);
            ((HashMap)localObject3).put("CONTEXT", BaseApplicationImpl.getApplication());
            localObject4 = new rtw(this);
            localObject1 = str;
            if (this.jdField_a_of_type_Int == 1) {
              localObject1 = str + "&rcode=" + Integer.toString(this.jdField_b_of_type_Int);
            }
            if (QLog.isColorLevel()) {
              QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport cgiUrl=" + (String)localObject1);
            }
            new azgm((String)localObject1, "GET", (azgl)localObject4, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject3 });
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.19
 * JD-Core Version:    0.7.0.1
 */