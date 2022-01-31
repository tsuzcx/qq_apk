import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class bbnb
{
  public static int a;
  private static bbnb jdField_a_of_type_Bbnb;
  public static String a;
  public static String b;
  public static String c = "1";
  private Object jdField_a_of_type_JavaLangObject;
  private af[] jdField_a_of_type_ArrayOfAf;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager;
  private Object b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_JavaLangString = "0";
  }
  
  private bbnb()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static bbnb a()
  {
    if (jdField_a_of_type_Bbnb == null) {}
    try
    {
      jdField_a_of_type_Bbnb = new bbnb();
      return jdField_a_of_type_Bbnb;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfAf = new af[2];
    switch (jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 4: 
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        return;
        try
        {
          this.jdField_a_of_type_JavaLangObject = bbnh.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.jdField_b_of_type_JavaLangObject = bbnh.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        try
        {
          this.jdField_a_of_type_ArrayOfAf[0] = ag.a(bbni.a("isms"));
          this.jdField_a_of_type_ArrayOfAf[1] = ag.a(bbni.a("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null)
          {
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)bbnh.a("android.telephony.TelephonyManager", "getDefault"));
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)bbnh.a("android.telephony.TelephonyManager", "getSecondary"));
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
        catch (Error localError)
        {
          localError.printStackTrace();
          return;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject = BaseApplicationImpl.getContext().getSystemService("phone");
      af localaf = ag.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
      this.jdField_a_of_type_ArrayOfAf[0] = localaf;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    switch (jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return 0;
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        paramInt = ((Integer)bbnh.a(this.jdField_a_of_type_JavaLangObject, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      continue;
      if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null) {
        continue;
      }
      return this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[paramInt].getSimState();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        Object localObject = this.jdField_a_of_type_JavaLangObject;
        if (paramInt == 0) {}
        for (paramInt = i;; paramInt = 5)
        {
          paramInt = ((Integer)bbnh.a(localObject, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
          return paramInt;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt) == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnb
 * JD-Core Version:    0.7.0.1
 */