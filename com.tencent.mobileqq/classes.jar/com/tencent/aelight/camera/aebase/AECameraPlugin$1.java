package com.tencent.aelight.camera.aebase;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class AECameraPlugin$1
  implements Runnable
{
  AECameraPlugin$1(AECameraPlugin paramAECameraPlugin, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      localJSONObject = AECameraPlugin.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b);
      this.this$0.callJs(AECameraPlugin.a(this.this$0), new String[] { localJSONObject.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      JSONObject localJSONObject;
      AECameraPlugin localAECameraPlugin;
      break label116;
    }
    catch (JSONException localJSONException)
    {
      break label81;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label46:
      label81:
      label116:
      break label46;
    }
    localJSONObject = AECameraPlugin.a(this.this$0, "out of memory");
    localAECameraPlugin = this.this$0;
    localAECameraPlugin.callJs(AECameraPlugin.a(localAECameraPlugin), new String[] { localJSONObject.toString() });
    return;
    localJSONObject = AECameraPlugin.a(this.this$0, "json exception");
    localAECameraPlugin = this.this$0;
    localAECameraPlugin.callJs(AECameraPlugin.a(localAECameraPlugin), new String[] { localJSONObject.toString() });
    return;
    localJSONObject = AECameraPlugin.a(this.this$0, "io exception");
    localAECameraPlugin = this.this$0;
    localAECameraPlugin.callJs(AECameraPlugin.a(localAECameraPlugin), new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.1
 * JD-Core Version:    0.7.0.1
 */