import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class avbh
  implements View.OnClickListener
{
  avbh(avbb paramavbb, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new HashMap();
    abuf.a((Map)localObject, this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put(Integer.valueOf(10), "2");
    abuf.a(amwn.a(), "769", "205711", this.jdField_a_of_type_Avbb.a().gameAppId, "76905", "1", "160", (Map)localObject);
    localObject = new Intent();
    ((Intent)localObject).setClass(avbb.a(this.jdField_a_of_type_Avbb), ForwardRecentActivity.class);
    ((Intent)localObject).putExtra("forward_type", 27);
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc", "");
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("ver", "");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("view");
    String str4 = this.jdField_a_of_type_OrgJsonJSONObject.optString("config");
    String str5 = this.jdField_a_of_type_OrgJsonJSONObject.optString("meta");
    String str6 = this.jdField_a_of_type_OrgJsonJSONObject.optString("prompt");
    ((Intent)localObject).putExtra("forward_ark_app_name", this.b);
    ((Intent)localObject).putExtra("forward_ark_app_view", str3);
    ((Intent)localObject).putExtra("forward_ark_app_desc", str1);
    ((Intent)localObject).putExtra("forward_ark_app_ver", str2);
    ((Intent)localObject).putExtra("forward_ark_app_prompt", str6);
    ((Intent)localObject).putExtra("forward_ark_app_meta", str5);
    ((Intent)localObject).putExtra("forward_ark_app_config", str4);
    ((Intent)localObject).putExtra("is_ark_display_share", true);
    ((Intent)localObject).putExtra("appName", this.b);
    ((Intent)localObject).putExtra("appView", str3);
    ((Intent)localObject).putExtra("appMinVersion", str2);
    ((Intent)localObject).putExtra("metaData", str5);
    ((Intent)localObject).putExtra("scale", avbb.a(this.jdField_a_of_type_Avbb).getResources().getDisplayMetrics().scaledDensity);
    avbb.a(this.jdField_a_of_type_Avbb).startActivity((Intent)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbh
 * JD-Core Version:    0.7.0.1
 */