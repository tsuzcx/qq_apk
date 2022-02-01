package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public class WXMediaMessage$Builder
{
  public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
  
  public static WXMediaMessage fromBundle(Bundle paramBundle)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.sdkVer = paramBundle.getInt("_wxobject_sdkVer");
    localWXMediaMessage.title = paramBundle.getString("_wxobject_title");
    localWXMediaMessage.description = paramBundle.getString("_wxobject_description");
    localWXMediaMessage.thumbData = paramBundle.getByteArray("_wxobject_thumbdata");
    localWXMediaMessage.mediaTagName = paramBundle.getString("_wxobject_mediatagname");
    localWXMediaMessage.messageAction = paramBundle.getString("_wxobject_message_action");
    localWXMediaMessage.messageExt = paramBundle.getString("_wxobject_message_ext");
    String str = pathOldToNew(paramBundle.getString("_wxobject_identifier_"));
    if (str != null)
    {
      if (str.length() <= 0) {
        return localWXMediaMessage;
      }
      try
      {
        localObject = (WXMediaMessage.IMediaObject)Class.forName(str).newInstance();
        localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
        ((WXMediaMessage.IMediaObject)localObject).unserialize(paramBundle);
        return localWXMediaMessage;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get media object from bundle failed: unknown ident ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", ex = ");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        Log.e("MicroMsg.SDK.WXMediaMessage", ((StringBuilder)localObject).toString());
      }
    }
    return localWXMediaMessage;
  }
  
  private static String pathNewToOld(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return paramString.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
    }
    Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
    return paramString;
  }
  
  private static String pathOldToNew(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pathOldToNew, oldPath = ");
    localStringBuilder.append(paramString);
    Log.i("MicroMsg.SDK.WXMediaMessage", localStringBuilder.toString());
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pathOldToNew fail, invalid pos, oldPath = ");
        localStringBuilder.append(paramString);
        Log.e("MicroMsg.SDK.WXMediaMessage", localStringBuilder.toString());
        return paramString;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.tencent.mm.opensdk.modelmsg");
      localStringBuilder.append(paramString.substring(i));
      return localStringBuilder.toString();
    }
    Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
    return paramString;
  }
  
  public static Bundle toBundle(WXMediaMessage paramWXMediaMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_wxobject_sdkVer", paramWXMediaMessage.sdkVer);
    localBundle.putString("_wxobject_title", paramWXMediaMessage.title);
    localBundle.putString("_wxobject_description", paramWXMediaMessage.description);
    localBundle.putByteArray("_wxobject_thumbdata", paramWXMediaMessage.thumbData);
    WXMediaMessage.IMediaObject localIMediaObject = paramWXMediaMessage.mediaObject;
    if (localIMediaObject != null)
    {
      localBundle.putString("_wxobject_identifier_", pathNewToOld(localIMediaObject.getClass().getName()));
      paramWXMediaMessage.mediaObject.serialize(localBundle);
    }
    localBundle.putString("_wxobject_mediatagname", paramWXMediaMessage.mediaTagName);
    localBundle.putString("_wxobject_message_action", paramWXMediaMessage.messageAction);
    localBundle.putString("_wxobject_message_ext", paramWXMediaMessage.messageExt);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder
 * JD-Core Version:    0.7.0.1
 */