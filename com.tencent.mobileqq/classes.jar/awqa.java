import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class awqa
  extends awqb
{
  String a = null;
  
  awoh a(afgv paramafgv, List<awoi> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    awni localawni;
    if (paramList != null)
    {
      localawni = (awni)paramList.get(0);
      if ((localawni != null) && (localawni.a() != null))
      {
        String str = localawni.a().hotword.get();
        nol.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localawni.a(), str, String.valueOf(localawni.a().hotword_type.get()), "");
      }
      if ((localawni == null) || (localawni.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localawni != null) && (localawni.a() != null)) {
        nol.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localawni.a().account_id.get()));
      }
      awvz.a(110);
      this.a = paramString2;
      return new awnh(paramafgv, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localawni = (awni)paramList.get(1);
      } else {
        localawni = null;
      }
    }
  }
  
  awoi a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new awni(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  awoi a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new awni(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqa
 * JD-Core Version:    0.7.0.1
 */