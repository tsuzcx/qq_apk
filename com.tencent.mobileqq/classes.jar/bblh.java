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

final class bblh
  extends bbwt
{
  bblh(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    parambbwu = new File(bblg.jdField_a_of_type_JavaLangString);
    if (parambbwu.exists())
    {
      parambbwu = bbdx.a(parambbwu, -1);
      if (!TextUtils.isEmpty(parambbwu)) {}
      try
      {
        parambbwu = Base64.decode(parambbwu, 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        parambbwu = new JSONObject(new String(localCipher.doFinal(parambbwu)));
        if (QLog.isColorLevel()) {
          QLog.d("VasResourceCheckUtil", 2, "decode json success, content = " + parambbwu.toString());
        }
        bblg.a(this.a);
        bblg.jdField_a_of_type_AndroidOsHandler.sendMessage(bblg.jdField_a_of_type_AndroidOsHandler.obtainMessage(257));
        return;
      }
      catch (Exception parambbwu)
      {
        QLog.e("VasResourceCheckUtil", 1, "decode json fail: " + parambbwu.getMessage());
        bblg.jdField_a_of_type_AndroidOsHandler.sendMessage(bblg.jdField_a_of_type_AndroidOsHandler.obtainMessage(259));
        return;
      }
    }
    bblg.jdField_a_of_type_AndroidOsHandler.sendMessage(bblg.jdField_a_of_type_AndroidOsHandler.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblh
 * JD-Core Version:    0.7.0.1
 */