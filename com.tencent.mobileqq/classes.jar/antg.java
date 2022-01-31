import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class antg
  implements Handler.Callback
{
  public final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private ante jdField_a_of_type_Ante;
  private antf jdField_a_of_type_Antf;
  public anth a;
  private anti jdField_a_of_type_Anti;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public final String a;
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  protected boolean a;
  public final int b = 2;
  public final int c = 4;
  public final int d = 6;
  public final int e = 7;
  
  public antg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatStateMachine";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Antf = new antf(this, 100);
    this.jdField_a_of_type_Anti = new anti(this, 101);
    a(100, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt, anpe paramanpe)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + paramInt);
      if (this.jdField_a_of_type_Ante != null) {
        this.jdField_a_of_type_Ante.b(paramanpe);
      }
      return;
      try
      {
        this.jdField_a_of_type_Ante = this.jdField_a_of_type_Antf;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_Ante = this.jdField_a_of_type_Anti;
    }
  }
  
  public void a(anth paramanth)
  {
    this.jdField_a_of_type_Anth = paramanth;
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
  
  public void a(boolean paramBoolean, int paramInt, anpe paramanpe, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onCSMatchResponseMsg success:" + paramBoolean + " retCode:" + paramInt);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 4, i, paramInt, new Object[] { paramanpe, paramString }).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean, anpe paramanpe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean + " info:" + paramanpe);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 6, i, 0, paramanpe).sendToTarget();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Antf != null)
    {
      this.jdField_a_of_type_Antf.c();
      this.jdField_a_of_type_Antf = null;
    }
    if (this.jdField_a_of_type_Anti != null)
    {
      this.jdField_a_of_type_Anti.c();
      this.jdField_a_of_type_Anti = null;
    }
    this.jdField_a_of_type_Ante = null;
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
    if (this.jdField_a_of_type_Ante == null) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 5: 
    default: 
      return true;
    case 1: 
      this.jdField_a_of_type_Ante.a();
      return true;
    case 2: 
      this.jdField_a_of_type_Ante.b();
      return true;
    case 4: 
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Object[]))) {
          break label208;
        }
        Object localObject = (Object[])paramMessage.obj;
        if ((localObject == null) || (localObject.length != 2)) {
          break label191;
        }
        anpe localanpe = (anpe)localObject[0];
        localObject = (String)localObject[1];
        this.jdField_a_of_type_Ante.a(bool1, paramMessage.arg2, localanpe, (String)localObject);
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
        this.jdField_a_of_type_Ante.a(bool1, paramMessage.arg2, null, null);
        continue;
        this.jdField_a_of_type_Ante.a(bool1, paramMessage.arg2, null, null);
        QLog.e("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG obj err");
      }
    case 6: 
      label191:
      label208:
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      if (paramMessage.obj == null) {
        break;
      }
    }
    for (paramMessage = (anpe)paramMessage.obj;; paramMessage = null)
    {
      this.jdField_a_of_type_Ante.a(bool1, paramMessage);
      return true;
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      this.jdField_a_of_type_Ante.a(bool1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     antg
 * JD-Core Version:    0.7.0.1
 */