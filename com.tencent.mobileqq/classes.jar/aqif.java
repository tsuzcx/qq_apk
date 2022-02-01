import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqif
  extends aqie
{
  public boolean b;
  public Rect c;
  public Rect d;
  public int e;
  public String e;
  public String f = "";
  
  public aqif()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      super.a(paramInt, paramString, paramJSONObject);
      paramString = BaseApplicationImpl.getContext();
      this.jdField_e_of_type_Int = paramJSONObject.optInt("passive_type", -1);
      this.b = paramJSONObject.optBoolean("passive_rotate", false);
      this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("start_align", this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      this.f = paramJSONObject.optString("end_align", "");
      if (paramJSONObject.has("start_rect"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("start_rect");
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
        this.jdField_c_of_type_AndroidGraphicsRect.left = AIOUtils.dp2px(localJSONArray.getInt(0) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.top = AIOUtils.dp2px(localJSONArray.getInt(1) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.right = AIOUtils.dp2px(localJSONArray.getInt(2) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.bottom = AIOUtils.dp2px(localJSONArray.getInt(3) / 2, paramString.getResources());
        this.a = this.jdField_c_of_type_AndroidGraphicsRect;
      }
      if (paramJSONObject.has("end_rect"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("end_rect");
        this.d = new Rect();
        this.d.left = AIOUtils.dp2px(paramJSONObject.getInt(0) / 2, paramString.getResources());
        this.d.top = AIOUtils.dp2px(paramJSONObject.getInt(1) / 2, paramString.getResources());
        this.d.right = AIOUtils.dp2px(paramJSONObject.getInt(2) / 2, paramString.getResources());
        this.d.bottom = AIOUtils.dp2px(paramJSONObject.getInt(3) / 2, paramString.getResources());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqif
 * JD-Core Version:    0.7.0.1
 */