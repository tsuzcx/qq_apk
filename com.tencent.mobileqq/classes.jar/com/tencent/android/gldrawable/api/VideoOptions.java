package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/VideoOptions;", "Lcom/tencent/android/gldrawable/api/GLDrawableOptions;", "()V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLoop", "", "()Z", "setLoop", "(Z)V", "needThumbnail", "getNeedThumbnail", "setNeedThumbnail", "videoType", "", "getVideoType", "()I", "setVideoType", "(I)V", "toBundle", "Landroid/os/Bundle;", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public final class VideoOptions
  implements GLDrawableOptions
{
  public static final VideoOptions.Companion Companion = new VideoOptions.Companion(null);
  @NotNull
  public static final String NAME = "VideoDrawable";
  public static final int TYPE_ALPHA = 1;
  public static final int TYPE_ALPHA2 = 2;
  public static final int TYPE_NORMAL = 0;
  @NotNull
  private String filePath = "";
  private boolean isLoop = true;
  private boolean needThumbnail = true;
  private int videoType;
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final boolean getNeedThumbnail()
  {
    return this.needThumbnail;
  }
  
  public final int getVideoType()
  {
    return this.videoType;
  }
  
  public final boolean isLoop()
  {
    return this.isLoop;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    this.isLoop = paramBoolean;
  }
  
  public final void setNeedThumbnail(boolean paramBoolean)
  {
    this.needThumbnail = paramBoolean;
  }
  
  public final void setVideoType(int paramInt)
  {
    this.videoType = paramInt;
  }
  
  @NotNull
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type_flag", "VideoDrawable");
    localBundle.putString("filePath", this.filePath);
    localBundle.putBoolean("needThumbnail", this.needThumbnail);
    localBundle.putInt("videoType", this.videoType);
    localBundle.putBoolean("isLoop", this.isLoop);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.VideoOptions
 * JD-Core Version:    0.7.0.1
 */