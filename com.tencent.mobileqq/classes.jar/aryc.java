import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aryc
  extends arxk
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131642368);
  }
  
  public aryc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(arya paramarya, MessageRecord paramMessageRecord, ArrayList<atpp> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramarya = atpl.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramarya != null) {
        paramArrayList.add(paramarya);
      }
    }
    label47:
    label224:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              paramArrayList1.add(paramMessageRecord);
              break label47;
              break label47;
              break label47;
              break label47;
              for (;;)
              {
                return;
                if (QLog.isColorLevel())
                {
                  QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                  return;
                  if ((paramMessageRecord instanceof MessageForMixedMsg))
                  {
                    paramarya = atpl.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    if (paramarya != null)
                    {
                      paramArrayList.addAll(paramarya);
                      paramArrayList1.add(paramMessageRecord);
                      return;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
                    return;
                  }
                  if (paramMessageRecord.msgtype != -1036) {
                    break label224;
                  }
                  paramarya = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramarya.hasNext())
                  {
                    localObject = (MessageRecord)paramarya.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = atpl.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                      if (localObject != null)
                      {
                        paramArrayList.addAll((Collection)localObject);
                        paramArrayList1.add(paramMessageRecord);
                      }
                    }
                  }
                }
              }
              if (!(paramMessageRecord instanceof MessageForStructing)) {
                break;
              }
              paramarya = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramarya == null) || (!(paramarya instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramarya).getFirstImageElement();
          } while (localObject == null);
          if (((awwr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
          {
            if (((awwr)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((awwr)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramarya);
            }
            ((awwr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((awwr)localObject).a();
          }
          paramarya = atpl.a(7, ((awwr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (paramarya != null)
          {
            paramArrayList.add(paramarya);
            paramArrayList1.add(paramMessageRecord);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        return;
      } while (!(paramMessageRecord instanceof MessageForReplyText));
      paramMessageRecord = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
    } while ((paramMessageRecord == null) || ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)) && (!(paramMessageRecord instanceof MessageForStructing)) && (paramMessageRecord.msgtype != -1036)));
    if (QLog.isColorLevel()) {
      QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg] MessageForReplyText add to list");
    }
    if (paramarya.b == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramarya, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<atpp> paramArrayList1, int paramInt, arya paramarya, arxn paramarxn)
  {
    atpv localatpv = atpl.a(8, 7);
    localatpv.a(paramArrayList1);
    localatpv.a(new aryd(this, paramArrayList, paramHashMap, paramMessageRecord, paramarxn, paramarya));
    atpl.a(localatpv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(arya paramarya, HashMap<String, ArrayList<MessageRecord>> paramHashMap, arxn paramarxn)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramarya.b == 2) {}
    for (int i = 0;; i = paramarya.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      String str2 = paramarya.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = paramarya.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramarya, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramarya.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramarya.b, paramarya, paramarxn);
      return;
    }
    paramarxn.a(0, 1, paramarya);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryc
 * JD-Core Version:    0.7.0.1
 */