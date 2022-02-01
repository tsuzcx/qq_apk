import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public class bdgk
  implements agwi
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {}
    while (!"1033".equals(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"))) {
      return;
    }
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800AF35", "0X800AF35", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgk
 * JD-Core Version:    0.7.0.1
 */