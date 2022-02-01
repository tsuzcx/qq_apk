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

final class bgtj
  extends bhhe
{
  bgtj(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    parambhhf = new File(bgti.jdField_a_of_type_JavaLangString);
    if (parambhhf.exists())
    {
      parambhhf = bgmg.a(parambhhf, -1);
      if (!TextUtils.isEmpty(parambhhf)) {}
      try
      {
        parambhhf = Base64.decode(parambhhf, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambhhf = new JSONObject(new String(localCipher.doFinal(parambhhf)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambhhf.toString());
        }
        bgti.a(this.a);
        bgti.jdField_a_of_type_AndroidOsHandler.sendMessage(bgti.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambhhf)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambhhf.getMessage());
        bgti.jdField_a_of_type_AndroidOsHandler.sendMessage(bgti.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bgti.jdField_a_of_type_AndroidOsHandler.sendMessage(bgti.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtj
 * JD-Core Version:    0.7.0.1
 */