package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class NewFriendsPlayMode$SendVideoToFriendInfo
{
  public final int a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private String jdField_a_of_type_JavaLangString;
  public final int b;
  private String b;
  private int c = 0;
  
  public NewFriendsPlayMode$SendVideoToFriendInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a()
  {
    this.c = 0;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.c = 1;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.c != 0;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode.SendVideoToFriendInfo
 * JD-Core Version:    0.7.0.1
 */