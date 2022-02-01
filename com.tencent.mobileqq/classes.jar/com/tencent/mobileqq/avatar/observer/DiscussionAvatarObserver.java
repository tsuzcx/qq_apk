package com.tencent.mobileqq.avatar.observer;

import android.util.Pair;
import com.tencent.mobileqq.app.BusinessObserver;

public class DiscussionAvatarObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    paramObject = (Pair)paramObject;
    onUpdateDiscussionFaceIcon(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
  }
  
  protected void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.observer.DiscussionAvatarObserver
 * JD-Core Version:    0.7.0.1
 */