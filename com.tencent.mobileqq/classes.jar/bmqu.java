import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmqu
{
  public static int a;
  public String a;
  public HashMap<Integer, String> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  static
  {
    jdField_a_of_type_Int = 51;
  }
  
  public bmqu()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "55801");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "1");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "4");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "430");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), Build.MODEL);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), Build.VERSION.RELEASE);
  }
  
  public bmqu a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public bmqu a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public bmqu a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "8.4.10");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        int j = HttpUtil.getNetWorkType();
        if (j < 0) {
          break label456;
        }
        i = j;
        if (j >= AppConstants.NET_TYPE_NAME.length) {
          break label456;
        }
        localJSONObject3.put("net_type", AppConstants.NET_TYPE_NAME[i]);
        localJSONObject3.put("resolution", bmqt.a(null));
        localJSONObject3.put("is_red_point", "0");
        localJSONObject3.put("is_new_status", "0");
        localJSONObject3.put("gamecenter_src", "1");
        localJSONObject3.put("ret_id", String.valueOf(this.jdField_c_of_type_Int));
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          localJSONObject3.put("oper_moudle", this.jdField_c_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localJSONObject3.put("oper_id", this.jdField_b_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.d)) {
          localJSONObject3.put("gameappid", this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
          localJSONObject3.put("tianji_report_str", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
          localJSONObject3.put("apk_volume", this.f);
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getValue();
          if (TextUtils.isEmpty(str)) {
            continue;
          }
          localJSONObject3.put("ext" + localEntry.getKey(), str);
          continue;
        }
        localJSONObject2.put("data", localJSONObject3);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localJSONObject1;
      }
      localJSONObject2.put("dc_id", this.jdField_a_of_type_JavaLangString);
      localException.put(localJSONObject2);
      localJSONObject1.put("target", paramInt);
      localJSONObject1.put("report_list", localException);
      return localJSONObject1;
      label456:
      int i = 0;
    }
  }
  
  public bmqu b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public bmqu c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bmqu d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bmqu e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public bmqu f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String toString()
  {
    return "[dcId=" + this.jdField_a_of_type_JavaLangString + ",operId=" + this.jdField_b_of_type_JavaLangString + ",operModule=" + this.jdField_c_of_type_JavaLangString + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqu
 * JD-Core Version:    0.7.0.1
 */