import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bfhj
{
  public int a;
  public long a;
  public bfgy a;
  public String a;
  public List<ResultRecord> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public bfhj()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfgy = new bfgy();
    this.jdField_a_of_type_Bfgy.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Bfgy.a = new byte[0];
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("classify", 0);
      this.jdField_b_of_type_Int = paramString.optInt("verifyType", 2);
      this.jdField_a_of_type_JavaLangString = paramString.optString("classificationInfo", "");
      this.jdField_b_of_type_JavaLangString = paramString.optString("name", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("introduction", "");
      this.e = paramString.optString("location", "");
      this.jdField_c_of_type_Int = paramString.optInt("group_type", -1);
      if (paramString.optInt("isJumpAio") == 1) {}
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        this.jdField_d_of_type_Int = paramString.optInt("create_source", 0);
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "";
    this.jdField_a_of_type_Bfgy = null;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhj
 * JD-Core Version:    0.7.0.1
 */