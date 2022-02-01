package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXGameLiveObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXGameObject";
  public HashMap<String, String> extraInfoMap = new HashMap();
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public String getExtra(String paramString1, String paramString2)
  {
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null)
    {
      paramString1 = (String)localHashMap.get(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
      return paramString2;
    }
    return null;
  }
  
  public void putExtra(String paramString1, String paramString2)
  {
    if (this.extraInfoMap == null) {
      this.extraInfoMap = new HashMap();
    }
    if (!b.b(paramString1)) {
      this.extraInfoMap.put(paramString1, paramString2);
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null) {
      paramBundle.putSerializable("_wxgame_extrainfo", localHashMap);
    }
  }
  
  public int type()
  {
    return 70;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.extraInfoMap = ((HashMap)paramBundle.getSerializable("_wxgame_extrainfo"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXGameLiveObject
 * JD-Core Version:    0.7.0.1
 */