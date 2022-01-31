package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXGameVideoFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final int FILE_SIZE_LIMIT = 104857600;
  private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String filePath;
  public String thumbUrl;
  public String videoUrl;
  
  public WXGameVideoFileObject()
  {
    this.filePath = null;
    this.videoUrl = null;
    this.thumbUrl = null;
  }
  
  public WXGameVideoFileObject(String paramString1, String paramString2, String paramString3)
  {
    this.filePath = paramString1;
    this.videoUrl = paramString2;
    this.thumbUrl = paramString3;
  }
  
  private int getFileSize(String paramString)
  {
    return d.getFileSize(paramString);
  }
  
  public boolean checkArgs()
  {
    if ((this.filePath == null) || (this.filePath.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, filePath is null");
      return false;
    }
    if (getFileSize(this.filePath) > 104857600)
    {
      Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, video file size is too large");
      return false;
    }
    if ((this.videoUrl != null) && (this.videoUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, videoUrl is too long");
      return false;
    }
    if ((this.thumbUrl != null) && (this.thumbUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, thumbUrl is too long");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxvideofileobject_filePath", this.filePath);
    paramBundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
    paramBundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
  }
  
  public int type()
  {
    return 39;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.filePath = paramBundle.getString("_wxvideofileobject_filePath");
    this.videoUrl = paramBundle.getString("_wxvideofileobject_cdnUrl");
    this.thumbUrl = paramBundle.getString("_wxvideofileobject_thumbUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject
 * JD-Core Version:    0.7.0.1
 */