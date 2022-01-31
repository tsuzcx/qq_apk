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

public class awtm
{
  private static volatile awtm jdField_a_of_type_Awtm;
  public static final String a;
  private Map<Integer, awsv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, awtf> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private awtc a(int paramInt)
  {
    awtc localawtc2 = c(paramInt);
    awtc localawtc1 = localawtc2;
    if (localawtc2 == null) {
      localawtc1 = b(paramInt);
    }
    return localawtc1;
  }
  
  public static awtm a()
  {
    if (jdField_a_of_type_Awtm == null) {}
    try
    {
      if (jdField_a_of_type_Awtm == null)
      {
        jdField_a_of_type_Awtm = new awtm();
        jdField_a_of_type_Awtm.b();
      }
      return jdField_a_of_type_Awtm;
    }
    finally {}
  }
  
  private void a(List<awtf> arg1, List<awsv> paramList1)
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
          awtf localawtf = (awtf)???.next();
          this.b.put(Integer.valueOf(localawtf.a()), localawtf);
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
        ??? = (awsv)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((awsv)???).a()), ???);
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
  
  private awtc b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      awsv localawsv = (awsv)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localawsv != null) {
        return new awta(localawsv);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private awtc c(int paramInt)
  {
    if (paramInt == 101) {
      return new awth();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = anar.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((anar)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((anar)localObject1).a("ark");
    Object localObject3 = ((anar)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        anas localanas = (anas)((Iterator)localObject2).next();
        ((List)localObject1).add(new awsv(localanas.a, localanas.b, localanas.c, localanas.d, "", null));
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
            localArrayList.add(new awtf(((anas)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public awtc a(QQAppInterface paramQQAppInterface, Context paramContext, awog paramawog)
  {
    Object localObject1 = null;
    if (paramawog == null) {}
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
        } while (!(paramawog instanceof awpo));
        localObject2 = (awpo)paramawog;
        i = ((awpo)localObject2).f();
        paramawog = a(i);
        localObject1 = paramawog;
      } while (paramawog == null);
      str1 = ((awpo)localObject2).c();
      str2 = ((awpo)localObject2).e();
      localObject2 = ((awpo)localObject2).d();
      paramawog.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramawog;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramawog;
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
      awsv localawsv = (awsv)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localawsv != null)
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
 * Qualified Name:     awtm
 * JD-Core Version:    0.7.0.1
 */