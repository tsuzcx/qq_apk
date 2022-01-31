import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class asea
  extends nac
{
  asea(asdt paramasdt, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aseh.a("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMesssage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(asdt.a(this.jdField_a_of_type_Asdt)), ", isFirstShow =", Boolean.valueOf(asdt.b(this.jdField_a_of_type_Asdt)) });
      if (asdt.b(this.jdField_a_of_type_Asdt)) {
        break;
      }
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isFirstShow =" + asdt.b(this.jdField_a_of_type_Asdt));
      return;
    }
    if (asdt.a(this.jdField_a_of_type_Asdt))
    {
      QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for isTimeOut =" + asdt.a(this.jdField_a_of_type_Asdt));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState currentRequestTime =" + asdt.b(this.jdField_a_of_type_Asdt) + ", sendStamp = " + l);
      if ((l == -1L) || (l != asdt.b(this.jdField_a_of_type_Asdt)))
      {
        QLog.d("ForwardShareByServerHelper", 1, "handleGetMessageState return for sendStamp");
        return;
      }
    }
    asdt.a(this.jdField_a_of_type_Asdt, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    asdt.a(this.jdField_a_of_type_Asdt).removeMessages(94);
    this.jdField_a_of_type_Asdt.c();
    paramBundle = asdt.a(this.jdField_a_of_type_Asdt);
    String str4 = ForwardUtils.c(asdt.a(this.jdField_a_of_type_Asdt).getInt("req_type"));
    String str5 = ForwardUtils.a(asdt.a(this.jdField_a_of_type_Asdt).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      azqs.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      asdt.a(this.jdField_a_of_type_Asdt, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      asdt.b(this.jdField_a_of_type_Asdt, str1);
    }
    for (;;)
    {
      asdt.c(this.jdField_a_of_type_Asdt, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      asdt.a(this.jdField_a_of_type_Asdt);
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
 * Qualified Name:     asea
 * JD-Core Version:    0.7.0.1
 */