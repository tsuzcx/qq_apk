import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bojv
{
  private final HashMap<Integer, Object> a;
  public final bojn[] a;
  
  private bojv()
  {
    this.jdField_a_of_type_ArrayOfBojn = new bojn[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bojn a(int paramInt)
  {
    return bojx.a.c(paramInt);
  }
  
  public static bojv a()
  {
    return bojx.a;
  }
  
  public static AppInterface a()
  {
    return (AppInterface)a();
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  private void a(int paramInt, bojn parambojn)
  {
    this.jdField_a_of_type_ArrayOfBojn[paramInt] = parambojn;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bojn b(int paramInt)
  {
    return bojx.a.jdField_a_of_type_ArrayOfBojn[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBojn.length)
    {
      bojn localbojn = this.jdField_a_of_type_ArrayOfBojn[i];
      yqp.b("QIMManager", "destroy manager : %s", localbojn);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBojn)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localbojn == null) {}
      }
      try
      {
        localbojn.b();
        this.jdField_a_of_type_ArrayOfBojn[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBojn[paramInt] != null;
  }
  
  public bojn c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBojn[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBojn)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBojn[paramInt];
      if (localObject4 != null)
      {
        return localObject4;
        localObject5 = finally;
        throw localObject5;
      }
      if (!a()) {
        throw new RuntimeException("invalid process");
      }
    }
    finally {}
    Object localObject3 = localObject5;
    switch (paramInt)
    {
    default: 
      localObject3 = localObject5;
    }
    for (;;)
    {
      a(paramInt, (bojn)localObject3);
      if (localObject3 != null)
      {
        ((bojn)localObject3).a();
        yqp.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new booy();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bqgc();
      continue;
      localObject3 = new boom();
      continue;
      localObject3 = new bolb();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new boko();
      continue;
      localObject3 = new bone();
      continue;
      localObject3 = new bonv();
      continue;
      localObject3 = new boos();
      continue;
      localObject3 = new bnbo();
      continue;
      localObject3 = new bopp();
      continue;
      localObject3 = new bolk();
      continue;
      localObject3 = new boyw();
      continue;
      localObject3 = new bnpc();
      continue;
      localObject3 = new bnvo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojv
 * JD-Core Version:    0.7.0.1
 */