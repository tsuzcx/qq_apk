import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class atjj
  implements biab
{
  public atjj(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  public void a(biaa parambiaa)
  {
    int i = parambiaa.a - 1;
    Object localObject1 = null;
    parambiaa = null;
    for (;;)
    {
      JSONArray localJSONArray;
      int j;
      try
      {
        String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
        localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("list");
        if (localJSONArray == null) {
          break;
        }
        if (i >= localJSONArray.length()) {
          return;
        }
        if (TextUtils.isEmpty(str)) {
          break label169;
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { String.valueOf(i + 1) });
        return;
      }
      catch (Exception localException1)
      {
        i = 0;
        localObject1 = parambiaa;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException1.getMessage());
          j = i;
          localObject1 = parambiaa;
        }
        switch (j)
        {
        default: 
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().loadUrl((String)localObject1);
      return;
      label169:
      Object localObject2 = localJSONArray.optJSONObject(i);
      i = ((JSONObject)localObject2).optInt("target");
      parambiaa = (biaa)localObject1;
      try
      {
        localObject1 = ((JSONObject)localObject2).optString("jumpUrl");
        parambiaa = (biaa)localObject1;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        j = i;
        if (!bool) {
          continue;
        }
        return;
      }
      catch (Exception localException2) {}
      parambiaa = new Bundle();
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
      {
        localObject2 = new Intent(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtras(parambiaa);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).setFlags(0);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        return;
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass());
      ((Intent)localObject2).putExtras(parambiaa);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).setFlags(0);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjj
 * JD-Core Version:    0.7.0.1
 */