import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.ComboLockManager.2;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class boln
  implements IEventReceiver
{
  public static final String a;
  int jdField_a_of_type_Int = -1;
  aniz jdField_a_of_type_Aniz = new bolp(this);
  bolq jdField_a_of_type_Bolq;
  bpyf jdField_a_of_type_Bpyf;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bojl.a();
  LockedCategory jdField_a_of_type_DovComQqImCaptureDataLockedCategory;
  public QIMFilterCategoryItem a;
  HashMap<String, LockedCategory> jdField_a_of_type_JavaUtilHashMap;
  volatile boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = alkn.jdField_a_of_type_JavaLangString + "/tencent/qim/share/";
  }
  
  public boln()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bolq == null)
    {
      this.jdField_a_of_type_Bolq = new bolq(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "registerStoryReceiver");
      }
      wfo.a().registerSubscriber(this.jdField_a_of_type_Bolq);
    }
  }
  
  public LockedCategory a(String paramString)
  {
    return (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bolq != null)
    {
      this.jdField_a_of_type_Bolq = new bolq(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "unregisterStoryReceiver");
      }
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Bolq);
      this.jdField_a_of_type_Bolq = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bpyf parambpyf)
  {
    if (this.jdField_a_of_type_Bpyf == parambpyf) {
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "same data");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "updateConfigData isfrist " + this.jdField_b_of_type_Boolean + " sendStory " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData first card.snedSrory " + this.jdField_a_of_type_Boolean);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = parambpyf.jdField_a_of_type_JavaUtilHashMap;
      this.jdField_a_of_type_Bpyf = parambpyf;
      parambpyf = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (parambpyf.hasNext())
      {
        Object localObject = (String)parambpyf.next();
        localObject = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((LockedCategory)localObject).jdField_a_of_type_Boolean = a(((LockedCategory)localObject).jdField_a_of_type_JavaLangString);
        if ((((LockedCategory)localObject).jdField_a_of_type_Boolean) && (((LockedCategory)localObject).jdField_a_of_type_Int == 2))
        {
          this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory = ((LockedCategory)localObject);
          c();
        }
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "updateConfigData " + localObject + " lock " + ((LockedCategory)localObject).jdField_a_of_type_Boolean);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    LockedCategory localLockedCategory;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      bool1 = false;
      i = -1;
      localLockedCategory = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("ComboLockManager", 2, "is locke " + paramString + " code" + i);
        if (i == 3) {
          QLog.i("ComboLockManager", 2, "islock result" + bool1 + " type " + localLockedCategory.jdField_a_of_type_Int + " mHaveSendStory " + this.jdField_a_of_type_Boolean);
        }
      }
      return bool1;
      localLockedCategory = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localLockedCategory == null)
      {
        bool1 = false;
      }
      else if (!localLockedCategory.jdField_a_of_type_Boolean)
      {
        bool1 = false;
        i = 1;
      }
      else if (localLockedCategory.a())
      {
        bool1 = false;
        i = 2;
      }
      else if (localLockedCategory.jdField_a_of_type_Int == 2)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString.equals(paramString)) {}
          }
        }
        else
        {
          bool1 = true;
        }
        i = 3;
      }
      else if (localLockedCategory.jdField_a_of_type_Int == 1)
      {
        if (!localLockedCategory.jdField_b_of_type_Boolean)
        {
          localLockedCategory.jdField_a_of_type_Boolean = bgsg.z(BaseApplicationImpl.getApplication(), paramString);
          localLockedCategory.jdField_b_of_type_Boolean = true;
        }
        bool1 = localLockedCategory.jdField_a_of_type_Boolean;
        i = 3;
      }
      else
      {
        bool1 = false;
        i = 3;
      }
    }
  }
  
  public boolean a(String paramString, Context paramContext)
  {
    boolean bool = false;
    if (a(paramString))
    {
      Object localObject2 = a(paramString).jdField_b_of_type_JavaLangString;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ComboLockManager", 1, "empty jump url");
        localObject1 = "https://ti.qq.com/unlocked/index.html?_wv=536870912&id=" + paramString;
      }
      localObject2 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("k_f_id", paramString);
      paramContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "handleLockItemClick id " + paramString);
      }
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "handleSendStory");
    }
    this.jdField_a_of_type_Boolean = true;
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Bolq);
    Object localObject = (anip)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Aniz, true);
    if (this.jdField_a_of_type_DovComQqImCaptureDataLockedCategory != null)
    {
      localObject = BaseApplicationImpl.getContext();
      bolo localbolo = new bolo(this, (Context)localObject);
      ThreadManager.getUIHandler().postDelayed(new ComboLockManager.2(this, (Context)localObject, localbolo), 1000L);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_Bpyf.a(this.jdField_a_of_type_Int).a;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        Object localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if (((FilterCategory)localObject2).a != null)
        {
          localObject2 = ((FilterCategory)localObject2).a.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!paramString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)) {
              break;
            }
            this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = localQIMFilterCategoryItem;
          }
        }
      }
    }
    label101:
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "setLockingItem " + paramString + " result " + this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boln
 * JD-Core Version:    0.7.0.1
 */