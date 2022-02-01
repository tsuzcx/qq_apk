package com.tencent.mobileqq.apollo.model;

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
    if (paramObject == null) {
      return false;
    }
    paramObject = (ApolloFavActionData)paramObject;
    int i = paramObject.audioId;
    if (i > 0)
    {
      if ((paramObject.acitonId == this.acitonId) && (i == this.audioId) && (paramObject.audioStartTime == this.audioStartTime) && (paramObject.playOriginalAudio == this.playOriginalAudio) && (this.text.equals(paramObject.text)) && (paramObject.textType == this.textType)) {
        return true;
      }
    }
    else if (!TextUtils.isEmpty(this.text))
    {
      if ((paramObject.acitonId == this.acitonId) && (this.text.equals(paramObject.text)) && (paramObject.textType == this.textType)) {
        return true;
      }
    }
    else if (paramObject.acitonId == this.acitonId) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:");
    localStringBuilder.append(this.acitonId);
    localStringBuilder.append(" text:");
    localStringBuilder.append(this.text);
    localStringBuilder.append(" textType:");
    localStringBuilder.append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloFavActionData
 * JD-Core Version:    0.7.0.1
 */