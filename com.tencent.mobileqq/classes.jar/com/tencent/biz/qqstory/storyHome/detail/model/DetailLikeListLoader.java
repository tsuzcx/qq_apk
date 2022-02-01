package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;

public class DetailLikeListLoader
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public DetailLikeListLoader(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public DetailLikeListLoader(String paramString, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0));
  }
  
  public void a(boolean paramBoolean)
  {
    DetailLikeListLoader.GetLikeListRequest localGetLikeListRequest = new DetailLikeListLoader.GetLikeListRequest();
    localGetLikeListRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localGetLikeListRequest.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int != -1) {
      localGetLikeListRequest.c = this.jdField_a_of_type_Int;
    }
    CmdTaskManger.a().a(localGetLikeListRequest, new DetailLikeListLoader.2(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader
 * JD-Core Version:    0.7.0.1
 */