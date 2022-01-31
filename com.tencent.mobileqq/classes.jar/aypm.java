import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class aypm
  extends aypn
{
  String a = null;
  
  aynt a(ahip paramahip, List<aynu> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    aymu localaymu;
    if (paramList != null)
    {
      localaymu = (aymu)paramList.get(0);
      if ((localaymu != null) && (localaymu.a() != null))
      {
        String str = localaymu.a().hotword.get();
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localaymu.a(), str, String.valueOf(localaymu.a().hotword_type.get()), "");
      }
      if ((localaymu == null) || (localaymu.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localaymu != null) && (localaymu.a() != null)) {
        nrt.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localaymu.a().account_id.get()));
      }
      ayvl.a(110);
      this.a = paramString2;
      return new aymt(paramahip, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localaymu = (aymu)paramList.get(1);
      } else {
        localaymu = null;
      }
    }
  }
  
  aynu a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new aymu(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  aynu a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new aymu(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypm
 * JD-Core Version:    0.7.0.1
 */