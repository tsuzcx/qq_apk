import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.HashMap;
import org.json.JSONObject;

public class bbxq
  extends bhzo
{
  private HashMap<String, bhzo> a;
  
  public bbxq(String paramString, View paramView, HashMap<String, bhzo> paramHashMap)
  {
    super(paramString, paramView);
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    int i = vzl.b(this.jdField_a_of_type_AndroidViewView.getContext());
    paramLayoutParams.width = Math.max((int)(i * 108.0F / 360.0F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 108.0F));
    paramLayoutParams.height = Math.max((int)(i * 126.0F / 360.0F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 126.0F));
    return paramLayoutParams;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("border".equals(paramString1))
    {
      if ((bhzo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) != null) {}
      return;
    }
    super.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxq
 * JD-Core Version:    0.7.0.1
 */