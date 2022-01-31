import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class avqf
  extends avqg
{
  String a = null;
  
  avom a(aewb paramaewb, List<avon> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    avnn localavnn;
    if (paramList != null)
    {
      localavnn = (avnn)paramList.get(0);
      if ((localavnn != null) && (localavnn.a() != null))
      {
        String str = localavnn.a().hotword.get();
        ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, localavnn.a(), str, String.valueOf(localavnn.a().hotword_type.get()), "");
      }
      if ((localavnn == null) || (localavnn.a() == null)) {
        break label166;
      }
    }
    for (;;)
    {
      if ((localavnn != null) && (localavnn.a() != null)) {
        ndn.a(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localavnn.a().account_id.get()));
      }
      avwe.a(110);
      this.a = paramString2;
      return new avnm(paramaewb, paramList, paramString1, paramString2);
      label166:
      if (paramList.size() > 1) {
        localavnn = (avnn)paramList.get(1);
      } else {
        localavnn = null;
      }
    }
  }
  
  avon a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new avnn(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  avon a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new avnn(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqf
 * JD-Core Version:    0.7.0.1
 */