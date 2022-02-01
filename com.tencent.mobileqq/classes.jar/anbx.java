import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anbx
{
  private static anbx jdField_a_of_type_Anbx;
  private int jdField_a_of_type_Int = -2;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static anbx a()
  {
    try
    {
      if (jdField_a_of_type_Anbx == null) {
        jdField_a_of_type_Anbx = new anbx();
      }
      anbx localanbx = jdField_a_of_type_Anbx;
      return localanbx;
    }
    finally {}
  }
  
  private void a()
  {
    if ((this.b) || (this.c)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        int j = arrayOfThread.length;
        i = 0;
        if (i < j)
        {
          Thread localThread = arrayOfThread[i];
          if (localThread == null) {
            break label216;
          }
          if (localThread.getName() == null) {
            break label223;
          }
          localObject = localThread.getName();
          if ((this.b) && ("MSF-Receiver".equals(localObject))) {
            localThread.setPriority(1);
          } else if ((this.c) && (("logWriteThread".equals(localObject)) || (((String)localObject).startsWith("GlobalPool")) || (((String)localObject).startsWith("Face")) || (((String)localObject).startsWith("um-stack")) || (((String)localObject).startsWith("QQ_FTS")) || (((String)localObject).startsWith("httpcomm")))) {
            localThread.setPriority(1);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.Optimizer", 2, "", localException);
        }
        if (this.c)
        {
          ThreadManager.getSubThread().setPriority(1);
          ThreadManager.getFileThread().setPriority(1);
          ThreadManager.getRecentThreadLooper().getThread().setPriority(1);
        }
      }
      return;
      label216:
      i += 1;
      continue;
      label223:
      String str = "";
    }
  }
  
  private void a(DeviceProfileManager paramDeviceProfileManager, String[] paramArrayOfString)
  {
    float f = Float.parseFloat(paramArrayOfString[1]);
    if (paramDeviceProfileManager.jdField_a_of_type_Int * 1.0F / 10000.0F < f)
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramArrayOfString[0]).intValue();
      this.jdField_a_of_type_Boolean = "1".equals(paramArrayOfString[2]);
      this.b = "1".equals(paramArrayOfString[3]);
      this.c = "1".equals(paramArrayOfString[4]);
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 7)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      boolean bool1 = localSharedPreferences.getBoolean("enableUpdateIconStep", false);
      boolean bool2 = "1".equals(paramArrayOfString[7]);
      if (bool1 != bool2) {
        localSharedPreferences.edit().putBoolean("enableUpdateIconStep", bool2).commit();
      }
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 6)
    {
      if ("1".equals(paramArrayOfString[6])) {
        com.tencent.common.config.AppSetting.e = true;
      }
    }
    else {
      return;
    }
    com.tencent.common.config.AppSetting.e = false;
  }
  
  private void c(String[] paramArrayOfString)
  {
    File localFile;
    if (paramArrayOfString.length > 5)
    {
      localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "disableSmallLock");
      if (!"1".equals(paramArrayOfString[5])) {
        break label47;
      }
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    return;
    label47:
    localFile.createNewFile();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(DeviceProfileManager paramDeviceProfileManager)
  {
    Object localObject = paramDeviceProfileManager.a(DeviceProfileManager.DpcNames.qq_thread_config.name());
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager.Optimizer", 2, "config = " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {
          continue;
        }
        a(paramDeviceProfileManager, (String[])localObject);
        c((String[])localObject);
        b((String[])localObject);
        a((String[])localObject);
        a();
        return;
      }
      catch (Exception paramDeviceProfileManager)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThreadManager.Optimizer", 2, "", paramDeviceProfileManager);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbx
 * JD-Core Version:    0.7.0.1
 */