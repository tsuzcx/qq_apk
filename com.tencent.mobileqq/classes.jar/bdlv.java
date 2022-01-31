import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class bdlv
{
  public static int a;
  private static bdlv jdField_a_of_type_Bdlv;
  public static String a;
  public static String b;
  public static String c = "1";
  private Object jdField_a_of_type_JavaLangObject;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager;
  private t[] jdField_a_of_type_ArrayOfT;
  private Object b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_JavaLangString = "0";
  }
  
  private bdlv()
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
  
  public static bdlv a()
  {
    if (jdField_a_of_type_Bdlv == null) {}
    try
    {
      jdField_a_of_type_Bdlv = new bdlv();
      return jdField_a_of_type_Bdlv;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfT = new t[2];
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
          this.jdField_a_of_type_JavaLangObject = bdmb.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.jdField_b_of_type_JavaLangObject = bdmb.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        try
        {
          this.jdField_a_of_type_ArrayOfT[0] = u.a(bdmc.a("isms"));
          this.jdField_a_of_type_ArrayOfT[1] = u.a(bdmc.a("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null)
          {
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)bdmb.a("android.telephony.TelephonyManager", "getDefault"));
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)bdmb.a("android.telephony.TelephonyManager", "getSecondary"));
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
      t localt = u.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
      this.jdField_a_of_type_ArrayOfT[0] = localt;
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
        paramInt = ((Integer)bdmb.a(this.jdField_a_of_type_JavaLangObject, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
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
          paramInt = ((Integer)bdmb.a(localObject, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
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
 * Qualified Name:     bdlv
 * JD-Core Version:    0.7.0.1
 */