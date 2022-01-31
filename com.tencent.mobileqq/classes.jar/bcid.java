import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class bcid
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcid.class.getName();
  }
  
  public static bcie a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new bcie();
        ((bcie)localObject1).jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((bcie)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((bcie)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((bcie)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((bcie)localObject1).jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((bcie)localObject1).jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((bcie)localObject1).jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((bcie)localObject1).jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      return localObject1;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to int. " + paramMessageRecord.getMessage());
    }
    return localObject1;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, bcie parambcie)
  {
    try
    {
      if (TextUtils.isEmpty(parambcie.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (parambcie.jdField_b_of_type_JavaLangString.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", parambcie.jdField_b_of_type_JavaLangString);
        syb.a(paramAppInterface, parambcie.jdField_b_of_type_JavaLangString);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!parambcie.jdField_b_of_type_JavaLangString.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        bdds.a((QQAppInterface)paramAppInterface, paramContext, parambcie.jdField_b_of_type_JavaLangString).c();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(parambcie.jdField_b_of_type_JavaLangString)));
  }
  
  public static void a(MessageRecord paramMessageRecord, bcie parambcie)
  {
    if ((parambcie == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(parambcie.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", parambcie.jdField_a_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", parambcie.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", parambcie.jdField_c_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(parambcie.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", parambcie.jdField_d_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(parambcie.jdField_c_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(parambcie.jdField_d_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcid
 * JD-Core Version:    0.7.0.1
 */