import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class bchb
  extends bchc
{
  String a = null;
  
  bcfi a(aiuk paramaiuk, List<bcfj> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    bcej localbcej;
    if (paramList != null)
    {
      localbcej = (bcej)paramList.get(0);
      if ((localbcej != null) && (localbcej.a() != null))
      {
        String str = localbcej.a().hotword.get();
        olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localbcej.a(), str, String.valueOf(localbcej.a().hotword_type.get()), "");
      }
      if ((localbcej == null) || (localbcej.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localbcej != null) && (localbcej.a() != null)) {
        olh.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localbcej.a().account_id.get()));
      }
      bcnb.a(110);
      this.a = paramString2;
      return new bcei(paramaiuk, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localbcej = (bcej)paramList.get(1);
      } else {
        localbcej = null;
      }
    }
  }
  
  bcfj a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new bcej(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  bcfj a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new bcej(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchb
 * JD-Core Version:    0.7.0.1
 */