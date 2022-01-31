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

public class ayop
{
  private static volatile ayop jdField_a_of_type_Ayop;
  public static final String a;
  private Map<Integer, ayny> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, ayoi> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private ayof a(int paramInt)
  {
    ayof localayof2 = c(paramInt);
    ayof localayof1 = localayof2;
    if (localayof2 == null) {
      localayof1 = b(paramInt);
    }
    return localayof1;
  }
  
  public static ayop a()
  {
    if (jdField_a_of_type_Ayop == null) {}
    try
    {
      if (jdField_a_of_type_Ayop == null)
      {
        jdField_a_of_type_Ayop = new ayop();
        jdField_a_of_type_Ayop.b();
      }
      return jdField_a_of_type_Ayop;
    }
    finally {}
  }
  
  private void a(List<ayoi> arg1, List<ayny> paramList1)
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
          ayoi localayoi = (ayoi)???.next();
          this.b.put(Integer.valueOf(localayoi.a()), localayoi);
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
        ??? = (ayny)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((ayny)???).a()), ???);
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
  
  private ayof b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      ayny localayny = (ayny)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localayny != null) {
        return new ayod(localayny);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private ayof c(int paramInt)
  {
    if (paramInt == 101) {
      return new ayok();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = aory.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((aory)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((aory)localObject1).a("ark");
    Object localObject3 = ((aory)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aorz localaorz = (aorz)((Iterator)localObject2).next();
        ((List)localObject1).add(new ayny(localaorz.a, localaorz.b, localaorz.c, localaorz.d, "", null));
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
            localArrayList.add(new ayoi(((aorz)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public ayof a(QQAppInterface paramQQAppInterface, Context paramContext, ayjj paramayjj)
  {
    Object localObject1 = null;
    if (paramayjj == null) {}
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
        } while (!(paramayjj instanceof aykr));
        localObject2 = (aykr)paramayjj;
        i = ((aykr)localObject2).f();
        paramayjj = a(i);
        localObject1 = paramayjj;
      } while (paramayjj == null);
      str1 = ((aykr)localObject2).c();
      str2 = ((aykr)localObject2).e();
      localObject2 = ((aykr)localObject2).d();
      paramayjj.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramayjj;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramayjj;
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
      ayny localayny = (ayny)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localayny != null)
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
 * Qualified Name:     ayop
 * JD-Core Version:    0.7.0.1
 */