import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class apja
  implements Handler.Callback, Manager
{
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apjb jdField_a_of_type_Apjb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile ConcurrentLinkedQueue<apij> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile CopyOnWriteArrayList<apij> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public apja(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, apij paramapij)
  {
    this.jdField_a_of_type_Int += 1;
    int i = 0;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    while (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "realSaveEmo failed! errorCode = " + i);
      }
      if (paramapij != null)
      {
        paramapij.jdField_a_of_type_Int = -1;
        paramapij.jdField_b_of_type_Int = i;
        paramapij.c = auln.a(i);
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        paramString1.obj = paramapij;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      return;
      if (TextUtils.isEmpty(paramString2)) {
        i = 10002;
      } else if (!bdcs.a(paramString1)) {
        i = 10003;
      }
    }
    Object localObject;
    if (!paramString2.contains("."))
    {
      localObject = bdcs.b(paramString1);
      paramString2 = paramString2 + "." + (String)localObject;
    }
    for (;;)
    {
      localObject = new File(apii.jdField_a_of_type_JavaLangString, paramString2);
      File localFile = new File(paramString1);
      ThreadManager.getFileThreadHandler().post(new MultiEmotionSaveManager.1(this, (File)localObject, localFile, paramString1, paramString2, paramapij));
      return;
    }
  }
  
  private void b(apij paramapij)
  {
    String str = System.nanoTime() + "";
    a(paramapij.jdField_b_of_type_JavaLangString, str, paramapij);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "clearCatch");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Apjb != null) {
      this.jdField_a_of_type_Apjb.b();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Apjb == null)) {}
    int i;
    do
    {
      return;
      i = (int)(this.jdField_b_of_type_Int * 100.0D / this.jdField_a_of_type_Long);
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Long) {
        i = 100;
      }
    } while (this.jdField_a_of_type_Apjb == null);
    this.jdField_a_of_type_Apjb.a(i);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    c();
    if (this.jdField_a_of_type_Apjb != null) {
      this.jdField_a_of_type_Apjb.a();
    }
  }
  
  public void a(apij paramapij)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    if (this.jdField_a_of_type_Apjb != null) {
      this.jdField_a_of_type_Apjb.a(paramapij);
    }
    c();
  }
  
  public void a(apjb paramapjb)
  {
    this.jdField_a_of_type_Apjb = paramapjb;
  }
  
  public void a(List<appw> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
      }
      paramList = new apij();
      paramList.jdField_a_of_type_Int = -1;
      paramList.jdField_b_of_type_Int = 10006;
      paramList.c = auln.a(10006);
      a(paramList);
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList count is :" + paramList.size());
      }
      c();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (appw)paramList.next();
        if ((localObject instanceof appr))
        {
          localObject = (appr)localObject;
          apij localapij = new apij();
          localapij.jdField_a_of_type_JavaLangString = ((appr)localObject).g;
          localapij.jdField_b_of_type_JavaLangString = ((appr)localObject).e;
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localapij);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MultiEmotionSaveManager", 2, "temp is not CustomEmoticonInfoBase class is " + localObject.getClass());
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList is empty!");
        }
        paramList = new apij();
        paramList.jdField_a_of_type_Int = -1;
        paramList.jdField_b_of_type_Int = 10006;
        paramList.c = auln.a(10006);
        a(paramList);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoReqList count is :" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      }
      d();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      paramList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject = (apij)paramList.next();
        if (this.jdField_a_of_type_Int < 1) {
          b((apij)localObject);
        } else {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localObject);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apjb = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    apij localapij;
    if ((paramMessage.obj instanceof apij))
    {
      localapij = (apij)paramMessage.obj;
      if (localapij != null) {
        switch (paramMessage.what)
        {
        }
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_Int -= 1;
      if (paramMessage.what == 2)
      {
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localapij.jdField_b_of_type_Int + ", errorMsg = " + localapij.c);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int += 1;
        e();
        paramMessage = (apij)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (paramMessage == null) {
          break;
        }
        b(paramMessage);
        return false;
        this.jdField_b_of_type_Boolean = true;
      }
    } while (this.jdField_a_of_type_Int != 0);
    paramMessage = new apij();
    if (this.jdField_b_of_type_Boolean) {
      paramMessage.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      a(paramMessage);
      return false;
      paramMessage.jdField_a_of_type_Int = -1;
      paramMessage.jdField_b_of_type_Int = localapij.jdField_b_of_type_Int;
      paramMessage.c = localapij.c;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "onDestroy");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apja
 * JD-Core Version:    0.7.0.1
 */