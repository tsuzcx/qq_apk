import android.annotation.SuppressLint;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bogd
{
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final bogb[] jdField_a_of_type_ArrayOfBogb = new bogb[20];
  
  public static bogb a(int paramInt)
  {
    return bogf.a().c(paramInt);
  }
  
  public static bogd a()
  {
    return bogf.a();
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
  
  public static bogb b(int paramInt)
  {
    return bogf.a().jdField_a_of_type_ArrayOfBogb[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBogb.length)
    {
      Object localObject1;
      synchronized (this.jdField_a_of_type_ArrayOfBogb)
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
    return this.jdField_a_of_type_ArrayOfBogb[paramInt] != null;
  }
  
  public bogb c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBogb[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBogb)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBogb[paramInt];
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
      this.jdField_a_of_type_ArrayOfBogb[paramInt] = localObject3;
      if (localObject3 != null)
      {
        ((bogb)localObject3).onInit();
        ykq.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new boke();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new bpqs();
      continue;
      localObject3 = new bojs();
      continue;
      localObject3 = new bohj();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bogw();
      continue;
      localObject3 = new boje();
      continue;
      localObject3 = new bojy();
      continue;
      localObject3 = new bmuv();
      continue;
      localObject3 = new boki();
      continue;
      localObject3 = new bohs();
      continue;
      localObject3 = new borm();
      continue;
      localObject3 = new bnkb();
      continue;
      localObject3 = new AEPlayShowMaterialManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogd
 * JD-Core Version:    0.7.0.1
 */