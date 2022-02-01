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

public class bcku
{
  private static volatile bcku jdField_a_of_type_Bcku;
  public static final String a;
  private Map<Integer, bckd> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, bckn> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private bckk a(int paramInt)
  {
    bckk localbckk2 = c(paramInt);
    bckk localbckk1 = localbckk2;
    if (localbckk2 == null) {
      localbckk1 = b(paramInt);
    }
    return localbckk1;
  }
  
  public static bcku a()
  {
    if (jdField_a_of_type_Bcku == null) {}
    try
    {
      if (jdField_a_of_type_Bcku == null)
      {
        jdField_a_of_type_Bcku = new bcku();
        jdField_a_of_type_Bcku.b();
      }
      return jdField_a_of_type_Bcku;
    }
    finally {}
  }
  
  private void a(List<bckn> arg1, List<bckd> paramList1)
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
          bckn localbckn = (bckn)???.next();
          this.b.put(Integer.valueOf(localbckn.a()), localbckn);
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
        ??? = (bckd)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((bckd)???).a()), ???);
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
  
  private bckk b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      bckd localbckd = (bckd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbckd != null) {
        return new bcki(localbckd);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private bckk c(int paramInt)
  {
    if (paramInt == 101) {
      return new bckp();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = aroy.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((aroy)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((aroy)localObject1).a("ark");
    Object localObject3 = ((aroy)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aroz localaroz = (aroz)((Iterator)localObject2).next();
        ((List)localObject1).add(new bckd(localaroz.a, localaroz.b, localaroz.c, localaroz.d, "", null));
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
            localArrayList.add(new bckn(((aroz)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public bckk a(QQAppInterface paramQQAppInterface, Context paramContext, bcfp parambcfp)
  {
    Object localObject1 = null;
    if (parambcfp == null) {}
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
        } while (!(parambcfp instanceof bcgx));
        localObject2 = (bcgx)parambcfp;
        i = ((bcgx)localObject2).f();
        parambcfp = a(i);
        localObject1 = parambcfp;
      } while (parambcfp == null);
      str1 = ((bcgx)localObject2).c();
      str2 = ((bcgx)localObject2).e();
      localObject2 = ((bcgx)localObject2).d();
      parambcfp.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = parambcfp;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return parambcfp;
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
      bckd localbckd = (bckd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbckd != null)
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
 * Qualified Name:     bcku
 * JD-Core Version:    0.7.0.1
 */