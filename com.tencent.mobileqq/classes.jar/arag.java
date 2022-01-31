import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class arag
{
  public static arag a;
  public int a;
  public boolean a;
  public int b = 1;
  public int c = 256;
  
  public arag()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    arag localarag = a();
    if (localarag != null) {
      return localarag.c;
    }
    return 256;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return paramInt;
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("HotVideoDPC", 2, "StringToInt Exception! " + paramString);
    return paramInt;
  }
  
  public static arag a()
  {
    if ((jdField_a_of_type_Arag == null) || (jdField_a_of_type_Arag.jdField_a_of_type_Boolean)) {
      jdField_a_of_type_Arag = b();
    }
    return jdField_a_of_type_Arag;
  }
  
  public static boolean a()
  {
    arag localarag = a();
    return (localarag != null) && (localarag.b == 1);
  }
  
  public static arag b()
  {
    int i1 = 256;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoDPC", 2, "loadHotVideoDPC!");
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HotVCfg.name());
    QLog.i("HotVideoDPC", 2, "loadHotVideoDPC dpcValue: " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int k;
      int m;
      int i;
      int j;
      int n;
      try
      {
        localObject = str.split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          k = a(localObject[0], 0);
          m = k;
        }
      }
      catch (Exception localException2)
      {
        Object localObject;
        m = 0;
        j = 1;
        continue;
      }
      try
      {
        i = a(localObject[1], 0);
        j = i;
        m = k;
        try
        {
          n = a(localObject[2], 256);
          localObject = new arag();
          ((arag)localObject).jdField_a_of_type_Int = k;
          ((arag)localObject).b = i;
          ((arag)localObject).c = n;
          if ((str == null) || (str.isEmpty())) {
            bool = true;
          }
          ((arag)localObject).jdField_a_of_type_Boolean = bool;
          return localObject;
        }
        catch (Exception localException1) {}
        if ((localObject != null) && (localObject.length == 1)) {
          k = a(localObject[0], 0);
        }
      }
      catch (Exception localException3)
      {
        j = 1;
        continue;
      }
      try
      {
        QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 1");
        i = 1;
        n = i1;
      }
      catch (Exception localException4)
      {
        m = k;
        j = 1;
        continue;
      }
      if ((localObject != null) && (localObject.length == 2))
      {
        k = a(localObject[0], 0);
        m = k;
        i = a(localObject[1], 0);
        j = i;
        m = k;
        QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 2");
        n = i1;
        continue;
        n = i1;
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.e("HotVideoDPC", 2, "loadHotVideoDPC exception:", localException1);
          n = i1;
          i = j;
          k = m;
        }
      }
      else
      {
        i = 1;
        k = 0;
        n = i1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" hotVideoBlurSwitch: ").append(this.b);
    localStringBuilder.append(" hotVideoBlurMemory: ").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arag
 * JD-Core Version:    0.7.0.1
 */