import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class ayld
  extends ayle
{
  String a = null;
  
  ayjk a(ahea paramahea, List<ayjl> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    ayil localayil;
    if (paramList != null)
    {
      localayil = (ayil)paramList.get(0);
      if ((localayil != null) && (localayil.a() != null))
      {
        String str = localayil.a().hotword.get();
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localayil.a(), str, String.valueOf(localayil.a().hotword_type.get()), "");
      }
      if ((localayil == null) || (localayil.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localayil != null) && (localayil.a() != null)) {
        nrt.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localayil.a().account_id.get()));
      }
      ayrc.a(110);
      this.a = paramString2;
      return new ayik(paramahea, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localayil = (ayil)paramList.get(1);
      } else {
        localayil = null;
      }
    }
  }
  
  ayjl a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new ayil(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  ayjl a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new ayil(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayld
 * JD-Core Version:    0.7.0.1
 */