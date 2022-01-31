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

public class anrn
  implements Handler.Callback, Manager
{
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private anro jdField_a_of_type_Anro;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile ConcurrentLinkedQueue<anqw> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile CopyOnWriteArrayList<anqw> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public anrn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, anqw paramanqw)
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
      if (paramanqw != null)
      {
        paramanqw.jdField_a_of_type_Int = -1;
        paramanqw.jdField_b_of_type_Int = i;
        paramanqw.c = asuo.a(i);
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        paramString1.obj = paramanqw;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      return;
      if (TextUtils.isEmpty(paramString2)) {
        i = 10002;
      } else if (!bbdj.a(paramString1)) {
        i = 10003;
      }
    }
    Object localObject;
    if (!paramString2.contains("."))
    {
      localObject = bbdj.b(paramString1);
      paramString2 = paramString2 + "." + (String)localObject;
    }
    for (;;)
    {
      localObject = new File(anqv.jdField_a_of_type_JavaLangString, paramString2);
      File localFile = new File(paramString1);
      ThreadManager.getFileThreadHandler().post(new MultiEmotionSaveManager.1(this, (File)localObject, localFile, paramString1, paramString2, paramanqw));
      return;
    }
  }
  
  private void b(anqw paramanqw)
  {
    String str = System.nanoTime() + "";
    a(paramanqw.jdField_b_of_type_JavaLangString, str, paramanqw);
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
    if (this.jdField_a_of_type_Anro != null) {
      this.jdField_a_of_type_Anro.b();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Anro == null)) {}
    int i;
    do
    {
      return;
      i = (int)(this.jdField_b_of_type_Int * 100.0D / this.jdField_a_of_type_Long);
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Long) {
        i = 100;
      }
    } while (this.jdField_a_of_type_Anro == null);
    this.jdField_a_of_type_Anro.a(i);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    c();
    if (this.jdField_a_of_type_Anro != null) {
      this.jdField_a_of_type_Anro.a();
    }
  }
  
  public void a(anqw paramanqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    if (this.jdField_a_of_type_Anro != null) {
      this.jdField_a_of_type_Anro.a(paramanqw);
    }
    c();
  }
  
  public void a(anro paramanro)
  {
    this.jdField_a_of_type_Anro = paramanro;
  }
  
  public void a(List<anyc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
      }
      paramList = new anqw();
      paramList.jdField_a_of_type_Int = -1;
      paramList.jdField_b_of_type_Int = 10006;
      paramList.c = asuo.a(10006);
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
        localObject = (anyc)paramList.next();
        if ((localObject instanceof anxz))
        {
          localObject = (anxz)localObject;
          anqw localanqw = new anqw();
          localanqw.jdField_a_of_type_JavaLangString = ((anxz)localObject).f;
          localanqw.jdField_b_of_type_JavaLangString = ((anxz)localObject).d;
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localanqw);
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
        paramList = new anqw();
        paramList.jdField_a_of_type_Int = -1;
        paramList.jdField_b_of_type_Int = 10006;
        paramList.c = asuo.a(10006);
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
        localObject = (anqw)paramList.next();
        if (this.jdField_a_of_type_Int < 1) {
          b((anqw)localObject);
        } else {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localObject);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Anro = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    anqw localanqw;
    if ((paramMessage.obj instanceof anqw))
    {
      localanqw = (anqw)paramMessage.obj;
      if (localanqw != null) {
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
          QLog.i("MultiEmotionSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localanqw.jdField_b_of_type_Int + ", errorMsg = " + localanqw.c);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int += 1;
        e();
        paramMessage = (anqw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (paramMessage == null) {
          break;
        }
        b(paramMessage);
        return false;
        this.jdField_b_of_type_Boolean = true;
      }
    } while (this.jdField_a_of_type_Int != 0);
    paramMessage = new anqw();
    if (this.jdField_b_of_type_Boolean) {
      paramMessage.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      a(paramMessage);
      return false;
      paramMessage.jdField_a_of_type_Int = -1;
      paramMessage.jdField_b_of_type_Int = localanqw.jdField_b_of_type_Int;
      paramMessage.c = localanqw.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anrn
 * JD-Core Version:    0.7.0.1
 */