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

public class bajp
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bajp.class.getName();
  }
  
  public static bajq a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new bajq();
        ((bajq)localObject1).jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((bajq)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((bajq)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((bajq)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((bajq)localObject1).jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((bajq)localObject1).jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((bajq)localObject1).jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((bajq)localObject1).jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      return localObject1;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to int. " + paramMessageRecord.getMessage());
    }
    return localObject1;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, bajq parambajq)
  {
    try
    {
      if (TextUtils.isEmpty(parambajq.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (parambajq.jdField_b_of_type_JavaLangString.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", parambajq.jdField_b_of_type_JavaLangString);
        sgg.a(paramAppInterface, parambajq.jdField_b_of_type_JavaLangString);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!parambajq.jdField_b_of_type_JavaLangString.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        bbex.a((QQAppInterface)paramAppInterface, paramContext, parambajq.jdField_b_of_type_JavaLangString).c();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(parambajq.jdField_b_of_type_JavaLangString)));
  }
  
  public static void a(MessageRecord paramMessageRecord, bajq parambajq)
  {
    if ((parambajq == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(parambajq.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", parambajq.jdField_a_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", parambajq.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", parambajq.jdField_c_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(parambajq.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", parambajq.jdField_d_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(parambajq.jdField_c_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(parambajq.jdField_d_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajp
 * JD-Core Version:    0.7.0.1
 */