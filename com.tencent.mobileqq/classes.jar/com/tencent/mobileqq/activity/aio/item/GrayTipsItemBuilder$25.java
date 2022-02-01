package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class GrayTipsItemBuilder$25
  implements Runnable
{
  GrayTipsItemBuilder$25(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, int paramInt, long paramLong, String paramString2) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject != null)
      {
        MessageRecord localMessageRecord = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        if ((localMessageRecord != null) && (!TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"), this.b)))
        {
          localMessageRecord.saveExtInfoToExtStr("sens_msg_original_text", this.b);
          ((QQMessageFacade)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, "extLong", Integer.valueOf(localMessageRecord.extLong));
          ((QQMessageFacade)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
          ((QQMessageFacade)localObject).a(localMessageRecord);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.25
 * JD-Core Version:    0.7.0.1
 */