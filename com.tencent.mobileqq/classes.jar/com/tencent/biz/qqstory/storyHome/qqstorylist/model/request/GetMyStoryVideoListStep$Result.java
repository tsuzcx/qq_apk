package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class GetMyStoryVideoListStep$Result
{
  public int a = 0;
  public String b = "";
  public boolean c = false;
  public final ArrayList<String> d = new ArrayList();
  public final PBRepeatMessageField<qqstory_struct.UserVidList> e;
  public FeedFeatureItem f = new FeedFeatureItem();
  
  public GetMyStoryVideoListStep$Result()
  {
    this(0, null);
  }
  
  public GetMyStoryVideoListStep$Result(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
  {
    this.a = paramInt;
    this.e = paramPBRepeatMessageField;
  }
  
  public static Result a(String paramString)
  {
    Result localResult = new Result();
    localResult.b = paramString;
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result
 * JD-Core Version:    0.7.0.1
 */