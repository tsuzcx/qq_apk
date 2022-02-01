import android.text.TextUtils;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class blrv
{
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "0";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "2";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  
  public blrv()
  {
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = NetworkState.getNetworkType();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public blrv(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, ArrayList<String> paramArrayList)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.d = paramString5;
    this.jdField_b_of_type_Int = paramInt;
    this.e = paramString6;
    this.g = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public blrv(long paramLong, String paramString, Map<String, String> paramMap)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    if (paramMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    }
  }
  
  public blrv(String paramString)
  {
    this();
    this.f = paramString;
    this.jdField_c_of_type_JavaLangString = "12";
  }
  
  public JSONObject a()
  {
    if (!TextUtils.isEmpty(this.h)) {}
    Object localObject;
    for (JSONObject localJSONObject = new JSONObject(this.h);; localJSONObject = new JSONObject())
    {
      localJSONObject.put("touin", this.jdField_a_of_type_Long);
      localJSONObject.put("network_type", String.valueOf(this.jdField_a_of_type_Int));
      localJSONObject.put("tabletype", this.jdField_b_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.isEmpty())) {
        break label366;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    if (!localJSONObject.has("refer")) {
      localJSONObject.put("refer", this.jdField_b_of_type_JavaLangString);
    }
    localJSONObject.put("actiontype", this.jdField_c_of_type_JavaLangString);
    localJSONObject.put("subactiontype", this.d);
    localJSONObject.put("tabletype", this.jdField_b_of_type_Int);
    localJSONObject.put("domain_type", this.j);
    localJSONObject.put("reserves", this.e);
    localJSONObject.put("source_type", this.l);
    localJSONObject.put("source_from", this.m);
    localJSONObject.put("source_to", this.n);
    localJSONObject.put("mergenum", this.jdField_c_of_type_Int);
    localJSONObject.put("reserves10", this.i);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("reserves" + (i1 + 2), localObject);
        }
        i1 += 1;
      }
    }
    label366:
    localJSONObject.put("read_source", this.f);
    localJSONObject.put("time", String.valueOf(this.jdField_b_of_type_Long));
    localJSONObject.put("info", this.g);
    localJSONObject.put("pushstatkey", this.k);
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrv
 * JD-Core Version:    0.7.0.1
 */