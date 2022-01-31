import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class blqr
{
  private final HashMap<Integer, Object> a;
  public final blqj[] a;
  
  private blqr()
  {
    this.jdField_a_of_type_ArrayOfBlqj = new blqj[20];
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static blqj a(int paramInt)
  {
    return blqt.a.c(paramInt);
  }
  
  public static blqr a()
  {
    return blqt.a;
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
  
  private void a(int paramInt, blqj paramblqj)
  {
    this.jdField_a_of_type_ArrayOfBlqj[paramInt] = paramblqj;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static blqj b(int paramInt)
  {
    return blqt.a.jdField_a_of_type_ArrayOfBlqj[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBlqj.length)
    {
      blqj localblqj = this.jdField_a_of_type_ArrayOfBlqj[i];
      wxe.b("QIMManager", "destroy manager : %s", localblqj);
      Object localObject2;
      synchronized (this.jdField_a_of_type_ArrayOfBlqj)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (localblqj == null) {}
      }
      try
      {
        localblqj.b();
        this.jdField_a_of_type_ArrayOfBlqj[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBlqj[paramInt] != null;
  }
  
  public blqj c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBlqj[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBlqj)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBlqj[paramInt];
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
      a(paramInt, (blqj)localObject3);
      if (localObject3 != null)
      {
        ((blqj)localObject3).a();
        wxe.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new blvu();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bnpl();
      continue;
      localObject3 = new blvi();
      continue;
      localObject3 = new blrx();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new blrk();
      continue;
      localObject3 = new blua();
      continue;
      localObject3 = new blur();
      continue;
      localObject3 = new blvo();
      continue;
      localObject3 = new bknb();
      continue;
      localObject3 = new blwl();
      continue;
      localObject3 = new blsg();
      continue;
      localObject3 = new bmhq();
      continue;
      localObject3 = new bkzy();
      continue;
      localObject3 = new blgg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqr
 * JD-Core Version:    0.7.0.1
 */