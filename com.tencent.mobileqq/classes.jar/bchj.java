import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class bchj
  extends bchk
{
  String a = null;
  
  bcfq a(ajfc paramajfc, List<bcfr> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    bcer localbcer;
    if (paramList != null)
    {
      localbcer = (bcer)paramList.get(0);
      if ((localbcer != null) && (localbcer.a() != null))
      {
        String str = localbcer.a().hotword.get();
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localbcer.a(), str, String.valueOf(localbcer.a().hotword_type.get()), "");
      }
      if ((localbcer == null) || (localbcer.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localbcer != null) && (localbcer.a() != null)) {
        ocd.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localbcer.a().account_id.get()));
      }
      bcnh.a(110);
      this.a = paramString2;
      return new bceq(paramajfc, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localbcer = (bcer)paramList.get(1);
      } else {
        localbcer = null;
      }
    }
  }
  
  bcfr a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new bcer(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  bcfr a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new bcer(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchj
 * JD-Core Version:    0.7.0.1
 */