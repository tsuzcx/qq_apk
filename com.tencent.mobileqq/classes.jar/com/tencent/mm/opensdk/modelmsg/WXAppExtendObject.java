package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXAppExtendObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int EXTINFO_LENGTH_LIMIT = 2048;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
  public String extInfo;
  public byte[] fileData;
  public String filePath;
  
  public WXAppExtendObject() {}
  
  public WXAppExtendObject(String paramString1, String paramString2)
  {
    this.extInfo = paramString1;
    this.filePath = paramString2;
  }
  
  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    return b.a(paramString);
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.extInfo;
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        localObject = this.fileData;
        if ((localObject == null) || (localObject.length == 0)) {
          break label153;
        }
      }
    }
    localObject = this.extInfo;
    if ((localObject != null) && (((String)localObject).length() > 2048)) {
      localObject = "checkArgs fail, extInfo is invalid";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", (String)localObject);
      return false;
      localObject = this.filePath;
      if ((localObject != null) && (((String)localObject).length() > 10240))
      {
        localObject = "checkArgs fail, filePath is invalid";
      }
      else
      {
        localObject = this.filePath;
        if ((localObject != null) && (getFileSize((String)localObject) > 10485760))
        {
          localObject = "checkArgs fail, fileSize is too large";
        }
        else
        {
          localObject = this.fileData;
          if ((localObject != null) && (localObject.length > 10485760))
          {
            localObject = "checkArgs fail, fileData is too large";
          }
          else
          {
            return true;
            label153:
            localObject = "checkArgs fail, all arguments is null";
          }
        }
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxappextendobject_extInfo", this.extInfo);
    paramBundle.putByteArray("_wxappextendobject_fileData", this.fileData);
    paramBundle.putString("_wxappextendobject_filePath", this.filePath);
  }
  
  public int type()
  {
    return 7;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.extInfo = paramBundle.getString("_wxappextendobject_extInfo");
    this.fileData = paramBundle.getByteArray("_wxappextendobject_fileData");
    this.filePath = paramBundle.getString("_wxappextendobject_filePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXAppExtendObject
 * JD-Core Version:    0.7.0.1
 */