import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Map;
import org.json.JSONObject;

public class apat
  extends ClickableSpan
{
  public apat(MessageForQQWalletTips paramMessageForQQWalletTips, SoftReference paramSoftReference1, SoftReference paramSoftReference2, QQAppInterface paramQQAppInterface, Context paramContext, afbe paramafbe, aipw paramaipw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QLog.i(MessageForQQWalletTips.access$000(), 2, "rich click, msgtype: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.msgType + ", msgsubtype: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.subType);
    paramView = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    Object localObject1 = (QQAppInterface)this.b.get();
    if ((localObject1 == null) || (paramView == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.bytes_jumpurl))
      {
        QLog.i(MessageForQQWalletTips.access$000(), 2, "gold red package...");
        paramView = bixy.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.bytes_jumpurl, MessageForQQWalletTips.access$100(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), true);
        ajae.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        return;
      }
      if ((MessageForQQWalletTips.access$200(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips) != 524288) || (this.jdField_a_of_type_Afbe == null) || (this.jdField_a_of_type_Aipw == null)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_Aipw.a(MessageForQQWalletTips.access$300(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips));
      if ((localObject2 == null) || (((aipv)localObject2).a) || (((aipv)localObject2).b) || (((aipv)localObject2).a())) {
        break;
      }
      paramView = this.jdField_a_of_type_Aipw.a(((aipv)localObject2).e);
    } while (bdje.a(paramView));
    this.jdField_a_of_type_Afbe.a(MessageForQQWalletTips.access$300(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips), paramView, aghr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.subChannel), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.subChannel);
    return;
    if (TextUtils.isEmpty(MessageForQQWalletTips.access$300(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips)))
    {
      QLog.i(MessageForQQWalletTips.access$000(), 2, "error, listId is null");
      return;
    }
    Object localObject2 = MessageForQQWalletTips.access$400(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips, (QQAppInterface)localObject1);
    String str1 = (String)((Map)localObject2).get("grouptype");
    String str2 = (String)((Map)localObject2).get("name");
    String str3 = (String)((Map)localObject2).get("groupId");
    JSONObject localJSONObject = new JSONObject();
    localObject2 = new JSONObject();
    try
    {
      localJSONObject.put("listid", MessageForQQWalletTips.access$300(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips));
      localJSONObject.put("name", str2);
      localJSONObject.put("grouptype", str1);
      localJSONObject.put("groupid", str3);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey != null) {
        localJSONObject.put("authkey", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey);
      }
      ((JSONObject)localObject2).put("userId", ((QQAppInterface)localObject1).getCurrentAccountUin());
      ((JSONObject)localObject2).put("viewTag", "redgiftDetail");
      ((JSONObject)localObject2).put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      ((JSONObject)localObject2).put("come_from", 2);
      ((JSONObject)localObject2).put("extra_data", localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    localObject2 = new Intent(paramView, PayBridgeActivity.class);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("pay_requestcode", 5);
    paramView.startActivity((Intent)localObject2);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apat
 * JD-Core Version:    0.7.0.1
 */