import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class aqgi
  implements Handler.Callback
{
  public final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private aqgg jdField_a_of_type_Aqgg;
  private aqgh jdField_a_of_type_Aqgh;
  public aqgj a;
  private aqgk jdField_a_of_type_Aqgk;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public final String a;
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  protected boolean a;
  public final int b = 2;
  public final int c = 4;
  public final int d = 6;
  public final int e = 7;
  
  public aqgi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatStateMachine";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqgh = new aqgh(this, 100);
    this.jdField_a_of_type_Aqgk = new aqgk(this, 101);
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
  
  public void a(int paramInt, aqcl paramaqcl)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + paramInt);
      if (this.jdField_a_of_type_Aqgg != null) {
        this.jdField_a_of_type_Aqgg.b(paramaqcl);
      }
      return;
      try
      {
        this.jdField_a_of_type_Aqgg = this.jdField_a_of_type_Aqgh;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_Aqgg = this.jdField_a_of_type_Aqgk;
    }
  }
  
  public void a(aqgj paramaqgj)
  {
    this.jdField_a_of_type_Aqgj = paramaqgj;
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
  
  public void a(boolean paramBoolean, int paramInt, aqcl paramaqcl, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onCSMatchResponseMsg success:" + paramBoolean + " retCode:" + paramInt);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, i, paramInt, new Object[] { paramaqcl, paramString }).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean, aqcl paramaqcl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean + " info:" + paramaqcl);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 6, i, 0, paramaqcl).sendToTarget();
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqgh != null)
    {
      this.jdField_a_of_type_Aqgh.b();
      this.jdField_a_of_type_Aqgh = null;
    }
    if (this.jdField_a_of_type_Aqgk != null)
    {
      this.jdField_a_of_type_Aqgk.b();
      this.jdField_a_of_type_Aqgk = null;
    }
    this.jdField_a_of_type_Aqgg = null;
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
    if (this.jdField_a_of_type_Aqgg == null) {
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
      this.jdField_a_of_type_Aqgg.a(i);
      return true;
    case 2: 
      this.jdField_a_of_type_Aqgg.a();
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
        aqcl localaqcl = (aqcl)localObject[0];
        localObject = (String)localObject[1];
        this.jdField_a_of_type_Aqgg.a(bool1, paramMessage.arg2, localaqcl, (String)localObject);
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
        this.jdField_a_of_type_Aqgg.a(bool1, paramMessage.arg2, null, null);
        continue;
        this.jdField_a_of_type_Aqgg.a(bool1, paramMessage.arg2, null, null);
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
    for (paramMessage = (aqcl)paramMessage.obj;; paramMessage = null)
    {
      this.jdField_a_of_type_Aqgg.a(bool1, paramMessage);
      return true;
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      this.jdField_a_of_type_Aqgg.a(bool1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgi
 * JD-Core Version:    0.7.0.1
 */