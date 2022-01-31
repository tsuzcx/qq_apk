import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aqga
  extends mxm
{
  aqga(aqft paramaqft, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aqgh.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMesssage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(aqft.a(this.jdField_a_of_type_Aqft)), ", isFirstShow =", Boolean.valueOf(aqft.b(this.jdField_a_of_type_Aqft)) });
      if (aqft.b(this.jdField_a_of_type_Aqft)) {
        break;
      }
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isFirstShow =" + aqft.b(this.jdField_a_of_type_Aqft));
      return;
    }
    if (aqft.a(this.jdField_a_of_type_Aqft))
    {
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isTimeOut =" + aqft.a(this.jdField_a_of_type_Aqft));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState currentRequestTime =" + aqft.b(this.jdField_a_of_type_Aqft) + ", sendStamp = " + l);
      if ((l == -1L) || (l != aqft.b(this.jdField_a_of_type_Aqft)))
      {
        QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for sendStamp");
        return;
      }
    }
    aqft.a(this.jdField_a_of_type_Aqft, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    aqft.a(this.jdField_a_of_type_Aqft).removeMessages(94);
    this.jdField_a_of_type_Aqft.c();
    paramBundle = aqft.a(this.jdField_a_of_type_Aqft);
    String str4 = ForwardUtils.c(aqft.a(this.jdField_a_of_type_Aqft).getInt("req_type"));
    String str5 = ForwardUtils.a(aqft.a(this.jdField_a_of_type_Aqft).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      axqw.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      aqft.a(this.jdField_a_of_type_Aqft, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      aqft.b(this.jdField_a_of_type_Aqft, str1);
    }
    for (;;)
    {
      aqft.c(this.jdField_a_of_type_Aqft, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      aqft.a(this.jdField_a_of_type_Aqft);
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
 * Qualified Name:     aqga
 * JD-Core Version:    0.7.0.1
 */