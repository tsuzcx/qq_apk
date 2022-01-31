import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class bgdj
{
  bgdk jdField_a_of_type_Bgdk = new bgdk(this);
  HashMap<Integer, bgdi> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private w a()
  {
    try
    {
      w localw = x.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isub" }));
      return localw;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("UniKingCardHelper/SimManager", "getIsub error:" + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void a(int paramInt, bgdi parambgdi)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambgdi);
    }
  }
  
  private int b(Context paramContext)
  {
    try
    {
      String str = bgdg.a(paramContext);
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = bfpj.a().b();
      }
      a(10, paramContext);
      a(10, Boolean.valueOf(true));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainIMSI error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  private int c(Context paramContext)
  {
    try
    {
      b(10, bgdg.b(paramContext));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainPhoneNum error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  int a(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = TelephonyManager.class.getMethod("isMultiSimEnabled", new Class[0]);
      if (localMethod != null)
      {
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        if (bool) {
          return 10;
        }
        return 11;
      }
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "isMultiSimEnabled error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  abstract int a(Context paramContext, int[] paramArrayOfInt);
  
  abstract int a(w paramw);
  
  public bgdi a()
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = 0;
      if (i <= 10)
      {
        localObject = a(i);
        if ((localObject == null) || (!((bgdi)localObject).a()) || (TextUtils.isEmpty(((bgdi)localObject).b()))) {}
      }
    }
    bgdi localbgdi;
    label98:
    do
    {
      return localObject;
      i += 1;
      break;
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        i = 0;
        for (;;)
        {
          if (i > 10) {
            break label98;
          }
          localbgdi = a(i);
          if (localbgdi != null)
          {
            localObject = localbgdi;
            if (localbgdi.a()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        break label132;
      }
      localbgdi = a(10);
      if (localbgdi == null) {
        break label132;
      }
      localObject = localbgdi;
    } while (!TextUtils.isEmpty(localbgdi.b()));
    label132:
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = j;
      for (;;)
      {
        if (i > 10) {
          break label169;
        }
        localbgdi = a(i);
        localObject = localbgdi;
        if (localbgdi != null) {
          break;
        }
        i += 1;
      }
    }
    label169:
    return null;
  }
  
  bgdi a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return (bgdi)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  void a(int paramInt, Boolean paramBoolean)
  {
    bgdi localbgdi2 = a(paramInt);
    bgdi localbgdi1 = localbgdi2;
    if (localbgdi2 == null) {
      localbgdi1 = new bgdi();
    }
    localbgdi1.a(paramBoolean.booleanValue());
    a(paramInt, localbgdi1);
  }
  
  void a(int paramInt, String paramString)
  {
    bgdi localbgdi2 = a(paramInt);
    bgdi localbgdi1 = localbgdi2;
    if (localbgdi2 == null) {
      localbgdi1 = new bgdi();
    }
    localbgdi1.a(paramString);
    a(paramInt, localbgdi1);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      a();
      b(paramContext);
      c(paramContext);
      w localw = a();
      j = 2;
      int[] arrayOfInt2 = null;
      int[] arrayOfInt1 = null;
      i = j;
      if (localw != null) {
        arrayOfInt1 = arrayOfInt2;
      }
      try
      {
        arrayOfInt2 = localw.a();
        i = j;
        arrayOfInt1 = arrayOfInt2;
        if (arrayOfInt2 != null)
        {
          arrayOfInt1 = arrayOfInt2;
          i = arrayOfInt2.length;
          arrayOfInt1 = arrayOfInt2;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QZLog.e("UniKingCardHelper/SimManager", "getActiveSubIdList error:" + localThrowable.getMessage());
          i = j;
        }
      }
      this.jdField_a_of_type_Bgdk.jdField_a_of_type_Int = i;
      if ((i > 1) && (a(paramContext) != 11))
      {
        this.jdField_a_of_type_Bgdk.jdField_a_of_type_Boolean = true;
        a(paramContext, arrayOfInt1);
        b(paramContext, arrayOfInt1);
        if (a(localw) != 0) {
          c(paramContext, arrayOfInt1);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      int j;
      int i;
      QZLog.e("UniKingCardHelper/SimManager", "initAllInfo error:" + paramContext.getMessage());
      return;
    }
    finally
    {
      this.jdField_a_of_type_Bgdk.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    }
  }
  
  abstract int b(Context paramContext, int[] paramArrayOfInt);
  
  void b(int paramInt, String paramString)
  {
    bgdi localbgdi2 = a(paramInt);
    bgdi localbgdi1 = localbgdi2;
    if (localbgdi2 == null) {
      localbgdi1 = new bgdi();
    }
    localbgdi1.b(paramString);
    a(paramInt, localbgdi1);
  }
  
  abstract int c(Context paramContext, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgdj
 * JD-Core Version:    0.7.0.1
 */