package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.Iterator;
import java.util.List;

class MessageShareActivity$1
  implements Runnable
{
  MessageShareActivity$1(MessageShareActivity paramMessageShareActivity, List paramList, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, localResultRecord.uin, localResultRecord.getUinType(), null, 0);
      continue;
      StructMsgForImageShare.sendAndUploadImageShare(this.this$0.app, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity.1
 * JD-Core Version:    0.7.0.1
 */