package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import java.util.HashMap;

public class AELaunchEditPicImpl
  implements IAELaunchEditPic
{
  public Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt);
  }
  
  public Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, paramInt3);
  }
  
  public Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  public Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap<String, Object> paramHashMap)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, paramInt3, paramHashMap);
  }
  
  public Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramBoolean8, paramInt1, paramInt2, paramInt3, paramBoolean9, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.AELaunchEditPicImpl
 * JD-Core Version:    0.7.0.1
 */