import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.observer.WtloginObserver;

class bavb
  extends WtloginObserver
{
  final Intent jdField_a_of_type_AndroidContentIntent;
  final bavc jdField_a_of_type_Bavc;
  final String jdField_a_of_type_JavaLangString;
  
  bavb(Intent paramIntent, String paramString, bavc parambavc)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bavc = parambavc;
  }
  
  public void OnRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentIntent);
    if (paramArrayOfByte3 != null) {}
    label295:
    label310:
    label323:
    label329:
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        if (QLog.isDevelopLevel()) {
          QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig ret: %s, uin: %s, error: %s, contactssig: %s, lhsig: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte1, MD5.toMD5(paramArrayOfByte2), MD5.toMD5(paramArrayOfByte4) }));
        }
        if (paramInt != 0) {
          break label323;
        }
        bool = true;
        paramArrayOfByte3 = String.valueOf(paramLong);
        if ((!TextUtils.isEmpty(paramArrayOfByte3)) && (paramArrayOfByte3.equals(this.jdField_a_of_type_JavaLangString))) {
          break label295;
        }
        bool = false;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
          break label310;
        }
        bool = false;
        if (!TextUtils.isEmpty(paramArrayOfByte1)) {
          break label329;
        }
        paramArrayOfByte1 = BaseApplicationImpl.getContext().getString(2131651340);
        localIntent.putExtra("key_register_prompt_info", paramArrayOfByte1);
        if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
          localIntent.putExtra("key_register_lhsig", paramArrayOfByte4);
        }
        if (QLog.isDevelopLevel()) {
          bavd.a("LHLoginMng -- OnRegGetSMSVerifyLoginAccountWithLhSig", localIntent);
        }
        if (this.jdField_a_of_type_Bavc != null) {
          this.jdField_a_of_type_Bavc.a(localIntent, bool, this.jdField_a_of_type_JavaLangString, paramArrayOfByte4, paramArrayOfByte1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig, lhUin: %s, isSuc: %s, error: %s, ret: %s", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool), paramArrayOfByte1, Integer.valueOf(paramInt) }));
        }
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
      continue;
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      continue;
      localIntent.putExtra("key_register_sign", paramArrayOfByte2);
      continue;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavb
 * JD-Core Version:    0.7.0.1
 */