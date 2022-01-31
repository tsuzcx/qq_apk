import android.text.TextUtils;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class anjm
  implements Runnable
{
  public anjm(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject3;
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_a_of_type_ArrayOfJavaLangString[0] != null))
    {
      localObject3 = "";
      localObject5 = "";
      localObject2 = localObject3;
      localObject1 = localObject5;
    }
    Object localObject6;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject3 = localJSONObject.getString("giftid");
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject6 = localJSONObject.getJSONObject("giftZipUrl");
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (MagicfaceResLoader.a().equals("sbig"))
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlSBig");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5SBig");
          localObject1 = localObject6;
          localObject2 = localObject5;
        }
      }
      catch (JSONException localJSONException1)
      {
        JSONObject localJSONObject;
        localObject5 = "";
      }
      try
      {
        QZoneGiftFullScreenJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin, localJSONObject.getString("callback"));
        localObject6 = localObject3;
        localObject3 = localObject2;
        localObject5 = localObject1;
        if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty(QZoneGiftFullScreenJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin)))) {
          break;
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localObject5 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          Object localObject4 = localJSONException2;
        }
      }
      localObject2 = localObject3;
      localObject1 = localObject5;
      if (MagicfaceResLoader.a().equals("xbig"))
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject5 = ((JSONObject)localObject6).getString("androidZipUrlXBig");
        localObject2 = localObject3;
        localObject1 = localObject5;
        localObject6 = ((JSONObject)localObject6).getString("androidMd5XBig");
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      else
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (MagicfaceResLoader.a().equals("small"))
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlSmall");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5Small");
          localObject2 = localObject5;
          localObject1 = localObject6;
        }
        else
        {
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject5 = ((JSONObject)localObject6).getString("androidZipUrlBig");
          localObject2 = localObject3;
          localObject1 = localObject5;
          localObject6 = ((JSONObject)localObject6).getString("androidMd5Big");
          localObject1 = localObject6;
          localObject2 = localObject5;
          continue;
          localJSONException1.printStackTrace();
          localObject4 = localObject1;
          localObject6 = localObject2;
        }
      }
    }
    RemoteHandleManager.a().a().a((String)localObject6, localObject4, (String)localObject5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjm
 * JD-Core Version:    0.7.0.1
 */