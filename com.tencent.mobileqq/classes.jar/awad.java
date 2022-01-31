import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class awad
  implements Manager
{
  private awbw jdField_a_of_type_Awbw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<AutoReplyText> jdField_a_of_type_JavaUtilList;
  
  public awad(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    a();
  }
  
  private void a()
  {
    ThreadManager.getFileThreadHandler().post(new AutoReplyManager.1(this));
  }
  
  public AutoReplyText a()
  {
    Object localObject = null;
    List localList = a();
    Iterator localIterator = localList.iterator();
    if (localIterator.hasNext())
    {
      AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
      if (!localAutoReplyText.isChecked()) {
        break label107;
      }
      localObject = localAutoReplyText;
    }
    label107:
    for (;;)
    {
      break;
      if (localObject == null)
      {
        localObject = (AutoReplyText)localList.get(0);
        QLog.d("AutoReplyManager", 1, "getCurrentAutoReplyText is null, default check index 0");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyManager", 2, "getCurrentAutoReplyText: " + localObject);
        }
        return localObject;
      }
    }
  }
  
  public List<AutoReplyText> a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AutoReplyText(alpo.a(2131701228), 0));
    localArrayList.add(new AutoReplyText(alpo.a(2131701227), 1));
    localArrayList.add(new AutoReplyText(alpo.a(2131701225), 2));
    localArrayList.add(new AutoReplyText(alpo.a(2131701226), 2147483647));
    ((AutoReplyText)localArrayList.get(0)).mCheckFlag = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "getAutoReplyCache, buffList == null");
    }
    a();
    return localArrayList;
  }
  
  public void a(List<AutoReplyText> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject2 = null;
    ??? = null;
    for (;;)
    {
      try
      {
        localawby = this.jdField_a_of_type_Awbw.a();
        ??? = localawby;
        localObject2 = localawby;
        localawby.a();
        ??? = localawby;
        localObject2 = localawby;
        this.jdField_a_of_type_Awbw.a(AutoReplyText.class);
        ??? = localawby;
        localObject2 = localawby;
        Iterator localIterator = paramList.iterator();
        ??? = localawby;
        localObject2 = localawby;
        if (!localIterator.hasNext()) {
          break label251;
        }
        ??? = localawby;
        localObject2 = localawby;
        localAutoReplyText = (AutoReplyText)localIterator.next();
        ??? = localawby;
        localObject2 = localawby;
        if (localAutoReplyText.getTextId() != paramInt) {
          continue;
        }
        ??? = localawby;
        localObject2 = localawby;
        localAutoReplyText.mCheckFlag = 1;
      }
      catch (Exception localException)
      {
        awby localawby;
        AutoReplyText localAutoReplyText;
        localObject2 = ???;
        localException.printStackTrace();
        localObject2 = ???;
        QLog.d("AutoReplyManager", 1, "updateAutoReplyList, exception: ", localException);
        if (??? == null) {
          continue;
        }
        ???.b();
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null) {
            break label322;
          }
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          return;
        }
        ??? = localException;
        localObject2 = localException;
        localAutoReplyText.mCheckFlag = 0;
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        localObject2.b();
      }
      ??? = localawby;
      localObject2 = localawby;
      this.jdField_a_of_type_Awbw.b(localAutoReplyText);
    }
    for (;;)
    {
      label251:
      ??? = localException;
      localObject2 = localException;
      localException.c();
      ??? = localException;
      localObject2 = localException;
      if (QLog.isColorLevel())
      {
        ??? = localException;
        localObject2 = localException;
        QLog.d("AutoReplyManager", 2, String.format("updateAutoReplyListCache, textList: %s, selectId: %s", new Object[] { paramList, Integer.valueOf(paramInt) }));
      }
      if (localException != null)
      {
        localException.b();
        continue;
        label322:
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "AutoReplyManager onDestroy");
    }
    this.jdField_a_of_type_Awbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awad
 * JD-Core Version:    0.7.0.1
 */