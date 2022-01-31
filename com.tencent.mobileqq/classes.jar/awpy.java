import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class awpy
  extends awpz
{
  String a = null;
  
  awof a(afgx paramafgx, List<awog> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    awng localawng;
    if (paramList != null)
    {
      localawng = (awng)paramList.get(0);
      if ((localawng != null) && (localawng.a() != null))
      {
        String str = localawng.a().hotword.get();
        noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localawng.a(), str, String.valueOf(localawng.a().hotword_type.get()), "");
      }
      if ((localawng == null) || (localawng.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localawng != null) && (localawng.a() != null)) {
        noo.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localawng.a().account_id.get()));
      }
      awvx.a(110);
      this.a = paramString2;
      return new awnf(paramafgx, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localawng = (awng)paramList.get(1);
      } else {
        localawng = null;
      }
    }
  }
  
  awog a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new awng(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  awog a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new awng(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpy
 * JD-Core Version:    0.7.0.1
 */