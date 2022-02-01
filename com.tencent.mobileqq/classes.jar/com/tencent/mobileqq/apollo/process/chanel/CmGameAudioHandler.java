package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.process.audio.CmGameAudioPlayer;
import org.json.JSONObject;

public class CmGameAudioHandler
  implements CmGameNativeMethodHandler.NativeObject
{
  private int a;
  
  public CmGameAudioHandler()
  {
    int i = CmGameNativeMethodHandler.a;
    CmGameNativeMethodHandler.a = i + 1;
    this.a = i;
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject a(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new CmGameAudioPlayer(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramCmGameNativeMethodHandler != null) {
        paramCmGameNativeMethodHandler.a(paramJSONObject);
      }
    }
    return null;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAudioHandler
 * JD-Core Version:    0.7.0.1
 */