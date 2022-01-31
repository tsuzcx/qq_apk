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

public class aulf
  extends aukn
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131708536);
  }
  
  public aulf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(auld paramauld, MessageRecord paramMessageRecord, ArrayList<awew> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramauld = awes.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramauld != null) {
        paramArrayList.add(paramauld);
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
                    paramauld = awes.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    if (paramauld != null)
                    {
                      paramArrayList.addAll(paramauld);
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
                  paramauld = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramauld.hasNext())
                  {
                    localObject = (MessageRecord)paramauld.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = awes.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
              paramauld = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramauld == null) || (!(paramauld instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramauld).getFirstImageElement();
          } while (localObject == null);
          if (((azsp)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
          {
            if (((azsp)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((azsp)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramauld);
            }
            ((azsp)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((azsp)localObject).a();
          }
          paramauld = awes.a(7, ((azsp)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (paramauld != null)
          {
            paramArrayList.add(paramauld);
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
    if (paramauld.b == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramauld, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<awew> paramArrayList1, int paramInt, auld paramauld, aukq paramaukq)
  {
    awfc localawfc = awes.a(8, 7);
    localawfc.a(paramArrayList1);
    localawfc.a(new aulg(this, paramArrayList, paramHashMap, paramMessageRecord, paramaukq, paramauld));
    awes.a(localawfc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(auld paramauld, HashMap<String, ArrayList<MessageRecord>> paramHashMap, aukq paramaukq)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramauld.b == 2) {}
    for (int i = 0;; i = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      String str2 = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramauld, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramauld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramauld.b, paramauld, paramaukq);
      return;
    }
    paramaukq.a(0, 1, paramauld);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */