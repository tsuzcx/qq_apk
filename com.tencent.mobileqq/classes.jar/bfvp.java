import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONObject;

public class bfvp
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  final int jdField_b_of_type_Int;
  final String jdField_b_of_type_JavaLangString;
  final String c;
  final String d;
  
  private bfvp(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static bfvp a(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int j = 0;
    Object localObject1 = "0";
    Object localObject2 = "0";
    Object localObject4 = paramAppInfo.buffer.get();
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = new JSONObject((String)localObject4);
        localObject3 = localObject1;
        localObject1 = ((JSONObject)localObject4).getString("trace_id");
        localObject3 = localObject1;
        i = ((JSONObject)localObject4).getInt("trace_num");
        i += 1;
        int k;
        paramAppInfo.printStackTrace();
      }
      catch (Exception paramAppInfo)
      {
        try
        {
          localObject3 = ((JSONObject)localObject4).getString("ad_id");
          localObject2 = localObject3;
          k = paramAppInfo.uiAppId.get();
          j = k;
          localObject2 = localObject3;
          return new bfvp((String)localObject1, i, (String)localObject2, j, "vab_red", "vab_red");
        }
        catch (Exception paramAppInfo)
        {
          break label123;
        }
        paramAppInfo = paramAppInfo;
        i = 0;
        localObject1 = localObject3;
      }
      label123:
      continue;
      int i = 0;
    }
  }
  
  public String a()
  {
    return "trace_detail_ad_id=" + this.jdField_b_of_type_JavaLangString + "&trace_detail_app_id=" + this.jdField_b_of_type_Int;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bfvp)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int));
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return "ReportKey{traceId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", traceNum=" + this.jdField_a_of_type_Int + ", adId=" + this.jdField_b_of_type_JavaLangString + ", appId=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfvp
 * JD-Core Version:    0.7.0.1
 */