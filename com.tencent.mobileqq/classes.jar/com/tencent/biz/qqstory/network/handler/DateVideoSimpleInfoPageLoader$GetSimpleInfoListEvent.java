package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.List;

public class DateVideoSimpleInfoPageLoader$GetSimpleInfoListEvent
  extends BasePageLoaderEvent
{
  public int e;
  public List<StoryVideoItem> f;
  
  public DateVideoSimpleInfoPageLoader$GetSimpleInfoListEvent(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateVideoSimpleInfoPageLoader.GetSimpleInfoListEvent
 * JD-Core Version:    0.7.0.1
 */