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

public class bmql
{
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final bmqj[] jdField_a_of_type_ArrayOfBmqj = new bmqj[20];
  
  public static bmqj a(int paramInt)
  {
    return bmqn.a().c(paramInt);
  }
  
  public static bmql a()
  {
    return bmqn.a();
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
  
  public static bmqj b(int paramInt)
  {
    return bmqn.a().jdField_a_of_type_ArrayOfBmqj[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfBmqj.length)
    {
      Object localObject1;
      synchronized (this.jdField_a_of_type_ArrayOfBmqj)
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
    return this.jdField_a_of_type_ArrayOfBmqj[paramInt] != null;
  }
  
  public bmqj c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfBmqj[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfBmqj)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfBmqj[paramInt];
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
      this.jdField_a_of_type_ArrayOfBmqj[paramInt] = localObject3;
      if (localObject3 != null)
      {
        ((bmqj)localObject3).onInit();
        xvv.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new bmum();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new boba();
      continue;
      localObject3 = new bmua();
      continue;
      localObject3 = new bmrr();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new bmre();
      continue;
      localObject3 = new bmtm();
      continue;
      localObject3 = new bmug();
      continue;
      localObject3 = new blie();
      continue;
      localObject3 = new bmuq();
      continue;
      localObject3 = new bmsa();
      continue;
      localObject3 = new bnbu();
      continue;
      localObject3 = new bluy();
      continue;
      localObject3 = new AEPlayShowMaterialManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmql
 * JD-Core Version:    0.7.0.1
 */