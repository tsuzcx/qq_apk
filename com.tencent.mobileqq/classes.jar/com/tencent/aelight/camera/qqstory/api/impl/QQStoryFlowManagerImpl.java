package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class QQStoryFlowManagerImpl
  implements IQQStoryFlowManager
{
  public boolean isValidMedia(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return QQStoryFlowCallback.a(paramActivity, paramLocalMediaInfo);
  }
  
  public void startEditVideoActivity(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7, Bundle paramBundle)
  {
    QQStoryFlowCallback.a(paramActivity, paramString1, paramLocalMediaInfo, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramBoolean, paramInt6, paramInt7, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.QQStoryFlowManagerImpl
 * JD-Core Version:    0.7.0.1
 */