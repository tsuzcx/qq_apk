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

final class bbkt
  extends bbwf
{
  bbkt(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    parambbwg = new File(bbks.jdField_a_of_type_JavaLangString);
    if (parambbwg.exists())
    {
      parambbwg = bbdj.a(parambbwg, -1);
      if (!TextUtils.isEmpty(parambbwg)) {}
      try
      {
        parambbwg = Base64.decode(parambbwg, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambbwg = new JSONObject(new String(localCipher.doFinal(parambbwg)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambbwg.toString());
        }
        bbks.a(this.a);
        bbks.jdField_a_of_type_AndroidOsHandler.sendMessage(bbks.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambbwg)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambbwg.getMessage());
        bbks.jdField_a_of_type_AndroidOsHandler.sendMessage(bbks.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bbks.jdField_a_of_type_AndroidOsHandler.sendMessage(bbks.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkt
 * JD-Core Version:    0.7.0.1
 */