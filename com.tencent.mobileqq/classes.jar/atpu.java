import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class atpu
  extends nmf
{
  atpu(atpn paramatpn, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      atqa.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(atpn.a(this.jdField_a_of_type_Atpn)), ", isFirstShow =", Boolean.valueOf(atpn.b(this.jdField_a_of_type_Atpn)) });
      if (atpn.b(this.jdField_a_of_type_Atpn)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + atpn.b(this.jdField_a_of_type_Atpn));
      return;
    }
    if (atpn.a(this.jdField_a_of_type_Atpn))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + atpn.a(this.jdField_a_of_type_Atpn));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + atpn.b(this.jdField_a_of_type_Atpn) + ", sendStamp = " + l);
      if ((l == -1L) || (l != atpn.b(this.jdField_a_of_type_Atpn)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    atpn.a(this.jdField_a_of_type_Atpn, true);
    paramBundle = ForwardUtils.parseOIDBb77RspBody(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    atpn.a(this.jdField_a_of_type_Atpn).removeMessages(94);
    this.jdField_a_of_type_Atpn.c();
    paramBundle = atpn.a(this.jdField_a_of_type_Atpn);
    String str4 = ForwardUtils.reqTypeToReportData(atpn.a(this.jdField_a_of_type_Atpn).getInt("req_type"));
    String str5 = ForwardUtils.toType(atpn.a(this.jdField_a_of_type_Atpn).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      bcef.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      atpn.a(this.jdField_a_of_type_Atpn, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      atpn.b(this.jdField_a_of_type_Atpn, str1);
    }
    for (;;)
    {
      atpn.c(this.jdField_a_of_type_Atpn, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      atpn.a(this.jdField_a_of_type_Atpn);
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
 * Qualified Name:     atpu
 * JD-Core Version:    0.7.0.1
 */