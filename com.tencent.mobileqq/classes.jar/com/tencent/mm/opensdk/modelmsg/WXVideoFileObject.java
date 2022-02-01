package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXVideoFileObject
  implements WXMediaMessage.IMediaObject
{
  public static final int FILE_SIZE_LIMIT = 1073741824;
  private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
  public static final int WXVideoFileShareSceneCommon = 0;
  public static final int WXVideoFileShareSceneFromWX = 1;
  public String filePath;
  public int shareScene = 0;
  public String shareTicket;
  
  public WXVideoFileObject()
  {
    this.filePath = null;
  }
  
  public WXVideoFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  private int getFileSize(String paramString)
  {
    return b.a(paramString);
  }
  
  public boolean checkArgs()
  {
    String str = this.filePath;
    if ((str != null) && (str.length() != 0)) {
      if (getFileSize(this.filePath) <= 1073741824) {}
    }
    for (str = "checkArgs fail, video file size is too large";; str = "checkArgs fail, filePath is null")
    {
      Log.e("MicroMsg.SDK.WXVideoFileObject", str);
      return false;
      return true;
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxvideofileobject_filePath", this.filePath);
    paramBundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
    paramBundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
  }
  
  public int type()
  {
    return 38;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.filePath = paramBundle.getString("_wxvideofileobject_filePath");
    this.shareScene = paramBundle.getInt("_wxvideofileobject_shareScene", 0);
    this.shareTicket = paramBundle.getString("_wxvideofileobject_shareTicketh");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXVideoFileObject
 * JD-Core Version:    0.7.0.1
 */