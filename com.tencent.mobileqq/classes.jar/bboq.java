import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class bboq
  extends bbor
{
  String a = null;
  
  bbmx a(aitt paramaitt, List<bbmy> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    bbly localbbly;
    if (paramList != null)
    {
      localbbly = (bbly)paramList.get(0);
      if ((localbbly != null) && (localbbly.a() != null))
      {
        String str = localbbly.a().hotword.get();
        oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localbbly.a(), str, String.valueOf(localbbly.a().hotword_type.get()), "");
      }
      if ((localbbly == null) || (localbbly.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localbbly != null) && (localbbly.a() != null)) {
        oat.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localbbly.a().account_id.get()));
      }
      bbuo.a(110);
      this.a = paramString2;
      return new bblx(paramaitt, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localbbly = (bbly)paramList.get(1);
      } else {
        localbbly = null;
      }
    }
  }
  
  bbmy a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new bbly(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  bbmy a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new bbly(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboq
 * JD-Core Version:    0.7.0.1
 */