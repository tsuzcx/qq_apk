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

public class bgrf
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgrf.class.getName();
  }
  
  public static bgrg a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new bgrg();
        ((bgrg)localObject1).jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((bgrg)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((bgrg)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((bgrg)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((bgrg)localObject1).jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((bgrg)localObject1).jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((bgrg)localObject1).jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((bgrg)localObject1).jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend")))) {
        bnwq.a().a(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to int. " + localException.getMessage());
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, bgrg parambgrg)
  {
    try
    {
      if (TextUtils.isEmpty(parambgrg.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (parambgrg.jdField_b_of_type_JavaLangString.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", parambgrg.jdField_b_of_type_JavaLangString);
        tzq.a(paramAppInterface, parambgrg.jdField_b_of_type_JavaLangString);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!parambgrg.jdField_b_of_type_JavaLangString.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        bhni.a((QQAppInterface)paramAppInterface, paramContext, parambgrg.jdField_b_of_type_JavaLangString).a();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(parambgrg.jdField_b_of_type_JavaLangString)));
  }
  
  public static void a(MessageRecord paramMessageRecord, bgrg parambgrg)
  {
    if ((parambgrg == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(parambgrg.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", parambgrg.jdField_a_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", parambgrg.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", parambgrg.jdField_c_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(parambgrg.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", parambgrg.jdField_d_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(parambgrg.jdField_c_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(parambgrg.jdField_d_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrf
 * JD-Core Version:    0.7.0.1
 */