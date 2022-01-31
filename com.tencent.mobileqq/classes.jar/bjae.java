import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bjae
{
  private final HashMap<Integer, Object> a;
  public final bizw[] a;
  
  private bjae()
  {
    this.jdField_a_of_type_ArrayOfBizw = new bizw[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bizw a(int paramInt)
  {
    return bjag.a.c(paramInt);
  }
  
  public static bjae a()
  {
    return bjag.a;
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
  
  private void a(int paramInt, bizw parambizw)
  {
    this.jdField_a_of_type_ArrayOfBizw[paramInt] = parambizw;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bizw b(int paramInt)
  {
    return bjag.a.jdField_a_of_type_ArrayOfBizw[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBizw.length)
    {
      bizw localbizw = this.jdField_a_of_type_ArrayOfBizw[i];
      veg.b("QIMManager", "destroy manager : %s", localbizw);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBizw)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localbizw == null) {}
      }
      try
      {
        localbizw.b();
        this.jdField_a_of_type_ArrayOfBizw[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBizw[paramInt] != null;
  }
  
  public bizw c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBizw[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBizw)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBizw[paramInt];
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
      a(paramInt, (bizw)localObject3);
      if (localObject3 != null)
      {
        ((bizw)localObject3).a();
        veg.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new bjfg();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bkyy();
      continue;
      localObject3 = new bjeu();
      continue;
      localObject3 = new bjbk();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bjax();
      continue;
      localObject3 = new bjdm();
      continue;
      localObject3 = new bjed();
      continue;
      localObject3 = new bjfa();
      continue;
      localObject3 = new bigh();
      continue;
      localObject3 = new bjfx();
      continue;
      localObject3 = new bjbt();
      continue;
      localObject3 = new bjrd();
      continue;
      localObject3 = new biqk();
      continue;
      localObject3 = new biwo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjae
 * JD-Core Version:    0.7.0.1
 */