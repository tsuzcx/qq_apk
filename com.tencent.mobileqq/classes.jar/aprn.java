import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aprn
{
  private static aprn jdField_a_of_type_Aprn;
  CopyOnWriteArrayList<WeakReference<apsa>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<apsb>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<apsc>> c = new CopyOnWriteArrayList();
  
  public static aprn a()
  {
    try
    {
      if (jdField_a_of_type_Aprn == null) {
        jdField_a_of_type_Aprn = new aprn();
      }
      aprn localaprn = jdField_a_of_type_Aprn;
      return localaprn;
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
  
  public void a(apsa paramapsa)
  {
    if (paramapsa == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapsa) {
          return;
        }
      }
    }
    paramapsa = new WeakReference(paramapsa);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramapsa);
  }
  
  public void a(apsb paramapsb)
  {
    if (paramapsb == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapsb) {
          return;
        }
      }
    }
    paramapsb = new WeakReference(paramapsb);
    this.b.add(paramapsb);
  }
  
  public void a(apsc paramapsc)
  {
    if (paramapsc == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramapsc) {
          return;
        }
      }
    }
    paramapsc = new WeakReference(paramapsc);
    this.c.add(paramapsc);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      apsb localapsb = (apsb)((WeakReference)localIterator.next()).get();
      if (localapsb != null) {
        localapsb.a(paramEmoticonPackage);
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
          apsb localapsb = (apsb)((WeakReference)localIterator.next()).get();
          if (localapsb != null) {
            localapsb.b(paramEmoticonPackage, paramInt);
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
        apsa localapsa = (apsa)((WeakReference)localIterator.next()).get();
        if (localapsa != null) {
          localapsa.a(paramEmoticonPackage, paramInt1, paramInt2);
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
          apsb localapsb = (apsb)((WeakReference)localIterator.next()).get();
          if (localapsb == null) {
            continue;
          }
          localapsb.a(paramEmoticonPackage, paramInt1, paramInt3);
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
    if ((paramEmoticonPackage.status == 2) && (apvx.a(paramEmoticonPackage.updateFlag))) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        wxe.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((aufn)paramQQAppInterface.getManager(14)).a(paramEmoticonPackage);
      }
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        apsb localapsb = (apsb)((WeakReference)paramQQAppInterface.next()).get();
        if (localapsb != null) {
          localapsb.a(paramEmoticonPackage, paramInt2);
        }
      }
      paramEmoticonPackage.status = 0;
    }
    if (paramEmoticonPackage.type == 1) {}
    for (paramInt1 = 5;; paramInt1 = 4)
    {
      aufn.e(String.valueOf(paramInt2), paramInt1);
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
          apsc localapsc = (apsc)((WeakReference)localIterator.next()).get();
          if (localapsc != null) {
            localapsc.a(paramEmoticonPackage, paramInt, paramBundle);
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
  
  public void b(apsa paramapsa)
  {
    if (paramapsa == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramapsa) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(apsb paramapsb)
  {
    if (paramapsb == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramapsb) {
          this.b.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(apsc paramapsc)
  {
    if (paramapsc == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramapsc) {
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
      apvu.a(paramEmoticonPackage.epId);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        apsa localapsa = (apsa)((WeakReference)localIterator.next()).get();
        if (localapsa != null) {
          localapsa.a(paramEmoticonPackage);
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
        apsb localapsb = (apsb)((WeakReference)localIterator.next()).get();
        if (localapsb != null) {
          localapsb.b(paramEmoticonPackage, paramInt1, paramInt2);
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
      apsa localapsa = (apsa)((WeakReference)localIterator.next()).get();
      if (localapsa != null) {
        localapsa.b(paramEmoticonPackage);
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      aufn.c("0", i);
      return;
    }
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    apvu.a(paramEmoticonPackage.epId);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        apsb localapsb = (apsb)((WeakReference)localIterator.next()).get();
        if (localapsb != null) {
          localapsb.a(paramEmoticonPackage, 0);
        }
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      aufn.e("0", i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprn
 * JD-Core Version:    0.7.0.1
 */