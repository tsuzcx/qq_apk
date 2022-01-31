import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class azrr
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
    localStructMsgForGeneralShare.mMsgBrief = alpo.a(2131714998);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localazqk1 = azqt.a(2);
      localazqk1.a(new azsm((String)paramArrayList.get(0)));
      localazqk1.a(new StructMsgItemTitle(""));
      localazqk1.a(new azvd(alpo.a(2131714988)));
      paramArrayList = azqt.a(0);
      paramArrayList.a(new azvb(0));
      localStructMsgForGeneralShare.addItem(localazqk1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    azqk localazqk1 = azqt.a(3);
    if (i == 2)
    {
      localazqk1.a(new azsm((String)paramArrayList.get(0)));
      localazqk1.a(new azsm((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = azqt.a(0);
      paramArrayList.a(new azvb(0));
      azqk localazqk2 = azqt.a(0);
      localazqk2.a(new azvd(alpo.a(2131714979)));
      localStructMsgForGeneralShare.addItem(localazqk1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localazqk2);
      break;
      localazqk1.a(new azsm((String)paramArrayList.get(0)));
      localazqk1.a(new azsm((String)paramArrayList.get(1)));
      localazqk1.a(new azsm((String)paramArrayList.get(2)));
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
 * Qualified Name:     azrr
 * JD-Core Version:    0.7.0.1
 */