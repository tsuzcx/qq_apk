package com.tencent.mobileqq.apollo.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.text.TextUtils;
import mqq.app.AppRuntime;

public class ApolloInfo
{
  public int drawableId;
  public int iconType;
  public ApolloActionData mAction;
  public String mActionText;
  public int mAudioId;
  public float mAudioStartTime;
  public int mBinderType;
  public int mPackageId;
  public int mPlayOriginalAudio;
  public int mSendSrc;
  public int mTextType;
  public int mType;
  public String mUin;
  
  public Drawable getPanelDrawable(Context paramContext, float paramFloat)
  {
    return TextUtils.getResourceDrawableThroughImageCache(paramContext.getResources(), this.drawableId);
  }
  
  public void send(AppRuntime paramAppRuntime, EditText paramEditText, int paramInt, String paramString1, String paramString2) {}
  
  public String toString()
  {
    if (this.mAction != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append("id: ");
      localStringBuilder.append(this.mAction.actionId);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(this.mAction.actionName);
      localStringBuilder.append(", peerUin: ");
      localStringBuilder.append(this.mAction.peerUin);
      localStringBuilder.append(", peopleNum: ");
      localStringBuilder.append(this.mAction.personNum);
      localStringBuilder.append(", feeType: ");
      localStringBuilder.append(this.mAction.feeType);
      localStringBuilder.append(", inputText: ");
      localStringBuilder.append(this.mAction.inputText);
      localStringBuilder.append(",actionText: ");
      localStringBuilder.append(this.mActionText);
      localStringBuilder.append(",textType: ");
      localStringBuilder.append(this.mTextType);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return "ApolloActionData is null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloInfo
 * JD-Core Version:    0.7.0.1
 */