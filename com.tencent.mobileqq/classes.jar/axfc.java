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

public class axfc
  implements azrg
{
  protected MessageForMixedMsg a;
  protected String a;
  protected ArrayList<MessageForText.AtTroopMemberInfo> a;
  protected Map<String, List<Integer>> a;
  
  public axfc(MessageForMixedMsg paramMessageForMixedMsg, Map<String, List<Integer>> paramMap, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg = paramMap;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.jdField_a_of_type_JavaUtilMap = paramString;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    Object localObject;
    if ((paramMessageForMixedMsg.msgElemList.get(0) instanceof MessageForText))
    {
      localObject = (MessageForText)paramMessageForMixedMsg.msgElemList.get(0);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (((MessageForText)localObject).atInfoList == null)) {
        ((MessageForText)localObject).atInfoList = this.jdField_a_of_type_JavaUtilArrayList;
      }
    }
    if (paramMessageForMixedMsg.istroop == 1)
    {
      localObject = paramMessageForMixedMsg.msgElemList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        nlj.a().a(localMessageRecord);
      }
    }
    axey.a(this.jdField_a_of_type_Axey, this.jdField_a_of_type_Axey.a, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg, true);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Object localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {}
    for (;;)
    {
      return null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(((Integer)localObject2).intValue());
        if ((localObject2 instanceof MessageForPic)) {
          ((MessageForPic)localObject2).richText = paramRichText;
        }
      }
    }
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new ErrorMessage(paramazrh.jdField_b_of_type_Int, paramazrh.jdField_a_of_type_JavaLangString);
      QLog.d("MixedMsgManager", 2, "reqUploadMultiPics UiCallBack success result = " + paramazrh + ", error = " + localObject1);
    }
    if (paramazrh.jdField_b_of_type_Int != 0) {
      axey.a(this.jdField_a_of_type_Axey, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "send Msg fail: " + paramazrh);
    }
    do
    {
      do
      {
        return;
        localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.getSubMessage(((Integer)localObject2).intValue());
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "onSend, pre MessageForPic:" + ((MessageForPic)localObject2).toLogString());
          }
          ((MessageForPic)localObject2).md5 = paramazrh.d;
          ((MessageForPic)localObject2).uuid = paramazrh.c;
          ((MessageForPic)localObject2).size = paramazrh.jdField_a_of_type_Long;
          ((MessageForPic)localObject2).groupFileID = paramazrh.jdField_b_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "onSend, end MessageForPic:" + ((MessageForPic)localObject2).toLogString());
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.prewrite();
        }
      }
    } while (!this.jdField_a_of_type_JavaUtilMap.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "onSend, mMsgMap isEmpty, packAndSend..");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfc
 * JD-Core Version:    0.7.0.1
 */