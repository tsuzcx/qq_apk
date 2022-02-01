import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.together.writetogether.WriteTogetherManager.1;
import com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bdgj
  implements bdgd, Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WriteTogetherWebSocketSender jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender;
  private CopyOnWriteArrayList<bdge> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private CopyOnWriteArrayList<bdge> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public bdgj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender = new WriteTogetherWebSocketSender(new bdjk());
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  private void a(bdge parambdge, BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject, MqqHandler paramMqqHandler)
  {
    paramMqqHandler.post(new WriteTogetherManager.1(this, parambdge, paramType, paramBoolean, paramObject));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(paramInt);
  }
  
  public void a(bdge parambdge)
  {
    a(parambdge, false);
  }
  
  public void a(bdge parambdge, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambdge);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambdge);
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(paramBaseToWriteTogetherMsg);
  }
  
  public void a(BaseWriteTogetherMsg paramBaseWriteTogetherMsg)
  {
    BaseWriteTogetherMsg.Type localType = paramBaseWriteTogetherMsg.getType();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      a((bdge)localIterator.next(), localType, true, paramBaseWriteTogetherMsg, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      a((bdge)localIterator.next(), localType, true, paramBaseWriteTogetherMsg, this.jdField_b_of_type_MqqOsMqqHandler);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public void b(bdge parambdge)
  {
    b(parambdge, false);
  }
  
  public void b(bdge parambdge, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambdge);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambdge);
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgj
 * JD-Core Version:    0.7.0.1
 */