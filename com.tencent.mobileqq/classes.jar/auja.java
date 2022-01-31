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

public class auja
  implements Manager
{
  private aukp jdField_a_of_type_Aukp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<AutoReplyText> jdField_a_of_type_JavaUtilList;
  
  public auja(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
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
    localArrayList.add(new AutoReplyText(ajya.a(2131700859), 0));
    localArrayList.add(new AutoReplyText(ajya.a(2131700858), 1));
    localArrayList.add(new AutoReplyText(ajya.a(2131700856), 2));
    localArrayList.add(new AutoReplyText(ajya.a(2131700857), 2147483647));
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
        localaukr = this.jdField_a_of_type_Aukp.a();
        ??? = localaukr;
        localObject2 = localaukr;
        localaukr.a();
        ??? = localaukr;
        localObject2 = localaukr;
        this.jdField_a_of_type_Aukp.a(AutoReplyText.class);
        ??? = localaukr;
        localObject2 = localaukr;
        Iterator localIterator = paramList.iterator();
        ??? = localaukr;
        localObject2 = localaukr;
        if (!localIterator.hasNext()) {
          break label251;
        }
        ??? = localaukr;
        localObject2 = localaukr;
        localAutoReplyText = (AutoReplyText)localIterator.next();
        ??? = localaukr;
        localObject2 = localaukr;
        if (localAutoReplyText.getTextId() != paramInt) {
          continue;
        }
        ??? = localaukr;
        localObject2 = localaukr;
        localAutoReplyText.mCheckFlag = 1;
      }
      catch (Exception localException)
      {
        aukr localaukr;
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
      ??? = localaukr;
      localObject2 = localaukr;
      this.jdField_a_of_type_Aukp.b(localAutoReplyText);
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
    this.jdField_a_of_type_Aukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auja
 * JD-Core Version:    0.7.0.1
 */