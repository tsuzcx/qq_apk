import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public class bect
  implements agwi
{
  private void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface == null) || (paramMessageForUniteGrayTip == null)) {}
    while ((paramMessageForUniteGrayTip.tipParam == null) || (paramMessageForUniteGrayTip.tipParam.b != 131090)) {
      return;
    }
    beeg.b(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin);
  }
  
  private void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface == null) || (paramMessageForUniteGrayTip == null)) {}
    while ((paramMessageForUniteGrayTip.tipParam == null) || (paramMessageForUniteGrayTip.tipParam.b != 131091)) {
      return;
    }
    beue.a(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip))) {
      return;
    }
    paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
    a(paramQQAppInterface, paramMessageRecord);
    b(paramQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bect
 * JD-Core Version:    0.7.0.1
 */