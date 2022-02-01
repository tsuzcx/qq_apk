import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bcko
{
  private static volatile bcko jdField_a_of_type_Bcko;
  public static final String a;
  private Map<Integer, bcjx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, bckh> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private bcke a(int paramInt)
  {
    bcke localbcke2 = c(paramInt);
    bcke localbcke1 = localbcke2;
    if (localbcke2 == null) {
      localbcke1 = b(paramInt);
    }
    return localbcke1;
  }
  
  public static bcko a()
  {
    if (jdField_a_of_type_Bcko == null) {}
    try
    {
      if (jdField_a_of_type_Bcko == null)
      {
        jdField_a_of_type_Bcko = new bcko();
        jdField_a_of_type_Bcko.b();
      }
      return jdField_a_of_type_Bcko;
    }
    finally {}
  }
  
  private void a(List<bckh> arg1, List<bcjx> paramList1)
  {
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， nativesize :" + ???.size());
      }
      synchronized (this.b)
      {
        this.b.clear();
        ??? = ???.iterator();
        if (???.hasNext())
        {
          bckh localbckh = (bckh)???.next();
          this.b.put(Integer.valueOf(localbckh.a()), localbckh);
        }
      }
    }
    for (;;)
    {
      if (paramList1 == null) {
        break label264;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize:" + paramList1.size());
      }
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        ??? = (bcjx)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((bcjx)???).a()), ???);
      }
      synchronized (this.b)
      {
        this.b.clear();
        if (QLog.isColorLevel()) {
          QLog.d("RichNodeFactory", 2, "updateConfig， nativesize = 0");
        }
      }
    }
    for (;;)
    {
      return;
      label264:
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize = 0");
        return;
      }
    }
  }
  
  private bcke b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      bcjx localbcjx = (bcjx)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbcjx != null) {
        return new bckc(localbcjx);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private bcke c(int paramInt)
  {
    if (paramInt == 101) {
      return new bckj();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = armh.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((armh)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((armh)localObject1).a("ark");
    Object localObject3 = ((armh)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        armi localarmi = (armi)((Iterator)localObject2).next();
        ((List)localObject1).add(new bcjx(localarmi.a, localarmi.b, localarmi.c, localarmi.d, "", null));
      }
    }
    for (;;)
    {
      localObject2 = localArrayList;
      if (localObject3 != null)
      {
        localObject2 = localArrayList;
        if (((ArrayList)localObject3).size() > 0)
        {
          localArrayList = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          for (;;)
          {
            localObject2 = localArrayList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localArrayList.add(new bckh(((armi)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public bcke a(QQAppInterface paramQQAppInterface, Context paramContext, bcfh parambcfh)
  {
    Object localObject1 = null;
    if (parambcfh == null) {}
    Object localObject2;
    String str1;
    String str2;
    do
    {
      int i;
      do
      {
        do
        {
          return localObject1;
        } while (!(parambcfh instanceof bcgp));
        localObject2 = (bcgp)parambcfh;
        i = ((bcgp)localObject2).f();
        parambcfh = a(i);
        localObject1 = parambcfh;
      } while (parambcfh == null);
      str1 = ((bcgp)localObject2).c();
      str2 = ((bcgp)localObject2).e();
      localObject2 = ((bcgp)localObject2).d();
      parambcfh.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = parambcfh;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return parambcfh;
  }
  
  public void a()
  {
    c();
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "nodeExist， id:" + paramInt);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "nodeExist， switch off");
      }
      return false;
    }
    synchronized (this.b)
    {
      if (this.b.get(Integer.valueOf(paramInt)) != null) {
        return true;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      bcjx localbcjx = (bcjx)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbcjx != null)
      {
        return true;
        localObject1 = finally;
        throw localObject1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcko
 * JD-Core Version:    0.7.0.1
 */