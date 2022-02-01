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

public class axpn
  extends axot
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131707034);
  }
  
  public axpn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(axpl paramaxpl, MessageRecord paramMessageRecord, ArrayList<azqf> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramaxpl = azqb.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramaxpl != null) {
        paramArrayList.add(paramaxpl);
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
                    paramaxpl = azqb.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    if (paramaxpl != null)
                    {
                      paramArrayList.addAll(paramaxpl);
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
                  paramaxpl = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramaxpl.hasNext())
                  {
                    localObject = (MessageRecord)paramaxpl.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = azqb.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
              paramaxpl = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramaxpl == null) || (!(paramaxpl instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramaxpl).getFirstImageElement();
          } while (localObject == null);
          if (((bdqr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
          {
            if (((bdqr)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((bdqr)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramaxpl);
            }
            ((bdqr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((bdqr)localObject).a();
          }
          paramaxpl = azqb.a(7, ((bdqr)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (paramaxpl != null)
          {
            paramArrayList.add(paramaxpl);
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
    if (paramaxpl.b == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramaxpl, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<azqf> paramArrayList1, int paramInt, axpl paramaxpl, axow paramaxow)
  {
    azqk localazqk = azqb.a(8, 7);
    localazqk.a(paramArrayList1);
    localazqk.a(new axpo(this, paramArrayList, paramHashMap, paramMessageRecord, paramaxow, paramaxpl));
    azqb.a(localazqk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(axpl paramaxpl, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axow paramaxow)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramaxpl.b == 2) {}
    for (int i = 0;; i = paramaxpl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      String str2 = paramaxpl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = paramaxpl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramaxpl, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramaxpl.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramaxpl.b, paramaxpl, paramaxow);
      return;
    }
    paramaxow.a(0, 1, paramaxpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpn
 * JD-Core Version:    0.7.0.1
 */