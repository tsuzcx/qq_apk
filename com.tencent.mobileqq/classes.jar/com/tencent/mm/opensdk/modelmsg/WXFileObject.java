package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXFileObject";
  private int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String filePath;
  
  public WXFileObject()
  {
    this.fileData = null;
    this.filePath = null;
  }
  
  public WXFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  public WXFileObject(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    return d.getFileSize(paramString);
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.fileData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.fileData;
      if ((localObject != null) && (localObject.length > this.contentLengthLimit)) {
        localObject = "checkArgs fail, fileData is too large";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXFileObject", (String)localObject);
      return false;
      localObject = this.filePath;
      if ((localObject != null) && (getFileSize((String)localObject) > this.contentLengthLimit))
      {
        localObject = "checkArgs fail, fileSize is too large";
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
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
  }
  
  public void setContentLengthLimit(int paramInt)
  {
    this.contentLengthLimit = paramInt;
  }
  
  public void setFileData(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public int type()
  {
    return 6;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXFileObject
 * JD-Core Version:    0.7.0.1
 */