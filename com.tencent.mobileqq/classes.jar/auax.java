import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

class auax
  implements awfy
{
  protected MessageForMixedMsg a;
  protected String a;
  protected ArrayList<MessageForText.AtTroopMemberInfo> a;
  protected Map<String, Integer> a;
  
  public auax(MessageForMixedMsg paramMessageForMixedMsg, Map<String, Integer> paramMap, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = paramMap;
    this.jdField_a_of_type_JavaUtilMap = paramString;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).intValue();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(i);
    if ((localMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)localMessageRecord).richText = paramRichText;
    }
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    Object localObject;
    if (paramawfz.jdField_b_of_type_Int == 0)
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(i);
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        ((MessageForPic)localObject).md5 = paramawfz.d;
        ((MessageForPic)localObject).uuid = paramawfz.c;
        ((MessageForPic)localObject).size = paramawfz.jdField_a_of_type_Long;
        ((MessageForPic)localObject).groupFileID = paramawfz.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.prewrite();
      }
      if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
      {
        localObject = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList.get(0);
        if ((localObject instanceof MessageForText))
        {
          localObject = (MessageForText)localObject;
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (((MessageForText)localObject).atInfoList == null)) {
            ((MessageForText)localObject).atInfoList = this.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            nav.a().a(localMessageRecord);
          }
        }
        auat.a(this.jdField_a_of_type_Auat, this.jdField_a_of_type_Auat.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new ErrorMessage(paramawfz.jdField_b_of_type_Int, paramawfz.jdField_a_of_type_JavaLangString);
        QLog.d("zivonchen", 2, "reqUploadMultiPics UiCallBack success result = " + paramawfz + ", error = " + localObject);
      }
      return;
      auat.a(this.jdField_a_of_type_Auat, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "send Msg fail: " + paramawfz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auax
 * JD-Core Version:    0.7.0.1
 */