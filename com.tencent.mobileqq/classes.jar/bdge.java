import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bdge
{
  public int a;
  public long a;
  public String a;
  public List<Long> a;
  public int b;
  public long b;
  
  bdge()
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  bdge(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
  }
  
  private static long a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return paramLong;
  }
  
  public static bdge a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      bdge localbdge = new bdge();
      paramString = Uri.parse(paramString);
      localbdge.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localbdge.jdField_a_of_type_Int = a(paramString.getQueryParameter("loadCTs"), 0);
      localbdge.jdField_a_of_type_Long = a(paramString.getQueryParameter("lastLCT"), 0L);
      localbdge.jdField_a_of_type_JavaUtilList = a(paramString.getQueryParameters("prc"));
      localbdge.jdField_b_of_type_Long = a(paramString.getQueryParameter("runCPT"), 0L);
      localbdge.jdField_b_of_type_Int = a(paramString.getQueryParameter("runCTs"), 0);
      return localbdge;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoCrashInfo", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private static List<Long> a(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = a((String)paramList.next(), 0L);
        if (l > 0L) {
          localLinkedList.add(Long.valueOf(l));
        }
      }
    }
    if (localLinkedList.size() > 1) {
      Collections.sort(localLinkedList);
    }
    return localLinkedList;
  }
  
  static void a(String paramString1, String paramString2, int paramInt)
  {
    bdge localbdge = bdgf.a(paramString1, paramString2);
    if (localbdge == null)
    {
      localbdge = new bdge(paramString2);
      if (paramInt != 1) {
        break label163;
      }
      localbdge.jdField_b_of_type_Int += 1;
      if (localbdge.jdField_b_of_type_Int >= 999) {
        localbdge.jdField_b_of_type_Int = 0;
      }
      l = NetConnInfoCenter.getServerTimeMillis();
      localbdge.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      if (localbdge.jdField_a_of_type_JavaUtilList.size() >= 3)
      {
        if (Math.abs(l - ((Long)localbdge.jdField_a_of_type_JavaUtilList.get(0)).longValue()) > 1800000L) {
          break label134;
        }
        localbdge.jdField_b_of_type_Long = l;
      }
      bdgf.a(localbdge, paramString1);
    }
    label134:
    label163:
    while (paramInt != 0) {
      for (;;)
      {
        long l;
        return;
        break;
        while (localbdge.jdField_a_of_type_JavaUtilList.size() >= 3) {
          localbdge.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
    localbdge.jdField_a_of_type_Int += 1;
    if (localbdge.jdField_a_of_type_Int > 2)
    {
      bdgl.a().a(paramString1, paramString2);
      bdgf.a(paramString1);
      bdgf.c(paramString1);
      return;
    }
    if (localbdge.jdField_a_of_type_Int == 1) {
      localbdge.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    }
    bdgf.a(localbdge, paramString1);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&loadCTs=").append(this.jdField_a_of_type_Int).append("&lastLCT=").append(this.jdField_a_of_type_Long).append("&runCTs=").append(this.jdField_b_of_type_Int).append("&runCPT=").append(this.jdField_b_of_type_Long);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      localStringBuilder.append("&prc=").append(l);
    }
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Long > 0L;
  }
  
  boolean b()
  {
    return (a()) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) <= 7200000L);
  }
  
  boolean c()
  {
    return (this.jdField_a_of_type_Int >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) < 21600000L);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) >= 21600000L);
  }
  
  boolean e()
  {
    return (this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Int % 3 == 0);
  }
  
  boolean f()
  {
    if (d()) {}
    while ((a()) || (e())) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return "SoCrashInfo{mSoVer='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mLoadCrashTimes=" + this.jdField_a_of_type_Int + ", mFirstLoadCrashTime=" + this.jdField_a_of_type_Long + ", mRunCrashProtectTime=" + this.jdField_b_of_type_Long + ", mPreRunCrashTimes=" + this.jdField_a_of_type_JavaUtilList + ", mRunCrashTimes=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdge
 * JD-Core Version:    0.7.0.1
 */