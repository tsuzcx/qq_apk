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

class asjy
  implements auoq
{
  protected MessageForMixedMsg a;
  protected String a;
  protected ArrayList<MessageForText.AtTroopMemberInfo> a;
  protected Map<String, Integer> a;
  
  public asjy(MessageForMixedMsg paramMessageForMixedMsg, Map<String, Integer> paramMap, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
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
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    Object localObject;
    if (paramauor.jdField_b_of_type_Int == 0)
    {
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(i);
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        ((MessageForPic)localObject).md5 = paramauor.d;
        ((MessageForPic)localObject).uuid = paramauor.c;
        ((MessageForPic)localObject).size = paramauor.jdField_a_of_type_Long;
        ((MessageForPic)localObject).groupFileID = paramauor.jdField_b_of_type_Long;
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
            myb.a().a(localMessageRecord);
          }
        }
        asju.a(this.jdField_a_of_type_Asju, this.jdField_a_of_type_Asju.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new ErrorMessage(paramauor.jdField_b_of_type_Int, paramauor.jdField_a_of_type_JavaLangString);
        QLog.d("zivonchen", 2, "reqUploadMultiPics UiCallBack success result = " + paramauor + ", error = " + localObject);
      }
      return;
      asju.a(this.jdField_a_of_type_Asju, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "send Msg fail: " + paramauor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjy
 * JD-Core Version:    0.7.0.1
 */