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

final class bhtm
  extends biht
{
  bhtm(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    parambihu = new File(bhtl.jdField_a_of_type_JavaLangString);
    if (parambihu.exists())
    {
      parambihu = bhmi.a(parambihu, -1);
      if (!TextUtils.isEmpty(parambihu)) {}
      try
      {
        parambihu = Base64.decode(parambihu, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambihu = new JSONObject(new String(localCipher.doFinal(parambihu)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambihu.toString());
        }
        bhtl.a(this.a);
        bhtl.jdField_a_of_type_AndroidOsHandler.sendMessage(bhtl.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambihu)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambihu.getMessage());
        bhtl.jdField_a_of_type_AndroidOsHandler.sendMessage(bhtl.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bhtl.jdField_a_of_type_AndroidOsHandler.sendMessage(bhtl.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtm
 * JD-Core Version:    0.7.0.1
 */