import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class bcie
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
    localStructMsgForGeneralShare.mMsgBrief = amtj.a(2131713652);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localbcgx1 = bchg.a(2);
      localbcgx1.a(new bciz((String)paramArrayList.get(0)));
      localbcgx1.a(new StructMsgItemTitle(""));
      localbcgx1.a(new bclv(amtj.a(2131713642)));
      paramArrayList = bchg.a(0);
      paramArrayList.a(new bclt(0));
      localStructMsgForGeneralShare.addItem(localbcgx1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    bcgx localbcgx1 = bchg.a(3);
    if (i == 2)
    {
      localbcgx1.a(new bciz((String)paramArrayList.get(0)));
      localbcgx1.a(new bciz((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = bchg.a(0);
      paramArrayList.a(new bclt(0));
      bcgx localbcgx2 = bchg.a(0);
      localbcgx2.a(new bclv(amtj.a(2131713633)));
      localStructMsgForGeneralShare.addItem(localbcgx1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localbcgx2);
      break;
      localbcgx1.a(new bciz((String)paramArrayList.get(0)));
      localbcgx1.a(new bciz((String)paramArrayList.get(1)));
      localbcgx1.a(new bciz((String)paramArrayList.get(2)));
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
 * Qualified Name:     bcie
 * JD-Core Version:    0.7.0.1
 */