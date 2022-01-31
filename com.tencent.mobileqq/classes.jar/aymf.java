import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aymf
  extends ajmm
{
  aymf(ayme paramayme) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((!ayme.a(this.a)) || (ayme.a(this.a) == null)) {}
    for (;;)
    {
      return;
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "msgList == null is true");
        }
      }
      else
      {
        paramList = paramList.iterator();
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
        } while (((MessageRecord)paramList.next()).uniseq != ayme.a(this.a).uniseq);
        for (int i = 1; i != 0; i = 0)
        {
          ThreadManager.getUIHandler().post(new TroopAioKeywordTipBar.1.1(this));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aymf
 * JD-Core Version:    0.7.0.1
 */