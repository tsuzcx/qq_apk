import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class bcxa
{
  public static AbsStructMsg a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size(); i <= 0; i = 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.setFlag(1);
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 19;
    localStructMsgForGeneralShare.mMsgBrief = anni.a(2131713311);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localbcvt1 = bcwc.a(2);
      localbcvt1.a(new bcxv((String)paramArrayList.get(0)));
      localbcvt1.a(new StructMsgItemTitle(""));
      localbcvt1.a(new bdaq(anni.a(2131713301)));
      paramArrayList = bcwc.a(0);
      paramArrayList.a(new bdao(0));
      localStructMsgForGeneralShare.addItem(localbcvt1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    bcvt localbcvt1 = bcwc.a(3);
    if (i == 2)
    {
      localbcvt1.a(new bcxv((String)paramArrayList.get(0)));
      localbcvt1.a(new bcxv((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = bcwc.a(0);
      paramArrayList.a(new bdao(0));
      bcvt localbcvt2 = bcwc.a(0);
      localbcvt2.a(new bdaq(anni.a(2131713292)));
      localStructMsgForGeneralShare.addItem(localbcvt1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localbcvt2);
      break;
      localbcvt1.a(new bcxv((String)paramArrayList.get(0)));
      localbcvt1.a(new bcxv((String)paramArrayList.get(1)));
      localbcvt1.a(new bcxv((String)paramArrayList.get(2)));
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgtype != -2011)) {}
    do
    {
      return false;
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
    } while ((paramMessageRecord == null) || (paramMessageRecord.mMsgServiceID != 19));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxa
 * JD-Core Version:    0.7.0.1
 */