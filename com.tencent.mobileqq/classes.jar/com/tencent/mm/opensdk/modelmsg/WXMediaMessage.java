package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
  public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
  public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
  public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
  public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
  private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
  public static final int THUMB_LENGTH_LIMIT = 65536;
  public static final int TITLE_LENGTH_LIMIT = 512;
  public String description;
  public WXMediaMessage.IMediaObject mediaObject;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(WXMediaMessage.IMediaObject paramIMediaObject)
  {
    this.mediaObject = paramIMediaObject;
  }
  
  final boolean checkArgs()
  {
    Object localObject;
    if (getType() == 8)
    {
      localObject = this.thumbData;
      if ((localObject == null) || (localObject.length == 0)) {
        localObject = "checkArgs fail, thumbData should not be null when send emoji";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", (String)localObject);
      return false;
      if (d.a(getType()))
      {
        localObject = this.thumbData;
        if ((localObject == null) || (localObject.length > 131072))
        {
          localObject = "checkArgs fail, thumbData should not be null or exceed 128kb";
          continue;
        }
      }
      if (!d.a(getType()))
      {
        localObject = this.thumbData;
        if ((localObject != null) && (localObject.length > 65536))
        {
          localObject = "checkArgs fail, thumbData is invalid";
          continue;
        }
      }
      localObject = this.title;
      if ((localObject != null) && (((String)localObject).length() > 512))
      {
        localObject = "checkArgs fail, title is invalid";
      }
      else
      {
        localObject = this.description;
        if ((localObject != null) && (((String)localObject).length() > 1024))
        {
          localObject = "checkArgs fail, description is invalid";
        }
        else if (this.mediaObject == null)
        {
          localObject = "checkArgs fail, mediaObject is null";
        }
        else
        {
          localObject = this.mediaTagName;
          if ((localObject != null) && (((String)localObject).length() > 64))
          {
            localObject = "checkArgs fail, mediaTagName is too long";
          }
          else
          {
            localObject = this.messageAction;
            if ((localObject != null) && (((String)localObject).length() > 2048))
            {
              localObject = "checkArgs fail, messageAction is too long";
            }
            else
            {
              localObject = this.messageExt;
              if ((localObject == null) || (((String)localObject).length() <= 2048)) {
                break;
              }
              localObject = "checkArgs fail, messageExt is too long";
            }
          }
        }
      }
    }
    return this.mediaObject.checkArgs();
  }
  
  public final int getType()
  {
    WXMediaMessage.IMediaObject localIMediaObject = this.mediaObject;
    if (localIMediaObject == null) {
      return 0;
    }
    return localIMediaObject.type();
  }
  
  public final void setThumbImage(Bitmap paramBitmap)
  {
    try
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
      this.thumbData = ((ByteArrayOutputStream)localObject).toByteArray();
      ((ByteArrayOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      Object localObject = new StringBuilder("setThumbImage exception:");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      Log.e("MicroMsg.SDK.WXMediaMessage", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMediaMessage
 * JD-Core Version:    0.7.0.1
 */