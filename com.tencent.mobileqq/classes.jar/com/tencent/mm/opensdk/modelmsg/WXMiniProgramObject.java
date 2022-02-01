package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXMiniProgramObject
  implements WXMediaMessage.IMediaObject
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
  public int disableforward = 0;
  private HashMap<String, String> extraInfoMap = null;
  public boolean isSecretMessage = false;
  public boolean isUpdatableMessage = false;
  public int miniprogramType = 0;
  public String path;
  public String userName;
  public String webpageUrl;
  public boolean withShareTicket;
  
  public boolean checkArgs()
  {
    String str;
    if (b.b(this.webpageUrl)) {
      str = "webPageUrl is null";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", str);
      return false;
      if (b.b(this.userName))
      {
        str = "userName is null";
      }
      else
      {
        int i = this.miniprogramType;
        if ((i >= 0) && (i <= 2)) {
          return true;
        }
        str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
      }
    }
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
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    paramBundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    paramBundle.putBoolean("_wxminiprogram_isupdatablemsg", this.isUpdatableMessage);
    paramBundle.putBoolean("_wxminiprogram_issecretmsg", this.isSecretMessage);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null) {
      paramBundle.putSerializable("_wxminiprogram_extrainfo", localHashMap);
    }
  }
  
  public int type()
  {
    return 36;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    this.disableforward = paramBundle.getInt("_wxminiprogram_disableforward");
    this.isUpdatableMessage = paramBundle.getBoolean("_wxminiprogram_isupdatablemsg");
    this.isSecretMessage = paramBundle.getBoolean("_wxminiprogram_issecretmsg");
    this.extraInfoMap = ((HashMap)paramBundle.getSerializable("_wxminiprogram_extrainfo"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */