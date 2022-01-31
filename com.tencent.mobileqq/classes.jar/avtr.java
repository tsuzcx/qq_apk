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

public class avtr
{
  private static volatile avtr jdField_a_of_type_Avtr;
  public static final String a;
  private Map<Integer, avta> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, avtk> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private avth a(int paramInt)
  {
    avth localavth2 = c(paramInt);
    avth localavth1 = localavth2;
    if (localavth2 == null) {
      localavth1 = b(paramInt);
    }
    return localavth1;
  }
  
  public static avtr a()
  {
    if (jdField_a_of_type_Avtr == null) {}
    try
    {
      if (jdField_a_of_type_Avtr == null)
      {
        jdField_a_of_type_Avtr = new avtr();
        jdField_a_of_type_Avtr.b();
      }
      return jdField_a_of_type_Avtr;
    }
    finally {}
  }
  
  private void a(List<avtk> arg1, List<avta> paramList1)
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
          avtk localavtk = (avtk)???.next();
          this.b.put(Integer.valueOf(localavtk.a()), localavtk);
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
        ??? = (avta)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((avta)???).a()), ???);
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
  
  private avth b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      avta localavta = (avta)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localavta != null) {
        return new avtf(localavta);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private avth c(int paramInt)
  {
    if (paramInt == 101) {
      return new avtm();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = amkg.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((amkg)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((amkg)localObject1).a("ark");
    Object localObject3 = ((amkg)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        amkh localamkh = (amkh)((Iterator)localObject2).next();
        ((List)localObject1).add(new avta(localamkh.a, localamkh.b, localamkh.c, localamkh.d, "", null));
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
            localArrayList.add(new avtk(((amkh)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public avth a(QQAppInterface paramQQAppInterface, Context paramContext, avol paramavol)
  {
    Object localObject1 = null;
    if (paramavol == null) {}
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
        } while (!(paramavol instanceof avpt));
        localObject2 = (avpt)paramavol;
        i = ((avpt)localObject2).f();
        paramavol = a(i);
        localObject1 = paramavol;
      } while (paramavol == null);
      str1 = ((avpt)localObject2).c();
      str2 = ((avpt)localObject2).e();
      localObject2 = ((avpt)localObject2).d();
      paramavol.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramavol;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramavol;
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
      avta localavta = (avta)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localavta != null)
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
 * Qualified Name:     avtr
 * JD-Core Version:    0.7.0.1
 */