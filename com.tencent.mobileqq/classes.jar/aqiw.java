import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqiw
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<aqix>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static aqiw a()
  {
    return (aqiw)apub.a().a(432);
  }
  
  public static aqiw a(aptx paramaptx)
  {
    int i = 0;
    aqiw localaqiw = new aqiw();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
        int j = paramaptx.optInt("switch", 0);
        int k = paramaptx.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaptx.optInt("showMessageResult", 1);
        int n = paramaptx.optInt("ftsEnableSwitch", 1);
        int i1 = paramaptx.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaptx.optInt("ftsEnableFtsFilter", 1);
        localaqiw.a(j);
        localaqiw.b(k);
        localaqiw.c(m);
        localaqiw.c = n;
        localaqiw.e = i1;
        localaqiw.f = i2;
        paramaptx = paramaptx.optJSONArray("templateinfo");
        if (paramaptx != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaptx.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaptx.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aqix localaqix = new aqix();
          localaqix.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localaqix.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localaqix.c = localJSONObject.optString("templatever");
          localaqix.b = localJSONObject.optString("templatename");
          localaqix.d = localJSONObject.optString("templateview");
          if ("ark".equals(localaqix.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localaqix);
          } else if ("native".equals(localaqix.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localaqix);
          }
        }
      }
      catch (Exception paramaptx)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaptx.toString());
        }
      }
      return localaqiw;
      label375:
      localaqiw.a("ark", localArrayList1);
      localaqiw.a("native", localArrayList2);
      return localaqiw;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aqix> a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {
      return (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString, ArrayList<aqix> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (paramString != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, paramArrayList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean c()
  {
    return this.e == 1;
  }
  
  public boolean d()
  {
    return this.f == 1;
  }
  
  public boolean e()
  {
    return this.d == 1;
  }
  
  public boolean f()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {}
    for (String str = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.toString();; str = "null") {
      return String.format("mRichSwitch:%d  templateData:%s", new Object[] { Integer.valueOf(i), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqiw
 * JD-Core Version:    0.7.0.1
 */