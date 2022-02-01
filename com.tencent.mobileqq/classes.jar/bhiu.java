import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

final class bhiu
  extends bhyn
{
  bhiu(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    parambhyo = new File(bhit.jdField_a_of_type_JavaLangString);
    if (parambhyo.exists())
    {
      parambhyo = FileUtils.readFileToStringEx(parambhyo, -1);
      if (!TextUtils.isEmpty(parambhyo)) {}
      try
      {
        parambhyo = Base64.decode(parambhyo, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambhyo = new JSONObject(new String(localCipher.doFinal(parambhyo)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambhyo.toString());
        }
        bhit.a(this.a);
        bhit.jdField_a_of_type_AndroidOsHandler.sendMessage(bhit.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambhyo)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambhyo.getMessage());
        bhit.jdField_a_of_type_AndroidOsHandler.sendMessage(bhit.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bhit.jdField_a_of_type_AndroidOsHandler.sendMessage(bhit.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhiu
 * JD-Core Version:    0.7.0.1
 */