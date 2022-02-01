import android.app.Activity;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

final class aueh
  implements ValueCallback<String>
{
  aueh(WeakReference paramWeakReference, String paramString, WXShareHelper paramWXShareHelper) {}
  
  public void a(String paramString)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localActivity == null) || (paramString == null)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramString.split(":");
        if ((localObject == null) || (localObject.length != 2) || (localObject[0].startsWith("http"))) {
          break;
        }
        paramString = localObject[0];
        localObject = localObject[1];
        String str = auea.h(paramString);
        i = auea.f((String)localObject);
        if (str != null) {
          bdla.b(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
        }
      } while (((!paramString.startsWith("userClick")) && (!paramString.startsWith("extraMenuEvent"))) || (!((String)localObject).equalsIgnoreCase("send_to_wx")) || (!aufd.c(localActivity, this.jdField_a_of_type_JavaLangString)));
      int i = auea.b(this.jdField_a_of_type_JavaLangString);
      paramString = BitmapFactory.decodeResource(localActivity.getResources(), i);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper.a(this.jdField_a_of_type_JavaLangString, paramString);
      return;
    } while (!paramString.startsWith("http"));
    if (auht.a().a("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386")) {}
    bdla.b(null, "dc00898", "", "", "0X800AE47", "0X800AE47", 0, 0, "", "", "", "");
    audn.a(localActivity, null, 2131697900, new auei(this, localActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aueh
 * JD-Core Version:    0.7.0.1
 */