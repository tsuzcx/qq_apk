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

final class bdok
  extends bead
{
  bdok(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    parambeae = new File(bdoj.jdField_a_of_type_JavaLangString);
    if (parambeae.exists())
    {
      parambeae = bdhb.a(parambeae, -1);
      if (!TextUtils.isEmpty(parambeae)) {}
      try
      {
        parambeae = Base64.decode(parambeae, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambeae = new JSONObject(new String(localCipher.doFinal(parambeae)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambeae.toString());
        }
        bdoj.a(this.a);
        bdoj.jdField_a_of_type_AndroidOsHandler.sendMessage(bdoj.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambeae)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambeae.getMessage());
        bdoj.jdField_a_of_type_AndroidOsHandler.sendMessage(bdoj.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bdoj.jdField_a_of_type_AndroidOsHandler.sendMessage(bdoj.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdok
 * JD-Core Version:    0.7.0.1
 */