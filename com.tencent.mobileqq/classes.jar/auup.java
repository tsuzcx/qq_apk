import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class auup
  extends ntf
{
  auup(auui paramauui, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      auuv.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(auui.a(this.jdField_a_of_type_Auui)), ", isFirstShow =", Boolean.valueOf(auui.b(this.jdField_a_of_type_Auui)) });
      if (auui.b(this.jdField_a_of_type_Auui)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + auui.b(this.jdField_a_of_type_Auui));
      return;
    }
    if (auui.a(this.jdField_a_of_type_Auui))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + auui.a(this.jdField_a_of_type_Auui));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + auui.b(this.jdField_a_of_type_Auui) + ", sendStamp = " + l);
      if ((l == -1L) || (l != auui.b(this.jdField_a_of_type_Auui)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    auui.a(this.jdField_a_of_type_Auui, true);
    paramBundle = ForwardUtils.parseOIDBb77RspBody(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    auui.a(this.jdField_a_of_type_Auui).removeMessages(94);
    this.jdField_a_of_type_Auui.c();
    paramBundle = auui.a(this.jdField_a_of_type_Auui);
    String str4 = ForwardUtils.reqTypeToReportData(auui.a(this.jdField_a_of_type_Auui).getInt("req_type"));
    String str5 = ForwardUtils.toType(auui.a(this.jdField_a_of_type_Auui).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      bdla.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      auui.a(this.jdField_a_of_type_Auui, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      auui.b(this.jdField_a_of_type_Auui, str1);
    }
    for (;;)
    {
      auui.c(this.jdField_a_of_type_Auui, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      auui.a(this.jdField_a_of_type_Auui);
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel())) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auup
 * JD-Core Version:    0.7.0.1
 */