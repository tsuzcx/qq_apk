import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doc.jsp.VoiceInputHelper.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public final class apjp
  implements VoiceRecognizerListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private String jdField_a_of_type_JavaLangString;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  
  public apjp(WebViewPlugin paramWebViewPlugin)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin = paramWebViewPlugin.mRuntime;
      localObject1 = localObject2;
      if (paramWebViewPlugin != null)
      {
        paramWebViewPlugin = paramWebViewPlugin.a();
        localObject1 = localObject2;
        if (paramWebViewPlugin != null) {
          localObject1 = paramWebViewPlugin.getApplicationContext();
        }
      }
    }
    this.jdField_a_of_type_AndroidContentContext = ((Context)localObject1);
    if (localObject1 == null) {
      QLog.e("VoiceInputHelper", 1, "context is invalid.");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) {}
    for (begz localbegz = null; localbegz == null; localbegz = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime) {
      return null;
    }
    return localbegz.a();
  }
  
  private AppActivity a()
  {
    Activity localActivity = a();
    if ((localActivity instanceof AppActivity)) {
      return (AppActivity)localActivity;
    }
    return null;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceInputHelper", 2, "voice input helper preInit invalid app");
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break;
        }
        new bcdk(paramAppInterface.getApplication().getApplicationContext(), "3171", "libWXVoice.so", "WXVoice").a();
      } while (!QLog.isColorLevel());
      QLog.d("VoiceInputHelper", 2, "voice input helper preInit doing");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VoiceInputHelper", 2, "voice input helper preInit app isn't QQAppInterface, app=" + paramAppInterface);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    do
    {
      return;
      localObject = ((Activity)localObject).getWindow();
    } while (localObject == null);
    if (paramBoolean)
    {
      ((Window)localObject).addFlags(128);
      return;
    }
    ((Window)localObject).clearFlags(128);
  }
  
  private void b()
  {
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new apjq(this), 1818, new String[] { "android.permission.RECORD_AUDIO" });
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new apjr(this, Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  private boolean c()
  {
    if (!bcdk.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"))
    {
      QLog.e("VoiceInputHelper", 1, "setup error, so lib not exists");
      return false;
    }
    int i = VoiceRecognizer.shareInstance().init(this.jdField_a_of_type_AndroidContentContext, "wxcd8072f67d2d78d4", bcdk.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"));
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "setup failed, ret=" + i);
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    AppActivity localAppActivity = a();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0);
  }
  
  private boolean e()
  {
    int i = VoiceRecognizer.shareInstance().start();
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "start failed, ret=" + i);
      return false;
    }
    a(true);
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    c();
    this.jdField_a_of_type_AndroidOsHandler = null;
    VoiceRecognizer.shareInstance().destroy();
    a(false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    VoiceRecognizer.shareInstance().setListener(this);
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(1);
    VoiceRecognizer.shareInstance().setSilentTime(1000);
    ThreadManager.excute(new VoiceInputHelper.1(this), 64, null, true);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("VoiceInputHelper", 1, "start failed, callback is invalid.");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (d()) {
      return e();
    }
    b();
    return false;
  }
  
  public boolean b()
  {
    int i = VoiceRecognizer.shareInstance().stop();
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "stop failed, ret=" + i);
      return false;
    }
    a(false);
    return true;
  }
  
  public void onGetError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceInputHelper", 2, "onGetError:" + paramInt);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("errorCode", paramInt);
      ((JSONObject)localObject2).put("cmd", "error");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onGetError error", localJSONException);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { localObject1 });
    }
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if (paramVoiceRecognizerResult == null) {}
    for (;;)
    {
      return;
      long l;
      String str;
      if (paramVoiceRecognizerResult.isEnd)
      {
        l = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
        str = this.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str)) {
          continue;
        }
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("text", paramVoiceRecognizerResult.text);
        localJSONObject.put("voice_id", l);
        localJSONObject.put("startOffset", paramVoiceRecognizerResult.startTime);
        localJSONObject.put("endOffset", paramVoiceRecognizerResult.stopTime);
        localJSONObject.put("cmd", "result");
        paramVoiceRecognizerResult = localJSONObject.toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (TextUtils.isEmpty(paramVoiceRecognizerResult))) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramVoiceRecognizerResult });
        return;
        l = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      }
      catch (JSONException paramVoiceRecognizerResult)
      {
        for (;;)
        {
          QLog.e("VoiceInputHelper", 1, "onGetResult error", paramVoiceRecognizerResult);
          paramVoiceRecognizerResult = "";
        }
      }
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceInputHelper", 2, "onGetVoiceRecordState:" + paramVoiceRecordState);
    }
    String str;
    if ((paramVoiceRecordState == VoiceRecordState.Canceling) || (paramVoiceRecordState == VoiceRecordState.Canceled) || (paramVoiceRecordState == VoiceRecordState.Complete))
    {
      str = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        paramVoiceRecordState = "";
      }
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "canceled");
      localObject = ((JSONObject)localObject).toString();
      paramVoiceRecordState = (VoiceRecordState)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onGetVoiceRecordState error", localJSONException);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty(paramVoiceRecordState))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramVoiceRecordState });
    }
  }
  
  public void onVolumeChanged(int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("volume", paramInt);
      ((JSONObject)localObject2).put("cmd", "volume");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onVolumeChanged error", localJSONException);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { localObject1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjp
 * JD-Core Version:    0.7.0.1
 */