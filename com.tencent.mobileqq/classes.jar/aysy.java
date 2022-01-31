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

public class aysy
{
  private static volatile aysy jdField_a_of_type_Aysy;
  public static final String a;
  private Map<Integer, aysh> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, aysr> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private ayso a(int paramInt)
  {
    ayso localayso2 = c(paramInt);
    ayso localayso1 = localayso2;
    if (localayso2 == null) {
      localayso1 = b(paramInt);
    }
    return localayso1;
  }
  
  public static aysy a()
  {
    if (jdField_a_of_type_Aysy == null) {}
    try
    {
      if (jdField_a_of_type_Aysy == null)
      {
        jdField_a_of_type_Aysy = new aysy();
        jdField_a_of_type_Aysy.b();
      }
      return jdField_a_of_type_Aysy;
    }
    finally {}
  }
  
  private void a(List<aysr> arg1, List<aysh> paramList1)
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
          aysr localaysr = (aysr)???.next();
          this.b.put(Integer.valueOf(localaysr.a()), localaysr);
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
        ??? = (aysh)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((aysh)???).a()), ???);
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
  
  private ayso b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      aysh localaysh = (aysh)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localaysh != null) {
        return new aysm(localaysh);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private ayso c(int paramInt)
  {
    if (paramInt == 101) {
      return new ayst();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = aowh.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((aowh)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((aowh)localObject1).a("ark");
    Object localObject3 = ((aowh)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aowi localaowi = (aowi)((Iterator)localObject2).next();
        ((List)localObject1).add(new aysh(localaowi.a, localaowi.b, localaowi.c, localaowi.d, "", null));
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
            localArrayList.add(new aysr(((aowi)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public ayso a(QQAppInterface paramQQAppInterface, Context paramContext, ayns paramayns)
  {
    Object localObject1 = null;
    if (paramayns == null) {}
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
        } while (!(paramayns instanceof aypa));
        localObject2 = (aypa)paramayns;
        i = ((aypa)localObject2).f();
        paramayns = a(i);
        localObject1 = paramayns;
      } while (paramayns == null);
      str1 = ((aypa)localObject2).c();
      str2 = ((aypa)localObject2).e();
      localObject2 = ((aypa)localObject2).d();
      paramayns.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramayns;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramayns;
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
      aysh localaysh = (aysh)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localaysh != null)
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
 * Qualified Name:     aysy
 * JD-Core Version:    0.7.0.1
 */