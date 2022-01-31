import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class behk
  implements ValueCallback<Bundle>
{
  behk(behj parambehj) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("input-box-num", 0);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "onFakeLoginRecognised detect ", Integer.valueOf(i), " input box" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behk
 * JD-Core Version:    0.7.0.1
 */