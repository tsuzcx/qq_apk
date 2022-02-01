import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class bdpc
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
    localStructMsgForGeneralShare.mMsgBrief = anvx.a(2131713999);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localbdnv1 = bdoe.a(2);
      localbdnv1.a(new bdpx((String)paramArrayList.get(0)));
      localbdnv1.a(new StructMsgItemTitle(""));
      localbdnv1.a(new bdsv(anvx.a(2131713989)));
      paramArrayList = bdoe.a(0);
      paramArrayList.a(new bdst(0));
      localStructMsgForGeneralShare.addItem(localbdnv1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    bdnv localbdnv1 = bdoe.a(3);
    if (i == 2)
    {
      localbdnv1.a(new bdpx((String)paramArrayList.get(0)));
      localbdnv1.a(new bdpx((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = bdoe.a(0);
      paramArrayList.a(new bdst(0));
      bdnv localbdnv2 = bdoe.a(0);
      localbdnv2.a(new bdsv(anvx.a(2131713980)));
      localStructMsgForGeneralShare.addItem(localbdnv1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localbdnv2);
      break;
      localbdnv1.a(new bdpx((String)paramArrayList.get(0)));
      localbdnv1.a(new bdpx((String)paramArrayList.get(1)));
      localbdnv1.a(new bdpx((String)paramArrayList.get(2)));
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
 * Qualified Name:     bdpc
 * JD-Core Version:    0.7.0.1
 */