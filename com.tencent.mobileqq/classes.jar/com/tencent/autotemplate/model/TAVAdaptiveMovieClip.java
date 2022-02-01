package com.tencent.autotemplate.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVMovieResourceStatus;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVResourceType;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TAVAdaptiveMovieClip
{
  private transient float duration;
  private transient String fileDir;
  @SerializedName("filePath")
  private String fileName;
  @SerializedName("startOffset")
  private float startOffset = 0.0F;
  @SerializedName("volume")
  private float volume = 1.0F;
  @SerializedName("volumeEffects")
  private List<TAVVolumeAutomaticEffect> volumeEffects = new ArrayList();
  
  private TAVMovieTrackResource convertToMovieTrackResource()
  {
    Object localObject = getFullPath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new TAVMovieTrackResource((String)localObject);
    ((TAVMovieTrackResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
    float f2 = ((TAVMovieTrackResource)localObject).getTimeRange().getDuration().getTimeSeconds() * 1000.0F;
    float f3 = this.startOffset;
    float f1 = this.duration;
    if (f2 - f3 < f1) {
      f1 = f2 - f3;
    }
    ((TAVMovieTrackResource)localObject).setTimeRange(new CMTimeRange(new CMTime(this.startOffset / 1000.0F), new CMTime(f1 / 1000.0F)));
    return localObject;
  }
  
  private String getFullPath()
  {
    if ((!TextUtils.isEmpty(this.fileName)) && (new File(this.fileName).exists())) {
      return this.fileName;
    }
    if ((!TextUtils.isEmpty(this.fileDir)) && (!TextUtils.isEmpty(this.fileName)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.fileDir);
      localStringBuilder.append("/");
      localStringBuilder.append(this.fileName);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public TAVMovieClip convertToMovieClip()
  {
    TAVMovieClip localTAVMovieClip = new TAVMovieClip();
    localTAVMovieClip.setResource(convertToMovieTrackResource());
    if (localTAVMovieClip.getResource() != null)
    {
      if (localTAVMovieClip.getResource().getStatus() == TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError) {
        return null;
      }
      localTAVMovieClip.getAudioConfiguration().setVolume(this.volume);
      if (!localTAVMovieClip.getResource().getTimeRange().isLegal()) {
        return null;
      }
      return localTAVMovieClip;
    }
    return null;
  }
  
  public float getDuration()
  {
    return this.duration;
  }
  
  public String getFileDir()
  {
    return this.fileDir;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public float getStartOffset()
  {
    return this.startOffset;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public List<TAVVolumeAutomaticEffect> getVolumeEffects()
  {
    return this.volumeEffects;
  }
  
  public void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }
  
  public void setFileDir(String paramString)
  {
    this.fileDir = paramString;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setStartOffset(float paramFloat)
  {
    this.startOffset = paramFloat;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public void setVolumeEffects(List<TAVVolumeAutomaticEffect> paramList)
  {
    this.volumeEffects = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVAdaptiveMovieClip
 * JD-Core Version:    0.7.0.1
 */