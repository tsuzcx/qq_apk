package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public abstract interface IGroupPageLoader$CallBack
{
  public abstract void a(ErrorMessage paramErrorMessage, List<IDataProvider.GroupId> paramList, boolean paramBoolean);
  
  public abstract void b(ErrorMessage paramErrorMessage, List<IDataProvider.GroupInfo> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IGroupPageLoader.CallBack
 * JD-Core Version:    0.7.0.1
 */