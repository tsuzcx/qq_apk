import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class axvv
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
    localStructMsgForGeneralShare.mMsgBrief = ajyc.a(2131714615);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localaxuo1 = axux.a(2);
      localaxuo1.a(new axwq((String)paramArrayList.get(0)));
      localaxuo1.a(new StructMsgItemTitle(""));
      localaxuo1.a(new axzh(ajyc.a(2131714605)));
      paramArrayList = axux.a(0);
      paramArrayList.a(new axzf(0));
      localStructMsgForGeneralShare.addItem(localaxuo1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    axuo localaxuo1 = axux.a(3);
    if (i == 2)
    {
      localaxuo1.a(new axwq((String)paramArrayList.get(0)));
      localaxuo1.a(new axwq((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = axux.a(0);
      paramArrayList.a(new axzf(0));
      axuo localaxuo2 = axux.a(0);
      localaxuo2.a(new axzh(ajyc.a(2131714596)));
      localStructMsgForGeneralShare.addItem(localaxuo1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localaxuo2);
      break;
      localaxuo1.a(new axwq((String)paramArrayList.get(0)));
      localaxuo1.a(new axwq((String)paramArrayList.get(1)));
      localaxuo1.a(new axwq((String)paramArrayList.get(2)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvv
 * JD-Core Version:    0.7.0.1
 */