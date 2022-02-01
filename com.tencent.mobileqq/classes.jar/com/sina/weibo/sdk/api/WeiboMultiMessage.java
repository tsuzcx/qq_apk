package com.sina.weibo.sdk.api;

import android.os.Bundle;
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
    if (this.mediaObject != null)
    {
      paramBundle.putParcelable("_weibo_message_media", this.mediaObject);
      if (this.textObject == null) {
        break label97;
      }
      paramBundle.putParcelable("_weibo_message_text", this.textObject);
      label34:
      if (this.imageObject == null) {
        break label107;
      }
      paramBundle.putParcelable("_weibo_message_image", this.imageObject);
      label51:
      if (this.multiImageObject == null) {
        break label117;
      }
      paramBundle.putParcelable("_weibo_message_multi_image", this.multiImageObject);
    }
    for (;;)
    {
      if (this.videoSourceObject == null) {
        break label127;
      }
      paramBundle.putParcelable("_weibo_message_video_source", this.videoSourceObject);
      return paramBundle;
      paramBundle.putParcelable("_weibo_message_media", null);
      break;
      label97:
      paramBundle.putParcelable("_weibo_message_text", null);
      break label34;
      label107:
      paramBundle.putParcelable("_weibo_message_image", null);
      break label51;
      label117:
      paramBundle.putParcelable("_weibo_message_multi_image", null);
    }
    label127:
    paramBundle.putParcelable("_weibo_message_video_source", null);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.WeiboMultiMessage
 * JD-Core Version:    0.7.0.1
 */