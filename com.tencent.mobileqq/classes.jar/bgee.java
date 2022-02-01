import android.text.TextUtils;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class bgee
  implements wiq
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public bgee()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  @Nullable
  public JSONObject a(int paramInt)
  {
    int j = 1;
    int i = 1;
    JSONObject localJSONObject = new JSONObject();
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt != 0)
    {
      return null;
      paramInt = i;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localJSONObject.put("raw_url", this.jdField_a_of_type_JavaLangString);
        paramInt = 0;
        continue;
        paramInt = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localJSONObject.put("raw_url", this.jdField_a_of_type_JavaLangString);
          paramInt = 0;
        }
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localJSONObject.put("fake_url", this.jdField_b_of_type_JavaLangString);
          paramInt = 0;
        }
      }
    }
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("raw_url");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("fake_url");
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof bgee))
    {
      paramObject = (bgee)paramObject;
      if (!TextUtils.isEmpty(paramObject.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramObject.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramObject.jdField_b_of_type_JavaLangString;
      }
      if (paramObject.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = paramObject.jdField_a_of_type_Int;
      }
      if (paramObject.jdField_b_of_type_Int != -1) {
        this.jdField_b_of_type_Int = paramObject.jdField_b_of_type_Int;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof bgee))
    {
      paramObject = (bgee)paramObject;
      if ((this.jdField_b_of_type_JavaLangString != null) && (paramObject.jdField_b_of_type_JavaLangString != null)) {
        return TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString);
      }
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgee
 * JD-Core Version:    0.7.0.1
 */