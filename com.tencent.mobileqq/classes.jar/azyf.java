import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class azyf
  extends azyh
{
  public azyf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap<String, ArrayList<MessageRecord>> a(List<MessageRecord> paramList, ArrayList<ChatMessage> paramArrayList)
  {
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if ((localMessageRecord1 instanceof MessageForMixedMsg))
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          if (((localMessageRecord2 instanceof MessageForReplyText)) && (((MessageForReplyText)localMessageRecord2).getSourceMessage() != null))
          {
            localArrayList.add(localMessageRecord2);
            localHashMap.put(String.valueOf(localMessageRecord1.uniseq), localArrayList);
          }
        }
        paramArrayList.add((ChatMessage)localMessageRecord1);
      }
    }
    return localHashMap;
  }
  
  private void h(awcs paramawcs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramawcs.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage instanceof MessageForMixedMsg)) {
          ((avsf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForMixedMsg)localChatMessage, false, ((MessageForMixedMsg)localChatMessage).forwardID);
        }
      }
    }
  }
  
  protected void c(awcs paramawcs)
  {
    h(paramawcs);
  }
  
  protected void d(awcs paramawcs)
  {
    int i = 0;
    Object localObject = paramawcs.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList(1);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramawcs.jdField_a_of_type_Int != 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramawcs.jdField_a_of_type_JavaUtilHashMap = a(a(localQQAppInterface, (List)localObject, bool), localArrayList);
      paramawcs.jdField_a_of_type_JavaUtilList = localArrayList;
      if (paramawcs.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
      }
      h(paramawcs);
      return;
    }
    if (paramawcs.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramawcs;
      ((Message)localObject).sendToTarget();
      return;
      if (paramawcs.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  protected void g(awcs paramawcs)
  {
    h(paramawcs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyf
 * JD-Core Version:    0.7.0.1
 */