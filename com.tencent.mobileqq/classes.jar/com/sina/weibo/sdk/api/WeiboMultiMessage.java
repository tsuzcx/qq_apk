package com.sina.weibo.sdk.api;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

public class WeiboMultiMessage
  implements Serializable
{
  private static final long serialVersionUID = -3336491646257094828L;
  public ImageObject imageObject;
  public MediaObject mediaObject;
  public MultiImageObject multiImageObject;
  public TextObject textObject;
  public VideoSourceObject videoSourceObject;
  
  public void readFromBundle(Bundle paramBundle)
  {
    this.mediaObject = ((MediaObject)paramBundle.getParcelable("_weibo_message_media"));
    this.textObject = ((TextObject)paramBundle.getParcelable("_weibo_message_text"));
    this.imageObject = ((ImageObject)paramBundle.getParcelable("_weibo_message_image"));
    this.multiImageObject = ((MultiImageObject)paramBundle.getParcelable("_weibo_message_multi_image"));
    this.videoSourceObject = ((VideoSourceObject)paramBundle.getParcelable("_weibo_message_video_source"));
  }
  
  public Bundle writeToBundle(Bundle paramBundle)
  {
    Object localObject = this.mediaObject;
    if (localObject != null) {
      paramBundle.putParcelable("_weibo_message_media", (Parcelable)localObject);
    } else {
      paramBundle.putParcelable("_weibo_message_media", null);
    }
    localObject = this.textObject;
    if (localObject != null) {
      paramBundle.putParcelable("_weibo_message_text", (Parcelable)localObject);
    } else {
      paramBundle.putParcelable("_weibo_message_text", null);
    }
    localObject = this.imageObject;
    if (localObject != null) {
      paramBundle.putParcelable("_weibo_message_image", (Parcelable)localObject);
    } else {
      paramBundle.putParcelable("_weibo_message_image", null);
    }
    localObject = this.multiImageObject;
    if (localObject != null) {
      paramBundle.putParcelable("_weibo_message_multi_image", (Parcelable)localObject);
    } else {
      paramBundle.putParcelable("_weibo_message_multi_image", null);
    }
    localObject = this.videoSourceObject;
    if (localObject != null)
    {
      paramBundle.putParcelable("_weibo_message_video_source", (Parcelable)localObject);
      return paramBundle;
    }
    paramBundle.putParcelable("_weibo_message_video_source", null);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.WeiboMultiMessage
 * JD-Core Version:    0.7.0.1
 */