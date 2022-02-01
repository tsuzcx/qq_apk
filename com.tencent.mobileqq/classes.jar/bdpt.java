import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class bdpt
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
    localStructMsgForGeneralShare.mMsgBrief = anzj.a(2131713420);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localbdom1 = bdov.a(2);
      localbdom1.a(new bdqo((String)paramArrayList.get(0)));
      localbdom1.a(new StructMsgItemTitle(""));
      localbdom1.a(new bdtj(anzj.a(2131713410)));
      paramArrayList = bdov.a(0);
      paramArrayList.a(new bdth(0));
      localStructMsgForGeneralShare.addItem(localbdom1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    bdom localbdom1 = bdov.a(3);
    if (i == 2)
    {
      localbdom1.a(new bdqo((String)paramArrayList.get(0)));
      localbdom1.a(new bdqo((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = bdov.a(0);
      paramArrayList.a(new bdth(0));
      bdom localbdom2 = bdov.a(0);
      localbdom2.a(new bdtj(anzj.a(2131713401)));
      localStructMsgForGeneralShare.addItem(localbdom1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localbdom2);
      break;
      localbdom1.a(new bdqo((String)paramArrayList.get(0)));
      localbdom1.a(new bdqo((String)paramArrayList.get(1)));
      localbdom1.a(new bdqo((String)paramArrayList.get(2)));
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
 * Qualified Name:     bdpt
 * JD-Core Version:    0.7.0.1
 */