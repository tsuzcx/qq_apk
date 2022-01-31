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

final class bdkb
  extends bdvu
{
  bdkb(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    parambdvv = new File(bdka.jdField_a_of_type_JavaLangString);
    if (parambdvv.exists())
    {
      parambdvv = bdcs.a(parambdvv, -1);
      if (!TextUtils.isEmpty(parambdvv)) {}
      try
      {
        parambdvv = Base64.decode(parambdvv, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambdvv = new JSONObject(new String(localCipher.doFinal(parambdvv)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambdvv.toString());
        }
        bdka.a(this.a);
        bdka.jdField_a_of_type_AndroidOsHandler.sendMessage(bdka.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambdvv)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambdvv.getMessage());
        bdka.jdField_a_of_type_AndroidOsHandler.sendMessage(bdka.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bdka.jdField_a_of_type_AndroidOsHandler.sendMessage(bdka.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkb
 * JD-Core Version:    0.7.0.1
 */