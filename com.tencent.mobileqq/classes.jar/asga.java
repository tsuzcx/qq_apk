import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class asga
  implements View.OnClickListener
{
  asga(asfu paramasfu, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new HashMap();
    aact.a(paramView, this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(10), "2");
    aact.a(akro.a(), "769", "205711", this.jdField_a_of_type_Asfu.a().gameAppId, "76905", "1", "160", paramView);
    paramView = new Intent();
    paramView.setClass(asfu.a(this.jdField_a_of_type_Asfu), ForwardRecentActivity.class);
    paramView.putExtra("forward_type", 27);
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc", "");
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("ver", "");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("view");
    String str4 = this.jdField_a_of_type_OrgJsonJSONObject.optString("config");
    String str5 = this.jdField_a_of_type_OrgJsonJSONObject.optString("meta");
    String str6 = this.jdField_a_of_type_OrgJsonJSONObject.optString("prompt");
    paramView.putExtra("forward_ark_app_name", this.b);
    paramView.putExtra("forward_ark_app_view", str3);
    paramView.putExtra("forward_ark_app_desc", str1);
    paramView.putExtra("forward_ark_app_ver", str2);
    paramView.putExtra("forward_ark_app_prompt", str6);
    paramView.putExtra("forward_ark_app_meta", str5);
    paramView.putExtra("forward_ark_app_config", str4);
    paramView.putExtra("is_ark_display_share", true);
    paramView.putExtra("appName", this.b);
    paramView.putExtra("appView", str3);
    paramView.putExtra("appMinVersion", str2);
    paramView.putExtra("metaData", str5);
    paramView.putExtra("scale", asfu.a(this.jdField_a_of_type_Asfu).getResources().getDisplayMetrics().scaledDensity);
    asfu.a(this.jdField_a_of_type_Asfu).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asga
 * JD-Core Version:    0.7.0.1
 */