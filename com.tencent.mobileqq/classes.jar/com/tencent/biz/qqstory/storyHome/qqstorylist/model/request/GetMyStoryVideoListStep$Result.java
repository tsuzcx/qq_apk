package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class GetMyStoryVideoListStep$Result
{
  public int a;
  public FeedFeatureItem a;
  public final PBRepeatMessageField a;
  public String a;
  public final ArrayList a;
  public boolean a;
  
  public GetMyStoryVideoListStep$Result()
  {
    this(0, null);
  }
  
  public GetMyStoryVideoListStep$Result(int paramInt, PBRepeatMessageField paramPBRepeatMessageField)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem = new FeedFeatureItem();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
  }
  
  public static Result a(String paramString)
  {
    Result localResult = new Result();
    localResult.jdField_a_of_type_JavaLangString = paramString;
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result
 * JD-Core Version:    0.7.0.1
 */