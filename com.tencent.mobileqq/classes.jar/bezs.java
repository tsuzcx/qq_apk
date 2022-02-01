import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bezs
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String c = "";
  private String d = "";
  
  public bezs() {}
  
  public bezs(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static bezs a(aqlg[] paramArrayOfaqlg)
  {
    localObject2 = "";
    localObject1 = "";
    localObject3 = "";
    Object localObject9 = "";
    int n = 0;
    i = 0;
    int k = 0;
    if (n < paramArrayOfaqlg.length)
    {
      Object localObject4 = paramArrayOfaqlg[n].jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject7 = localObject9;
        localObject6 = localObject3;
      }
      for (;;)
      {
        n += 1;
        localObject3 = localObject6;
        localObject9 = localObject7;
        break;
        m = k;
        try
        {
          localJSONObject1 = new JSONObject((String)localObject4);
          m = k;
          j = localJSONObject1.optInt("globalOpen", 0);
          m = j;
          k = localJSONObject1.optInt("globalOpenTXDoc", 0);
          m = k;
          localObject8 = localObject2;
          localObject7 = localObject1;
          localObject6 = localObject3;
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            localJSONObject2 = localJSONObject1.optJSONObject("weikeUrls");
            localObject5 = localObject2;
            localObject4 = localObject1;
            if (localJSONObject2 != null)
            {
              localObject8 = localObject2;
              localObject7 = localObject1;
              localObject6 = localObject3;
              localObject2 = localJSONObject2.optString("choose_exam");
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              JSONObject localJSONObject1;
              int j;
              Object localObject8;
              JSONObject localJSONObject2;
              Object localObject5;
              boolean bool1;
              boolean bool2;
              i = m;
              localObject2 = localObject8;
              localObject1 = localObject7;
              localObject3 = localObject6;
            }
          }
          try
          {
            localObject4 = localJSONObject2.optString("get_exam_info");
            localObject5 = localObject2;
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localJSONObject1 = localJSONObject1.optJSONObject("txDocUrls");
            i = m;
            k = j;
            localObject2 = localObject5;
            localObject1 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject9;
            if (localJSONObject1 == null) {
              continue;
            }
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localObject3 = localJSONObject1.optString("choose_doc");
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localObject1 = localJSONObject1.optString("get_doc_info");
            localObject7 = localObject1;
            i = m;
            k = j;
            localObject2 = localObject5;
            localObject1 = localObject4;
            localObject6 = localObject3;
          }
          catch (JSONException localJSONException3)
          {
            i = m;
            break label299;
          }
          localJSONException1 = localJSONException1;
          j = m;
        }
        label299:
        localJSONException1.printStackTrace();
        k = j;
        localObject6 = localObject3;
        localObject7 = localObject9;
      }
    }
    if (k == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label377;
      }
    }
    label377:
    for (bool2 = true;; bool2 = false)
    {
      paramArrayOfaqlg = new bezs(bool1, (String)localObject2, (String)localObject1, bool2, (String)localObject3, (String)localObject9);
      if (QLog.isColorLevel()) {
        QLog.i("PublishHwkThirdPartyEntryConfig", 2, paramArrayOfaqlg.toString());
      }
      return paramArrayOfaqlg;
      bool1 = false;
      break;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsGlobalOpenWeiKe:").append(this.jdField_a_of_type_Boolean).append("\r\n");
    localStringBuilder.append("mIsGlobalOpenTXDoc:").append(this.jdField_b_of_type_Boolean).append("\r\n");
    localStringBuilder.append("mStrSelectWeiKeUrl:").append(this.jdField_a_of_type_JavaLangString).append("\r\n");
    localStringBuilder.append("mStrDetailWeiKeUrl:").append(this.jdField_b_of_type_JavaLangString).append("\r\n");
    localStringBuilder.append("mStrSelectDocUrl:").append(this.c).append("\r\n");
    localStringBuilder.append("mStrDetailDocUrl:").append(this.d).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezs
 * JD-Core Version:    0.7.0.1
 */