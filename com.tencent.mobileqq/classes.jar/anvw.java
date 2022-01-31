import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class anvw
{
  private static anvw jdField_a_of_type_Anvw;
  CopyOnWriteArrayList<WeakReference<anwj>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<anwk>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<anwl>> c = new CopyOnWriteArrayList();
  
  public static anvw a()
  {
    try
    {
      if (jdField_a_of_type_Anvw == null) {
        jdField_a_of_type_Anvw = new anvw();
      }
      anvw localanvw = jdField_a_of_type_Anvw;
      return localanvw;
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
  
  public void a(anwj paramanwj)
  {
    if (paramanwj == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwj) {
          return;
        }
      }
    }
    paramanwj = new WeakReference(paramanwj);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramanwj);
  }
  
  public void a(anwk paramanwk)
  {
    if (paramanwk == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwk) {
          return;
        }
      }
    }
    paramanwk = new WeakReference(paramanwk);
    this.b.add(paramanwk);
  }
  
  public void a(anwl paramanwl)
  {
    if (paramanwl == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwl) {
          return;
        }
      }
    }
    paramanwl = new WeakReference(paramanwl);
    this.c.add(paramanwl);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      anwk localanwk = (anwk)((WeakReference)localIterator.next()).get();
      if (localanwk != null) {
        localanwk.a(paramEmoticonPackage);
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
          anwk localanwk = (anwk)((WeakReference)localIterator.next()).get();
          if (localanwk != null) {
            localanwk.b(paramEmoticonPackage, paramInt);
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
        anwj localanwj = (anwj)((WeakReference)localIterator.next()).get();
        if (localanwj != null) {
          localanwj.a(paramEmoticonPackage, paramInt1, paramInt2);
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
          anwk localanwk = (anwk)((WeakReference)localIterator.next()).get();
          if (localanwk == null) {
            continue;
          }
          localanwk.a(paramEmoticonPackage, paramInt1, paramInt3);
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
    if ((paramEmoticonPackage.status == 2) && (anzr.a(paramEmoticonPackage.updateFlag))) {
      axqy.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        ved.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((askf)paramQQAppInterface.getManager(14)).a(paramEmoticonPackage);
      }
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        anwk localanwk = (anwk)((WeakReference)paramQQAppInterface.next()).get();
        if (localanwk != null) {
          localanwk.a(paramEmoticonPackage, paramInt2);
        }
      }
      paramEmoticonPackage.status = 0;
    }
    if (paramEmoticonPackage.type == 1) {}
    for (paramInt1 = 5;; paramInt1 = 4)
    {
      askf.e(String.valueOf(paramInt2), paramInt1);
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
          anwl localanwl = (anwl)((WeakReference)localIterator.next()).get();
          if (localanwl != null) {
            localanwl.a(paramEmoticonPackage, paramInt, paramBundle);
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
  
  public void b(anwj paramanwj)
  {
    if (paramanwj == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwj) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(anwk paramanwk)
  {
    if (paramanwk == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwk) {
          this.b.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(anwl paramanwl)
  {
    if (paramanwl == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwl) {
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
      anzo.a(paramEmoticonPackage.epId);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        anwj localanwj = (anwj)((WeakReference)localIterator.next()).get();
        if (localanwj != null) {
          localanwj.a(paramEmoticonPackage);
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
        anwk localanwk = (anwk)((WeakReference)localIterator.next()).get();
        if (localanwk != null) {
          localanwk.b(paramEmoticonPackage, paramInt1, paramInt2);
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
      anwj localanwj = (anwj)((WeakReference)localIterator.next()).get();
      if (localanwj != null) {
        localanwj.b(paramEmoticonPackage);
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      askf.c("0", i);
      return;
    }
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    anzo.a(paramEmoticonPackage.epId);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        anwk localanwk = (anwk)((WeakReference)localIterator.next()).get();
        if (localanwk != null) {
          localanwk.a(paramEmoticonPackage, 0);
        }
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      askf.e("0", i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvw
 * JD-Core Version:    0.7.0.1
 */