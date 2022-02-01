import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqac
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
  
  public aqac()
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
  
  public static aqac a(aptx[] paramArrayOfaptx)
  {
    aqac localaqac = new aqac();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      int i1 = paramArrayOfaptx.length;
      int n = 0;
      if (n < i1)
      {
        Object localObject = paramArrayOfaptx[n];
        if (localObject == null) {}
        for (;;)
        {
          n += 1;
          break;
          localObject = ((aptx)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localaqac);
            b(localJSONObject, localaqac);
            c(localJSONObject, localaqac);
            if (QLog.isColorLevel()) {
              QLog.i("PicPreDownloadBean", 2, "parse: " + (String)localObject + " bean:" + localaqac.toString());
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
    return localaqac;
  }
  
  private static void a(JSONObject paramJSONObject, aqac paramaqac)
  {
    if (paramJSONObject.has("PicPreDownSwitchNew")) {
      paramaqac.jdField_a_of_type_Long = paramJSONObject.optLong("PicPreDownSwitchNew");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramaqac.jdField_b_of_type_Long = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramaqac.jdField_c_of_type_Long = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramaqac.jdField_d_of_type_Long = paramJSONObject.optLong("Max4GFlow");
    }
    if (paramJSONObject.has("Max3GFlow")) {
      paramaqac.e = paramJSONObject.optLong("Max3GFlow");
    }
    if (paramJSONObject.has("Max2GFlow")) {
      paramaqac.f = paramJSONObject.optLong("Max2GFlow");
    }
  }
  
  private static void b(JSONObject paramJSONObject, aqac paramaqac)
  {
    if (paramJSONObject.has("flowCombination")) {
      paramaqac.jdField_a_of_type_JavaLangString = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramaqac.jdField_b_of_type_JavaLangString = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramaqac.g = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramaqac.jdField_c_of_type_JavaLangString = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramaqac.h = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramaqac.i = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramaqac.j = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramaqac.k = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramaqac.l = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramaqac.jdField_d_of_type_JavaLangString = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramaqac.m = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  private static void c(JSONObject paramJSONObject, aqac paramaqac)
  {
    if (paramJSONObject.has("gifWifiPreDownloadLimit")) {
      paramaqac.jdField_a_of_type_Int = paramJSONObject.optInt("gifWifiPreDownloadLimit");
    }
    if (paramJSONObject.has("gifXgPreDownloadLimit")) {
      paramaqac.jdField_b_of_type_Int = paramJSONObject.optInt("gifXgPreDownloadLimit");
    }
  }
  
  public String toString()
  {
    return "PicPreDownloadBean{PreDownSwitchNew=" + this.jdField_a_of_type_Long + ",PicAuDownTimePoint=" + this.jdField_b_of_type_Long + ",PreDownMaxWifiFlow=" + this.jdField_c_of_type_Long + ",PreDownMax4GFlow=" + this.jdField_d_of_type_Long + ",PreDownMax3GFlow=" + this.e + ",PreDownMax2GFlow=" + this.f + ",flowsCombination=" + this.jdField_a_of_type_JavaLangString + ",troopCombination=" + this.jdField_b_of_type_JavaLangString + ",requestListMaxSize=" + this.g + ",xGPreDownPolicy=" + this.jdField_c_of_type_JavaLangString + ",xgFlowHitFeedback=" + this.h + ",XgFlowMissFeedback=" + this.i + ",pisSizeAvg=" + this.j + ",pisSizeMax=" + this.k + ",mEnablePeakFlow=" + this.l + ",mPeakFlowTimePeriod=" + this.jdField_d_of_type_JavaLangString + ",mPeakFlowMaxPicSize=" + this.m + ",gifWifiPreDownloadLimit=" + this.jdField_a_of_type_Int + ",gifXgPreDownloadLimit=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqac
 * JD-Core Version:    0.7.0.1
 */