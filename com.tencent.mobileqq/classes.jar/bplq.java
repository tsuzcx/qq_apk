import android.annotation.SuppressLint;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bplq
{
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final bpli[] jdField_a_of_type_ArrayOfBpli = new bpli[20];
  
  public static bpli a(int paramInt)
  {
    return bpls.a().c(paramInt);
  }
  
  public static bplq a()
  {
    return bpls.a();
  }
  
  public static AppInterface a()
  {
    return (AppInterface)a();
  }
  
  private static AppRuntime a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static bpli b(int paramInt)
  {
    return bpls.a().jdField_a_of_type_ArrayOfBpli[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBpli.length)
    {
      Object localObject1;
      synchronized (this.jdField_a_of_type_ArrayOfBpli)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfBpli[paramInt] != null;
  }
  
  public bpli c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBpli[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBpli)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBpli[paramInt];
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
      this.jdField_a_of_type_ArrayOfBpli[paramInt] = localObject3;
      if (localObject3 != null)
      {
        ((bpli)localObject3).a();
        yuk.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new bpqt();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new brhn();
      continue;
      localObject3 = new bpqh();
      continue;
      localObject3 = new bpmw();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bpmj();
      continue;
      localObject3 = new bpoz();
      continue;
      localObject3 = new bppq();
      continue;
      localObject3 = new bpqn();
      continue;
      localObject3 = new bocw();
      continue;
      localObject3 = new bprk();
      continue;
      localObject3 = new bpnf();
      continue;
      localObject3 = new bqar();
      continue;
      localObject3 = new boqr();
      continue;
      localObject3 = new bowy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplq
 * JD-Core Version:    0.7.0.1
 */