package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 26214400;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  public byte[] imageData;
  public String imagePath;
  
  public WXImageObject() {}
  
  public WXImageObject(Bitmap paramBitmap)
  {
    try
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
      this.imageData = ((ByteArrayOutputStream)localObject).toByteArray();
      ((ByteArrayOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WXImageObject <init>, exception:");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      Log.e("MicroMsg.SDK.WXImageObject", ((StringBuilder)localObject).toString());
    }
  }
  
  public WXImageObject(byte[] paramArrayOfByte)
  {
    this.imageData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    return b.a(paramString);
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.imageData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.imagePath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.imageData;
      if ((localObject != null) && (localObject.length > 26214400)) {
        localObject = "checkArgs fail, content is too large";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXImageObject", (String)localObject);
      return false;
      localObject = this.imagePath;
      if ((localObject != null) && (((String)localObject).length() > 10240))
      {
        localObject = "checkArgs fail, path is invalid";
      }
      else
      {
        localObject = this.imagePath;
        if ((localObject != null) && (getFileSize((String)localObject) > 26214400))
        {
          localObject = "checkArgs fail, image content is too large";
        }
        else
        {
          return true;
          localObject = "checkArgs fail, all arguments are null";
        }
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXImageObject
 * JD-Core Version:    0.7.0.1
 */