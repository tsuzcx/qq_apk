import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class anvr
{
  private static anvr jdField_a_of_type_Anvr;
  CopyOnWriteArrayList<WeakReference<anwe>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<anwf>> b = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<anwg>> c = new CopyOnWriteArrayList();
  
  public static anvr a()
  {
    try
    {
      if (jdField_a_of_type_Anvr == null) {
        jdField_a_of_type_Anvr = new anvr();
      }
      anvr localanvr = jdField_a_of_type_Anvr;
      return localanvr;
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
  
  public void a(anwe paramanwe)
  {
    if (paramanwe == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwe) {
          return;
        }
      }
    }
    paramanwe = new WeakReference(paramanwe);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramanwe);
  }
  
  public void a(anwf paramanwf)
  {
    if (paramanwf == null) {
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwf) {
          return;
        }
      }
    }
    paramanwf = new WeakReference(paramanwf);
    this.b.add(paramanwf);
  }
  
  public void a(anwg paramanwg)
  {
    if (paramanwg == null) {
      return;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramanwg) {
          return;
        }
      }
    }
    paramanwg = new WeakReference(paramanwg);
    this.c.add(paramanwg);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      anwf localanwf = (anwf)((WeakReference)localIterator.next()).get();
      if (localanwf != null) {
        localanwf.a(paramEmoticonPackage);
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
          anwf localanwf = (anwf)((WeakReference)localIterator.next()).get();
          if (localanwf != null) {
            localanwf.b(paramEmoticonPackage, paramInt);
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
        anwe localanwe = (anwe)((WeakReference)localIterator.next()).get();
        if (localanwe != null) {
          localanwe.a(paramEmoticonPackage, paramInt1, paramInt2);
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
          anwf localanwf = (anwf)((WeakReference)localIterator.next()).get();
          if (localanwf == null) {
            continue;
          }
          localanwf.a(paramEmoticonPackage, paramInt1, paramInt3);
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
    if ((paramEmoticonPackage.status == 2) && (anzm.a(paramEmoticonPackage.updateFlag))) {
      axqw.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        veg.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((askd)paramQQAppInterface.getManager(14)).a(paramEmoticonPackage);
      }
      paramQQAppInterface = this.b.iterator();
      while (paramQQAppInterface.hasNext())
      {
        anwf localanwf = (anwf)((WeakReference)paramQQAppInterface.next()).get();
        if (localanwf != null) {
          localanwf.a(paramEmoticonPackage, paramInt2);
        }
      }
      paramEmoticonPackage.status = 0;
    }
    if (paramEmoticonPackage.type == 1) {}
    for (paramInt1 = 5;; paramInt1 = 4)
    {
      askd.e(String.valueOf(paramInt2), paramInt1);
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
          anwg localanwg = (anwg)((WeakReference)localIterator.next()).get();
          if (localanwg != null) {
            localanwg.a(paramEmoticonPackage, paramInt, paramBundle);
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
  
  public void b(anwe paramanwe)
  {
    if (paramanwe == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwe) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(anwf paramanwf)
  {
    if (paramanwf == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwf) {
          this.b.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(anwg paramanwg)
  {
    if (paramanwg == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramanwg) {
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
      anzj.a(paramEmoticonPackage.epId);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        anwe localanwe = (anwe)((WeakReference)localIterator.next()).get();
        if (localanwe != null) {
          localanwe.a(paramEmoticonPackage);
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
        anwf localanwf = (anwf)((WeakReference)localIterator.next()).get();
        if (localanwf != null) {
          localanwf.b(paramEmoticonPackage, paramInt1, paramInt2);
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
      anwe localanwe = (anwe)((WeakReference)localIterator.next()).get();
      if (localanwe != null) {
        localanwe.b(paramEmoticonPackage);
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      askd.c("0", i);
      return;
    }
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    anzj.a(paramEmoticonPackage.epId);
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        anwf localanwf = (anwf)((WeakReference)localIterator.next()).get();
        if (localanwf != null) {
          localanwf.a(paramEmoticonPackage, 0);
        }
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      askd.e("0", i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvr
 * JD-Core Version:    0.7.0.1
 */