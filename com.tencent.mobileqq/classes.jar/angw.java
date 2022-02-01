import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class angw
  extends angu
{
  private String b;
  private String c;
  private String d;
  private String e;
  
  public angw(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.b = paramString4;
    this.c = paramString5;
    this.d = paramString6;
    this.e = paramString7;
    if (TextUtils.isEmpty(this.d)) {
      this.d = paramActivity.getResources().getString(2131690291);
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = "https://qqvgame.qq.com/116da9321d03f927e434a165c14c7c1b.png";
    }
  }
  
  protected Intent a()
  {
    QLog.d("AVGameShareResultLink", 1, "getShareArkIntent");
    if (a() == null)
    {
      QLog.e("AVGameShareResultLink", 1, "getShareArkIntent error: activity is null");
      return null;
    }
    Intent localIntent = new Intent(a(), ForwardRecentActivity.class);
    try
    {
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", "com.tencent.avgame");
      localIntent.putExtra("forward_ark_app_view", "invite");
      localIntent.putExtra("forward_ark_app_ver", "1.0.0.1");
      localIntent.putExtra("forward_ark_app_prompt", "邀请你领礼包");
      localIntent.putExtra("selection_mode", 2);
      localIntent.putExtra("avgame_share_callback_key", false);
      String str = h();
      QLog.d("AVGameShareResultLink", 1, "getShareArkIntent metaDataString: " + str);
      localIntent.putExtra("forward_ark_app_meta", str);
      localIntent.putExtras(QQCustomArkDialog.AppInfo.zipArgs("com.tencent.avgame", "invite", "1.0.0.1", str, ArkAppCenterUtil.getDensity(), null, null));
      return localIntent;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("AVGameShareResultLink", 1, "getShareArkIntent exception message: " + localJSONException.getMessage());
      }
    }
  }
  
  protected String a(int paramInt)
  {
    return this.b;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected int b()
  {
    return -1;
  }
  
  protected String b(int paramInt)
  {
    return this.c;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected String d()
  {
    return this.b;
  }
  
  protected String e()
  {
    return this.c;
  }
  
  protected String f()
  {
    return this.e;
  }
  
  protected String g()
  {
    return this.e;
  }
  
  protected String h()
  {
    b();
    long l = this.a;
    String str = a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "award");
    JSONObject localJSONObject3 = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://avgame/create_room");
    localStringBuilder.append("?").append("gameType").append("=").append("4");
    localJSONObject3.put("jump_url", localStringBuilder.toString());
    localJSONObject3.put("h5_url", str);
    localJSONObject3.put("icon_url", this.e);
    localJSONObject3.put("title", this.b);
    localJSONObject3.put("summary", this.c);
    localJSONObject3.put("button", this.d);
    localJSONObject2.put("extra", localJSONObject3);
    localJSONObject1.put("invite", localJSONObject2);
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angw
 * JD-Core Version:    0.7.0.1
 */