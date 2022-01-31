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

public class awtk
{
  private static volatile awtk jdField_a_of_type_Awtk;
  public static final String a;
  private Map<Integer, awst> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, awtd> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private awta a(int paramInt)
  {
    awta localawta2 = c(paramInt);
    awta localawta1 = localawta2;
    if (localawta2 == null) {
      localawta1 = b(paramInt);
    }
    return localawta1;
  }
  
  public static awtk a()
  {
    if (jdField_a_of_type_Awtk == null) {}
    try
    {
      if (jdField_a_of_type_Awtk == null)
      {
        jdField_a_of_type_Awtk = new awtk();
        jdField_a_of_type_Awtk.b();
      }
      return jdField_a_of_type_Awtk;
    }
    finally {}
  }
  
  private void a(List<awtd> arg1, List<awst> paramList1)
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
          awtd localawtd = (awtd)???.next();
          this.b.put(Integer.valueOf(localawtd.a()), localawtd);
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
        ??? = (awst)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((awst)???).a()), ???);
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
  
  private awta b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      awst localawst = (awst)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localawst != null) {
        return new awsy(localawst);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private awta c(int paramInt)
  {
    if (paramInt == 101) {
      return new awtf();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = anak.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((anak)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((anak)localObject1).a("ark");
    Object localObject3 = ((anak)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        anal localanal = (anal)((Iterator)localObject2).next();
        ((List)localObject1).add(new awst(localanal.a, localanal.b, localanal.c, localanal.d, "", null));
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
            localArrayList.add(new awtd(((anal)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public awta a(QQAppInterface paramQQAppInterface, Context paramContext, awoe paramawoe)
  {
    Object localObject1 = null;
    if (paramawoe == null) {}
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
        } while (!(paramawoe instanceof awpm));
        localObject2 = (awpm)paramawoe;
        i = ((awpm)localObject2).f();
        paramawoe = a(i);
        localObject1 = paramawoe;
      } while (paramawoe == null);
      str1 = ((awpm)localObject2).c();
      str2 = ((awpm)localObject2).e();
      localObject2 = ((awpm)localObject2).d();
      paramawoe.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramawoe;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramawoe;
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
      awst localawst = (awst)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localawst != null)
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
 * Qualified Name:     awtk
 * JD-Core Version:    0.7.0.1
 */