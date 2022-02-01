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

public class axiw
  extends axic
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131707613);
  }
  
  public axiw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(axiu paramaxiu, MessageRecord paramMessageRecord, ArrayList<azjz> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramaxiu = azjv.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (paramaxiu != null) {
        paramArrayList.add(paramaxiu);
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
                    paramaxiu = azjv.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                    if (paramaxiu != null)
                    {
                      paramArrayList.addAll(paramaxiu);
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
                  paramaxiu = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramaxiu.hasNext())
                  {
                    localObject = (MessageRecord)paramaxiu.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = azjv.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
              paramaxiu = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramaxiu == null) || (!(paramaxiu instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramaxiu).getFirstImageElement();
          } while (localObject == null);
          if (((bdqa)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
          {
            if (((bdqa)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((bdqa)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramaxiu);
            }
            ((bdqa)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((bdqa)localObject).a();
          }
          paramaxiu = azjv.a(7, ((bdqa)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt2, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          if (paramaxiu != null)
          {
            paramArrayList.add(paramaxiu);
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
    if (paramaxiu.b == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramaxiu, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<azjz> paramArrayList1, int paramInt, axiu paramaxiu, axif paramaxif)
  {
    azke localazke = azjv.a(8, 7);
    localazke.a(paramArrayList1);
    localazke.a(new axix(this, paramArrayList, paramHashMap, paramMessageRecord, paramaxif, paramaxiu));
    azjv.a(localazke, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(axiu paramaxiu, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axif paramaxif)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramaxiu.b == 2) {}
    for (int i = 0;; i = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      String str2 = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      int j = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramaxiu, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramaxiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, localArrayList2, localArrayList1, paramaxiu.b, paramaxiu, paramaxif);
      return;
    }
    paramaxif.a(0, 1, paramaxiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axiw
 * JD-Core Version:    0.7.0.1
 */