import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class asje
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private asjf jdField_a_of_type_Asjf;
  protected ArrayList<Integer> a;
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  
  public asje(asjf paramasjf)
  {
    this.jdField_a_of_type_Asjf = paramasjf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10001);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        b();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, Integer.valueOf(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiResReloader", 2, new Object[] { "addReloadDrawable idx:", Integer.valueOf(paramInt), " ,size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
        }
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  protected void b()
  {
    ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResReloader.1(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label162;
        }
        i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).intValue();
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (i <= -1) {
          break;
        }
        if (this.jdField_a_of_type_Asjf != null) {
          this.jdField_a_of_type_Asjf.a(i);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 300L);
          return false;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResReloader", 2, "finish reloading");
      return false;
      label162:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asje
 * JD-Core Version:    0.7.0.1
 */