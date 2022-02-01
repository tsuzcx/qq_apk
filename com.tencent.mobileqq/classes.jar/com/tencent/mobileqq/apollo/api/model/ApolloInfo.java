package com.tencent.mobileqq.apollo.api.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.TextUtils;

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
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public String toString()
  {
    if (this.mAction != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append("id: ").append(this.mAction.actionId).append(", name: ").append(this.mAction.actionName).append(", peerUin: ").append(this.mAction.peerUin).append(", peopleNum: ").append(this.mAction.personNum).append(", feeType: ").append(this.mAction.feeType).append(", inputText: ").append(this.mAction.inputText).append(",actionText: ").append(this.mActionText).append(",textType: ").append(this.mTextType).append("]");
      return localStringBuilder.toString();
    }
    return "ApolloActionData is null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloInfo
 * JD-Core Version:    0.7.0.1
 */