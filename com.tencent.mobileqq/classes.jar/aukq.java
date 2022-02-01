import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aukq
  extends niv
{
  aukq(aukj paramaukj, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aukw.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(aukj.a(this.jdField_a_of_type_Aukj)), ", isFirstShow =", Boolean.valueOf(aukj.b(this.jdField_a_of_type_Aukj)) });
      if (aukj.b(this.jdField_a_of_type_Aukj)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + aukj.b(this.jdField_a_of_type_Aukj));
      return;
    }
    if (aukj.a(this.jdField_a_of_type_Aukj))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + aukj.a(this.jdField_a_of_type_Aukj));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + aukj.b(this.jdField_a_of_type_Aukj) + ", sendStamp = " + l);
      if ((l == -1L) || (l != aukj.b(this.jdField_a_of_type_Aukj)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    aukj.a(this.jdField_a_of_type_Aukj, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    aukj.a(this.jdField_a_of_type_Aukj).removeMessages(94);
    this.jdField_a_of_type_Aukj.c();
    paramBundle = aukj.a(this.jdField_a_of_type_Aukj);
    String str4 = ForwardUtils.c(aukj.a(this.jdField_a_of_type_Aukj).getInt("req_type"));
    String str5 = ForwardUtils.a(aukj.a(this.jdField_a_of_type_Aukj).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      bcst.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      aukj.a(this.jdField_a_of_type_Aukj, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      aukj.b(this.jdField_a_of_type_Aukj, str1);
    }
    for (;;)
    {
      aukj.c(this.jdField_a_of_type_Aukj, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      aukj.a(this.jdField_a_of_type_Aukj);
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
 * Qualified Name:     aukq
 * JD-Core Version:    0.7.0.1
 */