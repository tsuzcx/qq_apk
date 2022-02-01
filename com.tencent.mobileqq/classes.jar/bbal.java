import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class bbal
  extends bbam
{
  String a = null;
  
  bays a(ahzl paramahzl, List<bayt> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    baxt localbaxt;
    if (paramList != null)
    {
      localbaxt = (baxt)paramList.get(0);
      if ((localbaxt != null) && (localbaxt.a() != null))
      {
        String str = localbaxt.a().hotword.get();
        odq.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localbaxt.a(), str, String.valueOf(localbaxt.a().hotword_type.get()), "");
      }
      if ((localbaxt == null) || (localbaxt.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localbaxt != null) && (localbaxt.a() != null)) {
        odq.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localbaxt.a().account_id.get()));
      }
      bbgj.a(110);
      this.a = paramString2;
      return new baxs(paramahzl, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localbaxt = (baxt)paramList.get(1);
      } else {
        localbaxt = null;
      }
    }
  }
  
  bayt a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new baxt(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  bayt a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new baxt(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbal
 * JD-Core Version:    0.7.0.1
 */