package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;

public class VideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo
{
  int jdField_a_of_type_Int;
  StoryVideoItem.InteractPasterLayout jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout;
  StoryVideoItem.PollLayout jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  String c;
  public String d;
  public String e;
  
  public VideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d = (QQStoryConstant.p + paramString1 + ".mp4");
    this.e = PlayModeUtils.a(paramString1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo
 * JD-Core Version:    0.7.0.1
 */