import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class arzr
  extends nac
{
  arzr(arzk paramarzk, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      arzy.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMesssage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(arzk.a(this.jdField_a_of_type_Arzk)), ", isFirstShow =", Boolean.valueOf(arzk.b(this.jdField_a_of_type_Arzk)) });
      if (arzk.b(this.jdField_a_of_type_Arzk)) {
        break;
      }
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isFirstShow =" + arzk.b(this.jdField_a_of_type_Arzk));
      return;
    }
    if (arzk.a(this.jdField_a_of_type_Arzk))
    {
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isTimeOut =" + arzk.a(this.jdField_a_of_type_Arzk));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState currentRequestTime =" + arzk.b(this.jdField_a_of_type_Arzk) + ", sendStamp = " + l);
      if ((l == -1L) || (l != arzk.b(this.jdField_a_of_type_Arzk)))
      {
        QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for sendStamp");
        return;
      }
    }
    arzk.a(this.jdField_a_of_type_Arzk, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    arzk.a(this.jdField_a_of_type_Arzk).removeMessages(94);
    this.jdField_a_of_type_Arzk.c();
    paramBundle = arzk.a(this.jdField_a_of_type_Arzk);
    String str4 = ForwardUtils.c(arzk.a(this.jdField_a_of_type_Arzk).getInt("req_type"));
    String str5 = ForwardUtils.a(arzk.a(this.jdField_a_of_type_Arzk).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      azmj.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      arzk.a(this.jdField_a_of_type_Arzk, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      arzk.b(this.jdField_a_of_type_Arzk, str1);
    }
    for (;;)
    {
      arzk.c(this.jdField_a_of_type_Arzk, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      arzk.a(this.jdField_a_of_type_Arzk);
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel())) {
      QLog.e("ForwardShareByServerHelper", 2, "onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzr
 * JD-Core Version:    0.7.0.1
 */