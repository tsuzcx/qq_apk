import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class aome
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap<String, aomj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public aome(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = aomh.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static aome a(QQAppInterface paramQQAppInterface)
  {
    return (aome)paramQQAppInterface.getManager(QQManagerFactory.HIDDENCHAT_MANAGER);
  }
  
  aomj a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      aomj localaomj2 = (aomj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      aomj localaomj1 = localaomj2;
      if (localaomj2 == null)
      {
        localaomj1 = new aomj();
        localaomj1.jdField_a_of_type_JavaLangString = paramString;
        localaomj1.jdField_a_of_type_Int = paramInt;
      }
      return localaomj1;
    }
  }
  
  public ArrayList<aomj> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("KeyHiddenChatList", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String[] arrayOfString = localObject[i].split("\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
            try
            {
              aomj localaomj = new aomj();
              localaomj.jdField_a_of_type_JavaLangString = arrayOfString[0];
              localaomj.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localaomj);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("tag_hidden_chat", 2, localThrowable, new Object[0]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aomj localaomj = (aomj)localIterator.next();
      localStringBuilder.append(localaomj.jdField_a_of_type_JavaLangString).append("|").append(localaomj.jdField_a_of_type_Int).append(";");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  public void a(Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("FirstSetHidden", false))
    {
      localSharedPreferences.edit().putBoolean("FirstSetHidden", true).commit();
      bhdj.a(paramActivity, 230, paramActivity.getString(2131696084), paramActivity.getString(2131696082), paramActivity.getString(2131718822), paramActivity.getString(2131696083), new aomf(this, paramActivity), new bhdx()).show();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
    }
  }
  
  void a(aomj paramaomj)
  {
    if ((paramaomj == null) || (TextUtils.isEmpty(paramaomj.jdField_a_of_type_JavaLangString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaomj.jdField_a_of_type_JavaLangString, paramaomj);
      a();
      return;
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      a();
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      a(a(paramString, paramInt));
      return;
    }
    a(paramString);
  }
  
  boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a();
        if (QLog.isColorLevel())
        {
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            QLog.d("tag_hidden_chat", 2, new Object[] { "doInitAllHidden(), dataList.size is ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (localObject1 == null) {
            break label158;
          }
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            aomj localaomj = (aomj)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localaomj.jdField_a_of_type_JavaLangString, localaomj);
          }
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "doInitAllHidden exception:" + localException.getMessage());
        }
        return false;
      }
    }
    label158:
    return true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aome
 * JD-Core Version:    0.7.0.1
 */