import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import java.util.HashMap;
import org.json.JSONObject;

public class bbxq
  extends bbxl
{
  public bbxq(Activity paramActivity, JSONObject paramJSONObject, auuw paramauuw)
  {
    super(paramActivity, paramJSONObject, paramauuw);
    this.d = vzo.a(paramActivity, 4.0F);
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    Object localObject = (QZoneLayoutTemplate1)paramView.findViewById(2131368127);
    if (localObject != null)
    {
      ((QZoneLayoutTemplate1)localObject).setBorderWidth(b(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setItemBg(a(paramJSONObject, a(100.0F), a(100.0F)), a(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setLeftView(paramJSONObject.optString("ph"));
      ((QZoneLayoutTemplate1)localObject).setRightView(paramJSONObject.optString("ph"));
    }
    localObject = paramView.findViewById(2131367679);
    TextView localTextView = (TextView)paramView.findViewById(2131377183);
    ImageView localImageView = (ImageView)paramView.findViewById(2131367815);
    String str = localTextView.getText().toString();
    if ((this.jdField_a_of_type_Auuw.a.a != 0) && (str.length() > 4) && (str.substring(str.length() - 4, str.length()).equals("QQ空间"))) {
      localTextView.setText(str.substring(0, str.length() - 4) + ajyc.a(2131714812));
    }
    a(paramJSONObject, (View)localObject, localTextView, localImageView);
    return paramView;
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131561602);
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561611, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxq
 * JD-Core Version:    0.7.0.1
 */