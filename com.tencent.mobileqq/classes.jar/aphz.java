import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.1;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public abstract class aphz<T extends CustomEmotionBase>
  implements Manager
{
  public QQAppInterface a;
  protected List<T> a;
  
  public aphz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract appw a(T paramT);
  
  public T a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      awbw localawbw;
      do
      {
        return null;
        localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      } while (localawbw == null);
      paramString = localawbw.a(a(), false, "url=?", new String[] { paramString }, null, null, null, null);
      localawbw.a();
    } while ((paramString == null) || (paramString.size() != 1));
    return (CustomEmotionBase)paramString.get(0);
  }
  
  public abstract Class a();
  
  public abstract List<T> a();
  
  public List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getCustomEmoticonResIdsByType.");
    }
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
        String str = localCustomEmotionBase.resid;
        if ((localCustomEmotionBase.RomaingType.equals(paramString)) && (str != null) && (!"".equals(str))) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
      if (localCustomEmotionBase.RomaingType.equals("failed")) {
        localArrayList.add(localCustomEmotionBase);
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
  }
  
  public void a(apia paramapia)
  {
    if (paramapia == null) {
      return;
    }
    ThreadManager.post(new CustomEmotionRoamingDBManagerBase.3(this, paramapia), 5, null, true);
  }
  
  public void a(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 4);
      a(paramT, 4);
    }
  }
  
  public void a(T paramT, int paramInt)
  {
    if (paramT == null) {
      return;
    }
    a(new CustomEmotionRoamingDBManagerBase.2(this, paramInt, paramT), 8);
  }
  
  protected void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      b((CustomEmotionBase)paramList.get(i), 4);
      i += 1;
    }
    a(paramList, 4);
  }
  
  protected void a(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    a(new CustomEmotionRoamingDBManagerBase.1(this, paramList, paramInt), 8);
  }
  
  public abstract List<appw> b();
  
  public List<T> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getEmoticonDatasByType.");
      }
      localList = a();
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localList.get(i);
      if (localCustomEmotionBase.RomaingType.equals(paramString)) {
        localArrayList.add(localCustomEmotionBase);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 2);
      a(paramT, 2);
    }
  }
  
  protected void b(T paramT, int paramInt)
  {
    if (paramT == null) {}
    CustomEmotionBase localCustomEmotionBase;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          switch (paramInt)
          {
          }
        } while (!QLog.isColorLevel());
        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not update fav emoticon cache data, type:" + paramInt);
        return;
        this.jdField_a_of_type_JavaUtilList.add(paramT);
        return;
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
        } while (localCustomEmotionBase.emoId != paramT.emoId);
        localCustomEmotionBase.replace(paramT);
        return;
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
    } while (localCustomEmotionBase.emoId != paramT.emoId);
    this.jdField_a_of_type_JavaUtilList.remove(localCustomEmotionBase);
  }
  
  public abstract List<appw> c();
  
  public List<T> c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from findMagicEmosById.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localList.get(i);
        if ((localCustomEmotionBase != null) && (localCustomEmotionBase.emoPath.equals(paramString))) {
          localArrayList.add(localCustomEmotionBase);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void c(T paramT)
  {
    if (paramT != null)
    {
      b(paramT, 1);
      a(paramT, 1);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphz
 * JD-Core Version:    0.7.0.1
 */