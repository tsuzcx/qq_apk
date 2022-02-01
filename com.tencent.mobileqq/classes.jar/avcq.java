import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class avcq
  extends nkq
{
  avcq(avcj paramavcj, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      avcw.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(avcj.a(this.jdField_a_of_type_Avcj)), ", isFirstShow =", Boolean.valueOf(avcj.b(this.jdField_a_of_type_Avcj)) });
      if (avcj.b(this.jdField_a_of_type_Avcj)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + avcj.b(this.jdField_a_of_type_Avcj));
      return;
    }
    if (avcj.a(this.jdField_a_of_type_Avcj))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + avcj.a(this.jdField_a_of_type_Avcj));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + avcj.b(this.jdField_a_of_type_Avcj) + ", sendStamp = " + l);
      if ((l == -1L) || (l != avcj.b(this.jdField_a_of_type_Avcj)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    avcj.a(this.jdField_a_of_type_Avcj, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    avcj.a(this.jdField_a_of_type_Avcj).removeMessages(94);
    this.jdField_a_of_type_Avcj.c();
    paramBundle = avcj.a(this.jdField_a_of_type_Avcj);
    String str4 = ForwardUtils.c(avcj.a(this.jdField_a_of_type_Avcj).getInt("req_type"));
    String str5 = ForwardUtils.a(avcj.a(this.jdField_a_of_type_Avcj).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      bdll.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      avcj.a(this.jdField_a_of_type_Avcj, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      avcj.b(this.jdField_a_of_type_Avcj, str1);
    }
    for (;;)
    {
      avcj.c(this.jdField_a_of_type_Avcj, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      avcj.a(this.jdField_a_of_type_Avcj);
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
 * Qualified Name:     avcq
 * JD-Core Version:    0.7.0.1
 */