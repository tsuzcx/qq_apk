import android.app.Activity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class bebp
  extends bebj
{
  public bebp(Activity paramActivity, JSONObject paramJSONObject, awqt paramawqt)
  {
    super(paramActivity, paramJSONObject, paramawqt);
    this.d = xsm.a(paramActivity, 3.0F);
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131561811);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if ((paramView != null) && (paramTextView != null))
    {
      paramTextView.setTextColor(this.c);
      String str = b(paramJSONObject);
      if (TextUtils.isEmpty(str)) {
        break label141;
      }
      int i = xsm.a(this.jdField_a_of_type_AndroidAppActivity, 300.0F);
      int j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
      int k = xsm.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
      int m = xsm.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F);
      paramView.setBackgroundDrawable(a(str, new bebq(Math.min(j + k, i), m)));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramView = c(paramJSONObject);
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        paramImageView.setImageDrawable(a(paramView));
      }
      return;
      label141:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
      }
      paramView.setVisibility(8);
    }
    if (paramJSONObject != null) {
      QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
    }
    paramImageView.setVisibility(8);
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561820, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebp
 * JD-Core Version:    0.7.0.1
 */