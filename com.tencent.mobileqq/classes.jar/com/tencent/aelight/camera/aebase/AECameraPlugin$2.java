package com.tencent.aelight.camera.aebase;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class AECameraPlugin$2
  implements Runnable
{
  AECameraPlugin$2(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      localJSONObject = AECameraPlugin.a(this.this$0, this.a, 0);
      this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      JSONObject localJSONObject;
      break label102;
    }
    catch (JSONException localJSONException)
    {
      break label69;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label36:
      label69:
      label102:
      break label36;
    }
    localJSONObject = AECameraPlugin.a(this.this$0, "out of memory");
    this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
    return;
    localJSONObject = AECameraPlugin.a(this.this$0, "json exception");
    this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
    return;
    localJSONObject = AECameraPlugin.a(this.this$0, "io exception");
    this.this$0.callJs(this.b, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin.2
 * JD-Core Version:    0.7.0.1
 */