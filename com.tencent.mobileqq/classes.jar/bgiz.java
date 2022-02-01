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
import cooperation.vip.tianshu.TianShuManager;

public class bgiz
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgiz.class.getName();
  }
  
  public static bgja a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new bgja();
        ((bgja)localObject1).jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((bgja)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((bgja)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((bgja)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((bgja)localObject1).jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((bgja)localObject1).jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((bgja)localObject1).jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((bgja)localObject1).jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend")))) {
        TianShuManager.getInstance().cacheTraceInfo(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
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
  
  public static void a(AppInterface paramAppInterface, Context paramContext, bgja parambgja)
  {
    try
    {
      if (TextUtils.isEmpty(parambgja.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (parambgja.jdField_b_of_type_JavaLangString.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", parambgja.jdField_b_of_type_JavaLangString);
        uuc.a(paramAppInterface, parambgja.jdField_b_of_type_JavaLangString);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!parambgja.jdField_b_of_type_JavaLangString.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        bhey.a((QQAppInterface)paramAppInterface, paramContext, parambgja.jdField_b_of_type_JavaLangString).a();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(parambgja.jdField_b_of_type_JavaLangString)));
  }
  
  public static void a(MessageRecord paramMessageRecord, bgja parambgja)
  {
    if ((parambgja == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(parambgja.jdField_a_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", parambgja.jdField_a_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", parambgja.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", parambgja.jdField_c_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(parambgja.jdField_b_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", parambgja.jdField_d_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(parambgja.jdField_c_of_type_Int));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(parambgja.jdField_d_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgiz
 * JD-Core Version:    0.7.0.1
 */