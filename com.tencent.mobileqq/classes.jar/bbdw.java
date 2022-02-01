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

public class bbdw
{
  private static volatile bbdw jdField_a_of_type_Bbdw;
  public static final String a;
  private Map<Integer, bbdf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, bbdp> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private bbdm a(int paramInt)
  {
    bbdm localbbdm2 = c(paramInt);
    bbdm localbbdm1 = localbbdm2;
    if (localbbdm2 == null) {
      localbbdm1 = b(paramInt);
    }
    return localbbdm1;
  }
  
  public static bbdw a()
  {
    if (jdField_a_of_type_Bbdw == null) {}
    try
    {
      if (jdField_a_of_type_Bbdw == null)
      {
        jdField_a_of_type_Bbdw = new bbdw();
        jdField_a_of_type_Bbdw.b();
      }
      return jdField_a_of_type_Bbdw;
    }
    finally {}
  }
  
  private void a(List<bbdp> arg1, List<bbdf> paramList1)
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
          bbdp localbbdp = (bbdp)???.next();
          this.b.put(Integer.valueOf(localbbdp.a()), localbbdp);
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
        ??? = (bbdf)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((bbdf)???).a()), ???);
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
  
  private bbdm b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      bbdf localbbdf = (bbdf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbbdf != null) {
        return new bbdk(localbbdf);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private bbdm c(int paramInt)
  {
    if (paramInt == 101) {
      return new bbdr();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = aqiw.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((aqiw)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((aqiw)localObject1).a("ark");
    Object localObject3 = ((aqiw)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aqix localaqix = (aqix)((Iterator)localObject2).next();
        ((List)localObject1).add(new bbdf(localaqix.a, localaqix.b, localaqix.c, localaqix.d, "", null));
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
            localArrayList.add(new bbdp(((aqix)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public bbdm a(QQAppInterface paramQQAppInterface, Context paramContext, bayr parambayr)
  {
    Object localObject1 = null;
    if (parambayr == null) {}
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
        } while (!(parambayr instanceof bazz));
        localObject2 = (bazz)parambayr;
        i = ((bazz)localObject2).f();
        parambayr = a(i);
        localObject1 = parambayr;
      } while (parambayr == null);
      str1 = ((bazz)localObject2).c();
      str2 = ((bazz)localObject2).e();
      localObject2 = ((bazz)localObject2).d();
      parambayr.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = parambayr;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return parambayr;
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
      bbdf localbbdf = (bbdf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localbbdf != null)
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
 * Qualified Name:     bbdw
 * JD-Core Version:    0.7.0.1
 */