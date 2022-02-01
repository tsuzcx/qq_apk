import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aojk
  extends aoji
{
  public long a;
  
  public aojk(Activity paramActivity, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt)
  {
    super(paramActivity, paramString1, paramString2, paramString3, paramInt);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(String paramString1, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis() / 1000L;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "invite");
    JSONObject localJSONObject3 = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://avgame/join_room");
    localStringBuilder.append("?").append("uin").append("=").append(paramString1).append("&").append("room").append("=").append(paramLong);
    localJSONObject3.put("jump_url", localStringBuilder.toString());
    localJSONObject3.put("h5_url", paramString2);
    localJSONObject3.put("icon_url", "https://qqvgame.qq.com/d55d788cc3c423807d830230aad935b2.png");
    localJSONObject3.put("roomid", String.valueOf(paramLong));
    localJSONObject3.put("timestamp", String.valueOf(l));
    localJSONObject2.put("extra", localJSONObject3);
    localJSONObject1.put("invite", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  protected Intent a()
  {
    QLog.d("AVGameShareEntry", 1, "getShareArkIntent");
    if (a() == null)
    {
      QLog.e("AVGameShareEntry", 1, "getShareArkIntent error: activity is null");
      return null;
    }
    localIntent = new Intent(a(), ForwardRecentActivity.class);
    try
    {
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", "com.tencent.avgame");
      localIntent.putExtra("forward_ark_app_view", "invite");
      localIntent.putExtra("forward_ark_app_ver", "1.0.0.1");
      if (TextUtils.isEmpty(c())) {}
      for (String str = "邀请你加入派对";; str = c() + "邀请你加入派对")
      {
        localIntent.putExtra("forward_ark_app_prompt", str);
        localIntent.putExtra("selection_mode", 2);
        localIntent.putExtra("avgame_share_callback_key", true);
        str = h();
        QLog.d("AVGameShareEntry", 1, "getShareArkIntent metaDataString: " + str);
        localIntent.putExtra("forward_ark_app_meta", str);
        localIntent.putExtras(QQCustomArkDialog.AppInfo.zipArgs("com.tencent.avgame", "invite", "1.0.0.1", str, ArkAppCenterUtil.getDensity(), null, null));
        break;
      }
      return localIntent;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("AVGameShareEntry", 1, "getShareArkIntent exception message: " + localJSONException.getMessage());
    }
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    aojq.a().a(a(), 2, true);
  }
  
  protected void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend");
    if (a() == 0) {
      bdla.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    Bundle localBundle;
    for (;;)
    {
      localBundle = new Bundle();
      localBundle.putInt("key_req", ForwardRecentActivity.f);
      localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
      paramActionSheetItem = a();
      if (paramActionSheetItem != null) {
        break;
      }
      QLog.e("AVGameShareEntry", 1, "shareToSpecifiedFriend error: intent is null");
      QQToast.a(a(), 2131690497, 0).a();
      return;
      bdla.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    paramActionSheetItem.putExtras(localBundle);
    aupt.a(a(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, -1);
    QLog.d("AVGameShareEntry", 1, "shareToSpecifiedFriend success");
    if (a() == 0)
    {
      bdla.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "0", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  public void c()
  {
    QLog.d("AVGameShareEntry", 1, "showActionSheet");
    if ((a() == null) || (TextUtils.isEmpty(b())) || (TextUtils.isEmpty(a())))
    {
      QLog.e("AVGameShareEntry", 1, "showActionSheet error: params wrong");
      QQToast.a(a(), 2131690497, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      QLog.e("AVGameShareEntry", 1, "mShareActionSheet is null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      return;
    }
    a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_av_game");
    List localList1 = a();
    List localList2 = b();
    Intent localIntent = a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new aojl(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  protected void d()
  {
    if (a() == 0) {
      bdla.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    Intent localIntent;
    for (;;)
    {
      QLog.d("AVGameShareEntry", 1, "shareToQQ");
      localIntent = a();
      if (localIntent != null) {
        break;
      }
      QLog.e("AVGameShareEntry", 1, "shareToQQ error: params wrong");
      QQToast.a(a(), 2131690497, 0).a();
      return;
      bdla.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    a().startActivityForResult(localIntent, -1);
    QLog.d("AVGameShareEntry", 1, "shareToQQ success");
    if (a() == 0)
    {
      bdla.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "1", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  protected void e()
  {
    QLog.d("AVGameShareEntry", 1, "shareToQzone");
    if (a() == 0) {
      bdla.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    for (;;)
    {
      a();
      if (a() != 0) {
        break;
      }
      bdla.b(null, "dc00898", "", "", "0X800B068", "0X800B068", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
      bdla.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
    }
    bdla.b(null, "dc00898", "", "", "0X800B064", "0X800B064", a(), 0, "2", String.valueOf(this.jdField_a_of_type_Long), "", "");
  }
  
  protected void f(int paramInt)
  {
    QLog.d("AVGameShareEntry", 1, "shareToWeChat: shareType is " + paramInt);
    if (paramInt == 9) {
      if (a() == 0) {
        bdla.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "3", String.valueOf(this.jdField_a_of_type_Long), "", "");
      }
    }
    for (;;)
    {
      e(paramInt);
      return;
      bdla.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "3", String.valueOf(this.jdField_a_of_type_Long), "", "");
      continue;
      if (paramInt == 10) {
        if (a() == 0) {
          bdla.b(null, "dc00898", "", "", "0X800B066", "0X800B066", a(), 0, "4", String.valueOf(this.jdField_a_of_type_Long), "", "");
        } else {
          bdla.b(null, "dc00898", "", "", "0X800B065", "0X800B065", a(), 0, "4", String.valueOf(this.jdField_a_of_type_Long), "", "");
        }
      }
    }
  }
  
  protected String h()
  {
    return a(b(), this.jdField_a_of_type_Long, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojk
 * JD-Core Version:    0.7.0.1
 */