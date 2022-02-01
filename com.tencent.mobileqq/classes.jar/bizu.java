import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bizu
  extends BaseJsPlugin
{
  private int jdField_a_of_type_Int;
  private zon jdField_a_of_type_Zon;
  final zop jdField_a_of_type_Zop = new bizv(this);
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveJsPlugin | preload()");
    }
    if (this.jdField_a_of_type_Zon == null)
    {
      this.jdField_a_of_type_Zon = zon.a();
      this.jdField_a_of_type_Zon.a();
      this.jdField_a_of_type_Zon.g(this.jdField_a_of_type_Zop);
    }
    this.jdField_a_of_type_Zon.g();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveJsPlugin", 2, "NowLiveNativePlugin | onDestroy()");
    }
    if (this.jdField_a_of_type_Zon != null) {
      this.jdField_a_of_type_Zon.h();
    }
  }
  
  @JsEvent({"nowlive"})
  public void onInvoke(RequestEvent paramRequestEvent)
  {
    if ((paramRequestEvent == null) || (TextUtils.isEmpty(paramRequestEvent.jsonParams))) {
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "onInvoke(): request event  is null.");
      }
    }
    label105:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
            String str = paramRequestEvent.optString("api_name");
            if (TextUtils.equals("nowlive", str)) {
              break label105;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("NowLiveJsPlugin", 2, "onInvoke() the api name: " + str);
              return;
            }
          }
          catch (Exception paramRequestEvent) {}
        }
      } while (!QLog.isColorLevel());
      QLog.w("NowLiveJsPlugin", 2, "decode param error");
      return;
      paramRequestEvent = new JSONObject(paramRequestEvent.getString("data")).getString("action");
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "onInvoke()" + paramRequestEvent);
      }
    } while (!TextUtils.equals(paramRequestEvent, "preload"));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizu
 * JD-Core Version:    0.7.0.1
 */