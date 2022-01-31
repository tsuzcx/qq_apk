import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class aojx
  implements Handler.Callback
{
  public final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private aojv jdField_a_of_type_Aojv;
  private aojw jdField_a_of_type_Aojw;
  public aojy a;
  private aojz jdField_a_of_type_Aojz;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public final String a;
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  protected boolean a;
  public final int b = 2;
  public final int c = 4;
  public final int d = 6;
  public final int e = 7;
  
  public aojx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatStateMachine";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aojw = new aojw(this, 100);
    this.jdField_a_of_type_Aojz = new aojz(this, 101);
    a(100, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QLog.e("ExtendFriendLimitChatStateMachine", 2, "requestmatch with wrong id");
      i = 1;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, i, i).sendToTarget();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt, aofu paramaofu)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + paramInt);
      if (this.jdField_a_of_type_Aojv != null) {
        this.jdField_a_of_type_Aojv.b(paramaofu);
      }
      return;
      try
      {
        this.jdField_a_of_type_Aojv = this.jdField_a_of_type_Aojw;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_Aojv = this.jdField_a_of_type_Aojz;
    }
  }
  
  public void a(aojy paramaojy)
  {
    this.jdField_a_of_type_Aojy = paramaojy;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 7, Integer.valueOf(i)).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, aofu paramaofu, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onCSMatchResponseMsg success:" + paramBoolean + " retCode:" + paramInt);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, i, paramInt, new Object[] { paramaofu, paramString }).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean, aofu paramaofu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean + " info:" + paramaofu);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 6, i, 0, paramaofu).sendToTarget();
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aojw != null)
    {
      this.jdField_a_of_type_Aojw.b();
      this.jdField_a_of_type_Aojw = null;
    }
    if (this.jdField_a_of_type_Aojz != null)
    {
      this.jdField_a_of_type_Aojz.b();
      this.jdField_a_of_type_Aojz = null;
    }
    this.jdField_a_of_type_Aojv = null;
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "machine Clear ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_Aojv == null) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 5: 
    default: 
      return true;
    case 1: 
      int i = paramMessage.arg1;
      this.jdField_a_of_type_Aojv.a(i);
      return true;
    case 2: 
      this.jdField_a_of_type_Aojv.a();
      return true;
    case 4: 
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Object[]))) {
          break label214;
        }
        Object localObject = (Object[])paramMessage.obj;
        if ((localObject == null) || (localObject.length != 2)) {
          break label197;
        }
        aofu localaofu = (aofu)localObject[0];
        localObject = (String)localObject[1];
        this.jdField_a_of_type_Aojv.a(bool1, paramMessage.arg2, localaofu, (String)localObject);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG mIsGetMatchInfoWaitingHandle");
        }
        this.jdField_a_of_type_Boolean = false;
        return true;
        bool1 = false;
        break;
        this.jdField_a_of_type_Aojv.a(bool1, paramMessage.arg2, null, null);
        continue;
        this.jdField_a_of_type_Aojv.a(bool1, paramMessage.arg2, null, null);
        QLog.e("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG obj err");
      }
    case 6: 
      label197:
      label214:
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      if (paramMessage.obj == null) {
        break;
      }
    }
    for (paramMessage = (aofu)paramMessage.obj;; paramMessage = null)
    {
      this.jdField_a_of_type_Aojv.a(bool1, paramMessage);
      return true;
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      this.jdField_a_of_type_Aojv.a(bool1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojx
 * JD-Core Version:    0.7.0.1
 */