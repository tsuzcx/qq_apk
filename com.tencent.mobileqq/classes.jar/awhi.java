import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;

public class awhi
  implements bjig
{
  public awhi(QQApiPlugin.3 param3) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.this$0.c == null) || (!this.a.this$0.c.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      zyx.a(1, 2131718139);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_JavaLangString))
      {
        this.a.this$0.callJs(this.a.this$0.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(bool) });
        return;
        zyx.a(2, 2131718157);
        if ((this.a.this$0.jdField_a_of_type_Bitp != null) && (this.a.this$0.jdField_a_of_type_Bits != null))
        {
          int i;
          label171:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
          {
            i = 1009;
            paramBaseResp = this.a.this$0.jdField_a_of_type_Bitp.getMsgid();
            str1 = this.a.this$0.jdField_a_of_type_Bitp.getPublicUin();
            str2 = this.a.b;
            str3 = AccountDetailActivity.a(this.a.this$0.jdField_a_of_type_Bits.getCurrentUrl());
            String str4 = this.a.this$0.jdField_a_of_type_Bitp.getSourcePuin();
            if ((str4 == null) || ("".equals(str4))) {
              break label314;
            }
            ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Bits.getCurrentUrl(), str3, false);
          }
          for (;;)
          {
            bool = true;
            break;
            i = 1004;
            break label171;
            label314:
            if ("2".equals(this.a.jdField_a_of_type_JavaLangString)) {
              i = 1003;
            }
            ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
          }
          bool = false;
        }
      }
      else
      {
        this.a.this$0.callJs4OpenApiIfNeeded("shareMsg", 0, String.valueOf(bool));
        return;
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhi
 * JD-Core Version:    0.7.0.1
 */