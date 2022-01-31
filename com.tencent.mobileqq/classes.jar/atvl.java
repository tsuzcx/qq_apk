import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class atvl
{
  private static atvl jdField_a_of_type_Atvl;
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private atvl()
  {
    if (NetConnInfoCenter.socketConnState == 4) {
      this.jdField_a_of_type_Int = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadingStateManager", 2, "LoadingStateManager init loadingstate = " + this.jdField_a_of_type_Int);
    }
  }
  
  public static atvl a()
  {
    if (jdField_a_of_type_Atvl == null) {
      jdField_a_of_type_Atvl = new atvl();
    }
    return jdField_a_of_type_Atvl;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    jdField_a_of_type_Atvl = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getAttribute("_tag_socket") == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel())
          {
            QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork mShowIllegalNetworkBar=" + this.jdField_a_of_type_Boolean);
            QLog.d("LoadingStateManager", 2, "changeConversationLoadingState mShowErrorNetworkBar=" + this.b);
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!this.b));
        if (!this.b) {
          break;
        }
        paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg.obtainMessage(10002, null).sendToTarget();
      return;
      if (!c()) {
        a(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
      }
      paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg.obtainMessage(1134012, null).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 3;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */