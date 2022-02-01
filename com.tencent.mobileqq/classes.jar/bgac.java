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

final class bgac
  extends bgod
{
  bgac(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    parambgoe = new File(bgab.jdField_a_of_type_JavaLangString);
    if (parambgoe.exists())
    {
      parambgoe = FileUtils.readFileToStringEx(parambgoe, -1);
      if (!TextUtils.isEmpty(parambgoe)) {}
      try
      {
        parambgoe = Base64.decode(parambgoe, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambgoe = new JSONObject(new String(localCipher.doFinal(parambgoe)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambgoe.toString());
        }
        bgab.a(this.a);
        bgab.jdField_a_of_type_AndroidOsHandler.sendMessage(bgab.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambgoe)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambgoe.getMessage());
        bgab.jdField_a_of_type_AndroidOsHandler.sendMessage(bgab.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bgab.jdField_a_of_type_AndroidOsHandler.sendMessage(bgab.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgac
 * JD-Core Version:    0.7.0.1
 */