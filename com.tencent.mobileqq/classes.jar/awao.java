import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.ShareMsgImpl.3;

public class awao
  implements pkr
{
  public awao(ShareMsgImpl.3 param3) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool2 = false;
    if ((this.a.this$0.b == null) || (!this.a.this$0.b.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool1 = bool2;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      znl.a(1, 2131718766);
      bool1 = bool2;
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Awar.onSharMsgcallback(this.a.this$0.jdField_a_of_type_JavaLangString, String.valueOf(bool1));
      return;
      znl.a(2, 2131718784);
      if ((this.a.this$0.jdField_a_of_type_Bikj != null) && (this.a.this$0.jdField_a_of_type_Bikm != null))
      {
        int i;
        label162:
        String str1;
        String str2;
        String str3;
        if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
        {
          i = 1009;
          paramBaseResp = this.a.this$0.jdField_a_of_type_Bikj.getMsgid();
          str1 = this.a.this$0.jdField_a_of_type_Bikj.getPublicUin();
          str2 = this.a.b;
          str3 = AccountDetailActivity.a(this.a.this$0.jdField_a_of_type_Bikm.getCurrentUrl());
          String str4 = this.a.this$0.jdField_a_of_type_Bikj.getSourcePuin();
          if ((str4 == null) || ("".equals(str4))) {
            break label305;
          }
          olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Bikm.getCurrentUrl(), str3, false);
        }
        for (;;)
        {
          bool1 = true;
          break;
          i = 1004;
          break label162;
          label305:
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString)) {
            i = 1003;
          }
          olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
        }
      }
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awao
 * JD-Core Version:    0.7.0.1
 */