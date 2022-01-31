import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;

public class arnf
  implements bcww
{
  public arnf(QQApiPlugin.3 param3) {}
  
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
      wij.a(1, 2131719487);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_JavaLangString))
      {
        this.a.this$0.callJs(this.a.this$0.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(bool) });
        return;
        wij.a(2, 2131719506);
        if ((this.a.this$0.jdField_a_of_type_Bcig != null) && (this.a.this$0.jdField_a_of_type_Bcij != null))
        {
          int i;
          label171:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
          {
            i = 1009;
            paramBaseResp = this.a.this$0.jdField_a_of_type_Bcig.f();
            str1 = this.a.this$0.jdField_a_of_type_Bcig.g();
            str2 = this.a.b;
            str3 = AccountDetailActivity.a(this.a.this$0.jdField_a_of_type_Bcij.b());
            String str4 = this.a.this$0.jdField_a_of_type_Bcig.h();
            if ((str4 == null) || ("".equals(str4))) {
              break label314;
            }
            nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Bcij.b(), str3, false);
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
            nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnf
 * JD-Core Version:    0.7.0.1
 */