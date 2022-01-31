import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.report.BaseData;
import com.tencent.open.agent.report.ReportCenter.2;
import com.tencent.open.agent.report.ReportCenter.3;
import com.tencent.open.agent.report.ReportCenter.4;
import com.tencent.open.agent.report.ReportCenter.5;
import com.tencent.open.agent.report.ReportCenter.6;
import com.tencent.open.agent.report.ReportCenter.7;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfhz
{
  protected static bfhz a;
  public Handler a;
  public ArrayList<Serializable> a;
  protected Random a;
  protected Executor a;
  public ArrayList<Serializable> b;
  protected Executor b;
  protected Executor c = ThreadManager.newSerialExecutor();
  
  protected bfhz()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bfia(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newSerialExecutor();
    this.jdField_b_of_type_JavaUtilConcurrentExecutor = ThreadManager.newSerialExecutor();
  }
  
  public static bfhz a()
  {
    try
    {
      if (jdField_a_of_type_Bfhz == null) {
        jdField_a_of_type_Bfhz = new bfhz();
      }
      bfhz localbfhz = jdField_a_of_type_Bfhz;
      return localbfhz;
    }
    finally {}
  }
  
  public int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = bfmx.a(bfbm.a().a(), null).a("Common_CGIReportFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
    }
    do
    {
      return paramInt;
      i = bfmx.a(bfbm.a().a(), null).a("Common_CGIReportFrequencyFailed");
      paramInt = i;
    } while (i != 0);
    return 100;
  }
  
  public Bundle a()
  {
    localObject1 = bfib.a().a("report_cgi");
    if (localObject1 != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->prepareCgiData, itemList size: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return null;
    }
    localObject1 = new Bundle();
    try
    {
      ((Bundle)localObject1).putString("releaseversion", bfbm.a().f());
      ((Bundle)localObject1).putString("device", Build.DEVICE);
      ((Bundle)localObject1).putString("qua", bfnd.b);
      ((Bundle)localObject1).putString("key", "appid,apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject2 = (BaseData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((Bundle)localObject1).putString(i + "_1", (String)((BaseData)localObject2).attrs.get("appid"));
        ((Bundle)localObject1).putString(i + "_2", (String)((BaseData)localObject2).attrs.get("apn"));
        ((Bundle)localObject1).putString(i + "_3", (String)((BaseData)localObject2).attrs.get("frequency"));
        ((Bundle)localObject1).putString(i + "_4", (String)((BaseData)localObject2).attrs.get("commandid"));
        ((Bundle)localObject1).putString(i + "_5", (String)((BaseData)localObject2).attrs.get("resultCode"));
        ((Bundle)localObject1).putString(i + "_6", (String)((BaseData)localObject2).attrs.get("timeCost"));
        ((Bundle)localObject1).putString(i + "_7", (String)((BaseData)localObject2).attrs.get("reqSize"));
        ((Bundle)localObject1).putString(i + "_8", (String)((BaseData)localObject2).attrs.get("rspSize"));
        ((Bundle)localObject1).putString(i + "_9", (String)((BaseData)localObject2).attrs.get("detail"));
        ((Bundle)localObject1).putString(i + "_10", (String)((BaseData)localObject2).attrs.get("uin"));
        localObject2 = bfmw.h() + "&" + (String)((BaseData)localObject2).attrs.get("deviceInfo");
        ((Bundle)localObject1).putString(i + "_11", (String)localObject2);
        i += 1;
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReportCenter", 2, "-->prepareCgiData, exception.", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->prepareCgiData, end. params: " + ((Bundle)localObject1).toString());
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.5(this));
  }
  
  public void a(Bundle paramBundle, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      try
      {
        bfbm.a().a(Long.valueOf(paramString2).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->reportVia, bundle: " + paramBundle.toString());
        }
        if ((!a("report_via", paramString1)) && (!paramBoolean)) {
          continue;
        }
        this.jdField_b_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.2(this, paramString2, paramBundle, paramBoolean));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bfbm.a().a(0L);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c.execute(new ReportCenter.4(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->reportCgi, command: " + paramString1 + " | responseCode: " + paramInt2 + " | uin: " + paramString2 + " | detail: " + paramString3);
    }
    this.c.execute(new ReportCenter.7(this, paramInt3, paramString1, paramString3, paramInt1, paramInt2, paramString2, paramBoolean));
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->reportCgi, command: " + paramString1 + " | startTime: " + paramLong1 + " | reqSize:" + paramLong2 + " | rspSize: " + paramLong3 + " | responseCode: " + paramInt + " | uin: " + paramLong4 + " | appid: " + paramString2 + " | detail: " + paramString3);
    }
    if ((!a("report_cgi", "" + paramInt)) && (!paramBoolean)) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.c.execute(new ReportCenter.3(this, paramString2, paramString1, paramString3, paramInt, paramLong2, paramLong3, l - paramLong1, paramLong4, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.6(this, paramBundle, paramString1, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    try
    {
      a(bfii.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString7, "", "", paramString8, paramString9), paramString3, paramString1, paramBoolean);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReportCenter", 2, "-->reportVia 2 exception", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    try
    {
      a(bfii.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString5, "", "", "", ""), paramString3, paramString1, paramBoolean);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReportCenter", 2, "-->reportVia 1 exception", paramString1);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    int i = 5;
    boolean bool = false;
    int j;
    if (paramString.equals("report_cgi"))
    {
      j = bfmx.a(bfbm.a().a(), null).a("Common_CGIReportMaxcount");
      if (j != 0) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->availableCount, report: " + paramString + " | dataSize: " + paramInt + " | maxcount: " + i);
      }
      if (paramInt >= i) {
        bool = true;
      }
      return bool;
      i = j;
      continue;
      if (paramString.equals("report_via"))
      {
        j = bfmx.a(bfbm.a().a(), null).a("Agent_ReportBatchCount");
        if (j != 0) {
          i = j;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->availableFrequency, report: " + paramString1 + " | ext: " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return bool2;
    }
    if (paramString1.equals("report_cgi")) {}
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(paramString2);
        i = a(i);
        if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < i)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReportCenter", 2, "-->availableFrequency, result: " + bool1 + " | frequency: " + i);
          return bool1;
        }
        bool1 = false;
        continue;
        if (paramString1.equals("report_via"))
        {
          i = bfnk.a(paramString2);
          if (new Random().nextInt(100) < i)
          {
            bool1 = true;
            continue;
          }
          bool1 = bool3;
          continue;
        }
        i = 100;
      }
      catch (Exception paramString1)
      {
        return false;
      }
      bool1 = bool3;
    }
  }
  
  public Bundle b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = bfib.a().a("report_via");
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->prepareViaData, itemList size: " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        int i = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (i == 0)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new JSONArray();
        localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label228;
        }
        Object localObject5 = (Serializable)((Iterator)localObject4).next();
        localJSONObject = new JSONObject();
        localObject5 = (BaseData)localObject5;
        Iterator localIterator = ((BaseData)localObject5).attrs.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localJSONObject.put(str, ((BaseData)localObject5).attrs.get(str));
          }
          catch (JSONException localJSONException2) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException2);
          continue;
        }
        localObject2.put(localJSONObject);
      }
      finally {}
      continue;
      label228:
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->prepareViaData, JSONArray array: " + localObject2.toString());
      }
      Object localObject4 = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      Object localObject3;
      try
      {
        localJSONObject.put("data", localObject2);
        ((Bundle)localObject4).putString("data", localJSONObject.toString());
        localObject3 = localObject4;
      }
      catch (JSONException localJSONException1)
      {
        localObject3 = localObject4;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException1);
        localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhz
 * JD-Core Version:    0.7.0.1
 */