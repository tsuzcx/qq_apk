package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer;
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
  
  public JSONObject b(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
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
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameAudioHandler
 * JD-Core Version:    0.7.0.1
 */