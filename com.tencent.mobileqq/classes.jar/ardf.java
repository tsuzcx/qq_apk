import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ardf
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e = 31457280L;
  public long f = 31457280L;
  public long g = 100L;
  public long h = 150L;
  public long i = 40960L;
  public long j = 71680L;
  public long k = 204800L;
  public long l = 1L;
  public long m = 819200L;
  
  public ardf()
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 524288000L;
    this.jdField_d_of_type_Long = 31457280L;
    this.jdField_a_of_type_JavaLangString = "12000|600|20000|400|6000|300|20000|200";
    this.jdField_b_of_type_JavaLangString = "20|10|50|10";
    this.jdField_c_of_type_JavaLangString = "51f3f3f7";
    this.jdField_d_of_type_JavaLangString = "20-24;0-1";
    this.jdField_a_of_type_Int = 1000;
    this.jdField_b_of_type_Int = 32;
  }
  
  public static ardf a(aqxa[] paramArrayOfaqxa)
  {
    ardf localardf = new ardf();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int i1 = paramArrayOfaqxa.length;
      int n = 0;
      if (n < i1)
      {
        Object localObject = paramArrayOfaqxa[n];
        if (localObject == null) {}
        for (;;)
        {
          n += 1;
          break;
          localObject = ((aqxa)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localardf);
            b(localJSONObject, localardf);
            c(localJSONObject, localardf);
            if (QLog.isColorLevel()) {
              QLog.i("PicPreDownloadBean", 2, "parse: " + (String)localObject + " bean:" + localardf.toString());
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return localardf;
  }
  
  private static void a(JSONObject paramJSONObject, ardf paramardf)
  {
    if (paramJSONObject.has("PicPreDownSwitchNew")) {
      paramardf.jdField_a_of_type_Long = paramJSONObject.optLong("PicPreDownSwitchNew");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramardf.jdField_b_of_type_Long = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramardf.jdField_c_of_type_Long = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramardf.jdField_d_of_type_Long = paramJSONObject.optLong("Max4GFlow");
    }
    if (paramJSONObject.has("Max3GFlow")) {
      paramardf.e = paramJSONObject.optLong("Max3GFlow");
    }
    if (paramJSONObject.has("Max2GFlow")) {
      paramardf.f = paramJSONObject.optLong("Max2GFlow");
    }
  }
  
  private static void b(JSONObject paramJSONObject, ardf paramardf)
  {
    if (paramJSONObject.has("flowCombination")) {
      paramardf.jdField_a_of_type_JavaLangString = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramardf.jdField_b_of_type_JavaLangString = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramardf.g = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramardf.jdField_c_of_type_JavaLangString = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramardf.h = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramardf.i = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramardf.j = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramardf.k = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramardf.l = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramardf.jdField_d_of_type_JavaLangString = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramardf.m = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  private static void c(JSONObject paramJSONObject, ardf paramardf)
  {
    if (paramJSONObject.has("gifWifiPreDownloadLimit")) {
      paramardf.jdField_a_of_type_Int = paramJSONObject.optInt("gifWifiPreDownloadLimit");
    }
    if (paramJSONObject.has("gifXgPreDownloadLimit")) {
      paramardf.jdField_b_of_type_Int = paramJSONObject.optInt("gifXgPreDownloadLimit");
    }
  }
  
  public String toString()
  {
    return "PicPreDownloadBean{PreDownSwitchNew=" + this.jdField_a_of_type_Long + ",PicAuDownTimePoint=" + this.jdField_b_of_type_Long + ",PreDownMaxWifiFlow=" + this.jdField_c_of_type_Long + ",PreDownMax4GFlow=" + this.jdField_d_of_type_Long + ",PreDownMax3GFlow=" + this.e + ",PreDownMax2GFlow=" + this.f + ",flowsCombination=" + this.jdField_a_of_type_JavaLangString + ",troopCombination=" + this.jdField_b_of_type_JavaLangString + ",requestListMaxSize=" + this.g + ",xGPreDownPolicy=" + this.jdField_c_of_type_JavaLangString + ",xgFlowHitFeedback=" + this.h + ",XgFlowMissFeedback=" + this.i + ",pisSizeAvg=" + this.j + ",pisSizeMax=" + this.k + ",mEnablePeakFlow=" + this.l + ",mPeakFlowTimePeriod=" + this.jdField_d_of_type_JavaLangString + ",mPeakFlowMaxPicSize=" + this.m + ",gifWifiPreDownloadLimit=" + this.jdField_a_of_type_Int + ",gifXgPreDownloadLimit=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardf
 * JD-Core Version:    0.7.0.1
 */