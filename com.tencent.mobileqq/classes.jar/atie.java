import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;

public class atie
  implements bfah
{
  public atie(QQApiPlugin.3 param3) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.this$0.c == null) || (!this.a.this$0.c.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ybk.a(1, 2131720031);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_JavaLangString))
      {
        this.a.this$0.callJs(this.a.this$0.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(bool) });
        return;
        ybk.a(2, 2131720050);
        if ((this.a.this$0.jdField_a_of_type_Belq != null) && (this.a.this$0.jdField_a_of_type_Belt != null))
        {
          int i;
          label171:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
          {
            i = 1009;
            paramBaseResp = this.a.this$0.jdField_a_of_type_Belq.g();
            str1 = this.a.this$0.jdField_a_of_type_Belq.h();
            str2 = this.a.b;
            str3 = AccountDetailActivity.a(this.a.this$0.jdField_a_of_type_Belt.b());
            String str4 = this.a.this$0.jdField_a_of_type_Belq.i();
            if ((str4 == null) || ("".equals(str4))) {
              break label314;
            }
            nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Belt.b(), str3, false);
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
            nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atie
 * JD-Core Version:    0.7.0.1
 */