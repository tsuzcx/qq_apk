import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class asig
{
  private static asig jdField_a_of_type_Asig;
  CopyOnWriteArrayList<WeakReference<asit>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<asiu>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<asiv>> c = new CopyOnWriteArrayList();
  
  public static asig a()
  {
    try
    {
      if (jdField_a_of_type_Asig == null) {
        jdField_a_of_type_Asig = new asig();
      }
      asig localasig = jdField_a_of_type_Asig;
      return localasig;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    synchronized (this.b)
    {
      this.b.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(asit paramasit)
  {
    if (paramasit == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramasit) {
          return;
        }
      }
    }
    paramasit = new WeakReference(paramasit);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramasit);
  }
  
  public void a(asiu paramasiu)
  {
    if (paramasiu == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramasiu) {
          return;
        }
      }
    }
    paramasiu = new WeakReference(paramasiu);
    this.b.add(paramasiu);
  }
  
  public void a(asiv paramasiv)
  {
    if (paramasiv == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramasiv) {
          return;
        }
      }
    }
    paramasiv = new WeakReference(paramasiv);
    this.c.add(paramasiv);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      asiu localasiu = (asiu)((WeakReference)localIterator.next()).get();
      if (localasiu != null) {
        localasiu.onPackageStart(paramEmoticonPackage);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          asiu localasiu = (asiu)((WeakReference)localIterator.next()).get();
          if (localasiu != null) {
            localasiu.onJsonComplete(paramEmoticonPackage, paramInt);
          }
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        asit localasit = (asit)((WeakReference)localIterator.next()).get();
        if (localasit != null) {
          localasit.onPackageMoved(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null)
    {
      if (paramInt2 != 0) {}
      for (;;)
      {
        synchronized (this.b)
        {
          Iterator localIterator = this.b.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          asiu localasiu = (asiu)((WeakReference)localIterator.next()).get();
          if (localasiu == null) {
            continue;
          }
          localasiu.onCoverComplete(paramEmoticonPackage, paramInt1, paramInt3);
        }
        paramInt3 = 0;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if ((paramEmoticonPackage == null) || (paramQQAppInterface == null)) {
      return;
    }
    if ((paramEmoticonPackage.status == 2) && (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))) {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        ykq.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticonPackage);
      }
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        asiu localasiu = (asiu)((WeakReference)paramQQAppInterface.next()).get();
        if (localasiu != null) {
          localasiu.onPackageEnd(paramEmoticonPackage, paramInt2);
        }
      }
      paramEmoticonPackage.status = 0;
    }
    if (paramEmoticonPackage.type == 1) {}
    for (paramInt1 = 5;; paramInt1 = 4)
    {
      awyr.e(String.valueOf(paramInt2), paramInt1);
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          asiv localasiv = (asiv)((WeakReference)localIterator.next()).get();
          if (localasiv != null) {
            localasiv.a(paramEmoticonPackage, paramInt, paramBundle);
          }
        }
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, int paramInt, QQAppInterface paramQQAppInterface)
  {
    a(paramEmoticonPackage, -1, paramInt, paramQQAppInterface);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      c(paramEmoticonPackage);
      paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
      String str = paramQQAppInterface.getString("LAST_ADD_EMO_PACKAGE", "");
      str = str + "|" + paramEmoticonPackage.epId;
      paramQQAppInterface.edit().putString("LAST_ADD_EMO_PACKAGE", str).commit();
    } while (3 != paramEmoticonPackage.jobType);
    paramQQAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
  }
  
  public void b(asit paramasit)
  {
    if (paramasit == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramasit) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(asiu paramasiu)
  {
    if (paramasiu == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramasiu) {
          this.b.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(asiv paramasiv)
  {
    if (paramasiv == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramasiv) {
          this.c.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        asit localasit = (asit)((WeakReference)localIterator.next()).get();
        if (localasit != null) {
          localasit.onPackageDeleted(paramEmoticonPackage);
        }
      }
    }
  }
  
  protected void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        asiu localasiu = (asiu)((WeakReference)localIterator.next()).get();
        if (localasiu != null) {
          localasiu.onPackageProgress(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  protected void c(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      asit localasit = (asit)((WeakReference)localIterator.next()).get();
      if (localasit != null) {
        localasit.onPackageAdded(paramEmoticonPackage);
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      awyr.c("0", i);
      return;
    }
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    EmoticonTabAdapter.removeTabDrawableCache(paramEmoticonPackage.epId);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        asiu localasiu = (asiu)((WeakReference)localIterator.next()).get();
        if (localasiu != null) {
          localasiu.onPackageEnd(paramEmoticonPackage, 0);
        }
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      awyr.e("0", i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asig
 * JD-Core Version:    0.7.0.1
 */