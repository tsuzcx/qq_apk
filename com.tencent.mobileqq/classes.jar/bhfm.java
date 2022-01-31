import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bhfm
{
  private final HashMap<Integer, Object> a;
  public final bhfe[] a;
  
  private bhfm()
  {
    this.jdField_a_of_type_ArrayOfBhfe = new bhfe[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bhfe a(int paramInt)
  {
    return bhfo.a.c(paramInt);
  }
  
  public static bhfm a()
  {
    return bhfo.a;
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
  
  private void a(int paramInt, bhfe parambhfe)
  {
    this.jdField_a_of_type_ArrayOfBhfe[paramInt] = parambhfe;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bhfe b(int paramInt)
  {
    return bhfo.a.jdField_a_of_type_ArrayOfBhfe[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBhfe.length)
    {
      bhfe localbhfe = this.jdField_a_of_type_ArrayOfBhfe[i];
      urk.b("QIMManager", "destroy manager : %s", localbhfe);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBhfe)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localbhfe == null) {}
      }
      try
      {
        localbhfe.aZ_();
        this.jdField_a_of_type_ArrayOfBhfe[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBhfe[paramInt] != null;
  }
  
  public bhfe c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBhfe[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBhfe)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBhfe[paramInt];
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
      a(paramInt, (bhfe)localObject3);
      if (localObject3 != null)
      {
        ((bhfe)localObject3).aY_();
        urk.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new bhko();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bjin();
      continue;
      localObject3 = new bhkc();
      continue;
      localObject3 = new bhgs();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bhgf();
      continue;
      localObject3 = new bhiu();
      continue;
      localObject3 = new bhjl();
      continue;
      localObject3 = new bhki();
      continue;
      localObject3 = new bhdr();
      continue;
      localObject3 = new bhlf();
      continue;
      localObject3 = new bhhb();
      continue;
      localObject3 = new bhzl();
      continue;
      localObject3 = new bgxx();
      continue;
      localObject3 = new bgyb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhfm
 * JD-Core Version:    0.7.0.1
 */