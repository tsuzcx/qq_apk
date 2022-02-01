import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class bcix
  implements ajve
{
  bcix(bciw parambciw, StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("retCode");
    String str = paramBundle.getString("retMsg");
    int j = paramBundle.getInt("payTime");
    paramBundle = paramBundle.getString("orderId");
    this.jdField_a_of_type_Bciw.a.b(i);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.savePayInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bciw.a.at, i);
    VACDReportUtil.a("ret_code=" + i + "|ret_str=" + str + "|pay_time=" + j + "|order_id=" + paramBundle, "qqwallet", "publicpaymsg.pay.result", null, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcix
 * JD-Core Version:    0.7.0.1
 */