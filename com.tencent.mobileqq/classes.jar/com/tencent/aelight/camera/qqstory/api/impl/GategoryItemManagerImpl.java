package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.qqstory.api.IGategoryItemManager;

public class GategoryItemManagerImpl
  implements IGategoryItemManager
{
  public String getItemName(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QIMFilterCategoryItem))) {
      return ((QIMFilterCategoryItem)paramObject).b;
    }
    return null;
  }
  
  public String getJumApp(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QIMFilterCategoryItem))) {
      return ((QIMFilterCategoryItem)paramObject).h;
    }
    return null;
  }
  
  public boolean isCombo(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QIMFilterCategoryItem))) {
      return ((QIMFilterCategoryItem)paramObject).a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.GategoryItemManagerImpl
 * JD-Core Version:    0.7.0.1
 */