import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import java.util.HashMap;
import org.json.JSONObject;

public class aruk
  extends ClickableSpan
{
  public aruk(MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.frienduin;
    Object localObject1 = new JSONObject();
    paramView = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("name", localObject2);
      ((JSONObject)localObject1).put("grouptype", 1 + "");
      ((JSONObject)localObject1).put("groupid", str);
      localObject2 = (akqe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagIndex))) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId = ((String)((akqe)localObject2).h.get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagIndex));
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId)) {
        return;
      }
      localObject2 = (String)((akqe)localObject2).d.get(((akqe)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.istroop) + "_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.frienduin + "_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      ((JSONObject)localObject1).put("listid", this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId);
      ((JSONObject)localObject1).put("authkey", localObject2);
      paramView.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView.put("viewTag", "redgiftDetail");
      paramView.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      paramView.put("come_from", 2);
      paramView.put("extra_data", localObject1);
    }
    catch (Exception localException)
    {
      label296:
      break label296;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", paramView.toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
    paramView.putExtras((Bundle)localObject1);
    paramView.putExtra("pay_requestcode", 5);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    return;
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
 * Qualified Name:     aruk
 * JD-Core Version:    0.7.0.1
 */