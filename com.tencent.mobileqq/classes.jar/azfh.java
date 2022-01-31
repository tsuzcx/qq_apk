import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.troop.homework.ErrorInfo;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class azfh
  extends ajuc
{
  public azfh(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg)
  {
    if (QLog.isColorLevel()) {
      if (paramRspSend1V1Msg != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = "null";; localObject = vlw.a(paramRspSend1V1Msg))
    {
      QLog.d(".troop.troop_app.BulkSendMessageFragment", 2, new Object[] { "Receive response succ=", Boolean.valueOf(paramBoolean), "resp: ", localObject });
      if (this.a.jdField_a_of_type_Vmv != null)
      {
        this.a.jdField_a_of_type_Vmv.a();
        this.a.jdField_a_of_type_Vmv = null;
      }
      localObject = this.a.getActivity();
      if (localObject != null) {
        break;
      }
      QLog.e(".troop.troop_app.BulkSendMessageFragment", 2, "onBulkSendMessage() Error: getActivity == null");
      return;
    }
    if (paramRspSend1V1Msg == null)
    {
      bbmy.a((Context)localObject, 1, ajjy.a(2131635437), 1).a();
      return;
    }
    if (paramRspSend1V1Msg.result.error_code.get() != 0)
    {
      bbmy.a((Context)localObject, 1, paramRspSend1V1Msg.result.error_desc.get().toStringUtf8(), 1).a();
      return;
    }
    bbmy.a((Context)localObject, 2, ajjy.a(2131635433), 1).a();
    ((FragmentActivity)localObject).finish();
    ((FragmentActivity)localObject).overridePendingTransition(0, 2130772001);
    paramRspSend1V1Msg = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (paramRspSend1V1Msg != null) {
      paramRspSend1V1Msg.sendEmptyMessage(1009);
    }
    paramRspSend1V1Msg = azzx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString);
    azzx.a("Grp_edu", "MassMessage", "CreateMessage_Send", 0, 0, new String[] { this.a.jdField_a_of_type_JavaLangString, paramRspSend1V1Msg, paramReqSend1V1Msg.text.get().toStringUtf8(), String.valueOf(paramReqSend1V1Msg.to_uins.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfh
 * JD-Core Version:    0.7.0.1
 */