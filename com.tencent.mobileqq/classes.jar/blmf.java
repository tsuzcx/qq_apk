import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class blmf
{
  private final HashMap<Integer, Object> a;
  public final bllx[] a;
  
  private blmf()
  {
    this.jdField_a_of_type_ArrayOfBllx = new bllx[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bllx a(int paramInt)
  {
    return blmh.a.c(paramInt);
  }
  
  public static blmf a()
  {
    return blmh.a;
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
  
  private void a(int paramInt, bllx parambllx)
  {
    this.jdField_a_of_type_ArrayOfBllx[paramInt] = parambllx;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bllx b(int paramInt)
  {
    return blmh.a.jdField_a_of_type_ArrayOfBllx[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBllx.length)
    {
      bllx localbllx = this.jdField_a_of_type_ArrayOfBllx[i];
      wsv.b("QIMManager", "destroy manager : %s", localbllx);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBllx)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localbllx == null) {}
      }
      try
      {
        localbllx.b();
        this.jdField_a_of_type_ArrayOfBllx[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBllx[paramInt] != null;
  }
  
  public bllx c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBllx[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBllx)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBllx[paramInt];
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
      a(paramInt, (bllx)localObject3);
      if (localObject3 != null)
      {
        ((bllx)localObject3).a();
        wsv.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new blri();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bnkz();
      continue;
      localObject3 = new blqw();
      continue;
      localObject3 = new blnl();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new blmy();
      continue;
      localObject3 = new blpo();
      continue;
      localObject3 = new blqf();
      continue;
      localObject3 = new blrc();
      continue;
      localObject3 = new bkiu();
      continue;
      localObject3 = new blrz();
      continue;
      localObject3 = new blnu();
      continue;
      localObject3 = new bmde();
      continue;
      localObject3 = new bkvr();
      continue;
      localObject3 = new blbz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmf
 * JD-Core Version:    0.7.0.1
 */