import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneClickReport;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class bmku
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public bmku()
  {
    this.mPluginNameSpace = "gdtReportPlugin";
  }
  
  private long a()
  {
    return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
  }
  
  private void a()
  {
    Log.i("gdtReportPlugin", "172\t" + a());
    bmfd.a().a().a(this.jdField_a_of_type_JavaUtilMap, 2014, 0, a(), 0L);
  }
  
  private void a(int paramInt, Map<String, Object> paramMap)
  {
    Log.i("gdtReportPlugin", "173\t" + a());
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; paramInt = 0)
    {
      bmfd.a().a().a(this.jdField_a_of_type_JavaUtilMap, 2014, 1, a(), paramInt);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getHost();
        String[] arrayOfString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private long b()
  {
    return SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
  }
  
  private void b()
  {
    Log.i("gdtReportPlugin", "129\t" + a());
    bmfd.a().a().a(this.jdField_a_of_type_JavaUtilMap, 2005, 0, b(), 0L);
  }
  
  private void b(int paramInt, Map<String, Object> paramMap)
  {
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (int i = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; i = 0)
    {
      bmfd.a().a().a(this.jdField_a_of_type_JavaUtilMap, 2000, paramInt, a(), i);
      Log.i("gdtReportPlugin", paramInt + 120 + "\t" + a());
      return;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    bmfd.a().a().a(this.jdField_a_of_type_JavaUtilMap, 2000, 0, a(), 0L);
    Log.i("gdtReportPlugin", "120\t" + a());
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (this.mRuntime.a().getIntent().getBooleanExtra("needGdtLandingPageReport", false)) {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (this.jdField_b_of_type_Int == 1)
        {
          if ((paramLong != 8589934593L) || (this.jdField_a_of_type_Int != 1) || (a(paramString))) {
            break label402;
          }
          a();
          this.jdField_b_of_type_Int = 2;
        }
        break;
      }
    }
    for (;;)
    {
      paramString = new blrv();
      paramString.c = String.valueOf(478);
      if (paramLong == 8589934599L)
      {
        paramString.d = String.valueOf(2);
        QZoneClickReport.report(this.mRuntime.a().getAccount(), paramString, true);
      }
      return false;
      if (paramLong != 8589934593L) {
        break;
      }
      if ((a(paramString)) && (this.jdField_b_of_type_Int == 0)) {
        this.jdField_b_of_type_Int = 1;
      }
      List localList = (List)this.mRuntime.a().getIntent().getSerializableExtra("FeedDataCookie");
      if ((localList != null) && (localList.size() == 1)) {
        this.jdField_a_of_type_JavaUtilMap = ((Map)localList.get(0));
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Int = 1;
      break;
      if (paramLong == 8589934594L)
      {
        this.jdField_a_of_type_Int = 2;
        c();
        break;
      }
      if (paramLong == 8589934595L)
      {
        this.jdField_a_of_type_Int = 3;
        b(1, paramMap);
        break;
      }
      if (paramLong == 8589934601L)
      {
        this.jdField_a_of_type_Int = 4;
        b(94, paramMap);
        b();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.jdField_a_of_type_Int = 4;
      b(95, paramMap);
      b();
      break;
      if (paramLong != 8589934597L) {
        break;
      }
      b();
      this.jdField_a_of_type_Int = 4;
      break;
      if (paramLong == 8589934593L)
      {
        this.jdField_a_of_type_Int = 4;
        b();
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.jdField_a_of_type_Int = 4;
      b();
      break;
      label402:
      if ((a(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
      {
        this.jdField_b_of_type_Int = 2;
        a(1, paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmku
 * JD-Core Version:    0.7.0.1
 */