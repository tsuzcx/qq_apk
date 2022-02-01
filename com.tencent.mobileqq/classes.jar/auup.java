import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.ShareMsgImpl.3;

public class auup
  implements pbq
{
  public auup(ShareMsgImpl.3 param3) {}
  
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
      yyi.a(1, 2131718380);
      bool1 = bool2;
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Auus.onSharMsgcallback(this.a.this$0.jdField_a_of_type_JavaLangString, String.valueOf(bool1));
      return;
      yyi.a(2, 2131718398);
      if ((this.a.this$0.jdField_a_of_type_Bgzr != null) && (this.a.this$0.jdField_a_of_type_Bgzu != null))
      {
        int i;
        label162:
        String str1;
        String str2;
        String str3;
        if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
        {
          i = 1009;
          paramBaseResp = this.a.this$0.jdField_a_of_type_Bgzr.getMsgid();
          str1 = this.a.this$0.jdField_a_of_type_Bgzr.getPublicUin();
          str2 = this.a.b;
          str3 = AccountDetailActivity.a(this.a.this$0.jdField_a_of_type_Bgzu.getCurrentUrl());
          String str4 = this.a.this$0.jdField_a_of_type_Bgzr.getSourcePuin();
          if ((str4 == null) || ("".equals(str4))) {
            break label305;
          }
          odq.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_Bgzu.getCurrentUrl(), str3, false);
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
          odq.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
        }
      }
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auup
 * JD-Core Version:    0.7.0.1
 */