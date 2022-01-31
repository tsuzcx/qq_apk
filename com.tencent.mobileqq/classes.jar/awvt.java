import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class awvt
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
    localStructMsgForGeneralShare.mMsgBrief = ajjy.a(2131648826);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localawum1 = awuv.a(2);
      localawum1.a(new awwo((String)paramArrayList.get(0)));
      localawum1.a(new StructMsgItemTitle(""));
      localawum1.a(new awzf(ajjy.a(2131648816)));
      paramArrayList = awuv.a(0);
      paramArrayList.a(new awzd(0));
      localStructMsgForGeneralShare.addItem(localawum1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    awum localawum1 = awuv.a(3);
    if (i == 2)
    {
      localawum1.a(new awwo((String)paramArrayList.get(0)));
      localawum1.a(new awwo((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = awuv.a(0);
      paramArrayList.a(new awzd(0));
      awum localawum2 = awuv.a(0);
      localawum2.a(new awzf(ajjy.a(2131648807)));
      localStructMsgForGeneralShare.addItem(localawum1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localawum2);
      break;
      localawum1.a(new awwo((String)paramArrayList.get(0)));
      localawum1.a(new awwo((String)paramArrayList.get(1)));
      localawum1.a(new awwo((String)paramArrayList.get(2)));
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
 * Qualified Name:     awvt
 * JD-Core Version:    0.7.0.1
 */