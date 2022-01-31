import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class bhlw
{
  bhlx jdField_a_of_type_Bhlx = new bhlx(this);
  HashMap<Integer, bhlv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ai a()
  {
    try
    {
      ai localai = aj.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isub" }));
      return localai;
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
  
  private void a(int paramInt, bhlv parambhlv)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambhlv);
    }
  }
  
  private int b(Context paramContext)
  {
    try
    {
      String str = bhlt.a(paramContext);
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = bgxq.a().b();
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
      b(10, bhlt.b(paramContext));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainPhoneNum error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  abstract int a(ai paramai);
  
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
  
  public bhlv a()
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
        if ((localObject == null) || (!((bhlv)localObject).a()) || (TextUtils.isEmpty(((bhlv)localObject).b()))) {}
      }
    }
    bhlv localbhlv;
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
          localbhlv = a(i);
          if (localbhlv != null)
          {
            localObject = localbhlv;
            if (localbhlv.a()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        break label132;
      }
      localbhlv = a(10);
      if (localbhlv == null) {
        break label132;
      }
      localObject = localbhlv;
    } while (!TextUtils.isEmpty(localbhlv.b()));
    label132:
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = j;
      for (;;)
      {
        if (i > 10) {
          break label169;
        }
        localbhlv = a(i);
        localObject = localbhlv;
        if (localbhlv != null) {
          break;
        }
        i += 1;
      }
    }
    label169:
    return null;
  }
  
  bhlv a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return (bhlv)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  void a(int paramInt, Boolean paramBoolean)
  {
    bhlv localbhlv2 = a(paramInt);
    bhlv localbhlv1 = localbhlv2;
    if (localbhlv2 == null) {
      localbhlv1 = new bhlv();
    }
    localbhlv1.a(paramBoolean.booleanValue());
    a(paramInt, localbhlv1);
  }
  
  void a(int paramInt, String paramString)
  {
    bhlv localbhlv2 = a(paramInt);
    bhlv localbhlv1 = localbhlv2;
    if (localbhlv2 == null) {
      localbhlv1 = new bhlv();
    }
    localbhlv1.a(paramString);
    a(paramInt, localbhlv1);
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
      ai localai = a();
      j = 2;
      int[] arrayOfInt2 = null;
      int[] arrayOfInt1 = null;
      i = j;
      if (localai != null) {
        arrayOfInt1 = arrayOfInt2;
      }
      try
      {
        arrayOfInt2 = localai.a();
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
      this.jdField_a_of_type_Bhlx.jdField_a_of_type_Int = i;
      if ((i > 1) && (a(paramContext) != 11))
      {
        this.jdField_a_of_type_Bhlx.jdField_a_of_type_Boolean = true;
        a(paramContext, arrayOfInt1);
        b(paramContext, arrayOfInt1);
        if (a(localai) != 0) {
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
      this.jdField_a_of_type_Bhlx.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    }
  }
  
  abstract int b(Context paramContext, int[] paramArrayOfInt);
  
  void b(int paramInt, String paramString)
  {
    bhlv localbhlv2 = a(paramInt);
    bhlv localbhlv1 = localbhlv2;
    if (localbhlv2 == null) {
      localbhlv1 = new bhlv();
    }
    localbhlv1.b(paramString);
    a(paramInt, localbhlv1);
  }
  
  abstract int c(Context paramContext, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhlw
 * JD-Core Version:    0.7.0.1
 */