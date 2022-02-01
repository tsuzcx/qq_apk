package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject()
  {
    this.emojiData = null;
    this.emojiPath = null;
  }
  
  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    return d.getFileSize(paramString);
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.emojiData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.emojiPath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.emojiData;
      if ((localObject != null) && (localObject.length > 10485760)) {
        localObject = "checkArgs fail, emojiData is too large";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", (String)localObject);
      return false;
      localObject = this.emojiPath;
      if ((localObject != null) && (getFileSize((String)localObject) > 10485760))
      {
        localObject = "checkArgs fail, emojiSize is too large";
      }
      else
      {
        return true;
        localObject = "checkArgs fail, both arguments is null";
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }
  
  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public int type()
  {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEmojiObject
 * JD-Core Version:    0.7.0.1
 */