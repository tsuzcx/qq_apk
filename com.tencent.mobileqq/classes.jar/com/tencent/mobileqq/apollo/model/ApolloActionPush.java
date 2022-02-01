package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloActionPush
  extends Entity
{
  public int mActionId;
  public int mActionType;
  public int mAioType;
  public String mContent;
  @unique
  public long mId;
  public long mRcvUin;
  public long mSendUin;
  public long mSessionId;
  public int mWordShowType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloActionPush{mId=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(", mActionId=");
    localStringBuilder.append(this.mActionId);
    localStringBuilder.append(", mActionType=");
    localStringBuilder.append(this.mActionType);
    localStringBuilder.append(", mSendUin=");
    localStringBuilder.append(this.mSendUin);
    localStringBuilder.append(", mRcvUin=");
    localStringBuilder.append(this.mRcvUin);
    localStringBuilder.append(", mSessionId=");
    localStringBuilder.append(this.mSessionId);
    localStringBuilder.append(", mAioType=");
    localStringBuilder.append(this.mAioType);
    localStringBuilder.append(", mWordShowType=");
    localStringBuilder.append(this.mWordShowType);
    localStringBuilder.append(", mContent='");
    localStringBuilder.append(this.mContent);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloActionPush
 * JD-Core Version:    0.7.0.1
 */