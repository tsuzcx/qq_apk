import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class apmm
  extends mmn
{
  apmm(apmf paramapmf, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      apmt.a("KEY_STAGE_2_NORMAL_B77", bool);
      if (QLog.isColorLevel()) {
        QLog.i("ForwardShareByServerHelper", 2, "onResult errorCode=" + paramInt + ", isTimeOut=" + apmf.a(this.jdField_a_of_type_Apmf) + ", isFirstShow =" + apmf.b(this.jdField_a_of_type_Apmf));
      }
      if (apmf.b(this.jdField_a_of_type_Apmf)) {
        break label92;
      }
    }
    label92:
    long l;
    label140:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (!apmf.a(this.jdField_a_of_type_Apmf)) {
          break label140;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState isTimeOut =" + apmf.a(this.jdField_a_of_type_Apmf));
      return;
      if (paramBundle == null) {
        break label224;
      }
      l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardShareByServerHelper", 2, "handleGetMessageState currentRequestTime =" + apmf.b(this.jdField_a_of_type_Apmf) + ", sendStamp = " + l);
      }
    } while ((l == -1L) || (l != apmf.b(this.jdField_a_of_type_Apmf)));
    label224:
    apmf.a(this.jdField_a_of_type_Apmf, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    apmf.a(this.jdField_a_of_type_Apmf).removeMessages(94);
    this.jdField_a_of_type_Apmf.c();
    paramBundle = apmf.a(this.jdField_a_of_type_Apmf);
    String str4 = ForwardUtils.c(apmf.a(this.jdField_a_of_type_Apmf).getInt("req_type"));
    String str5 = ForwardUtils.a(apmf.a(this.jdField_a_of_type_Apmf).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      awqx.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      apmf.a(this.jdField_a_of_type_Apmf, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      apmf.b(this.jdField_a_of_type_Apmf, str1);
    }
    for (;;)
    {
      apmf.c(this.jdField_a_of_type_Apmf, this.jdField_a_of_type_AndroidOsBundle.getString("share_comment_message_for_server"));
      return;
      apmf.a(this.jdField_a_of_type_Apmf);
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
 * Qualified Name:     apmm
 * JD-Core Version:    0.7.0.1
 */