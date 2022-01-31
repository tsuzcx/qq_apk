import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aqgc
  extends mxj
{
  aqgc(aqfv paramaqfv, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aqgj.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMesssage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(aqfv.a(this.jdField_a_of_type_Aqfv)), ", isFirstShow =", Boolean.valueOf(aqfv.b(this.jdField_a_of_type_Aqfv)) });
      if (aqfv.b(this.jdField_a_of_type_Aqfv)) {
        break;
      }
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isFirstShow =" + aqfv.b(this.jdField_a_of_type_Aqfv));
      return;
    }
    if (aqfv.a(this.jdField_a_of_type_Aqfv))
    {
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isTimeOut =" + aqfv.a(this.jdField_a_of_type_Aqfv));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState currentRequestTime =" + aqfv.b(this.jdField_a_of_type_Aqfv) + ", sendStamp = " + l);
      if ((l == -1L) || (l != aqfv.b(this.jdField_a_of_type_Aqfv)))
      {
        QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for sendStamp");
        return;
      }
    }
    aqfv.a(this.jdField_a_of_type_Aqfv, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    aqfv.a(this.jdField_a_of_type_Aqfv).removeMessages(94);
    this.jdField_a_of_type_Aqfv.c();
    paramBundle = aqfv.a(this.jdField_a_of_type_Aqfv);
    String str4 = ForwardUtils.c(aqfv.a(this.jdField_a_of_type_Aqfv).getInt("req_type"));
    String str5 = ForwardUtils.a(aqfv.a(this.jdField_a_of_type_Aqfv).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      axqy.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      aqfv.a(this.jdField_a_of_type_Aqfv, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      aqfv.b(this.jdField_a_of_type_Aqfv, str1);
    }
    for (;;)
    {
      aqfv.c(this.jdField_a_of_type_Aqfv, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      aqfv.a(this.jdField_a_of_type_Aqfv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgc
 * JD-Core Version:    0.7.0.1
 */