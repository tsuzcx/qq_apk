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

public class benm
  implements beng, Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WriteTogetherWebSocketSender jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender;
  private CopyOnWriteArrayList<benh> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private CopyOnWriteArrayList<benh> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public benm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender = new WriteTogetherWebSocketSender(new beqn());
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  private void a(benh parambenh, BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject, MqqHandler paramMqqHandler)
  {
    paramMqqHandler.post(new WriteTogetherManager.1(this, parambenh, paramType, paramBoolean, paramObject));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(paramInt);
  }
  
  public void a(benh parambenh)
  {
    a(parambenh, false);
  }
  
  public void a(benh parambenh, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambenh);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambenh);
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
      a((benh)localIterator.next(), localType, true, paramBaseWriteTogetherMsg, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      a((benh)localIterator.next(), localType, true, paramBaseWriteTogetherMsg, this.jdField_b_of_type_MqqOsMqqHandler);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketWriteTogetherWebSocketSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public void b(benh parambenh)
  {
    b(parambenh, false);
  }
  
  public void b(benh parambenh, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambenh);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambenh);
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benm
 * JD-Core Version:    0.7.0.1
 */