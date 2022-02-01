import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqrc
{
  public long a;
  public String a;
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
  
  public aqrc()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 524288000L;
    this.jdField_d_of_type_Long = 31457280L;
    this.jdField_a_of_type_JavaLangString = "12000|600|20000|400|6000|300|20000|200";
    this.jdField_b_of_type_JavaLangString = "20|10|50|10";
    this.jdField_c_of_type_JavaLangString = "51f3f3f7";
    this.jdField_d_of_type_JavaLangString = "20-24;0-1";
  }
  
  public static aqrc a(aqlg[] paramArrayOfaqlg)
  {
    aqrc localaqrc = new aqrc();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      int i1 = paramArrayOfaqlg.length;
      int n = 0;
      if (n < i1)
      {
        Object localObject = paramArrayOfaqlg[n];
        if (localObject == null) {}
        for (;;)
        {
          n += 1;
          break;
          localObject = ((aqlg)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localaqrc);
            b(localJSONObject, localaqrc);
            if (QLog.isColorLevel()) {
              QLog.i("PicPreDownloadBean", 2, "parse: " + (String)localObject + " bean:" + localaqrc.toString());
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
    return localaqrc;
  }
  
  private static void a(JSONObject paramJSONObject, aqrc paramaqrc)
  {
    if (paramJSONObject.has("PicPreDownSwitch")) {
      paramaqrc.jdField_a_of_type_Long = paramJSONObject.optLong("PicPreDownSwitch");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramaqrc.jdField_b_of_type_Long = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramaqrc.jdField_c_of_type_Long = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramaqrc.jdField_d_of_type_Long = paramJSONObject.optLong("Max4GFlow");
    }
    if (paramJSONObject.has("Max3GFlow")) {
      paramaqrc.e = paramJSONObject.optLong("Max3GFlow");
    }
    if (paramJSONObject.has("Max2GFlow")) {
      paramaqrc.f = paramJSONObject.optLong("Max2GFlow");
    }
  }
  
  private static void b(JSONObject paramJSONObject, aqrc paramaqrc)
  {
    if (paramJSONObject.has("flowCombination")) {
      paramaqrc.jdField_a_of_type_JavaLangString = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramaqrc.jdField_b_of_type_JavaLangString = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramaqrc.g = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramaqrc.jdField_c_of_type_JavaLangString = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramaqrc.h = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramaqrc.i = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramaqrc.j = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramaqrc.k = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramaqrc.l = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramaqrc.jdField_d_of_type_JavaLangString = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramaqrc.m = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  public String toString()
  {
    return "PicPreDownloadBean{,PreDownSwitch=" + this.jdField_a_of_type_Long + ",PicAuDownTimePoint=" + this.jdField_b_of_type_Long + ",PreDownMaxWifiFlow=" + this.jdField_c_of_type_Long + ",PreDownMax4GFlow=" + this.jdField_d_of_type_Long + ",PreDownMax3GFlow=" + this.e + ",PreDownMax2GFlow=" + this.f + ",flowsCombination=" + this.jdField_a_of_type_JavaLangString + ",troopCombination=" + this.jdField_b_of_type_JavaLangString + ",requestListMaxSize=" + this.g + ",xGPreDownPolicy=" + this.jdField_c_of_type_JavaLangString + ",xgFlowHitFeedback=" + this.h + ",XgFlowMissFeedback=" + this.i + ",pisSizeAvg=" + this.j + ",pisSizeMax=" + this.k + ",mEnablePeakFlow=" + this.l + ",mPeakFlowTimePeriod=" + this.jdField_d_of_type_JavaLangString + ",mPeakFlowMaxPicSize=" + this.m + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrc
 * JD-Core Version:    0.7.0.1
 */