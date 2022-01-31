import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.1;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class bbym
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bbyn> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private final String b = "a4d7xwsbelhregistercard";
  private final String c = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  
  public bbym(String paramString, bbyn parambbyn)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbyn);
  }
  
  private bbyh a()
  {
    try
    {
      Object localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = a().newCall((Request)localObject).execute();
      int i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = ((Response)localObject).body().string();
        if (QLog.isColorLevel()) {
          QLog.i("CheckRegisterLiangHao", 2, "json " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12196");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("data");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject("mOut");
            if (localObject != null) {
              return new bbyh((JSONObject)localObject);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("CheckRegisterLiangHao", 2, "sendRequest errorCode" + i);
        }
        localObject = new bbyh();
        ((bbyh)localObject).a = i;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CheckRegisterLiangHao", 2, localThrowable.toString());
      }
    }
    return null;
  }
  
  private OkHttpClient a()
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setConnectTimeout(5L, TimeUnit.SECONDS);
    localOkHttpClient.setReadTimeout(5L, TimeUnit.SECONDS);
    return localOkHttpClient;
  }
  
  private String a()
  {
    return "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=" + System.currentTimeMillis() + "&data=" + a();
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", this.jdField_a_of_type_JavaLangString);
      localJSONObject3.put("sign", b());
      localJSONObject2.put("mIn", localJSONObject3);
      localJSONObject1.put("12196", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private void a(bbyh parambbyh)
  {
    Object localObject2;
    Object localObject1;
    long l1;
    long l2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onResponse ");
      if (parambbyh == null)
      {
        localObject1 = "";
        QLog.i("CheckRegisterLiangHao", 2, (String)localObject1);
      }
    }
    else
    {
      l1 = SystemClock.elapsedRealtime();
      l2 = this.jdField_a_of_type_Long;
      if (parambbyh == null) {
        break label146;
      }
      i = parambbyh.a;
      label63:
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(i));
      localObject2 = axrl.a(BaseApplicationImpl.getApplication());
      if (i != 0) {
        break label153;
      }
    }
    label146:
    label153:
    for (boolean bool = true;; bool = false)
    {
      ((axrl)localObject2).a(null, "reg_lh_check_uin", bool, l1 - l2, 0L, (HashMap)localObject1, "", true);
      localObject1 = (bbyn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        break label159;
      }
      return;
      localObject1 = parambbyh.toString();
      break;
      i = -30009;
      break label63;
    }
    label159:
    ThreadManagerV2.getUIHandlerV2().post(new CheckRegisterLiangHao.2(this, (bbyn)localObject1, parambbyh));
  }
  
  private String b()
  {
    return MD5.toMD5("uin=" + this.jdField_a_of_type_JavaLangString + "&key=" + "a4d7xwsbelhregistercard").toUpperCase();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new CheckRegisterLiangHao.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbym
 * JD-Core Version:    0.7.0.1
 */