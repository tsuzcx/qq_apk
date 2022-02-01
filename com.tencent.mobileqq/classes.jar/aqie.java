import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqie
{
  public int a;
  public long a;
  public Rect a;
  public String a;
  public boolean a;
  public int b;
  public Rect b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public aqie()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_d_of_type_Int = paramInt;
      paramString = BaseApplicationImpl.getContext();
      if (paramJSONObject.has("rect"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
        this.jdField_a_of_type_AndroidGraphicsRect.left = AIOUtils.dp2px(localJSONArray.getInt(0) / 2, paramString.getResources());
        this.jdField_a_of_type_AndroidGraphicsRect.top = AIOUtils.dp2px(localJSONArray.getInt(1) / 2, paramString.getResources());
        this.jdField_a_of_type_AndroidGraphicsRect.right = AIOUtils.dp2px(localJSONArray.getInt(2) / 2, paramString.getResources());
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = AIOUtils.dp2px(localJSONArray.getInt(3) / 2, paramString.getResources());
      }
      this.jdField_a_of_type_Long = paramJSONObject.optInt("time", 0);
      this.jdField_a_of_type_Int = paramJSONObject.optInt("cycle_count", 1);
      this.jdField_b_of_type_Int = paramJSONObject.optInt("count", 0);
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("img_prefix", "");
      this.jdField_c_of_type_Int = paramJSONObject.optInt("alpha", 0);
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("align", "");
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("zip_name", "");
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("img_reverse", true);
      paramJSONObject = paramJSONObject.optJSONArray("padding");
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect.left = AIOUtils.dp2px(paramJSONObject.getInt(0) / 2, paramString.getResources());
    this.jdField_b_of_type_AndroidGraphicsRect.top = AIOUtils.dp2px(paramJSONObject.getInt(1) / 2, paramString.getResources());
    this.jdField_b_of_type_AndroidGraphicsRect.right = AIOUtils.dp2px(paramJSONObject.getInt(2) / 2, paramString.getResources());
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = AIOUtils.dp2px(paramJSONObject.getInt(3) / 2, paramString.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqie
 * JD-Core Version:    0.7.0.1
 */