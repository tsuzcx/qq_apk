package com.tencent.mobileqq.apollo.api.model;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloFavActionData
  extends Entity
{
  public int acitonId;
  public int audioId;
  public float audioStartTime = 0.0F;
  @unique
  public long favId;
  public int playOriginalAudio;
  public String text;
  public int textType;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramObject = (ApolloFavActionData)paramObject;
          if (paramObject.audioId <= 0) {
            break;
          }
        } while ((paramObject.acitonId != this.acitonId) || (paramObject.audioId != this.audioId) || (paramObject.audioStartTime != this.audioStartTime) || (paramObject.playOriginalAudio != this.playOriginalAudio) || (!this.text.equals(paramObject.text)) || (paramObject.textType != this.textType));
        return true;
        if (TextUtils.isEmpty(this.text)) {
          break;
        }
      } while ((paramObject.acitonId != this.acitonId) || (!this.text.equals(paramObject.text)) || (paramObject.textType != this.textType));
      return true;
    } while (paramObject.acitonId != this.acitonId);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:").append(this.acitonId).append(" text:").append(this.text).append(" textType:").append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloFavActionData
 * JD-Core Version:    0.7.0.1
 */