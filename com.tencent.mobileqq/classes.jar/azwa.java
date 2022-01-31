import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class azwa
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
    localStructMsgForGeneralShare.mMsgBrief = alud.a(2131715010);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localazut1 = azvc.a(2);
      localazut1.a(new azwv((String)paramArrayList.get(0)));
      localazut1.a(new StructMsgItemTitle(""));
      localazut1.a(new azzm(alud.a(2131715000)));
      paramArrayList = azvc.a(0);
      paramArrayList.a(new azzk(0));
      localStructMsgForGeneralShare.addItem(localazut1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    azut localazut1 = azvc.a(3);
    if (i == 2)
    {
      localazut1.a(new azwv((String)paramArrayList.get(0)));
      localazut1.a(new azwv((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = azvc.a(0);
      paramArrayList.a(new azzk(0));
      azut localazut2 = azvc.a(0);
      localazut2.a(new azzm(alud.a(2131714991)));
      localStructMsgForGeneralShare.addItem(localazut1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localazut2);
      break;
      localazut1.a(new azwv((String)paramArrayList.get(0)));
      localazut1.a(new azwv((String)paramArrayList.get(1)));
      localazut1.a(new azwv((String)paramArrayList.get(2)));
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
 * Qualified Name:     azwa
 * JD-Core Version:    0.7.0.1
 */