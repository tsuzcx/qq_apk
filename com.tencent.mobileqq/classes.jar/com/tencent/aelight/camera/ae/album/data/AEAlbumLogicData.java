package com.tencent.aelight.camera.ae.album.data;

import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import java.io.Serializable;

public class AEAlbumLogicData
  implements OtherCommonData, Serializable
{
  public boolean canMixPhotoAndVideo;
  public boolean canPickVideo;
  public boolean canSwitchSelectionMode;
  public int initialHasPickedNum;
  public int maxSelectNumForMix;
  public int maxSelectNumForNormal;
  public int minSelectNumForMix;
  public int minSelectNumForNormal;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEAlbumLogicData{canMixPhotoAndVideo=");
    localStringBuilder.append(this.canMixPhotoAndVideo);
    localStringBuilder.append(", minSelectNumForNormal=");
    localStringBuilder.append(this.minSelectNumForNormal);
    localStringBuilder.append(", maxSelectNumForNormal=");
    localStringBuilder.append(this.maxSelectNumForNormal);
    localStringBuilder.append(", minSelectNumForMix=");
    localStringBuilder.append(this.minSelectNumForMix);
    localStringBuilder.append(", maxSelectNumForMix=");
    localStringBuilder.append(this.maxSelectNumForMix);
    localStringBuilder.append(", canSwitchSelectionMode=");
    localStringBuilder.append(this.canSwitchSelectionMode);
    localStringBuilder.append(", initialHasPickedNum=");
    localStringBuilder.append(this.initialHasPickedNum);
    localStringBuilder.append(", canPickVideo=");
    localStringBuilder.append(this.canPickVideo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData
 * JD-Core Version:    0.7.0.1
 */