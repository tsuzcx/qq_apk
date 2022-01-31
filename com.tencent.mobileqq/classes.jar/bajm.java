import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

final class bajm
  extends batl
{
  bajm(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    parambatm = new File(bajl.jdField_a_of_type_JavaLangString);
    if (parambatm.exists())
    {
      parambatm = bace.a(parambatm, -1);
      if (!TextUtils.isEmpty(parambatm)) {}
      try
      {
        parambatm = Base64.decode(parambatm, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambatm = new JSONObject(new String(localCipher.doFinal(parambatm)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambatm.toString());
        }
        bajl.a(this.a);
        bajl.jdField_a_of_type_AndroidOsHandler.sendMessage(bajl.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambatm)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambatm.getMessage());
        bajl.jdField_a_of_type_AndroidOsHandler.sendMessage(bajl.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bajl.jdField_a_of_type_AndroidOsHandler.sendMessage(bajl.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajm
 * JD-Core Version:    0.7.0.1
 */