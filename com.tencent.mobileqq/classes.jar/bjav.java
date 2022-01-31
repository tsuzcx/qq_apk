import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bjav
{
  private final HashMap<Integer, Object> a;
  public final bjan[] a;
  
  private bjav()
  {
    this.jdField_a_of_type_ArrayOfBjan = new bjan[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bjan a(int paramInt)
  {
    return bjax.a.c(paramInt);
  }
  
  public static bjav a()
  {
    return bjax.a;
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
  
  private void a(int paramInt, bjan parambjan)
  {
    this.jdField_a_of_type_ArrayOfBjan[paramInt] = parambjan;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bjan b(int paramInt)
  {
    return bjax.a.jdField_a_of_type_ArrayOfBjan[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBjan.length)
    {
      bjan localbjan = this.jdField_a_of_type_ArrayOfBjan[i];
      ved.b("QIMManager", "destroy manager : %s", localbjan);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBjan)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localbjan == null) {}
      }
      try
      {
        localbjan.b();
        this.jdField_a_of_type_ArrayOfBjan[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBjan[paramInt] != null;
  }
  
  public bjan c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBjan[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBjan)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBjan[paramInt];
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
      a(paramInt, (bjan)localObject3);
      if (localObject3 != null)
      {
        ((bjan)localObject3).a();
        ved.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new bjfx();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bkzp();
      continue;
      localObject3 = new bjfl();
      continue;
      localObject3 = new bjcb();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bjbo();
      continue;
      localObject3 = new bjed();
      continue;
      localObject3 = new bjeu();
      continue;
      localObject3 = new bjfr();
      continue;
      localObject3 = new bigy();
      continue;
      localObject3 = new bjgo();
      continue;
      localObject3 = new bjck();
      continue;
      localObject3 = new bjru();
      continue;
      localObject3 = new birb();
      continue;
      localObject3 = new bixf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjav
 * JD-Core Version:    0.7.0.1
 */