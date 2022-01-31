import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class aqfj
  extends mxj
{
  aqfj(aqfd paramaqfd, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      aqgj.a("KEY_STAGE_2_IMAGE_B77", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "handleGetMessageState currentRequestTime =", Long.valueOf(aqfd.a(this.jdField_a_of_type_Aqfd)), ", sendStamp = ", Long.valueOf(l) });
      if ((l != -1L) && (l == aqfd.a(this.jdField_a_of_type_Aqfd))) {
        break;
      }
      aqfd.a(this.jdField_a_of_type_Aqfd, aqfd.e(), this.jdField_a_of_type_JavaLangString);
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, "4", this.b, this.c);
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "大图发送消息后客户端收到回调=0X8009C94, errorCode=", Integer.valueOf(paramInt), ", fileType=4, toType=", this.b, ", title=", this.c });
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
      aqfd.a(this.jdField_a_of_type_Aqfd, (String)paramArrayOfByte[2], this.jdField_a_of_type_JavaLangString);
      return;
    }
    aqfd.a(this.jdField_a_of_type_Aqfd, "", this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfj
 * JD-Core Version:    0.7.0.1
 */