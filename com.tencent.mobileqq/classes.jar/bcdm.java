import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class bcdm
  implements ValueCallback<Bundle>
{
  bcdm(bcdl parambcdl) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("input-box-num", 0);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "onFakeLoginRecognised detect ", Integer.valueOf(i), " input box" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdm
 * JD-Core Version:    0.7.0.1
 */