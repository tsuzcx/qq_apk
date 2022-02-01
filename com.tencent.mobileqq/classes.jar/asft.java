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

public class asft
  implements Handler.Callback, Manager
{
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private asfu jdField_a_of_type_Asfu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile ConcurrentLinkedQueue<asfc> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile CopyOnWriteArrayList<asfc> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public asft(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString1, String paramString2, asfc paramasfc)
  {
    this.jdField_a_of_type_Int += 1;
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiEmotionSaveManager", 2, "realSaveEmo failed! errorCode = " + i);
        }
        if (paramasfc != null)
        {
          paramasfc.jdField_a_of_type_Int = -1;
          paramasfc.jdField_b_of_type_Int = i;
          paramasfc.c = axpv.a(i);
          paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          paramString1.obj = paramasfc;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bhmi.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        i = 0;
        Object localObject1 = paramString2;
        File localFile;
        do
        {
          if (i > 0) {
            localObject1 = paramString2 + "_" + i;
          }
          Object localObject2 = localObject1;
          if (!((String)localObject1).contains("."))
          {
            localObject2 = bhmi.b(paramString1);
            localObject2 = (String)localObject1 + "." + (String)localObject2;
          }
          localFile = new File(asfb.jdField_a_of_type_JavaLangString, (String)localObject2);
          i += 1;
          localObject1 = localObject2;
        } while (localFile.exists());
        paramString2 = new File(paramString1);
        ThreadManager.getFileThreadHandler().post(new MultiEmotionSaveManager.1(this, localFile, paramString2, paramString1, paramasfc));
        return;
      }
      i = 0;
    }
  }
  
  private void b(asfc paramasfc)
  {
    String str = System.nanoTime() + "";
    a(paramasfc.jdField_b_of_type_JavaLangString, str, paramasfc);
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
    if (this.jdField_a_of_type_Asfu != null) {
      this.jdField_a_of_type_Asfu.b();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Asfu == null)) {}
    int i;
    do
    {
      return;
      i = (int)(this.jdField_b_of_type_Int * 100.0D / this.jdField_a_of_type_Long);
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Long) {
        i = 100;
      }
    } while (this.jdField_a_of_type_Asfu == null);
    this.jdField_a_of_type_Asfu.a(i);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "cancelMultiEmoSave");
    }
    c();
    if (this.jdField_a_of_type_Asfu != null) {
      this.jdField_a_of_type_Asfu.a();
    }
  }
  
  public void a(asfc paramasfc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiEmotionSaveManager", 2, "saveComplete");
    }
    if (this.jdField_a_of_type_Asfu != null) {
      this.jdField_a_of_type_Asfu.a(paramasfc);
    }
    c();
  }
  
  public void a(asfu paramasfu)
  {
    this.jdField_a_of_type_Asfu = paramasfu;
  }
  
  public void a(List<asmu> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiEmotionSaveManager", 2, "saveMultiRichMedialFile emoSaveReqList is empty!");
      }
      paramList = new asfc();
      paramList.jdField_a_of_type_Int = -1;
      paramList.jdField_b_of_type_Int = 10006;
      paramList.c = axpv.a(10006);
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
        localObject = (asmu)paramList.next();
        if ((localObject instanceof asmp))
        {
          localObject = (asmp)localObject;
          asfc localasfc = new asfc();
          localasfc.jdField_a_of_type_JavaLangString = ((asmp)localObject).g;
          localasfc.jdField_b_of_type_JavaLangString = ((asmp)localObject).e;
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localasfc);
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
        paramList = new asfc();
        paramList.jdField_a_of_type_Int = -1;
        paramList.jdField_b_of_type_Int = 10006;
        paramList.c = axpv.a(10006);
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
        localObject = (asfc)paramList.next();
        if (this.jdField_a_of_type_Int < 1) {
          b((asfc)localObject);
        } else {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localObject);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Asfu = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asfc localasfc;
    if ((paramMessage.obj instanceof asfc))
    {
      localasfc = (asfc)paramMessage.obj;
      if (localasfc != null) {
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
          QLog.i("MultiEmotionSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localasfc.jdField_b_of_type_Int + ", errorMsg = " + localasfc.c);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int += 1;
        e();
        paramMessage = (asfc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (paramMessage == null) {
          break;
        }
        b(paramMessage);
        return false;
        this.jdField_b_of_type_Boolean = true;
      }
    } while (this.jdField_a_of_type_Int != 0);
    paramMessage = new asfc();
    if (this.jdField_b_of_type_Boolean) {
      paramMessage.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      a(paramMessage);
      return false;
      paramMessage.jdField_a_of_type_Int = -1;
      paramMessage.jdField_b_of_type_Int = localasfc.jdField_b_of_type_Int;
      paramMessage.c = localasfc.c;
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
 * Qualified Name:     asft
 * JD-Core Version:    0.7.0.1
 */