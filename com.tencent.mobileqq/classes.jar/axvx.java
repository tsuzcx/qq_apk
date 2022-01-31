import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class axvx
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
    localStructMsgForGeneralShare.mMsgBrief = ajya.a(2131714626);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localaxuq1 = axuz.a(2);
      localaxuq1.a(new axws((String)paramArrayList.get(0)));
      localaxuq1.a(new StructMsgItemTitle(""));
      localaxuq1.a(new axzj(ajya.a(2131714616)));
      paramArrayList = axuz.a(0);
      paramArrayList.a(new axzh(0));
      localStructMsgForGeneralShare.addItem(localaxuq1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    axuq localaxuq1 = axuz.a(3);
    if (i == 2)
    {
      localaxuq1.a(new axws((String)paramArrayList.get(0)));
      localaxuq1.a(new axws((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = axuz.a(0);
      paramArrayList.a(new axzh(0));
      axuq localaxuq2 = axuz.a(0);
      localaxuq2.a(new axzj(ajya.a(2131714607)));
      localStructMsgForGeneralShare.addItem(localaxuq1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localaxuq2);
      break;
      localaxuq1.a(new axws((String)paramArrayList.get(0)));
      localaxuq1.a(new axws((String)paramArrayList.get(1)));
      localaxuq1.a(new axws((String)paramArrayList.get(2)));
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
 * Qualified Name:     axvx
 * JD-Core Version:    0.7.0.1
 */