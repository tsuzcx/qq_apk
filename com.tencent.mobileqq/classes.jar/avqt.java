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

public class avqt
  extends avqv
{
  public avqt(QQAppInterface paramQQAppInterface)
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
  
  private void h(asue paramasue)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramasue.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage instanceof MessageForMixedMsg)) {
          ((asjs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(paramasue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForMixedMsg)localChatMessage, false, ((MessageForMixedMsg)localChatMessage).forwardID);
        }
      }
    }
  }
  
  protected void c(asue paramasue)
  {
    h(paramasue);
  }
  
  protected void d(asue paramasue)
  {
    int i = 0;
    Object localObject1 = paramasue.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList(1);
    Object localObject2 = (HashMap)paramasue.jdField_a_of_type_JavaUtilMap;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramasue.jdField_a_of_type_Int != 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramasue.jdField_a_of_type_JavaUtilHashMap = a(a((QQAppInterface)localObject2, (List)localObject1, bool), localArrayList);
      paramasue.jdField_a_of_type_JavaUtilList = localArrayList;
      if (paramasue.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
      }
      h(paramasue);
      return;
    }
    if (paramasue.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject1).obj = paramasue;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramasue.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  protected void g(asue paramasue)
  {
    h(paramasue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avqt
 * JD-Core Version:    0.7.0.1
 */