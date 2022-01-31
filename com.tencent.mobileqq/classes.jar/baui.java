import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.HashMap;
import org.json.JSONObject;

public class baui
  extends bgqa
{
  private HashMap<String, bgqa> a;
  
  public baui(String paramString, View paramView, HashMap<String, bgqa> paramHashMap)
  {
    super(paramString, paramView);
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    int i = vms.b(this.jdField_a_of_type_AndroidViewView.getContext());
    paramLayoutParams.width = Math.max((int)(i * 108.0F / 360.0F), vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 108.0F));
    paramLayoutParams.height = Math.max((int)(i * 126.0F / 360.0F), vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 126.0F));
    return paramLayoutParams;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("border".equals(paramString1))
    {
      if ((bgqa)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) != null) {}
      return;
    }
    super.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baui
 * JD-Core Version:    0.7.0.1
 */